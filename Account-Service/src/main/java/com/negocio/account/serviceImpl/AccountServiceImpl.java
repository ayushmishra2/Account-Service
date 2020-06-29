package com.negocio.account.serviceImpl;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.negocio.account.dto.AccountDto;
import com.negocio.account.dto.CreateAccountResponse;
import com.negocio.account.entity.Account;
import com.negocio.account.entity.Role;
import com.negocio.account.repository.AccountRepository;
import com.negocio.account.repository.RoleRepository;
import com.negocio.account.service.AccountService;

@Service
public class AccountServiceImpl implements AccountService {

	@Autowired
	private AccountRepository accountRepository;

	@Autowired
	private RoleRepository roleRepository;

	@Autowired
	PasswordEncoder passwordEncoder;

	@Override
	public CreateAccountResponse createAccount(AccountDto accountDto) {
		Account account = new Account(accountDto.getUsername(), passwordEncoder.encode(accountDto.getPassword()),
				accountDto.getEmail());
		account.setRoles(setAccountRoles(accountDto.getRoles()));
		Account optionalAccount = accountRepository.save(account);
		return new CreateAccountResponse(optionalAccount.getUsername());
	}

	private List<Role> setAccountRoles(List<String> roles) {
		return roles.stream().map(role -> roleRepository.findByName(role).get()).collect(Collectors.toList());
	}

	@Override
	public String changePassword(AccountDto accountDto) {
		Optional<Account> optionalAccount = accountRepository.findByUsername(accountDto.getUsername());
		if (optionalAccount.isPresent()) {
			Account account = optionalAccount.get();
			account.setPassword(passwordEncoder.encode(accountDto.getPassword()));
			accountRepository.save(account);
			return "Password Changed";
		}
		return null;
	}

	@Override
	public CreateAccountResponse getAccountDetails(String username) {
		Optional<Account> account = accountRepository.findByUsername(username);
		account.orElseThrow(() -> new RuntimeException("Username Not Found"));
		CreateAccountResponse createAccountResponse = new CreateAccountResponse();
		BeanUtils.copyProperties(account.get(), createAccountResponse);
		return createAccountResponse;
	}

	@Override
	public String deleteAccount(String username) {
		Optional<Account> account = accountRepository.findByUsername(username);
		account.orElseThrow(() -> new RuntimeException("Username Not Found"));
		accountRepository.delete(account.get());
		return "Account Deleted";
	}

}
