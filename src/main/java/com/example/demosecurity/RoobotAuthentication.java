package com.example.demosecurity;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;

import java.util.Collection;

/**
 * @author Ayoub ANBARA
 */
public class RoobotAuthentication implements Authentication {
    @Override
    public String getName() {
        return "Ms Robot";
    }

    @Override
    public Object getPrincipal() {
        return getName();
    }

    @Override
    public boolean isAuthenticated() {
        return true;
    }

    @Override
    public void setAuthenticated(boolean isAuthenticated) throws IllegalArgumentException {
        throw new IllegalArgumentException("Don't");
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return AuthorityUtils.createAuthorityList("ROLE_ROBOT");
    }

    @Override
    public Object getDetails() {
        return null;
    }

    @Override
    public Object getCredentials() {
        return null;
    }
}
