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
     private int maxDiameter = 0;

    public int findDepth(TreeNode root){
        if(root == null) return 0;

        int leftH = findDepth(root.left);
        int rightH = findDepth(root.right);

        maxDiameter = Math.max(maxDiameter, leftH + rightH);

        return 1 + Math.max(leftH, rightH);
    }
    public int diameterOfBinaryTree(TreeNode root) {
        findDepth(root);
        return maxDiameter;
    }
}