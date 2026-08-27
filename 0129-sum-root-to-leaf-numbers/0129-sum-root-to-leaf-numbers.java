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
    public int dfs(TreeNode root, int currentNum){
        if(root == null) return 0;

        currentNum = currentNum * 10 + root.val;

        if(root.left == null && root.right == null) return currentNum;

        int left = dfs(root.left, currentNum);
        int right = dfs(root.right, currentNum);

        return left + right;
    }
    public int sumNumbers(TreeNode root) {
        return dfs(root, 0);
    }
}