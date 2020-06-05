package com.apl.inner.sys.feign;

import com.apl.inner.sys.feign.impl.AFeignImpl;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient(value = "server-a",fallback = AFeignImpl.class)
@Component
public interface AFeign {


    @GetMapping("/test/async")
    void invokeBServer();

}
