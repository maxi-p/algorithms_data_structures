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
class Solution 
{
    public ListNode removeNthFromEnd(ListNode head, int n) 
    {
        int i = 0;
        ListNode trav = head;
        while(trav != null)
        {
            trav = trav.next;
            i++;
        }
        int rem = i-n;

        trav = head;
        ListNode prev = null;
        i=0;
        while(i!=rem)
        {
            prev = trav;
            trav = trav.next;
            i++;
        }
        if (prev == null)
            head = trav.next;
        else
            prev.next = trav.next;

        return head;
    }
}
