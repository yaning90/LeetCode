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
    public TreeNode invertTree(TreeNode root) {
        invertTreeHelper(root);
        return root;
    }                                                 //注意返回值，因为这个返回值我们再写个helper函数做交换
    public void invertTreeHelper(TreeNode root){
        if(root==null){
            return;
        }
        TreeNode temp = root.left;
        root.left = root.right;
        root.right= temp;
        invertTreeHelper(root.left);
        invertTreeHelper(root.right);
    }
}
