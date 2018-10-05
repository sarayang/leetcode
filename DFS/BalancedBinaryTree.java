package DFS;

/**
 * Created by YANGSONG on 2018-10-04.
 */
public class BalancedBinaryTree {
    int NOT_BALANCED = -1;
    public boolean isBalanced(TreeNode root) {
        return getMaxHeight(root) != NOT_BALANCED;
    }

    private int getMaxHeight(TreeNode node) {
        if (node == null) {
            return 0;
        }

        int left = getMaxHeight(node.left);
        int right = getMaxHeight(node.right);

        if (left == NOT_BALANCED || right == NOT_BALANCED) {
            return NOT_BALANCED;
        }

        if (Math.abs(left - right) > 1) {
            return NOT_BALANCED;
        }

        return Math.max(left, right) + 1;
    }
}
