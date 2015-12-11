/**
 * Definition for binary tree with next pointer.
 * public class TreeLinkNode {
 *     int val;
 *     TreeLinkNode left, right, next;
 *     TreeLinkNode(int x) { val = x; }
 * }
 */
public class Solution {
    public void connect(TreeLinkNode root) {
        if(root == null){
            return;
        }
        
        TreeLinkNode leftEnd = root;
        while(leftEnd != null){
            TreeLinkNode cur = leftEnd;
            TreeLinkNode dummy = new TreeLinkNode(0);
            TreeLinkNode pre = dummy;
            while(cur != null){
                if(cur.left != null){
                    pre.next = cur.left;
                    pre = cur.left;
                }
                
                if(cur.right != null){
                    pre.next = cur.right;
                    pre = cur.right;
                }
                
                cur = cur.next;
            }
            
            leftEnd = dummy.next;
        }
    }
}
