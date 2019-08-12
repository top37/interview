package jvm.memory.non_heap;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;


/**
 * -XX:MetaspaceSize=8m -XX:MaxMetaspaceSize=8m
 * Exception in thread "main" java.lang.OutOfMemoryError: Metaspace
 */
public class JavaMethodAreaOOM {
    public static void main(String[] args) throws Exception{
        while (true) {
            Enhancer enhancer = new Enhancer();
            enhancer.setSuperclass(OOMObj.class);
            enhancer.setUseCache(false);
            enhancer.setCallback((MethodInterceptor) (o, m, a, p) -> p.invokeSuper(o, a));

            enhancer.create();
        }
    }

    static class OOMObj{}
}
