package jvm.classload.classloader.myloader.cache;

import sun.misc.IOUtils;

import java.io.*;

public class SimpleClassLoader2 extends ClassLoader{

    private String classpath = "F:\\My\\interview\\target\\classes\\";

    SimpleClassLoader2() {
        super(null); // disables delegation -> only delegate bootstrap
    }

    protected Class<?> findClass(String name) {
        try {
            byte[] b = getDate("jvm.classload.classloader.myloader.cache.Bar");
            return defineClass("jvm.classload.classloader.myloader.cache.Bar", b, 0, b.length);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
    void foo() throws ClassNotFoundException {
        System.err.println(loadClass("jvm.classload.classloader.myloader.cache.Bar"));
        System.err.println(findLoadedClass("jvm.classload.classloader.myloader.cache.Bar"));
    }

    //返回类的字节码
    private byte[] getDate(String className) throws IOException {
        InputStream in = null;
        ByteArrayOutputStream out = null;
        String path=classpath + File.separatorChar +
                className.replace('.',File.separatorChar)+".class";
        try {
            in=new FileInputStream(path);
            out=new ByteArrayOutputStream();
            byte[] buffer=new byte[2048];
            int len=0;
            while((len=in.read(buffer))!=-1){
                out.write(buffer,0,len);
            }
            return out.toByteArray();
        }
        catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        finally{
            in.close();
            out.close();
        }
        return null;
    }

    public static void main(String[] args) throws ClassNotFoundException {
        new SimpleClassLoader2().foo();
    }
}
