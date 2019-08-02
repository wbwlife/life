package BinaryTree;

public class BST {
    public static TreeNode search(TreeNode root,int target){
        if(root == null || root.value == target){
            return root;
        }
        if(target < root.value){
            return search(root.left,target);
        }else {
            return search(root.right,target);
        }

    }

    public  static TreeNode search1(TreeNode root,int target){
        if(root == null ){
            return null;
        }
        while ( root !=null && root.value!=target ){//注意root NPE
            if(target < root.value){
                root = root.left;
            }else {
                root = root.right;
            }
        }
        return root;
    }
}
