class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        if(head==null)
        return null;
        
        ListNode temp = head;
        ListNode diff = head.next;
        
        while(diff!=null){
	        if(temp.val != diff.val){
		        temp=temp.next;
		        temp.val=diff.val;
	        }
	        diff = diff.next;
        }
        temp.next = null;
        return head;
    }
}