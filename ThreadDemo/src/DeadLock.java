public class DeadLock {
    public static void main(String[] args) {
        Makeup g1 = new Makeup(0, " little girl");
        Makeup g2 = new Makeup(1, "princess");
        g1.start();
        g2.start();
    }

}

class Lipstick {

}

class Mirror {

}

class Makeup extends Thread {

    static Lipstick lipstick = new Lipstick();
    static Mirror mirror = new Mirror();
    int choice;
    String girlName;

    Makeup(int choice, String name) {
        this.choice = choice;
        this.girlName = name;
    }

    @Override
    public void run() {
        try {
            makeup();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private void makeup() throws InterruptedException {
        if (choice == 0) {
            synchronized (lipstick) {
                System.out.println(this.girlName + " get the lipstick lock!");
                Thread.sleep(1000);
            }
            synchronized (mirror) {
                System.out.println(this.girlName + " get the mirror lock!");

            }
        } else {
            synchronized (mirror) {
                System.out.println(this.girlName + " get the mirror lock!");
                Thread.sleep(2000);
            }
            synchronized (lipstick) {
                System.out.println(this.girlName + " get the lipstick lock!");
            }
        }
    }
}
