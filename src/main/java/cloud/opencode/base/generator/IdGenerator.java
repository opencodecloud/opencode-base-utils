package cloud.opencode.base.generator;

import org.joda.time.LocalDate;

import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.time.format.DateTimeFormatter;

/**
 * @author Jon So,
 * e-mail: ijonso123@gmail.com
 * url: <a href="https://jon.wiki">Jon's blog</a>
 * url: <a href="https://github.com/opencodecloud">project github</a>
 * @version v1.0.0
 */
public final class IdGenerator {

    private final static int CODE_LENGTH = 14;
    private final static long APP_BIT = 4L;
    private final static long MACHINE_BIT = 4L;
    private final static long SEQUENCE_BIT = 12L;

    private final static long MAX_SEQUENCE = -1L ^ (-1L << SEQUENCE_BIT);
    private final static long MAX_MACHINE_NUM = -1L ^ (-1L << MACHINE_BIT);
    private final static long MAX_APP_NUM = -1L ^ (-1L << APP_BIT);

    private final static long MACHINE_LEFT = SEQUENCE_BIT;
    private final static long APP_LEFT = SEQUENCE_BIT + MACHINE_BIT;
    private final static long TIME_LEFT = APP_LEFT + APP_BIT;

    private final static String DATE_STRING = LocalDate.now().toString();
    private final static DateTimeFormatter DF = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
    private final static long START_TIMESTAMP = LocalDateTime.parse(DATE_STRING + " 00:00:00", DF)
            .toInstant(ZoneOffset.of("+8")).toEpochMilli();

    private long appId;
    private long machineId;
    private long sequence = 0L;
    private long lastTimeStamp = -1L;
    private String appIdChar;
    private String machineChar;

    private IdGenerator(){}

    /**
     * The parameters are required
     *
     * @param appId     Microservice Code,takes values in the range 0-15
     * @param machineId Machine code,takes values in the range 0-15
     */
    public IdGenerator(long appId, long machineId) {
        if (appId > MAX_APP_NUM || appId < 0) {
            throw new IllegalArgumentException("AppId can't be greater than 15 or less than 0！");
        }
        if (machineId > MAX_MACHINE_NUM || machineId < 0) {
            throw new IllegalArgumentException("MachineId can't be greater than 15 or less than 0！");
        }
        this.appId = appId;
        this.machineId = machineId;
        appIdChar = Long.toString(appId, 16).toUpperCase();
        machineChar = Long.toString(machineId, 16).toUpperCase();
    }

    /**
     * Get millis
     *
     * @return millis
     */
    private long getNext() {
        long mill = getNew();
        while (mill <= lastTimeStamp) {
            mill = getNew();
        }
        return mill;
    }

    /**
     * Get millis
     *
     * @return millis
     */
    private long getNew() {
        return System.currentTimeMillis();
    }

    /**
     * Generate ID
     *
     * @return 24bit ID
     */
    public synchronized String genId() {
        long currTimeStamp = getNew();
        if (currTimeStamp < lastTimeStamp) {
            throw new RuntimeException("Clock moved backwards.  Refusing to generate id");
        }

        if (currTimeStamp == lastTimeStamp) {
            sequence = (sequence + 1) & MAX_SEQUENCE;
            if (sequence == 0L) {
                currTimeStamp = getNext();
            }
        } else {
            sequence = 0L;
        }

        lastTimeStamp = currTimeStamp;
        Long result = (currTimeStamp - START_TIMESTAMP) << TIME_LEFT
                | appId << APP_LEFT
                | machineId << MACHINE_LEFT
                | sequence;
        return DATE_STRING.replace("-", "") + appIdChar + machineChar + cast(result.toString());
    }

    /**
     * Converts to a length-compliant string
     *
     * @param StringNumber
     * @return 14bit string
     */
    private String cast(String StringNumber) {
        int len1 = StringNumber.length();
        if (len1 < CODE_LENGTH) {
            return getZero(CODE_LENGTH - len1) + StringNumber;
        }
        return StringNumber;
    }

    /**
     * Left-aligned zero complement
     *
     * @param x Number of replenishments required
     * @return 14bit string
     */
    private String getZero(int x) {
        if (x <= 0) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < x; i++) {
            sb.append(0);
        }
        return sb.toString();
    }
}
