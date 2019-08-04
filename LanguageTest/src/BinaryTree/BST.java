package BinaryTree;

import java.util.function.Predicate;

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

    public static TreeNode insert(TreeNode root,int value){
        if(root == null){
            return new TreeNode(value);
        }
        if(root.value == value){
            return root;
        }
        if(value < root.value){
            root.left = insert(root.left,value);
        }else {
            root.right = insert(root.right,value);
        }
        return root;
    }

    public static TreeNode insert1(TreeNode root, int value){
        if(root == null){
            return new TreeNode(value);
        }
        TreeNode result = root;
        TreeNode pre =null;
        while (root!=null) {
             pre = root;
            if (value < root.value) {
                root = root.left;
            } else if(value>root.value){
                root =root.right;
            }else {
                return result;
            }
        }
        if(value<pre.value){
            pre.left = new TreeNode(value);
        }else {
            pre.right = new TreeNode(value);
        }

        return result;
    }


}
