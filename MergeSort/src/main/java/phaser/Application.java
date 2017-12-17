package phaser;

import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedDeque;
import java.util.concurrent.Phaser;

public class Application {

    public static void main(String[] args) {

        Queue<String> productList = new ConcurrentLinkedDeque<>();

        Phaser phaser = new Phaser(5);

        Producer producer1 = new Producer(productList, phaser, "producer1");
        Producer producer2 = new Producer(productList, phaser, "producer2");
        Producer producer3 = new Producer(productList, phaser, "producer3");
        Consumer consumer1 = new Consumer(productList, phaser, "consumer1");
        Consumer consumer2 = new Consumer(productList, phaser, "consumer2");
    }

}
