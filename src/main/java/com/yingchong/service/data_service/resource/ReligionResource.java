package com.yingchong.service.data_service.resource;

import com.github.pagehelper.PageInfo;
import com.yingchong.service.data_service.BizBean.ResponseBean;
import com.yingchong.service.data_service.BizBean.biz_religion.BizReligionDetailInfo;
import com.yingchong.service.data_service.BizBean.biz_religion.BizReligionPercent;
import com.yingchong.service.data_service.service.ReligionService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Api(value="religion_service",tags={""})
@RestController
@RequestMapping("/religion")
@Produces(MediaType.APPLICATION_JSON)
@Component
public class ReligionResource {

    @Autowired
    private ReligionService religionService;

    @ApiImplicitParams({
            @ApiImplicitParam(name = "date", value = "date", required = true, dataType = "string", paramType = "query")
    })
    @ApiOperation(value="每日插入宗教次数结果表", notes="每日插入宗教次数结果表")
    @RequestMapping(value={"/insertReligionTimes"}, method= RequestMethod.GET)
    public boolean insertReligionTimes(
            @RequestParam("date") String date
    ){
        return religionService.insertReligionTimes(date);
    }

    @ApiImplicitParams({
            @ApiImplicitParam(name = "startDate", value = "startDate", required = true, dataType = "string", paramType = "query"),
            @ApiImplicitParam(name = "endDate", value = "endDate", required = true, dataType = "string", paramType = "query")
    })
    @ApiOperation(value="宗教信仰访问分类", notes="宗教信仰访问分类")
    @RequestMapping(value={"/religionCategory"}, method= RequestMethod.GET)
    public ResponseBean<List<BizReligionPercent>> religionCategory(
            @RequestParam("startDate") String startDate,
            @RequestParam("endDate") String endDate
    ){
        return religionService.religionCategory(startDate,endDate);
    }

    @ApiImplicitParams({
            @ApiImplicitParam(name = "startDate", value = "startDate", required = true, dataType = "string", paramType = "query"),
            @ApiImplicitParam(name = "endDate", value = "endDate", required = true, dataType = "string", paramType = "query")
    })
    @ApiOperation(value="宗教信仰访问趋势图", notes="宗教信仰访问趋势图")
    @RequestMapping(value={"/religionTread"}, method= RequestMethod.GET)
    public ResponseBean<List<BizReligionPercent>> religionTread(
            @RequestParam("startDate") String startDate,
            @RequestParam("endDate") String endDate
    ){
        return religionService.religionTread(startDate,endDate);
    }

    @ApiImplicitParams({
            @ApiImplicitParam(name = "religionName", value = "宗教名称", required = true, dataType = "string", paramType = "query"),
            @ApiImplicitParam(name = "startDate", value = "startDate", required = true, dataType = "string", paramType = "query"),
            @ApiImplicitParam(name = "endDate", value = "endDate", required = true, dataType = "string", paramType = "query"),
            @ApiImplicitParam(name = "page", value = "页码", required = true, dataType = "int", paramType = "query"),
            @ApiImplicitParam(name = "pageSize", value = "页码条数", required = true, dataType = "int", paramType = "query")
    })
    @ApiOperation(value="查询宗教信息详情", notes="查询宗教信息详情")
    @RequestMapping(value={"/religionDetail"}, method= RequestMethod.GET)
    public ResponseBean<PageInfo<BizReligionDetailInfo>> religionDetail(
            @RequestParam("religionName") String religionName,
            @RequestParam("startDate") String startDate,
            @RequestParam("endDate") String endDate,
            @RequestParam("page") Integer page,
            @RequestParam("pageSize") Integer pageSize
    ){
        return religionService.religionDetail(religionName,startDate,endDate,page,pageSize);
    }

    @ApiImplicitParams({
            @ApiImplicitParam(name = "startDate", value = "startDate", required = true, dataType = "string", paramType = "query"),
            @ApiImplicitParam(name = "endDate", value = "endDate", required = true, dataType = "string", paramType = "query"),
            @ApiImplicitParam(name = "page", value = "页码", required = true, dataType = "int", paramType = "query"),
            @ApiImplicitParam(name = "pageSize", value = "页码条数", required = true, dataType = "int", paramType = "query")
    })
    @ApiOperation(value="宗教信仰url网址访问TOP N 分页", notes="pageSize 相当于 N")
    @RequestMapping(value={"/religionRank"}, method= RequestMethod.GET)
    public ResponseBean<PageInfo<BizReligionDetailInfo>> religionRank(
            @RequestParam("startDate") String startDate,
            @RequestParam("endDate") String endDate,
            @RequestParam("page") Integer page,
            @RequestParam("pageSize") Integer pageSize
    ){
        return religionService.religionRank(startDate,endDate,page,pageSize);
    }


    @ApiImplicitParams({
            @ApiImplicitParam(name = "user", value = "用户名,ip", dataType = "string", paramType = "query"),
            @ApiImplicitParam(name = "startDate", value = "startDate", required = true, dataType = "string", paramType = "query"),
            @ApiImplicitParam(name = "endDate", value = "endDate", required = true, dataType = "string", paramType = "query"),
            @ApiImplicitParam(name = "page", value = "页码", required = true, dataType = "int", paramType = "query"),
            @ApiImplicitParam(name = "pageSize", value = "页码条数", required = true, dataType = "int", paramType = "query")
    })
    @ApiOperation(value="宗教信仰个人访问次数TOP3 分页", notes="按人统计,统计每个人访问次数,进行排序 pageSize 相当于 N")
    @RequestMapping(value={"/peopleVisitTimes"}, method= RequestMethod.GET)
    public ResponseBean<PageInfo<BizReligionDetailInfo>> peopleVisitTimes(
            @RequestParam(value = "user",required = false) String user,
            @RequestParam("startDate") String startDate,
            @RequestParam("endDate") String endDate,
            @RequestParam("page") Integer page,
            @RequestParam("pageSize") Integer pageSize
    ){
        return religionService.peopleVisitTimes(user,startDate,endDate,page,pageSize);
    }

    @ApiImplicitParams({
            @ApiImplicitParam(name = "user", value = "用户名,ip", dataType = "string", paramType = "query"),
            @ApiImplicitParam(name = "startDate", value = "startDate", required = true, dataType = "string", paramType = "query"),
            @ApiImplicitParam(name = "endDate", value = "endDate", required = true, dataType = "string", paramType = "query"),
            @ApiImplicitParam(name = "page", value = "页码", required = true, dataType = "int", paramType = "query"),
            @ApiImplicitParam(name = "pageSize", value = "页码条数", required = true, dataType = "int", paramType = "query")
    })
    @ApiOperation(value="详细信息,访问网站的详细信息,点击类别,右边的详细信息", notes="详细信息,访问网站的详细信息")
    @RequestMapping(value={"/peopleVisitTimesDetail"}, method= RequestMethod.GET)
    public ResponseBean<PageInfo<BizReligionDetailInfo>> peopleVisitTimesDetail(
            @RequestParam(value = "user",required = false) String user,
            @RequestParam("startDate") String startDate,
            @RequestParam("endDate") String endDate,
            @RequestParam("page") Integer page,
            @RequestParam("pageSize") Integer pageSize
    ){
        return religionService.peopleVisitTimesDetail(user,startDate,endDate,page,pageSize);
    }

}
