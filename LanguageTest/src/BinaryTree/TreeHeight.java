package BinaryTree;


public class TreeHeight {
    public static int getHeight(TreeNode root){
        if(root == null){
            return 0;
        }
        int leftHeight = getHeight(root.left);
        int rightHeight = getHeight(root.right);
        return Math.max(leftHeight,rightHeight)+1;
    }//Time = O(n),Space = O(n)


}
