package mergesort;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ForkJoinPool;

public class Application {

    public static void main(String[] args) {

        List<Integer> numbers = new ArrayList<>();
        numbers.add(4);
        numbers.add(2);
        numbers.add(7);
        numbers.add(6);
        numbers.add(1);
        numbers.add(8);
        numbers.add(5);
        numbers.add(0);
        numbers.add(3);
        numbers.add(9);

        ForkJoinPool pool = new ForkJoinPool();

        MergeSort mergeSort = new MergeSort(numbers);

        List<Integer> result = pool.invoke(mergeSort);

        System.out.println(result);
    }

}
