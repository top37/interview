package jvm.memory.non_heap.cglib;


public class Hello {
    public String sayHello(boolean throwException) throws Exception {
        System.out.println("hello everyone!");
        if (throwException)
            throw new Exception("test exception");
        return "123";
    }
}