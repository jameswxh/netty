package james.learn.netty.utils;

/**
 * Created by james on 2017/2/24.
 */
public class Test {
    public static void main(String[] args) {
        System.out.println(StaticClass.i);
        System.out.println(StaticClass.mymap.get("sheep"));
        ThirdClass thirdClass = new ThirdClass();
        thirdClass.out();
        SecondClass secondClass = new SecondClass();
        secondClass.plus();
        secondClass.put("sheep", 1);
        System.out.println(StaticClass.mymap.get("sheep"));
        thirdClass.out();

    }


}
