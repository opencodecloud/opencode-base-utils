package cloud.opencode.base.util;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.DecimalFormat;

/**
 * @author Jon So,
 * e-mail: ijonso123@gmail.com
 * url: <a href="https://jon.wiki">Jon's blog</a>
 * url: <a href="https://github.com/opencodecloud">project github</a>
 * @version v1.0.0
 */
public final class CodeMoneyUtils {

    private static final String[] CN_NUMBER = {"零", "壹", "贰", "叁", "肆", "伍", "陆", "柒", "捌", "玖"};
    private static final String[] CN_NUMBER_UNIT = {"分", "角", "元", "拾", "佰", "仟", "万", "拾", "佰", "仟", "亿",
            "拾", "佰", "仟", "兆", "拾", "佰", "仟"};
    private static final String CN_FULL = "整";
    private static final String CN_NEGATIVE = "负";
    private static final int MONEY_PRECISION = 2;
    private static final int TEN = 10;
    private static final String CN_ZERO_YUAN = "零元" + CN_FULL;

    private CodeMoneyUtils(){}

    /**
     * china: fen to yuan
     *
     * @param fen fen
     * @return BigDecimal
     */
    public static BigDecimal getFen2Yuan(Integer fen) {
        BigDecimal d = new BigDecimal(fen).divide(new BigDecimal(100));
        return d;
    }

    /**
     * china: get yuan string
     *
     * @param number BigDecimal
     * @return String
     */
    private static String getYuan(BigDecimal number) {
        DecimalFormat df = new DecimalFormat("0.00");
        df.setRoundingMode(RoundingMode.HALF_UP);
        return df.format(number);
    }

    /**
     * china: fen to yuan
     *
     * @param fen Integer
     * @return String
     */
    public static String getFen2YuanString(Integer fen) {
        return getYuan(getFen2Yuan(fen));
    }

    /**
     * get rounded china yuan notation
     *
     * @param yuan BigDecimal yuan
     * @return china yuan
     */
    public static String convert2CnMoney(BigDecimal yuan) {
        StringBuilder sb = new StringBuilder();
        int signal = yuan.signum();
        if (signal == 0) {
            return CN_ZERO_YUAN;
        }
        long number = yuan.movePointRight(MONEY_PRECISION)
                .setScale(0, RoundingMode.HALF_UP).abs().longValue();
        long scale = number % 100;
        int numUnit = 0;
        int numIndex = 0;
        boolean getZero = false;
        if (scale <= 0) {
            numIndex = 2;
            number = number / 100;
            getZero = true;
        }
        if ((scale > 0) && (scale % TEN <= 0)) {
            numIndex = 1;
            number = number / 10;
            getZero = true;
        }
        int zeroSize = 0;
        while (number > 0) {

            numUnit = (int) (number % 10);
            if (numUnit > 0) {
                if ((numIndex == 9) && (zeroSize >= 3)) {
                    sb.insert(0, CN_NUMBER_UNIT[6]);
                }
                if ((numIndex == 13) && (zeroSize >= 3)) {
                    sb.insert(0, CN_NUMBER_UNIT[10]);
                }
                sb.insert(0, CN_NUMBER_UNIT[numIndex]);
                sb.insert(0, CN_NUMBER[numUnit]);
                getZero = false;
                zeroSize = 0;
            } else {
                ++zeroSize;
                if (!(getZero)) {
                    sb.insert(0, CN_NUMBER[numUnit]);
                }
                if (numIndex == 2) {
                    if (number > 0) {
                        sb.insert(0, CN_NUMBER_UNIT[numIndex]);
                    }
                } else if (((numIndex - 2) % 4 == 0) && (number % 1000 > 0)) {
                    sb.insert(0, CN_NUMBER_UNIT[numIndex]);
                }
                getZero = true;
            }
            number = number / 10;
            ++numIndex;
        }
        if (signal == -1) {
            sb.insert(0, CN_NEGATIVE);
        }
        if (scale <= 0) {
            sb.append(CN_FULL);
        }
        return sb.toString();
    }
}
