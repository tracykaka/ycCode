package com.yingchong.service.data_service.resource;

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

}
