package base.effectjava.cap10;

import java.util.Arrays;
import java.util.Objects;

public class EqualsDemo {

    private String str;
    private Integer itr;
    private Object obj;
    private int ii;
    private float ft;
    private char[] ca;

    public String getStr() {
        return str;
    }

    public void setStr(String str) {
        this.str = str;
    }

    public Integer getItr() {
        return itr;
    }

    public void setItr(Integer itr) {
        this.itr = itr;
    }

    public Object getObj() {
        return obj;
    }

    public void setObj(Object obj) {
        this.obj = obj;
    }

    public int getIi() {
        return ii;
    }

    public void setIi(int ii) {
        this.ii = ii;
    }

    public float getFt() {
        return ft;
    }

    public void setFt(float ft) {
        this.ft = ft;
    }

    public char[] getCa() {
        return ca;
    }

    public void setCa(char[] ca) {
        this.ca = ca;
    }

    /**
     * 对于引用类型数据，调用相应对象的 equals 方法；
     * Java基本数据类型，直接使用==进行验证；
     * 引用类型，则使用：
     * public static boolean equals(Object a, Object b) {
     *         return (a == b)                          //指向同一地址 毫无疑问的相等；
     *                  ||                              //或者
     *                (a != null && a.equals(b));       //a（this的ref属性）非空，且（this的ref属性 与 that的ref属性 逻辑相等）
     * }
     *
     * 静态方法进行验证
     * @param o 参数
     * @return 逻辑相等则为真，否则为假
     *
     * 对于类型为非 float 或 double 的基本类型，使用 == 运算符进行比较；
     *
     * 对于对象引用属性，递归地调用 equals 方法；
     *
     * 对于 float 基本类型的属性，使用静态 Float.compare(float, float) 方法；
     * 对于 double 基本类型的属性，使用 Double.compare(double, double) 方法。
     *
     * 由于存在 Float.NaN，-0.0f 和类似的 double 类型的值，所以需要对 float 和 double 属性进行特殊的处理；
     * 有关详细信息，请参阅 JLS 15.21.1 或 Float.equals 方法的详细文档。
     * 虽然你可以使用静态方法 Float.equals 和 Double.equals 方法对 float 和 double 基本类型的属性进行比较，
     * 这会导致每次比较时发生自动装箱，引发非常差的性能。
     *
     * 对于数组属性，将这些准则应用于每个元素。
     * 如果数组属性中的每个元素都很重要，请使用其中一个重载的 Arrays.equals 方法。
     */

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        EqualsDemo that = (EqualsDemo) o;
        return ii == that.ii &&
                Float.compare(that.ft, ft) == 0 &&
                Objects.equals(str, that.str) &&
                Objects.equals(itr, that.itr) &&
                Objects.equals(obj, that.obj) &&
                Arrays.equals(ca, that.ca);
    }


    @Override
    public int hashCode() {

        int result = Objects.hash(str, itr, obj, ii, ft);
        result = 31 * result + Arrays.hashCode(ca);
        return result;
    }





    public static void main(String[] args) {
        EqualsDemo ed = new EqualsDemo();
        ed.setIi(1);ed.setStr("2");

        EqualsDemo ed1 = new EqualsDemo();
        ed1.setIi(1);ed1.setStr("2");

        System.out.println(ed.equals(ed1));
    }
}
