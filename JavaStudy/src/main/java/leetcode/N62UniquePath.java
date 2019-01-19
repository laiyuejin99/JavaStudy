package leetcode;

public class N62UniquePath {
    public int uniquePaths(int m, int n) {
        int[][] area = new int[m][n];
        area[0][0] = 1;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (j - 1 >= 0) {
                    area[i][j] += area[i][j - 1];
                }
                if (i - 1 >= 0) {
                    area[i][j] += area[i - 1][j];
                }
            }
        }
        return area[m - 1][n - 1];
    }

    public static void main(String args[]) {
        System.out.println(new N62UniquePath().uniquePaths(3, 2));
    }

    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        return helper(obstacleGrid,0,0);
    }

    public int helper(int[][] obstacleGrid, int i, int j) {
        if (i > obstacleGrid.length || j > obstacleGrid[0].length) return 0;
        if (obstacleGrid[i][j] == 1) return 0;
        if (i == obstacleGrid.length - 1 && j == obstacleGrid[0].length-1) return 1;
        int left = helper(obstacleGrid, i + 1, j);
        int right = helper(obstacleGrid, i, j + 1);
        return left + right;
    }
}
