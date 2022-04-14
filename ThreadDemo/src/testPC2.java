public class testPC2 {
    public static void main(String[] args) {
        TV tv = new TV();
        new Player(tv).start();
        new Watcher(tv).start();

    }

}

class Player extends Thread {
TV tv = new TV();
    public Player(TV tv){
        this.tv = tv;
    }

    @Override
    public void run() {
        for (int i = 0; i < 20; i++) {
            if(i % 2 == 0){
                try {
                    this.tv.play("Happy camping house is coming!");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }else{
                try {
                    this.tv.play("ticktok: recoding your happy life!");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}

class Watcher extends Thread {
    TV tv = new TV();
    public Watcher(TV tv){
        this.tv = tv;
    }

    @Override
    public void run() {
        for (int i = 0; i < 20; i++) {
            tv.watch();
        }
    }
}

class TV extends Thread {
    String voice;
    boolean flag = true;

    public synchronized void play(String voice) throws InterruptedException {
        if(!flag){
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("Player is singing: " + voice);
        this.notifyAll();
        this.voice = voice;
        this.flag = !this.flag;
    }

    public synchronized void watch() {
        if (flag) {
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("Audiences are watching: " + voice);
        this.notifyAll();
        this.flag = !this.flag;
    }
}