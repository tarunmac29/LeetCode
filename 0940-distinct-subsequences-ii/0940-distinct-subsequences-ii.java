public class Solution {
    public int distinctSubseqII(String s) {
        int MOD = 1_000_000_007;
        int n = s.length();
        
        // dp[i] stores the number of distinct subsequences using the first i characters
        int[] dp = new int[n + 1];
        dp[0] = 1; // Base case: empty string has 1 subsequence (the empty one)
        
        // Track the last seen index of each character ('a' to 'z')
        int[] lastSeen = new int[26];
        Arrays.fill(lastSeen, -1);
        
        for (int i = 1; i <= n; i++) {
            char c = s.charAt(i - 1);
            int charIndex = c - 'a';
            
            // Standard case: doubling the existing subsequences
            dp[i] = (dp[i - 1] * 2) % MOD;
            
            // If the character has appeared before, subtract the duplicates
            if (lastSeen[charIndex] != -1) {
                int prevIndex = lastSeen[charIndex];
                dp[i] = (dp[i] - dp[prevIndex - 1] + MOD) % MOD;
            }
            
            // Record the current position for this character
            lastSeen[charIndex] = i;
        }
        
        // Subtract 1 to exclude the empty subsequence, then ensure the result is positive
        return (dp[n] - 1 + MOD) % MOD;
    }
}
