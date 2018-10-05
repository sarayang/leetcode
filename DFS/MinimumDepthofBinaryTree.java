package DFS;

/**
 * Created by YANGSONG on 2018-10-04.
 */
public class MinimumDepthofBinaryTree {
    int min = Integer.MAX_VALUE;
    public int minDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }

        helper(root, 0);
        return min;
    }
    private void helper(TreeNode node, int height) {
        if (node == null) {
            return;
        }

        if (node != null && node.left == null && node.right == null) {
            min = Math.min(min, height + 1);
            return;
        }

        height = height + 1;
        helper(node.left, height);
        helper(node.right, height);
    }
}
