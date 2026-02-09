//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.


void main() throws InterruptedException {
    //TIP Press <shortcut actionId="ShowIntentionActions"/> with your caret at the highlighted text
    // to see how IntelliJ IDEA suggests fixing it.

    OrderManager manager=new OrderManager(2);

    Thread t1=new Thread(()->{
        for(int i=0;i<5;i++){
            manager.submitOrder("Book",1);
        }
    });
    Thread t2=new Thread(()->{
        for(int i=0;i<5;i++){
            manager.submitOrder("Toy",2);
        }
    });

    System.out.println("Hello ");

    t1.start();
    t2.start();

    t1.join();
    t2.join();

    Thread.sleep(3000);

    manager.printSummaryReport();
    System.out.println("Hello everyOne!!");


}
