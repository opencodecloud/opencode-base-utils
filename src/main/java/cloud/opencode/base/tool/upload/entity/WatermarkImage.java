package cloud.opencode.base.tool.upload.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

/**
 * @author Jon So,
 * e-mail: ijonso123@gmail.com
 * url: <a href="https://jon.wiki">Jon's blog</a>
 * url: <a href="https://github.com/opencodecloud">project github</a>
 * @version v1.0.0
 */
@Getter
@Setter
@AllArgsConstructor
@Accessors(chain = true)
public class WatermarkImage {
    private static final int DEFAULT_MARGIN_X = 20;
    private static final int DEFAULT_MARGIN_Y = 20;
    private static final WatermarkPosition DEFAULT_POSITION = WatermarkPosition.TOP_LEFT;
    private static final String DEFAULT_URL = "";
    private static final float DEFAULT_ALPHA = 1F;
    /**
     * Watermark margin X
     */
    private Integer marginX;
    /**
     * Watermark margin Y
     */
    private Integer marginY;
    /**
     * Watermark position
     */
    private WatermarkPosition position;
    /**
     * Watermark url
     */
    private String waterUrl;
    /**
     * Watermark alpha
     */
    private float waterAlpha = 1f;

    public WatermarkImage() {
        this.marginX = DEFAULT_MARGIN_X;
        this.marginY = DEFAULT_MARGIN_Y;
        this.position = DEFAULT_POSITION;
        this.waterUrl = DEFAULT_URL;
        this.waterAlpha = DEFAULT_ALPHA;
    }
}