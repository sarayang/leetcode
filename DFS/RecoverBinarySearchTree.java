package DFS;

import java.util.Deque;
import java.util.LinkedList;

/**
 * Created by YANGSONG on 2018-10-04.
 */
public class RecoverBinarySearchTree {
    TreeNode prev = null;
    TreeNode first = null;
    TreeNode second = null;
    // iterative way to solve it
    public void recoverTree(TreeNode root) {
        if (root == null) {
            return;
        }
        TreeNode cur = root;
        Deque<TreeNode> stack = new LinkedList<>();
        while (!stack.isEmpty() || cur != null) {
            // below snippet of code is equivalent to helper(root.left) in recursive version
            while (cur != null) {
                stack.offer(cur);
                cur = cur.left;
            }

            cur = stack.pollLast();
            if (prev != null && prev.val > cur.val) {
                if (first == null) {
                    first = prev;
                }
                second = cur;

            }
            prev = cur;

            // equivalent to helper(root.right) in recursive version.
            cur = cur.right;


        }
        int tmp = first.val;
        first.val = second.val;
        second.val = tmp;
    }

         // recursion way to solve it
     public void recoverTree_recursion(TreeNode root) {
         if (root == null) {
             return;
         }

         helper(root);
         int tmp = first.val;
         first.val = second.val;
         second.val = tmp;
     }

     private void helper(TreeNode node) {
         if (node == null) {
             return;
         }

         helper(node.left);
         if (prev != null && prev.val > node.val) {
             if (first == null) {
                 first = prev;
             }
             second = node;
         }
         prev = node;
         helper(node.right);
     }

    //   public void recoverTree(TreeNode root) {
    //   if (root == null) { return; }
    //   TreeNode pre = null, first = null, second = null;
    //   Stack<TreeNode> stk = new Stack<>();
    //   while (!stk.isEmpty() || root != null) {
    //     while (root != null) {
    //       stk.push(root);
    //       root = root.left;
    //     }
    //     TreeNode cur = stk.pop();
    //     if (pre != null && pre.val >= cur.val) {
    //       if (first == null) {
    //         first = pre;
    //       }
    //       if (first != null) {
    //         second = cur;
    //       }
    //     }
    //     root = cur.right;
    //     pre = cur;
    //   }
    //   int tmp = first.val;
    //   first.val = second.val;
    //   second.val = tmp;
    //   return;
    // }
}
