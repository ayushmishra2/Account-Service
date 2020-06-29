package com.negocio.account.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.negocio.account.entity.Account;

@Repository
public interface AccountRepository extends JpaRepository<Account, String> {

	Optional<Account> findByUsername(String username);
}
