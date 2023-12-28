package controller;

import db.mysqlcon;
import models.Product;

import java.sql.*;

import java.util.ArrayList;
import java.util.List;

import com.mysql.cj.xdevapi.Result;



//  1   product_id      Primary	    int			No	    None		            AUTO_INCREMENT	                Change Change	Drop Drop	
// 	2	product_name	            varchar(25)	        utf8mb4_0900_ai_ci		No	            None			Change Change	Drop Drop	
// 	3	product_desc	            text	            utf8mb4_0900_ai_ci		Yes	            NULL			Change Change	Drop Drop	
// 	4	product_harga	            int			No	    None			                                        Change Change   Drop Drop	
// 	5	product_stock	

public class productController {
    
    public static void main(String[] args) throws   ClassNotFoundException {
        // GetAllproductData();
        System.out.println("\"");
    }

    public static List<Product> GetAllproductData() throws ClassNotFoundException {
        String query = "SELECT * FROM product";
        List<Product> productList = new ArrayList<>();
    
        try (ResultSet data = mysqlcon.getQuery(query)) {
            while (data.next()) {
                int productId = data.getInt(1);
                String productName = data.getString(2);
                String productDesc = data.getString(3);
                int productHarga = data.getInt(4);
                int productStock = data.getInt(5);
    
                // Create a Product object and add it to the list
                Product product = new Product(productId, productName, productDesc, productHarga, productStock);
                productList.add(product);
            }
        } catch (SQLException e) {
            System.out.println("Error :" + e.getMessage());
            e.printStackTrace();
        }
    
        return productList;
    }

    public static List<Product> getAllEmptyStock() throws ClassNotFoundException {
    String query = "SELECT * FROM product WHERE product_stock = 0;";
    List<Product> productList = new ArrayList<>();

    try (ResultSet data = mysqlcon.getQuery(query)) {
        while (data.next()) {
            int productId = data.getInt(1);
            String productName = data.getString(2);
            String productDesc = data.getString(3);
            int productHarga = data.getInt(4);
            int productStock = data.getInt(5);

            // Create a Product object and add it to the list
            Product product = new Product(productId, productName, productDesc, productHarga, productStock);
            productList.add(product);
        }
    } catch (SQLException e) {
        System.out.println("Error :" + e.getMessage());
        e.printStackTrace();
    }
    
        return productList;
    }
    

    public static void insertProductData(String productName, String productDesc, int productHarga, int productStock) throws ClassNotFoundException, SQLException {
        String query = "INSERT INTO product (product_id , product_name, product_desc, product_harga, product_stock) VALUES " + "(" + 0 + ",\"" + productName + "\",\"" + productDesc + "\",\"" + productHarga + "\",\"" + productStock + "\"" + ");";
        mysqlcon.initQuery(query);
    }

    public static void updateProductData(int productId, String productName, String productDesc, int productHarga, int productStock) throws ClassNotFoundException, SQLException {
        String query = "UPDATE product SET product_name=\"" + productName + "\", product_desc=\"" + productDesc + "\", product_harga=\"" + productHarga + "\", product_stock=\"" + productStock + "\" WHERE product_id=" + productId + ";";
        mysqlcon.initQuery(query);
    }

    public static void deleteProductData(int productId) throws ClassNotFoundException, SQLException {
        String query = "DELETE FROM product WHERE product_id=" + productId + ";";
        mysqlcon.initQuery(query);
    }


    public static String getTotalEmptyStock() throws ClassNotFoundException, SQLException {
        String query = "SELECT COUNT(product.product_stock) FROM product WHERE product.product_stock = 0;";
        ResultSet data = mysqlcon.getQuery(query);

        while (data.next()) {
            return data.getString(1);
            
        }
        return "";
    }

    public static void updateStocks(int productId, int productStock) throws ClassNotFoundException, SQLException {
        String query = "UPDATE product SET product_stock=\"" + productStock + "\" WHERE product_id=" + productId + ";";
        mysqlcon.initQuery(query);
    }
    


}

