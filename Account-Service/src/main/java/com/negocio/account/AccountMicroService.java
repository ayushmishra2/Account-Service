package com.negocio.account;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;

@SpringBootApplication
@OpenAPIDefinition(info = @Info(title = "AccountServiceAPI", description = "Service for Registering and Logging into Negocio Application", version = "1.0.0"))
public class AccountMicroService {

//	@Autowired
//	private AccountRepository accountRepository;

//	@Autowired
//	PasswordEncoder passwordEncoder;

//	@PostConstruct
//	void addPermission() {
//
//		permissionRepository.saveAll(Arrays.asList(new Permission("CREATE"), new Permission("READ"),
//				new Permission("UPDATE"), new Permission("DELETE")));
//	}

//	@PostConstruct
//	void addRole() {
//
//		roleRepository.saveAll(Arrays.asList(new Role("ADMIN"), new Role("USER")));
//	}

//	@PostConstruct
//	void addAccount() {
//
//		accountRepository
//				.saveAll(Arrays.asList(new Account("ayushlkw", passwordEncoder.encode("ayush"), "ayushlkw@gmail.com"),
//						new Account("crazyayush", passwordEncoder.encode("ayush"), "crazyayush31@gmail.com")));
//	}

	public static void main(String[] args) {
		SpringApplication.run(AccountMicroService.class, args);
	}

}
