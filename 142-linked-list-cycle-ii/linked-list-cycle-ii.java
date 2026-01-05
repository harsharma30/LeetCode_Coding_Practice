public class Solution {
    public ListNode detectCycle(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        ListNode temp = head;

        while( fast!=null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
            if(slow==fast) break;
        }
        if(fast==null || fast.next==null) return null;
        while(temp!=slow){
            temp = temp.next;
            slow = slow.next;
        }
        return temp;
    }
}