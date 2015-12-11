
// version 1, O(n) space, O(n) time
public class Solution {
    public boolean isPalindrome(ListNode head) {
       int len = 0;
       ListNode dummyHead = head;
       while(head!=null){
           len+=1;
           head=head.next;
       }
       int[] help = new int[len];
       for(int i=0;i<len;i++){
           help[i] = dummyHead.val;
           dummyHead = dummyHead.next;
       }
       for(int i=0,j=len-1;i<j;i++,j--){
           if(help[i]!=help[j]) return false;
       }
       return true;
    }
}

// version 2, O(1) space, O(n) time


