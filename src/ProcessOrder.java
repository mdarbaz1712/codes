public class ProcessOrder extends Thread {
    private OrdersList orderQueue=new OrdersList();
    public ProcessOrder(OrdersList orderQueue, String name){
        super(name);
        this.orderQueue=orderQueue;
    }
    private void processOrder(Order order){
        try{
            order.setOrderStatus(OrderStatus.PROCESSING);

            //Do And Prepare your Order.
            Thread.sleep(90);

            order.setOrderStatus(OrderStatus.DELIVERED);
        }
        catch(Exception e){
            order.setOrderStatus(OrderStatus.FAILED);
        }
    }
    public void run(){
        while(true){
            try{
                Order order=orderQueue.takeOrder();
                processOrder(order);
            }
            catch(InterruptedException e){
                break;
            }
        }
    }

}
