package com.auraapi.security;

import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.auraapi.modelsdb1.entity.users.EnterpriseUserVO;



public class UserDetailsSupplierImpl implements UserDetails{

	private static final long serialVersionUID = 1L;
	private EnterpriseUserVO user;
    private Collection<? extends GrantedAuthority> authorities;

    public UserDetailsSupplierImpl(EnterpriseUserVO user, Collection<? extends GrantedAuthority> authorities) {
        this.user = user;
        this.authorities = authorities;
    }

    // implementa todos los métodos de la interfaz UserDetails
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return authorities;
    }

    @Override
    public String getPassword() {
        return user.getPassword_enterprise_user();
    }

    @Override
    public String getUsername() {
        return user.getUsername_enterprise_user();
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
        return user.isState_enterprise_user();
    }

    // métodos adicionales para acceder a otros atributos de entidad de usuario enterprise
    public Long getId() {
        return user.getId_enterprise_user();
    }

    public EnterpriseUserVO getUser() {
        return user;
    }
}
