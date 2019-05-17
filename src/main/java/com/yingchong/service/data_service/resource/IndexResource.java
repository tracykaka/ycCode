package com.yingchong.service.data_service.resource;

import com.yingchong.service.data_service.BizBean.BizTestBean;
import com.yingchong.service.data_service.BizBean.ResponseBean;
import com.yingchong.service.data_service.BizBean.biz_flux.BizDataBean;
import com.yingchong.service.data_service.mybatis.model.FluxResult;
import com.yingchong.service.data_service.service.IndexService;
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

@Api(value="首页service",tags={"首页操作接口"})
@RestController
@RequestMapping("/index")
@Produces(MediaType.APPLICATION_JSON)
@Component
public class IndexResource {

    @Autowired
    private IndexService indexService;

    @ApiImplicitParams({
            @ApiImplicitParam(name = "param", value = "param", required = true, dataType = "string", paramType = "query")
    })
    @ApiOperation(value="test", notes="test")
    @RequestMapping(value={"/testIndex"}, method= RequestMethod.GET)
    public ResponseBean<BizTestBean> testIndex(
            @RequestParam("param") String param
    ) {
        return indexService.testIndex(param);
    }

    @ApiImplicitParams({
            @ApiImplicitParam(name = "startDate", value = "startDate", required = true, dataType = "string", paramType = "query"),
            @ApiImplicitParam(name = "endDate", value = "endDate", required = true, dataType = "string", paramType = "query")
    })
    @ApiOperation(value="流量", notes="流量(弃用,参考接口)")
    @RequestMapping(value={"/upFlux"}, method= RequestMethod.GET)
    public ResponseBean<List<BizDataBean>> Flux_1(
            @RequestParam("startDate") String startDate,
            @RequestParam("endDate") String endDate
    ){
        return indexService.Flux_1(startDate,endDate);
    }

    @ApiImplicitParams({
            @ApiImplicitParam(name = "startDate", value = "startDate", required = true, dataType = "string", paramType = "query"),
            @ApiImplicitParam(name = "endDate", value = "endDate", required = true, dataType = "string", paramType = "query")
    })
    @ApiOperation(value="流量", notes="流量")
    @RequestMapping(value={"/Flux"}, method= RequestMethod.GET)
    public ResponseBean<List<FluxResult>> Flux(
            @RequestParam("startDate") String startDate,
            @RequestParam("endDate") String endDate
    ){
        return indexService.Flux(startDate,endDate);
    }
}
