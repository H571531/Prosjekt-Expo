package no.hvl.dat109.expo.utils;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.qrcode.QRCodeWriter;

import java.awt.image.BufferedImage;
import java.util.Optional;

/**
 * @author
 *
 */
public class QRUtils {

	/**
	 * Lager en ny QR-kode
	 * @param String link linken som skal bli QR-kode
	 * @param Integer width bredde paa bildet til QR-koden
	 * @param Integer height hoyde paa bildet til QR-koden
	 * @return
	 */
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
