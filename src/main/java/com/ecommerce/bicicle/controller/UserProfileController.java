package com.ecommerce.bicicle.controller;

import com.ecommerce.bicicle.constants.EndpointNames;
import com.ecommerce.bicicle.dto.JwtRequestDto;
import com.ecommerce.bicicle.dto.JwtResponse;
import com.ecommerce.bicicle.dto.UserDto;
import com.ecommerce.bicicle.service.UserService;
import com.ecommerce.bicicle.service.impl.JwtUserDetailsService;
import com.ecommerce.bicicle.util.JwtTokenUtil;
import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.MalformedJwtException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping(value = EndpointNames.URI)
public class UserProfileController <T> {

    private static final String userProfileUri = EndpointNames.USER_PROFILE_CONTROLLER;

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private JwtTokenUtil jwtTokenUtil;

    @Autowired
    private JwtUserDetailsService userDetailsService;

    @Autowired
    private UserService userService;

    @RequestMapping(value = userProfileUri + "/isValid", method = RequestMethod.POST)
    public ResponseEntity<Boolean> createAuthenticationToken(@RequestBody UserDto userDto) throws Exception {

        try {
            Boolean isValid = jwtTokenUtil.validateToken(userDto.getToken(), userDto.getUserName());
            return ResponseEntity.ok(isValid);
        } catch (MalformedJwtException MF) {
            return ResponseEntity.ok(false);
        } catch (ExpiredJwtException MF) {
            return ResponseEntity.ok(false);
        }
    }

}
