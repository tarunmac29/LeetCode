/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode removeElements(ListNode head, int val) {
        ListNode temp = new ListNode(0, head);
        ListNode prev = temp;
        while(prev.next != null){
            if(prev.next.val != val){
                prev = prev.next;
            }else{
                prev.next = prev.next.next;
            }
        }

        return temp.next;
    }
}