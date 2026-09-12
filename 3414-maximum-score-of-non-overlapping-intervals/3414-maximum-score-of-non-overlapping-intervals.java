import java.util.*;

class Solution {
    public int[] maximumWeight(List<List<Integer>> intervals) {
        int n = intervals.size();
        
        // Store interval data: [start, end, weight, original_index]
        int[][] sortedIntervals = new int[n][4];
        for (int i = 0; i < n; i++) {
            sortedIntervals[i][0] = intervals.get(i).get(0);
            sortedIntervals[i][1] = intervals.get(i).get(1);
            sortedIntervals[i][2] = intervals.get(i).get(2);
            sortedIntervals[i][3] = i; 
        }
        
        // Sort intervals based on the end time to efficiently find non-overlapping intervals
        Arrays.sort(sortedIntervals, Comparator.comparingInt(a -> a[1]));
        
        // dp[i][j] stores the best State considering the first i intervals and selecting j intervals
        State[][] dp = new State[n + 1][5];
        for (int i = 0; i <= n; i++) {
            for (int j = 0; j <= 4; j++) {
                dp[i][j] = new State(0L, new ArrayList<>());
            }
        }
        
        for (int i = 1; i <= n; i++) {
            int start = sortedIntervals[i - 1][0];
            int weight = sortedIntervals[i - 1][2];
            int originalIndex = sortedIntervals[i - 1][3];
            
            // Binary search to find the latest valid interval that ends before current one starts
            // (Strictly smaller than start since sharing a boundary means overlapping)
            int k = findLatestNonOverlapping(sortedIntervals, start, i - 1);
            
            for (int j = 1; j <= 4; j++) {
                // Choice 1: Skip the current interval
                State skip = dp[i - 1][j];
                
                // Choice 2: Take the current interval
                long takeWeight = dp[k][j - 1].weight + weight;
                List<Integer> takeIndices = new ArrayList<>(dp[k][j - 1].indices);
                takeIndices.add(originalIndex);
                Collections.sort(takeIndices); 
                
                State take = new State(takeWeight, takeIndices);
                
                // Keep the best configuration
                dp[i][j] = getBest(skip, take);
            }
        }
        
        // Convert the best indices list into the required int array
        List<Integer> bestIndices = dp[n][4].indices;
        int[] result = new int[bestIndices.size()];
        for (int i = 0; i < result.length; i++) {
            result[i] = bestIndices.get(i);
        }
        
        return result;
    }
    
    // Finds the largest index of an interval that ends before the targetStart
    private int findLatestNonOverlapping(int[][] intervals, int targetStart, int maxIdx) {
        int left = 0, right = maxIdx - 1;
        int res = -1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (intervals[mid][1] < targetStart) {
                res = mid;
                left = mid + 1; // Try to find a later one
            } else {
                right = mid - 1;
            }
        }
        return res + 1; // +1 because the DP array is 1-based indexing
    }
    
    // Returns the optimal state (maximum weight, and tie-breaks with lexicographically smaller indices)
    private State getBest(State a, State b) {
        if (a.weight > b.weight) return a;
        if (b.weight > a.weight) return b;
        
        // If weights are equal, tie-break with lexicographically smaller sorted indices
        int minSize = Math.min(a.indices.size(), b.indices.size());
        for (int i = 0; i < minSize; i++) {
            int cmp = a.indices.get(i).compareTo(b.indices.get(i));
            if (cmp < 0) return a;
            if (cmp > 0) return b;
        }
        
        // If all compared elements are identical, prefer the shorter list (though our loops manage sizes well)
        if (a.indices.size() < b.indices.size()) return a;
        if (b.indices.size() < a.indices.size()) return b;
        
        return a;
    }
    
    // Helper class to encapsulate DP State
    class State {
        long weight;
        List<Integer> indices;
        
        State(long weight, List<Integer> indices) {
            this.weight = weight;
            this.indices = indices;
        }
    }
}