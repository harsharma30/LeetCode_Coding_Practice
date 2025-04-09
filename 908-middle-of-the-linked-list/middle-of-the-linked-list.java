class Solution {
    public ListNode middleNode(ListNode head) {
        int length = 0;
        ListNode current = head;
        while(current != null){
            current = current.next;
            length++;
        }

        int middle = length/2;
        current = head;
        for(int i=0; i<middle; i++){
            current = current.next;
        }
        return current;
    }
}