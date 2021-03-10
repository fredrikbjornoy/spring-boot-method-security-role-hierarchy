package net.bjornoy.method.security.resource;

import net.bjornoy.method.security.service.SecuredService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping
public class Resource {

    private final SecuredService securedService;

    @Autowired
    public Resource(SecuredService securedService) {
        this.securedService = securedService;
    }

    @GetMapping
    public ResponseEntity<String> get() {
        try {
            return ResponseEntity.ok(securedService.secureMethod());
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.FORBIDDEN).body("You shall not pass!");
        }
    }
}
