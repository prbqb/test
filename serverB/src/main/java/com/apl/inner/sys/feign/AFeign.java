package com.apl.inner.sys.feign;

import com.apl.inner.sys.feign.impl.AFeignImpl;
import com.apl.inner.sys.pojo.PlatformOutOrderStockBo;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@FeignClient(value = "server-a",fallback = AFeignImpl.class)
@Component
public interface AFeign {


    @GetMapping("/test/async")
    void invokeBServer();

    @PostMapping(value = "/test/send" , consumes = MediaType.APPLICATION_JSON_VALUE)
    void sendIds(List<PlatformOutOrderStockBo> platformOutOrderStockBos);

}
