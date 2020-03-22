package com.example.myfirstspringproject.service;


import com.example.myfirstspringproject.models.User;
import freemarker.template.Configuration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.mail.javamail.MimeMessagePreparator;
import org.springframework.stereotype.Service;
import org.springframework.ui.freemarker.FreeMarkerTemplateUtils;
import freemarker.template.Template;


import java.util.HashMap;
import java.util.Map;

@Service
public class EmailServiceImpl implements EmailService {

    @Autowired
    private JavaMailSender javaMailSender;

    @Value("${spring.mail.username}")
    private String userName;

    @Autowired
    private Configuration freemarkerConfig;

    @Override
    public void sendMail(String subject, User user, String email) {
        try {
            Template template = freemarkerConfig.getTemplate("mails/mail.ftl");
            Map data = new HashMap();
            data.put("username", user.getFirstname());
            data.put("confirm", user.getConfirmCode());
            String html = FreeMarkerTemplateUtils.processTemplateIntoString(template, data);
            MimeMessagePreparator messagePreparator = mimeMessage -> {
                MimeMessageHelper messageHelper = new MimeMessageHelper(mimeMessage);
                messageHelper.setFrom(userName);
                messageHelper.setTo(email);
                messageHelper.setSubject(subject);
                messageHelper.setText(html, true);
            };

            javaMailSender.send(messagePreparator);
        } catch (Exception e) {
            System.out.println("Mail error");
            e.printStackTrace();
        }
    }
}
