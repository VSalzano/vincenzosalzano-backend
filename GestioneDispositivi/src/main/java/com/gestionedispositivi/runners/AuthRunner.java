package com.gestionedispositivi.runners;

import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import com.gestionedispositivi.enums.ERole;
import com.gestionedispositivi.models.UserRole;
import com.gestionedispositivi.repos.RoleRepository;
import com.gestionedispositivi.repos.UserRepository;
import com.gestionedispositivi.services.AuthService;



@Component
public class AuthRunner implements ApplicationRunner {
	
	@Autowired RoleRepository roleRepository;
	@Autowired UserRepository userRepository;
	@Autowired PasswordEncoder passwordEncoder;
	@Autowired AuthService authService;
	
	private Set<UserRole> adminRole;
	private Set<UserRole> moderatorRole;
	private Set<UserRole> userRole;
	
	@Override
	public void run(ApplicationArguments args) throws Exception {
		System.out.println("Run...");
		// Da lanciare solo la prima volta
		//setRoleDefault();
		
	}
	
	private void setRoleDefault() {
		UserRole admin = new UserRole();
		admin.setRoleName(ERole.ROLE_ADMIN);
		roleRepository.save(admin);
		
		UserRole user = new UserRole();
		user.setRoleName(ERole.ROLE_USER);
		roleRepository.save(user);
		
		UserRole moderator = new UserRole();
		moderator.setRoleName(ERole.ROLE_MODERATOR);
		roleRepository.save(moderator);
		
		adminRole = new HashSet<UserRole>();
		adminRole.add(admin);
		adminRole.add(moderator);
		adminRole.add(user);
		
		moderatorRole = new HashSet<UserRole>();
		moderatorRole.add(moderator);
		moderatorRole.add(user);
		
		userRole = new HashSet<UserRole>();
		userRole.add(user);
	}

}
