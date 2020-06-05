package com.apl.inner.sys.pojo;

import lombok.Data;

import javax.servlet.AsyncContext;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;


@Data
public class PlatformOutOrderStockBo implements Serializable {


    AsyncContext actx;

    private Long orderId;

    private List<PlatformOutOrderStock> platformOutOrderStocks = new ArrayList<>();

    @Data
    public static class PlatformOutOrderStock implements Serializable{

        //仓库id
        private Long whId;

        //商品id
        private Long commodityId;

        //改变的数量
        private Integer changeCount;


    }


}

