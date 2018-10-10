package BST;

import java.util.Deque;
import java.util.LinkedList;

/**
 * Created by YANGSONG on 2018-10-05.
 */
public class BinarySearchTree {
    public void postorderTraversal_iterative(BST.TreeNode root) {
        if (root == null) {
            return;
        }

        Deque<TreeNode> stack = new LinkedList<>();
        TreeNode cur = root;
        while (!stack.isEmpty() || cur != null) {
            if (cur != null) {
                stack.offer(cur);
                cur = cur.left;
            } else {
                TreeNode node = stack.peekLast().right;
                if (node != null) {
                    cur = node;
                } else {
                    node = stack.pollLast();
                    System.out.println(node.val);
                    while (!stack.isEmpty() && node == stack.peekLast().right) {
                        node = stack.pollLast();
                        System.out.println(node.val);
                    }
                }
            }
        }
    }

    public void preorder_iterative(TreeNode root) {
        if (root == null) {
            return;
        }

        Deque<TreeNode> stack = new LinkedList<>();
        stack.offer(root);
        while (!stack.isEmpty()) {
            TreeNode node = stack.pollLast();
            System.out.println(node.val);
            if (node.right != null) {
                stack.offer(node.right);
            }
            if (node.left != null) {
                stack.offer(node.left);
            }
        }
    }

    public void inorder_interative(TreeNode root) {
        if (root == null) {
            return;
        }

        Deque<TreeNode> stack = new LinkedList<>();
        TreeNode cur = root;
        while (true) {
            if (cur != null) {
                stack.offer(cur);
                cur = cur.left;
            } else {
                if (stack.isEmpty()) {
                    break;
                }

                TreeNode node = stack.pollLast();
                System.out.println(node.val);
                cur = node.right;
            }
        }
    }
    public static void main(String[] args) {
        BinarySearchTree b = new BinarySearchTree();
        TreeNode root = new TreeNode(9);
        TreeNode root_l = new TreeNode(4);
        TreeNode root_r = new TreeNode(6);
        TreeNode root_ll = new TreeNode(1);
        TreeNode root_lr = new TreeNode(40);
        TreeNode root_rl = new TreeNode(34);

        root.left = root_l;
        root.right = root_r;
        root_l.left = root_ll;
        root_l.right = root_lr;
        root_r.left = root_rl;

        b.inorder_interative(root);
    }
}
