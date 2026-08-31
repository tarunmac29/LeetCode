class Solution {
    public int[] nodesBetweenCriticalPoints(ListNode head) {

        int firstCritical = -1;
        int previousCritical = -1;

        int minDistance = Integer.MAX_VALUE;
        int maxDistance = -1;

        ListNode prev = head;
        ListNode curr = head.next;

        int position = 2;

        while (curr.next != null) {

            ListNode next = curr.next;

            // Check whether curr is a critical point
            boolean isCritical =
                    (curr.val > prev.val && curr.val > next.val) ||
                    (curr.val < prev.val && curr.val < next.val);

            if (isCritical) {

                // First critical point
                if (firstCritical == -1) {
                    firstCritical = position;
                }

                // From second critical point onwards
                if (previousCritical != -1) {
                    int distance = position - previousCritical;

                    minDistance = Math.min(minDistance, distance);
                }

                previousCritical = position;
            }

            prev = curr;
            curr = next;
            position++;
        }

        // Less than 2 critical points
        if (firstCritical == -1 || firstCritical == previousCritical) {
            return new int[]{-1, -1};
        }

        // Distance between first and last critical point
        maxDistance = previousCritical - firstCritical;

        return new int[]{minDistance, maxDistance};
    }
}