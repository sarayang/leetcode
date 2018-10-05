package DFS;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by YANGSONG on 2018-10-04.
 */
public class BinaryTreeRightSideView {
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if (root == null) {
            return res;
        }

        helper(root, res, 1);
        return res;
    }

    private void helper(TreeNode node, List<Integer> res, int level) {
        if (node == null) {
            return;
        }

        if (res.size() + 1 == level) {
            res.add(node.val);
        }

        helper(node.right, res, level + 1);
        helper(node.left, res, level + 1);
    }
}
