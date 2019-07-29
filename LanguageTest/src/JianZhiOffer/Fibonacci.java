package JianZhiOffer;

public class Fibonacci {
    public int solution1(int n){//递归，或导致栈溢出
        if(n==1||n==0){
            return n;
        }
        return solution1(n-1)+solution1(n-2);
    }

    public int solution2(int n){//循环
        if(n==1||n==0){
            return n;
        }
        int[] array = new int[n];
        array[0] = 0;
        array[1] = 1;
        for (int i = 2; i < n; i++) {
             array[i] = array[i-1]+array[i-2];
        }

        return array[n-1];
    }

    public int solution3(int n){//循环
        if(n==1||n==0){
            return n;
        }
        int i = 0;
        int j = 1;
        while (n >2) {
            j += i;
            i = j-i;
            n--;
        }
        return j;

    }

    public static void main(String[] args) {
        Fibonacci a = new Fibonacci();
        System.out.println(a.solution3(4));
        System.out.println(2&3);
    }

}
