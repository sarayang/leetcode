package DFS;

/**
 * Created by YANGSONG on 2018-10-04.
 */
public class ConstructBinaryTreefromInorderandPostorderTraversal {
    int postIndex = 0;
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        if (inorder.length != postorder.length) {
            return null;
        }
        postIndex = postorder.length - 1;
        return helper(inorder, 0, inorder.length - 1, postorder);

    }

    private TreeNode helper(int[] inorder, int inS, int inE, int[] postorder) {
        if (postIndex < 0 || inS > inE) {
            return null;
        }


        TreeNode root = new TreeNode(postorder[postIndex]);
        int position = findPosition(inorder, inS, inE, postorder[postIndex--]);
        root.right = helper(inorder, position + 1, inE, postorder);
        root.left = helper(inorder, inS, position - 1, postorder);


        return root;
    }

    private int findPosition(int[] inorder, int from, int end, int target) {
        if (from > end) {
            return -1;
        }
        for (int i = from; i <= end; i++) {
            if (inorder[i] == target) {
                return i;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] inorder = {9,3,15,20,7};
        int[] postorder = {9,15,7,20,3};

        ConstructBinaryTreefromInorderandPostorderTraversal cc = new ConstructBinaryTreefromInorderandPostorderTraversal();
        TreeNode node = cc.buildTree(inorder, postorder);
        System.out.println(node.val);
    }

}
