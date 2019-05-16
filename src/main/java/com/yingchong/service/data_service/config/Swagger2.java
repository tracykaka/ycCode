package com.yingchong.service.data_service.config;

import com.google.common.base.Predicates;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * Created by zhoujia on 2019/05/15.
 */

@Configuration
@EnableSwagger2
public class Swagger2 {
    @Bean
    public Docket createRestApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.yingchong.service.data_service")) //指定api接口的package
                .paths(PathSelectors.any())
                .paths(Predicates.not(PathSelectors.regex("/error.*")))// 错误路径不监控
                .build();
    }
    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title("data-service")
                .description("数据操作接口")
                //.termsOfServiceUrl("http://blog.didispace.com/")
                .contact("zhoujia")
                .version("1.0")
                .build();
    }
}
