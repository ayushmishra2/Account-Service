package com.negocio.account.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.negocio.account.config.ResponseBuilder;
import com.negocio.account.dto.AccountDto;
import com.negocio.account.service.AccountService;

@RestController
@RequestMapping("/account")
public class AccountController {

	@Autowired
	private AccountService accountService;

	@PostMapping("/")
	ResponseEntity<?> createAccount(@RequestBody AccountDto accountDto) {
		return ResponseBuilder.created(accountService.createAccount(accountDto));
	}

	@PutMapping("/")
	public ResponseEntity<?> changePassword(@RequestBody AccountDto accountDto) {
		return ResponseBuilder.ok(accountService.changePassword(accountDto));
	}

	@GetMapping("/")
	public ResponseEntity<?> getAccount(@RequestParam("username") String username) {
		return ResponseBuilder.ok(accountService.getAccountDetails(username));
	}

	@DeleteMapping("/")
	public ResponseEntity<?> deleteAccount(@RequestParam("username") String username) {
		return ResponseBuilder.ok(accountService.deleteAccount(username));
	}
}
