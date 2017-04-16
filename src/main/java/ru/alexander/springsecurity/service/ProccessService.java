package ru.alexander.springsecurity.service;

import org.springframework.security.access.annotation.Secured;

public interface ProccessService {
    
    @Secured("ROLE_ADMIN")
    String getMessage();
    
}
