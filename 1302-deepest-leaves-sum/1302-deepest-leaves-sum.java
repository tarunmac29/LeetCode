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
    public int deepestLeavesSum(TreeNode root) {
        if(root == null) return 0;

        int deepLevelsum = 0;
        Queue<TreeNode> que = new LinkedList<>();

        que.offer(root);

        while(!que.isEmpty()){
            int level = que.size();

            int sum = 0;

            for(int i = 0; i < level; i++){
                TreeNode node = que.poll();

                if(node.left != null) que.offer(node.left);
                if(node.right != null) que.offer(node.right);

                sum += node.val;
            }

            deepLevelsum = sum;
        }
        return deepLevelsum;
    }
}