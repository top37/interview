package spring.mvc.handler.adapter.adapters;

import spring.mvc.handler.adapter.HandlerAdapter;
import spring.mvc.handler.adapter.interfaceI.Controller;
import spring.mvc.handler.adapter.message.ModelAndView;
import spring.mvc.handler.adapter.message.Request;
import spring.mvc.handler.adapter.message.Response;

public class SimpleControllerHandlerAdapter implements HandlerAdapter {
    public boolean supports(Object handler) {
        return handler instanceof Controller;
    }

    public ModelAndView handle(Request req, Response resp, Object handler) throws Exception {
        return ((Controller)handler).handleRequest(req, resp);
    }
}
