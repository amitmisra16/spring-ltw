/**
 * 
 */
package com.ishisystems.spring.app;

/**
 * @author amit.misra
 *
 */
public class AppServiceImpl {

	public String sayHello(final String aUserName) {
		return String.format("Hello %s", aUserName);
	}
}
