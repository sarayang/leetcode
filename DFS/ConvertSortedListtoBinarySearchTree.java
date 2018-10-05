package DFS;

/**
 * Created by YANGSONG on 2018-10-04.
 */
class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; }
 }
public class ConvertSortedListtoBinarySearchTree {
    ListNode cur = null;

    // use two pointers to find the middle of linked list, then recursively construct its left and right subtree
//     public TreeNode sortedListToBST(ListNode head) {
//         if (head == null) return null;

//         ListNode slow = head;
//         ListNode fast = head;
//         ListNode prev = head;
//         while (fast != null && fast.next != null) {
//             prev = slow;
//             slow = slow.next;
//             fast = fast.next.next;
//         }
//         prev.next = null;
//         TreeNode root = new TreeNode(slow.val);

//         root.left = (head != slow) ? sortedListToBST(head) : null;
//         root.right= sortedListToBST(slow.next);

    //         return root;
//     }
    public TreeNode sortedListToBST(ListNode head) {
        if (head == null) return null;
        cur = head;
        int length = getSize(head);
        return inorderTraverse(length);
    }
    private TreeNode inorderTraverse(int len) {
        if (len <= 0) {
            return null;
        }
        TreeNode left = inorderTraverse(len / 2);
        TreeNode root = new TreeNode(cur.val);
        cur = cur.next;
        TreeNode right = inorderTraverse(len - len / 2 - 1);

        root.left = left;
        root.right = right;

        return root;
    }

    private int getSize(ListNode head) {
        if (head == null) return 0;
        ListNode cur = head;
        int count = 0;
        while (cur != null) {
            count++;
            cur = cur.next;
        }
        return count;
    }
}
