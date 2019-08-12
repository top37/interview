package jvm.memory.non_heap.cglib;

/**
 * https://blog.csdn.net/jiaotuwoaini/article/details/51675684
 */
public class EnhancerMain {
    public static void main(String[] args) throws Exception {
        Hello hello = new Hello();
        ProxyFactory cglibProxy = new ProxyFactory();
        Hello proxy = (Hello) cglibProxy.createProxy(hello);
        String result=proxy.sayHello(false);
        System.out.println(result);
    }

}
