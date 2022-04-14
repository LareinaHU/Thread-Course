public class TestJoin implements Runnable {


    @Override
    public void run() {
        for (int i = 0; i < 40; i++) {
            System.out.println("Thread VIP is coming" + i);
        }
    }

    public static void main(String[] args) throws InterruptedException {
        TestJoin t = new TestJoin();
        Thread thread = new Thread(t);
        thread.start();

        for (int i = 0; i < 100; i++) {
            System.out.println(i);
            if(i == 50){
                thread.join();
            }
        }
    }
}