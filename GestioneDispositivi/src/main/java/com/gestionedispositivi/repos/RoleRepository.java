package com.gestionedispositivi.repos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.gestionedispositivi.enums.ERole;
import com.gestionedispositivi.models.UserRole;

import java.util.Optional;

public interface RoleRepository extends JpaRepository<UserRole, Long> {
    
	Optional<UserRole> findByRoleName(ERole roleName);

}
