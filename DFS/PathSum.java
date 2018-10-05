package DFS;

/**
 * Created by YANGSONG on 2018-10-04.
 */
public class PathSum {
    public boolean hasPathSum(TreeNode root, int sum) {
        if (root == null) {
            return false;
        }

        return helper(root, sum);
    }

    public boolean helper(TreeNode root, int sum) {
        if (root == null) {
            return false;
        }
        if (root.left == null && root.right == null) {
            return root.val == sum;
        }

        return helper(root.left, sum - root.val) || helper(root.right, sum - root.val);


    }
}
