package com.negocio.account.entity;

import java.io.Serializable;
import java.util.UUID;

import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

import lombok.Data;

@MappedSuperclass
@Data
public abstract class AbstractBaseEntity implements Serializable {

	private static final long serialVersionUID = 914412715338388247L;

	@Id
	private String id;

	public AbstractBaseEntity() {
		this.id = UUID.randomUUID().toString();
	}

	@Override
	public int hashCode() {
		return id.hashCode();
	}

	@Override
	public boolean equals(Object obj) {

		if (obj == null) {
			return false;
		}
		if (this == obj) {
			return true;
		}
		if (!(this.getClass().getName().equals(obj.getClass().getName()))) {
			return false;
		}
		AbstractBaseEntity baseEntity = (AbstractBaseEntity) obj;
		return this.id.equals(baseEntity.getId());
	}
}
