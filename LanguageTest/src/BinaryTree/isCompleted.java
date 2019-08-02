package BinaryTree;

import java.util.LinkedList;
import java.util.Queue;

public class isCompleted {
    public static boolean solution(TreeNode root){
        if(null == root)return false;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int flag = 0;
        while (!queue.isEmpty()){
            TreeNode cur = queue.poll();

            if(cur.left == null){
                flag = 1;
            }else if(flag == 1){
                return false;
            }else {
                queue.offer(cur.left);
            }

            if(cur.right == null){
                flag = 1;
            }else if(flag == 1){
                return false;
            }else {
                queue.offer(cur.right);
            }
        }
        return true;
    }


}
