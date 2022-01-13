package com.ecommerce.bicicle.controller;

import com.ecommerce.bicicle.constants.EndpointNames;
import com.ecommerce.bicicle.service.FloatingCharsService;
import com.ecommerce.bicicle.service.EmailService;
import com.ecommerce.bicicle.util.JwtTokenUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

import javax.mail.MessagingException;
import java.io.IOException;
import java.util.ArrayList;

@CrossOrigin
@RestController
@RequestMapping(value = EndpointNames.URI)
public class EmailServiceController {

    private static final String emailServiceEndpoint = EndpointNames.EMAIL_SERVICE_CONTROLLER;

    @Autowired
    private JwtTokenUtil jwtTokenUtil;

    @Autowired
    private FloatingCharsService floatingCharsService;

    @Autowired
    private EmailService emailService;

    @RequestMapping(value = emailServiceEndpoint + "/purchase/{transactionId}", method = {RequestMethod.GET})
    public @ResponseBody
    String sendMail(@PathVariable(value = "transactionId") Integer transactionId) throws IOException, MessagingException {

        emailService.sendPurchaseNotification(transactionId);

        return "sent Email";
    }

    @RequestMapping(value = emailServiceEndpoint + "/signUpMail", method = {RequestMethod.GET})
    public @ResponseBody
    String sendVerificationMail(
            @PathVariable(value = "userMail") String userMail,
            @PathVariable(value = "userName") String userName,
            @PathVariable(value = "userPassword") String userPassword
    ) throws IOException, MessagingException {

        UserDetails userDetails = new User(userName, userPassword, new ArrayList<>());
        final String token = jwtTokenUtil.generateToken(userDetails);

        emailService.sendVerificationMailEmail(userName, userMail, token);

        return "sent Verification mail Email";
    }

    @RequestMapping(value = emailServiceEndpoint + "/resetPassword/{userMail}/{userName}/{userPassword}", method = {RequestMethod.GET})
    public @ResponseBody
    String sendResetPasswordMail(
            @PathVariable(value = "userMail") String userMail,
            @PathVariable(value = "userName") String userName,
            @PathVariable(value = "userPassword") String userPassword
    ) throws IOException, MessagingException {

        UserDetails userDetails = new User(userName, userPassword, new ArrayList<>());
        final String token = jwtTokenUtil.generateToken(userDetails);

        emailService.sendVerificationMailEmail(userName, userMail, token);

        return "sent Verification mail Email";
    }

}
