class Solution {
    int[] memo;

    public int fib(int n) {
        memo = new int[n + 1];
        return dpMemo(n);
    }

    int dpMemo(int n) {
        if (n <= 1) return n;

        if (memo[n] != 0)
            return memo[n];

        memo[n] = dpMemo(n - 1) + dpMemo(n - 2);
        return memo[n];
    }
}



// class Solution {
//     public int fib(int n) {
//         if (n == 0) return 0;

//         if (n == 1) return 1;

//         return fib(n - 1) + fib(n - 2);
//     }
// }

// class Solution {
//     public int fib(int n) {
//         if (n <= 1) return n;

//         int[] dp = new int[n + 1];
//         dp[0] = 0;
//         dp[1] = 1;

//         for (int i = 2; i <= n; i++) {
//             dp[i] = dp[i - 1] + dp[i - 2];
//         }

//         return dp[n];
//     }
// }