package com.ecommerce.controller;

import com.ecommerce.dao.UserDao;
import com.ecommerce.model.User;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet(name = "SignupServlet", value = "/SignupServlet")
public class SignupServlet extends HttpServlet {


    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException{
        String path = request.getServletPath();

        switch (path){
            case "/admin_signup" :
                this.adminSignUp(request, response);
                break;
            case "/customer_signup" :
                this.customerSignUp(request, response);
                break;
            default:
                throw new IllegalStateException("invalid URL: " + path);
        }

    }
    public boolean adminSignUp(HttpServletRequest request, HttpServletResponse response){
        boolean adminSignedUp = false;
        String fullName = request.getParameter("name");
        String staffId = request.getParameter("staffId");
        String password = request.getParameter("password");
        String email = request.getParameter("email");

        User user = new User(fullName, staffId, password, email);
        UserDao userDao = new UserDao();

        try {
            if (userDao.adminSignUp(user)){
                response.sendRedirect("adminlogin.jsp");
                adminSignedUp = true;
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException | IOException e) {
            throw new RuntimeException(e);
        }
        return adminSignedUp;
    }
    public boolean customerSignUp(HttpServletRequest request, HttpServletResponse response){
        boolean customerSignedUp = false;
        String fullName = request.getParameter("name");
        String password = request.getParameter("password");
        String email = request.getParameter("email");

        User user = new User(fullName,password, email);
        UserDao userDao = new UserDao();

        try {
            if (userDao.customerSignUp(user)){
                response.sendRedirect("customerlogin.jsp");
                customerSignedUp = true;
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException | IOException e) {
            throw new RuntimeException(e);
        }
        return customerSignedUp;
    }

}
