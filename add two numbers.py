class Solution:
    def addTwoNumbers(self, l1: Optional[ListNode], l2: Optional[ListNode]) -> Optional[ListNode]:
        dummy = ListNode()
        curr = dummy
        t1, t2 = l1, l2
        carry = 0

        while t1 or t2:
            sum = carry
            if t1: sum += t1.val
            if t2: sum += t2.val
            
            node = ListNode(sum % 10)
            carry = sum // 10

            curr.next = node
            curr = curr.next

            if t1: t1 = t1.next
            if t2: t2 = t2.next
        if carry != 0:
            node = ListNode(carry)
            curr.next = node
        return dummy.next
