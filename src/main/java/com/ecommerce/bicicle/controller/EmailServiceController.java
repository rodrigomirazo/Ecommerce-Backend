package com.ecommerce.bicicle.controller;

import com.ecommerce.bicicle.constants.EndpointNames;
import com.ecommerce.bicicle.service.FloatingCharsService;
import com.ecommerce.bicicle.util.EmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.mail.MessagingException;
import java.io.IOException;

@CrossOrigin
@RestController
@RequestMapping(value = EndpointNames.URI)
public class EmailServiceController {

    private static final String emailServiceEndpoint = EndpointNames.EMAIL_SERVICE_CONTROLLER;

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

}
