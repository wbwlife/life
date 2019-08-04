import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ArrayToList {
    public static void main(String[] args) {
        int[] array = {1,2,3,4};
        List<Integer> mlist = new ArrayList<>();
        for(int element:array){
            mlist.add(element);
        }
        mlist.forEach(System.out::println);
    }
}
