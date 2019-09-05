package base.nestedclass;

public class NonStatic {

    public class Inner {
        private int num = 2;
    }

    public static void main(String[] args) {
        NonStatic NonStatic = new NonStatic();
        Inner inner = NonStatic.new Inner();
        System.out.println(inner.num);
    }
}
