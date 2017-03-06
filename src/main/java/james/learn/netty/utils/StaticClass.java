package james.learn.netty.utils;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by james on 2017/2/26.
 */
public class StaticClass {
    public static int i = 0;
    public static Map<String, Integer> mymap = new HashMap<>();

    public static void put(String s, int i) {
        mymap.put(s, i);
    }
}
