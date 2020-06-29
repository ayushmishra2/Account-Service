package com.negocio.account.service;

import java.util.List;

import com.negocio.account.dto.AdminDto;

public interface AdminService {

	List<AdminDto> getAccounts();

	String blockAccount(String username);

	String unBlockAccount(String username);

	String blockUnblockAccount(List<String> adminBlockUnblockDtos, Boolean blockAccount);

}
