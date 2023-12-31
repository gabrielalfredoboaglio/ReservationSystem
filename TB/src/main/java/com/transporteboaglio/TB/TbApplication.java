package com.transporteboaglio.TB;

import com.transporteboaglio.TB.entity.RoleEntity;
import com.transporteboaglio.TB.entity.UserEntity;
import com.transporteboaglio.TB.enumeration.ERole;
import com.transporteboaglio.TB.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.Set;


@SpringBootApplication
public class TbApplication {

	public static void main(String[] args) {
		SpringApplication.run(TbApplication.class, args);
	}


	@Autowired
	PasswordEncoder passwordEncoder;
    @Autowired
	UserRepository userRepository;
	@Bean
	public CommandLineRunner init() {
		return args -> {
			// Crea un usuario con el rol "ROLE_ADMIN"
			UserEntity userEntity = UserEntity.builder()
					.email("mail@mail.com")
					.username("mail")
					.password(passwordEncoder.encode("123456"))
					.roles(Set.of(RoleEntity.builder().name(ERole.ADMIN).build()))
					.build();

			UserEntity userEntity2 = UserEntity.builder()
					.email("gabi@mail.com")
					.username("gabi")
					.password(passwordEncoder.encode("123456"))
					.roles(Set.of(RoleEntity.builder().name(ERole.USER).build()))
					.build();


			userRepository.save(userEntity);
			userRepository.save(userEntity2);

		};
	}
}
