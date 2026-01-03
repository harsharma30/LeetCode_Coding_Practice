class Solution {
    public ListNode mergeTwoLists(ListNode h1, ListNode h2) {
        if(h1!=null && h2!=null){
            if(h1.val<h2.val){
                h1.next = mergeTwoLists(h1.next,h2);
                return h1;
            }
            else{
                h2.next = mergeTwoLists(h1,h2.next);
                return h2;
            }
        }
        if(h1==null)
            return h2;
        return h1;
    }
}