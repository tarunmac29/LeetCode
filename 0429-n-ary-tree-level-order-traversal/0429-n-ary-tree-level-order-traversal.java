/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }
};
*/

class Solution {
    public List<List<Integer>> levelOrder(Node root) {
        List<List<Integer>> ans = new ArrayList<>();
        if(root == null) return ans;

        Queue<Node> que = new ArrayDeque<>();

        que.offer(root);

        while(!que.isEmpty()){
            int level = que.size();
            List<Integer> list = new ArrayList<>();

            for(int i = 0; i < level; i++){
                Node node = que.poll();
                list.add(node.val);

                if (node.children != null) {
                    for (Node child : node.children) {
                        if (child != null) {
                            que.offer(child);
                        }
                    }
                }
            }
            ans.add(list);
        }
        return ans;
    }
}