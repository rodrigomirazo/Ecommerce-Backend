package com.ecommerce.bicicle.controller;

import com.ecommerce.bicicle.constants.EndpointNames;
import com.ecommerce.bicicle.dto.ItemFloatingCharsCatDto;
import com.ecommerce.bicicle.dto.ItemFloatingCharsDto;
import com.ecommerce.bicicle.service.FloatingCharsService;
import com.ecommerce.bicicle.util.EmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping(value = EndpointNames.URI)
public class EmailServiceController {

    private static final String emailServiceEndpoint = EndpointNames.EMAIL_SERVICE_CONTROLLER;

    @Autowired
    private FloatingCharsService floatingCharsService;

    @Autowired
    private EmailService emailService;
    /**
     * Floating Chars
     */

    @RequestMapping(value = emailServiceEndpoint + "/{emailId}" + "/{userName}", method = {RequestMethod.GET})
    public @ResponseBody
    String sendMail(@PathVariable(value = "emailId") String emailId, @PathVariable(value = "userName") String userName) {

        emailService.sendMail(emailId, userName);

        return "sent Email";
    }

}
