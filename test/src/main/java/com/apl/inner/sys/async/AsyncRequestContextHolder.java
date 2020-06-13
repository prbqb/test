package com.apl.inner.sys.async;

import javax.servlet.AsyncContext;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class AsyncRequestContextHolder {

    //  超时默认30秒

    private static Map<String , AsyncContext> asyncContextMap = new ConcurrentHashMap<>();


    /**
     * @Desc: 添加异步请求
     * @Author: CY
     * @Date: 2020/6/5 17:03
     */
    public static void addRequestContext(String tagId){

        addRequestContext(tagId , null);
    }

    public static void addRequestContext(String tagId , Long timeOut){

        addRequestContext(tagId , CommonContextHolder.getAsyncContext() , timeOut);
    }

    public static void addRequestContext(String tagId , AsyncContext asyncContext , Long timeOut){

        if (timeOut != null) {
            asyncContext.setTimeout(timeOut);
        }
        asyncContextMap.put(tagId , asyncContext);
    }


    /**
     * @Desc: 移除异步请求
     * @Author: CY
     * @Date: 2020/6/5 17:04
     */
    public static void removeRequestContext(String tagId ){

        asyncContextMap.remove(tagId);
    }

    public static AsyncContext getAsyncRequestContext(String tagId){

        return asyncContextMap.get(tagId);
    }


    /**
     * @Desc: 判断是否存在
     * @Author: CY
     * @Date: 2020/6/5 17:04
     */
    public static  Boolean exist(String tagId){

        return asyncContextMap.get(tagId) != null ? true : false;
    }


    public static Map<String, AsyncContext> getAsyncContextMap() {
        return asyncContextMap;
    }
}
