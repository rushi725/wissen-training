package com.rushabh.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.context.annotation.Import;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.rushabh.repository.AccountRepository;
//import com.rushabh.service.NEFTTxrService;
//import com.rushabh.service.TxrService;

@EnableTransactionManagement
@EnableAspectJAutoProxy
@Configuration
@Import(value= {TransactionManagerConfiguration.class,DataSourceConfiguration.class})
@ComponentScan(basePackages = {"com.rushabh.service","com.rushabh.repository","com.rushabh.aspects","com.rushabh.model"})

public class AccountServiceConfiguration {
//	@Autowired
//	@Qualifier("jdbc")
//	private AccountRepository accountRepository;

//	@Bean("txrService")
//	public TxrService txrService() {
//		NEFTTxrService txrService = new NEFTTxrService();
//		txrService.setTxrType("IMPS");
//		txrService.setAccountRepository(accountRepository);
//		return txrService;
//	}
//	

}
