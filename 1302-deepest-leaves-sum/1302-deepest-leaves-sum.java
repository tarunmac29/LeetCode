import java.util.ArrayList;
import java.util.List;

class Solution {
    // A dynamic list to store the sum of each level
    private List<Integer> levelSums;

    public int deepestLeavesSum(TreeNode root) {
        levelSums = new ArrayList<>();
        calculateSums(root, 0);
        
        // The last element in the list will be the deepest level's sum
        return levelSums.get(levelSums.size() - 1);
    }

    private void calculateSums(TreeNode node, int depth) {
        if (node == null) return;

        // If this is the first time reaching this depth, add a new level sum
        if (depth == levelSums.size()) {
            levelSums.add(node.val);
        } else {
            // Otherwise, add the node's value to the existing sum for this depth
            levelSums.set(depth, levelSums.get(depth) + node.val);
        }

        // Standard DFS traversal
        calculateSums(node.left, depth + 1);
        calculateSums(node.right, depth + 1);
    }
}
