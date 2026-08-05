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
    public ListNode deleteDuplicates(ListNode head) {
        ListNode temp = new ListNode(0);
        temp.next = head;

        ListNode curr = temp.next;

        while(curr != null && curr.next != null){
            if(curr.val != curr.next.val){
                curr = curr.next;
            }else{
                curr.next = curr.next.next;
            }
        }

        return temp.next;
    }
}