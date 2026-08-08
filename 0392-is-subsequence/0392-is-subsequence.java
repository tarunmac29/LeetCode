class Solution {
    public boolean isSubsequence(String s, String t) {
        if (s.length() == 0) return true;
        if (s.length() > t.length()) return false;

        char[] sChars = s.toCharArray();
        char[] tChars = t.toCharArray();

        int i = 0;
        int j = 0;

        while (i < sChars.length && j < tChars.length) {
            if (sChars[i] == tChars[j]) {
                i++;
            }
            j++;
        }

        return i == sChars.length;
    }
}
