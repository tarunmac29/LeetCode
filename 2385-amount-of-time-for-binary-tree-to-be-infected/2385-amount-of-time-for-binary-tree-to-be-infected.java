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
    // public TreeNode findNode(TreeNode current, int target) {
    //     if (current == null) {
    //         return null;
    //     }

    //     if (current.val == target) {
    //         return current;
    //     }

    //     TreeNode foundNode = findNode(current.left, target);

    //     if (foundNode != null) {
    //         return foundNode;
    //     }

    //     return findNode(current.right, target);
    // }
    TreeNode targetNode = null;
    public void markParent(TreeNode root, Map<TreeNode, TreeNode> pt, int start){
        Queue<TreeNode> que = new ArrayDeque<>();

        que.offer(root);
        pt.put(root, null);

        while(!que.isEmpty()){
            TreeNode node = que.poll();

            if(node.val == start){
                targetNode = node;
            }

            if(node.left != null){
                que.offer(node.left);
                pt.put(node.left, node);
            }
            if(node.right != null){
                que.offer(node.right);
                pt.put(node.right, node);
            }
        }
    }
    public int amountOfTime(TreeNode root, int start) {
        Map<TreeNode, TreeNode> pt = new HashMap<>();
        markParent(root, pt, start);

        Map<TreeNode, Boolean> visited = new HashMap<>();

        Queue<TreeNode> que = new ArrayDeque<>();

        que.offer(targetNode);
        visited.put(targetNode, true);

        int cur = 0;

        while(!que.isEmpty()){
            int size = que.size();
            cur++;

            for(int i = 0; i < size; i++){
                TreeNode node = que.poll();

                if(node.left != null && visited.get(node.left) == null){
                    que.offer(node.left);
                    visited.put(node.left, true);
                }
                if(node.right != null && visited.get(node.right) == null){
                    que.offer(node.right);
                    visited.put(node.right, true);
                }
                if(pt.get(node) != null && visited.get(pt.get(node)) == null){
                    que.offer(pt.get(node));
                    visited.put(pt.get(node), true);
                }
            }
        }

        return cur == 0 ? 0 : cur - 1;
    }
}