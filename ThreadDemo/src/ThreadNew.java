import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

public class ThreadNew {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        new MyThread1().start();
        new Thread(new MyThread2()).start();
        FutureTask<Integer> futureTask = new FutureTask<Integer>(new MyThread3());
        new Thread(futureTask).start();

        Integer integer = futureTask.get();
        System.out.println(integer);

    }

    static class MyThread1 extends Thread {
        @Override
        public void run() {
            System.out.println("My Thread1!");
        }
    }

    static class MyThread2 implements Runnable {

        @Override
        public void run() {
            System.out.println("My Thread2!");
        }
    }

    static class MyThread3 implements Callable<Integer> {

        @Override
        public Integer call() throws Exception {
            System.out.println("My Thread3!");
            return 100;
        }
    }
}
