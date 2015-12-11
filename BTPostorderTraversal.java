
// recursive traversal
//
public class Solution {
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> ans = new ArrayList<Integer>();
        postorderTraversalHelper(root,ans);
        return ans;
    }
    public void postorderTraversalHelper(TreeNode root, List<Integer> ans){
        if(root==null) return;
        postorderTraversalHelper(root.left,ans);
        postorderTraversalHelper(root.right,ans);
        ans.add(root.val);
    }
}

// iterative
//

