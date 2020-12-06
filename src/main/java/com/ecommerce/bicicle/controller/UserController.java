package com.ecommerce.bicicle.controller;

import com.ecommerce.bicicle.constants.EndpointNames;
import com.ecommerce.bicicle.dto.JwtRequestDto;
import com.ecommerce.bicicle.dto.JwtResponse;
import com.ecommerce.bicicle.dto.UserDto;
import com.ecommerce.bicicle.service.UserService;
import com.ecommerce.bicicle.service.impl.JwtUserDetailsService;
import com.ecommerce.bicicle.util.JwtTokenUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@CrossOrigin
@RestController
@RequestMapping(value = EndpointNames.URI)
public class UserController {

    private static final String userUri = EndpointNames.USER_CONTROLLER;

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private JwtTokenUtil jwtTokenUtil;

    @Autowired
    private JwtUserDetailsService userDetailsService;

    @Autowired
    private UserService userService;

    @RequestMapping(value = userUri, method = {RequestMethod.GET})
    public @ResponseBody
    List<UserDto> get() {

        List<UserDto> itemEntities = userService.get();

        return itemEntities;
    }

    @RequestMapping(value = userUri+"/{username}", method = {RequestMethod.GET})
    public @ResponseBody
    UserDto getByUsername(@PathVariable("username") String userName) {

        UserDto itemEntities = userService.getByUsername(userName);

        return itemEntities;
    }

    @RequestMapping(value = userUri + "/authenticate", method = RequestMethod.POST)
    public ResponseEntity<?> createAuthenticationToken(@RequestBody JwtRequestDto authenticationRequest) throws Exception {

        UserDto userInDB = userService.getByUsernameAndPassword(authenticationRequest.getUsername(), authenticationRequest.getPassword());
        UserDetails userDetails;

        if (userInDB != null) {
            userDetails = new User(userInDB.getUserName(), userInDB.getPassword(), new ArrayList<>());
        } else {
            throw new UsernameNotFoundException("User not found with username: " + authenticationRequest.getUsername());
        }

        final String token = jwtTokenUtil.generateToken(userDetails);
        userInDB.setToken(token);

        return ResponseEntity.ok(userInDB);
    }

    @RequestMapping(value = userUri, method = {RequestMethod.PUT})
    public @ResponseBody
    UserDto put(@RequestBody UserDto userDto) {

        UserDto savedItemUser = userService.save(userDto);

        return savedItemUser;
    }

    @RequestMapping(value = userUri, method = {RequestMethod.DELETE})
    public @ResponseBody
    void delete(@RequestParam Integer itemId) {

        userService.delete(itemId);
    }

    private void authenticate(String username, String password) throws Exception {
        try {
            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username, password));
        } catch (DisabledException e) {
            throw new Exception("USER_DISABLED", e);
        } catch (BadCredentialsException e) {
            throw new Exception("INVALID_CREDENTIALS", e);
        }
    }
}
