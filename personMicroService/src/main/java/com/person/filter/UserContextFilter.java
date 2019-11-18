/**
 * 
 */
package com.person.filter;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.Enumeration;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
/**
 * @author chandresh.mishra
 *
 */
@Component
@Order(1)
public class UserContextFilter  implements Filter {
    private static final Logger logger = LoggerFactory.getLogger(UserContextFilter.class);

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		logger.info("UserContextFilter init");
		
	}

	@Override
	public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain)
			throws IOException, ServletException {
		logger.info("UserContextFilter filtering request");
		 	HttpServletRequest httpServletRequest = (HttpServletRequest) servletRequest;
		 	
		 	Enumeration<String> headerNames = httpServletRequest.getHeaderNames();

		    if (headerNames != null) {
		        while (headerNames.hasMoreElements()) {
		            String name = headerNames.nextElement();
		            logger.info("Header: " + name + " value:" + httpServletRequest.getHeader(name));
		        }
		    }
		 	
		 //	UserContextHolder.getContext().setCorrelationId(  httpServletRequest.getHeader(UserContext.CORRELATION_ID) );
	       // UserContextHolder.getContext().setUserId(httpServletRequest.getHeader(UserContext.USER_ID));
	        UserContextHolder.getContext().setAuthToken(httpServletRequest.getHeader(UserContext.AUTH_TOKEN));
	      // UserContextHolder.getContext().setOrgId(httpServletRequest.getHeader(UserContext.ORG_ID));

	        logger.info("UserContextFilter AUTH_TOKEN {}", httpServletRequest.getHeader(UserContext.AUTH_TOKEN));

	        filterChain.doFilter(httpServletRequest, servletResponse);
		
	}

	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		
	}

}
