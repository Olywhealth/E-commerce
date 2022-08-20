package com.ecommerce.model;

import java.sql.Timestamp;

public class Cart {
    private String productId;
    private int userId;
    private Timestamp date;
    private int cartId;

    public Cart(String productId, int userId, Timestamp date, int cartId) {
        this.productId = productId;
        this.userId = userId;
        this.date = date;
        this.cartId = cartId;
    }

    public Cart(String productId, int userId) {
        this.productId = productId;
        this.userId = userId;
    }

    public Cart() {
    }

    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public Timestamp getDate() {
        return date;
    }

    public void setDate(Timestamp date) {
        this.date = date;
    }

    public int getCartId() {
        return cartId;
    }

    public void setCartId(int cartId) {
        this.cartId = cartId;
    }
}
