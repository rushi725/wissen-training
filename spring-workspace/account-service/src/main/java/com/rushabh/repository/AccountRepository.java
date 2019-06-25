package com.rushabh.repository;

import com.rushabh.model.Account;

public interface AccountRepository {

	Account load(String accNum);

	Account update(Account account);

}