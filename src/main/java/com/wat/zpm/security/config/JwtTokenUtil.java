package com.wat.zpm.security.config;

import com.wat.model.Role;
import com.wat.model.User;
import com.wat.zpm.service.UserService;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import java.io.Serializable;
import java.util.Collection;
import java.util.Collections;
import java.util.Date;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import static com.wat.zpm.security.Constants.ACCESS_TOKEN_VALIDITY_SECONDS;
import static com.wat.zpm.security.Constants.SIGNING_KEY;

@Component
public class JwtTokenUtil implements Serializable {

    private final UserService userService;

    public JwtTokenUtil(UserService userService) {
        this.userService = userService;
    }

    public String getUsernameFromToken(String token) {
        final Claims claims = getAllClaimsFromToken(token);
        return claims.getSubject();
        //return getClaimFromToken(token, Claims::getSubject);
    }

    public Date getExpirationDateFromToken(String token) {
        final Claims claims = getAllClaimsFromToken(token);
        return claims.getExpiration();
        //return getClaimFromToken(token, Claims::getExpiration);
    }

    /*public T getClaimFromToken(String token, Function<R, T> claimsResolver) {
        final Claims claims = getAllClaimsFromToken(token);
        return claimsResolver.apply((R) claims);
    }*/

    private Claims getAllClaimsFromToken(String token) {
        return Jwts.parser()
                .setSigningKey(SIGNING_KEY)
                .parseClaimsJws(token)
                .getBody();
    }

    private Boolean isTokenExpired(String token) {
        final Date expiration = getExpirationDateFromToken(token);
        return expiration.before(new Date());
    }

    public String generateToken(User user) {
        return doGenerateToken(user.getUsername());
    }

    private String doGenerateToken(String subject) {

        Claims claims = Jwts.claims().setSubject(subject);
        claims.put("scope", userService.findByUsername(subject).getRoles()
        .stream()
        .map(Role::getAuthorities)
        .flatMap(Collection::stream)
        .collect(Collectors.toList()));

        return Jwts.builder()
                .setClaims(claims)
                .setIssuer("http://localhost:4200")
                .setIssuedAt(new Date(System.currentTimeMillis()))
                .setExpiration(new Date(System.currentTimeMillis() + ACCESS_TOKEN_VALIDITY_SECONDS * 1000))
                .signWith(SignatureAlgorithm.HS256, SIGNING_KEY)
                .compact();
    }

    public Boolean validateToken(String token, UserDetails userDetails) {
        final String username = getUsernameFromToken(token);

        return (username.equals(userDetails.getUsername())
                && !isTokenExpired(token));
    }
}

