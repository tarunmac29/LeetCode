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
    private int count = 0;
    public void countPathFromNode(TreeNode root, long target){
        if(root == null) return;

        target -= root.val;

        if(target == 0) count++;
        
        countPathFromNode(root.left, target);
        countPathFromNode(root.right, target);
    }

    public void startAndFindPath(TreeNode root, long target){
        if(root == null) return;

        countPathFromNode(root, target);

        startAndFindPath(root.left, target);
        startAndFindPath(root.right, target);
    }
    public int pathSum(TreeNode root, int targetSum) {
        if(root == null) return 0;

        count = 0;

        startAndFindPath(root, targetSum);

        return count;
    }
}