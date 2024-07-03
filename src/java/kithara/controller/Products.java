package kithara.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import kithara.model.ProductModel;
import kithara.dao.ProductDao;
import kithara.dao.ProductsUpdateClass;
import kithara.dao.ProductsSearchClass;

/**
 *
 * @author aisi
 */
public class Products extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String action = request.getServletPath();
        switch (action) {
            case "/home":
                showHome(request, response);
                break;

            case "/about":
                showAbout(request, response);
                break;

            case "/contact":
                showContact(request, response);
                break;

            case "/login":
                showLogin(request, response);
                break;

            case "/products/create/form":
                showproductsForm(request, response);
                break;

            case "/products/create": {
                try {
                    createproducts(request, response);
                } catch (ClassNotFoundException ex) {
                    Logger.getLogger(Products.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            break;

            case "/products/update/form": {
                try {
                    showproductsUpdateForm(request, response);
                } catch (ClassNotFoundException ex) {
                    Logger.getLogger(Products.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            break;

            case "/products/update": {
                try {
                    updateproducts(request, response);
                } catch (ClassNotFoundException ex) {
                    Logger.getLogger(Products.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            break;

            case "/products/delete": {
                try {
                    deleteproducts(request, response);
                } catch (ClassNotFoundException ex) {
                    Logger.getLogger(Products.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            break;

            default: {
                try {
                    viewproducts(request, response);
                } catch (ClassNotFoundException ex) {
                    Logger.getLogger(Products.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            break;

        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request, response);
    }

    private void viewproducts(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, ClassNotFoundException {
        if (request.getParameter("addProducts") != null) {
            int productsId = Integer.parseInt(request.getParameter("productsId"));
            ProductsUpdateClass edit = new ProductsUpdateClass();
            ArrayList<ProductModel> productsDetails = edit.getproductsDetails(productsId);
            request.setAttribute("productsDetails", productsDetails);

            RequestDispatcher rd = getServletContext().getRequestDispatcher(
                    "/productsUpdate.jsp");
            rd.forward(request, response);
        } else {
            ProductsSearchClass products = new ProductsSearchClass();
            ArrayList<ProductModel> productsList = products.getproductsList();
            request.setAttribute("productsList", productsList);

            RequestDispatcher rd = getServletContext().getRequestDispatcher(
                    "/products.jsp");
            rd.forward(request, response);
        }
    }

    private void showproductsForm(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        RequestDispatcher rd = getServletContext().getRequestDispatcher(
                "/productsForm.jsp");
        rd.forward(request, response);
    }

    private void showHome(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        RequestDispatcher rd = getServletContext().getRequestDispatcher(
                "/index.jsp");
        rd.forward(request, response);
    }

    private void showAbout(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        RequestDispatcher rd = getServletContext().getRequestDispatcher(
                "/about.jsp");
        rd.forward(request, response);
    }

    private void showContact(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        RequestDispatcher rd = getServletContext().getRequestDispatcher(
                "/contact.jsp");
        rd.forward(request, response);
    }
    
    private void showLogin(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        RequestDispatcher rd = getServletContext().getRequestDispatcher(
                "/login.jsp");
        rd.forward(request, response);
    }

    private void createproducts(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, ClassNotFoundException {
        int productsId = Integer.parseInt(request.getParameter("productsId"));
        String productsName = request.getParameter("productsName");
        String description = request.getParameter("description");
        String size = request.getParameter("size");
        double price = Double.parseDouble(request.getParameter("price"));
        int quantity = Integer.parseInt(request.getParameter("quantity"));

        ProductDao product = new ProductDao();
        ProductModel products = new ProductModel(
                productsId, productsName, description, size, price, quantity);
        boolean success = product.createproducts(products);
        if (success) {
            System.out.println("Success");
            response.sendRedirect(request.getContextPath() + "/products?alert=successproduct");
        } else {
            System.out.println("Error");
            response.sendRedirect(request.getContextPath() + "/products?alert=errorProduct");
        }
    }

    private void showproductsUpdateForm(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, ClassNotFoundException {
        int productsId = Integer.parseInt(request.getParameter("productsId"));
        ProductDao products = new ProductDao();
        ProductModel productsDetails = products.getproductsDetails(productsId);
        request.setAttribute("productsDetails", productsDetails);
        RequestDispatcher rd = getServletContext().getRequestDispatcher(
                "/productsUpdate.jsp");
        rd.forward(request, response);
    }

    private void updateproducts(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, ClassNotFoundException {
        int productsId = Integer.parseInt(request.getParameter("productsId"));
        String productsName = request.getParameter("productsName");
        String description = request.getParameter("description");
        String size = request.getParameter("size");
        double price = Double.parseDouble(request.getParameter("price"));
        int quantity = Integer.parseInt(request.getParameter("quantity"));

        ProductDao products = new ProductDao();
        ProductModel updateproducts = new ProductModel(
                productsId, productsName, description, size, price, quantity);
        boolean success = products.updateproducts(updateproducts);
        if (success) {
            System.out.println("Success");
            response.sendRedirect(request.getContextPath() + "/products?alert=successupdate");
        } else {
            System.out.println("Error");
            response.sendRedirect(request.getContextPath() + "/products?alert=errorupdate");
        }
    }

    private void deleteproducts(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, ClassNotFoundException {
        int productsId = Integer.parseInt(request.getParameter("productsId"));
        ProductDao products = new ProductDao();
        boolean success = products.deleteproducts(productsId);
        if (success) {
            System.out.println("Success");
            response.sendRedirect(request.getContextPath() + "/products?alert=deleted");
        } else {
            System.out.println("Error");
            response.sendRedirect(request.getContextPath() + "/products?alert=notdeleted");
        }
    }
}
