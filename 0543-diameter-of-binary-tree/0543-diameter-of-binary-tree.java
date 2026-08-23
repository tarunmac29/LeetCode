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
    public static int findDepth(TreeNode root){
        if(root == null) return 0;

        int leftH = findDepth(root.left);
        int rightH = findDepth(root.right);

        return 1 + Math.max(leftH, rightH);
    }
    public int diameterOfBinaryTree(TreeNode root) {
        if(root == null) return 0;

        int leftH = findDepth(root.left);
        int rightH = findDepth(root.right);

        int curD = leftH + rightH;
        
        int leftD = diameterOfBinaryTree(root.left);
        int rightD = diameterOfBinaryTree(root.right);

        return Math.max(curD, Math.max(leftD,rightD));
        
    }
}