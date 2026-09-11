class Solution {
    public int totalNumbers(int[] digits) {
        // Count the frequency of each digit available in the input array (size 10 for digits 0-9)
        int[] availableCounts = new int[10];
        for (int digit : digits) {
            availableCounts[digit]++;
        }
        
        int distinctEvenCount = 0;
        
        // Iterate through all possible 3-digit even numbers (100 to 998)
        for (int num = 100; num <= 998; num += 2) {
            int[] requiredCounts = new int[10];
            int temp = num;
            
            // Extract each digit of the current number
            while (temp > 0) {
                requiredCounts[temp % 10]++;
                temp /= 10;
            }
            
            // Check if the available digits can satisfy the required digits
            boolean canForm = true;
            for (int i = 0; i < 10; i++) {
                if (requiredCounts[i] > availableCounts[i]) {
                    canForm = false;
                    break;
                }
            }
            
            // If the number can be formed, increment our count
            if (canForm) {
                distinctEvenCount++;
            }
        }
        
        return distinctEvenCount;
    }
}
