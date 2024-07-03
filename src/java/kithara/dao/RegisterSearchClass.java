package kithara.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import kithara.model.CustomerRegModel;

public class RegisterSearchClass {

    public ArrayList<CustomerRegModel> getCustomerList() throws ClassNotFoundException {
        ArrayList<CustomerRegModel> customerList = new ArrayList<>();
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
                + "userRole, "
                + "accountStatus, "
                + "loginStatus "
                + "FROM customerinfo ";
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
                customer.setAccountStatus(rs.getString("accountStatus"));
                customer.setLoginStatus(rs.getString("loginStatus"));
                customerList.add(customer);
            }
            conn.close();
        } catch (SQLException e) {
            System.out.println("getCustomerList Error: " + e);
        } finally {
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException e) {
                    //ignore
                }
            }
            if (ps != null) {
                try {
                    ps.close();
                } catch (SQLException e) {
                    //ignore
                }
            }
            if (rs != null) {
                try {
                    rs.close();
                } catch (SQLException e) {
                    //ignore
                }
            }

        }
        return customerList;
    }
    
}
