package part1;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class QuestionZou2_1 {
    class Point {
        int x, y;

        Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    int removeObstacle(int numRows, int numColumns, List<List<Integer>> lot) {
        if (lot == null || lot.size() == 0 || lot.get(0).size() == 0) {
            return -1;
        }

        int[] directionX = {1, 0, -1, 0};
        int[] directionY = {0, 1, 0, -1};

        Queue<Point> queue = new LinkedList<>();
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
                    Point point = new Point(x, y);
                    if (isValid(lot, x, y)) {
                        queue.offer(point);
                        if (lot.get(currentP.x).get(currentP.y) == 1) {
                            lot.get(currentP.x).set(currentP.y, 0);
                        }
                    }
                }
            }
            steps += 1;
        }

        return -1;
    }

    private boolean isValid(List<List<Integer>> lot, int x, int y) {
        int m = lot.size();
        int n = lot.get(0).size();
        return x >= 0 && x < m && y >= 0 && y < n && lot.get(x).get(y) != 0;
    }

}
