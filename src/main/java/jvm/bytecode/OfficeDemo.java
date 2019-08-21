package jvm.bytecode;

public class OfficeDemo {
    void spin() {
        int i;
        for (i = 0; i < 100; i++) {
            ; // Loop body is empty
        }
    }

    //标注检查 - 常量折叠
    int i = 1 + 2;//javac 后 int = 3；

    public void foo(final int arg0){
        final int var = 0;
    }

    public void foo1(int arg0){
        int var = 0;
    }

    public static String testt() throws Exception{
        try {
//            int i = 9/0;
            System.exit(0);
            return "try";

        }
//        catch (Exception e) {
//            return "catch";
//        }
        finally{
            return "finally";
        }
    }

    public static int test1(){

        int ret = 0;

        try{
            return ret;

        }finally{

            ret = 2;

        }

    }

    public static void main(String[] args) throws Exception {
        System.out.println(test1());
    }

}
