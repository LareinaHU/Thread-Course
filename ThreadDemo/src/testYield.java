public class testYield {
    public static void main(String[] args) {
        myYield t = new myYield();
        new Thread(t, "a").start();
        new Thread(t,"b").start();
    }

}

class myYield implements Runnable{

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName() + " Thread is executing");
        Thread.yield();
        System.out.println(Thread.currentThread().getName() + " Thread is stopping.");
    }
}
