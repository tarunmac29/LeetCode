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
    public int maxLevelSum(TreeNode root) {
        List<Integer> levelSum = new ArrayList<>();

        if(root == null) return 0;

        Queue<TreeNode> que = new LinkedList<>();

        que.offer(root);

        int maxSum = Integer.MIN_VALUE;
        int curLevel = 1;
        int maxLevel = 0;

        while(!que.isEmpty()){
            int level = que.size();

            int sum = 0;

            for(int i = 0; i < level; i++){
                TreeNode node = que.poll();

                if(node.left != null) que.offer(node.left);
                if(node.right != null) que.offer(node.right);

                sum += node.val;                
            }

            if(sum > maxSum){
                maxSum = sum;
                maxLevel = curLevel;
            }

            curLevel++;

            // levelSum.add(sum);
        }

        // return levelSum.indexOf(Collections.max(levelSum)) + 1;
        return maxLevel;
    }
}