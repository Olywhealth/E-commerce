package com.ecommerce.controller;

import com.ecommerce.dao.CartDao;
import com.ecommerce.model.Cart;
import com.ecommerce.model.Like;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class CartServletTest {
    HttpServletRequest request;
    HttpServletResponse response;
    Cart cart;
    CartDao cartDao;
    Like like;


    @BeforeEach
    void setUp() {
        request = Mockito.mock(HttpServletRequest.class);
        response = Mockito.mock(HttpServletResponse.class);
        cartDao = new CartDao();
    }

    @Test
    void doPostToAddToCart() {
        cart =  new Cart("1", 9);
        assertTrue(cartDao.addProductToCart(cart));
    }
    @Test
    void doPostToRemoveFromCart() {
        cart =  new Cart("123AC", 9);
        assertFalse(cartDao.addProductToCart(cart));
    }

    @Test
    void doPostToLikeProduct() {
        like =  new Like("123AC", 9);
        assertTrue(cartDao.likeOrUnlikeProduct(like));
    }

    @Test
    void doPostToUnlikeProduct() {
        like =  new Like("123AC", 9);
        assertFalse(cartDao.likeOrUnlikeProduct(like));
    }

    @Test
    void doGet() {
    }
}