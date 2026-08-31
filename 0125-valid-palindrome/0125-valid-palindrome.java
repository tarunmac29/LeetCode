class Solution {
    public boolean isPalindrome(String s) {
        int left = 0;
        int right = s.length() - 1;

        while(left <= right){
            char lChar = s.charAt(left);
            char rChar = s.charAt(right);

            if(lChar >= 'A' && lChar <= 'Z'){
                lChar = (char) (lChar + 32);
            }else if(!((lChar >= 'a' && lChar <= 'z') || (lChar >= '0' && lChar <= '9'))){
                left++;
                continue;
            }

            if(rChar >= 'A' && rChar <= 'Z'){
                rChar = (char) (rChar + 32);
            }else if(!((rChar >= 'a' && rChar <= 'z') || (rChar >= '0' && rChar <= '9'))){
                right--;
                continue;
            }

            if(lChar != rChar){
                return false;
            }

            left++;
            right--;
        }

        return true;
    }
}