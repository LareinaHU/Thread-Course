public class testState {
    public static void main(String[] args) throws InterruptedException {
        Thread thread = new Thread(() ->
        {
            for (int i = 0; i < 5; i++) {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

            }
            System.out.println("//////");
        });
        Thread.State state = thread.getState();
        System.out.println(state);  //new

        thread.start();
        state = thread.getState();
        System.out.println(state); //run

        while(state != Thread.State.TERMINATED){
            thread.sleep(100);
            state = thread.getState();
            System.out.println(state);



        }
    }
}
