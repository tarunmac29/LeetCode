class Solution {
    public int numDistinct(String s, String t) {
        int m = s.length();
        int n = t.length();
        
        // dp[j] will store the number of subsequences of s that match t[0...j-1]
        int[] dp = new int[n + 1];
        
        // Base case: an empty t can be formed by any prefix of s in 1 way
        dp[0] = 1;
        
        // Iterate through each character of s
        for (int i = 1; i <= m; i++) {
            // Traverse backwards to use the values from the previous iteration of s
            for (int j = n; j >= 1; j--) {
                if (s.charAt(i - 1) == t.charAt(j - 1)) {
                    dp[j] = dp[j] + dp[j - 1];
                }
                // If characters don't match, dp[j] remains unchanged (dp[i][j] = dp[i-1][j])
            }
        }
        
        return dp[n];
    }
}
