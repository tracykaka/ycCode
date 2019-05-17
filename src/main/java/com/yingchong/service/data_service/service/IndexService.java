package com.yingchong.service.data_service.service;

import com.yingchong.service.data_service.BizBean.ResponseBean;
import com.yingchong.service.data_service.BizBean.biz_flux.BizDataBean;
import com.yingchong.service.data_service.mapper.MyFluxMapper;
import com.yingchong.service.data_service.mybatis.mapper.FluxResultMapper;
import com.yingchong.service.data_service.mybatis.model.FluxResult;
import com.yingchong.service.data_service.mybatis.model.FluxResultExample;
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
    private static final Logger logger = LoggerFactory.getLogger(IndexService.class);

    @Autowired
    private MyFluxMapper myFluxMapper;

    @Autowired
    private FluxResultMapper fluxResultMapper;

    /**
     *
     * @param startDate 开始时间 2019-05-01
     * @param endData 结束时间 2019-05-15
     * @return
     */
    public ResponseBean<List<BizDataBean>> Flux_1(String startDate, String endData) {
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

    /**
     * 查询结果集,返回给前端数据
     * @param startDate 开始时间 2019-05-01
     * @param endData 结束时间 2019-05-15
     * @return
     */
    public ResponseBean<List<FluxResult>> Flux(String startDate, String endData) {
        FluxResultExample example = new FluxResultExample();
        example.createCriteria().andFluxDateBetween(DateUtil.StringToDate(startDate,"yyyy-MM-dd"),DateUtil.StringToDate(endData,"yyyy-MM-dd"));
        List<FluxResult> fluxResults = fluxResultMapper.selectByExample(example);
        return new ResponseBean<>(fluxResults);
    }

    /**
     * 查询指定日期的原始数据
     * @param date 日期 2019-05-17
     * @return 1
     */
    public List<BizDataBean> Flux(String date) {
        String param = date.replaceAll("-","");
        List<BizDataBean> bizDataBeans = myFluxMapper.selectFlux(param + "_flux");
        for (BizDataBean bizDataBean : bizDataBeans) {
            bizDataBean.setDate(date);
        }
        return bizDataBeans;
    }

    /**
     * 每日同步数据
     * @param date
     * @return
     */
    public boolean insertFluxResult(String date) {
        FluxResultExample example = new FluxResultExample();
        example.createCriteria().andFluxDateEqualTo(DateUtil.StringToDate(date, "yyyy-MM-dd"));
        List<FluxResult> fluxResults = fluxResultMapper.selectByExample(example);
        if (fluxResults != null && fluxResults.size() > 0) {
            logger.info("数据已经插入,不再重复插入");
            return true;
        }
        List<BizDataBean> flux = this.Flux(date);
        try {
            for (BizDataBean bizDataBean : flux) {
                FluxResult fr = new FluxResult();
                fr.setUpload(Double.parseDouble(bizDataBean.getUploadFlux()));
                fr.setDownload(Double.parseDouble(bizDataBean.getDownFlux()));
                fr.setFluxDate(DateUtil.formatStringToDate(bizDataBean.getDate(),"yyyy-MM-dd"));
                Date nowDate = new Date();
                fr.setCreateTime(nowDate);
                fr.setUpdateTime(nowDate);
                int insert = fluxResultMapper.insert(fr);
            }
        } catch (Exception e) {
            logger.error("insertFluxResult error:",e);
            return false;
        }
        return true;
    }



}
