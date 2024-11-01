
class Solution {
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        //[1,2,4] , [1,3,4]
        // 1,1,2,3,4,4,
        //0->1->1->2->3->4->4
        //h
        //return h.next
        //1->1->2->3->4->4
       ListNode newHead = new ListNode(0);//creating new Head pointing to 0 
       ListNode curr=newHead;//pointer to pointing prev node
       //traverse through list
       while(list1 != null && list2 != null){
        if(list1.val<list2.val){
            curr.next=list1;
            list1=list1.next;
        }
        else{
            curr.next=list2;
            list2=list2.next;
        }
        curr=curr.next;
       }
       if(list1==null){
        curr.next=list2;
       }
       if(list2==null){
        curr.next=list1;
       }

       return newHead.next;
    }
}