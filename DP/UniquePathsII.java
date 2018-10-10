package DP;

/**
 * Created by YANGSONG on 2018-10-10.
 */
public class UniquePathsII {
    public int uniquePathsWithObstacles(int[][] grid) {
        //transition funtion shoule be
        // f[i][j] = f[i - 1][j] (if obstacleGrid[i -1][j] != 1) + f[i][j - 1];
        int rows = grid.length;
        if (rows == 0) {
            return 0;
        }

        int cols = grid[0].length;
        if (cols == 0) {
            return 0;
        }

        int[][] f = new int[rows][cols];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                f[i][j] = 0;
                if (grid[i][j] == 1) {
                    continue;
                }

                if (i == 0 && j == 0) {
                    f[i][j] = 1;
                }

                if (i > 0) {
                    f[i][j] += f[i - 1][j];
                }

                if (j > 0) {
                    f[i][j] += f[i][j - 1];
                }
            }
        }
        return f[rows - 1][cols - 1];

    }
}
