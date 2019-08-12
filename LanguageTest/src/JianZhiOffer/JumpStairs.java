package JianZhiOffer;


public class JumpStairs {
    public static int solution(int number){
        if(number <= 0) {
            return 0;
        }
        if(number == 1) {
            return 1;
        }
        if(number == 2) {
            return 2;
        }
        int first = 1, second = 2;
        for (int i = 2; i < number; i++) {
            second+=first;
            first = second - first;
        }
        return second;
    }

    public static void main(String[] args) {
        System.out.println(solution(2));
    }
}
