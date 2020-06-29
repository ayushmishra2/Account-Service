package com.negocio.account.dto;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.negocio.account.entity.Role;

import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(Include.NON_NULL)
public class AdminDto {

	private String id;
	private String username;
	private String email;
	private List<Role> roles;
	private Boolean isAccountNonLocked;
	private Boolean isAccountNonExpired;
	private Boolean isCredentialsNonExpired;
	private Boolean enabled;

}
