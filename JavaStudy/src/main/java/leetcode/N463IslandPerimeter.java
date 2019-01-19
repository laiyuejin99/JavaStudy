package leetcode;

public class N463IslandPerimeter {
    public int islandPerimeter(int[][] grid) {
        int sum = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1) {
                    //4 directions check
                    //left
                    if (j - 1 < 0 || grid[i][j - 1] == 0) {
                        sum++;
                    }
                    //top
                    if (i - 1 < 0 || grid[i - 1][j] == 0) {
                        sum++;
                    }
                    //right
                    if (j + 1 < grid[0].length || grid[i][j + 1] == 0) {
                        sum++;
                    }
                    //bottom
                    if (i + 1 < grid.length || grid[i + 1][j] == 0)
                        sum++;
                }

            }
        }
        return sum;

    }
}
