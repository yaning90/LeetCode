
// 静态变量是属于整个类的，能被所有对象用，相当于全局变量
// 非静态变量是属于对象的，必须先实例化对象，再使用那个变量

public class Solution {
    private static int number = 0;
    private static int count = 0;

    public int kthSmallest(TreeNode root, int k) {
        count = k;
        helper(root);
        return number;
    }

    public void helper(TreeNode root) {
        if(root==null) return;
        helper(root.left);
        count--;
        if (count == 0) {
            number = root.val;
            return;
        }
        helper(root.right);
    }
}


