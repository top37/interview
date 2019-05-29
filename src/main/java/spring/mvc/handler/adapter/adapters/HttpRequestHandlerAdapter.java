package spring.mvc.handler.adapter.adapters;

import spring.mvc.handler.adapter.HandlerAdapter;
import spring.mvc.handler.adapter.interfaceI.HttpRequestHandler;
import spring.mvc.handler.adapter.message.ModelAndView;
import spring.mvc.handler.adapter.message.Request;
import spring.mvc.handler.adapter.message.Response;

public class HttpRequestHandlerAdapter implements HandlerAdapter {
    public boolean supports(Object handler) {
        return handler instanceof HttpRequestHandler;
    }

    public ModelAndView handle(Request req, Response resp, Object handler) throws Exception {
        ((HttpRequestHandler)handler).handleRequest(req, resp);
        return null;
    }
}
