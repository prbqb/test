package com.apl.inner.sys.async;

import javax.servlet.AsyncContext;
import javax.servlet.AsyncEvent;
import javax.servlet.AsyncListener;
import javax.servlet.ServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class AsyncRequest {



    /**
     * @Desc: 根据标识，查找异步请求域，将数据写回客户端
     * @Author: CY
     * @Date: 2020/6/5 16:36
     */
    public static void writeData(String tagId , Object data) throws Exception {

        AsyncContext asyncRequestContext = AsyncRequestContextHolder.getAsyncRequestContext(tagId);
        writeData(asyncRequestContext , data);
    }


    /**
     * @Desc: 构建一个异步请求域，将数据写客户端
     * @Author: CY
     * @Date: 2020/6/5 16:37
     */
    public static void writeData(Object data) throws Exception {

        AsyncContext asyncContext = CommonContextHolder.getAsyncContext();
        writeData(asyncContext , data);

    }

    /**
     * @Desc: 将数据写回该异步请求域
     * @Author: CY
     * @Date: 2020/6/5 16:38
     */
    public static void writeData(AsyncContext asyncContext , Object data) throws Exception {

        asyncContext.addListener(new AsyncListener() {
            @Override
            public void onComplete(AsyncEvent asyncEvent) throws IOException {
                // TODO Auto-generated method stub
                System.out.println("writeData onComplete");
            }

            @Override
            public void onError(AsyncEvent arg0) throws IOException {
                // TODO Auto-generated method stub
                System.out.println("writeData has error");
            }

            @Override
            public void onStartAsync(AsyncEvent arg0) throws IOException {
                // TODO Auto-generated method stub
                System.out.println("writeData start:" + arg0.getSuppliedRequest().getRemoteAddr());
            }

            @Override
            public void onTimeout(AsyncEvent arg0) throws IOException {
                // TODO Auto-generated method stub
                System.out.println("writeData time out " + arg0);
            }
        });

        ServletResponse response = asyncContext.getResponse();

        response.setContentType("text/event-stream");
        response.setCharacterEncoding("utf-8");
        PrintWriter printWriter = asyncContext.getResponse().getWriter();

        if(printWriter.checkError()){
            System.out.println("客户端端口断开连接");
            throw new Exception("客户端断开异常");
        }

        printWriter.write(data.toString());
        printWriter.flush();

        printWriter.close();
    }


}
