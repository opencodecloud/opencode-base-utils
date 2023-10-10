package cloud.opencode.base.tool.upload.entity;

import lombok.Getter;

/**
 * @author Jon So,
 * e-mail: ijonso123@gmail.com
 * url: <a href="https://jon.wiki">Jon's blog</a>
 * url: <a href="https://github.com/opencodecloud">project github</a>
 * @version v1.0.0
 */
@Getter
public enum UploadFileType {
    /**
     * File type
     */
    FILE(1, "File"),
    /**
     * JPG,PNG
     */
    IMAGE(2, "JPG,PNG");
    private Integer typeCode;
    private String typeName;

    UploadFileType(Integer typeCode, String typeName) {
        this.typeCode = typeCode;
        this.typeName = typeName;
    }
}