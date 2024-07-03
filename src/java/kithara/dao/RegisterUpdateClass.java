package kithara.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import kithara.model.CustomerRegModel;

public class RegisterUpdateClass {

    public ArrayList<CustomerRegModel> getCustomerDetails(String userId) throws ClassNotFoundException {
        ArrayList<CustomerRegModel> customerDetails = new ArrayList<>();
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        String query = "SELECT "
                + "firstName, "
                + "middleName, "
                + "lastName, "
                + "birthDate, "
                + "mobile, "
                + "address, "
                + "userId, "
                + "password, "
                + "userRole "
                + "FROM customerinfo "
                + "WHERE userId = ? ";
        try {
            conn = ConnectionPool.getConnection();
            ps = conn.prepareStatement(query);
            rs = ps.executeQuery();
            while (rs.next()) {
                CustomerRegModel customer = new CustomerRegModel();

                customer.setFirstName(rs.getString("firstName"));
                customer.setMiddleName(rs.getString("middleName"));
                customer.setLastName(rs.getString("lastName"));
                customer.setBirthDate(rs.getString("birthDate"));
                customer.setMobile(rs.getString("mobile"));
                customer.setAddress(rs.getString("address"));
                customer.setUserId(rs.getString("userId"));
                customer.setPassword(rs.getString("password"));

                customer.setUserRole(rs.getString("userRole"));
                customerDetails.add(customer);
            }
            conn.close();
        } catch (SQLException e) {
            System.out.println("getCustomerList Error: " + e);
        }
        
        if (ps != null) {
                try {
                    ps.close();
                } catch (SQLException e) {
                    //ignore
                }
            }
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException e) {
                    //ignore
                }
            }
            
        return customerDetails;
    }

    public Boolean editRegister(
            String firstName,
            String middleName,
            String lastName,
            String birthDate,
            String mobile,
            String address,
            String password,
            String userRole,
            String userId) throws ClassNotFoundException {
        boolean success = false;
        Connection conn = null;
        PreparedStatement ps = null;

        try {
            String query = "UPDATE customerinfo SET"
                    + "firstName = ?,"
                    + "middleName = ?,"
                    + "lastName = ?,"
                    + "birthDate = ?,"
                    + "mobile = ?,"
                    + "address = ?,"
                    + "password = ?,"
                    + "userRole = ? "
                    + "WHERE userId = ? ";
            conn = ConnectionPool.getConnection();
            ps = conn.prepareStatement(query);
            ps.setString(1, firstName);
            ps.setString(2, middleName);
            ps.setString(3, lastName);
            ps.setString(4, birthDate);
            ps.setString(5, mobile);
            ps.setString(6, address);
            ps.setString(7, password);
            ps.setString(8, userRole);
            ps.setString(9, userId);
            
            int rowsAffected = ps.executeUpdate();
            if (rowsAffected != 0){
                success = true;
            }
                    
        } catch (SQLException e) {
            System.out.println("getCustomerList Error: " + e);
        } finally {
            if (ps != null) {
                try {
                    ps.close();
                } catch (SQLException e) {
                    //ignore
                }
            }
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException e) {
                    //ignore
                }
            }
    } 
        return false;
    }

}
