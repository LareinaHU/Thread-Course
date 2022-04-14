
//缓冲区 -》管程法
public class testPC {
    public static void main(String[] args) {
        SynContainer container = new SynContainer();
        new Processor(container).start();
        new Consumer(container).start();
    }

}

class Processor extends Thread{
    SynContainer container;
    public Processor(SynContainer container){
        this.container = container;
    }

    @Override
    public void run() {
        for (int i = 1; i <= 10; i++) {
            container.push(new chicken(i));
            System.out.println("Product the numbers of chickens: " + i);

        }
    }
}

class Consumer extends Thread{
    SynContainer container;
    public Consumer(SynContainer container){
        this.container = container;
    }

    @Override
    public void run() {
        for (int i = 1; i <= 10; i++) {
            System.out.println("Consumers bought the numbers of chickens" + container.pop().id);
        }
    }
}

class chicken{
    int id;

    public chicken(int id) {
        this.id = id;
    }
}

class SynContainer{
    chicken[] chickens = new chicken[10];
    int count = 0;

    public synchronized void push(chicken chicken){
        if(count == chickens.length){
            System.out.println("Please waiting for the chickens to be ready, to all consumers!");
        }

        chickens[count++] = chicken;
        this.notifyAll();
     //   System.out.println("You can buy fresh chickens now, to all consumers!");

    }

    public synchronized chicken pop(){
        if(count == 0){
            System.out.println("Waiting for the product!!");
        }
        count--;
        chicken chicken = chickens[count];
        System.out.println("You can product more chickens, to all processors!");
        return chicken;
    }
}