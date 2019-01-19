package part1;

import java.util.*;


public class QuestionZou2 {
    public static int removeObstacle(int numRows, int numColums, List<List<Integer>> lot) {
        if (lot == null || lot.size() == 0)
            return -1;

        int step = 0;
        LinkedList<Integer> lotQueue = new LinkedList<>();
        Set<Integer> visitedSet = new HashSet<>();
        visitedSet.add(0);
        lotQueue.add(0);

        while (!lotQueue.isEmpty()) {
            int queueSize = lotQueue.size();
            for (int i = 0; i < queueSize; i++) {
                int value = lotQueue.pollFirst();// value = numColums*row+ colums;
                int x = value / numColums;
                int y = value % numColums;

                if (lot.get(x).get(y) == 9) {
                    return step;
                }
                visitedSet.add(numColums * x + y);

                int downValue = numColums * (x + 1) + y; //go down value;
                if (x + 1 < numRows && lot.get(x + 1).get(y) != 0 && !visitedSet.contains(downValue)) { //go down
                    lotQueue.offer(downValue);
                }

                visitedSet.add(numColums * x + y);
                int upValue = numColums * (x - 1) + y; //go up value;
                if (x - 1 >= 0 && lot.get(x - 1).get(y) != 0 && !visitedSet.contains(upValue)) { //go up
                    lotQueue.offer(upValue);
                }

                int leftValue = numColums * x + y - 1; //go left value;
                if (y - 1 >= 0 && lot.get(x).get(y - 1) != 0 && !visitedSet.contains(leftValue)) { //go left
                    lotQueue.offer(leftValue);
                }

                int rightValue = numColums * x + y + 1; //go right value;
                if (y + 1 < numColums && lot.get(x).get(y + 1) != 0 && !visitedSet.contains(rightValue)) { //go right
                    lotQueue.offer(rightValue);
                }
            }
            step++;
        }
        return -1;
    }

    public static void main(String args[]) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> item = new ArrayList<>();
        item.add(1);
        item.add(0);
        item.add(0);
        result.add(item);
        List<Integer> item2 = new ArrayList<>();
        item2.add(1);
        item2.add(0);
        item2.add(0);
        result.add(item2);
//        List<Integer> item3 = new ArrayList<>();
//        item3.add(1);
//        item3.add(9);
//        item3.add(1);
//        result.add(item3);
        System.out.println(removeObstacle(2, 3, result));
    }
}
