package part1;

import java.util.*;

public class FlatFields {
//    public int flatFields (int numRows, int numColumns, List<List<Integer>> fields) {
//
//    }

    public static int cutTreeInGolf(int[][] golf) {
        // corner case
        if (golf == null || golf.length == 0 || golf[0].length == 0) return 0;
        // put all tree and corresponding point into min heap
        int row = golf.length;
        int col = golf[0].length;
        PriorityQueue<Integer> pq = new PriorityQueue<Integer>();
        HashMap<Integer, Point> map = new HashMap<Integer, Point>();
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (golf[i][j] > 1) { //means this point is a tree
                    pq.offer(golf[i][j]);
                    map.put(golf[i][j], new Point(i, j));
                }
            }
        }

        int res = 0;
        // get the effective element form pq one by one
        Point src = new Point(row-1, col-1);
        while (!pq.isEmpty()) {
            int treeHigh = pq.poll();
            Point tar = map.get(treeHigh);
            int currdistance = bfsFindDistance(golf, src, tar, treeHigh);
            if (currdistance != -1) {
                res += treeHigh + currdistance;
                // set the cutted tree as ground as 1
                golf[tar.x][tar.y] = 1;
                src = tar;
            } else {
                return -1;
            }
        }

        return res;
    }

    public static int bfsFindDistance(int[][] golf, Point src, Point tar, int height) {
        if(golf == null || golf.length == 0) return 0;

        int row = golf.length;
        int col = golf[0].length;
        boolean[][] visited = new boolean[row][col];
        if( !isValidGolfPlace(golf, visited, src.x, src.y, height) ) return -1;
        if( !isValidGolfPlace(golf, visited, tar.x, tar.y, height) ) return -1;
        int[] direcx = {-1,0,1,0};
        int[] direcy = {0,-1,0,1};
        PointNode root = new PointNode(new Point(src.x, src.y), 0);
        visited[src.x][src.y] = true;
        Queue<PointNode> queue = new LinkedList<PointNode>();
        queue.add(root);
        while(!queue.isEmpty()) {
            int size = queue.size();
            for(int i = 0; i < size; i++) {
                PointNode temp = queue.poll();
                //find a matched solution
                if(temp.pt.x == tar.x && temp.pt.y == tar.y) return temp.dist;
                for(int j = 0; j < 4; j++) {
                    // tranverse point is valid
                    if(isValidGolfPlace(golf, visited, temp.pt.x+direcx[j], temp.pt.y+direcy[j], height)) {
                        int rowtemp = temp.pt.x+direcx[j];
                        int coltemp = temp.pt.y+direcy[j];
                        visited[rowtemp][coltemp] = true;
                        PointNode qadd = new PointNode(new Point(rowtemp, coltemp), temp.dist+1);
                        queue.offer(qadd);
                    }
                }
            }
        }
        return -1;
    }
    public static boolean isValidGolfPlace(int[][] golf, boolean[][] visited, int row, int col, int height) {
        int m = golf.length;
        int n = golf[0].length;
        return row >= 0 && row < m && col >= 0 && col < n
                                && (golf[row][col] == 1 || golf[row][col] == height) && visited[row][col] == false;
    }

    static class Point {
        int x;
        int y;
        Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
    static class PointNode {
        Point pt;
        int dist;
        PointNode(Point pt, int dist) {
            //this.x = x;
            this.pt = pt;
            this.dist = dist;
        }
    }
}
