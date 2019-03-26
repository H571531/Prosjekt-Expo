package no.hvl.dat109.expo.utils.test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import no.hvl.dat109.expo.utils.PasswordUtil;

public class PasswordUtilsTest {

	private String unSaltedPassword;
	private String unSaltedPassword2;
	private String saltedPassword;
	private String saltedPassword2;

	@Test
	public void krypterPassordTest() {
		unSaltedPassword = "Password123";
		saltedPassword = PasswordUtil.krypterPassord(unSaltedPassword);

		assertFalse(unSaltedPassword.equals(saltedPassword));
	}

	@Test
	public void krypterPassordNullTest() {
		unSaltedPassword = "";
		saltedPassword = PasswordUtil.krypterPassord(unSaltedPassword);

		assertNotNull(saltedPassword);
		assertFalse(unSaltedPassword.equals(saltedPassword));
	}

	@Test
	public void saltingTest() {
		unSaltedPassword = "Unsalted";
		unSaltedPassword2 = unSaltedPassword;

		saltedPassword = PasswordUtil.krypterPassord(unSaltedPassword);
		saltedPassword2 = PasswordUtil.krypterPassord(unSaltedPassword2);

		assertFalse(saltedPassword.equals(saltedPassword2));

	}

	@Test
	public void saltingNullTest() {
		unSaltedPassword = "";
		unSaltedPassword2 = unSaltedPassword;

		saltedPassword = PasswordUtil.krypterPassord(unSaltedPassword);
		saltedPassword2 = PasswordUtil.krypterPassord(unSaltedPassword2);

		assertFalse(saltedPassword.equals(saltedPassword2));

	}

	@Test
	public void sjekkPassordTest() {
		unSaltedPassword = "unsalted";
		saltedPassword = PasswordUtil.krypterPassord(unSaltedPassword);

		assertTrue(PasswordUtil.sjekkPassord(unSaltedPassword, saltedPassword));

	}

	@Test
	public void sjekkPassordNullTest() {
		unSaltedPassword = "";
		saltedPassword = PasswordUtil.krypterPassord(unSaltedPassword);

		assertNotNull(saltedPassword);
		assertTrue(PasswordUtil.sjekkPassord(unSaltedPassword, saltedPassword));

	}

}
