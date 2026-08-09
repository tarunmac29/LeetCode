class Solution {
    public boolean isAnagram(String s, String t) {
        if(s.length() != t.length()){
            return false;
        }

        int[] ans = new int[26];

        for (int i = 0; i < s.length(); i++) {
            ans[s.charAt(i) - 'a']++; 
            ans[t.charAt(i) - 'a']--;
        }


        return Arrays.stream(ans).allMatch(x -> x == 0);
    }
}