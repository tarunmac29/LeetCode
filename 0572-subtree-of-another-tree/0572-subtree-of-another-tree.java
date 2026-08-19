/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
        StringBuilder rootSerial = new StringBuilder();
        StringBuilder subRootSerial = new StringBuilder();
        
        serialize(root, rootSerial);
        serialize(subRoot, subRootSerial);
        
        return rootSerial.toString().contains(subRootSerial.toString());
    }
    
    private void serialize(TreeNode node, StringBuilder sb) {
        if (node == null) {
            sb.append(",#");
            return;
        }
        
        sb.append(",").append(node.val);
        
        serialize(node.left, sb);
        serialize(node.right, sb);
    }
}
