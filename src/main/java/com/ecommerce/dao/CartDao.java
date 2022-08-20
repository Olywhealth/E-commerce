package com.ecommerce.dao;

import com.ecommerce.model.Cart;
import com.ecommerce.model.Like;
import com.ecommerce.util.DbConnection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class CartDao {

    public  boolean addProductToCart(Cart cart){
        boolean added = false;
        final String ADD_PRODUCT_QUERY = "INSERT INTO cart(userId, productId) VALUES (?,?)";
        final String REMOVE_PRODUCT_FROM_CART_QUERY = "DELETE FROM cart WHERE productId = ? And userId = ?";
        final String TO_CHECK_ADDITION_QUERY = "SELECT * FROM cart WHERE productId = ? And userId = ?";
        PreparedStatement preparedStatement =  null;

        try{
            preparedStatement = DbConnection.getConnection().prepareStatement(TO_CHECK_ADDITION_QUERY);
            preparedStatement.setInt(2, cart.getUserId());
            preparedStatement.setString(1, cart.getProductId());
            System.out.println(preparedStatement);

            ResultSet resultSet = preparedStatement.executeQuery();

            String addedStr = " ";
            if(resultSet.next()){
                addedStr = resultSet.getString("product_id");
                System.out.println("Entered here?");
                if (resultSet.getString("product_id").equalsIgnoreCase(cart.getProductId())) {
                   // System.out.println("You dey enter here?");
                    preparedStatement = DbConnection.getConnection().prepareStatement(REMOVE_PRODUCT_FROM_CART_QUERY);
                    preparedStatement.setString(1, cart.getProductId());
                    preparedStatement.setInt(2, cart.getUserId());
                    System.out.println(preparedStatement + "for unlike");
                    int result =  preparedStatement.executeUpdate();
                    added = false;
                }
            }
            else {
                //like
                preparedStatement = DbConnection.getConnection().prepareStatement(ADD_PRODUCT_QUERY);
                preparedStatement.setString(2, cart.getProductId());
                preparedStatement.setInt(1, cart.getUserId());
                System.out.println(preparedStatement  + "for like");
                preparedStatement.executeUpdate();
                added = true;
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        return added;
    }

    public boolean likeOrUnlikeProduct(Like like){
        final String LIKE_PRODUCT_QUERY = "INSERT INTO likes(userId, productId) VALUES (?,?)";
        final String UNLIKE_PRODUCT_QUERY = "DELETE FROM likes  WHERE productId = ? And userId= ?";
        final String TO_CHECK_LIKE_QUERY = "SELECT * FROM  likes WHERE productId = ? And userId = ?";
        System.out.println("Inside the like or unlike");
        boolean action = false;

        PreparedStatement preparedStatement = null;
        try{
            preparedStatement = DbConnection.getConnection().prepareStatement(TO_CHECK_LIKE_QUERY);
            preparedStatement.setString(1, like.getProductId());
            preparedStatement.setInt(2, like.getUserId());
            System.out.println(preparedStatement);
            ResultSet resultSet = preparedStatement.executeQuery();

            
//if user has already liked the product
            String liked = "";
            //System.out.println("e reach here");
            if(resultSet.next()){
                liked = resultSet.getString("product_id");
                System.out.println("Entered here?");
                if (resultSet.getString("product_id").equalsIgnoreCase(like.getProductId())) {
                   // System.out.println("You dey enter here?");
                    preparedStatement = DbConnection.getConnection().prepareStatement(UNLIKE_PRODUCT_QUERY);
                    preparedStatement.setString(1, like.getProductId());
                    preparedStatement.setInt(2, like.getUserId());
                    System.out.println(preparedStatement + "for unlike");
                  int result =  preparedStatement.executeUpdate();
                  action = false;
                }
            }
            else {
                //like
                preparedStatement = DbConnection.getConnection().prepareStatement(LIKE_PRODUCT_QUERY);
                preparedStatement.setString(2, like.getProductId());
                preparedStatement.setInt(1, like.getUserId());
                System.out.println(preparedStatement  + "for like");
                preparedStatement.executeUpdate();
                action = true;
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        return action;
    }
//    public boolean deleteProductFromCart(String productId){
//        boolean deleted = false;
//        final String DELETE_FROM_CART_QUERY = "DELETE FROM cart WHERE productId = ?";
//        try{
//            PreparedStatement preparedStatement = DbConnection.getConnection().prepareStatement(DELETE_FROM_CART_QUERY);
//            preparedStatement.setString(1, productId);
//            preparedStatement.executeUpdate();
//            deleted = true;
//            System.out.println(deleted);
//        } catch (SQLException e) {
//            throw new RuntimeException(e);
//        } catch (ClassNotFoundException e) {
//            throw new RuntimeException(e);
//        }
//        return deleted;
//    }
}
