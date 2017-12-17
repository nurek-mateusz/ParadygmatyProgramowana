package mergesort;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.RecursiveTask;

public class MergeSort extends RecursiveTask<List<Integer>> {

    private List<Integer> elements = new ArrayList<>();

    public MergeSort(List<Integer> elements) {
        this.elements = elements;
    }

    @Override
    protected List<Integer> compute() {

        int size = elements.size();
        if(size > 2) {
            int firstHalf = size / 2;
            MergeSort task1 = new MergeSort(elements.subList(0, firstHalf));
            MergeSort task2 = new MergeSort(elements.subList(firstHalf, size));

            task1.fork();
            task2.fork();

            List<Integer> task1List = task1.join();
            List<Integer> task2List = task2.join();

            List<Integer> partialResult = new ArrayList<>();
            partialResult.addAll(task1List);
            partialResult.addAll(task2List);
            partialResult.sort((a,b) -> a-b);
            return partialResult;
        } else {
            elements.sort((a,b) -> a-b);
        }

        return elements;
    }
}
