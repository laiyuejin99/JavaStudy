package part1;

import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;

public class MazeTest {

    //意思是说有一个M*N的maze，0代表可以通过，1代表不可以通过，然后给你一个出口（x,y），找从（0,0）到出口的最少steps，如果找不到path就返回-1
    private static int[][] mazeMatrix2 = {
            {0, 1, 1, 1, 1, 1, 1, 1, 0, 1},
            {0, 0, 0, 0, 0, 0, 1, 0, 0, 1},
            {0, 1, 0, 1, 1, 0, 1, 1, 0, 1},
            {0, 1, 0, 0, 0, 0, 0, 0, 0, 0},
            {1, 1, 0, 1, 1, 0, 1, 1, 1, 1},
            {0, 0, 0, 0, 1, 0, 0, 0, 0, 1},
            {1, 1, 1, 1, 1, 1, 1, 1, 0, 1},
            {0, 0, 1, 1, 0, 0, 0, 0, 0, 0},
            {1, 1, 1, 1, 1, 0, 1, 1, 1, 0},
            {0, 0, 0, 0, 1, 0, 0, 0, 1, 1}
    };
    private static int[] xdirection = {1, 0, -1, 0};
    private static int[] ydirection = {0, 1, 0, -1};

    public int findSteps(int[][] maze, int dx, int dy) {
        int result = -1;
        int hight = maze.length;
        int width = maze[0].length;
        int[][] mazeT = new int[hight][width];
        mazeT[0][0] = 1;
        Queue<Point> queue = new LinkedList<>();
        queue.add(new Point(0, 0));
        while (!queue.isEmpty()) {
            Point point = queue.poll();
            for (int i = 0; i < 4; i++) {
                int xp = point.getX() + xdirection[i];
                int yp = point.getY() + ydirection[i];
                if (xp == dx && yp == dy) {//destination
                    if(maze[dx][dy]== 1) return -1;
                    return mazeT[point.getX()][point.getY()] + 1;
                }
                if (0 <= xp && xp < hight && 0 <= yp && yp < width && maze[xp][yp] != 1) {
                    queue.add(new Point(xp, yp));
                    mazeT[xp][yp] = mazeT[point.getX()][point.getY()] + 1;
                }
            }
        }


        return result;
    }

    public static void main(String[] args) {
        int res = new MazeTest().findSteps(mazeMatrix2, 6, 8);
        System.out.println(res);
    }


    private static final int INF = 100000;
    private static final int N = 10;
    private static final int M = 10;
    private static char[][] mazeMatrix = {
            {'#', 'S', '#', '#', '#', '#', '#', '#', 'o', '#'},
            {'o', 'o', 'o', 'o', 'o', 'o', '#', 'o', 'o', '#'},
            {'o', '#', 'o', '#', '#', 'o', '#', '#', 'o', '#'},
            {'o', '#', 'o', 'o', 'o', 'o', 'o', 'o', 'o', 'o'},
            {'#', '#', 'o', '#', '#', 'o', '#', '#', '#', '#'},
            {'o', 'o', 'o', 'o', '#', 'o', 'o', 'o', 'o', '#'},
            {'#', '#', '#', '#', '#', '#', '#', '#', 'o', '#'},
            {'o', 'o', 'o', '#', 'o', 'o', 'o', 'o', 'o', 'o'},
            {'o', '#', '#', '#', '#', 'o', '#', '#', '#', 'o'},
            {'o', 'o', 'o', 'o', '#', 'o', 'o', 'o', 'G', '#'}
    };
    private static int xs = 0;
    private static int ys = 1;
    private static int xe = 9;
    private static int ye = 8;
    private static int[][] distance = new int[N][M];

    private static int[] xd = {1, 0, -1, 0};
    private static int[] yd = {0, 1, 0, -1};


    private int bfs() {
        Queue<Point> que = new ConcurrentLinkedQueue<Point>();
        que.add(new Point(xs, ys));
        distance[xs][ys] = 0;
        while (que.size() > 0) {
            Point point = que.poll();
            if (point.getX() == xe && point.getY() == ye) {
                break;
            }
            for (int i = 0; i < 4; i++) {
                int xp = point.getX() + xd[i];
                int yp = point.getY() + yd[i];
                if (0 <= xp && xp < N && 0 <= yp && yp < M && mazeMatrix[xp][yp] != '#' && distance[xp][yp] == INF) {
                    que.add(new Point(xp, yp));
                    distance[xp][yp] = distance[point.getX()][point.getY()] + 1;
                }
            }
        }
        return distance[xe][ye];
    }

    private static void initDistance() {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                distance[i][j] = INF;
            }
        }
    }

    private static void printDistance() {
        for (int i = 0; i < N; i++) {
            System.out.println();
            for (int j = 0; j < M; j++) {
                System.out.print("\t\t" + distance[i][j]);
            }
        }
    }

    class Point {
        int x;
        int y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }

        public int getX() {
            return x;
        }

        public int getY() {
            return y;
        }

        public void setX(int x) {
            this.x = x;
        }

        public void setY(int y) {
            this.y = y;
        }
    }
}