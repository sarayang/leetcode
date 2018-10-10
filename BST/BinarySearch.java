package BST;

import java.util.Deque;
import java.util.LinkedList;

/**
 * Created by YANGSONG on 2018-10-05.
 */
public class BinarySearch {
    public int binarySearch(int[] array, int target) {
        if (array.length == 0) {
            return -1;
        }

        int start = 0;
        int end = array.length - 1;
        while (start + 1 < end) {
            int mid = start + (end - start) / 2;
            if (array[mid] == target) {
                if (mid - 1 >= 0 && array[mid - 1] == array[mid]) {
                    end = mid - 1;
                } else {
                    return mid;
                }
            } else if (array[mid] < target) {
                start = mid;
            } else {
                end = mid;
            }
        }

        if (array[start] == target) return start;
        if (array[end] == target) return end;
        return -1;
    }

    private TreeNode findNextSmallest(TreeNode node) {
        if (node == null) {
            return null;
        }

        Deque<TreeNode> stack = new LinkedList<>();
        TreeNode cur = node.right;
        while (true) {
            if (cur != null) {
                stack.offer(cur);
                cur = cur.left;
            } else {
                if (stack.isEmpty()) {
                    break;
                }
                return stack.pollLast();
            }
        }
        return node;
    }

    public static void main(String[] args) {
        BinarySearch bs = new BinarySearch();
        int[] arr = {0,1};
//        System.out.println(bs.binarySearch(arr, 1));

        TreeNode root = new TreeNode(1);
        System.out.println(bs.findNextSmallest(root).val);
    }
}
