class Solution {
    public int[] sortedSquares(int[] nums) {
        int low = 0;
        int high = nums.length - 1;

        int[] res = new int[nums.length];
        int idx = res.length - 1;


        while(low <= high){
            int lowS = nums[low] * nums[low];
            int highS = nums[high] * nums[high];

            if(lowS < highS){
                res[idx] = highS;
                high--;
            }else{
                res[idx] = lowS;
                low++;
            }
            idx--;
        }

        return res;
    }
}