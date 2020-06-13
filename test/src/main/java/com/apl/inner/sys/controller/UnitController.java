package com.apl.inner.sys.controller;


import com.apl.inner.sys.async.AsyncRequest;
import com.apl.inner.sys.async.AsyncRequestContextHolder;
import com.apl.inner.sys.mq.RabbitSender;
import com.apl.inner.sys.pojo.PlatformOutOrderStockBo;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
;import javax.servlet.AsyncContext;
import javax.servlet.AsyncEvent;
import javax.servlet.AsyncListener;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;

/**
 * @author cy
 * @since 2019-12-19
 */
@RestController
@RequestMapping("/test")
public class UnitController {

    @Autowired
    RabbitSender rabbitSender;

    @GetMapping("/async")
    public void getList() throws Exception {

        String data = "异步调用成功\r\n";
        AsyncContext asyncContext = AsyncRequestContextHolder.getAsyncRequestContext("serverA");

        if(asyncContext == null){
            return ;
        }
        while(true){
            try {
                TimeUnit.SECONDS.sleep(2);
                System.out.println(data);
                AsyncRequest.writeData(asyncContext , data);
            }catch (Exception e){
                break;
            }

        }

        /**
         *         System.out.println("server b callback -----");
         *
         *         AsyncContext serverA = AsyncRequestContextHolder.getAsyncRequestContext("serverA");
         *
         *         PrintWriter out = serverA.getResponse().getWriter();
         *         out.println("server b callback -----");  //js页面EventSource接收数据格式：data：数据 + "\r\n"
         *         out.flush();
         *         out.close();
         *
         *         return "success";
         */

    }


    @GetMapping("/sse")
    public void testSse(HttpServletRequest request, HttpServletResponse response) throws IOException, InterruptedException {

        AsyncRequestContextHolder.addRequestContext("serverA");

        rabbitSender.send("serverBExchange", "serverBQueue", "hello");
        System.out.println("end ..........");
        if (true) {
            return;
        }
        System.out.println("over ..........");

    }

    @GetMapping("/async/count")
    public Integer asyncCount() {
        return 1;
    }



    @GetMapping("/async/remove")
    public void remove() {

        AsyncRequestContextHolder.removeRequestContext("serverA");

    }

    @PostMapping("/send")
    public void sendIds(@RequestBody List<PlatformOutOrderStockBo> platformOutOrderStockBos){

        System.out.println("ids is : " + platformOutOrderStockBos );
    }

    public static void main(String[] args) {

        ConcurrentHashMap map = new ConcurrentHashMap();
        Object o = map.putIfAbsent("aaa", "bbb");
        System.out.println("result " + map.get("aaa"));
        System.out.println("111"+o);
        Object o1 = map.putIfAbsent("aaa", "ddd");
        System.out.println("222"+o1);

        System.out.println("result " + map.get("aaa"));
    }

}