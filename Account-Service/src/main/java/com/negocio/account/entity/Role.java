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
@AllArgsConstructor
@ToString
@NoArgsConstructor
@Entity
@Table(name = "role")
public class Role extends AbstractBaseEntity {

//	@Id
//	@GeneratedValue(generator = "UUID", strategy = GenerationType.AUTO)
//	private UUID id;
	private static final long serialVersionUID = 134644897423754386L;

	@Column(name = "role_name", nullable = false, unique = true)
	private String name;

//	@ManyToMany(mappedBy = "role")
//	private List<Account> users;

	@ManyToMany(cascade = CascadeType.PERSIST, fetch = FetchType.EAGER)
	@JoinTable(name = "role_permission", joinColumns = @JoinColumn(name = "role_id", referencedColumnName = "id"), inverseJoinColumns = @JoinColumn(name = "permission_id", referencedColumnName = "id"))
	private List<Permission> permissions;

	public Role(String name) {
		this.name = name;
	}

}
