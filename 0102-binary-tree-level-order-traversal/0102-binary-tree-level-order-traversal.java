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
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> list = new ArrayList<>();
        Queue<TreeNode> que = new LinkedList<>();

        if (root == null) {
            return list;
        }

        que.offer(root);

        while(!que.isEmpty()){
            int level = que.size();

            List<Integer> ans = new ArrayList<>();

            for(int i = 0; i < level; i++){
                if(que.peek().left != null) que.offer(que.peek().left);
                if(que.peek().right != null) que.offer(que.peek().right);

                ans.add(que.poll().val);
            }

            list.add(ans);
        }

        return list;
    }
}