package servlets;


import Lib.User;
import Lib.UserManager;
import constants.Constants;
import utils.ServletUtils;
import utils.SessionUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
public class LoginServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("in do get");
        response.setContentType("text/html;charset=UTF-8");
        String userName=SessionUtils.getUserName(request);
        if(userName==null){
            String userNameFromRequest=request.getParameter("userName");
            UserManager userManager=ServletUtils.getUserManaqer(getServletContext());
            User user = new User(userNameFromRequest);
            synchronized (this) {
                if (!userManager.isUserExists(user)) {
                    userManager.addUser(user);
                    request.getSession(true).setAttribute(Constants.USERNAME,user.getName());
                }
                else{
                    try(PrintWriter out = response.getWriter()) {
                        out.println("Username " + userNameFromRequest + " already exists. Please enter a different username.");
                    }
                }
            }
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("in do post");
        doGet(req,resp);
    }
}
