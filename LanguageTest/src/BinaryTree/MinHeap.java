package BinaryTree;

import com.sun.deploy.util.ArrayUtil;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MinHeap {
    private int[] array;
    private int size;

    public MinHeap(int cap){
        this.array = new int[cap];
    }

    public MinHeap(int[] array, int size) throws Exception {
        if(array == null || array.length == 0){
            throw new Exception();
        }
        this.array = array;
        this.size = size;
        heapify();
    }

    public int size(){
        return size;
    }

    public boolean isEmpty(){
        return size == 0;
    }

    public boolean isFull(){
        return size == array.length;
    }


    private void heapify(){
        for (int i = size/2; i >= 0 ; i--) {
            percolateDown(i);
        }
    }

    private void percolateDown(int i) {
        while(i <= size/2-1){
            int left = 2 * i + 1;
            int right = 2 * i + 2;//未必存在右边子女
            int min;
            if(right > size-1){
                min = left;
            }else {
                min = array[left] < array[right] ? left : right;
            }
            if(array[min] < array[i]){
                swap(array,left,i);
            }else {
                break;
            }
            i = min;
        }
    }

    private void percolateUp(int i){
        while(i>=1){
            int parent = i/2 -1;
            if(array[parent] < array[i]){
                swap(array,parent,i);
            }else {
                break;
            }
            i = parent;
        }
    }


    private void swap(int[] arr, int i, int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public int peek() throws Exception {
        if(size == 0){
            throw new Exception();//empty
        }
        return array[0];
    }
    public int poll() throws Exception {
        if(size == 0){
            throw new Exception();//empty
        }
        int result = array[0];
        array[0] = array[size-1];
        size--;
        percolateDown(0);
        return result;
    }
    public void offer(int i){
        if(isFull()){
            this.array = Arrays.copyOf(array, (int) (size*1.5));
        }
        array[size] = i;
        percolateUp(size);
        size++;
    }

    public int update(int index, int i) throws Exception {
        if(index<0 || index>=size){
            throw new Exception();
        }
        int result = array[index];
        array[index] = i;
        int parent = index/2-1;
        if(i < result){
            percolateUp(index);
        }else {
            percolateDown(i);
        }
        return result;
    }
}
