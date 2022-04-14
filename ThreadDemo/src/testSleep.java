public class testSleep {
    public void TenDown() throws InterruptedException {
        int num = 10;
        while (num > 0) {
        Thread.sleep(1000);
            System.out.println("TenDown: " + num--);
        }
    }

    public static void main(String[] args) throws InterruptedException {
        testSleep ten = new testSleep();
        ten.TenDown();
      //  new Thread((Runnable) ten).start();


    }
}
