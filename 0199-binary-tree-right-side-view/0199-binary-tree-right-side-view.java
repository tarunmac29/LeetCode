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
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> ans = new ArrayList<>();

        if(root == null) return ans;

        // Queue<TreeNode> que = new LinkedList<>();

        // que.offer(root);

        // while(!que.isEmpty()){
        //     int level = que.size();

        //     for(int i = 0; i < level; i++){
        //         TreeNode node = que.poll();

        //         if(i == level - 1) ans.add(node.val);

        //         if(node.left != null) que.offer(node.left);
        //         if(node.right != null) que.offer(node.right);
        //     }
        // }

        solve(root, 0, ans);

        return ans;
    }


    private static void solve(TreeNode root, int level, List<Integer> ans){
        if(root == null) return;

        if(level == ans.size()) ans.add(root.val);

        solve(root.right, level + 1, ans);
        solve(root.left, level + 1, ans);

    }
}