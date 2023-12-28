package controller;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import db.mysqlcon;
import models.Orders;


//  #	Name	            Type	Collation	Attributes	Null	                Default	Comments	Extra	Action
// 	1	order_id   Primary	int			No	    None		AUTO_INCREMENT	                            Change Change	Drop Drop	
// 	2	order_product_id	int			No	    None			                                        Change Change	    Drop Drop	
// 	3	order_qty	        int			No	    None			                                        Change Change	Drop Drop	
// 	4	order_user_id	    int			No	    None			                                        Change Change	Drop Drop	
// 	5	order_date	        datetime		    on update CURRENT_TIMESTAMP	No	CURRENT_TIMESTAMP		DEFAULT_GENERATED ON UPDATE CURRENT_TIMESTAMP	Change Change	Drop Drop	
// 	6	order_selesai	    enum('1', '0')	    utf8mb4_0900_ai_ci		No	None			Change Change	Drop Drop	

public class orderController {



    public static List<Orders> GetAllOrderData(int userId) throws ClassNotFoundException {
        String query = "SELECT order_id, product.product_name, order_qty, product.product_harga * order_qty as 'Total', users.user_name, order_date, order_selesai FROM orders left JOIN product on product_id=order_product_id LEFT JOIN users on users.user_id = order_user_id WHERE order_selesai = '0' and order_user_id = " + userId +";";
        List<Orders> orderList = new ArrayList<>();
    
        try (ResultSet data = mysqlcon.getQuery(query)) {
            while (data.next()) {
                int orderId = data.getInt(1);
                
                String productName = data.getString(2);
                int orderQty = data.getInt(3);
                int total = data.getInt(4);
                String userName = data.getString(5);
                String orderDate = data.getString(6);
                String orderSelesai = data.getString(7);
    
                Orders order = new Orders(orderId, productName, orderQty,total, userName, orderDate, orderSelesai);
                orderList.add(order);
            }
        } catch (SQLException e) {
            System.out.println("Error :" + e.getMessage());
            e.printStackTrace();
        }
    
        return orderList;
    }
    public static List<Orders> GetAllOrderHistoryData() throws ClassNotFoundException {
        String query = "SELECT order_id, product.product_name, order_qty, product.product_harga * order_qty as 'Total', users.user_name, order_date, order_selesai FROM orders left JOIN product on product_id=order_product_id LEFT JOIN users on users.user_id = order_user_id WHERE order_selesai = '1';";
        List<Orders> orderList = new ArrayList<>();
    
        try (ResultSet data = mysqlcon.getQuery(query)) {
            while (data.next()) {
                int orderId = data.getInt(1);
                
                String productName = data.getString(2);
                int orderQty = data.getInt(3);
                int total = data.getInt(4);
                String userName = data.getString(5);
                String orderDate = data.getString(6);
                String orderSelesai = data.getString(7);
    
                Orders order = new Orders(orderId, productName, orderQty,total, userName, orderDate, orderSelesai);
                orderList.add(order);
            }
        } catch (SQLException e) {
            System.out.println("Error :" + e.getMessage());
            e.printStackTrace();
        }
    
        return orderList;
    }

    public static void insertOrderData(int order_product_id, int order_qty, int order_user_id) throws ClassNotFoundException, SQLException {
        String query = "INSERT INTO orders (order_id , order_product_id,order_qty, order_user_id, order_selesai) VALUES " + "(" + 0 + ",\"" + order_product_id + "\",\"" + order_qty  + "\"," + order_user_id + ", '0');";
        mysqlcon.initQuery(query);
    }

    public static void updateOrderData(int order_id, int order_product_id, int order_qty, int order_user_id) throws ClassNotFoundException, SQLException {
        String query = "UPDATE orders SET order_product_id=\"" + order_product_id + "\", order_qty=\"" + order_qty + "\", order_user_id=\"" + order_user_id + "\", order_date=NOW(), order_selesai='0' WHERE order_id=" + order_id + ";";
        mysqlcon.initQuery(query);
    }

    public static void updateOrderHistoryData(int order_id, int order_product_id, int order_qty, int order_user_id) throws ClassNotFoundException, SQLException {
        String query = "UPDATE orders SET order_product_id=" + order_product_id + ", order_qty=" + order_qty + ", order_user_id=" + order_user_id + ", order_date=NOW(), order_selesai='1' WHERE order_id=" + order_id + ";";
        mysqlcon.initQuery(query);
    }

    public static void deleteOrderData(int order_id) throws ClassNotFoundException, SQLException {
        String query = "DELETE FROM orders WHERE order_id=" + order_id + ";";
        mysqlcon.initQuery(query);
    }
 


    public static String totalPembelian(int sesionID) throws ClassNotFoundException, SQLException {

        
        String query = "SELECT SUM( product.product_harga * orders.order_qty) as `TOTAL HARGA` from orders Left join product on product_id=order_product_id left join users on user_id=order_user_id  WHERE product_id = orders.order_product_id and orders.order_selesai = \"0\" and order_user_id= "+ sesionID +";";
        ResultSet getTotal = mysqlcon.getQuery(query);

        while (getTotal.next()) {
            String Total = getTotal.getString(1);
            return Total;
        }
        getTotal.close();
        return "";
    }


    public static String totalPenjualan() throws ClassNotFoundException, SQLException {
        String query = "SELECT SUM(product.product_harga * orders.order_qty) from orders left JOIN product on product_id = order_product_id WHERE order_selesai = '1';";
        ResultSet getTotal = mysqlcon.getQuery(query);

        while (getTotal.next()) {
            String Total = getTotal.getString(1);
            return Total;
        }
        getTotal.close();
        return "";
    }

    public static String getBarangTerjual() throws ClassNotFoundException, SQLException {
        String query = "SELECT SUM(order_qty) FROM `orders` WHERE order_selesai = '1' and order_qty != 0;";
        ResultSet getTotal = mysqlcon.getQuery(query);

        while (getTotal.next()) {
            String Total = getTotal.getString(1);
            return Total;
        }
        return "";
    }

    public static void bayarOrder(int userId) throws ClassNotFoundException, SQLException {
        String query = "Update orders set order_selesai = '1' WHERE orders.order_user_id = "+ userId + " and order_selesai = '0';";
        mysqlcon.initQuery(query);
    }
}
