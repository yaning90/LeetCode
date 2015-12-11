/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

// version 1 O(nlogn)
public class Solution {
    public TreeNode sortedListToBST(ListNode head) {
        if(head == null){
            return null;
        }
        ListNode slow = head, fast = head;
        ListNode pre = null;
        while(fast != null && fast.next != null){
            pre = slow;
            slow = slow.next;
            fast = fast.next.next;
        }
        ListNode headRight = slow.next;
        TreeNode root = new TreeNode(slow.val);
        if(pre != null){
            pre.next = null;
        }else{
            head = null;
        }
        root.left = sortedListToBST(head);
        root.right = sortedListToBST(headRight);
        return root;
        
    }
}

// version 2 O(n)
public class Solution {
    private ListNode current;
    
    private int getListLength(ListNode head){
        int size = 0;
        while(head != null){
            size++;
            head = head.next;
        }
        return size;
    }
    public TreeNode sortedListToBST(ListNode head) {
        int size;
        size = getListLength(head);
        current = head;
        return sortedListToBSTHelper(size);
        
    }
    public TreeNode sortedListToBSTHelper(int size){
        if(size <= 0){
            return null;
        }
        TreeNode left = sortedListToBSTHelper(size / 2);
        TreeNode root = new TreeNode(current.val);
        current = current.next;
        TreeNode right = sortedListToBSTHelper(size - 1 - size / 2);
        root.left = left;
        root.right = right;
        return root;
        
    }
}
