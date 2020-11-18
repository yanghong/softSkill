package com.hunter.nio;

import java.nio.ByteBuffer;

/**
 * @author hunter.yang
 * @version 1.0
 * @description 直接缓冲区
 * @date 2020/11/18 8:45
 */
public class BufferDirect {
    
    public static void main(String[] args) {
        ByteBuffer byteBuffer = ByteBuffer.allocateDirect(100);
        System.out.println(byteBuffer.isDirect());
    }

}
