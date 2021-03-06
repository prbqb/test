package com.apl.inner.sys.controller;


import com.apl.inner.sys.feign.AFeign;
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
import java.util.Arrays;
import java.util.Date;
import java.util.List;

/**
 *
 * @author cy
 * @since 2019-12-19
 */
@RestController
@RequestMapping("/test")
public class UnitController {

    @Autowired
    AFeign aFeign;

    @GetMapping("/sse-invoke")
    public void getList(PlatformOutOrderStockBo platformOutOrderStockBo) throws IOException {

        AsyncContext actx = platformOutOrderStockBo.getActx();

        actx.getResponse().getWriter().write("b server return");
        actx.getResponse().getWriter().flush();
    }


    @GetMapping("/send")
    public void send() throws IOException {

        List<PlatformOutOrderStockBo> ids = new ArrayList<>();
        PlatformOutOrderStockBo platformOutOrderStockBo = new PlatformOutOrderStockBo();

        ids.add(platformOutOrderStockBo);
        aFeign.sendIds(ids);
    }



}
