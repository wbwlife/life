
import com.sun.deploy.util.StringUtils;

import java.lang.reflect.Array;
import java.math.BigInteger;
import java.sql.SQLOutput;
import java.util.*;
import java.util.stream.Collectors;


public class  Main {

    public static Long urlToId(String url) {
        Long reInt = null;
        if (url != null && !url.isEmpty() && url.length() > 1) {

            url = url.substring(1, url.length());
            reInt = Long.parseLong((new BigInteger(url, 36)).toString(10));
            reInt = (reInt - 56L) / 2L;
            reInt = reInt > 0L ? reInt : 0L;
        }

        return reInt;
    }

    public static void main(String[] args) {
        PriorityQueue<Integer> queue = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                if (o1.equals(o2)) {
                    return 0;
                }
                return o1 > o2 ? -1 : 1;
            }

        });
        queue.offer(1);
        queue.offer(2);
        queue.offer(1);
        queue.forEach(System.out::println);
    }
}