package no.hvl.dat109.Expo.Utils;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.WriterException;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.qrcode.QRCodeWriter;

import javax.imageio.ImageIO;
import javax.swing.text.html.Option;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.util.Optional;


public class QRUtils {

    public static Optional<BufferedImage> generateQR(String link, Integer width, Integer height){
        QRCodeWriter writer = new QRCodeWriter();
        try{
            BitMatrix bitMatrix = writer.encode(link, BarcodeFormat.QR_CODE,width,height);
            BufferedImage image = MatrixToImageWriter.toBufferedImage(bitMatrix);
            return Optional.of(image);
        }catch (Exception e){
            // Jeg vil beholde printStackTrace slik at feil ikke blir usynlige.
            e.printStackTrace();
            return Optional.empty();
        }

    }

}
