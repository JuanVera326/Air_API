package com.auraapi.security;

import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.auraapi.modelsdb1.entity.users.EnterpriseUserVO;
import com.auraapi.modelsdb1.repository.IUserSupplierRepository;

@Service
public class CustomUserDetailsService implements UserDetailsService {

    @Autowired
    private IUserSupplierRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        EnterpriseUserVO user = userRepository.findByUsername_enterprise_user(username)
                .orElseThrow(() -> new UsernameNotFoundException("User not found"));
        
        Set<GrantedAuthority> authorities = user.getRol_enterprise_user().stream()
                .map(role -> new SimpleGrantedAuthority(role.getName()))
                .collect(Collectors.toSet());

        return new UserDetailsSupplierImpl(user, authorities);
    }
}