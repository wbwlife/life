package JianZhiOffer;



public class RotateArray {

        public int minNumberInRotateArray(int [] array) {

            if(array==null||array.length==0){  return 0;
            }
            int low=0;
            int up=array.length-1;
            int mid=low;

            // 当low和up两个指针相邻时候，就找到了最小值，也就是
            //右边序列的第一个值

            while(array[low]>=array[up]){
                if(up-low==1){
                    mid=up;
                    break;
                }
                //如果low、up、mid下标所指的值恰巧相等
                //如：{0,1,1,1,1}的旋转数组{1,1,1,0,1}
                if(array[low]==array[up]&&array[mid]==array[low])
                    return MinInOrder(array);
                mid=(low+up)/2;
                //这种情况，array[mid]仍然在左边序列中
                if(array[mid]>=array[low])
                    low=mid;//注意，不能写成low=mid+1；
                    //要是这种情况，array[mid]仍然在右边序列中
                else if(array[mid]<=array[up])
                    up=mid;
            }

            return array[mid];

        }
        private int MinInOrder(int[] array) {
            // TODO Auto-generated method stub
            int min =array[0];
            for(int i=1;i<array.length;i++){
                if(array[i]<min){
                    min=array[i];

                }
            }
            return min;
        }
}

