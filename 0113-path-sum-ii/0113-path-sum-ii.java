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
    public static void solve(TreeNode root, int targetSum, List<Integer> list, List<List<Integer>> ans){
        if(root == null) return;

        targetSum -= root.val;
        list.add(root.val);

        if(root.left == null && root.right == null){
            if(targetSum == 0){
                ans.add(new ArrayList<>(list));
            }
        }else{
            solve(root.left, targetSum, list, ans);
            solve(root.right, targetSum, list, ans);
        }

        list.remove(list.size() - 1);
    }
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> list = new ArrayList<>();

        solve(root, targetSum, list, ans);

        return ans;
    }
}