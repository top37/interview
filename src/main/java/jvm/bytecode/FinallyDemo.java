package jvm.bytecode;

public class FinallyDemo {

    public static volatile int i;
    static {
        i++;
    }

    public volatile int j;
    {
        j++;
    }

    public static String test(){
        try
        {
            int i=1/0;
            System.out.println("error open");//上面产生异常，所以永远不会走这里
            return "1";
        }
        catch (ArithmeticException e)
        {
            //虽然抛出异常，但程序不会中断
            System.out.println("error");
        }
        System.out.println("try..catch...finish");
        return "finish";
    }

    /**
     * 宏观上看，同一 代码块 值没有变化；
     * 实际指令 -
     * ∵不同 代码块 中的同一变量 均被 局部变量表 在不同solt中存储 保留了下来
     * 保证了 i值 在 不同代码块中 的 差异性
     *
     * ∴具体的返回值，取决于 执行return的 代码块
     */
    public static int test1() {//11
        int i = 1;
        try
        {
            System.out.println("try...");
            return i += 10;
        }
        catch (Exception e)
        {
            System.out.println("catch...");

        }
        finally
        {
            i++;
            System.out.println("finally...i=" + i);
        }
        return i;
    }

    public static int test1_1() {//11 - 字节码与test1() 完全一致；
        int i = 1;
        try {
            System.out.println("try...");
            i += 10;
            return i;
        } catch (Exception e) {
            System.out.println("catch...");
        } finally {
            i++;
            System.out.println("finally...i=" + i);

        }
        return i;
    }




    public static int test2() {//12
        int i = 1;
        try
        {
            System.out.println("try...");
            return i += 10;
        }
        catch (Exception e) {
            System.out.println("catch...");
        }
        finally
        {
            i++;
            System.out.println("finally...i=" + i);
            return i;
        }

    }







    public FinallyDemo getFinallyDemo(){
        return this;
    }

    public int getInt(int i){
        return i;
    }



    public static void main(String[] args) {
//        表达式的返回值
        int i = 1;
        System.out.println(i++);//1
        System.out.println(i);//2
        i = 1;
        System.out.println(++i);//2
        System.out.println(i);//2
    }

}
