package DFS;

import java.util.Arrays;

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
    private void quicksort(int[] array, int start, int end) {
        if (array.length == 0) {
            return;
        }
        if (start >= end) {
            return;
        }
        int left = start;
        int right = end;
        int pivot = array[(start + end) / 2];
        while (left <= right) {
            while (left <= right && array[left] < pivot) {
                left++;
            }

            while (left <= right && array[right] > pivot) {
                right--;
            }

            if (left <= right) {
                int tmp = array[left];
                array[left] = array[right];
                array[right] = tmp;
                left++;
                right--;
            }
        }
        quicksort(array, start, right);
        quicksort(array, left, end);
    }

    public static void main(String[] args) {
        int[] arr = {3, -2, -1};
        MinimumDepthofBinaryTree m = new MinimumDepthofBinaryTree();
        m.quicksort(arr, 0, arr.length - 1);
        System.out.println(Arrays.toString(arr));
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
