package spring.mvc.handler.adapter.adapters;

import spring.mvc.handler.adapter.HandlerAdapter;
import spring.mvc.handler.adapter.interfaceI.Servlet;
import spring.mvc.handler.adapter.message.ModelAndView;
import spring.mvc.handler.adapter.message.Request;
import spring.mvc.handler.adapter.message.Response;

public class SimpleServletHandlerAdapter implements HandlerAdapter {
    public boolean supports(Object handler) {
        return handler instanceof Servlet;
    }

    public ModelAndView handle(Request req, Response resp, Object handler) throws Exception {
        ((Servlet)handler).service(req, resp);
        return null;
    }
}
