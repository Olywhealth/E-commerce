package com.ecommerce.controller;

import com.ecommerce.dao.UserDao;
import com.ecommerce.model.User;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet(name = "LoginServlet", value = "/LoginServlet")
public class LoginServlet extends HttpServlet {
    public void doPost(HttpServletRequest request, HttpServletResponse response){
        String path = request.getServletPath();

        switch (path){
            case "/admin_login" :
                this.adminLogin(request, response);
                break;
            case "/customer_login" :
                this.customerLogin(request, response);
                break;
            default:
                throw new IllegalStateException("Unexpected value: " + path);
        }

            }
    public boolean adminLogin(HttpServletRequest request, HttpServletResponse response){
        boolean adminLoggedIn = true;

        String staffIdToValidate = request.getParameter("staffId");
        String passwordToValidate = request.getParameter("password");
        HttpSession session = request.getSession();
        try {
            User user = UserDao.getUserAdmin(staffIdToValidate, passwordToValidate);
            session.setAttribute("password", user.getPassword());
            session.setAttribute("staffId", user.getStaffId());
            String passwordFromDb = user.getPassword();
            String staffIdFromDb = user.getStaffId();
            if (!staffIdToValidate.equalsIgnoreCase(staffIdFromDb) && !passwordToValidate.equals(passwordFromDb)){
                session.setAttribute("invalid Login Details", "Invalid password or staff id");
                response.sendRedirect("adminlogin.jsp");
                adminLoggedIn = false;

            }else{
                session.setAttribute("staffId", user.getStaffId());
                session.setAttribute("fullName", user.getFullName());
                response.sendRedirect("addProduct.jsp");
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return adminLoggedIn;
    }

    public boolean customerLogin(HttpServletRequest request, HttpServletResponse response){
        boolean customerLoggedIn = true;

        String emailToValidate = request.getParameter("email");
        String passwordToValidate = request.getParameter("password");
        HttpSession session = request.getSession();
        try {
            User user = UserDao.getUserCustomer(emailToValidate, passwordToValidate);

            session.setAttribute("email", user.getEmail());
            session.setAttribute("password", user.getPassword());
            String passwordFromDb = user.getPassword();
            String emailFromDb = user.getEmail();

            if (!emailToValidate.equalsIgnoreCase(emailFromDb) || !passwordToValidate.equals(passwordFromDb)){

                System.out.println("Entered not logged in");
                session.setAttribute("invalid Login Details", "Invalid password or email");
                response.sendRedirect("customerlogin.jsp");
                customerLoggedIn = false;

            }else{
                session.setAttribute("email", user.getEmail());
                session.setAttribute("fullName", user.getFullName());
                session.setAttribute("userId", user.getId());
                System.out.println("Entered login");
                RequestDispatcher requestDispatcher = request.getRequestDispatcher("/customer_get_all_product");
                requestDispatcher.forward(request, response);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (ServletException e) {
            throw new RuntimeException(e);
        }
        return customerLoggedIn;
    }



}
