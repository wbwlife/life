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
    public static void printBSTKeys(TreeNode root,int min,int max){
        if(root == null) return;
        if(!(root.value<=min)){
            printBSTKeys(root.left,min,max);
        }
        if(root.value>=min && root.value<=max){
            System.out.println(root.value);
        }
        System.out.println(root.value);
        if(!(root.value>=max)){
            printBSTKeys(root.right,min,max);
        }
    }
}
