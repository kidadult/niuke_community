package com.nowcoder.community.community;

import com.nowcoder.community.community.utils.MailClient;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;

@RunWith(SpringRunner.class)
@SpringBootTest
@ContextConfiguration(classes = CommunityApplication.class)
public class MailTests {

    @Autowired
    private MailClient mailClient;

    @Autowired
    private TemplateEngine templateEngine;  // 操作themeleaf模板引擎的类

    @Test
    public void testTextMail() {
        mailClient.sendMail("kidadult.fun@gmail.com", "TEST", "Welcome.");  // 通过qq的邮件服务器帮我们代发邮件(配置文件中设置好)
    }

    @Test
    public void testHtmlMail() {
        Context context = new Context();
        context.setVariable("username", "sunday");

        String content = templateEngine.process("mail/demo", context);
        System.out.println(content);

        mailClient.sendMail("18370128926@163.com", "HTMLTest", content);
    }

}
