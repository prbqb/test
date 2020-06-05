package com.apl.inner.sys.controller;


import com.apl.inner.sys.pojo.PlatformOutOrderStockBo;
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

/**
 *
 * @author cy
 * @since 2019-12-19
 */
@RestController
@RequestMapping("/test")
public class UnitController {


    @GetMapping("/sse-invoke")
    public void getList(PlatformOutOrderStockBo platformOutOrderStockBo) throws IOException {

        AsyncContext actx = platformOutOrderStockBo.getActx();

        actx.getResponse().getWriter().write("b server return");
        actx.getResponse().getWriter().flush();
    }



}
