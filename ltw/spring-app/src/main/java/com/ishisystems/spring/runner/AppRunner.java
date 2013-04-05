/**
 * 
 */
package com.ishisystems.spring.runner;

import org.apache.log4j.Logger;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.ishisystems.spring.app.AppServiceImpl;

/**
 * @author amit.misra
 *
 */
public class AppRunner {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		final Logger LOGGER = Logger.getLogger(AppRunner.class);
		final ClassPathXmlApplicationContext appContext = new ClassPathXmlApplicationContext("classpath:applicationContext.xml");
		final AppServiceImpl service = (AppServiceImpl) appContext.getBean(AppServiceImpl.class);
		LOGGER.info(service.sayHello("Spring Load Time Weaving"));
	}

}
