package com.ecommerce.controller;

import com.ecommerce.dao.ProductDao;
import com.ecommerce.model.Product;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

public class ProductServlet extends HttpServlet {

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        String path = request.getServletPath();

        switch (path){
            case "/add_product" :
                this.addProduct(request, response);
                break;
            case "/update_product" :
                this.updateProduct(request, response);
                break;
            case "/delete_product" :
                this.deleteProduct(request, response);
                break;
            case "/get_product" :
                this.getProductByName(request, response);
                break;
            case "/get_product_category" :
                this.getProductByCategory(request, response);
                break;
            case "/get_all_product" :
                this.getAllProduct(request, response);
                break;
            case "/customer_get_product" :
                this.customerGetProductByName(request, response);
                break;
            case "/customer_get_product_category" :
                this.customerGetProductByCategory(request, response);
                break;
            case "/customer_get_all_product" :
                this.customerAllProduct(request, response);
                break;
            default:
                throw new IllegalStateException("Unexpected value: " + path);
        }


    }

    public boolean addProduct(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        response.setContentType("text/html");
        boolean added = false;
        String productId = request.getParameter("productId");
        String name = request.getParameter("productName");
        String category = request.getParameter("category");
        float quantity = Float.parseFloat(request.getParameter("quantity"));
        double price = Double.parseDouble(request.getParameter("price"));


        Product product = new Product(productId, name, category, price, quantity);
        ProductDao productDao = new ProductDao();
        PrintWriter printWriter = response.getWriter();

        if (productDao.addProduct(product)){
            request.getRequestDispatcher("addProduct.jsp");
            printWriter.println("Product Added Successfully");

            added = true;
        }
        return added;
    }

    public boolean updateProduct(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        boolean updated = false;
        HttpSession session = request.getSession();

        String id = request.getParameter("productId");
        String name = request.getParameter("productName");
        String category = request.getParameter("category");
        float quantity = Float.parseFloat(request.getParameter("quantity"));
        double price = Double.parseDouble(request.getParameter("price"));

        Product updatedProduct = new Product(id, name, category, price, quantity);
        ProductDao productDao = new ProductDao();

        if (productDao.updateProduct(updatedProduct)){
            request.getRequestDispatcher("allproductview.jsp");
            updated = true;
        }
        return updated;
    }
    public  boolean deleteProduct(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
//I still have to redirect path after successful deletion
        ProductDao productDao = new ProductDao();
        String productName = request.getParameter("productName");
        boolean deleted = productDao.deleteProduct(productName);
        if (deleted) {
            System.out.println("delete serv");
            request.getRequestDispatcher("allproductview.jsp").forward(request, response);
        }

        return deleted;
    }

    public void getProductByName(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        String productName = request.getParameter("productName");
        ProductDao productDao = new ProductDao();
        Product productFetched = productDao.getProduct(productName);

        PrintWriter printWriter = response.getWriter();
        printWriter.println("Gotten Successfully");
        HttpSession session = request.getSession();


        session.setAttribute("name", productFetched.getName());
        session.setAttribute("price", productFetched.getPrice());
        session.setAttribute("category", productFetched.getCategory());
        session.setAttribute("id", productFetched.getProductId());
        session.setAttribute("quantity", productFetched.getQuantity());

        session.setAttribute("productFetched", productFetched);


        RequestDispatcher requestDispatcher = request.getRequestDispatcher("getproductbyname.jsp");
        requestDispatcher.forward(request, response);
    }
    //list of product.... using setAttribute();

    public void getProductByCategory(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        String category = request.getParameter("category");
        ProductDao productDao = new ProductDao();
        List<Product> productByCategory = productDao.getProductByCategory(category);


        HttpSession session = request.getSession();

        session.setAttribute("productByCategory", productByCategory);


        RequestDispatcher requestDispatcher = request.getRequestDispatcher("productbycategory.jsp");
        requestDispatcher.forward(request, response);
    }

    public void getAllProduct(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ProductDao productDao = new ProductDao();
        List<Product> allProducts = productDao.getAllProduct();
        HttpSession session = request.getSession();

        session.setAttribute("allProducts", allProducts);


        RequestDispatcher requestDispatcher = request.getRequestDispatcher("allproductview.jsp");
        requestDispatcher.forward(request, response);

    }
    public void customerGetProductByName(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        String productName = request.getParameter("productName");
        ProductDao productDao = new ProductDao();
        Product productFetched = productDao.customerGetProduct(productName);

        PrintWriter printWriter = response.getWriter();
        printWriter.println("Gotten Successfully");
        HttpSession session = request.getSession();


        session.setAttribute("productFetched", productFetched);


        RequestDispatcher requestDispatcher = request.getRequestDispatcher("customergetproductbyname.jsp");
        requestDispatcher.forward(request, response);
    }
    //list of product.... using setAttribute();

    public void customerGetProductByCategory(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        String category = request.getParameter("category");
        ProductDao productDao = new ProductDao();
        List<Product> productByCategory = productDao.customerGetProductByCategory(category);


        HttpSession session = request.getSession();

        session.setAttribute("productByCategory", productByCategory);


        RequestDispatcher requestDispatcher = request.getRequestDispatcher("customerproductcategory.jsp");
        requestDispatcher.forward(request, response);
    }

    public void customerAllProduct(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ProductDao productDao = new ProductDao();
        List<Product> allProducts = productDao.customerGetAllProduct();
        HttpSession session = request.getSession();

        session.setAttribute("allProducts", allProducts);


        RequestDispatcher requestDispatcher = request.getRequestDispatcher("customerallproductview.jsp");
        requestDispatcher.forward(request, response);

    }


}
