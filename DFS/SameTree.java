package DFS;

import java.util.ArrayList;

/**
 * Created by YANGSONG on 2018-10-04.
 */
public class SameTree {
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if (p == null && q == null) {
            return true;
        }
        if (p == null || q == null) {
            return false;
        }

        ArrayList<Integer> pList = collectNodes(p, new ArrayList<>());
        ArrayList<Integer> qList = collectNodes(q, new ArrayList<>());
        return compareLists(pList, qList);

    }

    private ArrayList<Integer> collectNodes(TreeNode t, ArrayList<Integer> list) {
        if (t == null) {
            list.add(null);
            return list;
        }
        list.add(t.val);
        collectNodes(t.left, list);
        collectNodes(t.right, list);

        return list;
    }

    private boolean compareLists(ArrayList<Integer> l1, ArrayList<Integer> l2) {
        if (l1.size() != l2.size()) {
            return false;
        }

        int len = l1.size();
        for (int i = 0; i < len; i++) {
            if (l1.get(i) == null && l2.get(i) != null) {
                return false;
            } else if (l1.get(i) != null && l2.get(i) == null) {
                return false;
            } else if (l1.get(i) == null && l2.get(i) == null) {
                continue;
            } else {
                int res = l1.get(i).compareTo(l2.get(i));
                if (res != 0) {
                    return false;
                }
            }
        }
        return true;
    }
}
