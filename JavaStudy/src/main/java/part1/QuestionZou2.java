package part1;

import java.util.*;


public class QuestionZou2 {
    /**
     * You are in charge of preparing a recently purchased lot for one of amamzon't new building.
     * The lot is covered with trenches and has a single obstacle that needs to be taken down before the foundation
     * can be prepared for the building. the demoition robot must remove the obstacle before progress can be made one the building
     *
     * write an algorithm to determine the minimum distance required for the demoition robot to remove the obstacle
     * Assumptions:
     * the lot is flat, except for trenches and can be represent as 2D grid.
     * the demoition robot must start from the top-left corner of the lot. which is always flat and can move one block up down,left or right at a time.
     *
     * The robot can't enter trenches and can't leave the lot.
     * flat are  = 1, trenches = 0 obstacle = 9
     * @param numRows
     * @param numColums
     * @param lot
     * @return
     */
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
        List<Integer> item3 = new ArrayList<>();
        item3.add(1);
        item3.add(9);
        item3.add(1);
        result.add(item3);
        System.out.println(removeObstacle(3, 3, result));
    }
}
