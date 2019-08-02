package BinaryTree;


public class isBST {
    public static boolean solution(TreeNode root){
        if(root == null){
            return false;
        }
        int left = Integer.MIN_VALUE;
        int right = Integer.MAX_VALUE;
        return helper(root,left,right);

    }
    private static boolean helper(TreeNode root,int left,int right){
        if(root == null){
            return true;
        }
        if(root.value < left ||root.value>right){
            return false;
        }
        return helper(root.left,left,root.value) && helper(root.right,root.value,right);
    }

}
