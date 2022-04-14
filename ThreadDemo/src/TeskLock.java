import java.util.concurrent.locks.ReentrantLock;

public class TeskLock {
    public static void main(String[] args) {

        TestLock2 t1 = new TestLock2();
        new Thread(t1).start();
        new Thread(t1).start();
        new Thread(t1).start();
    }

    static class TestLock2 implements Runnable {

        int tickets = 10;

        private final ReentrantLock lock = new ReentrantLock();

        @Override
        public void run() {
            while (true) {
                try {
                    lock.lock();
                    if (tickets > 0) {
                        System.out.println("get the ticket" + tickets--);
                        try {
                            Thread.sleep(3000);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }

                    } else {
                        break;
                    }
                } finally {
                    lock.unlock();
                }
            }
        }
    }
}
