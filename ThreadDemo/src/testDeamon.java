public class testDeamon {

    public static void main(String[] args) {


        God god = new God();
        You1 you = new You1();
        Thread thread = new Thread(god);
        thread.setDaemon(true);
        thread.start();
        new Thread(you).start();
    }
}

class God implements Runnable {

    @Override
    public void run() {
        while (true) {
            System.out.println("God bless you!");
        }

    }
}

class You1 implements Runnable {

    @Override
    public void run() {
        for (int i = 0; i < 36500; i++) {
            System.out.println("You live a happy life.");
        }
        System.out.println("Goodbye, World!");
    }
}
