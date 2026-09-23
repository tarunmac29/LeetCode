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
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        Map<Integer, Integer> inMap = new HashMap<>();

        for(int i = 0; i < inorder.length; i++){
            inMap.put(inorder[i], i);
        }

        return conTree(inorder, 0, inorder.length - 1, postorder, 0, postorder.length - 1, inMap);
    }

    public TreeNode conTree(int[] inorder, int inStart, int inEnd, int[] postorder, int postStart, int postEnd, Map<Integer, Integer> inMap){
        if (inStart > inEnd || postStart > postEnd) {
            return null;
        }

        int rootVal = postorder[postEnd];
        TreeNode root = new TreeNode(rootVal);

        int inRootIdx = inMap.get(rootVal);
        
        int numsLeft = inRootIdx - inStart;

        root.left = conTree(inorder, inStart, inRootIdx - 1, 
                            postorder, postStart, postStart + numsLeft - 1, inMap);
                            
        root.right = conTree(inorder, inRootIdx + 1, inEnd, 
                             postorder, postStart + numsLeft, postEnd - 1, inMap);

        return root;
    }
}