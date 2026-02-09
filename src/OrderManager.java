import java.util.ArrayList;
import java.util.List;

public class OrderManager {
    public OrdersList orders=new OrdersList();
    private List<Order> allOrders=new ArrayList<>();
    private int orderId=1;
    public OrderManager(int workers){
        for(int worker=0;worker<workers;worker++){
            new ProcessOrder(orders,"worker - "+worker).start();
        }
    }
    public synchronized void submitOrder(String orderName,int orderQuantity){
        Order order=new Order(orderId++,orderName,orderQuantity);
        allOrders.add(order);
        orders.addOrder(order);
    }
    public void printSummaryReport(){
        int newCount=0,processingCount=0,deliveredCount=0,failedCount=0;
        for(Order order:allOrders){
            switch(order.getOrderStatus()){
                case NEW -> newCount++;
                case PROCESSING -> processingCount++;
                case DELIVERED -> deliveredCount++;
                case FAILED -> failedCount++;
            }
        }
        System.out.println("        === ORDER REPORT ===        ");
        System.out.println("Total     : "+allOrders.size());
        System.out.println("NEW       : "+newCount);
        System.out.println("PROCESSING: "+processingCount);
        System.out.println("DELIVERED : "+deliveredCount);
        System.out.println("FAILED    : "+failedCount);
    }
}
