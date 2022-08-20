package com.ecommerce.controller;

import com.ecommerce.dao.UserDao;
import com.ecommerce.model.User;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.sql.SQLException;

import static org.junit.jupiter.api.Assertions.*;

class SignupServletTest {
HttpServletRequest request;
HttpServletResponse response;
UserDao userDao;
User user;
    @BeforeEach
    void setUp() {
        request = Mockito.mock(HttpServletRequest.class);
        response = Mockito.mock(HttpServletResponse.class);
        userDao = new UserDao();
    }

    @Test
    void doPostAdminSignUp() throws SQLException, ClassNotFoundException {
        user = new User("baba", "11", "123", "baba@gmail.com");

        assertTrue(userDao.adminSignUp(user));

    }
    @Test
    void doPostCustomerSignUp() throws SQLException, ClassNotFoundException {
        user = new User("Abejirin",  "1235", "topeD@gmail.com");

        assertTrue(userDao.customerSignUp(user));

    }
}