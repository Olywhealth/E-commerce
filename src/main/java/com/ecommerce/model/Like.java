package com.ecommerce.model;

public class Like {
    private String productId;
    private int userId;
    private int likeId;

    public Like(String productId, int userId, int likeId) {
        this.productId = productId;
        this.userId = userId;
        this.likeId = likeId;
    }

    public Like(String productId, int userId) {
        this.productId = productId;
        this.userId = userId;
    }

    public Like() {
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

    public int getLikeId() {
        return likeId;
    }

    public void setLikeId(int likeId) {
        this.likeId = likeId;
    }
}
