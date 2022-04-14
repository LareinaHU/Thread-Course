public class getPriority {
    public static void main(String[] args) {

        System.out.println(Thread.currentThread().getName() + "-->" + Thread.currentThread().getPriority());

        MyPriority p = new MyPriority();

        Thread t1 = new Thread(p);
        Thread t2 = new Thread(p);
        Thread t3 = new Thread(p);
        Thread t4 = new Thread(p);

        //先设置优先级，再启动
        t1.start();
        t2.setPriority(8);
        t2.start();
        t3.setPriority(4);
        t3.start();
        t4.setPriority(Thread.MAX_PRIORITY);
        t4.start();

    }

    static class MyPriority implements Runnable {

        @Override
        public void run() {
            System.out.println(Thread.currentThread().getName() + "-->" + Thread.currentThread().getPriority());
        }
    }
}
