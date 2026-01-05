public class Solution {
    public boolean hasCycle(ListNode head) {
		    if(head==null || head.next==null)return false;
		    
		    ListNode T1 = head;
		    ListNode T2 = head.next;
		    
		    while(T2!=null && T2.next!=null){
			    if(T1==T2) return true;
			    T1 = T1.next;
			    T2 = T2.next.next;
			   }
			    return false;
     }
}