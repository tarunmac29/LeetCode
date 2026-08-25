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
    public int solve(TreeNode root){
        if(root == null) return 0;

        int leftH = solve(root.left);
        int rightH = solve(root.right);

        maxDiameter = Math.max(maxDiameter, leftH + rightH);

        return 1 + Math.max(leftH, rightH);
    }
    public int diameterOfBinaryTree(TreeNode root) {
        solve(root);
        return maxDiameter;        
    }
}