package com.negocio.account.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.negocio.account.entity.Role;

public interface RoleRepository extends JpaRepository<Role, String> {

	Optional<Role> findByName(String name);
}
