class Solution {
    public int countCommas(int n) {
        int totalCommas = 0;
        int length = 1;
        long start = 1;

        // Iterate through each interval based on the number of digits
        while (start <= n) {
            long end = Math.min(n, start * 10 - 1);
            int commasPerNumber = (length - 1) / 3;
            
            // Count how many numbers fall into the [start, end] range
            long count = end - start + 1;
            totalCommas += count * commasPerNumber;

            // Advance to the next magnitude range
            start *= 10;
            length++;
        }

        return totalCommas;
    }
}
