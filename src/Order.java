public class Order {
    private int orderId;
    private String orderName;
//    private int orderPrice;
    private int orderQuantity;
    private OrderStatus orderStatus;
    Order(int orderId,String orderName,int orderQuantity){
        this.orderId=orderId;
        this.orderName=orderName;
        this.orderQuantity=orderQuantity;
        this.orderStatus=OrderStatus.NEW;
    }
    public int  getOrderId(){
        return orderId;
    }
    public synchronized OrderStatus getOrderStatus(){
        return orderStatus;
    }
    public synchronized void setOrderStatus(OrderStatus orderStatus){
        this.orderStatus=orderStatus;
    }
}
