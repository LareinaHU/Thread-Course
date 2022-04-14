public class testStop implements Runnable {
    private boolean flag = true;

    @Override
    public void run() {
        int i = 0;
        while(flag){
            System.out.println("Thread is increasing" + i);
        }
    }

    public void stop(){
        this.flag = false;
    }
    public static void main(String[] args) {
        testStop t1 = new testStop();
        new Thread(t1).start();
        for(int i = 0; i < 50; i++){
            System.out.println(i);
            if(i == 3){
                t1.stop();
                System.out.println("Thread is stopping.");
            }
        }
    }
}
