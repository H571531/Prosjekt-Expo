package no.hvl.dat109.expo.utils.test;

import java.awt.image.BufferedImage;
import java.util.Optional;

import static no.hvl.dat109.expo.utils.QRUtils.generateQR;

import org.junit.Test;

public class QRUtilsTest {
	
	private Integer width = 200;
	private Integer heigth = 200;
	private String link;
	
	/*
	 * Tester om qr blir generert.
	 */
	@Test
	public void generateQRTest() {
		link = "https://hvl.no/";
		Optional<BufferedImage> qr = generateQR(link, width, heigth);
		
		qr.isPresent();
	}

}
