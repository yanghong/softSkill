package com.hunter.others.email;

import java.util.Properties;

/**
 * @author hunter.yang
 * @version 1.0
 * @description null
 * @date 2020/12/2 14:41
 */
public class Mail {

    private String fromAddress;
    private String toAddress;
    private String subject;
    private String content;
    private String attach;
    private String mailHost;
    private String username;
    private String password;
    private boolean validate;

    public String getFromAddress() {
        return fromAddress;
    }

    public void setFromAddress(String fromAddress) {
        this.fromAddress = fromAddress;
    }

    public String getToAddress() {
        return toAddress;
    }

    public void setToAddress(String toAddress) {
        this.toAddress = toAddress;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getAttach() {
        return attach;
    }

    public void setAttach(String attach) {
        this.attach = attach;
    }

    public String getMailHost() {
        return mailHost;
    }

    public void setMailHost(String mailHost) {
        this.mailHost = mailHost;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean isValidate() {
        return validate;
    }

    public void setValidate(boolean validate) {
        this.validate = validate;
    }

    public Properties getProperties() {
        Properties p = new Properties();
        p.put("mail.smtp.host", mailHost);
        p.put("mail.transport.protocol", "smtp");
        p.put("mail.smtp.auth", validate?"true":"false");
        return p;
    }
}
