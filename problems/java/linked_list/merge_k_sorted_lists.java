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
    public ListNode mergeKLists(ListNode[] lists) {
        PriorityQueue<int[]> heap = new PriorityQueue<>( (a,b) -> Integer.compare(a[0],b[0]) );
	    ListNode sol = null;
        ListNode res = null;

        for(int i=0; i<lists.length; i++) {
	    	if (lists[i] != null) {
	    		int[] cur = new int[2];
	    		cur[0] = lists[i].val;
	    		cur[1] = i;
	    		heap.add(cur); // O(logn)
            }
        }

        while(heap.size() != 0) {
        	int[] cur = heap.poll();
        	ListNode curNode = lists[cur[1]];
        	lists[cur[1]] = curNode.next;
            curNode.next = null;

        	if (sol == null){
                sol = curNode;
                res = sol;
            } 
            else {
                sol.next = curNode;
                sol = curNode;
            }

	        if (lists[cur[1]] != null){
	        	cur[0] = lists[cur[1]].val;
	        	heap.add(cur);
            }
        }

        return res;
    }
}
