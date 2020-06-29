package com.negocio.account.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.negocio.account.config.ResponseBuilder;
import com.negocio.account.service.AdminService;

@RestController
@RequestMapping("/admin/account")
public class AdminController {

	@Autowired
	private AdminService adminService;

	@GetMapping("/")
	public ResponseEntity<?> getAllAccounts() {
		return ResponseBuilder.ok(adminService.getAccounts());
	}

	@PatchMapping("/block/{username}")
	public ResponseEntity<?> blockAccount(@RequestParam("username") String username) {
		return ResponseBuilder.ok(adminService.blockAccount(username));
	}

	@PatchMapping("/unblock/{username}")
	public ResponseEntity<?> unBlockAccount(@RequestParam("username") String username) {
		return ResponseBuilder.ok(adminService.unBlockAccount(username));
	}

	@PostMapping("/account/block")
	public ResponseEntity<?> blockAccount(@RequestParam List<String> blockAccounts) {
		return ResponseBuilder.ok(adminService.blockUnblockAccount(blockAccounts, false));
	}

	@PostMapping("/account/unblock")
	public ResponseEntity<?> unblockAccount(@RequestParam List<String> unblockAccounts) {
		return ResponseBuilder.ok(adminService.blockUnblockAccount(unblockAccounts, true));
	}

}
