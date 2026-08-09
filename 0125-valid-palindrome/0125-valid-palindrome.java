class Solution {
    public boolean isPalindrome(String s) {
        int left = 0;
        int right = s.length() - 1;

        while(left <= right){
            char lchar = s.charAt(left);
            char rchar = s.charAt(right);

            if(lchar >= 'A' && lchar <= 'Z'){
                lchar = (char) (lchar + 32);
            }else if(!((lchar >= 'a' && lchar <= 'z') || (lchar >= '0' && lchar <= '9'))){
                left++;
                continue;
            }

            if(rchar >= 'A' && rchar <= 'Z'){
                rchar = (char) (rchar + 32);
            }else if(!((rchar >= 'a' && rchar <= 'z') || (rchar >= '0' && rchar <= '9'))){
                right--;
                continue;
            }

            if(lchar != rchar) {
                return false;
            }

            left++;
            right--;
        }
        return true;
    }
}