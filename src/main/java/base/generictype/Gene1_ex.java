package base.generictype;

import java.util.ArrayList;
import java.util.List;

public class Gene1_ex {

    // Fails at runtime - unsafeAdd method uses a raw type (List)!
    public static void main(String[] args) {
        List<String> strings = new ArrayList<>();
        unsafeAdd(strings, Integer.valueOf(42));
        String s = strings.get(0); // Has compiler-generated cast
    }

    //这就是伪泛型的弊端
    private static void unsafeAdd(List list, Object o) {
        list.add(o);//正常执行，get的时候才会抛异常
    }

    //问：那如果现在我有一个需求，需要在List中加入String，Integer，Date等类型，并根据需要进行取出，该怎么做；
    //答：使用<?> 通配符；×  -> ?表示某个类型的集合；
    //使用List<Object>,


}
