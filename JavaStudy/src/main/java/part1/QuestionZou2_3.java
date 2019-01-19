package part1;

import java.util.*;

public class QuestionZou2_3 {


    class Point {
        int x, y;

        Point(int x, int y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public boolean equals(Object obj) {
            if (obj == null || !(obj instanceof Point)) {
                return false;
            }
            Point point2 = (Point) obj;
            if (x == point2.x && y == point2.y)
                return true;
            return false;
        }

        @Override
        public int hashCode() {
            return (x + "," + y).hashCode();
        }
    }

    /**
     * You are in charge of preparing a recently purchased lot for one of amamzon't new building.
     * The lot is covered with trenches and has a single obstacle that needs to be taken down before the foundation
     * can be prepared for the building. the demoition robot must remove the obstacle before progress can be made one the building
     * <p>
     * write an algorithm to determine the minimum distance required for the demoition robot to remove the obstacle
     * Assumptions:
     * the lot is flat, except for trenches and can be represent as 2D grid.
     * the demoition robot must start from the top-left corner of the lot. which is always flat and can move one block up down,left or right at a time.
     * <p>
     * The robot can't enter trenches and can't leave the lot.
     * flat are  = 1, trenches = 0 obstacle = 9
     *
     * @param numRows
     * @param numColumns
     * @param lot
     * @return
     */
    int removeObstacle(int numRows, int numColumns, List<List<Integer>> lot) {
        if (lot == null || lot.size() == 0 || lot.get(0).size() == 0) {
            return -1;
        }
        //direction
        int[] directionX = {1, 0, -1, 0};
        int[] directionY = {0, 1, 0, -1};

        int height = lot.size();
        int width = lot.size();

        HashSet<Point> hashSet = new HashSet<>();
        Queue<Point> queue = new LinkedList<>();
        hashSet.add(new Point(0, 0));
        queue.offer(new Point(0, 0));
        int steps = 0;

        while (!queue.isEmpty()) {
            int level = queue.size();
            for (int k = 0; k < level; k++) {
                Point currentP = queue.poll();
                if (lot.get(currentP.x).get(currentP.y) == 9) {
                    return steps;
                }
                for (int i = 0; i < 4; i++) {
                    int x = currentP.x + directionX[i];
                    int y = currentP.y + directionY[i];
                    if (!isValidPoint(height, width, x, y) || hashSet.contains(new Point(x, y)) || lot.get(x).get(y) == 0) {
                        continue;//is not a point which can access.
                    }
                    Point point = new Point(x, y);
                    queue.offer(point);
                }
            }
            steps += 1;
        }
        return -1;
    }

    private boolean isValidPoint(int h, int w, int x, int y) {
        return x >= 0 && x < h && y >= 0 && y < w;
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
        System.out.println(new QuestionZou2_3().removeObstacle(3, 3, result));
    }
}
