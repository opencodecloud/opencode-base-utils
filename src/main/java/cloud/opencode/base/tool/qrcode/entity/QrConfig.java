package cloud.opencode.base.tool.qrcode.entity;

/**
 * @author Jon So,
 * e-mail: ijonso123@gmail.com
 * url: <a href="https://jon.wiki">Jon's blog</a>
 * url: <a href="https://github.com/opencodecloud">project github</a>
 * @version v1.0.0
 */
public final class QrConfig {
    private static final int CODE_LENGTH_DEFAULT = 300;
    private static final int CODE_LENGTH_MIN = 80;
    private static final int COLOR_FRONT = 0xFF000000;
    private static final int COLOR_BACKGROUND = 0xFFFFFFFF;

    private int codeLength;
    private int colorFront;
    private int colorBackground;

    public QrConfig() {
        this(CODE_LENGTH_DEFAULT, COLOR_FRONT, COLOR_BACKGROUND);
    }

    public QrConfig(int length, int colorFront, int colorBackground) {
        if (length <= CODE_LENGTH_MIN) {
            length = CODE_LENGTH_DEFAULT;
        }
        this.codeLength = length;
        this.colorFront = colorFront;
        this.colorBackground = colorBackground;
    }

    public int getCodeLength() {
        return this.codeLength;
    }

    public int getColorFront() {
        return this.colorFront;
    }

    public int getColorBackground() {
        return this.colorBackground;
    }
}