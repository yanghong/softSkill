package com.hunter.others.email;

import javax.mail.Authenticator;
import javax.mail.PasswordAuthentication;

/**
 * @author hunter.yang
 * @version 1.0
 * @description null
 * @date 2020/12/2 14:46
 */
public class MailAuthenticator extends Authenticator {

    String username = null;
    String password = null;
    public MailAuthenticator(){}
    public MailAuthenticator(String username,String password) {
        this.username = username;
        this.password = password;
    }
    @Override
    protected PasswordAuthentication getPasswordAuthentication() {
        return new PasswordAuthentication(username, password);
    }
}
