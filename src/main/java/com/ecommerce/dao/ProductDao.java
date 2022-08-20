package com.ecommerce.dao;

import com.ecommerce.model.Product;
import com.ecommerce.util.DbConnection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ProductDao {

    public  boolean addProduct(Product product){
        boolean added = false;
        final String ADD_PRODUCT_QUERY = "INSERT INTO product(productName, category, quantity, price, id) VALUES (?,?,?,?,?)";
        try{
            PreparedStatement preparedStatement = DbConnection.getConnection().prepareStatement(ADD_PRODUCT_QUERY);
            preparedStatement.setString(1, product.getName());
            preparedStatement.setString(2, product.getCategory());
            preparedStatement.setFloat(3, product.getQuantity());
            preparedStatement.setDouble(4, product.getPrice());
            preparedStatement.setString(5, product.getProductId());
            preparedStatement.executeUpdate();

            added = true;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        return added;
    }

    public boolean updateProduct(Product product){
        boolean updated = false;
        final String UPDATE_PRODUCT_QUERY = "UPDATE product SET productName = ?, category = ?, quantity = ?, price = ? WHERE id = ?";
        try{
            PreparedStatement preparedStatement = DbConnection.getConnection().prepareStatement(UPDATE_PRODUCT_QUERY);
            preparedStatement.setString(1, product.getName());
            preparedStatement.setString(2, product.getCategory());
            preparedStatement.setFloat(3, product.getQuantity());
            preparedStatement.setDouble(4, product.getPrice());
            preparedStatement.setString(5, product.getProductId());
            preparedStatement.executeUpdate();
            updated = true;
            System.out.println(updated);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        return updated;
    }

    public boolean deleteProduct(String productName){
        boolean deleted = false;
        final String DELETE_PRODUCT_QUERY = "DELETE FROM product WHERE productName = ?";
        try{
            PreparedStatement preparedStatement = DbConnection.getConnection().prepareStatement(DELETE_PRODUCT_QUERY);
            preparedStatement.setString(1, productName);
            preparedStatement.executeUpdate();
            deleted = true;
            System.out.println(deleted);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        return deleted;
    }

    public List<Product>getProductByCategory(String category){
        List<Product> productList = new ArrayList<>();
        final String GET_PRODUCT_BY_CATEGORY_QUERY = "SELECT * FROM product WHERE category = ?";
        try{
            PreparedStatement preparedStatement = DbConnection.getConnection().prepareStatement(GET_PRODUCT_BY_CATEGORY_QUERY);
            preparedStatement.setString(1, category);
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                String name = resultSet.getString("productName");
                String productCategory = resultSet.getString("category");
                double price = resultSet.getDouble("price");
                float quantity = resultSet.getFloat("quantity");
                String id = resultSet.getString("id");

                Product product = new Product(id, name, productCategory, price, quantity);
                productList.add(product);
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        return productList;
    }
    public Product getProduct(String productName){
        final String GET_PRODUCT_QUERY = "SELECT * FROM product WHERE productName = ?";
        Product product = new Product();
        try{
            PreparedStatement preparedStatement = DbConnection.getConnection().prepareStatement(GET_PRODUCT_QUERY);
            preparedStatement.setString(1, productName);
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                String name = resultSet.getString("productName");
                String productCategory = resultSet.getString("category");
                double price = resultSet.getDouble("price");
                float quantity = resultSet.getFloat("quantity");
                String id = resultSet.getString("id");

                product = new Product(id, name, productCategory, price, quantity);
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        return product;
    }

    public List<Product>getAllProduct(){
        List<Product> productList = new ArrayList<>();
        final String GET_ALL_PRODUCT_QUERY = "SELECT * FROM product";
        try{
            PreparedStatement preparedStatement = DbConnection.getConnection().prepareStatement(GET_ALL_PRODUCT_QUERY);
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                String name = resultSet.getString("productName");
                String productCategory = resultSet.getString("category");
                double price = resultSet.getDouble("price");
                float quantity = resultSet.getFloat("quantity");
                String id = resultSet.getString("id");

                Product product = new Product(id, name, productCategory, price, quantity);
                productList.add(product);
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        return productList;
    }

    public List<Product>customerGetProductByCategory(String category){
        List<Product> productList = new ArrayList<>();
        final String CUSTOMER_GET_PRODUCT_BY_CATEGORY_QUERY = "SELECT * FROM customerProd WHERE category = ?";
        try{
            PreparedStatement preparedStatement = DbConnection.getConnection().prepareStatement(CUSTOMER_GET_PRODUCT_BY_CATEGORY_QUERY);
            preparedStatement.setString(1, category);
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                String name = resultSet.getString("productName");
                String productCategory = resultSet.getString("category");
                double price = resultSet.getDouble("price");
                float quantity = resultSet.getFloat("quantity");
                String id = resultSet.getString("id");

                Product product = new Product(id, name, productCategory, price, quantity);
                productList.add(product);
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        return productList;
    }
    public Product customerGetProduct(String productName){
        final String CUSTOMER_GET_PRODUCT_QUERY = "SELECT * FROM customerProd WHERE productName = ?";
        Product product = new Product();
        try{
            PreparedStatement preparedStatement = DbConnection.getConnection().prepareStatement(CUSTOMER_GET_PRODUCT_QUERY);
            preparedStatement.setString(1, productName);
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                String name = resultSet.getString("productName");
                String productCategory = resultSet.getString("category");
                double price = resultSet.getDouble("price");
                float quantity = resultSet.getFloat("quantity");
                String id = resultSet.getString("id");

                product = new Product(id, name, productCategory, price, quantity);
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        return product;
    }
    public List<Product>customerGetAllProduct(){
        List<Product> productList = new ArrayList<>();
        final String CUSTOMER_GET_ALL_PRODUCT_QUERY = "SELECT * FROM customerProd";
        try{
            PreparedStatement preparedStatement = DbConnection.getConnection().prepareStatement(CUSTOMER_GET_ALL_PRODUCT_QUERY);
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                String name = resultSet.getString("productName");
                String productCategory = resultSet.getString("category");
                double price = resultSet.getDouble("price");
                float quantity = resultSet.getFloat("quantity");
                String id = resultSet.getString("id");

                Product product = new Product(id, name, productCategory, price, quantity);
                productList.add(product);
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        return productList;
    }


}
