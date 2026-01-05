class Solution {
    public ListNode middleNode(ListNode head) {
        ListNode s1=head;
        int count = 0;
        int i = 0;
        ListNode temp = head;
        while(s1!=null){
            count+=1;
            s1 = s1.next;
        }
        while(i<count/2){
            temp = temp.next;
            i++;
        }
        return temp;
    }
}