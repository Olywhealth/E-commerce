package com.ecommerce.controller;

import com.ecommerce.dao.ProductDao;
import com.ecommerce.model.Product;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import static org.junit.jupiter.api.Assertions.*;

class ProductServletTest {
    HttpServletRequest request;
    HttpServletResponse response;
    ProductDao productDao;
    Product product;

    @BeforeEach
    void setUp(){
        request = Mockito.mock(HttpServletRequest.class);
        response = Mockito.mock(HttpServletResponse.class);
        productDao = new ProductDao();
    }

    @Test
    void doPostAddProduct() {
        product = new Product("BCD", "Snickers", "Chocolate", 360, 2 );

        assertTrue(productDao.addProduct(product));
    }
    @Test
    void doPostUpdateProduct() {
        product = new Product("BCD", "Snickers", "Chocolate", 369, 22 );

        assertTrue(productDao.updateProduct(product));
    }

    @Test
    void doPostDeleteProduct() {
        product = new Product("BCD", "Snickers", "Chocolate", 369, 22 );

        assertTrue(productDao.deleteProduct(product.getName()));
    }
    @Test
    void doPostGetProduct() {
        product = new Product("BCD", "Snickers", "Chocolate", 369, 22 );

        assertNotEquals(product, productDao.customerGetProduct("Snickers"));
    }



    @Test
    void doGet() {
    }
}