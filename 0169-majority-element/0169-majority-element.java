class Solution {
    public int majorityElement(int[] nums) {
        int i = 0;
        int j = 0;
        int count = 0;

        while(j <= nums.length - 1){
            if(count == 0) i = j;

            if(nums[i] == nums[j]){
                count++;
                j++;
            }else{
                count--;
                j++;
            }
        }

        return nums[i];
    }
}