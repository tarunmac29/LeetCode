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
        if (root == null)
            return "";

        StringBuilder sb = new StringBuilder("");

        Queue<TreeNode> que = new LinkedList<>();

        que.offer(root);

        while (!que.isEmpty()) {
            TreeNode node = que.poll();

            if (node == null)
                sb.append("#,");
            else
                sb.append(node.val).append(',');

            if (node != null) {
                que.offer(node.left);
                que.offer(node.right);
            }
        }

        return sb.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        // Base case: if data is empty, the tree is empty
        if (data == null || data.isEmpty())
            return null;

        // Split the comma-separated data values into an array
        String[] values = data.split(",");

        // The first element is always the root node
        TreeNode root = new TreeNode(Integer.parseInt(values[0]));

        // Queue to keep track of nodes whose children need to be assigned
        Queue<TreeNode> que = new ArrayDeque<>();
        que.offer(root);

        // Pointer to traverse through the values array
        int i = 1;

        while (!que.isEmpty() && i < values.length) {
            TreeNode current = que.poll();

            // 1. Process the left child
            if (!values[i].equals("#")) {
                TreeNode leftChild = new TreeNode(Integer.parseInt(values[i]));
                current.left = leftChild;
                que.offer(leftChild); // Queue it up to find its own children later
            }
            i++; // Move to the next value in the serialization array

            // Guard check in case the array ends early
            if (i >= values.length)
                break;

            // 2. Process the right child
            if (!values[i].equals("#")) {
                TreeNode rightChild = new TreeNode(Integer.parseInt(values[i]));
                current.right = rightChild;
                que.offer(rightChild); // Queue it up to find its own children later
            }
            i++;
        }

        return root;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// String tree = ser.serialize(root);
// TreeNode ans = deser.deserialize(tree);
// return ans;