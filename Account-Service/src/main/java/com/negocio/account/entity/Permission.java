package com.negocio.account.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
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
@Table(name = "permission")
public class Permission extends AbstractBaseEntity {

//	@Id
//	@GeneratedValue(generator = "UUID", strategy = GenerationType.AUTO)
//	private UUID id;
	private static final long serialVersionUID = 2640473596184337928L;
	@Column(name = "permission_name", nullable = false, unique = true)
	private String name;

//	@ManyToMany(mappedBy = "permission")
//	private List<Role> roles;
}
