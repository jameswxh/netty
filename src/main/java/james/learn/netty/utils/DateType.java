package james.learn.netty.utils;

/**
 * Created by wxhx1 on 2017/2/8.
 */
public class DateType {

    public static void main(String[] args){

        long now = System.currentTimeMillis()/1000;
        int time = (int) now;
        System.out.print(now + " | " + time + "\n");
        System.out.println(time/60/60/24/365+1970);
        System.out.println(1 / 2);
        System.out.println(21 % 2);
    }
}
