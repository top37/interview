package jvm.classload.classloader;

import jvm.classload.classloader.demo.FatherClass;

import java.sql.Connection;
import java.sql.SQLException;

/**
 * -verbose:class
 * 不推荐：破坏双亲委派，JVM缓存中会出现两个相同的全路径名的实例
 */
public class ClassloaderMain {
    static {
        System.out.println( "ClassloaderMain 的loader ：" + ClassloaderMain.class.getClassLoader());
    }

    public static void main(String[] args) throws SQLException {
        FatherClass fc = new FatherClass();

        Connection ct = java.sql.DriverManager.getConnection("jdbc:mysql://10.152.4.33:3306/accounttest","accounttest","123456");
        System.out.println("ct 的loader ： "+ct.getClass().getClassLoader());
        System.out.println("Connection 的loader ： "+Connection.class.getClassLoader());
        ct.close();
    }
}
