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
    public static void traverse(Node root, List<Integer> ans){
        if(root == null) return;

        ans.add(root.val);

        if(root.children != null){
            for(Node node : root.children){
                if(node != null){
                    traverse(node, ans);
                }
            }
        }
    }
    public List<Integer> preorder(Node root) {
        List<Integer> ans = new ArrayList<>();

        traverse(root, ans);

        return ans;
    }
}