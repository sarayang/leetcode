package DFS;

/**
 * Created by YANGSONG on 2018-10-04.
 */
public class FlattenBinaryTreetoLinkedList {
    TreeNode prev = null;
    public void flatten(TreeNode root) {
        if (root == null) return;
        flatten(root.right);
        flatten(root.left);
        root.right = prev;
        root.left = null;
        prev = root;
    }
}
