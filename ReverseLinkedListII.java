

public class Solution {
    public ListNode reverseBetween(ListNode head, int m, int n) {
        if(head==null||m==n||head.next==null){
            return head;
        }
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode pre = dummy;
        for(int i=1;i<m;i++){
            pre = pre.next;
            head = head.next;
        }
        // record the previous m node 
        ListNode premNode = pre;
        ListNode mNode = pre.next;
        for(int j=0;j<=n-m;j++){
            ListNode temp = head.next;
            head.next = pre;
            pre = head;
            head = temp;
        }
        premNode.next = pre;
        mNode.next=head;
        return dummy.next;
    }
}
