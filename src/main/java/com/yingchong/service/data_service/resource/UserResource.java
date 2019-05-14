package com.yingchong.service.data_service.resource;

import io.swagger.annotations.Api;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Api(value="用户service",tags={"用户操作接口"})
@RestController
@RequestMapping("/user")
@Produces(MediaType.APPLICATION_JSON)
@Component
public class UserResource {


}
