package DFS;

/**
 * Created by YANGSONG on 2018-10-04.
 */
public class FriendCircles {
    public int findCircleNum(int[][] M) {
        int people = M.length;
        if (people == 0) {
            return 0;
        }
        int friends = M[0].length;
        if (friends == 0) {
            return 0;
        }


        int[] visited = new int[people];
        int cycles = 0;
        for (int i = 0; i < people; i++) {
            if (visited[i] == 0) {
                dfs(i, M, visited);
                cycles++;

            }

        }
        return cycles;
    }


    private void dfs(int person, int[][] relation, int[] visited) {
        for (int i = 0; i < relation[0].length; i++) {
            if (relation[person][i] == 1 && visited[i] != 1) {
                visited[i] = 1;
                dfs(i, relation, visited);
            }
        }
    }
}
