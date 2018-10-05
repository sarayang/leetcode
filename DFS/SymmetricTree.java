package DFS;

import java.util.Deque;
import java.util.LinkedList;

/**
 * Created by YANGSONG on 2018-10-04.
 */
public class SymmetricTree {
    // recursion
    public boolean isSymmetric_recursion(TreeNode root) {
        if (root == null) {
            return true;
        }
        return isMirror(root.left, root.right);
    }

    private boolean isMirror(TreeNode n1, TreeNode n2) {
        if (n1 == null && n2 == null) {
            return true;
        }
        if (n1 == null || n2 == null) {
            return false;
        }

        return (n1.val == n2.val)
                && isMirror(n1.left, n2.right)
                && isMirror(n2.left, n1.right);
    }

    public boolean isSymmetric(TreeNode root) {
        if (root == null) {
            return true;
        }
        Deque<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        queue.offer(root);
        while (!queue.isEmpty()) {
            TreeNode n1 = queue.pollFirst();
            TreeNode n2 = queue.pollFirst();
            System.out.println(n1);
            System.out.println(n2);
            if (n1 == null && n2 == null) {
                continue;
            }

            if (n1 == null || n2 == null) {
                return false;
            }

            if (n1.val != n2.val) {
                return false;
            }
            queue.offer(n1.right);
            queue.offer(n2.left);
            queue.offer(n1.left);
            queue.offer(n2.right);
        }
        return true;
    }
}
