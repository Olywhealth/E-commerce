package com.ecommerce.controller;

import com.ecommerce.dao.UserDao;
import com.ecommerce.model.User;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.SQLException;

class LoginServletTest {
    HttpServletRequest request;
    HttpServletResponse response;
    private UserDao userDao;

    @BeforeEach
    void setUp() {
        request = Mockito.mock(HttpServletRequest.class);
        response = Mockito.mock(HttpServletResponse.class);
        userDao = new UserDao();
    }

    @Test
    void doPostCustomer() {
        Mockito.when(request.getParameter("email")).thenReturn("nick@email.com");
        Mockito.when(request.getParameter("password")).thenReturn("1234");

        try {
            User user = UserDao.getUserCustomer("nick@email.com","1234");
            Assertions.assertEquals(user.getEmail(),"nick@email.com");
            Assertions.assertEquals(user.getPassword(),"1234");
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    @Test
    void doPostAdmin() {
        Mockito.when(request.getParameter("staffId")).thenReturn("dfg2");
        Mockito.when(request.getParameter("password")).thenReturn("1234");

        try {
            User user = UserDao.getUserAdmin("dfg2","1234");
            Assertions.assertEquals(user.getStaffId(),"dfg2");
            Assertions.assertEquals(user.getPassword(),"1234");
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }


    @Test
    void doPostToFailCustomer() {
        Mockito.when(request.getParameter("email")).thenReturn("wrongEmail@email.com");
        Mockito.when(request.getParameter("password")).thenReturn("wrongPassword");

        try {
            User user = UserDao.getUserCustomer("wrongEmail@email.com","wrongPassword");
            Assertions.assertNull(user.getEmail());
            Assertions.assertNull(user.getPassword());
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    @Test
    void doPostToFailAdmin() {
        Mockito.when(request.getParameter("staffId")).thenReturn("wrongId");
        Mockito.when(request.getParameter("password")).thenReturn("wrongPassword");

        try {
            User user = UserDao.getUserAdmin("wrongId","wrongPassword");
            Assertions.assertNull(user.getStaffId());
            Assertions.assertNull(user.getPassword());
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

}