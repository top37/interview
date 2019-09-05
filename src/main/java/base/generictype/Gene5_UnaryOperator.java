package base.generictype;

import java.util.function.UnaryOperator;

import static base.generictype.Gene5_UnaryOperator.identityFunction;

/**
 * 30.优先使用泛型方法.md
 * 泛型单例这么牛？
 * 泛型单例，行为一致性；
 *
 * 编译的时候可确定
 *
 * lambda表达式，表现的是行为
 */
public class Gene5_UnaryOperator {
    private static UnaryOperator<Object> IDENTITY_FN = (t) -> t;

    @SuppressWarnings("unchecked")
    public static <T> UnaryOperator<T> identityFunction() {
        return (UnaryOperator<T>) IDENTITY_FN;
    }

}

class Test1{
    // Sample program to exercise generic singleton
    public static void main(String[] args) {
        String[] strings = { "jute", "hemp", "nylon" };
        UnaryOperator<String> sameString = identityFunction();

        for (String s : strings)
            System.out.println(sameString.apply(s));

        Number[] numbers = { 1, 2.0, 3L };

        UnaryOperator<Number> sameNumber = identityFunction();

        for (Number n : numbers)
            System.out.println(sameNumber.apply(n));
    }
}


