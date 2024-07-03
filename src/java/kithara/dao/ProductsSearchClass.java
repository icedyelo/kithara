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

public class ProductsSearchClass {

    public ArrayList<ProductModel> getproductsList() throws ClassNotFoundException {
        ArrayList<ProductModel> customerList = new ArrayList<>();
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        String query = "select productsId, "
                + "productsName, "
                + "description, "
                + "size, "
                + "price, "
                + "quantity "
                + "from products ";
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
                
                customerList.add(products);
            }
            conn.close();
        } catch (SQLException e) {
            System.out.println("getProductsError Error: " + e);
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
