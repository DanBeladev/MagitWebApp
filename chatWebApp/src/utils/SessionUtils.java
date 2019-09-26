package utils;

import com.sun.deploy.net.HttpRequest;
import constants.Constants;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

public class SessionUtils {
    public static String getUserName(HttpServletRequest request){
        HttpSession session=request.getSession(false);
        if(session==null){
            return null;
        }
        else{
            return session.getAttribute(Constants.USERNAME).toString();
        }

    }
}
