package com.apl.inner.sys.controller;


import com.apl.inner.sys.mq.RabbitSender;
import com.apl.inner.sys.pojo.PlatformOutOrderStockBo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
;import javax.servlet.AsyncContext;
import javax.servlet.AsyncEvent;
import javax.servlet.AsyncListener;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Date;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.TimeUnit;

/**
 *
 * @author cy
 * @since 2019-12-19
 */
@RestController
@RequestMapping("/test")
public class UnitController {

    @Autowired
    RabbitSender rabbitSender;

    public static Map<String , AsyncContext> asyncContextMap = new ConcurrentHashMap<>();


    @GetMapping("/async")
    public String getList() throws IOException, InterruptedException {

        System.out.println("server b callback -----");

        AsyncContext serverA = asyncContextMap.get("serverA");

        TimeUnit.SECONDS.sleep(5);
        PrintWriter out = serverA.getResponse().getWriter();
        out.println("server b callback -----");  //js页面EventSource接收数据格式：data：数据 + "\r\n"
        out.flush();
        out.close();

        return "success";
    }


    @GetMapping("/sse")
    public void testSse(HttpServletRequest request , HttpServletResponse response) throws IOException, InterruptedException {

            AsyncContext actx = request.startAsync(request,response);
            actx.setTimeout(7 * 1000);
            actx.addListener(new AsyncListener() {
                @Override
                public void onComplete(AsyncEvent asyncEvent) throws IOException {
                    // TODO Auto-generated method stub
                    System.out.println("zxczxc");
                }

                @Override
                public void onError(AsyncEvent arg0) throws IOException {
                    // TODO Auto-generated method stub
                    System.out.println("[echo]event has error");
                }

                @Override
                public void onStartAsync(AsyncEvent arg0) throws IOException {
                    // TODO Auto-generated method stub
                    System.out.println("[echo]event start:" + arg0.getSuppliedRequest().getRemoteAddr());
                }

                @Override
                public void onTimeout(AsyncEvent arg0) throws IOException {
                    // TODO Auto-generated method stub
                    System.out.println(arg0);
                }
            });

            asyncContextMap.put("serverA" , actx);

        rabbitSender.send("serverBExchange" , "serverBQueue" , "hello");
        System.out.println("end ..........");
        if(true){
            return ;
        }
        System.out.println("over ..........");

    }

    @GetMapping("/async/count")
    public Integer asyncCount(){

        System.out.println("async count is : " + asyncContextMap.keySet().size());
        return asyncContextMap.keySet().size();
    }

}
