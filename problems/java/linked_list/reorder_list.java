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

        // find the half
        ListNode    slow        = head;
        ListNode    prevSlow    = null;
        ListNode    fast        = head;

        while (fast!=null && fast.next!=null)
        {
            fast        = fast.next.next;
            prevSlow    = slow;
            slow        = slow.next;
        }
        if(prevSlow == null)
            return;
        prevSlow.next = null;
        // slow now has the beginning node of middle

        // flip the second half (flow slow)
        ListNode prev = null;
        while(slow !=null)
        {
            ListNode temp = slow.next;
            slow.next = prev;
            prev = slow;
            slow = temp;
        }

        // merge the two halfs ( head and prev)
        int i=0;
        while(head != null)
        {
            if (i%2==0)
            {
                ListNode temp = head.next;
                head.next = prev;
                head = temp;
            }
            else /* i%2==1 */
            {
                ListNode temp = prev.next;
                prev.next = head;
                prev = temp;
            }
            i++;
        }
    }

    // public void reorderListArrayListSolution(ListNode head) 
    // {
    //     HashMap<Integer,ListNode> hash = new HashMap<>();

    //     int n=0;
    //     while (head != null)
    //     {
    //         hash.put(n++, head);
    //         head = head.next;
    //     }

    //     int a = 0;
    //     int b = n-1;
    //     int i = 0;
    //     while ( i < n )
    //     {
    //         if(i%2 == 0)
    //         {
    //             if (i==n-1)
    //             {
    //                 hash.get(a).next = null;
    //             }
    //             else
    //             {
    //                 hash.get(a++).next = hash.get(b);
    //             }
    //         }
    //         if(i%2 == 1)
    //         {
    //             if (i==n-1)
    //             {
    //                 hash.get(b).next = null;
    //             }
    //             else
    //             {
    //                 hash.get(b--).next = hash.get(a);
    //             }
    //         }
    //         i++;
    //     }
    // }
}
