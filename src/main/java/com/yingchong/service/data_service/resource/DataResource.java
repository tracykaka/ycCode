package com.yingchong.service.data_service.resource;

import com.yingchong.service.data_service.service.CalculateDataService;
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

@Api(value="dateService",tags={"数据操作接口"})
@RestController
@RequestMapping("/data")
@Produces(MediaType.APPLICATION_JSON)
@Component
public class DataResource {

    @Autowired
    private CalculateDataService calculateDataService;

    @ApiOperation(value="结算首页结果集数据", notes="结算首页结果集数据")
    @RequestMapping(value={"/calculIndexDate"}, method= RequestMethod.GET)
    public void calculIndexDate(){
        calculateDataService.calculIndexDate();
    }

    @ApiOperation(value="结算宗教结果集数据", notes="结算宗教结果集数据")
    @RequestMapping(value={"/calculReligionDate"}, method= RequestMethod.GET)
    public void calculReligionDate(){
        calculateDataService.calculReligionDate();
    }


    @ApiImplicitParams({
            @ApiImplicitParam(name = "startDate", value = "startDate", required = true, dataType = "string", paramType = "query"),
            @ApiImplicitParam(name = "endDate", value = "endDate", required = true, dataType = "string", paramType = "query")
    })
    @ApiOperation(value="结算宗教结果集数据-按照日期计算", notes="结算宗教结果集数据-按照日期计算")
    @RequestMapping(value={"/calculReligionDateByDate"}, method= RequestMethod.GET)
    public void calculReligionDateByDate(
            @RequestParam("startDate") String startDate,
            @RequestParam("endDate") String endDate
    ){
        calculateDataService.calculReligionDateByDate(startDate,endDate);
    }

}
