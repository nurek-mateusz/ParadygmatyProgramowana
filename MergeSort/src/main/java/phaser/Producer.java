package phaser;

import java.util.Queue;
import java.util.concurrent.Phaser;

public class Producer implements Runnable {

    Queue<String> productQueue;
    private Phaser phaser;
    private String name;

    public Producer(Queue<String> productQueue, Phaser phaser, String name) {
        this.productQueue = productQueue;
        this.phaser = phaser;
        this.name = name;
        new Thread(this).start();
    }

    @Override
    public void run() {
        for(int i = 0; i < 5; ++i) {
            System.out.println("Producer " + name + " produced product " + i);
            productQueue.add("Product " + i + " producer " + name);
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        phaser.arriveAndDeregister();
    }

}
