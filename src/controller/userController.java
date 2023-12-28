package controller;

import java.sql.*;

import com.mysql.cj.protocol.Resultset;

import db.mysqlcon;



// 1	user_id	int	NULL	NULL	NO	NULL	auto_increment		
// 2	user_name	varchar(255)	utf8mb4	utf8mb4_0900_ai_ci	NO	NULL			
// 3	user_password	varchar(255)	utf8mb4	utf8mb4_0900_ai_ci	NO	NULL			
// 4	user_email	text	utf8mb4	utf8mb4_0900_ai_ci	NO	NULL			
// 5	user_phone	varchar(255)	utf8mb4	utf8mb4_0900_ai_ci	NO	NULL			

public class userController {



    
    public static void main(String[] args) throws ClassNotFoundException {
        GetAllUserData();
        System.out.println("\"");
    }

    public static void GetAllUserData() throws ClassNotFoundException {
        String query = "SELECT * FROM users";


        try(ResultSet data = mysqlcon.getQuery(query) ){


            while (data.next()) {
                int userId = data.getInt(1);
                String userName = data.getString(2);
                String userPassword = data.getString(3);
                String userEmail = data.getString(4);
                String userPhone = data.getString(5);
            }
            
        } catch (SQLException e) {
            System.out.println("Error :" + e.getMessage());
            e.printStackTrace();
        }
    }

    public static void insertUserData(String userName, String userPassword, String userEmail, String userPhone) throws ClassNotFoundException, SQLException {
        userPhone = (userPhone != "" || userPhone != null) ? userPhone : null;
        String query = "INSERT INTO users (user_id , user_name,user_password, user_email, user_phone ) VALUES " + "(" + 0 + ",\"" + userName + "\",\"" + userPassword  + "\",\"" + userEmail + "\",\"" + userPhone + "\");";
        mysqlcon.initQuery(query);
    }

    public static void updateUserData(int userId, String userName, String userPassword, String userEmail, String userPhone) throws ClassNotFoundException, SQLException {
        userPhone = (userPhone!= "" || userPhone!= null)? userPhone : null;
        String query = "UPDATE users SET user_name=\"" + userName + "\", user_password=\"" + userPassword + "\", user_email=\"" + userEmail + "\", user_phone=\"" + userPhone + "\" WHERE user_id=" + userId + ";";
        mysqlcon.initQuery(query);
    }

    public static void deleteUserData(int userId) throws ClassNotFoundException, SQLException {
        String query = "DELETE FROM users WHERE user_id=" + userId + ";";
        mysqlcon.initQuery(query);
    }


    // PR : Login Logic
    public static int loginUser(String userName, String userPassword) throws ClassNotFoundException, SQLException {
        String query = "SELECT user_name, user_password FROM users WHERE user_name=\"" + userName + "\" AND user_password=\"" + userPassword + "\";";

        Resultset result = (Resultset) mysqlcon.getQuery(query);
        if (((ResultSet) result).next()){
            return 1;

        } else {
            return 0;
        }
    }

    public static int getUserid(String userName) throws SQLException, ClassNotFoundException {
        String query = "SELECT user_id FROM users WHERE user_name =\"" + userName + "\"";

        ResultSet result = mysqlcon.getQuery(query);
        while (result.next()) {
            int userid = result.getInt(1);
            return userid;
        }

        return 0;


    }





}


