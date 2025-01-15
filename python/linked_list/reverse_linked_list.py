# Definition for singly-linked list.
class ListNode:
    def __init__(self, val=0, next=None):
        self.val = val
        self.next = next



# Storage in a list solution

class Solution:
    def reverseList(self, head: Optional[ListNode]) -> Optional[ListNode]:
        if not head:
            return None

        i, li = 0, []
        temp = head

        while temp:
            li.append(temp)
            temp = temp.next

        res = ListNode(li[-1].val)
        temp = res

        for i in range(len(li)-2, -1, -1):
            temp.next = ListNode(li[i].val)
            temp = temp.next 

        return res

# Two pointer solution
class Solution:
    def reverseList(self, head: Optional[ListNode]) -> Optional[ListNode]:
        prev = None
        while head:
            temp = head.next
            head.next = prev
            prev = head
            head = temp
        
        return prev