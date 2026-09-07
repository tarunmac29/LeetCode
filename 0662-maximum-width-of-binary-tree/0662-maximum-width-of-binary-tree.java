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
class Pair{
    int num;
    TreeNode root;

    Pair(TreeNode root, int num){
        this.root = root;
        this.num = num;
    }
}
class Solution {
    public int widthOfBinaryTree(TreeNode root) {
        if(root == null) return 0;
        int ans = 0;

        Queue<Pair> que = new ArrayDeque<>();
        que.offer(new Pair(root, 0));

        while(!que.isEmpty()){
            int level = que.size();
            int minId = que.peek().num;
            int first = 0;
            int last = 0;

            for(int i = 0; i < level; i++){
                int cur_id = que.peek().num - minId;

                Pair pair = que.poll();
                TreeNode node = pair.root;
                if(i == 0) first = cur_id;
                if(i == level - 1) last = cur_id;

                if(node.left != null) que.offer(new Pair(node.left, cur_id*2+1));
                if(node.right != null) que.offer(new Pair(node.right, cur_id*2+2));

            }

            ans = Math.max(ans, last - first + 1);
        }

        return ans;
    }
}