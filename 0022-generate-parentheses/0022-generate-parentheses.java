class Solution {
    public List<String> generateParenthesis(int n) {

        List<String> ans = new ArrayList<>();

        genCom(n, "", ans, 0, 0, 0);

        return ans;
    }

    public void genCom(int n, String sb, List<String> ans, int idx, int open, int close){
        if(idx == 2 * n){
            ans.add(sb);
            return;
        }

        if(open < n){
            genCom(n, sb + "(", ans, idx + 1, open + 1, close);
        }

        if(close < open) genCom(n, sb +")", ans, idx + 1, open, close + 1);
    }
}