package no.hvl.dat109.expo.utils;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import no.hvl.dat109.expo.eao.AdminEAO;
import no.hvl.dat109.expo.entities.Admin;

public class LoginUtils {
	/**
	 * Klasse for  bestemme overskrift p inlogging
	 * 
	 * @param request fra servlet
	 * @return feilmelding/overskrift i inloggingskjerm
	 */
	public static String loginHeader(HttpServletRequest request) {
		// TODO Auto-generated method stub
		
		String pwError = "";
		
		String wrongPassword = request.getParameter("wrongPassword");
		
		if(wrongPassword != null){
			//Hvis bruker ble redirected tilbake på grunn av feil passord
			pwError = "Feil brukernavn eller passord";
		}
		
		String loginRequired = request.getParameter("loginRequired");
		if(loginRequired != null) {
			//Hvis ble redirected tilbake på grunn av session timeout
			pwError = "Du må være logget inn for å se denne siden.";
		}
		
		return pwError;
	}
/**
 * 
 * 
 * @param request fra servlet
 * @param admin som skal sjekkes om er logget inn
 * @return bolsk verdi om den er logget inn
 */
	public static boolean loginOk(HttpServletRequest request, Admin admin) {
		if(admin == null) {
			return false;
		}
		
		
		//Funnet en eksisterende bruker => sjekk passord
		String givenPw = request.getParameter("password");
		if(givenPw == null) {
			return false;
		}
		
		return PasswordUtil.sjekkPassord(givenPw, admin.getHashedPassword());
		
	}
	/**
	 * Sjekker om brukeren er logget inn
	 * 
	 * @param request fra servlet
	 * @return sjekker om bruker er logget inn
	 */
	public static boolean isLoggedIn(HttpServletRequest request) {
		
		HttpSession session = request.getSession(false);
		
		return !(session == null || session.getAttribute("Username") == null);
		
	}
	/**
	 * Metode som logger bruker inn. 
	 * 
	 * @param request fra servlet
	 * @param adminEAO for å finne admin som skal logges in. 
	 * @param timeout for sesjon invalidation
	 * @return
	 */
	public static boolean login(HttpServletRequest request , int timeout, AdminEAO adminEAO){
		String username = request.getParameter("Username");
		Admin user = adminEAO.findAdmin(username);
		
		if(!LoginUtils.loginOk(request, user)) {
			return false;
		} else {
			//Forsøk å hente session - hvis den ikke finnes, ikke opprett ny
			sessionStart(request, user, timeout);
			
			return true;
		}
	}

	/**
	 * Metode for å starte en sesjon med deltaker
	 * 
	 * @param request fra servlet
	 * @param admin som skal logges inn
	 * @param timeout for invalidation av sesjon
	 */
	public static void sessionStart(HttpServletRequest request, Admin admin, int timeout) {
		HttpSession sesjon = request.getSession(false);
		if(sesjon != null) {
			//hvis session finnes, invalider session
			sesjon.invalidate();
		}
		
		//Opprett ny session
		sesjon = request.getSession(true);
		//"logg ut" etter antall sekunder gitt i web.xml
		sesjon.setMaxInactiveInterval(timeout);
		//Send videre mobilnummer
		sesjon.setAttribute("Username", admin.getUsername());
	}
	
	public static void logOut(HttpServletRequest request) {
		HttpSession session = request.getSession(false);
		if(session != null) {
			session.removeAttribute("Username");
			session.invalidate();
		}
	}
}
