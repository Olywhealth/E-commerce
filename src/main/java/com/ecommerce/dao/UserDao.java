package com.ecommerce.dao;

import com.ecommerce.model.User;
import com.ecommerce.util.DbConnection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserDao {

    public boolean adminSignUp(User user) throws SQLException, ClassNotFoundException {
        boolean signUp = false;
        final String ADMIN_SIGNUP_QUERY = "INSERT INTO Admin(fullName, staffId, password, email) VALUES(?,?,?,?)";
        try{
            PreparedStatement preparedStatement = DbConnection.getConnection().prepareStatement(ADMIN_SIGNUP_QUERY);
            preparedStatement.setString(1, user.getFullName());
            preparedStatement.setString(2, user.getStaffId());
            preparedStatement.setString(3, user.getPassword());
            preparedStatement.setString(4, user.getEmail());
            preparedStatement.executeUpdate();

            signUp = true;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        return signUp;
    }

    public static User getUserAdmin(String staffId, String password) throws SQLException, ClassNotFoundException {
        final String adminValidationQuery = "SELECT * FROM Admin WHERE staffId = ? and password = ?";

        PreparedStatement preparedStatement = DbConnection.getConnection().prepareStatement(adminValidationQuery);
        preparedStatement.setString(1, staffId);
        preparedStatement.setString(2, password);

        ResultSet resultset = preparedStatement.executeQuery();
        User user = new User();
        while(resultset.next()){
            String name = resultset.getString("fullName");
            String sId = resultset.getString("staffId");
            String pass = resultset.getString("password");
            String email = resultset.getString("email");
            int id = resultset.getInt("id");

            user = new User(name, sId, id, pass, email);

        }
        return user;
    }
    public boolean customerSignUp(User user) throws SQLException, ClassNotFoundException {
        boolean signUp = false;
        final String CUSTOMER_SIGNUP_QUERY = "INSERT INTO user(fullName, password, email) VALUES(?,?,?)";
        try{
            PreparedStatement preparedStatement = DbConnection.getConnection().prepareStatement(CUSTOMER_SIGNUP_QUERY);
            preparedStatement.setString(1, user.getFullName());
            preparedStatement.setString(2, user.getEmail());
            preparedStatement.setString(3, user.getPassword());
            preparedStatement.executeUpdate();

            signUp = true;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        return signUp;
    }

    public static User getUserCustomer(String email, String password) throws SQLException, ClassNotFoundException {
        final String ADMIN_VALIDATION_QUERY = "SELECT * FROM user WHERE email = ? and password = ?";

        PreparedStatement preparedStatement = DbConnection.getConnection().prepareStatement(ADMIN_VALIDATION_QUERY);
        preparedStatement.setString(1, email);
        preparedStatement.setString(2, password);

        ResultSet resultset = preparedStatement.executeQuery();
        User user = new User() ;
        while(resultset.next()){
            String name = resultset.getString("fullName");
            String pass = resultset.getString("password");
            String customerEmail = resultset.getString("email");
            int id = resultset.getInt("id");

            user = new User(name, id, customerEmail, pass);

        }
        return user;
    }
}
