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
class Tuple {
    TreeNode node;
    int vertical;

    Tuple(TreeNode node, int vertical) {
        this.node = node;
        this.vertical = vertical;
    }
}
class Solution {
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        if(root == null) return ans;
        TreeMap<Integer, Integer> map = new TreeMap<>();

        Queue<Tuple> que = new ArrayDeque<>();

        que.offer(new Tuple(root, 0));

        while(!que.isEmpty()){
            Tuple tuple = que.poll();

            TreeNode node = tuple.node;
            int x = tuple.vertical;

            map.put(x, node.val);

            if(node.left != null) que.offer(new Tuple(node.left, x+1));
            if(node.right != null) que.offer(new Tuple(node.right, x+1));
        }

        for(int val : map.values()){
            ans.add(val);
        }

        return ans;
    }
}