package kithara.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.RequestDispatcher;
import kithara.dao.UserDao;
import kithara.model.UserModel;

public class User extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String action = request.getServletPath();
        switch (action) {
            case "/user/create":
                showUserForm(request, response);
                break;
            
            case "/user/added":
                getUser(request, response);
                break;

            default:
                
                showUser(request, response);
                break;
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request, response);
    }

    private void getUser(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String ID = request.getParameter("uID");

        if (ID.length() != 0) {
            String uID = request.getParameter("uID");
            String firstName = request.getParameter("firstName");
            String middleName = request.getParameter("middleName");
            String lastName = request.getParameter("lastName");
            String userRole = request.getParameter("userRole");
            String notice = request.getParameter("uID") + " user has been added";

            UserModel user = new UserModel(uID, firstName, middleName, lastName, userRole, notice);
            UserDao userDao = new UserDao();
            UserModel getUser = userDao.getUserDetails(user);
            request.setAttribute("user", getUser);

            RequestDispatcher rd = getServletContext().getRequestDispatcher(
                    "/user.jsp");
            rd.forward(request, response);
        } else {
            String uID = request.getParameter("uID");
            String firstName = request.getParameter("firstName");
            String middleName = request.getParameter("middleName");
            String lastName = request.getParameter("lastName");
            String userRole = request.getParameter("userRole");
            String notice = null;

            UserModel user = new UserModel(uID, firstName, middleName, lastName, userRole, notice);
            UserDao userDao = new UserDao();
            UserModel getUser = userDao.getUserDetails(user);
            request.setAttribute("user", getUser);

            RequestDispatcher rd = getServletContext().getRequestDispatcher(
                    "/user.jsp");
            rd.forward(request, response);
        }
    }

    private void showUserForm(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        RequestDispatcher rd = getServletContext().getRequestDispatcher(
                "/userForm.jsp");
        rd.forward(request, response);
    }
    
    private void showUser(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        RequestDispatcher rd = getServletContext().getRequestDispatcher(
                "/user.jsp");
        rd.forward(request, response);
    }

}
