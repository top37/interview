package spring.mvc.handler.adapter.interfaceI;

import spring.mvc.handler.adapter.message.ModelAndView;
import spring.mvc.handler.adapter.message.Request;
import spring.mvc.handler.adapter.message.Response;

public interface Controller {
    ModelAndView handleRequest(Request var1, Response var2) throws Exception;
}
