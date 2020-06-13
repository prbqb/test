package com.apl.inner.sys.feign.impl;

import com.apl.inner.sys.feign.AFeign;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class AFeignImpl implements AFeign {
    @Override
    public void invokeBServer() {

        System.out.println("server error");
    }

    @Override
    public void sendIds(List<Long> ids) {
        System.out.println("send ids");
    }
}
