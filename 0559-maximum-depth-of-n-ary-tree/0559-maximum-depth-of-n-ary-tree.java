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
    public int maxDepth(Node root) {
        if(root == null) return 0;

        Queue<Node> que = new ArrayDeque<>();

        que.offer(root);

        int count = 0;

        while(!que.isEmpty()){
            int level = que.size();

            for(int i = 0; i < level; i++){
                Node node = que.poll();

                if(node.children != null){
                    for (Node child : node.children) {
                        if (child != null) {
                            que.offer(child);
                        }
                    }
                }
            }

            count++;
        }

        return count;
    }
}