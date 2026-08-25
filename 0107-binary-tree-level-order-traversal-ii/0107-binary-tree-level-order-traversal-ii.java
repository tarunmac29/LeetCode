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
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<>();

        if (root == null) {
            return ans; 
        }

        Queue<TreeNode> que = new LinkedList<>();

        Stack<List<Integer>> stk = new Stack<>();

        que.offer(root);

        while(!que.isEmpty()){
            int level = que.size();

            List<Integer> list = new ArrayList<>();

            for(int i = 0; i < level; i++){
                TreeNode node = que.poll();

                if(node.left != null) que.offer(node.left);
                if(node.right != null) que.offer(node.right);

                list.add(node.val);
            }

            stk.add(list);
        }

        while(!stk.isEmpty()){
            ans.add(stk.pop());
        }

        return ans;
    }
}