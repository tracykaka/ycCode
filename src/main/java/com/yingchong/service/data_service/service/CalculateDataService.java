package com.yingchong.service.data_service.service;

import com.yingchong.service.data_service.service.thread.CompareThread;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.concurrent.ExecutorService;

@Service
public class CalculateDataService {

    private static final Logger logger = LoggerFactory.getLogger(CalculateDataService.class);
    @Autowired
    private IndexService indexService;

    @Autowired
    private AppTypeService appTypeService;

    @Autowired
    private ReligionService religionService;

    public void calculIndexDate() {
        LocalDate today = LocalDate.now();
        LocalDate endDate = LocalDate.of(2018, 10, 3);
        ExecutorService pool = CompareThread.newCachedThreadPool();

        for (LocalDate date = today.minusDays(1); date.isAfter(endDate); date = date.minusDays(1))
        {
            logger.info("计算:{}的数据",date);
            //this.TimeTask(date.toString());
            this.executeJob(pool,date.toString());
        }
        pool.shutdown();
    }

    private void executeJob(ExecutorService pool, String date) {
        Runnable runnable = () -> TimeTaskIndex(date);
        pool.execute(runnable);
    }

    public void calculReligionDate() {
        LocalDate today = LocalDate.now();
        LocalDate endDate = LocalDate.of(2018, 10, 3);
        for (LocalDate date = today.minusDays(1); date.isAfter(endDate); date = date.minusDays(1))
        {
            logger.info("计算:{}的数据",date);
            try {
            //插入宗教访问次数结果集 此接口较慢
            religionService.insertReligionTimes(date.toString());
            } catch (Exception e) {
                logger.error("宗教每日数据",e);
            }
        }
    }
    public void calculReligionDateByDate(String startDateStr,String endDateStr) {
        LocalDate startDate = LocalDate.parse(startDateStr);
        LocalDate endDate = LocalDate.parse(endDateStr);
        for (LocalDate date = startDate; date.isAfter(endDate); date = date.minusDays(1))
        {
            logger.info("计算:{}的数据",date);
            try {
            //插入宗教访问次数结果集 此接口较慢
            religionService.insertReligionTimes(date.toString());
            } catch (Exception e) {
                logger.error("宗教每日数据",e);
            }
        }
    }

    public void TimeTask(String date) {
        indexData(date);

        try {
            //插入宗教访问次数结果集 此接口较慢
            religionService.insertReligionTimes(date);
        } catch (Exception e) {
            logger.error("宗教每日数据",e);
        }
    }
    public void TimeTaskIndex(String date) {
        indexData(date);

    }

    private void indexData(String date) {
        try {
            //插入流量每日数据
            indexService.insertFluxResult(date);
        } catch (Exception e) {
            logger.error("插入流量每日数据异常", e);
        }

        try {
            //上网时长,每日同步数据
            indexService.insertOnlineTime(date);
        } catch (Exception e) {
            logger.error("上网时长,每日同步数据", e);
        }

        try {
            //应用流量，每日同步数据
            indexService.insertAppFluxSort(date);
        } catch (Exception e) {
            logger.error("应用流量，每日同步数据", e);
        }

        try {
            //网络行为意识分类每日数据
            appTypeService.insertActionType(date);
        } catch (Exception e) {
            logger.error("网络行为意识分类每日数据", e);
        }
    }

}
