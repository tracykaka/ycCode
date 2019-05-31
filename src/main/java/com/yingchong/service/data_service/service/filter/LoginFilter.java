package com.yingchong.service.data_service.service.filter;


import com.yingchong.service.data_service.utils.LoginUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;


@Component
//@WebFilter(urlPatterns="/*", filterName="loginFilter")
public class LoginFilter implements Filter {

    private static final Logger logger = LoggerFactory.getLogger(LoginFilter.class);

    //public static final String LOGINSOURCE = "loginSource";
    public static final String USERID = "userId";
    public static final String phone = "phone";
    //@Value("${spring.profiles.active}")
    //private String env;

    //private final RedisUtils redisUtils;

//    @Autowired
//    public LoginFilter(RedisUtils redisUtils) {
//        this.redisUtils = redisUtils;
//    }

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        //env = filterConfig.getInitParameter("env");
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException {
        try {

            /*if(request!=null){
                chain.doFilter(request, response);
                return;
            }*/

            HttpSession session = ((HttpServletRequest)request).getSession();
            String requestURI = ((HttpServletRequest)request).getRequestURI();
            String queryString = ((HttpServletRequest)request).getQueryString();
            String url = ((HttpServletRequest)request).getRequestURL().toString();
            Object token = ((HttpServletRequest) request).getHeader("token");
            logger.info("url=【{}】,token=【{}】,requestURI={},queryString={}", url,token,requestURI,queryString);

            LoginUtil.LOGINBEAN.setSession(session);
            //logger.info("sessionId【{}】", session.getId());
            if (requestURI.contains("/user/addAdminUser") //注册
                    || requestURI.contains("swagger")
                    || requestURI.contains("api-docs")
                    //|| requestURI.contains("/v1") //swagger请求地址
                    || requestURI.contains("/health")//swagger
                    || requestURI.contains("/notice")//swagger
					//|| requestURI.contains("/")//swagger
                    || requestURI.matches("^.*\\.(js|css|html|map|png|jpg|ico)")//静态资源
                    || requestURI.contains("/enterprise/isEnterpriseEmailUsed")
                    || requestURI.contains("/user/login")//
                    || requestURI.contains("/user/notLogin")
                    || requestURI.contains("/validate/code") //验证码
                    //|| requestURI.contains("/data/calculDate")//微信绑定验证
                    ) {//登录页不能拦截
                chain.doFilter(request, response);
                return;
            }
            if (token == null){
                logger.info("未登录--" + requestURI);
                ((HttpServletResponse)response).sendRedirect("/user/notLogin");
                return;
            }
            //logger.info("token={},redisUtils={},env={}",token,redisUtils,env);
            String s = String.valueOf(session.getAttribute(token.toString()));
            if(s!=null && !s.isEmpty() && !"null".equals(s)){
                chain.doFilter(request, response);
            }else {
                logger.info("未登录--" + requestURI);
                ((HttpServletResponse)response).sendRedirect("/user/notLogin");
            }
        } finally{
            LoginUtil.LOGINBEAN.remove();
        }
    }

    @Override
    public void destroy() {

    }

}