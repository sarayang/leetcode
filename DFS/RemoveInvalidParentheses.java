package DFS;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by YANGSONG on 2018-10-04.
 */
public class RemoveInvalidParentheses {
    public List<String> removeInvalidParentheses(String s) {
        int len = s.length();
        List<String> res = new ArrayList<>();
        if (len == 0) {
            res.add("");
            return res;
        }

        // this method will get the number of invalid left parenthese and right one.
        // save the value in an array. index 0 indicates the invalid left parenthese number,
        // index 1 indicates the right one.
        int[] leftAndRight = getLeftAndRight(s);
        dfs(s, leftAndRight[0], leftAndRight[1], 0, res);
        return res;
    }

    private void dfs(String s, int left, int right, int start, List<String> res) {
        if (left == 0 && right == 0 && isValid(s)) {
            res.add(s);
            return;
        }

        for (int i = start; i < s.length(); i++) {
            if (i > 0 && s.charAt(i) == s.charAt(i - 1)) {
                continue;
            }

            if (s.charAt(i) == '(' && left > 0) {
                dfs(s.substring(0, i) + s.substring(i + 1, s.length()), left - 1, right, i, res);
            }

            if (s.charAt(i) == ')' && right > 0) {
                dfs(s.substring(0, i) + s.substring(i + 1, s.length()), left, right - 1, i, res);
            }
        }
    }


    private boolean isValid(String s) {
        // char[] chas = s.toCharArray();
        // Deque<Character> stack = new LinkedList<>();
        // for (char c : chas) {
        //     if (c == '(') {
        //         stack.offer(c);
        //     }
        //     if (c == ')') {
        //         stack.pollLast();
        //     }
        // }
        // return stack.isEmpty();
        int[] result = getLeftAndRight(s);
        return result[0] == 0 && result[1] == 0;
    }

    private int[] getLeftAndRight(String s) {
        int[] res = new int[2];
        res[0] = 0;
        res[1] = 0;
        if (s.length() == 0) {
            return res;
        }

        char[] chas = s.toCharArray();
        for (char c : chas) {
            if (c == '(') {
                res[0]++;
            }

            if (c == ')') {
                if (res[0] > 0) {
                    res[0]--;
                } else {
                    res[1]++;
                }
            }
        }

        return res;
    }
}
