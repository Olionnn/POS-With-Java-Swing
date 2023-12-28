package models;

public class Orders {		

    private int orderId;
    private int orderProductId;
    private int orderQty;
    private String orderSelesai;
    private String orderDate;

    // Join DB
    public String productName;
    public String userName;
    public int total;


    public Orders(int orderId, String productName, int orderQty, int total,String userName, String orderDate,String orderSelesai) {
        this.orderId = orderId;
        this.productName = productName;
        this.orderQty = orderQty;
        this.total = total;
        this.userName = userName;
        this.orderDate = orderDate;
        this.orderSelesai = orderSelesai;
    }

    public int getOrderId() {
        return orderId;
    }

    public int getOrderProductId(){
        return orderProductId;
    }

    public int getOrderQty(){
        return orderQty;
    }
    
    public String getOrderDate() {
        return orderDate;
    }

    public String getOrderSelesai() {
        return orderSelesai;
    }

    public String getProductName() {
        return productName;
    }

    public String getUserName() {
        return userName;
    }

    public int getTotal() {
        return total;
    }
}
