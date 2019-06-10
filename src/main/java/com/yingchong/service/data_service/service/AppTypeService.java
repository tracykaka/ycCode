package com.yingchong.service.data_service.service;

import com.yingchong.service.data_service.BizBean.ResponseBean;
import com.yingchong.service.data_service.BizBean.biz_app.BizAppTreadBean;
import com.yingchong.service.data_service.BizBean.biz_app.BizAppTypeBean;
import com.yingchong.service.data_service.mapper.MyAppTypeMapper;
import com.yingchong.service.data_service.mybatis.mapper.ActionTypeMapper;
import com.yingchong.service.data_service.mybatis.model.ActionType;
import com.yingchong.service.data_service.mybatis.model.ActionTypeExample;
import com.yingchong.service.data_service.utils.CodeUtils;
import com.yingchong.service.data_service.utils.DateUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.List;

@Service
public class AppTypeService {
    private static final Logger logger = LoggerFactory.getLogger(AppTypeService.class);

    @Autowired
    private MyAppTypeMapper myAppTypeMapper;

    @Autowired
    private ActionTypeMapper actionTypeMapper;

    public static final String dateParttern = "yyyy-MM-dd";

    public boolean insertActionType(String date) {

        try {
            ActionTypeExample example = new ActionTypeExample();
            example.createCriteria().andActionDateEqualTo(DateUtil.StringToDate(date,dateParttern));
            List<ActionType> actionTypes = actionTypeMapper.selectByExample(example);
            if (actionTypes != null && actionTypes.size() > 0) {
                logger.info("数据已经插入,不再重复插入");
                return true;
            }

            List<BizAppTypeBean> bizAppBeans = myAppTypeMapper.selectApp(date.replaceAll("-", "") + "_action");

            for (BizAppTypeBean type : bizAppBeans) {
                ActionType at = new ActionType();
                at.setActionCount(type.getNum());
                String app = type.getApp();
                //logger.info("utf8: {}",new String(app.getBytes(StandardCharsets.ISO_8859_1), StandardCharsets.UTF_8));
                at.setActionName(app);
                at.setActionDate(DateUtil.StringToDate(date, dateParttern));
                Date date1 = new Date();
                at.setCreateTime(date1);
                at.setUpdateTime(date1);
                actionTypeMapper.insert(at);
            }
        } catch (Exception e) {
            logger.error("插入action_type 数据异常:",e);
            return false;
        }
        return true;
    }

    public ResponseBean<List<BizAppTypeBean>> actionTypeList(String startDate, String endDate) {
        List<BizAppTypeBean> bizAppTypeBeans = myAppTypeMapper.selectAppTypeResult(startDate, endDate);
        for (BizAppTypeBean bizAppTypeBean : bizAppTypeBeans) {
            //logger.info("utf8: {}",new String(bizAppTypeBean.getApp().getBytes(StandardCharsets.ISO_8859_1), StandardCharsets.UTF_8));
            bizAppTypeBean.setApp(CodeUtils.convertCharset(bizAppTypeBean.getApp()));
        }
        return new ResponseBean<>(bizAppTypeBeans);
    }

    /**
     * 趋势
     * @param startDate 开始时间
     * @param endDate   结束时间
     * @return
     */
    public ResponseBean<BizAppTreadBean> actionTypeTrend(String startDate, String endDate) {
        BizAppTreadBean bizAppTreadBean = new BizAppTreadBean();
        List<BizAppTypeBean> top3 = myAppTypeMapper.selectAppTypeResult(startDate, endDate);
        if (top3 == null || top3.size()==0) {
            return new ResponseBean<>(bizAppTreadBean);
        }
        List<BizAppTypeBean> bizAppTypeBeans1 = null;
        List<BizAppTypeBean> bizAppTypeBeans2 = null;
        List<BizAppTypeBean> bizAppTypeBeans3 = null;
        for (int i=0;i<3;i++) {
            BizAppTypeBean bizAppTypeBean = top3.get(i);
            List<BizAppTypeBean> bizAppTypeBeans = myAppTypeMapper.selectAppTypeTreadResultByAppName(startDate, endDate, CodeUtils.convertCharset88591(bizAppTypeBean.getApp()));
            if(i==0){
                bizAppTypeBeans1 = bizAppTypeBeans;
                for (BizAppTypeBean appTypeBean : bizAppTypeBeans1) {
                    appTypeBean.setApp(CodeUtils.convertCharset(appTypeBean.getApp()));
                    appTypeBean.setDateStr(DateUtil.formatDateToStr(appTypeBean.getDate(),AppTypeService.dateParttern));
                }
                bizAppTreadBean.setList1(bizAppTypeBeans1);
            }
            if(i==1){
                bizAppTypeBeans2 = bizAppTypeBeans;
                for (BizAppTypeBean appTypeBean : bizAppTypeBeans2) {
                    appTypeBean.setApp(CodeUtils.convertCharset(appTypeBean.getApp()));
                    appTypeBean.setDateStr(DateUtil.formatDateToStr(appTypeBean.getDate(),AppTypeService.dateParttern));
                }
                bizAppTreadBean.setList2(bizAppTypeBeans2);
            }

            if(i==2) {
                bizAppTypeBeans3 = bizAppTypeBeans;
                for (BizAppTypeBean appTypeBean : bizAppTypeBeans3) {
                    appTypeBean.setApp(CodeUtils.convertCharset(appTypeBean.getApp()));
                    appTypeBean.setDateStr(DateUtil.formatDateToStr(appTypeBean.getDate(),AppTypeService.dateParttern));
                }
                bizAppTreadBean.setList3(bizAppTypeBeans3);
            }
        }
        checkTrendData(bizAppTreadBean, startDate, endDate);
        /*List<BizAppTypeBean> bizAppTypeBeans = myAppTypeMapper.selectAppTypeTreadResult(startDate, endDate);
        for (BizAppTypeBean bizAppTypeBean : bizAppTypeBeans) {
            //bizAppTypeBean.setApp(new String(bizAppTypeBean.getApp().getBytes(StandardCharsets.ISO_8859_1), StandardCharsets.UTF_8));
            bizAppTypeBean.setApp(CodeUtils.convertCharset(bizAppTypeBean.getApp()));

            bizAppTypeBean.setDateStr(DateUtil.formatDateToStr(bizAppTypeBean.getDate(),"yyyy-MM-dd"));
        }*/
        return new ResponseBean<>(bizAppTreadBean);
    }

    private void checkTrendData(BizAppTreadBean bizAppTreadBean,String startDate, String endDate) {
        List<BizAppTypeBean> list1 = bizAppTreadBean.getList1();
        List<BizAppTypeBean> list2 = bizAppTreadBean.getList2();
        List<BizAppTypeBean> list3 = bizAppTreadBean.getList3();
        LocalDate start = LocalDate.parse(startDate, DateTimeFormatter.ofPattern(AppTypeService.dateParttern));
        LocalDate end = LocalDate.parse(endDate, DateTimeFormatter.ofPattern(AppTypeService.dateParttern));
        int i = 0;
        for (LocalDate date = start; date.isBefore(end); date = date.plusDays(1))
        {
            checkListData(list1, start, i, date);
            checkListData(list2, start, i, date);
            checkListData(list3, start, i, date);
            i++;
        }
    }
    private void checkListData(List<BizAppTypeBean> list,LocalDate start, int i, LocalDate date) {
        String app = list.get(0).getApp();
        if(list.size()-1 > i){
            BizAppTypeBean appTypeBean = list.get(i);
            if(appTypeBean==null || !date.toString().equals(appTypeBean.getDateStr())){
                appTypeBean = new BizAppTypeBean();
                appTypeBean.setDateStr(start.plusDays(i).toString());
                appTypeBean.setApp(app);
                appTypeBean.setNum(0);
                list.add(i,appTypeBean);
            }
        }else {
            BizAppTypeBean appTypeBean = new BizAppTypeBean();
            appTypeBean.setDateStr(start.plusDays(i+1).toString());
            appTypeBean.setApp(app);
            appTypeBean.setNum(0);
            list.add(appTypeBean);
        }
    }

}
