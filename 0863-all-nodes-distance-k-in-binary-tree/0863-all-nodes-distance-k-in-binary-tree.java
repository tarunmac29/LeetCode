/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public void markParent(TreeNode root, Map<TreeNode, TreeNode> pt){
        Queue<TreeNode> que = new ArrayDeque<>();

        que.offer(root);

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
    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        Map<TreeNode, TreeNode> pt = new HashMap<>();
        markParent(root, pt);

        Map<TreeNode, Boolean> visited = new HashMap<>();
        Queue<TreeNode> que = new ArrayDeque<>();

        que.offer(target);
        visited.put(target, true);

        int cur_level = 0;

        while(!que.isEmpty()){
            int size = que.size();

            if(cur_level == k) break;

            cur_level++;

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

        List<Integer> ans = new ArrayList<>();

        while(!que.isEmpty()){
            ans.add(que.poll().val);
        }

        return ans;
    }
}