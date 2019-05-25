package com.yingchong.service.data_service.resource;

import com.yingchong.service.data_service.BizBean.ResponseBean;
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
    @ApiOperation(value="宗教信仰访问人次数占比", notes="宗教信仰访问人次数占比")
    @RequestMapping(value={"/religionPercent"}, method= RequestMethod.GET)
    public ResponseBean<List<BizReligionPercent>> religionPercent(
            @RequestParam("startDate") String startDate,
            @RequestParam("endDate") String endDate
    ){
        return religionService.religionPercent(startDate,endDate);
    }

}
