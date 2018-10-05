package DFS;

/**
 * Created by YANGSONG on 2018-10-04.
 */
class TreeLinkNode {
      int val;
      TreeLinkNode left, right, next;
      TreeLinkNode(int x) { val = x; }
  }
public class PopulatingNextRightPointersinEachNode {
    public void connect(TreeLinkNode root) {
        if (root == null) {
            return;
        }
        helper(root, null);
    }

    private void helper(TreeLinkNode root, TreeLinkNode next) {
        if (root == null) {
            return;
        }
        root.next = next;
        helper(root.left, root.right);
        TreeLinkNode rightNext = next == null ? null : next.left;
        helper(root.right, rightNext);

    }

}
