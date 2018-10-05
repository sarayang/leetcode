package DFS;

import java.util.Arrays;

/**
 * Created by YANGSONG on 2018-10-02.
 */
//class TreeNode {
//    int val;
//    TreeNode left;
//    TreeNode right;
//    TreeNode(int x) { val = x; }
// }
public class ConvertSortedArrayToBST {
    public TreeNode sortedArrayToBST(int[] nums) {
        if (nums.length == 0) {
            return null;
        }
        if (nums.length == 1) {
//            return new TreeNode(nums[0]);
            return null;
        }
        int[] firstHalf = Arrays.copyOfRange(nums, 0, nums.length / 2);
        int[] secondHalf = Arrays.copyOfRange(nums, nums.length / 2 + 1, nums.length);


        int mid = nums.length  / 2;
//        TreeNode root = new TreeNode(nums[mid]);
        TreeNode left = sortedArrayToBST(firstHalf);


        TreeNode right = sortedArrayToBST(secondHalf);

//        root.left = left;
//        root.right = right;
//        System.out.println("-----");

//        return root;
        return null;
    }

    public static void main(String[] args) {
        ConvertSortedArrayToBST c = new ConvertSortedArrayToBST();
        int[] array = {-10,-3,0,5,9};
        TreeNode root = c.sortedArrayToBST(array);
//        System.out.println(root.val);

        String s = "()())()";
        int l = 0, r = 0;
        char[] chas = s.toCharArray();
        for (char cc : chas) {
            if (cc == '(') {
                l++;
            }
            if (cc == ')') {
                if (l > 0) {
                    l--;
                } else {
                    r++;
                }
            }

        }

        System.out.println(l + "," + r);

    }
}
