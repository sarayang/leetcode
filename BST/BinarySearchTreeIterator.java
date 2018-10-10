package BST;

import java.util.Comparator;
import java.util.Deque;
import java.util.LinkedList;
import java.util.PriorityQueue;

/**
 * Created by YANGSONG on 2018-10-07.
 */

class NodeSort implements Comparator<ListNode> {
    @Override
    public int compare(ListNode n1, ListNode n2) {
        return n1.val - n2.val;
    }
}
public class BinarySearchTreeIterator {
    Deque<TreeNode> stack = null;
    TreeNode cur = null;
    public BinarySearchTreeIterator(TreeNode root) {
        stack = new LinkedList<>();
        pushLeft(root);
    }

    /** @return whether we have a next smallest number */
    public boolean hasNext() {
        return !stack.isEmpty();
    }

    /** @return the next smallest number */
    public TreeNode next() {
        TreeNode cur = stack.pollLast();
        TreeNode res = cur;
        cur = cur.right;
        pushLeft(cur);
        System.out.println(stack);
        return res;
    }

    private void pushLeft(TreeNode root){
        while (root != null) {
            stack.offer(root);
            root = root.left;
        }
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(9);
        TreeNode root_l = new TreeNode(6);
        TreeNode root_r = new TreeNode(10);
        TreeNode root_ll = new TreeNode(2);
        TreeNode root_lr = new TreeNode(7);
        TreeNode root_rl = new TreeNode(9);
        TreeNode root_rr = new TreeNode(12);
        root_rl.left = new TreeNode(8);
        root_rr.right = new TreeNode(23);
        root_ll.right = new TreeNode(4);
        root_ll.right.left = new TreeNode(3);


        root.left = root_l;
        root.right = root_r;
        root_l.left = root_ll;
        root_l.right = root_lr;
        root_r.left = root_rl;
        root_r.right = root_rr;
        BinarySearchTreeIterator bi = new BinarySearchTreeIterator(root);

//        System.out.println(bi.next());

        ListNode node = new ListNode(-2);
        ListNode n1 = new ListNode(-1);
        ListNode n2 = new ListNode(-1);
        ListNode n3 = new ListNode(-1);
        node.next = n1;
        n1.next = n2;
        n2.next = n3;
        ListNode[] arr = new ListNode[2];
        arr[0] = node;
        arr[1] = null;
        System.out.println(bi.mergeKLists(arr).val);

    }

    public ListNode mergeKLists(ListNode[] lists) {
        if (lists.length == 0) {
            return null;
        }
        NodeSort nodeSort = new NodeSort();
        PriorityQueue<ListNode> heap = new PriorityQueue<>(lists.length, nodeSort);

        for (ListNode node : lists) {
            while (node != null) {

                heap.offer(node);
                node = node.next;
            }
        }
        // System.out.println(heap);

        ListNode head = heap.poll();
        ListNode cur = head;
        while (heap.size() > 0) {
            ListNode next = heap.poll();
            cur.next = next;
            cur = cur.next;
        }

        return head;

    }

}
