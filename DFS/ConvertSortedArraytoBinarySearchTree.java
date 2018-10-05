package DFS;

import java.util.Arrays;

/**
 * Created by YANGSONG on 2018-10-04.
 */
public class ConvertSortedArraytoBinarySearchTree {
    public TreeNode sortedArrayToBST(int[] nums) {
        if (nums.length == 0) {
            return null;
        }

        if (nums.length == 1) {
            return new TreeNode(nums[0]);
        }

        int mid = nums.length / 2;
        TreeNode root = new TreeNode(nums[mid]);
        TreeNode left =
                sortedArrayToBST(Arrays.copyOfRange(nums, 0, nums.length / 2));
        TreeNode right =
                sortedArrayToBST(Arrays.copyOfRange(nums, nums.length / 2 + 1, nums.length));

        root.left = left;
        root.right = right;
        return root;
    }
}
