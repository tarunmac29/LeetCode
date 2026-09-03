class Solution {
    public boolean uniformArray(int[] nums1) {
        int minOdd = Integer.MAX_VALUE;
        
        // Step 1: Find the smallest odd number in the array
        for (int num : nums1) {
            if (num % 2 != 0) {
                minOdd = Math.min(minOdd, num);
            }
        }
        
        // Step 2: Validate if any even number violates the constraint
        for (int num : nums1) {
            if (num % 2 == 0 && minOdd != Integer.MAX_VALUE && num < minOdd) {
                return false;
            }
        }
        
        return true;
    }
}
