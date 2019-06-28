//package com.rushabh;
//
//import org.apache.log4j.Logger;
//import org.springframework.context.ConfigurableApplicationContext;
//import org.springframework.context.annotation.AnnotationConfigApplicationContext;
//import org.springframework.context.support.ClassPathXmlApplicationContext;
//
//import com.rushabh.config.AccountServiceConfiguration;
//import com.rushabh.repository.AccountRepository;
//import com.rushabh.repository.JdbcAccountRepository;
//import com.rushabh.repository.JpaAccountRepository;
//import com.rushabh.service.NEFTTxrService;
//import com.rushabh.service.TxrService;
//
//public class App {
//
//	private static final Logger LOGGER = Logger.getLogger("App");
//
//	public static void main(String[] args) {
//
//		// -------------------------------------
//		// init / boot
//		// -------------------------------------
////		ConfigurableApplicationContext context = null;
////		context = new ClassPathXmlApplicationContext("account-service.xml");
//		
//		ConfigurableApplicationContext context = null;
//		context = new AnnotationConfigApplicationContext(AccountServiceConfiguration.class);
//
//		LOGGER.info("app init/booted..");
//		System.out.println();
//		// -------------------------------------
//		// use
//		// -------------------------------------
//		LOGGER.info("app in use");
//		TxrService txrService = context.getBean("txrService", TxrService.class);
//		LOGGER.info(txrService.getClass());
//		txrService.transfer(5500.00, "2", "1");
//		System.out.println();
//
//		System.out.println();
//		// -------------------------------------
//		// destroy
//		// -------------------------------------
//		LOGGER.info("app destroyed");
//		context.close();
//		// -------------------------------------
//	}
//
//}