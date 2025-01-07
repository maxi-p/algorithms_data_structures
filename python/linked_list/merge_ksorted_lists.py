# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next
import heapq

class Solution:
    def mergeKLists(self, lists: List[Optional[ListNode]]) -> Optional[ListNode]:
        heap = []
        res = None
        temp = None

        for index, node in enumerate(lists):
            if not node == None:
                heapq.heappush(heap,(node.val, index))
        
        while len(heap) > 0:
            cur = heapq.heappop(heap)
            curNode = lists[cur[1]]
            lists[cur[1]] = curNode.next
            curNode.next = None

            if temp == None:
                temp = curNode
                res = temp
            else:
                temp.next = curNode
                temp = temp.next

            if lists[cur[1]] != None:
                cur = (lists[cur[1]].val,cur[1])
                heapq.heappush(heap, cur)
        
        return res
        