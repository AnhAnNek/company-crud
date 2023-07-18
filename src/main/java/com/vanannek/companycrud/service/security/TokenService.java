package com.vanannek.companycrud.service.security;


import org.springframework.security.core.Authentication;

public interface TokenService {
    String generateToken(Authentication auth);
}
