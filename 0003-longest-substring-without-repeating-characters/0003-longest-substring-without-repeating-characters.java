class Solution {
    public int lengthOfLongestSubstring(String s) {
        int[] seen = new int[256];

        int left = 0;
        int right = 0;
        int maxLen = 0;

        while(right < s.length()){
            char ch = s.charAt(right);

            while(seen[ch] == 1){
                seen[s.charAt(left)]--;
                left++;
            }

            seen[ch]++;
            maxLen = Math.max(maxLen, right - left + 1);
            right++;
        }

        return maxLen;
    }
}