package com.yingchong.service.data_service.utils;

import com.yingchong.service.data_service.service.filter.LoginFilter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.http.HttpSession;
import java.util.Objects;

public enum LoginUtil {
	LOGINBEAN;
	
	private static final Logger logger = LoggerFactory.getLogger(LoginUtil.class);
	
	private ThreadLocal<HttpSession> localSession;
	
	private LoginUtil(){
		this.localSession = new ThreadLocal<>();
	}
	
	public String getUserId(){
		HttpSession session = this.localSession.get();
		if (session != null && session.getAttribute(LoginFilter.USERID) != null){
			logger.info("userId:【{}】", session.getAttribute(LoginFilter.USERID));
			return Objects.toString(session.getAttribute(LoginFilter.USERID));
		}
		logger.info("没有userID");
		throw new RuntimeException("没有userID");
//		return "userId";
	}

	public String getPhone() {
		HttpSession session = this.localSession.get();
		if (session != null && session.getAttribute(LoginFilter.phone) != null){
			logger.info("phone:【{}】", session.getAttribute(LoginFilter.phone));
			return Objects.toString(session.getAttribute(LoginFilter.phone));
		}
		logger.info("没有phone");
		throw new RuntimeException("没有phone");
	}
	
	public void setSession(HttpSession session){
		this.localSession.set(session);
	}
	
	public void remove(){
		this.localSession.remove();
	}
}
