package com.yingchong.service.data_service.service;

import com.yingchong.service.data_service.BizBean.BizTestBean;
import com.yingchong.service.data_service.BizBean.ResponseBean;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class IndexService {

    private static final Logger logger = LoggerFactory.getLogger(IndexService.class);
    public ResponseBean<BizTestBean> testIndex(String param) {
        logger.info("testIndex ... ... ...{}",param);
        BizTestBean bizTestBean = new BizTestBean();
        bizTestBean.setId("1");
        bizTestBean.setAge("20");
        bizTestBean.setName("zhangsan");
        return new ResponseBean<>(bizTestBean);
    }
    //public ResponseBean<BizTestBean> Flux(String startDate,String endData) {




    //}
}
