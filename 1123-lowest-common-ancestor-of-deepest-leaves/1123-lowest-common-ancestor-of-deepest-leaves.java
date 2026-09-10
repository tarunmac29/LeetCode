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
    public void markParent(TreeNode root, Map<TreeNode, TreeNode> pt){
        if (root == null) return;
        Queue<TreeNode> que = new ArrayDeque<>();

        que.offer(root);
        pt.put(root, null);

        while(!que.isEmpty()){
            TreeNode node = que.poll();
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
    public TreeNode lcaDeepestLeaves(TreeNode root) {
        Map<TreeNode, TreeNode> pt = new HashMap<>();
        markParent(root,pt);

        Queue<TreeNode> que = new ArrayDeque<>();

        que.offer(root);

        List<TreeNode> deepestLeaves = new ArrayList<>();
        
        while(!que.isEmpty()){
            int size = que.size();
            deepestLeaves.clear();
            
            for (int i = 0; i < size; i++) {
                TreeNode node = que.poll();
                deepestLeaves.add(node);
                
                if(node.left != null) que.offer(node.left);
                if(node.right != null) que.offer(node.right);
            }
        }

       Set<TreeNode> currentSet = new HashSet<>(deepestLeaves);
        while (currentSet.size() > 1) {
            Set<TreeNode> parentsSet = new HashSet<>();
            for (TreeNode node : currentSet) {
                parentsSet.add(pt.get(node));
            }
            currentSet = parentsSet;
        }
        
        return currentSet.iterator().next();
    }
}