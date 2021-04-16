package com.ecommerce.bicicle.controller;

import com.ecommerce.bicicle.constants.EndpointNames;
import com.ecommerce.bicicle.dto.ItemDto;
import com.ecommerce.bicicle.dto.ItemSavedDto;
import com.ecommerce.bicicle.dto.JwtRequestDto;
import com.ecommerce.bicicle.dto.UserDto;
import com.ecommerce.bicicle.service.UserService;
import com.ecommerce.bicicle.service.impl.JwtUserDetailsService;
import com.ecommerce.bicicle.util.JwtTokenUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
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
        return userService.get();
    }

    @RequestMapping(value = userUri+"/{username}", method = {RequestMethod.GET})
    public @ResponseBody
    UserDto getByUsername(@PathVariable("username") String userName) {

        return userService.getByUsername(userName);
    }

    /**
     * Authenticate with user & password
     * @param authenticationRequest
     * @return
     * @throws Exception
     */
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

    @RequestMapping(value = userUri + "/crossLogin", method = RequestMethod.POST)
    public ResponseEntity<?> crossLogin(@RequestBody JwtRequestDto authenticationRequest) throws Exception {

        UserDto userInDB = userService.getByUsernameAndPasswordCrossPlatform(authenticationRequest.getUsername(), authenticationRequest.getPassword());
        UserDetails userDetails;

        if (userInDB == null) {

            UserDto userDto = new UserDto();
            userDto.setUserName(authenticationRequest.getUsername());
            userDto.setEmail(authenticationRequest.getUsername());
            userDto.setUid(authenticationRequest.getPassword());

            userDto = userService.saveCrossPlatform(userDto);
            userInDB = userService.getByUsernameAndPasswordCrossPlatform(userDto.getUserName(), userDto.getUid());
            userDetails = new User(authenticationRequest.getUsername(), authenticationRequest.getPassword(), new ArrayList<>());
        } else {
            userDetails = new User(userInDB.getUserName(), userInDB.getPassword(), new ArrayList<>());
        }

        final String token = jwtTokenUtil.generateToken(userDetails);
        userInDB.setToken(token);

        return ResponseEntity.ok(userInDB);
    }

    @RequestMapping(value = userUri + "/preRegister", method = RequestMethod.POST)
    public ResponseEntity<?> register(@RequestBody JwtRequestDto authenticationRequest) throws Exception {

        UserDto userInDB = userService.getByUsernameAndPassword(authenticationRequest.getUsername(), authenticationRequest.getPassword());
        UserDetails userDetails;

        if (userInDB == null) {

            UserDto userDto = new UserDto();
            userDto.setUserName(authenticationRequest.getUsername());
            userDto.setEmail(authenticationRequest.getUsername());
            userDto.setPassword(authenticationRequest.getPassword());

            userService.registerUser(userDto);
            //userInDB = userService.getByUsernameAndPassword(userDto.getUserName(), userDto.getUid());
            //userDetails = new User(authenticationRequest.getUsername(), authenticationRequest.getPassword(), new ArrayList<>());
        } else {
            userDetails = new User(userInDB.getUserName(), userInDB.getPassword(), new ArrayList<>());
        }

        //final String token = jwtTokenUtil.generateToken(userDetails);
        //userInDB.setToken(token);

        return ResponseEntity.ok(null);
    }

    @RequestMapping(value = "/userUpdate", method = {RequestMethod.POST})
    public @ResponseBody
    UserDto put(
            @RequestBody UserDto userDto
            ) {

        return userService.save(userDto);
    }

    @RequestMapping(value = "/enableUser", method = {RequestMethod.POST})
    public @ResponseBody
    UserDto enableUser(
            @RequestBody UserDto userDto
    ) {
        return userService.enableUser(userDto);
    }

    @RequestMapping(value = "/passwordUpdate", method = {RequestMethod.POST})
    public @ResponseBody
    UserDto password(
            @RequestBody UserDto userDto
    ) {

        return userService.savePassword(userDto);
    }

    @RequestMapping(value = userUri, method = {RequestMethod.DELETE})
    public @ResponseBody
    void delete(@RequestParam Integer itemId) {

        userService.delete(itemId);
    }


    @RequestMapping(value = "/userFavorites/{username}", method = {RequestMethod.GET})
    public @ResponseBody
    List<ItemSavedDto> userFavorites(@PathVariable("username") String userName) {

        return userService.getFavouriteItems(userName);
    }

    @RequestMapping(value = "/userAddFavorites/{username}/{itemId}", method = {RequestMethod.GET})
    public @ResponseBody
    List<ItemSavedDto> userAddFavorites(@PathVariable("username") String userName, @PathVariable("itemId") Integer itemId) {

        return userService.addFavouriteItems(userName, itemId);
    }

    @RequestMapping(value = "/userRemoveFavorites/{username}/{itemId}", method = {RequestMethod.GET})
    public @ResponseBody
    List<ItemSavedDto> userRemoveFavorites(@PathVariable("username") String userName, @PathVariable("itemId") Integer itemId) {

        return userService.removeFavouriteItems(userName, itemId);
    }

    /*
    private void authenticate(String username, String password) throws Exception {
        try {
            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username, password));
        } catch (DisabledException e) {
            throw new Exception("USER_DISABLED", e);
        } catch (BadCredentialsException e) {
            throw new Exception("INVALID_CREDENTIALS", e);
        }
    }
    */
}
