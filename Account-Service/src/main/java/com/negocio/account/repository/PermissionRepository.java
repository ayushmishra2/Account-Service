package com.negocio.account.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.negocio.account.entity.Permission;

public interface PermissionRepository extends JpaRepository<Permission, String> {

}
