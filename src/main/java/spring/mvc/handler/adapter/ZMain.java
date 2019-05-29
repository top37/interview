package spring.mvc.handler.adapter;

import spring.mvc.handler.adapter.interfaceI.Controller;
import spring.mvc.handler.adapter.interfaceI.Servlet;
import spring.mvc.handler.adapter.interfaceImpl.ControllerImpl;
import spring.mvc.handler.adapter.message.Request;
import spring.mvc.handler.adapter.message.Response;

public class ZMain {

    public static void main(String[] args) throws Exception {
        Controller cl = new ControllerImpl();
        new DispatchServlet().doDispatch(cl);

        new DispatchServlet().doDispatch(new Servlet() {
            @Override
            public void service(Request var1, Response var2) throws Exception {
                System.out.println("---Servlet---");
            }
        });

    }
}
