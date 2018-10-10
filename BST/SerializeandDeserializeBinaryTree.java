package BST;

import java.util.ArrayList;

/**
 * Created by YANGSONG on 2018-10-07.
 */
public class SerializeandDeserializeBinaryTree {
    public String serialize(TreeNode root) {
        if (root == null) {
            return "#";
        }

        ArrayList<TreeNode> queue = new ArrayList<>();
        queue.add(root);
        // queue size is dynamically changing.
        for (int i = 0; i < queue.size(); i++) {
            TreeNode node = queue.get(i);
            if (node == null) {
                continue;
            }
            queue.add(node.left);
            queue.add(node.right);
        }

        StringBuilder sb = new StringBuilder();
        for (int j = 0; j < queue.size(); j++) {
            if (queue.get(j) == null) {
                sb.append("#");
            } else {
                sb.append(Integer.toString(queue.get(j).val));
            }
            sb.append(" ");
        }
        return sb.toString().trim();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {

        if (data.equals("#")) {
            return null;
        }

        String[] split = data.split(" ");

        ArrayList<TreeNode> queue = new ArrayList<>();
        TreeNode root = new TreeNode(Integer.parseInt(split[0]));
        queue.add(root);
        int index = 0;
        boolean isLeft = true;
        for (int i = 1; i < split.length; i++) {
            if (!split[i].equals("#")) {
                TreeNode node = new TreeNode(Integer.parseInt(split[i]));
                if (isLeft) {
                    queue.get(index).left = node;
                } else {
                    queue.get(index).right = node;
                }
                queue.add(node);
            }


            if (!isLeft) {
                index++;
            }
            isLeft = !isLeft;
        }

//         Deque<TreeNode> q = new LinkedList<>();
//         q.offer(root);
//         while (!q.isEmpty()) {
//             TreeNode node = q.pollFirst();
//             System.out.print(node.val);
//             System.out.print(" ");
//             if (node.left != null) {
//                 q.offer(node.left);
//             }

//             if (node.right != null) {
//                 q.offer(node.right);
//             }
//         }
//         System.out.println(" ");

        return root;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(9);
        TreeNode root_l = new TreeNode(6);
        TreeNode root_r = new TreeNode(10);
        TreeNode root_ll = new TreeNode(2);
        TreeNode root_lr = new TreeNode(7);
        TreeNode root_rl = new TreeNode(9);
        TreeNode root_rr = new TreeNode(12);
        root_rl.left = new TreeNode(8);
        root_rr.right = new TreeNode(23);
        root_ll.right = new TreeNode(4);
        root_ll.right.left = new TreeNode(3);


        root.left = root_l;
        root.right = root_r;
        root_l.left = root_ll;
        root_l.right = root_lr;
        root_r.left = root_rl;
        root_r.right = root_rr;
        SerializeandDeserializeBinaryTree s = new SerializeandDeserializeBinaryTree();
        String ss = s.serialize(root);
        System.out.println(ss);

        TreeNode node = s.deserialize(ss);
        System.out.println(node.val);


    }
}
