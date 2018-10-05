package DFS;

/**
 * Created by YANGSONG on 2018-10-04.
 */
public class MaxAreaofIsland {
    int[] xAxis = {1, -1, 0, 0};
    int[] yAxis = {0, 0, -1, 1};
    public int maxAreaOfIsland(int[][] grid) {
        int max = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                int area = getArea(grid, i, j);
                max = Math.max(max, area);
            }
        }
        return max;
    }

    private int getArea(int[][] grid, int x, int y) {
        if (x < 0 || x > grid.length - 1 || y < 0 || y > grid[0].length - 1) {
            return 0;
        }
        if (grid[x][y] == 0) {
            return 0;
        }

        grid[x][y] = 0;

        int down = getArea(grid, x + 1, y);
        int up = getArea(grid, x -1, y);
        int left = getArea(grid, x, y - 1);
        int right = getArea(grid, x, y + 1);

        return 1 + down + up + left + right;

    }
}
