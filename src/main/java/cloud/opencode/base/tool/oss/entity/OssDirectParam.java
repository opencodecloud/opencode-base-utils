package cloud.opencode.base.tool.oss.entity;

import lombok.Data;
import lombok.experimental.Accessors;

/**
 * @author Jon So,
 * e-mail: ijonso123@gmail.com
 * url: <a href="https://jon.wiki">Jon's blog</a>
 * url: <a href="https://github.com/opencodecloud">project github</a>
 * @version v1.0.0
 */
@Data
@Accessors(chain = true)
public class OssDirectParam extends OssBaseParam {
    private String bucketName;
    private String domain;
}
