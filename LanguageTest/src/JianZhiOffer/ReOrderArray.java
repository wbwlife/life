package JianZhiOffer;

public class ReOrderArray {
    //输入一个整数数组，实现一个函数来调整该数组中数字的顺序，使得所有的奇数位于数组的前半部分，
    // 所有的偶数位于数组的后半部分，并保证奇数和奇数，偶数和偶数之间的相对位置不变。
    public void reOrderArray(int [] array) {
        if(null == array || array.length == 0){
            return;
        }
        int i = 0;
        while (i < array.length-1){
            if((array[i] & 1) ==1){//i找到第一个偶数
                i++;
                continue;
            }
            for (int j = i+1; j < array.length; j++) {
                if((array[j] & 1) == 1){//j是i之后的第一个奇数
                    int temp = array[j];
                    for (int k = j; k > i ; k--) {
                        array[k] = array[k-1];
                    }
                    array[i] = temp;
                    break;
                }
            }
        }

    }
}
