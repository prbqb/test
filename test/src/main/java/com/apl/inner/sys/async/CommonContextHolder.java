package com.apl.inner.sys.async;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.AsyncContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


/**
 * @author CY
 * @version 1.0.0
 * @ClassName AplContextHolder.java
 * @createTime 2019年07月29日 14:29:00
 */
@Component
@Slf4j
@Data
public class CommonContextHolder {

    public static final ThreadLocal<String> tokenContextHolder = new ThreadLocal();

    //微服务CODE
    public static String getServiceCode(String requestURL) {
        String code = null;
        int p = requestURL.indexOf("/", 1);
        if (p > 1) {
            //requestURI 第一段为微服务代码
            code = requestURL.substring(1, p);
        }
        /*p = code.indexOf("-", 1);
        if (p > 1) {
            //inner-
            code = code.substring(0, p-1);
        }*/

        return code;
    }


    /**
     * @Author: CY
     * @Description: 获取请求上下文 request
     * @Date: 2019/7/31
     * @Param:
     * @return:
     **/
    public static HttpServletRequest getRequest() {

        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        return attributes.getRequest();

    }


    /**
     * @Author: CY
     * @Description: 获取请求上下文 response
     * @Date: 2019/7/31
     * @Param:
     * @return:
     **/
    public static HttpServletResponse httpServletResponse() {

        ServletRequestAttributes requestAttributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        return requestAttributes.getResponse();
    }

    /**
     * @Author hh
     * @Description 获取URI
     * @Date 2019/10/21
     */
    public static String getURI() {
        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();

        String uri = attributes.getRequest().getRequestURI();

        return uri;
    }

    /**
     * @Author hh
     * @Description 静态方法，获取token
     * @Date 2019/10/21
     */
    public static String getHeader(String key) {
        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();

        String token = attributes.getRequest().getHeader(key);

        return token;
    }



    public static AsyncContext getAsyncContext(){

        HttpServletRequest request = getRequest();

        HttpServletResponse response = httpServletResponse();

        return request.startAsync(request, response);

    }


}
