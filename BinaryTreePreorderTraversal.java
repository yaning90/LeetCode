
// version 1, preorder traversal

public class Solution {
    public ArrayList<Integer> preorderTraversal(TreeNode root) {
        ArrayList<Integer> result = new ArrayList<Integer>();
        traverse(root, result);
        return result;
    }
    
    private void traverse(TreeNode root, ArrayList<Integer> result) {
        if (root == null) {
            return;
        }

        result.add(root.val);
        traverse(root.left, result);
        traverse(root.right, result);
    }
}

// version 2, Divide and Conquer

public class Solution {
    public List<Integer> preorderTraversal(TreeNode root) {
        // divide and conquer
        List<Integer> ans = new ArrayList<Integer>();
        if(root==null) return ans;
        // divide
        List<Integer> left = preorderTraversal(root.left);
        List<Integer> right = preorderTraversal(root.right);
        // conquer
        ans.add(root.val);  // add加的是一个元素 integer
        ans.addAll(left);  // addAll加的是一个list中所有的元素，括号中是一个list
        ans.addAll(right);
        return ans;
    }
}

// version 3, iterative

public class Solution {
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> ans = new ArrayList<Integer>();
        Stack<TreeNode> stack = new Stack<>();
        if(root==null) return ans;
        stack.push(root);
        while(!stack.isEmpty()){
            TreeNode top = stack.pop();
            ans.add(top.val);
            if(top.right!=null){
                stack.push(top.right);
            }
            if(top.left!=null){
                stack.push(top.left);
            }
        }
        return ans;
    }
}




