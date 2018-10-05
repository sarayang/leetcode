package DFS;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by YANGSONG on 2018-10-04.
 */
public class BinaryTreePaths {
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> result = new ArrayList<>();
        if (root == null) {
            return result;
        }

        helper(root, result, "");
        return result;
    }

    private void helper(TreeNode root, List<String> res, String s) {
        if (root == null) {
            return;
        }
        if (root != null && root.left == null && root.right == null) {
            res.add(s + Integer.toString(root.val));
            return;
        }

        String val = Integer.toString(root.val) + "->";
        s += val;
        helper(root.left, res, s);
        helper(root.right, res, s);

    }
}
