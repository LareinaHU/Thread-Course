public class FightingGame implements Runnable{


    private static String winner;
    @Override
    public void run() {
        for (int i = 0; i <= 500; i++) {
//            if(Thread.currentThread().getName().equals("gray")){
//                try {
//                    Thread.sleep(10);
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
//            }
            System.out.println(Thread.currentThread().getName() + " is beating." + i);
            boolean flag = gameOver(i);
            if(flag){
                break;
            }
        }
    }
    private boolean gameOver(int i){
        if(winner != null){
            return true;
        }
        if(i >= 500){

            winner = Thread.currentThread().getName();
            System.out.println("winner is : " + winner);
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        FightingGame fight = new FightingGame();
        new Thread(fight, "white").start();
        new Thread(fight, "gray").start();
    }
}
