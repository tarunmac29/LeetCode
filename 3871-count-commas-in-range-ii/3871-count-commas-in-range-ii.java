public class Solution {
    public long countCommas(long n) {
        long totalCommas = 0;
        long threshold = 1000;

        // Loop through thresholds: 1,000, 1,000,000, 1,000,000,000, etc.
        while (n >= threshold) {
            totalCommas += (n - threshold + 1);
            
            // Prevent potential overflow before multiplying by 1000
            if (threshold > Long.MAX_VALUE / 1000) {
                break;
            }
            threshold *= 1000;
        }

        return totalCommas;
    }
}
