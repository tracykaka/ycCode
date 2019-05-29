package com.yingchong.service.data_service.resource;

import com.yingchong.service.data_service.service.CalculateDataService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Api(value="dateService",tags={"操作接口"})
@RestController
@RequestMapping("/data")
@Produces(MediaType.APPLICATION_JSON)
@Component
public class DataResource {

    @Autowired
    private CalculateDataService calculateDataService;

    @ApiOperation(value="结算所有结果集数据", notes="结算所有结果集数据")
    @RequestMapping(value={"/calculDate"}, method= RequestMethod.GET)
    public void calculDate(){
        calculateDataService.calculDate();
    }

}
