package com.hunter.others.email;

import java.util.Properties;

import javax.activation.DataHandler;
import javax.activation.FileDataSource;
import javax.mail.Address;
import javax.mail.BodyPart;
import javax.mail.Message;
import javax.mail.Multipart;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

/**
 * @author hunter.yang
 * @version 1.0
 * @description 发送添加邮件的附件
 * @date 2020/12/2 14:38
 */
public class SendEmail {
    private static boolean flag = false;
    public static boolean send(Mail mail) throws Exception{
        //首先判断是否需要验证
        //validate为true表明需要验证，但是是否真的验证了还要根据邮件服务器，有的服务器验证，有的不需要验证
        MailAuthenticator authenticator = null;
        Properties prop = mail.getProperties();
        if(mail.isValidate()) {
            authenticator = new MailAuthenticator(mail.getUsername(),mail.getPassword());
        }
        //根据属性和密码验证器生成一个邮件session
        Session session = Session.getDefaultInstance(prop,authenticator);
        try {
            Message message = new MimeMessage(session);
            Address from = new InternetAddress(mail.getFromAddress());
            message.setFrom(from);
            Address to = new InternetAddress(mail.getToAddress());
            message.setRecipient(Message.RecipientType.TO, to);
            message.setSubject(mail.getSubject());
            Multipart mainPart = new MimeMultipart();//邮件的主体，让它装载所有邮件内容
            BodyPart body = new MimeBodyPart();//邮件主体的子部分
            //邮件正文内容
            body.setContent(mail.getContent(),"text/html;charset=utf-8");
            BodyPart attachbody = null;
            if(null==mail.getAttach()||"".equals(mail.getAttach())) {
            }else {
                //开始处理邮件的附件
                attachbody = new MimeBodyPart();
                FileDataSource fds = new FileDataSource(mail.getAttach());
                DataHandler dh = new DataHandler(fds);
                //提取文件名
                String attach = mail.getAttach();
                String fileName = attach.substring(attach.lastIndexOf("\\"));
                attachbody.setFileName(new String(fileName.getBytes("GB2312")));
                attachbody.setDataHandler(dh);
            }
            mainPart.addBodyPart(body);
            mainPart.addBodyPart(attachbody);
            message.setContent(mainPart);
            Transport.send(message);
            System.out.println("邮件发送成功\\(^o^)//~");
            flag = true;
        } catch (Exception e) {
            System.out.println("邮件发送失败╮(╯▽╰)╭");
            flag = false;
            throw e;
        }
        return flag;
    }

}
