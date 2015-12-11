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
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> answer = new ArrayList<Integer>();
        if(root == null){
            return answer;
        }
        Queue<TreeNode> levelNode = new LinkedList<TreeNode>();
        levelNode.add(root);
        while(!levelNode.isEmpty()){
            int size = levelNode.size();
            for(int i = 0; i < size; i++){
                TreeNode node = levelNode.poll();
                if(i == size - 1){
                    answer.add(node.val);
                }
                if(node.left != null){
                   levelNode.offer(node.left); 
                }
                if(node.right != null){
                     levelNode.offer(node.right);
                }
            }
        }
        return answer;
    }
}
