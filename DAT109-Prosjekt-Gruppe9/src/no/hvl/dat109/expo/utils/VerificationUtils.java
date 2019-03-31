package no.hvl.dat109.expo.utils;


import no.hvl.dat109.expo.eao.StandEAO;
import no.hvl.dat109.expo.eao.VisitorEAO;
import no.hvl.dat109.expo.entities.Expo;
import no.hvl.dat109.expo.entities.Stand;
import no.hvl.dat109.expo.entities.Visitor;
import no.hvl.dat109.expo.sms.MessageBird;
import no.hvl.dat109.expo.sms.SMSInterface;
import no.hvl.dat109.expo.sms.SMSMock;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import java.security.SecureRandom;
import java.util.Base64;
import java.util.Optional;

public class VerificationUtils {


    public static Boolean login(Visitor visitor, String token, HttpServletRequest request){
        HttpSession session = SessionUtils.getSession(request).get();
        if(visitor.getVisitorToken().equals(token)){
            session.setAttribute("visitor",visitor);
            return true;
        }else{
            return false;
        }

    }

    public static Optional<Visitor> getVisitor(HttpServletRequest request){
        return SessionUtils.getSessionParameter(request,"visitor");
    }

    public static String createVisitor(String id, VisitorEAO visitorEAO,String API_KEY, Expo expo, HttpServletRequest request){
        String token = generateSafeToken();
        Visitor visitor = new Visitor(id,token);
        visitorEAO.addVisitor(visitor);
        
        
        SMSInterface sms;
        String URL = getValidationLink(visitor, request);
        String message = URL;
		message = "Hei! Vennligst klikk linken: " + URL;
        
        if(expo.isVerificationRequired()) {
        	sms = new MessageBird(API_KEY);
            sms.sendSMS(Long.parseLong(id),message);
        } else {
        	sms = new SMSMock();
        	sms.sendSMS(Long.parseLong(id), URL);
        }
        return URL;
    }

    public static String getValidationLink(Visitor visitor, HttpServletRequest request){
    	String protocol = (request.isSecure()) ? "https" : "http";
        String hosturl = request.getServerName() + ":" + request.getServerPort();
        return protocol + "://" + hosturl + request.getContextPath() +  "/VerificationServlet?id=" + visitor.getVisitorId() + "&token=" + visitor.getVisitorToken();
    }

    public static String generateSafeToken() {
        SecureRandom random = new SecureRandom();
        byte bytes[] = new byte[10];
        random.nextBytes(bytes);
        Base64.Encoder encoder = Base64.getUrlEncoder().withoutPadding();
        String token = encoder.encodeToString(bytes);
        return token;
    }

	public static Stand createStand(HttpServletRequest request, String newStandId, Expo expo, StandEAO standEAO) {
		String token = generateSafeToken();
		Stand stand = new Stand(newStandId, "---", expo, token);
		standEAO.addStand(stand);
		return stand;
	}
	
	public static String getValidationLink(Stand stand, HttpServletRequest request) {
		String protocol = (request.isSecure()) ? "https" : "http";
        String hosturl = request.getServerName() + ":" + request.getServerPort();
        return protocol + "://" + hosturl + request.getContextPath() +  "/AdminEditStandServlet?editStandId=" + stand.getStandId() + "&editStandToken=" + stand.getToken();
	}

	public static boolean editLinkIsValid(String editStandId, String editStandToken, StandEAO standEAO, HttpServletRequest request) {
		Stand stand = standEAO.findStand(editStandId);
		boolean isValid = false;
		
		if(stand != null && stand.getToken().equals(editStandToken)) {
			request.setAttribute("stand", stand);
			isValid = true;
		}
		
		return isValid;  
		
	}
	
	

}
