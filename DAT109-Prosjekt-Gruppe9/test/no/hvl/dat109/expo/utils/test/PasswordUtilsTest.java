package no.hvl.dat109.expo.utils.test;

import static org.junit.Assert.*;

import org.junit.Test;

import no.hvl.dat109.expo.utils.PasswordUtil;

public class PasswordUtilsTest {
	
	@Test
	public void krypterPassordTest() {
		String unSaltedPassword = "Password123";
		String saltedPassword = PasswordUtil.krypterPassord(unSaltedPassword);
		
		assertFalse(unSaltedPassword.equals(saltedPassword));
	}
	
	@Test
	public void krypterPassordNullTest() {
		String unSaltedPassword = "";
		String saltedPassword = PasswordUtil.krypterPassord(unSaltedPassword);
		
		assertNotNull(saltedPassword);
		assertFalse(unSaltedPassword.equals(saltedPassword));
	}
	
	
	@Test
	public void saltingTest() {
		String unSalted1 = "Unsalted";
		String unSalted2 = unSalted1;
		
		unSalted1 = PasswordUtil.krypterPassord(unSalted1);
		unSalted2 = PasswordUtil.krypterPassord(unSalted2);
		
		assertFalse(unSalted1.equals(unSalted2));
		
	}
	
	@Test
	public void saltingNullTest() {
		String unSalted1 = "";
		String unSalted2 = unSalted1;
		
		unSalted1 = PasswordUtil.krypterPassord(unSalted1);
		unSalted2 = PasswordUtil.krypterPassord(unSalted2);
		
		assertFalse(unSalted1.equals(unSalted2));
		
	}
	
	@Test
	public void sjekkPassordTest() {
		String unSalted = "unsalted";
		String salted = PasswordUtil.krypterPassord(unSalted);
		
		assertTrue(PasswordUtil.sjekkPassord(unSalted, salted));
		
	}
	
	@Test
	public void sjekkPassordNullTest() {
		String unSalted = "";
		String salted = PasswordUtil.krypterPassord(unSalted);
		
		assertNotNull(salted);
		assertTrue(PasswordUtil.sjekkPassord(unSalted, salted));
		
	}
	
	@Test
	public void test() {
		
	}

}
