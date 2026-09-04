class Solution {
    public int firstStableIndex(int[] nums, int k) {
        int n = nums.length;
        if (n == 0) return -1;

        // Step 1: Precompute suffix minimums
        // suffixMin[i] stores the minimum value from index i to n-1
        int[] suffixMin = new int[n];
        suffixMin[n - 1] = nums[n - 1];
        for (int i = n - 2; i >= 0; i--) {
            suffixMin[i] = Math.min(nums[i], suffixMin[i + 1]);
        }

        // Step 2: Iterate to find the first stable index
        int prefixMax = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            // Track the maximum value from index 0 to i
            prefixMax = Math.max(prefixMax, nums[i]);

            // Calculate the instability score using long to prevent overflow
            long instabilityScore = (long) prefixMax - suffixMin[i];

            // If it satisfies the stability condition, return immediately
            if (instabilityScore <= k) {
                return i;
            }
        }

        return -1;
    }
}