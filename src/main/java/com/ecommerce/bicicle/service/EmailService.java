package com.ecommerce.bicicle.service;

import com.ecommerce.bicicle.dto.ItemFloatingCharsDto;
import com.ecommerce.bicicle.dto.ItemSavedDto;
import com.ecommerce.bicicle.dto.ItemTransactionDto;
import com.ecommerce.bicicle.dto.UserDto;
import com.ecommerce.bicicle.repository.UserRepository;
import com.ecommerce.bicicle.service.ItemTransactionService;
import com.ecommerce.bicicle.service.UserService;
import com.ecommerce.bicicle.util.MailComponent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Component;

import javax.mail.internet.MimeMessage;
import java.io.IOException;
import java.sql.Date;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.util.List;
import javax.mail.MessagingException;

import org.springframework.mail.SimpleMailMessage;
import org.springframework.core.io.ClassPathResource;
import org.springframework.mail.javamail.MimeMessageHelper;

import static com.ecommerce.bicicle.constants.EmailContent.*;


@Component
public class EmailService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private JavaMailSender javaMailSender;

    @Autowired
    private MailComponent mailComponent;

    @Autowired
    private ItemTransactionService itemTransactionService;

    @Autowired
    private UserService userService;

    public boolean sendMail(String emailId, String userName) {

        userRepository.getByUserName(userName);
        sendEmail();

        return true;
    }

    void sendEmail() {

        SimpleMailMessage msg = new SimpleMailMessage();
        msg.setTo("rodrigomirazo@gmail.com", "to_2@gmail.com", "to_3@yahoo.com");
        msg.setFrom("rodrigo@baaw.mx");
        msg.setSubject("Testing from Spring Boot");
        msg.setText("Hello World \n Spring Boot Email");

        //javaMailSender.send(msg);
    }

    //UPLOAD
    public void sendUploadItemNotification(ItemSavedDto item) {

        // Mail to vendor User
        sendGenericItemEmail(item, null, item.getUser(), MAIL_BODY_UPLOAD_VENDOR_SUBJECT, MAIL_BODY_UPLOAD_VENDOR_MESSAGE);
        // Mail to Admin
        sendMailToadmins(item, null, MAIL_BODY_UPLOAD_ADMIN_SUBJECT, MAIL_BODY_UPLOAD_ADMIN_MESSAGE);
    }

    //DIAGNOST
    public void sendDiagnostItemNotification(ItemSavedDto item, boolean approved) {
        if(approved) {
            // Mail to vendor User
            sendGenericItemEmail(item, null, item.getUser(), MAIL_BODY_DIAGNOST_VENDOR_ACCEPTED_SUBJECT, MAIL_BODY_DIAGNOST_VENDOR_ACCEPTED_MESSAGE);
            // Mail to Admin
            sendMailToadmins(item, null, MAIL_BODY_DIAGNOST_ADMIN_ACCEPTED_SUBJECT, MAIL_BODY_DIAGNOST_ADMIN_ACCEPTED_MESSAGE);
        } else {
            // Mail to vendor User
            sendGenericItemEmail(item, null, item.getUser(), MAIL_BODY_DIAGNOST_VENDOR_DECLINE_SUBJECT, MAIL_BODY_DIAGNOST_VENDOR_DECLINE_MESSAGE);
            // Mail to Admin
            sendMailToadmins(item, null, MAIL_BODY_DIAGNOST_ADMIN_DECLINE_SUBJECT, MAIL_BODY_DIAGNOST_ADMIN_DECLINE_MESSAGE);
        }
    }

    // SEND TO BAAW PARTNER
    public void sendToBaawPartnerItemNotification(ItemSavedDto item, ItemTransactionDto itemTransaction) {
        // Mail to Buyer User
        sendGenericItemEmail(item, itemTransaction, item.getUser(), MAIL_BODY_SENT_BAAW_PARTNER_BUYER_SUBJECT, MAIL_BODY_SENT_BAAW_PARTNER_BUYER_MESSAGE);
        // Mail to vendor User
        sendGenericItemEmail(item, itemTransaction, item.getUser(), MAIL_BODY_SENT_BAAW_PARTNER_VENDOR_SUBJECT, MAIL_BODY_SENT_BAAW_PARTNER_VENDOR_MESSAGE);
        // Mail to Admin
        sendMailToadmins(item, itemTransaction, MAIL_BODY_SENT_BAAW_PARTNER_ADMIN_SUBJECT, MAIL_BODY_SENT_BAAW_PARTNER_ADMIN_MESSAGE);
    }

    // SERVICE
    public void sendServiceItemNotification(ItemSavedDto item, ItemTransactionDto itemTransaction) {
        // Mail to Buyer User
        sendGenericItemEmail(item, itemTransaction, item.getUser(), MAIL_BODY_SERVICE_BUYER_SUBJECT , MAIL_BODY_SERVICE_BUYER_MESSAGE);
        // Mail to vendor User
        sendGenericItemEmail(item, itemTransaction, item.getUser(), MAIL_BODY_SERVICE_VENDOR_SUBJECT, MAIL_BODY_SERVICE_VENDOR_MESSAGE);
        // Mail to Admin
        sendMailToadmins(item, itemTransaction, MAIL_BODY_SERVICE_ADMIN_SUBJECT, MAIL_BODY_SERVICE_ADMIN_MESSAGE);
    }

    // SEND TO BUYER
    public void sendSendToBuyerItemNotification(ItemSavedDto item, ItemTransactionDto itemTransaction) {
        // Mail to Buyer User
        sendGenericItemEmail(item, itemTransaction, item.getUser(), MAIL_BODY_SEND_TO_BUYER_BUYER_SUBJECT, MAIL_BODY_SEND_TO_BUYER_BUYER_MESSAGE);
        // Mail to vendor User
        sendGenericItemEmail(item, itemTransaction, item.getUser(), MAIL_BODY_SEND_TO_BUYER_VENDOR_SUBJECT, MAIL_BODY_SEND_TO_BUYER_VENDOR_MESSAGE);
        // Mail to Admin
        sendMailToadmins(item, itemTransaction, MAIL_BODY_SEND_TO_BUYER_ADMIN_SUBJECT, MAIL_BODY_SEND_TO_BUYER_ADMIN_MESSAGE);
    }

    // RECEIVED
    public void sendReceivedItemNotification(ItemSavedDto item, ItemTransactionDto itemTransaction) {
        // Mail to Buyer User
        sendGenericItemEmail(item, itemTransaction, item.getUser(), MAIL_BODY_RECEIVED_BUYER_SUBJECT, MAIL_BODY_RECEIVED_BUYER_MESSAGE);
        // Mail to vendor User
        sendGenericItemEmail(item, itemTransaction, item.getUser(), MAIL_BODY_RECEIVED_VENDOR_SUBJECT, MAIL_BODY_RECEIVED_VENDOR_MESSAGE);
        // Mail to Admin
        sendMailToadmins(item, itemTransaction, MAIL_BODY_RECEIVED_ADMIN_SUBJECT, MAIL_BODY_RECEIVED_ADMIN_MESSAGE);
    }

    public void sendMailToadmins(ItemSavedDto item, ItemTransactionDto itemTransaction, String subject, String userNotification) {

        userService.getUserAdmins();
        List<UserDto> adminUsers = userService.getUserAdmins();
        adminUsers.forEach(userAdmin -> {
            sendGenericItemEmail(item, itemTransaction, userAdmin, subject, userNotification);
        });
    }

    public void sendPurchaseNotification(Integer transactionId) {

        ItemTransactionDto itemTransaction = itemTransactionService.getById(transactionId);
        try {
            // 1. Notify Buyer
            sendEmailToBuyer(itemTransaction);
            // 2. Notify Vendor
            sendEmailToVendor(itemTransaction);

            // 3. Notify Admins
            userService.getUserAdmins();
            List<UserDto> adminUsers = userService.getUserAdmins();
            adminUsers.forEach(userDto -> {
                sendEmailToAdmins(itemTransaction, userDto.getName() + " " + userDto.getLastname(), userDto.getEmail());
            });
        } catch (MessagingException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void sendVerificationMailEmail(String userName, String userMail, String token) {

        String mailMessage = userTokenReplacement(userName, MAIL_TYPE_RESET_PASSWORD,
                MAIL_BODY_VERIFICATION_EMAIL_HEADER
                        + MAIL_BODY_USER_NOTIFICATION
                        + MAIL_BODY_USER_MAIL_FOOTER, token);

        //mailComponent.sendMail(mailMessage + "", MAIL_FROM + "", userMail + "", MAIL_TOKEN_USER_VERIFICATION_SUBJECT + "");
    }

    public void sendResetPasswordEmail(String userName, String userMail, String token) {

        String mailMessage = userTokenReplacement(userName, MAIL_TYPE_VERIFICATION,
                MAIL_BODY_RESET_PASS_EMAIL_HEADER
                        + MAIL_BODY_USER_NOTIFICATION
                        + MAIL_BODY_USER_MAIL_FOOTER, token);

        //mailComponent.sendMail(mailMessage + "", MAIL_FROM + "", userMail + "", MAIL_TOKEN_USER_VERIFICATION_SUBJECT + "");
    }

    public void sendGenericItemEmail(ItemSavedDto item, ItemTransactionDto itemTransaction, UserDto user,
                                     String subject, String userNotification) {

        MimeMessage msg = javaMailSender.createMimeMessage();

        String mailMessage =
                MAIL_BODY_PURCAHSE_HEADER
                + MAIL_BODY_PURCAHSE_NOTIFICATION
                + MAIL_BODY_PURCAHSE_FOOTER;

        mailMessage = genericTokenReplacement(item, itemTransaction, mailMessage, user.getName(), userNotification);

        MimeMessageHelper helper = null;
        try {
            helper = new MimeMessageHelper(msg, true);
            helper.setFrom(MAIL_FROM);
            helper.setTo(user.getEmail());
            helper.setSubject(subject);
            helper.setText(mailMessage, true);
            helper.addInline("logo", new ClassPathResource("img/logo.png"));

        } catch (MessagingException e) {
            e.printStackTrace();
        }


        //javaMailSender.send(msg);
    }

    public void sendEmailToAdmins(
            ItemTransactionDto itemTransactionDto, String baawPartner, String email
    ) {

        MimeMessage msg = javaMailSender.createMimeMessage();

        String notification =
                  MAIL_BODY_PURCAHSE_HEADER
                + MAIL_BODY_PURCAHSE_NOTIFICATION
                + MAIL_BODY_PURCAHSE_FOOTER;

        notification = notification.replace(MAIL_TOKEN_USER_NOTIFIC,     MAIL_BODY_PURCAHSE_ADMIN_MESSAGE);
        notification = notification.replace(MAIL_TOKEN_TRANSACTION_DATE,       dateFormat(itemTransactionDto.getCreatedTime()) + "");
        notification = notification.replace(MAIL_TOKEN_BUYER_LINK,             "http://baaw.mx/#/console/shoppingFollowUp/" + itemTransactionDto.getId());
        notification = notification.replace(MAIL_TOKEN_TRANSACTION_ID,         itemTransactionDto.getId() + "");
        notification = notification.replace(MAIL_TOKEN_ITEM_ID,                itemTransactionDto.getItem().getId() + "");
        notification = notification.replace(MAIL_TOKEN_ADMIN_CONSOLE_LINK,     "http://baaw.mx/#/console/diagnostico");
        notification = notification.replace(MAIL_TOKEN_CLIENT_NAME,            baawPartner + "");

        MimeMessageHelper helper = null;
        try {
            helper = new MimeMessageHelper(msg, true);
            helper.setFrom(MAIL_FROM);
            helper.setTo(email);
            helper.setSubject(MAIL_SUBJECT_ADMINS);
            helper.setText(notification, true);
            helper.addInline("logo", new ClassPathResource("img/logo.png"));

        } catch (MessagingException e) {
            e.printStackTrace();
        }


        //javaMailSender.send(msg);
    }

    public void sendEmailToBuyer(
            ItemTransactionDto itemTransactionDto
    ) throws MessagingException, IOException {

        MimeMessage msg = javaMailSender.createMimeMessage();

        String notification =
                  MAIL_BODY_PURCAHSE_HEADER
                + MAIL_BODY_PURCAHSE_NOTIFICATION
                + MAIL_BODY_PURCAHSE_FOOTER;

        notification = notification.replace(MAIL_TOKEN_USER_NOTIFIC,     MAIL_BODY_PURCAHSE_BUYER_MESSAGE);
        notification = notification.replace(MAIL_TOKEN_TRANSACTION_DATE, dateFormat(itemTransactionDto.getCreatedTime()));
        notification = notification.replace(MAIL_TOKEN_BUYER_LINK,      "http://baaw.mx/#/console/shoppingFollowUp/" + itemTransactionDto.getId());
        notification = notification.replace(MAIL_TOKEN_TRANSACTION_ID,  itemTransactionDto.getId() + "");
        notification = notification.replace(MAIL_TOKEN_ITEM_ID,         itemTransactionDto.getItem().getId() + "");
        notification = notification.replace(MAIL_TOKEN_CLIENT_NAME,     itemTransactionDto.getUserBuyer().getName() + " " + itemTransactionDto.getUserBuyer().getLastname() );

        MimeMessageHelper helper = new MimeMessageHelper(msg, true);
        helper.setFrom(MAIL_FROM);
        helper.setTo(itemTransactionDto.getUserBuyer().getEmail());
        helper.setSubject(MAIL_SUBJECT_BUYER);
        helper.setText(notification, true);
        helper.addInline("logo", new ClassPathResource("img/logo.png"));

        //javaMailSender.send(msg);
    }

    public void sendEmailToVendor(
            ItemTransactionDto itemTransactionDto
    ) throws MessagingException, IOException {

        MimeMessage msg = javaMailSender.createMimeMessage();

        String notification =
                  MAIL_BODY_PURCAHSE_HEADER
                + MAIL_BODY_PURCAHSE_NOTIFICATION
                + MAIL_BODY_VENDOR_STEPS
                + MAIL_BODY_PURCAHSE_FOOTER;

        notification = notification.replace(MAIL_TOKEN_USER_NOTIFIC,     MAIL_BODY_PURCAHSE_VENDOR_MESSAGE);
        notification = notification.replace(MAIL_TOKEN_TRANSACTION_DATE, dateFormat(itemTransactionDto.getCreatedTime()));
        notification = notification.replace(MAIL_TOKEN_BUYER_LINK,      "http://baaw.mx/#/console/shoppingFollowUp/" + itemTransactionDto.getId());
        notification = notification.replace(MAIL_TOKEN_TRANSACTION_ID,  itemTransactionDto.getId() + "");
        notification = notification.replace(MAIL_TOKEN_ITEM_ID,         itemTransactionDto.getItem().getId() + "");
        notification = notification.replace(MAIL_TOKEN_CLIENT_NAME,     itemTransactionDto.getUserVendor().getName() + " " + itemTransactionDto.getUserVendor().getLastname() );

        MimeMessageHelper helper = new MimeMessageHelper(msg, true);
        helper.setFrom(MAIL_FROM);
        helper.setTo(itemTransactionDto.getUserVendor().getEmail());
        helper.setSubject(MAIL_SUBJECT_VENDOR);
        helper.setText(notification, true);
        helper.addInline("logo", new ClassPathResource("img/logo.png"));

        //javaMailSender.send(msg);
    }

    public String dateFormat(Timestamp timestamp) {

        Date date = new Date(timestamp.getTime());
        String formattedDate = new SimpleDateFormat("dd / MM / YYYY").format(date);

        return formattedDate;
    }

    String userTokenReplacement(String userName, String notificationType, String message, String token) {

        if(notificationType.equalsIgnoreCase(MAIL_TYPE_VERIFICATION)) {
            message = message.replace(MAIL_TOKEN_USER_NOTIFIC, MAIL_TOKEN_USER_VERIFICATION_MESSAGE);
        } else if(notificationType.equalsIgnoreCase(MAIL_TYPE_RESET_PASSWORD)) {
            message = message.replace(MAIL_TOKEN_USER_NOTIFIC, MAIL_TOKEN_RESET_PASSWORD_MESSAGE);
        }

        message = message.replace(MAIL_TOKEN_USER_NAME, userName);
        message = message.replace(MAIL_TOKEN_SENT_TIME, dateFormat(new Timestamp(System.currentTimeMillis())) );
        message = message.replace(MAIL_TOKEN_RESET_VERIFICATION_URL, "<a href='http://baaw.mx/#/user/register?token="+token+"'>http://baaw.mx/#/user/register</a>");
        message = message.replace(MAIL_TOKEN_RESET_PASSWORD_URL, "<a href='http://baaw.mx/#/user/password?token="+token+"'>http://baaw.mx/#/user/password</a>");

        return message;
    }

    String genericTokenReplacement(ItemSavedDto item,
                                   ItemTransactionDto itemTransaction,
                                   String message,
                                   String clientName,
                                   String userNotification) {

        message = message.replace(MAIL_TOKEN_USER_NOTIFIC, userNotification);
        message = message.replace(MAIL_TOKEN_ADMIN_CONSOLE_LINK, "<a href='http://baaw.mx/#/console/diagnostico'>http://baaw.mx/#/console/diagnostico</a>");
        message = message.replace(MAIL_TOKEN_CLIENT_NAME, clientName + "");

        if(item != null) {
            message = message.replace(MAIL_TOKEN_BUYER_LINK, "<a href='http://baaw.mx/#/console/shoppingFollowUp/'>http://baaw.mx/#/console/shoppingFollowUp/</a>" + item.getId());
            message = message.replace(MAIL_TOKEN_ITEM_ID, item.getId()+"");
            message = message.replace(MAIL_TOKEN_UPLOAD_VENDOR, item.getUser().getName()+"");
        }
        if(itemTransaction != null) {
            message = message.replace(MAIL_TOKEN_TRANSACTION_ID, itemTransaction.getId() + "");
            message = message.replace(MAIL_TOKEN_TRANSACTION_DATE, dateFormat(itemTransaction.getCreatedTime()) + "");
        }
        return message;
    }
}
