package spring.mvc.handler.adapter;

import spring.mvc.handler.adapter.adapters.HttpRequestHandlerAdapter;
import spring.mvc.handler.adapter.adapters.SimpleControllerHandlerAdapter;
import spring.mvc.handler.adapter.adapters.SimpleServletHandlerAdapter;
import spring.mvc.handler.adapter.message.Request;
import spring.mvc.handler.adapter.message.Response;

import java.util.ArrayList;
import java.util.List;

public class DispatchServlet {
    private static List<HandlerAdapter> handlerAdapters;

    static
    {
        handlerAdapters = new ArrayList<>();
        initStrategies();
    }

    private static void initStrategies() {
        initHandlerAdapters();
    }

    private static void initHandlerAdapters(){
        handlerAdapters.add(new HttpRequestHandlerAdapter());
        handlerAdapters.add(new SimpleControllerHandlerAdapter());
        handlerAdapters.add(new SimpleServletHandlerAdapter());
    }

    public void doDispatch(Object handler) throws Exception {
        HandlerAdapter adapter = getHandlerAdapter(handler);
        adapter.handle(new Request(),new Response(),handler);
    }

    private HandlerAdapter getHandlerAdapter(Object handler){
        for(HandlerAdapter adapter: handlerAdapters){
            if(adapter.supports(handler)){
                return adapter;
            }
        }
        return null;
    }


}
