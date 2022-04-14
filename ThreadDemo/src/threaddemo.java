

//继承thread类， override run(),调用start() 开启线程

public class threaddemo extends Thread {
    @Override
    public void run(){
        for (int i = 0; i < 10; i++) {
            System.out.println("run:" + i);
        }
    }

    public static void main(String[] args) {

        threaddemo th1 = new threaddemo();
        th1.start();  // th1.run(); 如果调用run， 则会先执行完run，再继续执行以下代码。 如果调用start， 则线程同时进行。
        for (int i = 0; i < 20; i++) {
            System.out.println("main:" + i);
        }
    }
}
