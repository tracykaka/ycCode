package com.yingchong.service.data_service.service;

import com.yingchong.service.data_service.utils.DateUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
@EnableScheduling
public class TimeTask {
    private static final Logger logger = LoggerFactory.getLogger(TimeTask.class);

    @Autowired
    private CalculateDataService calculateDataService;

    /**
     *
     * 每天凌晨 0 点执行一次
     */
    @Scheduled(cron = "0 0 0 1/1 * ?")
    public void calculateResult(){
        Date nowDate = new Date();
        nowDate = DateUtil.addDay(nowDate, -1);//减一天
        String date = DateUtil.formatDateToStr(nowDate, "yyyy-MM-dd");
        calculateDataService.TimeTask(date);
    }
}
