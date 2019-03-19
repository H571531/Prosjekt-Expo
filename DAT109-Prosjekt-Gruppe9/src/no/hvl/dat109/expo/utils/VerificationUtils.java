package no.hvl.dat109.expo.utils;


import no.hvl.dat109.expo.eao.VisitorEAO;
import no.hvl.dat109.expo.entities.Visitor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.security.SecureRandom;
import java.util.Base64;
import java.util.Optional;

public class VerificationUtils {


    public void login(Visitor visitor, String token, HttpServletRequest request){
        HttpSession session = SessionUtils.getSession(request).get();
        if(visitor.getVisitorToken().equals(token)){
            session.setAttribute("visitor",visitor);
        }
    }

    public Optional<Visitor> getVisitor(HttpServletRequest request){
        return SessionUtils.getSessionParameter(request,"visitor");
    }

    public void createVisitor(String id, VisitorEAO visitorEAO){
        String token = generateSafeToken();
        Visitor visitor = new Visitor(id,token);
        visitorEAO.addVisitor(visitor);
    }

    private String generateSafeToken() {
        SecureRandom random = new SecureRandom();
        byte bytes[] = new byte[10];
        random.nextBytes(bytes);
        Base64.Encoder encoder = Base64.getUrlEncoder().withoutPadding();
        String token = encoder.encodeToString(bytes);
        return token;
    }

}
