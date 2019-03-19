package no.hvl.dat109.expo.utils;

import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpServletRequest;
import java.util.Optional;
public class SessionUtils {
    /**
     * Get session optional.
     *
     * @param request the request
     * @return the optional
     */
    static public Optional<HttpSession> getSession(HttpServletRequest request){
        HttpSession session = request.getSession(false);
        return (session == null) ? Optional.empty() : Optional.of(session);
    }

    /**
     * Get session parameter optional.
     *
     * @param <T>       the type parameter
     * @param request   the request
     * @param attribute the attribute
     * @return the optional
     */
    static public <T> Optional<T> getSessionParameter(HttpServletRequest request,String attribute){
        HttpSession session = request.getSession(false);
        Object object = (session != null) ? session.getAttribute(attribute) : null;
        return (object != null) ? Optional.of((T) object) : Optional.empty();
    }

    /**
     * Session contains boolean.
     *
     * @param request   the request
     * @param attribute the attribute
     * @return the boolean
     */
    static public Boolean sessionContains(HttpServletRequest request,String attribute){
        HttpSession session = request.getSession(false);
        return session != null && session.getAttribute(attribute) != null;
    }
}
