package com.gestionedispositivi.services;

import com.gestionedispositivi.payload.LoginDto;
import com.gestionedispositivi.payload.RegisterDto;

public interface AuthService {
    
	String login(LoginDto loginDto);
    String register(RegisterDto registerDto);
    
}
