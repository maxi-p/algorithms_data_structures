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
    public ListNode reverseList(ListNode head) {
        ListNode prev = null;
        
        // [1,2,3,4,5]
        while(head != null){
            ListNode temp = head;
            // traversing
            head = head.next;
                      
            // flipping
            temp.next = prev;
            prev = temp;

        }

        return prev;
    }
}