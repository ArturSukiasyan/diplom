package com.diplom.service;

import org.springframework.web.multipart.MultipartFile;

import javax.mail.MessagingException;

public interface EmailService {

    void sendMessage(String to, String subject, String text);

    void sendMessageWithAttachment(String to, String subject, String text, MultipartFile file) throws
                                                                                               MessagingException;
}
