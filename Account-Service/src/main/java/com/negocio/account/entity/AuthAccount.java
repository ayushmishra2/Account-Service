package com.negocio.account.entity;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import lombok.Getter;

@Getter
public class AuthAccount extends Account implements UserDetails {

	private static final long serialVersionUID = 5105007053611735725L;

	public AuthAccount(Account user) {
		super(user);
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {

		List<GrantedAuthority> list = new ArrayList<>();
		super.getRoles().forEach(role -> {
			list.add(new SimpleGrantedAuthority(role.getName()));
			role.getPermissions().forEach(permission -> {
				list.add(new SimpleGrantedAuthority(permission.getName()));
			});
		});

		return list;
	}

	@Override
	public String getPassword() {
		return super.getPassword();
	}

	@Override
	public String getUsername() {
		return super.getUsername();
	}

	@Override
	public boolean isAccountNonExpired() {
		return super.getIsAccountNonExpired();
	}

	@Override
	public boolean isAccountNonLocked() {
		return super.getIsAccountNonLocked();
	}

	@Override
	public boolean isCredentialsNonExpired() {
		return super.getIsCredentialsNonExpired();
	}

	@Override
	public boolean isEnabled() {
		return super.getEnabled();
	}

}
