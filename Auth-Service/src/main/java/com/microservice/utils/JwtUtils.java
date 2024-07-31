package com.microservice.utils;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

import java.util.Map;
import java.util.function.Function;
import java.util.Date;
import java.util.HashMap;

@Component
public class JwtUtils {

	public String generateToken(String userName) {
		Map<String, Object> claims = new HashMap<>();
		return createToken(claims, userName);
	}

	private String createToken(Map<String, Object> claims, String userName) {
		//Jwts:Using this factory class can be a good alternative to tightly coupling your code.
		//builder: used to create JWT compact serialized strings.
		//setClaims():Sets the JWT payload to be a JSON Claims instance populated by the specified name/value pairs.
		//setSubject(): set the Claims subject field with the specified value.
		//setIssuedAt(iat):issued date and time
		//compact:A compact URL-safe JWT string.
		return Jwts.builder().setClaims(claims).setSubject(userName).setIssuedAt(new Date(System.currentTimeMillis())).setExpiration(new Date(System.currentTimeMillis()+1000*60*30)).signWith(SignatureAlgorithm.HS512, "TFCwfbXerLCVoS2TjN67rw==").compact();
	}
	
//	private Key getSignkey() {
//		byte[] keyBytes = Decoders.BASE64.decode("TFCwfbXerLCVoS2TjN67rw==");
//		return Keys.hmacShaKeyFor(keyBytes);
//	}
	
	public Boolean validateToken(String token, UserDetails userDetails) {
		final String username = getUsernameFromToken(token);
		return (username.equals(userDetails.getUsername()) && !isTokenExpired(token));
	}
	
    private Boolean isTokenExpired(String token) {
        final Date expiration = getExpirationDateFromToken(token);
        return expiration.before(new Date());
    }
    
    public Date getExpirationDateFromToken(String token) {
        return getClaimFromToken(token, Claims::getExpiration);
    }
	 
	public String getUsernameFromToken(String token) {
		return getClaimFromToken(token, Claims::getSubject);
	}
	
    public <T> T getClaimFromToken(String token, Function<Claims, T> claimsResolver) {
        final Claims claims = getAllClaimsFromToken(token);
        return claimsResolver.apply(claims);
    }
    
    private Claims getAllClaimsFromToken(String token) {
        return Jwts.parser().setSigningKey("TFCwfbXerLCVoS2TjN67rw==").parseClaimsJws(token).getBody();
    }

}
