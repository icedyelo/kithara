/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package kithara.dao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import kithara.model.ProductModel;

public class ProductsUpdateClass {

    public ArrayList<ProductModel> getproductsDetails(int productsId) throws ClassNotFoundException {
        ArrayList<ProductModel> productsDetails = new ArrayList<>();
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        String query = ""
                + "select productsId, "
                + "productsName, "
                + "description, "
                + "size, "
                + "price, "
                + "quantity "
                + "from products "
                + "where productsId = ? ";
        try {
            conn = ConnectionPool.getConnection();
            ps = conn.prepareStatement(query);
            rs = ps.executeQuery();
            while (rs.next()) {
                ProductModel products = new ProductModel();

                products.setproductsId(rs.getInt("productsId"));
                products.setproductsName(rs.getString("productsName"));
                products.setdescription(rs.getString("description"));
                products.setsize(rs.getString("size"));
                products.setprice(Double.parseDouble(rs.getString("price")));
                products.setquantity(Integer.parseInt(rs.getString("quantity")));
                
                productsDetails.add(products);
            }
            conn.close();
        } catch (SQLException e) {
            System.out.println("getProductsList Error: " + e);
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
            
        return productsDetails;
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