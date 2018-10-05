package DFS;

/**
 * Created by YANGSONG on 2018-10-04.
 */
public class BinaryTreeMaximumPathSum {
    int max = Integer.MIN_VALUE;
    public int maxPathSum(TreeNode root) {
        if (root == null) {
            return 0;
        }
        getMaxSum(root);
        return max;
    }

    private int getMaxSum(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int val = root.val;
        int left = getMaxSum(root.left);
        int right = getMaxSum(root.right);
        max = Math.max(val + right + left, max);

        if (left < 0 && right < 0) {
            max = Math.max(val, max);
            return val;
        }

        if (left < 0) {
            max = Math.max(val + right, max);
            return val + right;
        }

        if (right < 0) {
            max = Math.max(val + left, max);
            return val + left;
        }
        return Math.max(left, right) + val;
    }
}
