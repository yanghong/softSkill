package com.hunter.linux;

import com.jcraft.jsch.*;

import java.io.InputStream;

/**
 * @author hunter.yang
 * @version 1.0
 * @description null
 * @date 2021/3/11 16:42
 */
public class LinuxShell {

    private Session session;

    public void login(String host, int port, String user,String password)  {
        try {
            JSch jsch = new JSch();
            session = jsch.getSession(user, host, port);
            session.setPassword(password);
            // 设置第一次登陆的时候提示，可选值:(ask | yes | no)
            session.setConfig("StrictHostKeyChecking", "no");
            // 连接超时
            session.connect(1000*10);

        } catch (JSchException e) {
            System.out.println("登录时发生错误！");
            e.printStackTrace();
        }
    }

    public String executeShell(String command) throws Exception {

        byte[] tmp = new byte[1024];
        // 命令返回的结果
        StringBuffer resultBuffer = new StringBuffer();

        Channel channel = session.openChannel("exec");
        ChannelExec exec = (ChannelExec) channel;
        // 返回结果流（命令执行错误的信息通过getErrStream获取）
        InputStream stdStream = exec.getInputStream();

        exec.setCommand(command);
        exec.connect();

        try {
            // 开始获得SSH命令的结果
            while (true) {
                while (stdStream.available() > 0) {
                    int i = stdStream.read(tmp, 0, 1024);
                    if (i < 0) {
                        break;
                    }
                    resultBuffer.append(new String(tmp, 0, i));
                }
                if (exec.isClosed()) {
                    System.out.println(resultBuffer.toString());
                    break;
                }
                try {
                    Thread.sleep(200);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        } finally {
            //关闭连接
            channel.disconnect();
        }

        return resultBuffer.toString();
    }

    public void close() {
        if (session.isConnected()) {
            session.disconnect();
        }
    }

    public static void main(String[] args) {

        String ip="119.45.41.22";
        String username="root";
        String password="15221921388hH*";

        LinuxShell linux = new LinuxShell();

        linux.login(ip, 22, username,password);
        String command = "df -h";
        try {
            String result = linux.executeShell(command);
            System.out.println(result);
            linux.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
