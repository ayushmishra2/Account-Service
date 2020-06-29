package com.negocio.account.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "account")
public class Account extends AbstractBaseEntity {

//	@Id
//	@GeneratedValue(generator = "UUID", strategy = GenerationType.AUTO)
//	private UUID id;

	private static final long serialVersionUID = -3704597675320954011L;

	@Column(name = "username", nullable = false, unique = true)
	private String username;

	@Column(name = "password", nullable = false)
	private String password;

	@Column(name = "email", nullable = false, unique = true)
	private String email;

	@Column(name = "account_non_locked", nullable = false)
	private Boolean isAccountNonLocked;

	@Column(name = "account_non_expired", nullable = false)
	private Boolean isAccountNonExpired;

	@Column(name = "credentials_non_expired", nullable = false)
	private Boolean isCredentialsNonExpired;

	@Column(name = "enabled", nullable = false)
	private Boolean enabled;

	@ManyToMany(cascade = CascadeType.PERSIST, fetch = FetchType.EAGER)
	@JoinTable(name = "account_role", joinColumns = @JoinColumn(name = "user_id", referencedColumnName = "id"), inverseJoinColumns = @JoinColumn(name = "role_id", referencedColumnName = "id"))
	private List<Role> roles;

	public Account(Account user) {
		this.username = user.username;
		this.password = user.password;
		this.email = user.email;
		this.isAccountNonLocked = user.isAccountNonLocked;
		this.isAccountNonExpired = user.isAccountNonExpired;
		this.isCredentialsNonExpired = user.isCredentialsNonExpired;
		this.enabled = user.enabled;
		this.roles = user.roles;
	}

	public Account(String username, String password, String email) {
		this.username = username;
		this.password = password;
		this.email = email;
		this.isAccountNonExpired = true;
		this.isAccountNonLocked = true;
		this.isCredentialsNonExpired = true;
		this.enabled = true;
	}
}
