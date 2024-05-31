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
    public void reorderList(ListNode head) 
    {
        HashMap<Integer,ListNode> hash = new HashMap<>();

        int n=0;
        while (head != null)
        {
            hash.put(n++, head);
            head = head.next;
        }

        int a = 0;
        int b = n-1;
        int i = 0;
        while ( i < n )
        {
            if(i%2 == 0)
            {
                if (i==n-1)
                {
                    hash.get(a).next = null;
                }
                else
                {
                    hash.get(a++).next = hash.get(b);
                }
            }
            if(i%2 == 1)
            {
                if (i==n-1)
                {
                    hash.get(b).next = null;
                }
                else
                {
                    hash.get(b--).next = hash.get(a);
                }
            }
            i++;
        }
    }
}
