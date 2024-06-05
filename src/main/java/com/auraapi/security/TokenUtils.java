package com.auraapi.security;

import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;

public class TokenUtils {
	
	private final static String ACCESS_TOKEN_SECRET = "4fb8fa83f8a81acb7d1c9004f171e7a1c790fc800afb4816a9c4f2f0b84b520c";
	private final static Long ACCESS_TOKEN_VALIDITY_SECONDS = 2_592_000l;
	
	
	public static String createToken (UserDetailsSupplierImpl user) {
		Long expirationTime = System.currentTimeMillis() + (ACCESS_TOKEN_VALIDITY_SECONDS * 1_000);
		Date expirationDate = new Date(expirationTime);
		List<String> roles = user.getAuthorities().stream()
                .map(authority -> authority.getAuthority())
                .collect(Collectors.toList());
		
		Map<String, Object> data = new HashMap<String, Object>(); 
		data.put("id", user.getId());
	    data.put("name", user.getUser().getName_enterprise_user());
	    data.put("lastname", user.getUser().getLastname_enterprise_user());
	    data.put("email", user.getUser().getEmail_enterprise_user());
	    data.put("roles", roles);
	    data.put("state", user.getUser().isState_enterprise_user());
		
		return Jwts.builder()
				.setSubject(user.getUsername())
				.setExpiration(expirationDate)
				.addClaims(data)
				.signWith(Keys.hmacShaKeyFor(ACCESS_TOKEN_SECRET.getBytes()))
				.compact();
	}
	
	public static UsernamePasswordAuthenticationToken authentication(String token) {
		
		try {
			
			Claims claims = Jwts.parserBuilder()
					.setSigningKey(ACCESS_TOKEN_SECRET.getBytes())
					.build()
					.parseClaimsJws(token).getBody();
			
			String username = claims.getSubject();
			
			List<String> roles = claims.get("roles", List.class);

			List<GrantedAuthority> authorities = roles.stream()
			        .map(SimpleGrantedAuthority::new)
			        .collect(Collectors.toList());
			
			return new UsernamePasswordAuthenticationToken(username, null, authorities);
			
		} catch (Exception e) { return null; }
		
	}
	
	
}
