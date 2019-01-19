package part1;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class QuestionZou21 {
    class Coordinate {
        int x, y;

        Coordinate(int x, int y) {
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

        Queue<Coordinate> queue = new LinkedList<>();
        queue.offer(new Coordinate(0, 0));
        int steps = 0;

        while (!queue.isEmpty()) {
            int level = queue.size();
            for (int k = 0; k < level; k++) {
                Coordinate coor = queue.poll();
                if (lot.get(coor.x).get(coor.y) == 9) {
                    return steps;
                }
                for (int i = 0; i < 4; i++) {
                    int x = coor.x + directionX[i];
                    int y = coor.y + directionY[i];
                    Coordinate c = new Coordinate(x, y);
                    if (isValid(lot, x, y)) {
                        queue.offer(c);
                        if (lot.get(coor.x).get(coor.y) == 1) {
                            lot.get(coor.x).set(coor.y, 0);
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
