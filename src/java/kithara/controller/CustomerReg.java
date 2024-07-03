package kithara.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.RequestDispatcher;
import kithara.dao.RegisterAddClass;
import kithara.dao.RegisterSearchClass;
import kithara.dao.RegisterUpdateClass;
import kithara.model.CustomerRegModel;

public class CustomerReg extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String action = request.getServletPath();
        switch (action) {

            case "/customer/create/form":
                showCustomerCreateForm(request, response);
                break;
                
            case "/customer/update/form":
            {
                try {
                    showCustomerUpdateForm(request, response);
                } catch (ClassNotFoundException ex) {
                    Logger.getLogger(CustomerReg.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
                break;


            case "/customer/update": {
                try {
                    updateCustomer(request, response);
                } catch (ClassNotFoundException ex) {
                    Logger.getLogger(CustomerReg.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            break;

            case "/customer/create": {
                try {
                    createCustomer(request, response);
                } catch (ClassNotFoundException ex) {
                    Logger.getLogger(CustomerReg.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            break;

            case "/customer/delete": {
                try {
                    deleteCustomer(request, response);
                } catch (ClassNotFoundException ex) {
                    Logger.getLogger(CustomerReg.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            break;

            default: {
                try {
                    viewCustomer(request, response);
                } catch (ClassNotFoundException ex) {
                    Logger.getLogger(CustomerReg.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            break;

        }

    }
    
    private void showCustomerUpdateForm(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, ClassNotFoundException {
        String userId = request.getParameter("userName");
        RegisterAddClass customer = new RegisterAddClass();
        CustomerRegModel customerDetails = customer.getCustomerDetails(userId);
        request.setAttribute("customerDetails", customerDetails);
        RequestDispatcher rd = getServletContext().getRequestDispatcher(
                "/customerUpdate.jsp");
        rd.forward(request, response);
    }

    private void updateCustomer(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, ClassNotFoundException {
        String firstName = request.getParameter("firstName");
        String middleName = request.getParameter("middleName");
        String lastName = request.getParameter("lastName");
        String birthDate = request.getParameter("birthDate");
        String mobile = request.getParameter("Mobile");
        String address = request.getParameter("Address");
        String userId = request.getParameter("userName");
        String password = request.getParameter("Password");
        String userRole = request.getParameter("userRole");
        String accountStatus = null;
        String loginStatus = null;

        RegisterAddClass customer = new RegisterAddClass();
        CustomerRegModel updateCustomer = new CustomerRegModel(firstName, middleName, lastName, birthDate, mobile, address, userId, password, userRole, accountStatus, loginStatus);
        boolean success = customer.updateCustomer(updateCustomer);
        
        
        
        if (success){
            System.out.println("Success");
            response.sendRedirect(request.getContextPath() + "/customer?alert=successupdate");
        } else {
            System.out.println("Error");
            response.sendRedirect(request.getContextPath() + "/customer?alert=errorupdate");
        }
    }

    private void showCustomerCreateForm(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        RequestDispatcher rd = getServletContext().getRequestDispatcher(
                "/customer.jsp");
        rd.forward(request, response);
    }

    private void viewCustomer(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, ClassNotFoundException {
        if (request.getParameter("viewRegister") != null) {
            String userId = request.getParameter("userName");
            RegisterUpdateClass edit = new RegisterUpdateClass();
            ArrayList<CustomerRegModel> customerDetails = edit.getCustomerDetails(userId);
            request.setAttribute("customerDetails", customerDetails);

            RequestDispatcher rd = getServletContext().getRequestDispatcher(
                    "/customerUpdate.jsp");
            rd.forward(request, response);
        } else {
            RegisterSearchClass customer = new RegisterSearchClass();
            ArrayList<CustomerRegModel> customerList = customer.getCustomerList();
            request.setAttribute("customerList", customerList);

            RequestDispatcher rd = getServletContext().getRequestDispatcher(
                    "/user.jsp");
            rd.forward(request, response);
        }

    }

    private void createCustomer(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, ClassNotFoundException {

        String firstName = request.getParameter("firstName");
        String middleName = request.getParameter("middleName");
        String lastName = request.getParameter("lastName");
        String birthDate = request.getParameter("birthDate");
        String mobile = request.getParameter("Mobile");
        String address = request.getParameter("Address");
        String userId = request.getParameter("userName");
        String password = request.getParameter("Password");
        String userRole = request.getParameter("userRole");
        String accountStatus = null;
        String loginStatus = null;

        RegisterAddClass customer = new RegisterAddClass();
        CustomerRegModel createCustomer = new CustomerRegModel(firstName, middleName, lastName, birthDate, mobile, address, userId, password, userRole, accountStatus, loginStatus);
        boolean success = customer.createCustomer(createCustomer);
        
        
        
        if (success){
            System.out.println("Success");
            response.sendRedirect(request.getContextPath() + "/customer?alert=success");
        } else {
            System.out.println("Error");
            response.sendRedirect(request.getContextPath() + "/customer?alert=error");
        }
        
        
        
        
    }

    private void deleteCustomer(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, ClassNotFoundException {
        String userId = request.getParameter("userName");
        RegisterAddClass customer = new RegisterAddClass();
        boolean success = customer.deleteCustomer(userId);
        if (success){
            System.out.println("Success");
            response.sendRedirect(request.getContextPath() + "/customer?alert=deleted");
        } else {
            System.out.println("Error");
            response.sendRedirect(request.getContextPath() + "/customer?alert=notdeleted");
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request, response);
    }
}
