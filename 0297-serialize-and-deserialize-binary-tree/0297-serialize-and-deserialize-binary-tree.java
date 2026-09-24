/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if(root == null) return "";

        StringBuilder sb = new StringBuilder("");

        Queue<TreeNode> que = new LinkedList<>();

        que.offer(root);

        while(!que.isEmpty()){
            TreeNode node = que.poll();

            if(node == null) sb.append("#,");
            else sb.append(node.val).append(",");

            if(node != null){
                que.offer(node.left);
                que.offer(node.right);
            }
        }

        return sb.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if(data == null || data.isEmpty()) return null;

        String[] values = data.split(",");

        TreeNode root = new TreeNode(Integer.parseInt(values[0]));

        Queue<TreeNode> que = new ArrayDeque<>();

        que.offer(root);
        int i = 1;

        while(!que.isEmpty() || i < values.length){
            TreeNode node = que.poll();

            if(!values[i].equals("#")){
                TreeNode leftChild = new TreeNode(Integer.parseInt(values[i]));
                node.left = leftChild;
                que.offer(leftChild);
            }
            i++;

            if(i > values.length) break;

            if(!values[i].equals("#")){
                TreeNode rightChild = new TreeNode(Integer.parseInt(values[i]));
                node.right = rightChild;
                que.offer(rightChild);
            }
            i++;
        }

        return root;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// TreeNode ans = deser.deserialize(ser.serialize(root));