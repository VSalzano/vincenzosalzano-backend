package com.gestionedispositivi.repos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.gestionedispositivi.enums.ERole;
import com.gestionedispositivi.models.Role;

import java.util.Optional;

public interface RoleRepository extends JpaRepository<Role, Long> {
    
	Optional<Role> findByRoleName(ERole roleName);

}
