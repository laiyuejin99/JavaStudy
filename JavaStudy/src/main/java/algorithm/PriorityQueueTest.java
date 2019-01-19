package algorithm;

import java.util.Comparator;
import java.util.PriorityQueue;

public class PriorityQueueTest {
    public static void main(String args[]) {
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                if (o1 >= o2) {
                    return 1;
                } else {
                    return -1;
                }
            }
        });
        priorityQueue.add(1);
        priorityQueue.add(1);
        priorityQueue.add(55);
        priorityQueue.add(2);
        priorityQueue.add(33);

        while (!priorityQueue.isEmpty()) {
            System.out.print(priorityQueue.poll() + "  ");
        }
    }

}
