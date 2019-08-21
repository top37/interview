package jvm.bytecode;

import java.util.Objects;

public class StringDemo {
    public String str = "abc";//字符串字面量的引用 StringTable
    public String str2 = new String("def");//String对象 的 引用

    public StringDemo(){
        System.out.println(str == str2);
        System.out.println(str.equals(str2));
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        StringDemo that = (StringDemo) o;
        return Objects.equals(str, that.str) &&
                Objects.equals(str2, that.str2);
    }
    @Override
    public int hashCode() {

        return Objects.hash(str, str2);
    }
}
