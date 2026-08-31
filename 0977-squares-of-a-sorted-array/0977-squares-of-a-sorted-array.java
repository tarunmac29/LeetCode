class Solution {
    public int[] sortedSquares(int[] nums) {
        int left = 0;
        int right = nums.length - 1;

        int[] arr = new int[nums.length];

        int idx = arr.length - 1;

        while(left <= right){
            int leftS = nums[left] * nums[left];
            int rightS = nums[right] * nums[right];

            if(leftS < rightS){
                arr[idx] = rightS;
                right--;
            }else{
                arr[idx] = leftS;
                left++;
            }
            idx--;
        }

        return arr;
    }
}