/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package pos;

import db.mysqlcon;
import view.login;

/**
 *
 * @author Olionnn
 */
public class Pos {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        mysqlcon.connect();
        login frame = new login();
        java.awt.EventQueue.invokeLater(() -> {
            frame.setVisible(true);
        });
    }
    
}
