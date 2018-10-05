package DFS;

import java.util.ArrayList;
import java.util.Deque;
import java.util.HashSet;
import java.util.LinkedList;

/**
 * Created by YANGSONG on 2018-10-03.
 */
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}
public class BST_InorderTraverse_Iterative {
    public ArrayList<TreeNode> inorderTraverseIterative(TreeNode root) {
        ArrayList<TreeNode> res = new ArrayList<>();
        if (root == null) {
            return res;
        }

        HashSet<TreeNode> visited = new HashSet<>();
        TreeNode cur = root;
        Deque<TreeNode> stack = new LinkedList<>();
        while (!stack.isEmpty() || cur != null) {
            while (cur != null) {
                if (visited.contains(cur)) {
                    break;
                }
                stack.offer(cur);
                cur = cur.left;
            }
            cur = stack.pollLast();
            res.add(cur);
            System.out.println(cur.val);
            if (visited.contains(cur.right)) {
                continue;
            }
            cur = cur.right;
        }
        return res;
    }

    public ArrayList<TreeNode> preorderTraverseIterative(TreeNode root) {
        ArrayList<TreeNode> res = new ArrayList<>();
        if (root == null) {
            return res;
        }

        HashSet<TreeNode> visited = new HashSet<>();
        TreeNode cur = root;
        Deque<TreeNode> stack = new LinkedList<>();
        stack.offer(root);
        while (!stack.isEmpty()) {
            TreeNode node = stack.pollLast();
            System.out.println(node.val);
            res.add(node);
            if (node.right != null) {
                stack.offer(node.right);
            }

            if (node.left != null) {
                stack.offer(node.left);
            }
        }
        return res;
    }

    public ArrayList<TreeNode> postorderTraverseIterative(TreeNode root) {
        ArrayList<TreeNode> res = new ArrayList<>();
        if (root == null) {
            return res;
        }

        TreeNode cur = root;
        Deque<TreeNode> stack = new LinkedList<>();
        while (!stack.isEmpty() || cur != null) {
            if (cur != null) {
                stack.offer(cur);
                cur = cur.left;
            } else {
                TreeNode n = stack.peekLast().right;
                if (n == null) {
                    // means n does not have right child, it is safe to be popped out
                    n = stack.pollLast();
                    System.out.println(n.val);
                    res.add(n);
                    // need tp
                    while (!stack.isEmpty() && n == stack.peekLast().right) {
                        n = stack.pollLast();
                        System.out.println(n.val);
                        res.add(n);
                    }
                    res.add(n);
                } else {
                    cur = n;
                }
            }
        }
        return res;

    }

    public static void main(String[] args) {
        BST_InorderTraverse_Iterative b = new BST_InorderTraverse_Iterative();
        TreeNode root = new TreeNode(1);
        TreeNode root_l = new TreeNode(2);
        TreeNode root_r = new TreeNode(3);
        TreeNode root_ll = new TreeNode(4);
        TreeNode root_lr = new TreeNode(5);
        TreeNode root_rl = new TreeNode(6);

        root.left = root_l;
        root.right = root_r;
        root_l.left = root_ll;
        root_l.right = root_lr;
        root_r.left = root_rl;

        b.postorderTraverseIterative(root);

    }


}
