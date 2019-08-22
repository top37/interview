package base.effectjava.cap4;

// Noninstantiable utility class
public class UtilityClass {
    // Suppress default constructor for noninstantiability
    private UtilityClass() {
        throw new AssertionError();
    }
    // Remainder omitted ...
}
/**
 * 添加注释是种明智的做法。
 *
 * 因为显式构造方法是私有的，所以在类之外是不可访问的。
 * AssertionError 异常不是严格要求的，但是它提供了一种保证，以防在类中意外地调用构造方法。(eg:通过反射调用)
 * 副作用：阻止了类的子类化。
 * 所有的构造方法都必须显式或隐式地调用父类构造方法，而子类则没有可访问的父类构造方法来调用。
 */
