package models;
// model
public class Product {
    private int productId;
    private String productName;
    private String productDesc;
    private int productHarga;
    private int productStock;


    public Product(int productId, String productName, String productDesc, int productHarga, int productStock) {
        this.productId = productId;
        this.productName = productName;
        this.productDesc = productDesc;
        this.productHarga = productHarga;
        this.productStock = productStock;
    }


    public int getProductId() {
        return productId;
    }

    public String getProductName() {
        return productName;
    }

    public String getProductDesc() {
        return productDesc;
    }

    public int getProductHarga() {
        return productHarga;
    }

    public int getProductStock() {
        return productStock;
    }
}
