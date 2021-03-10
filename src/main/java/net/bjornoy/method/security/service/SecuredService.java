package net.bjornoy.method.security.service;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Service;

@Service
@PreAuthorize("hasAuthority('ROLE_USER')")
public class SecuredService {

    public String secureMethod() {
        return "You passed!";
    }
}
