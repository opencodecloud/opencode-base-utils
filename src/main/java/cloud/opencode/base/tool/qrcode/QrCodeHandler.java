package cloud.opencode.base.tool.qrcode;

import cloud.opencode.base.tool.qrcode.entity.QrConfig;
import com.google.zxing.*;
import com.google.zxing.client.j2se.BufferedImageLuminanceSource;
import com.google.zxing.client.j2se.MatrixToImageConfig;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.common.HybridBinarizer;
import org.apache.commons.lang3.StringUtils;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.io.OutputStream;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.Map;
/**
 * @author Jon So,
 * e-mail: ijonso123@gmail.com
 * url: <a href="https://jon.wiki">Jon's blog</a>
 * url: <a href="https://github.com/opencodecloud">project github</a>
 * @version v1.0.0
 */
public class QrCodeHandler {

    /**
     * Create a QR code and save it to the specified path
     *
     * @param codeText QR code text
     * @param savePath Save path
     * @throws WriterException
     * @throws IOException
     */
    public static String createQrCode2File(String codeText, String savePath, QrConfig config) throws WriterException, IOException {
        codeText = checkCodeText(codeText);
        File codeImgFile = getFile(savePath);
        ImageIO.write(encodeQrCode(codeText, config), "png", codeImgFile);
        return codeImgFile.getPath();
    }

    /**
     * Create QR code and write to stream
     *
     * @param codeText     QR code text
     * @param outputStream stream
     * @throws WriterException
     * @throws IOException
     */
    public static void createQrCode2Stream(String codeText, OutputStream outputStream, QrConfig config) throws WriterException, IOException {
        ImageIO.write(encodeQrCode(codeText, config), "png", outputStream);
    }

    /**
     * Scan qrcode file and return text
     *
     * @param qrCodePath qrcode file path
     * @return qrcode text
     */
    public static String decodeQrCode2Txt(String qrCodePath) {
        BufferedImage image;
        String qrCodeText = null;
        try {
            image = ImageIO.read(new File(qrCodePath));
            LuminanceSource source = new BufferedImageLuminanceSource(image);
            Binarizer binarizer = new HybridBinarizer(source);
            BinaryBitmap binaryBitmap = new BinaryBitmap(binarizer);
            Map<DecodeHintType, Object> hints = new HashMap<DecodeHintType, Object>();
            hints.put(DecodeHintType.CHARACTER_SET, "UTF-8");
            Result result = new MultiFormatReader().decode(binaryBitmap, hints);
            qrCodeText = result.getText();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (NotFoundException e) {
            e.printStackTrace();
        }
        return qrCodeText;
    }

    /**
     * Get qrcode file
     *
     * @param filePath
     * @return File
     */
    private static File getFile(String filePath) {
        File file = new File(filePath);
        String savePath = "";
        String saveName = "";
        if (file.isDirectory()) {
            saveName = System.currentTimeMillis() + ".png";
            savePath = filePath;
        } else {
            filePath = StringUtils.substringBeforeLast(filePath, "/");
            saveName = StringUtils.substringAfterLast(filePath, "/");
            if (!StringUtils.substringAfterLast(saveName, ".").equals("png")) {
                saveName = saveName + ".png";
            }
        }
        File codeImgFile = new File(savePath, saveName);
        return codeImgFile;
    }


    /**
     * Check QR code text
     *
     * @param codeText
     * @return String
     */
    private static String checkCodeText(String codeText) {
        if (codeText == null || "".equals(codeText.trim())) {
            codeText = "Create by AbaseCode.com QRCode utils.";
        }
        return codeText.trim();
    }

    /**
     * Encode text to BufferedImage
     *
     * @param codeText
     * @return BufferedImage
     */
    private static BufferedImage encodeQrCode(String codeText, QrConfig config) {
        MatrixToImageConfig imageConfig = new MatrixToImageConfig(config.getColorFront(), config.getColorBackground());
        BufferedImage qrCode = null;
        try {
            Hashtable hints = new Hashtable();
            hints.put(EncodeHintType.CHARACTER_SET, "utf-8");
            BitMatrix bitMatrix = new MultiFormatWriter().encode(codeText, BarcodeFormat.QR_CODE, config.getCodeLength(), config.getCodeLength(), hints);
            qrCode = MatrixToImageWriter.toBufferedImage(bitMatrix, imageConfig);
        } catch (WriterException ex) {
        }
        return qrCode;
    }

}