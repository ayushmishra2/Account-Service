package com.negocio.account.serviceImpl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AccountStatusUserDetailsChecker;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.negocio.account.entity.Account;
import com.negocio.account.entity.AuthAccount;
import com.negocio.account.repository.AccountRepository;

@Service
public class AccountDetailsServiceImpl implements UserDetailsService {

	@Autowired
	private AccountRepository userRepository;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

		Optional<Account> optionalUserDetails = userRepository.findByUsername(username);
		optionalUserDetails.orElseThrow(() -> new RuntimeException("User Not Found"));

		UserDetails userDetails = new AuthAccount(optionalUserDetails.get());
		new AccountStatusUserDetailsChecker().check(userDetails);

		return userDetails;
	}

}
