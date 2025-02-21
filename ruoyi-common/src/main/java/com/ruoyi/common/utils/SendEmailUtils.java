package com.ruoyi.common.utils;

import org.apache.commons.mail.EmailException;
import org.apache.commons.mail.HtmlEmail;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;
import org.springframework.ui.Model;
import org.thymeleaf.context.Context;
import org.thymeleaf.spring5.SpringTemplateEngine;

import java.util.Map;

@Component
public class SendEmailUtils {
    @Autowired
    private SpringTemplateEngine templateEngine;

    @Async
    public void send(String title, String emailTo, Map<String, Object> variables, String tempalte){

        Context context = new Context();
        context.setVariables(variables); // 直接将 Map 传入 Thymeleaf

        String content = templateEngine.process(tempalte, context);
        HtmlEmail email = new HtmlEmail();
        email.setCharset("UTF-8");
        email.setSSLOnConnect(true);
        email.setSslSmtpPort("465");
        email.setAuthentication("492297036@qq.com","dzjdcbljeolncbab");
        email.setHostName("smtp.qq.com");
        try {
            email.addTo(emailTo.split(","));
            email.setFrom("492297036@qq.com", "系统提醒");
            email.setSubject(title);
            email.setHtmlMsg(content);
            email.send();
        } catch (EmailException e) {
            e.printStackTrace();
        }
    }


}
