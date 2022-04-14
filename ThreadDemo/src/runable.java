
public class runable implements Runnable {

    private int ticketNum = 10;
    @Override
    public void run() {
        while(true){
            if(ticketNum <= 0){
                break;
            }
            try {
                Thread.sleep(200);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName() + " get the ticket number: " + ticketNum--);
        }
    }

    public static void main(String[] args) {
        runable tic = new runable();
        new Thread(tic, "Jack").start();
        new Thread(tic, "Allen").start();
        new Thread(tic, "White").start();

    }
}
