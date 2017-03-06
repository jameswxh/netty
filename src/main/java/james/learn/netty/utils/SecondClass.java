package james.learn.netty.utils;


/**
 * Created by james on 2017/2/26.
 */
public class SecondClass {
    public void plus() {
        StaticClass.i++;
    }

    public void put(String s, int i) {
        StaticClass.put(s,i);
    }
}
