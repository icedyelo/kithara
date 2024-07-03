package kithara.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import kithara.model.CustomerRegModel;

public class RegisterAddClass {
    
    public ArrayList<CustomerRegModel> getCustomerList() throws ClassNotFoundException {
        ArrayList<CustomerRegModel> customerList = new ArrayList<>();
        Connection conn  = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        String query = "select * from customerinfo";
        try {
            conn = ConnectionPool.getConnection();
            ps = conn.prepareStatement(query);
            rs = ps.executeQuery();
            while (rs.next()) {
                CustomerRegModel customer = new CustomerRegModel();
                customer.setUserId(rs.getString("userId"));
                customer.setFirstName(rs.getString("firstName"));
                customer.setMiddleName(rs.getString("middleName"));
                customer.setLastName(rs.getString("lastName"));
                customer.setBirthDate(rs.getString("birthDate"));
                customer.setMobile(rs.getString("mobile"));
                customer.setAddress(rs.getString("address"));
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

    public boolean createCustomer(CustomerRegModel customer) throws ClassNotFoundException {
        boolean success = false;
        Connection conn = null;
        PreparedStatement ps = null;
        String query = "INSERT INTO customerinfo ("
                + "firstName,"
                + "middleName,"
                + "lastName,"
                + "birthDate,"
                + "mobile,"
                + "address,"
                + "userId,"
                + "password,"
                + "userRole)"
                + "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";
        try {
            conn = ConnectionPool.getConnection();
            ps = conn.prepareStatement(query);
            ps.setString(1, customer.getFirstName());
            ps.setString(2, customer.getMiddleName());
            ps.setString(3, customer.getLastName());
            ps.setString(4, customer.getBirthDate());
            ps.setString(5, customer.getMobile());
            ps.setString(6, customer.getAddress());
            ps.setString(7, customer.getUserId());
            ps.setString(8, customer.getPassword());
            ps.setString(9, customer.getUserRole());
            int rowAffected = ps.executeUpdate();
            if (rowAffected != 0) {
                success = true;
            }
        } catch (SQLException e) {
            System.out.println("createCustomer Error: " + e);
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

        }
        return success;
    }
    
    public CustomerRegModel getCustomerDetails(String username) throws ClassNotFoundException {
        CustomerRegModel customerDetails = null;
        Connection conn  = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        String query = "select * from customerinfo where userId = ?";
        try {
            conn = ConnectionPool.getConnection();
            ps = conn.prepareStatement(query);
            ps.setString(1, username);
            rs = ps.executeQuery();
            if (rs.next()) {
                username = rs.getString("userId");
                String firstName = rs.getString("firstName");
                String middleName = rs.getString("middleName");
                String lastName = rs.getString("lastName");
                String birthDate = rs.getString("birthDate");
                String mobile = rs.getString("mobile");
                String address = rs.getString("address");
                String password = rs.getString("password");
                String userRole = rs.getString("userRole");
                String accountStatus = rs.getString("accountStatus");
                String loginStatus = rs.getString("loginStatus");
                customerDetails = new CustomerRegModel(firstName, middleName, lastName, birthDate, mobile, address, username, password, userRole, accountStatus, loginStatus);
            }
        } catch (SQLException e) {
            System.out.println("getCustomerDetails Error: " + e); 
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
        return customerDetails;
    }
    
    public boolean updateCustomer(CustomerRegModel customer) throws ClassNotFoundException {
        boolean success = false;
        Connection conn  = null;
        PreparedStatement ps = null;
        String query = "UPDATE customerinfo set "
                + "firstName = ?, "
                + "middleName = ?, "
                + "lastName = ?, "
                + "birthDate = ?, "
                + "mobile = ?, "
                + "address = ?, "
                + "password = ?, "
                + "userRole = ? "
                + "where userId = ? ;";
        try {
            conn = ConnectionPool.getConnection();
            ps = conn.prepareStatement(query);
            ps.setString(9, customer.getUserId());
            ps.setString(1, customer.getFirstName());
            ps.setString(2, customer.getMiddleName());
            ps.setString(3, customer.getLastName());
            ps.setString(4, customer.getBirthDate());
            ps.setString(5, customer.getMobile());
            ps.setString(6, customer.getAddress());
            ps.setString(7, customer.getPassword());
            ps.setString(8, customer.getUserRole());
            int rowAffected = ps.executeUpdate();
            if (rowAffected != 0) {
                success = true;
            }
        } catch (SQLException e) {
            System.out.println("updateCustomer Error: " + e); 
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
            
        }
        return success;
    }
    
    public boolean deleteCustomer(String userId) throws ClassNotFoundException {
        boolean success = false;
        Connection conn  = null;
        PreparedStatement ps = null;
        String query = "DELETE FROM customerinfo "
                + "WHERE userId = ? ";
        try {
            conn = ConnectionPool.getConnection();
            ps = conn.prepareStatement(query);
            ps.setString(1, userId);
            int rowAffected = ps.executeUpdate();
            if (rowAffected != 0) {
                success = true;
            }
        } catch (SQLException e) {
            System.out.println("deleteEmployee Error: " + e); 
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
            
        }
        return success;
    }
    
}
