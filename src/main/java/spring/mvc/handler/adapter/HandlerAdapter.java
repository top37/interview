package spring.mvc.handler.adapter;

import spring.mvc.handler.adapter.message.ModelAndView;
import spring.mvc.handler.adapter.message.Request;
import spring.mvc.handler.adapter.message.Response;

public interface HandlerAdapter {

    boolean supports(Object var1);

    ModelAndView handle(Request var1, Response var2, Object var3) throws Exception;
}
