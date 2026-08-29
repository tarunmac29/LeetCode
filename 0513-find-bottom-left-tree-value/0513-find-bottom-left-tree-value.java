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
    public int findBottomLeftValue(TreeNode root) {

        Queue<TreeNode> que = new LinkedList<>();
        
        if(root == null) return 0;

        que.offer(root);

        TreeNode node = root;

        while(!que.isEmpty()){
            int level = que.size();
            for(int i = 0; i < level; i++){
                node = que.poll();

                if(node.right != null) que.offer(node.right);
                if(node.left != null) que.offer(node.left);
            }
        }

        return node.val;
    }
}