public class Solution {
    public boolean isBalanced(TreeNode root) {
        if(root==null) return true;
        return isBalanced(root.left)&&isBalanced(root.right)&&Math.abs(maxDepth(root.left)-maxDepth(root.right))<=1;
    }
    
    public int maxDepth(TreeNode root){
        if(root==null) return 0;
        int left = maxDepth(root.left);
        int right = maxDepth(root.right);
        return Math.max(left,right)+1;
    }
}
