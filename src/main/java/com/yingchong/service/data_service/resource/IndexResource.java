package com.yingchong.service.data_service.resource;

import com.yingchong.service.data_service.BizBean.BizTestBean;
import com.yingchong.service.data_service.BizBean.ResponseBean;
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
}