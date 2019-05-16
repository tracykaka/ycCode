package com.yingchong.service.data_service.service;

import com.yingchong.service.data_service.BizBean.BizTestBean;
import com.yingchong.service.data_service.BizBean.ResponseBean;
import com.yingchong.service.data_service.BizBean.biz_flux.BizDataBean;
import com.yingchong.service.data_service.mapper.MyFluxMapper;
import com.yingchong.service.data_service.utils.DateUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class IndexService {

    @Autowired
    private MyFluxMapper myFluxMapper;

    private static final Logger logger = LoggerFactory.getLogger(IndexService.class);
    public ResponseBean<BizTestBean> testIndex(String param) {
        logger.info("testIndex ... ... ...{}",param);
        BizTestBean bizTestBean = new BizTestBean();
        bizTestBean.setId("1");
        bizTestBean.setAge("20");
        bizTestBean.setName("zhangsan");
        return new ResponseBean<>(bizTestBean);
    }

    /**
     *
     * @param startDate 开始时间 2019-05-01
     * @param endData 结束时间 2019-05-15
     * @return
     */
    public ResponseBean<List<BizDataBean>> Flux(String startDate, String endData) {
        int days = DateUtil.differentDays(DateUtil.StringToDate(startDate,"yyyy-MM-dd"), DateUtil.StringToDate(endData,"yyyy-MM-dd"));
        List<BizDataBean> dataList = new ArrayList<>();
        for (int i = 0; i <= days; i++) {
            //String startDate1 = startDate.replaceAll("-", "");
            Date date = DateUtil.addDay(DateUtil.StringToDate(startDate,"yyyy-MM-dd"), i);
            String startDate1 = DateUtil.formatDateStrToString(DateUtil.formatDateToStr(date, "yyyy-MM-dd HH:mm:ss"));
            String param = startDate1.replaceAll("-","");
            List<BizDataBean> bizDataBeans = myFluxMapper.selectFlux( param + "_flux");
            BizDataBean bizDataBean = bizDataBeans.get(0);
            bizDataBean.setDate(startDate1);
            dataList.add(bizDataBean);
        }
        return new ResponseBean<>(dataList);
    }
}
