package synchronized1;

public class unsafeSyn {
    public static void main(String[] args) {
        buyTicket buyTicket = new buyTicket();
        new Thread(buyTicket, "me").start();
        new Thread(buyTicket,"you").start();
        new Thread(buyTicket,"cow").start();

    }

}

class buyTicket implements Runnable {

    private int tickets = 10;
    boolean flag = true;
    @Override
    public void run() {
        while(flag){
            try {
                buy();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }
    }




    public synchronized  void buy() throws InterruptedException {
        if(tickets <= 0){
            flag = false;
            return;
        }

        Thread.sleep(100);
        System.out.println("Got one ticket！" + tickets--);
    }
}
