package com.negocio.account.service;

import com.negocio.account.dto.AccountDto;
import com.negocio.account.dto.CreateAccountResponse;

public interface AccountService {

	CreateAccountResponse createAccount(AccountDto accountDto);

	String changePassword(AccountDto accountDto);

	CreateAccountResponse getAccountDetails(String username);

	String deleteAccount(String username);
}
