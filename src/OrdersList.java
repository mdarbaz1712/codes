import java.util.LinkedList;

public class OrdersList {
    private LinkedList<Order> orderList=new LinkedList<>();
    public synchronized void addOrder(Order order){
        orderList.add(order);
        notify();
        // Lets Start to prepare the Order of Customer;
        System.out.println("Your Order is Confirmed !!  "+order.getOrderId());
    }
    public synchronized Order takeOrder() throws InterruptedException{
        while(orderList.isEmpty()){
            //wait for the Order is Comming .
            //System.out.println("No Order is Present at this time !!");
            wait();
        }
        return orderList.remove(0);
    }
}
