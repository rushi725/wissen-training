package com.rushabh.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;

import javax.sql.DataSource;

import org.apache.log4j.Logger;
import org.aspectj.weaver.Iterators.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.rushabh.model.Account;
import com.rushabh.model.Transaction;

import oracle.sql.TIMESTAMP;
@Repository("jdbcAccountRepository")
public class JdbcAccountRepository implements AccountRepository {

	private static final Logger LOGGER = Logger.getLogger("App");

	private DataSource dataSource;
	private JdbcTemplate jdbcTemplate;
	public JdbcAccountRepository(DataSource dataSource) {
		this.jdbcTemplate = new JdbcTemplate(dataSource); 
		LOGGER.info("JdbcAccountRepository created with datasource");
	}

	@Override
	public Account load(String accNum) {
		LOGGER.info("loading account : " + accNum);
		String sql = "select * from ACCOUNTS where num=?";
		Account account = new Account();
		jdbcTemplate.queryForObject(sql, (rs, rowNum) -> {
			account.setNumber(rs.getString("num"));
			account.setBalance(rs.getDouble("balance"));
			return account;
		}, accNum);
		return account;
	}

	@Override
	public Account update(Account account) {
		//
		LOGGER.info("updating account : " + account.getNumber());

		String sql = "update ACCOUNTS set balance=? where num=?";
		int rowCount = jdbcTemplate.update(sql, account.getBalance(), account.getNumber());
		return account;

	}

	@Override
	public void addTransaction(Transaction transaction) {
		LOGGER.info("adding transaction: " + transaction.getId());
		
		String sql = "insert into Transactions(id,amount,closingBalance,type,accountNumber) values(tseq.nextval,?,?,?,?)";
		 Object[] params = new Object[] {
	                transaction.getAmount(),
	                transaction.getClosingBalance(),
	                transaction.getType().name(),
	                //Timestamp.valueOf(transaction.getDateTime().toString()),
	                transaction.getAccount().getNumber()
	        };
		int rowCount = jdbcTemplate.update(sql,params);
		LOGGER.info("added transactions: " + rowCount);
		
	}
	
	

}