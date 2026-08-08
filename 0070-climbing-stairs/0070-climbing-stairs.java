class Solution {
    public static int solve(int n, int step, int[] dp){
        if(step == n){
            return 1;
        }

        if(step > n){
            return 0;
        }

        if(dp[step] != -1){
            return dp[step];
        }

        dp[step] = solve(n, step + 1, dp) + solve(n, step + 2, dp);

        return dp[step];
    }

    public int climbStairs(int n) {
        int[] dp = new int[n+1];

        Arrays.fill(dp, -1);

        return solve(n, 0, dp);
    }
}