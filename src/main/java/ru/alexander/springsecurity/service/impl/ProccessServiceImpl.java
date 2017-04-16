package ru.alexander.springsecurity.service.impl;

import org.springframework.stereotype.Service;
import ru.alexander.springsecurity.service.ProccessService;

@Service
public class ProccessServiceImpl implements ProccessService{

    @Override
    public String getMessage() {
        return "my message";
    }
    
}
