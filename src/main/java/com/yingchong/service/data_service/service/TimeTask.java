package com.yingchong.service.data_service.service;

import com.yingchong.service.data_service.BizBean.ResponseBean;
import com.yingchong.service.data_service.BizBean.biz_flux.BizDataBean;
import com.yingchong.service.data_service.utils.DateUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.List;

@Component
@EnableScheduling
public class TimeTask {
    private static final Logger logger = LoggerFactory.getLogger(TimeTask.class);

    @Autowired
    private IndexService indexService;


    /**
     * 更新今天的步数到之前的步数
     * 每天凌晨 0 点执行一次
     */
    @Scheduled(cron = "0 0 0 1/1 * ?")
    public void addTodayDropsToBefore(){
        Date nowDate = new Date();

        ResponseBean<List<BizDataBean>> flux = indexService.Flux(DateUtil.formatDateToStr(nowDate, "yyyy-MM-dd"),
                DateUtil.formatDateToStr(nowDate, "yyyy-MM-dd"));
    }
}
