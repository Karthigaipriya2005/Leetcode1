class Solution {
    public ListNode reverseBetween(ListNode head, int left, int right) {
        if (left == right) {
            return head;
        }

        int index = 1;
        ListNode pointer = head;
        ListNode lastNode = null;
        ListNode leftNode = head;
        ListNode leftNodeLeft = null;
        ListNode rightNode = head;
        
        while (pointer != null) {
            if (left == index) {
                leftNode = pointer;
                leftNodeLeft = lastNode;
            }
            
            if (right == index) {
                rightNode = pointer;
            }
            lastNode = pointer;
            pointer = pointer.next;
            index++;
        }
        
        ListNode rightNodeRight = rightNode.next;
        reverseBetween(leftNode, rightNode);
        
        if (leftNodeLeft != null) {
            leftNodeLeft.next = rightNode;
        }
        
        leftNode.next = rightNodeRight;
        
        if (leftNodeLeft == null) {
            return rightNode;
        } else {
            return head;
        }
    }

    private ListNode reverseBetween(ListNode head, ListNode tail) {
        ListNode newHead = tail;
        ListNode cur = head;
        ListNode last = tail.next;
        ListNode next = cur.next;

        while (cur != tail) {
            cur.next = last;
            last = cur;
            cur = next;
            next = next.next;
        }

        cur.next = last;

        return newHead;
    }
}
