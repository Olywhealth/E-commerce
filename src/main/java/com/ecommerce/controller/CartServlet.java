package com.ecommerce.controller;

import com.ecommerce.dao.CartDao;
import com.ecommerce.model.Cart;
import com.ecommerce.model.Like;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

public class CartServlet extends HttpServlet {

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        String path = request.getServletPath();

        switch (path) {
            case "/add_product_to_cart":
                this.addProductToCart(request, response);
                break;
            case "/like_or_unlike":
                this.likeOrUnlike(request, response);
                break;
            default:
                throw new IllegalStateException("Unexpected value: " + path);
        }
    }

    public void addProductToCart(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        response.setContentType("text/html");
        HttpSession session = request.getSession();

        String productId = request.getParameter("productId");

        System.out.println("product ID: " + productId);
        int userId = (int) session.getAttribute("userId");

        Cart cart = new Cart(productId, userId);
        CartDao cartDao = new CartDao();
        PrintWriter printWriter = response.getWriter();

        if (cartDao.addProductToCart(cart)){
            request.getRequestDispatcher("customerallproductview.jsp");
            printWriter.println("Product Added Successfully");

        }else {
            printWriter.println("Product removed successfully");
        }
    }
    public void likeOrUnlike(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html");
        HttpSession session = request.getSession();

        String productId = request.getParameter("productId");

        int userId = (int) session.getAttribute("userId");
        session.setAttribute("userId", userId);
        System.out.println();

        CartDao cartDao = new CartDao();
        Like like = new Like(productId, userId);
        PrintWriter printWriter = response.getWriter();
        if(cartDao.likeOrUnlikeProduct(like)){
            printWriter.println("liked");

        }else{
            printWriter.println("unliked");
        }
    }
}
