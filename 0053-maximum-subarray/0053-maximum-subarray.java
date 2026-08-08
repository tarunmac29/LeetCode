class Solution {
    public int maxSubArray(int[] nums) {
        int maxSum = nums[0];
        int max = 0;
        int i = 0;
        int j = 0;
        while(j < nums.length){
            max += nums[j];

            maxSum = Math.max(maxSum, max);

            while(max < 0 && i <= j){
                max -= nums[i];
                i++;
            }
            j++;
        }

        return maxSum;
    }
}