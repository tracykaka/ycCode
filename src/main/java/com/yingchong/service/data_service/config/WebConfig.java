package com.yingchong.service.data_service.config;

import org.springframework.boot.bind.RelaxedPropertyResolver;
import org.springframework.context.EnvironmentAware;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.web.filter.CharacterEncodingFilter;

import javax.servlet.Filter;
import java.util.HashMap;
import java.util.Map;

@Configuration
public class WebConfig implements EnvironmentAware {

		// 解析application.yml
		private RelaxedPropertyResolver propResolver;

		/**
		 * 解决中文内容编码问题，统一用UTF-8编码
		 * 
		 * @return
		 */
		@Bean
		public Filter characterEncodingFilter() {
			CharacterEncodingFilter characterEncodingFilter = new CharacterEncodingFilter();
			characterEncodingFilter.setEncoding("UTF-8");
			characterEncodingFilter.setForceEncoding(true);

			return characterEncodingFilter;
		}

		@Override
		public void setEnvironment(Environment environment) {
			// TODO Auto-generated method stub
			propResolver = new RelaxedPropertyResolver(environment);
		}
		public Map<String,String> staticResource(){
			Map<String,String> commonStaticResource = null;
			try {
				commonStaticResource = new HashMap<String,String>();
				commonStaticResource.put("hostUrl", propResolver.getProperty("business.hostUrl"));//医疗特殊分类“家庭医生” 前台判断业态使用
			} catch (Exception e) {
				e.printStackTrace();
			}
			return commonStaticResource;
		}
}
