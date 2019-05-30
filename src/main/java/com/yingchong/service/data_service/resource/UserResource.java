package com.yingchong.service.data_service.resource;

import com.yingchong.service.data_service.BizBean.BizUser;
import com.yingchong.service.data_service.BizBean.ResponseBean;
import com.yingchong.service.data_service.mybatis.model.User;
import com.yingchong.service.data_service.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;

@Api(value="用户service",tags={"用户操作接口"})
@RestController
@RequestMapping("/user")
@Produces(MediaType.APPLICATION_JSON)
@Component
public class UserResource {

    @Autowired
    private UserService userService;

    @ApiImplicitParams({
            @ApiImplicitParam(name = "userName", value = "用户名", required = true, dataType = "String", paramType = "query"),
            @ApiImplicitParam(name = "password", value = "密码", required = true, dataType = "String", paramType = "query")
    })
    @PostMapping(value={"/login"})
    public ResponseBean<BizUser> login(
            @Context HttpServletRequest request,
            @RequestParam(value = "userName") String  userName,
            @RequestParam(value = "password") String password
    ) {
        return userService.login(userName, password, request.getSession());
    }

    @ApiImplicitParams({
            //@ApiImplicitParam(name = "friendUid", value = "朋友ID(获取朋友主页时传)", dataType = "Integer", paramType = "query")
    })
    @GetMapping(value={"/logout"})
    public ResponseBean<Void> logout(
            @RequestParam(value = "token") String token,
            @Context HttpServletRequest request
    ) {
        return userService.logout(token, request.getSession());
    }

    @ApiImplicitParams({
            @ApiImplicitParam(name = "userName", value = "用户名", dataType = "String",required = true, paramType = "query"),
            @ApiImplicitParam(name = "password", value = "密码", dataType = "String",required = true, paramType = "query"),
            @ApiImplicitParam(name = "nickName", value = "昵称", dataType = "String",required = true, paramType = "query"),
            @ApiImplicitParam(name = "description", value = "描述", dataType = "String", required = true, paramType = "query")
    })
    @PostMapping(value={"/addAdminUser"})
    public ResponseBean<User> addAdminUser(
            @Context HttpServletRequest request,
            @RequestParam(value = "userName") String  userName,
            @RequestParam(value = "password") String password,
            @RequestParam(value = "nickName") String nickName,
            @RequestParam(value = "description") String description
    ) {
        return userService.addAdminUser(userName, password, nickName,description);
    }


    @ApiImplicitParams({
            @ApiImplicitParam(name = "userId", value = "用户 ID", dataType = "int",required = true, paramType = "query")
    })
    @GetMapping(value={"/delAdminUser"})
    public ResponseBean<Void> delAdminUser(
            @RequestParam(value = "userId") Integer  userId
    ) {
//        String token = request.getHeader("token");
//        Object attribute = request.getSession().getAttribute(token);
//        Integer userId = Integer.parseInt(attribute.toString())
        return userService.delAdminUser(userId);
    }

    @ApiImplicitParams({
            @ApiImplicitParam(name = "userId", value = "用户 ID", dataType = "int", paramType = "query")
    })
    @GetMapping(value={"/getAdminUser"})
    public ResponseBean<User> getAdminUser(
            @RequestParam(value = "userId") Integer  userId
    ) {
//        String token = request.getHeader("token");
//        Object attribute = request.getSession().getAttribute(token);
//        Integer userId = Integer.parseInt(attribute.toString())
        return userService.getAdminUser(userId);
    }

    @GetMapping(value={"/notLogin"})
    public ResponseBean<Void> notLogin(
            @Context HttpServletRequest request
    ) {
        ResponseBean<Void> booleanResponseBean = new ResponseBean<>();
        booleanResponseBean.setCodeAndMsg("500","用户未登录,请请重新登录");
        return booleanResponseBean;
    }
}
