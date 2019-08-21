package jvm.bytecode;

public class MethodDemo {

    public void getVoid(String str,int i){
        System.out.println(str + i);
    }

    public void showGetVoid(){
        getVoid("aqiang",111);
        int i = 10;//果然，因为invokevirtual的调用，操作数栈 方法所用参数部分 被 清空了
    }

}
