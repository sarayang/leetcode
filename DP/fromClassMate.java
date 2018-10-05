package DP;

import java.util.Arrays;

/**
 * Created by YANGSONG on 2018-09-30.
 * Google的一个面试题，有一些推送广告收费的值和其时间，求可能的最大和的值，但不能太频繁会影响客户体验，不能小于7分钟。
 * 例子： 时间和广告费pair （0，1）， （6， 5）， （8， 11）， （14， 100）， （16， 300） 应该选时间0，8，16，返回1 + 11 + 300 = 312 这个动归题还是滑窗，怎么想方程
 */
public class fromClassMate {
    public int maxAds(int[][] inputs) {
        int rows = inputs.length;
        if (rows == 0) {
            return 0;
        }
        int cols = inputs[0].length;
        if (cols == 0) {
            return 0;
        }

        // 1 sort the input array based on the time ( we assume it sorted already here)
        int[] f = new int[inputs[rows - 1][0] + 1];

        for (int i = 0; i < f.length; i++) {
            f[i] = -1;
        }
        if (inputs[0][0] == 0) {
            f[0] = inputs[0][1];
        } else {
            f[0] = 0;
        }

        for (int i = 1; i < f.length; i++) {
            for (int[] tuple : inputs) {
                int index = tuple[0];
                if (i != index) {
                    continue;
                }
                int value = tuple[1];
                if (i - 7 >= 0) {
                    f[i] = Math.max(f[i - 7] + value, f[i - 1]);
                } else {
                    f[i] = Math.max(value, f[i - 1]);
                }
            }
            if (f[i] == -1) {
                f[i] = f[i - 1];
            }
        }
        System.out.println(Arrays.toString(f));
        return f[f.length - 1];
    }

    public static void main(String[] args) {
        fromClassMate f = new fromClassMate();
        int[][] test = {{2, 1},
                        {6, 100},
                        {8, 11},
                        {14, 100},
                        {16, 300}};

        int res = f.maxAds(test);
        System.out.println(res);

    }
}
