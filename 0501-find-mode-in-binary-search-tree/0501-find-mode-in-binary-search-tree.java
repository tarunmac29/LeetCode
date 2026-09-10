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
    int maxCount = 0;
    int count = 0;
    Integer curVal = null;
    List<Integer> modes = new ArrayList<>();

    public void inOrder(TreeNode node){
        if(node == null) return;

        inOrder(node.left);

        if(curVal != null && node.val == curVal) count++;
        else{
            curVal = node.val;
            count = 1;
        }

        if(count > maxCount){
            maxCount = count;
            modes.clear();
            modes.add(node.val);
        }else if(count == maxCount){
            modes.add(node.val);
        }

        inOrder(node.right);
    }
    public int[] findMode(TreeNode root) {
        maxCount = 0;
        count = 0;
        curVal = null;
        modes.clear();

        inOrder(root);

        int[] ans =  new int[modes.size()];

        for(int i = 0; i < modes.size(); i++){
            ans[i] = modes.get(i);
        }

        return ans;
    }
}