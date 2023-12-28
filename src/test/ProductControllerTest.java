package test;

import java.sql.SQLException;

import controller.productController;

public class ProductControllerTest {
    

    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        productController.insertProductData("Rokok", "amsdasd", 1000, 2000);
        productController.insertProductData("Sampo", "amsdasd", 4000, 2000);
        productController.insertProductData("Sapi", "amsdasd", 8000, 2000);
        productController.insertProductData("SUSU", "amsdasd", 5000, 2000);

        productController.updateProductData(2, "Mawar", "ASMENTUS WINE", 5000, 2000);
        productController.deleteProductData(4);
    }
}
