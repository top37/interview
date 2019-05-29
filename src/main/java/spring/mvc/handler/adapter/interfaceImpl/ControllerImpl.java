package spring.mvc.handler.adapter.interfaceImpl;

import spring.mvc.handler.adapter.interfaceI.Controller;
import spring.mvc.handler.adapter.message.ModelAndView;
import spring.mvc.handler.adapter.message.Request;
import spring.mvc.handler.adapter.message.Response;

public class ControllerImpl implements Controller {
    @Override
    public ModelAndView handleRequest(Request var1, Response var2) throws Exception {
        System.out.println("---Controller---");
        return null;
    }
}
