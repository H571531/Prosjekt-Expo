package no.hvl.dat109.expo.utils;


import no.hvl.dat109.expo.eao.VisitorEAO;
import no.hvl.dat109.expo.entities.Expo;
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
        
        if(expo.isVerificationRequired()) {
        	System.out.println("SENDER SMS");
        	//sms = new MessageBird(API_KEY);
            //sms.sendSMS(Long.parseLong(id),URL);
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

    private static String generateSafeToken() {
        SecureRandom random = new SecureRandom();
        byte bytes[] = new byte[10];
        random.nextBytes(bytes);
        Base64.Encoder encoder = Base64.getUrlEncoder().withoutPadding();
        String token = encoder.encodeToString(bytes);
        return token;
    }

}
