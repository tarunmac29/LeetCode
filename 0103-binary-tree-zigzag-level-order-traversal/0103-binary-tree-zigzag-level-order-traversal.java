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
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<>();

        if(root == null) return ans;

        Queue<TreeNode> que = new LinkedList<>();

        que.offer(root);

        int levelCount = 0;

        while(!que.isEmpty()){
            int level = que.size();

            ArrayList<Integer> list = new ArrayList<>();

            for(int i = 0; i < level; i++){
                TreeNode node = que.poll();

                if(node.left != null) que.offer(node.left);
                if(node.right != null) que.offer(node.right);

                list.add(node.val);
            }

            if(levelCount % 2 != 0){
                ans.add(new ArrayList<>(list.reversed()));
            }else{
                ans.add(list);
            }

            levelCount++;
        }

        return ans;
    }
}