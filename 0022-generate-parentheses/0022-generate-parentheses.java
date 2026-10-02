class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> ans = new ArrayList<>();
        genCom(n, "", 0, ans, 0, 0);
        return ans;
    }

    public void genCom(int n, String sb, int idx, List<String> ans, int open, int close){
        if(idx == n * 2){
            ans.add(sb);
            return;
        }

        if(open < n) genCom(n, sb + "(", idx + 1, ans, open + 1, close);
        if(close < open) genCom(n, sb + ")", idx + 1, ans, open, close + 1);
    }
}