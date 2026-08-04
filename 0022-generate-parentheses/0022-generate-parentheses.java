class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> ans = new ArrayList<>();

        char[] curr = new char[2 * n];

        solve(ans, curr, 0, 0, 0, n);

        return ans;
    }

    public static void solve(List<String> ans, char[] curr, int idx, int open, int close, int n){
        if(idx == 2 * n){
            ans.add(new String(curr));
            return;
        }

        if(open < n){
            curr[idx] = '(';
            solve(ans, curr, idx + 1, open + 1, close, n);
        }

        if(close < open){
            curr[idx] = ')';
            solve(ans, curr, idx + 1, open, close + 1, n);
        }
    }
}