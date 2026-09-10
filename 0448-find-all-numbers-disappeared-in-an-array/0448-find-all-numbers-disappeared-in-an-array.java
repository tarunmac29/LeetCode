class Solution {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        List<Integer> result = new ArrayList<>();
        
        // Step 1: Iterate through the array and mark visited indices as negative
        for (int i = 0; i < nums.length; i++) {
            // Use Math.abs because the value might have already been flipped negative
            int index = Math.abs(nums[i]) - 1; 
            
            if (nums[index] > 0) {
                nums[index] = -nums[index];
            }
        }
        
        // Step 2: Any index that is still positive means its matching number (index + 1) never appeared
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > 0) {
                result.add(i + 1);
            }
        }
        
        return result;
    }
}
