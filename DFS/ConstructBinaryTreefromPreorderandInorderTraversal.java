package DFS;

/**
 * Created by YANGSONG on 2018-10-03.
 */


public class ConstructBinaryTreefromPreorderandInorderTraversal {
    int postStart = 0;
    public TreeNode buildTree(int[] postorder, int[] inorder) {
        if (postorder.length != inorder.length) {
            return null;
        }
//        postStart = postorder.length - 1;
        return helpBuildTree(postorder, inorder, 0, inorder.length - 1);
    }

    // helper function to find the root position in inorder array
    private int findPosition(int[] arr, int start, int end, int target) {
        for (int i = start; i <= end; i++) {
            if (arr[i] == target) {
                return i;
            }
        }

        // did not find it
        return -1;
    }

    private TreeNode helpBuildTree(int[] postord,
                                   int[] inord,
                                   int inS,
                                   int inE) {
        if (postStart < 0 || inS > inE) {
            return null;
        }

        TreeNode root = new TreeNode(postord[postStart]);
        int mid = findPosition(inord, inS, inE, postord[postStart]);
        postStart++;


        root.left = helpBuildTree(postord, inord, inS, mid - 1);
        root.right = helpBuildTree(postord, inord, mid + 1, inE);

        return root;
    }

    public static void main(String[] args) {
        int[] pre = {3,9,20,15,7};
        int[] post = {9,15,7,20,3};
        int[] in = {9,3,15,20,7};
        ConstructBinaryTreefromPreorderandInorderTraversal c = new ConstructBinaryTreefromPreorderandInorderTraversal();
        TreeNode n = c.buildTree(pre, in);
        System.out.println("---");

    }
}
