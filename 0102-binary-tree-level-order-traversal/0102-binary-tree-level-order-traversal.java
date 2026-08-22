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
    public static void solve(TreeNode node, int depth, List<List<Integer>> list){
        if(node == null) return;

        if(depth == list.size()){
            list.add(new ArrayList<>());
        }

        list.get(depth).add(node.val);

        solve(node.left, depth + 1, list);
        solve(node.right, depth + 1, list);
    }
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> list = new ArrayList<>();

        if(root == null) return list;

        solve(root, 0, list);
        return list;
    }
}