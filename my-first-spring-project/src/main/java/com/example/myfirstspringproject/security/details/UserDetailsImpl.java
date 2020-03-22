package com.example.myfirstspringproject.security.details;

import com.example.myfirstspringproject.models.Role;
import com.example.myfirstspringproject.models.State;
import com.example.myfirstspringproject.models.User;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.Collections;
import java.util.function.IntUnaryOperator;

public class UserDetailsImpl implements UserDetails {
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        String authority = user.getRole().toString();
        SimpleGrantedAuthority simpleGrantedAuthority = new SimpleGrantedAuthority(authority);
        return Collections.singleton(simpleGrantedAuthority);

    }

    User user;

    public User getUser () {
        return user;
    }

    public UserDetailsImpl(User user) {
        this.user = user;
    }

    @Override
    public String getPassword() {
        return user.getHashPassword();
    }

    @Override
    public String getUsername() {
        return user.getEmail();
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return user.getState().equals(State.CONFIRMED);
    }
}
