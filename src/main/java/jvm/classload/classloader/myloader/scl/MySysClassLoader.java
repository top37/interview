package jvm.classload.classloader.myloader.scl;

import java.io.*;

public class MySysClassLoader extends ClassLoader{

    private String classpath = "C:\\Users\\top37\\Desktop\\";


    public MySysClassLoader(String classpath) {
        super();
        this.classpath = classpath;
    }

    public MySysClassLoader(ClassLoader parent, String classpath) {
        super(parent);
        this.classpath = classpath;
    }

    public MySysClassLoader(ClassLoader parent) {
        super(parent);
    }

    public Class<?> getCacheClassFromJVM(String name){
        return this.findLoadedClass(name);
    }

    @Override
    protected Class<?> findClass(String name) throws ClassNotFoundException {
        System.out.println("---> I am loading : " + name);
        System.out.println("---> I am cache : "+findLoadedClass(name));
        System.out.println("---> I am cache obj: "+findLoadedClass("java.lang.Object"));
        try {
            byte [] classDate=getDate(name);

            if(classDate==null){}

            else{
                //defineClass方法将字节码转化为类
                return defineClass(name,classDate,0,classDate.length);
            }

        } catch (IOException e) {

            e.printStackTrace();
        }

        return super.findClass(name);
    }
    //返回类的字节码
    private byte[] getDate(String className) throws IOException{
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
}
