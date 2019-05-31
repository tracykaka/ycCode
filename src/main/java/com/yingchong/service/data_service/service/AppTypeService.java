package com.yingchong.service.data_service.service;

import com.yingchong.service.data_service.BizBean.ResponseBean;
import com.yingchong.service.data_service.BizBean.biz_app.BizAppTypeBean;
import com.yingchong.service.data_service.mapper.MyAppTypeMapper;
import com.yingchong.service.data_service.mybatis.mapper.ActionTypeMapper;
import com.yingchong.service.data_service.mybatis.model.ActionType;
import com.yingchong.service.data_service.mybatis.model.ActionTypeExample;
import com.yingchong.service.data_service.utils.DateUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.nio.charset.StandardCharsets;
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
            bizAppTypeBean.setApp(new String(bizAppTypeBean.getApp().getBytes(StandardCharsets.ISO_8859_1), StandardCharsets.UTF_8));
        }
        return new ResponseBean<>(bizAppTypeBeans);
    }

    /**
     * 趋势
     * @param startDate 开始时间
     * @param endDate   结束时间
     * @return
     */
    public ResponseBean<List<BizAppTypeBean>> actionTypeTrend(String startDate,String endDate) {
        List<BizAppTypeBean> bizAppTypeBeans = myAppTypeMapper.selectAppTypeTreadResult(startDate, endDate);
        for (BizAppTypeBean bizAppTypeBean : bizAppTypeBeans) {
            bizAppTypeBean.setApp(new String(bizAppTypeBean.getApp().getBytes(StandardCharsets.ISO_8859_1), StandardCharsets.UTF_8));
            //bizAppTypeBean.setApp(new String(bizAppTypeBean.getApp().getBytes(StandardCharsets.ISO_8859_1), StandardCharsets.UTF_8));
        }
        return new ResponseBean<>(bizAppTypeBeans);
    }

}
