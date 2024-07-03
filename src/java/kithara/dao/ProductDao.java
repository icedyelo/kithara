/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/File.java to edit this template
 */
package kithara.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import kithara.model.ProductModel;

public class ProductDao {

    public ArrayList<ProductModel> getproductsList() throws ClassNotFoundException {
        ArrayList<ProductModel> productsList = new ArrayList<>();
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        String query = "SELECT * FROM products";
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
                products.setprice(rs.getDouble("price"));
                products.setquantity(rs.getInt("quantity"));
                productsList.add(products);
            }
            conn.close();
        } catch (SQLException e) {
            System.out.println("getproductsList Error: " + e);
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
        return productsList;
    }

    public ProductModel getproductsDetails(int productsId) throws ClassNotFoundException {
        ProductModel productsDetails = null;
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
            ps.setInt(1, productsId);
            rs = ps.executeQuery();
            if (rs.next()) {
                productsId = rs.getInt("productsId");
                String productsName = rs.getString("productsName");
                String description = rs.getString("description");
                String size = rs.getString("size");
                double price = rs.getDouble("price");
                int quantity = rs.getInt("quantity");
                productsDetails = new ProductModel(productsId, productsName, description, size, price, quantity);
            }
        } catch (SQLException e) {
            System.out.println("getproductsDetails Error: " + e);
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
        return productsDetails;
    }

    public boolean createproducts(ProductModel products) throws ClassNotFoundException {
        boolean success = false;
        Connection conn = null;
        PreparedStatement ps = null;
        String query = "insert into products ("
                + "productsId, "
                + "productsName, "
                + "description, "
                + "size, "
                + "price, "
                + "quantity) "
                + "values (?,?,?,?,?,?)";
        try {
            conn = ConnectionPool.getConnection();
            ps = conn.prepareStatement(query);
            ps.setInt(1, products.getproductsId());
            ps.setString(2, products.getproductsName());
            ps.setString(3, products.getdescription());
            ps.setString(4, products.getsize());
            ps.setDouble(5, products.getprice());
            ps.setInt(6, products.getquantity());
            int rowAffected = ps.executeUpdate();
            if (rowAffected != 0) {
                success = true;
            }
        } catch (SQLException e) {
            System.out.println("createproducts Error: " + e);
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

    public boolean updateproducts(ProductModel products) throws ClassNotFoundException {
        boolean success = true;
        Connection conn = null;
        PreparedStatement ps = null;
        String query = "UPDATE products set "
                + "productsName = ?, "
                + "description = ?, "
                + "size = ?, "
                + "price = ?, "
                + "quantity = ? "
                + "where productsId = ? ";
        try {
            conn = ConnectionPool.getConnection();
            ps = conn.prepareStatement(query);
            ps.setInt(6, products.getproductsId());
            ps.setString(1, products.getproductsName());
            ps.setString(2, products.getdescription());
            ps.setString(3, products.getsize());
            ps.setDouble(4, products.getprice());
            ps.setInt(5, products.getquantity());
            int rowAffected = ps.executeUpdate();
            if (rowAffected != 0) {
                success = true;
            }
        } catch (SQLException e) {
            System.out.println("updateproducts Error: " + e);
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

    public boolean deleteproducts(int productsId) throws ClassNotFoundException {
        boolean success = true;
        Connection conn = null;
        PreparedStatement ps = null;
        String query = "delete from products "
                + "where productsId = ? ";
        try {
            conn = ConnectionPool.getConnection();
            ps = conn.prepareStatement(query);
            ps.setInt(1, productsId);
            int rowAffected = ps.executeUpdate();
            if (rowAffected != 0) {
                success = true;
            }
        } catch (SQLException e) {
            System.out.println("deleteproducts Error: " + e);
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
