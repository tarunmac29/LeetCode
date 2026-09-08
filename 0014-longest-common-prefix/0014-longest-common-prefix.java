import java.util.Arrays;

class Solution {
    public String longestCommonPrefix(String[] strs) {
        // Handle edge case where array is null or empty
        if (strs == null || strs.length == 0) {
            return "";
        }
        
        // Sort the array alphabetically
        Arrays.sort(strs);
        
        // Compare characters between the first and the last string
        String first = strs[0];
        String last = strs[strs.length - 1];
        int index = 0;
        
        while (index < first.length() && index < last.length()) {
            if (first.charAt(index) == last.charAt(index)) {
                index++;
            } else {
                break;
            }
        }
        
        // Return the common prefix substring
        return first.substring(0, index);
    }
}
