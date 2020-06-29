package com.negocio.account.serviceImpl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import javax.transaction.Transactional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.negocio.account.dto.AdminDto;
import com.negocio.account.entity.Account;
import com.negocio.account.repository.AccountRepository;
import com.negocio.account.service.AdminService;

@Service
public class AdminServiceImpl implements AdminService {

	@Autowired
	private AccountRepository accountRepository;

	@Override
	public List<AdminDto> getAccounts() {
		List<Account> accounts = accountRepository.findAll();
		// System.out.print(accounts.get(0));
		List<AdminDto> adminResponses = new ArrayList<>();
		for (Account account : accounts) {
			AdminDto adminResponse = new AdminDto();
			BeanUtils.copyProperties(account, adminResponse);
			adminResponses.add(adminResponse);
		}
		return adminResponses;
	}

	@Override
	public String blockAccount(String username) {
		Optional<Account> account = accountRepository.findByUsername(username);
		account.orElseThrow(() -> new RuntimeException("Account Not Found"));
		if (account.get().getIsAccountNonLocked()) {
			account.get().setIsAccountNonLocked(false);
			accountRepository.save(account.get());
			return "Account Blocked";
		}
		return "Account already blocked";
	}

	@Override
	public String unBlockAccount(String username) {
		Optional<Account> account = accountRepository.findByUsername(username);
		account.orElseThrow(() -> new RuntimeException("Account Not Found"));
		if (!account.get().getIsAccountNonLocked()) {
			account.get().setIsAccountNonLocked(true);
			accountRepository.save(account.get());
			return "Account Unblocked";
		}
		return "Account already unblocked";
	}

	@Override
	@Transactional
	public String blockUnblockAccount(List<String> accountList, Boolean blockAccount) {
		List<Account> accounts = accountList.stream().map(username -> accountRepository.findByUsername(username).get())
				.collect(Collectors.toList());
		for (Account account : accounts) {
			account.setIsAccountNonLocked(blockAccount);
		}
		accountRepository.saveAll(accounts);
		return blockAccount ? "Accounts Unblocked" : "Accounts Blocked";
	}

}
