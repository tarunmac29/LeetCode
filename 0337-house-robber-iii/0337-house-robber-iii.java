class Solution {
    public int rob(TreeNode root) {
        int[] ans = solve(root);

        return Math.max(ans[0], ans[1]);
    }

    public int[] solve(TreeNode root) {

        // Base case
        if (root == null) {
            return new int[]{0, 0};
        }

        // Left subtree
        int[] left = solve(root.left);

        // Right subtree
        int[] right = solve(root.right);

        // If we rob current node,
        // we cannot rob its children
        int rob = root.val + left[0] + right[0];

        // If we don't rob current node,
        // children can either be robbed or not
        int notRob = Math.max(left[0], left[1])
                   + Math.max(right[0], right[1]);

        return new int[]{notRob, rob};
    }
}