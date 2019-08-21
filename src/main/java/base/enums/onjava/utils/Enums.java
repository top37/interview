package base.enums.onjava.utils;

import java.util.*;

/**
 * 古怪的语法<T extends Enum<T>> 表示 T 是一个 enum 实例。
 * 而将 Class<T> 作为参数的话，我们就可以利用 Class 对象得到 enum 实例的数组了。
 * 重载后的 random() 方法只需使用 T[] 作为参数，因为它并不会调用 Enum 上的任何操作，它只需从数组中随机选择一个元素即可。
 * 这样，最终的返回类型正是 enum 的类型。
 */
public class Enums {
    private static Random rand = new Random(47);

    public static <T extends Enum<T>> T random(Class<T> ec) {
        return random(ec.getEnumConstants());
    }

    public static <T> T random(T[] values) {
        return values[rand.nextInt(values.length)];
    }
}
