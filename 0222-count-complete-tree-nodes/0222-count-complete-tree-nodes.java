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
    int leftH(TreeNode root){
        int count = 0;

        while(root != null){
            count++;
            root = root.left;
        }

        return count;
    }
    int rightH(TreeNode root){
        int count = 0;

        while(root != null){
            count++;
            root = root.right;
        }

        return count;
    }
    public int countNodes(TreeNode root) {
        if(root == null) return 0;

        int leftH = leftH(root.left);
        int rightH = rightH(root.right);

        if(leftH == rightH) return (2 << leftH) - 1;

        return 1 + countNodes(root.left) + countNodes(root.right);
    }
}