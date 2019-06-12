package com.yingchong.service.data_service.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.yingchong.service.data_service.BizBean.ResponseBean;
import com.yingchong.service.data_service.BizBean.biz_action.BizActionBean;
import com.yingchong.service.data_service.BizBean.biz_religion.BizReligionDetailInfo;
import com.yingchong.service.data_service.BizBean.biz_religion.BizReligionPercent;
import com.yingchong.service.data_service.BizBean.biz_religion.BizReligionTrend;
import com.yingchong.service.data_service.mapper.MyActionMapper;
import com.yingchong.service.data_service.mapper.MyReligionTimeMapper;
import com.yingchong.service.data_service.mybatis.mapper.FeatureUrlMapper;
import com.yingchong.service.data_service.mybatis.mapper.ReligionTimesMapper;
import com.yingchong.service.data_service.mybatis.model.FeatureUrl;
import com.yingchong.service.data_service.mybatis.model.FeatureUrlExample;
import com.yingchong.service.data_service.mybatis.model.ReligionTimes;
import com.yingchong.service.data_service.mybatis.model.ReligionTimesExample;
import com.yingchong.service.data_service.service.thread.CompareThread;
import com.yingchong.service.data_service.utils.CodeUtils;
import com.yingchong.service.data_service.utils.DateUtil;
import com.yingchong.service.data_service.utils.JdomUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.nio.charset.StandardCharsets;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ExecutorService;

@Service
public class ReligionService {

    private static final Logger logger = LoggerFactory.getLogger(ReligionService.class);

    //private Integer start = 0;

    private Integer step = 10000;

    private String trace_t = "trace_t";
    private String web_url = "web_url";
    private String url = "url";
    @Autowired
    private MyActionMapper myActionMapper;
    @Autowired
    private FeatureUrlMapper featureUrlMapper;

    @Autowired
    private ReligionTimesMapper religionTimesMapper;

    @Autowired
    private MyReligionTimeMapper myReligionTimeMapper;

    /***
     * 详细信息,访问网站的详细信息
     * @param user
     * @param startDate
     * @param endDate
     * @param page
     * @param pageSize
     * @return
     */
    //@JsonInclude(JsonInclude.Include.NON_NULL)
    public ResponseBean<PageInfo<BizReligionDetailInfo>> peopleVisitTimesDetail(
            String user,
            String startDate,String endDate,
            Integer page,Integer pageSize
    ) {
        PageHelper.startPage(page, pageSize);
        List<BizReligionDetailInfo> bizReligionDetailInfos = myReligionTimeMapper.peopleVisitTimesDetail(user, startDate, endDate);
        for (BizReligionDetailInfo bizReligionDetailInfo : bizReligionDetailInfos) {
            bizReligionDetailInfo.setUrl(CodeUtils.convertCharset(bizReligionDetailInfo.getUrl()));
            bizReligionDetailInfo.setTitle(CodeUtils.convertCharset(bizReligionDetailInfo.getTitle()));
            bizReligionDetailInfo.setTerminalDetail(CodeUtils.convertCharset(bizReligionDetailInfo.getTerminalDetail()));
            bizReligionDetailInfo.setTerminal(CodeUtils.convertCharset(bizReligionDetailInfo.getTerminal()));
            bizReligionDetailInfo.setReligionName(CodeUtils.convertCharset(bizReligionDetailInfo.getReligionName()));
        }
        PageInfo<BizReligionDetailInfo> data = new PageInfo<>(bizReligionDetailInfos);
        return new ResponseBean<>(data);
    }

    /**
     * 按人统计,统计每个人访问次数,进行排序
     * 宗教信仰个人访问次数TOP N
     * @param startDate 开始时间
     * @param endDate 结束时间
     * @param page 页码
     * @param pageSize 每页条数
     * @return
     */
    public ResponseBean<PageInfo<BizReligionDetailInfo>> peopleVisitTimes(
            String user,
            String startDate,String endDate,
            Integer page,Integer pageSize
    ) {
        PageHelper.startPage(page, pageSize);
        List<BizReligionDetailInfo> bizReligionDetailInfos = myReligionTimeMapper.selectPeopleVisitTimes(user,startDate, endDate);
        for (BizReligionDetailInfo bizReligionDetailInfo : bizReligionDetailInfos) {
            bizReligionDetailInfo.setUrl(CodeUtils.convertCharset(bizReligionDetailInfo.getUrl()));
            bizReligionDetailInfo.setTitle(CodeUtils.convertCharset(bizReligionDetailInfo.getTitle()));
            bizReligionDetailInfo.setTerminalDetail(CodeUtils.convertCharset(bizReligionDetailInfo.getTerminalDetail()));
            bizReligionDetailInfo.setTerminal(CodeUtils.convertCharset(bizReligionDetailInfo.getTerminal()));
        }
        PageInfo<BizReligionDetailInfo> data = new PageInfo<>(bizReligionDetailInfos);
        return new ResponseBean<>(data);
    }

    /**
     * 宗教信仰url网址访问TOP N 分页
     * @param startDate 开始时间
     * @param endDate 结束时间
     * @return ResponseBean<List<BizReligionDetailInfo>>
     */
    public ResponseBean<PageInfo<BizReligionDetailInfo>> religionRank(
            String startDate,String endDate,
            Integer page,Integer pageSize) {
        PageHelper.startPage(page, pageSize);
        List<BizReligionDetailInfo> bizReligionDetailInfos = myReligionTimeMapper.selectReligionUrlRank(startDate, endDate);
        for (BizReligionDetailInfo bizReligionDetailInfo : bizReligionDetailInfos) {
            bizReligionDetailInfo.setTitle(CodeUtils.convertCharset(bizReligionDetailInfo.getTitle()));
            bizReligionDetailInfo.setUrl(CodeUtils.convertCharset(bizReligionDetailInfo.getUrl()));
            bizReligionDetailInfo.setTerminal(CodeUtils.convertCharset(bizReligionDetailInfo.getTerminal()));
            bizReligionDetailInfo.setTerminalDetail(CodeUtils.convertCharset(bizReligionDetailInfo.getTerminalDetail()));
        }
        PageInfo<BizReligionDetailInfo> data = new PageInfo<>(bizReligionDetailInfos);
        return new ResponseBean<>(data);
    }

    /**
     * 查询宗教信息详情 分页
     * @param religionName 宗教名称
     * @param startDate 开始时间
     * @param endDate 结束时间
     * @return ResponseBean<List < BizReligionDetailInfo>>
     */
    public ResponseBean<PageInfo<BizReligionDetailInfo>> religionDetail(
            String religionName,String startDate,String endDate,
            Integer page,Integer pageSize) {
        PageHelper.startPage(page, pageSize);
        //List<BizReligionDetailInfo> bizReligionDetailInfos = myReligionTimeMapper.selectReligionDetail(CodeUtils.convertCharset88591(religionName),startDate,endDate);
        List<BizReligionDetailInfo> bizReligionDetailInfos = myReligionTimeMapper.selectReligionDetail(new String(religionName.getBytes(StandardCharsets.UTF_8), StandardCharsets.ISO_8859_1),startDate,endDate);
        for (BizReligionDetailInfo bizReligionDetailInfo : bizReligionDetailInfos) {
            bizReligionDetailInfo.setVisitTime(bizReligionDetailInfo.getDate() == null?"":DateUtil.formatDateToStr(bizReligionDetailInfo.getDate(),"yyyy-MM-dd HH:mm:ss"));
            bizReligionDetailInfo.setReligionName(CodeUtils.convertCharset(bizReligionDetailInfo.getReligionName()));
            bizReligionDetailInfo.setUrl(CodeUtils.convertCharset(bizReligionDetailInfo.getUrl()));
            bizReligionDetailInfo.setTitle(CodeUtils.convertCharset(bizReligionDetailInfo.getTitle()));
            bizReligionDetailInfo.setTerminal(CodeUtils.convertCharset(bizReligionDetailInfo.getTerminal()));
            bizReligionDetailInfo.setTerminalDetail(CodeUtils.convertCharset(bizReligionDetailInfo.getTerminalDetail()));

        }
        PageInfo<BizReligionDetailInfo> data = new PageInfo<>(bizReligionDetailInfos);
        return new ResponseBean<>(data);
    }

    /**
     * 宗教信仰访问趋势图: 佛教,道教,基督教,天主教,伊斯兰教
     *
     * @param startDate 开始时间
     * @param endDate   结束时间
     * @return ResponseBean
     */
    public ResponseBean<BizReligionTrend> religionTrend(String startDate, String endDate) {
        BizReligionTrend bizReligionTrend = new BizReligionTrend();

        String[] religionNames = new String []{"佛教","道教","基督教","伊斯兰教","天主教"};
        List<BizReligionPercent> bizReligionPercents;
        for (String religionName : religionNames) {
            String religionName1 = new String(religionName.getBytes(StandardCharsets.UTF_8), StandardCharsets.ISO_8859_1);
            bizReligionPercents = myReligionTimeMapper.selectReligionTrend(religionName1,startDate, endDate);
            if (religionName.equals("佛教")) {
                for (BizReligionPercent bizReligionPercent : bizReligionPercents) {
                    bizReligionPercent.setReligionName("佛教");
                    bizReligionPercent.setDateStr(DateUtil.formatDateToStr(bizReligionPercent.getTimesDate(),AppTypeService.dateParttern));
                }
                bizReligionTrend.setFojiaoList(bizReligionPercents);
            }
            if (religionName.equals("道教")) {
                for (BizReligionPercent bizReligionPercent : bizReligionPercents) {
                    bizReligionPercent.setReligionName("道教");
                    bizReligionPercent.setDateStr(DateUtil.formatDateToStr(bizReligionPercent.getTimesDate(),AppTypeService.dateParttern));

                }
                bizReligionTrend.setDaojiaoList(bizReligionPercents);
            }
            if (religionName.equals("基督教")) {
                for (BizReligionPercent bizReligionPercent : bizReligionPercents) {
                    bizReligionPercent.setReligionName("基督教");
                    bizReligionPercent.setDateStr(DateUtil.formatDateToStr(bizReligionPercent.getTimesDate(),AppTypeService.dateParttern));
                }
                bizReligionTrend.setJiduList(bizReligionPercents);
            }
            if (religionName.equals("伊斯兰教")) {
                for (BizReligionPercent bizReligionPercent : bizReligionPercents) {
                    bizReligionPercent.setReligionName("伊斯兰教");
                    bizReligionPercent.setDateStr(DateUtil.formatDateToStr(bizReligionPercent.getTimesDate(),AppTypeService.dateParttern));
                }
                bizReligionTrend.setYisilanList(bizReligionPercents);
            }
            if (religionName.equals("天主教")) {
                for (BizReligionPercent bizReligionPercent : bizReligionPercents) {
                    bizReligionPercent.setReligionName("天主教");
                    bizReligionPercent.setDateStr(DateUtil.formatDateToStr(bizReligionPercent.getTimesDate(),AppTypeService.dateParttern));
                }
                bizReligionTrend.setTianzhujiaoList(bizReligionPercents);
            }
        }
        checkData(bizReligionTrend,startDate,endDate);
        return new ResponseBean<>(bizReligionTrend);
    }

    private void checkData(BizReligionTrend bizReligionTrend,String startDate,String endDate) {
        List<BizReligionPercent> daojiaoList = bizReligionTrend.getDaojiaoList();
        List<BizReligionPercent> fojiaoList = bizReligionTrend.getFojiaoList();
        List<BizReligionPercent> jiduList = bizReligionTrend.getJiduList();
        List<BizReligionPercent> tianzhujiaoList = bizReligionTrend.getTianzhujiaoList();
        List<BizReligionPercent> yisilanList = bizReligionTrend.getYisilanList();

        LocalDate start = LocalDate.parse(startDate, DateTimeFormatter.ofPattern(AppTypeService.dateParttern));
        LocalDate end = LocalDate.parse(endDate, DateTimeFormatter.ofPattern(AppTypeService.dateParttern)).plusDays(1);
        int i = 0;
        for (LocalDate date = start; date.isBefore(end); date = date.plusDays(1))
        {
            logger.info("date ={}",date);
            checkListData(fojiaoList, start, i, date,"佛教");
            checkListData(daojiaoList, start, i, date,"道教");
            checkListData(jiduList, start, i, date,"基督教");
            checkListData(tianzhujiaoList, start, i, date,"天主教");
            checkListData(yisilanList, start, i, date,"伊斯兰教");
            i++;
        }
    }

    private void checkListData(List<BizReligionPercent> jiaoList, LocalDate start, int i, LocalDate date,String religionName) {
        if(jiaoList.size()-1 >= i){//循环不超过 size
            BizReligionPercent bizReligionPercent = jiaoList.get(i);
            if(bizReligionPercent==null || !date.toString().equals(bizReligionPercent.getDateStr())){
                bizReligionPercent = new BizReligionPercent();
                bizReligionPercent.setDateStr(start.plusDays(i).toString());
                bizReligionPercent.setReligionName(religionName);
                bizReligionPercent.setVisitTime(0);
                jiaoList.add(i,bizReligionPercent);
            }
        }else {//超过,超过分为数组为空和不为空的时候
            BizReligionPercent bizReligionPercent = new BizReligionPercent();
            bizReligionPercent.setDateStr(start.plusDays(i).toString());
            bizReligionPercent.setReligionName(religionName);
            bizReligionPercent.setVisitTime(0);
            jiaoList.add(bizReligionPercent);
        }
    }

    /**
     * 宗教信仰访问分类
     * 佛教,基督教,天主教,道教,伊斯兰教,其他
     *
     * @param startDate 开始时间
     * @param endDate   结束时间
     * @return ResponseBean
     */
    public ResponseBean<List<BizReligionPercent>> religionCategory(String startDate, String endDate) {
        List<BizReligionPercent> bizReligionPercents = myReligionTimeMapper.selectReligionPercent(startDate, endDate);
        List<BizReligionPercent> result = new ArrayList<>();
        BizReligionPercent other = new BizReligionPercent();
        other.setReligionName("其他");
        double p = 0;
        for (BizReligionPercent bizReligionPercent : bizReligionPercents) {
            String religionName = (CodeUtils.convertCharset(bizReligionPercent.getReligionName()));
            if (religionName.equals("佛教")
                    || religionName.equals("基督教")
                    || religionName.equals("天主教")
                    || religionName.equals("道教")
                    || religionName.equals("伊斯兰教")) {
                bizReligionPercent.setReligionName(religionName);
                result.add(bizReligionPercent);
                p += bizReligionPercent.getPercentage();
            } else {
                other.setVisitTime(other.getVisitTime() + bizReligionPercent.getVisitTime());

            }
        }
        other.setPercentage(1 - p);
        result.add(other);
        return new ResponseBean<>(result);
    }


    /**
     * 插入宗教访问次数结果集
     *
     * @param date
     * @return
     */
    public boolean insertReligionTimes(String date) {
        ReligionTimesExample example = new ReligionTimesExample();
        example.createCriteria().andTimesDateEqualTo(DateUtil.StringToDate(date,AppTypeService.dateParttern));
        long l = religionTimesMapper.countByExample(example);
        if (l > 0) {
            logger.info("已经导入过数据:{}",l);
            return true;
        }

        ExecutorService pool = CompareThread.newCachedThreadPool();
        long ss1 = System.currentTimeMillis();
        //logger.info("s1=========={}",System.currentTimeMillis());
        String tableName = date.replaceAll("-", "") + "_action";

        List<FeatureUrl> featureUrls = featureUrlMapper.selectByExample(new FeatureUrlExample());
        Integer totalCount = myActionMapper.selectCountAction(tableName);
        //logger.info("s2=========={}",System.currentTimeMillis());
        int times = totalCount / step + 1;
        for (int i = 0; i < times; i++) {
            int s1 = (i * step);
            batchSQL(tableName, featureUrls, s1,date);
            //executeJob(pool, tableName, featureUrls, s1,date);
            //logger.info("s4=========={}",System.currentTimeMillis());
            logger.info("i={},s1={}", i, s1);
        }

        long ss2 = System.currentTimeMillis();
        pool.shutdown();
        //logger.info("s5=========={}",System.currentTimeMillis());
        logger.info("接口耗时:{}毫秒", ss2 - ss1);
        return true;
    }

    private void executeJob(ExecutorService pool, String tableName, List<FeatureUrl> featureUrls, int s1,String date) {
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                //batchSQL(tableName, featureUrls, s1,date);
            }
        };
        pool.execute(runnable);
    }

    private void executeJob1(ExecutorService pool, List<FeatureUrl> featureUrls, BizActionBean bizActionBean,String date) {
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                parseMap(featureUrls,date,bizActionBean);
            }
        };
        pool.execute(runnable);
    }
    private void batchSQL(String tableName, List<FeatureUrl> featureUrls, int s1,String date) {
        logger.info("启动线程{}查询:", s1);
        List<BizActionBean> bizActionBeans = myActionMapper.selectActionById(tableName, s1, step);
        //logger.info("s3=========={}",System.currentTimeMillis());
        if (bizActionBeans != null && bizActionBeans.size() > 0) {
            for (BizActionBean bizActionBean : bizActionBeans) {
                parseMap(featureUrls, date, bizActionBean);
                //executeJob1(pool,featureUrls,bizActionBean,date);
            }
        }
        bizActionBeans = null;
    }

    private void parseMap(List<FeatureUrl> featureUrls, String date, BizActionBean bizActionBean) {
        Map<String, String> resultMap = JdomUtils.transferXmlToMap(bizActionBean.getResult());
        if (resultMap != null) {
            String s = resultMap.get(trace_t);
            if (web_url.equals(s)) {//是请求 web 网站
                String userVisitUrl = resultMap.get(url);
                for (FeatureUrl featureUrl : featureUrls) {
                    compareUrl(bizActionBean, resultMap, userVisitUrl, featureUrl,date);
                }
            }
            s = null;
        }
        resultMap = null;
    }

    private void compareUrl(BizActionBean bizActionBean, Map<String, String> resultMap, String userVisitUrl, FeatureUrl featureUrl,String date) {
        //logger.info("userVisitUrl={}, featureUrl={}",userVisitUrl,featureUrl.getUrl());
        //if(userVisitUrl.contains("baidu.com"))
        if (userVisitUrl.contains(featureUrl.getUrl())) {//对应的宗教行为,插入到结果集
            ReligionTimes rt = new ReligionTimes();
            rt.setReligionName(featureUrl.getReligionName());
            if(userVisitUrl.length()>1000) userVisitUrl = userVisitUrl.substring(0,1000);
            rt.setUrl(userVisitUrl);
            rt.setWebName(resultMap.get("title"));
            rt.setWebTitle(resultMap.get("title"));
            rt.setHostIp(bizActionBean.getHostIp());
            rt.setDetIp(bizActionBean.getDstIp());
            rt.setHostPort(bizActionBean.getSrcPort());
            rt.setTerminalDetail(resultMap.get("termtype"));
            rt.setDns(resultMap.get("DNS"));
            if(resultMap.get("urldata").length()>1000){
                rt.setDomainName(resultMap.get("urldata").substring(0,1000));
            }else {
                rt.setDomainName(resultMap.get("urldata"));
            }
            rt.setMacAddress(resultMap.get("mac"));
            rt.setProtocol(resultMap.get("nProtocol"));
            rt.setVisiteTime(bizActionBean.getRecordTime());
            rt.setTerminalType(resultMap.get("termtype"));

            rt.setCreateTime(new Date());
            rt.setUpdateTime(new Date());
            rt.setTimesDate(DateUtil.StringToDate(date,AppTypeService.dateParttern));
            int insert = religionTimesMapper.insert(rt);
            logger.info("匹配到宗教行为:{}, insert={}", userVisitUrl, insert);
        }
    }


}
