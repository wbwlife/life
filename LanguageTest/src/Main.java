
import com.sun.deploy.util.StringUtils;

import java.lang.reflect.Array;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
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
    String a = "123";
    String b = "123";

    System.out.println(a==b);
    System.out.println(a.equals(b));
    }

}