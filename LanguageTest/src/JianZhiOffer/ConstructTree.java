package JianZhiOffer;


public class ConstructTree {
    public TreeNode reConstructBinaryTree(int [] pre, int [] in) {
        //前序遍历{1,2,4,7,3,5,6,8}和中序遍历序列{4,7,2,1,5,3,8,6}
        if(null == pre || pre.length == 0 || null == in || in.length == 0){
            return null;
        }
        return helper(pre,0,pre.length-1,in,0,in.length-1);
    }
    private TreeNode helper(int[] pre,int startPre,int endPre,int[] in,int startIn,int endIn){
        if(startPre>endPre || startIn>endIn){
            return null;
        }
        TreeNode root = new TreeNode(pre[startPre]);
        for (int i = startIn; i <= endIn; i++) {
            if(in[i] == pre[startPre]){
                int index = i-startIn;
                root.left = helper(pre,startPre+1,startPre+index,in,startIn,i-1);
                root.right = helper(pre,startPre+index+1,endPre,in,i+1,endIn);
                break;
            }
        }
        return root;
    }

    public static class TreeNode{
        int value;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { value = x; }
    }
}
