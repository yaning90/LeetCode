/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Solution {
    private TreeNode pre = null;
    private TreeNode first = null;
    private TreeNode second = null;
    
    public void recoverTree(TreeNode root) {
        findNodes(root);
        swap(first, second);
    }
    public void findNodes(TreeNode root){
        if(root == null){
            return;
        }
        // in-order traversal
        findNodes(root.left);
        if(pre != null && root.val < pre.val){
            if(first == null){
                first = pre;
                second = root;
            }else{
                second = root;
            }
        }
        pre = root;
        findNodes(root.right);
    }
    public void swap(TreeNode first, TreeNode second){ // swap the node's value, not node itself
        int temp;
        temp = first.val;
        first.val = second.val;
        second.val = temp;
    }
}
