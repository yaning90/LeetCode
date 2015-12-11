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
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> answers = new ArrayList<List<Integer>>();
        if(root==null){
            return answers;
        }
        int flag = 0;
        Stack<TreeNode> stack1 = new Stack<>();
        Stack<TreeNode> stack2 = new Stack<>();
        stack1.add(root);
        while(!stack1.isEmpty()||!stack2.isEmpty()){
            List<Integer> answer = new ArrayList<Integer>();
            if(flag%2==0){
                while(!stack1.isEmpty()){
                    TreeNode node = stack1.pop();
                    answer.add(node.val);
                    if(node.left!=null) stack2.push(node.left);
                    if(node.right!=null) stack2.push(node.right);
                }
            }else{
               while(!stack2.isEmpty()){
                   TreeNode node = stack2.pop();
                   answer.add(node.val);
                   if(node.right!=null) stack1.push(node.right);
                   if(node.left!=null) stack1.push(node.left);
               }
            }
            flag++;
            answers.add(answer);
        }
        return answers;
    }
}
