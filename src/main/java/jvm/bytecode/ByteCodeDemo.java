package jvm.bytecode;

public class ByteCodeDemo {
    String str;
    boolean bl;
    int i;

    public ByteCodeDemo(String str) {
        this.str = str;
    }

    public ByteCodeDemo(boolean bl) {
        this.bl = bl;
    }

    public ByteCodeDemo(String str, boolean bl) {
        this.str = str;
        this.bl = bl;
    }

    public int addt(int a, int b){
        this.i = a;
        int c = i +b;
        return c;
    }

    public boolean isBl() {
        return bl & false;
    }
}
