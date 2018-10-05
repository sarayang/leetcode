package DFS;

/**
 * Created by YANGSONG on 2018-10-04.
 */
public class NumberofIslands {
    public int numIslands(char[][] grid) {
        int rows = grid.length;
        if (rows == 0) {
            return 0;
        }

        int cols = grid[0].length;
        if (cols == 0) {
            return 0;
        }

        int count = 0;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (grid[i][j] == '1') {
                    dfs(i, j, grid);
                    count++;
                }
            }
        }

        return count;
    }

    private void dfs(int x, int y, char[][] grid) {
        if (x < 0 || x > grid.length - 1 || y < 0 || y > grid[0].length - 1) {
            return;
        }
        System.out.println(x + "," + y);
        if (grid[x][y] == '1') {
            grid[x][y] = '0';
            dfs(x - 1, y, grid);
            dfs(x + 1, y, grid);
            dfs(x, y - 1, grid);
            dfs(x, y + 1, grid);
        }
    }

    public static void main(String[] args) {
        NumberofIslands n = new NumberofIslands();
        char[][] island = {{'1','1','0','0','0'},{'1','1','0','0','0'},{'0','0','1','0','0'},{'0','0','0','1','1'}};
        int c = n.numIslands(island);
//        System.out.println(c);

        String s = "yangsong";
        StringBuilder ss = new StringBuilder();
        for (int i = 0; i < 3; i ++) {
            ss.append(s);
        }
        System.out.println(ss.toString());
    }
}
