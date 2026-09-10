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
    public boolean vailidate(TreeNode root, long min, long max){
        if(root == null) return true;

        if(root.val <= min || root.val >= max) return false;

        return vailidate(root.left, min, root.val) && vailidate(root.right, root.val, max);
    }
    public boolean isValidBST(TreeNode root) {
        return vailidate(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }
}