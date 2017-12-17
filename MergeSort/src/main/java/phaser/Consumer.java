package phaser;

import java.util.Queue;
import java.util.concurrent.Phaser;

public class Consumer implements Runnable {

    private Queue<String> productQueue;
    private Phaser phaser;
    private String name;

    public Consumer(Queue<String> productQueue, Phaser phaser, String name) {
        this.productQueue = productQueue;
        this.phaser = phaser;
        this.name = name;
        new Thread(this).start();
    }

    @Override
    public void run() {
        phaser.arriveAndAwaitAdvance();
        while(!productQueue.isEmpty()) {
            System.out.println("Consumer " + name + " consumed product " + productQueue.poll());
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        phaser.arriveAndDeregister();
    }

}
