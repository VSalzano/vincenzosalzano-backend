package com.gestionedispositivi.models;

import java.util.HashSet;
import java.util.List;
import java.util.Set;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
@Table(name="users")
public class User {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long id;
	
	@Column(unique=true, nullable=false)
	private String email;
	
    @Column(nullable = false, unique = true)
    private String username;
	
    @Column(nullable = false)
	private String nome;
	
    @Column(nullable = false)
	private String cognome;
	
    @Column(nullable = false)
    private String password;
	
	@ManyToMany
	@JoinTable(
	        name = "user_dispositivo",
	        joinColumns = @JoinColumn(name = "user_id"),
	        inverseJoinColumns = @JoinColumn(name = "dispositivo_id")
	    )
	private List<Dispositivo> dispositivo;
	
    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.MERGE)
    @JoinTable(name = "users_roles",
            joinColumns = @JoinColumn(name = "user_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "role_id", referencedColumnName = "id")
    )
	private Set<UserRole> roles = new HashSet<>();

}
