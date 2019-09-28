package utils;

import Lib.Repository;
import Lib.RepositoryManager;
import Lib.User;
import com.sun.deploy.net.HttpRequest;
import constants.Constants;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

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
    public static RepositoryManager getRepoistoryManager(HttpServletRequest request){
        HttpSession session=request.getSession(false);
        if(session==null){
            return null;
        }
        else{
            if(session.getAttribute(Constants.RERPOSITORYMANAGER)==null){
                session.setAttribute(Constants.RERPOSITORYMANAGER,new RepositoryManager());
                ((RepositoryManager)session.getAttribute(Constants.RERPOSITORYMANAGER)).ChangeUser(new User(session.getAttribute(Constants.USERNAME).toString()));

            }
            return (RepositoryManager)session.getAttribute(Constants.RERPOSITORYMANAGER);
        }
    }
    public static List<Repository> getAllRepositoryList(HttpServletRequest request){
        HttpSession session=request.getSession(false);
        if(session==null){
            return null;
        }
        if(session.getAttribute(Constants.REPOSITORIESSLIST)==null){
            return null;
        }
        else{
            return (List<Repository>)session.getAttribute(Constants.REPOSITORIESSLIST);
        }
    }
}
