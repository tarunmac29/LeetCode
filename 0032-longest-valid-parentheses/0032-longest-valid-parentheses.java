class Solution {
    public int longestValidParentheses(String s) {
        Stack<Integer> stk = new Stack<>();
        int maxLen = 0;
        stk.push(-1);

        for(int i = 0; i < s.length(); i++){
            char c = s.charAt(i);

            if(c == '('){
                stk.push(i);
            }else{
                stk.pop();

                if(stk.isEmpty()){
                    stk.push(i);
                }else{
                    int len = i - stk.peek();
                    maxLen = Math.max(maxLen, len);
                }
            }
        }

        return maxLen;
    }
}