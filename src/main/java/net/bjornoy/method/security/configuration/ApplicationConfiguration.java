package net.bjornoy.method.security.configuration;

import net.bjornoy.method.security.configuration.security.Role;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.access.hierarchicalroles.RoleHierarchy;
import org.springframework.security.access.hierarchicalroles.RoleHierarchyImpl;

import java.util.stream.Collectors;
import java.util.stream.Stream;

@Configuration
public class ApplicationConfiguration {

    @Bean
    public RoleHierarchy roleHierarchy() {
        RoleHierarchyImpl roleHierarchy = new RoleHierarchyImpl();
        roleHierarchy.setHierarchy(createHierarchy());
        return roleHierarchy;
    }

    private String createHierarchy() {
        return Stream.of(Role.USER, Role.ANONYMOUS)
                .map(role -> Role.ADMINISTRATOR + " > " + role + "\n")
                .collect(Collectors.joining());
    }

}
