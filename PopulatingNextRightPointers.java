/**
 * Definition for binary tree with next pointer.
 * public class TreeLinkNode {
 *     int val;
 *     TreeLinkNode left, right, next;
 *     TreeLinkNode(int x) { val = x; }
 * }
 */
// version 1 recursion
public class Solution {
    public void connect(TreeLinkNode root) {
        if(root == null){
            return;
        }
        if(root.left != null){
            root.left.next = root.right;
        }
        if(root.right != null){
            root.right.next = root.next == null? null : root.next.left;
        }
        connect(root.left);
        connect(root.right);
    }
}

// version 2 iteration using queue
// /**
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
        Queue<TreeLinkNode> queue = new LinkedList<TreeLinkNode>();
        queue.offer(root);
        while(!queue.isEmpty()){
            int size = queue.size();
            for(int i = 0; i < size; i++){
                TreeLinkNode node = queue.poll();
                if(node.left == null){
                    return;
                }
                if(node.left != null){
                    node.left.next = node.right;
                }
                if(node.right != null){
                    node.right.next = node.next == null ? null : node.next.left;
                }
                queue.offer(node.left);
                queue.offer(node.right);
            }
        }
    }
}
