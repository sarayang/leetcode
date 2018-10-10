package DP;

/**
 * Created by YANGSONG on 2018-10-08.
 */
public class UniqueBinarySearchTrees {
    //G(n)=∑(i=1~n)F(i,n)  ---> here G(n) means f[n] in the below method
    // G[0] = 1, G[1] = 1
    public int numTrees(int n) {
        if (n == 0) {
            return 0;
        }

        int[] f = new int[n + 1];
        f[0] = 1;
        for (int i = 1; i < n + 1; i++) {
            for (int j = 0; j < i; j++) {
                f[i] += f[j] * f[i - j - 1];
            }
        }
        return f[n];
    }
}
