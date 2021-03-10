package net.bjornoy.method.security.configuration.security;

import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import java.util.List;

public class ApplicationUserDetailsService implements UserDetailsService {

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        switch (username) {
            case "1337":
                return createUser(username, Role.ADMINISTRATOR);
            case "7331":
                return createUser(username, Role.USER);
        }

        return createUser(username, Role.ANONYMOUS);
    }

    private User createUser(String username, String role_user) {
        return new User(username, "N/A", List.of(new SimpleGrantedAuthority(role_user)));
    }
}
