package jvm.classload.classloader.myloader;

import jvm.classload.classloader.myloader.data.HighClass;

public class Main {

    static {
        System.out.println("MainCache :"+Main.class.getClassLoader());
    }

    public static void main(String[] args) throws Exception{
        MyClassLoader pClassLoader=new MyClassLoader("C:\\Users\\top37\\Desktop\\");
        MyClassLoader cClassLoader=new MyClassLoader(pClassLoader,"C:\\Users\\top37\\Desktop\\");
        //包名+类名
        Class c=pClassLoader.loadClass("jvm.classload.classloader.myloader.data.LowClass");
//        Class p=cClassLoader.loadClass("jvm.classload.classloader.myloader.data.HighClass");
//        Class p1=cClassLoader.loadClass("jvm.classload.classloader.myloader.data.InterfcPara");
//        Object lowClass= c.newInstance();
//        Method method=c.getMethod("say", null);
//        method.invoke(lowClass, null);
        HighClass.getDown(c.newInstance());
//        System.out.println("InterfcPara : "+InterfcPara.class.getClassLoader());

    }
}
