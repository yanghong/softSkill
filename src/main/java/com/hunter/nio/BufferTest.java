package com.hunter.nio;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.Buffer;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;
import java.util.Scanner;

/**
 * @author hunter.yang
 * @version 1.0
 * @description null
 * @date 2020/11/13 7:43
 */
public class BufferTest {

//    Buffer buffer = new Buffer(0,1,10,10);
//
//    ByteBuffer byteBuffer = new ByteBuffer(0, 1, 10, 20);

    public void initBuffer () {
        File file = new File("D://data.txt");
        long len = file.length();
        byte[] ds = new byte[(int) len];

        try {
            MappedByteBuffer mappedByteBuffer = new RandomAccessFile(file, "r").getChannel().map(FileChannel.MapMode.READ_ONLY, 0, len);

            for (int offset = 0 ; offset < len ; offset++) {
                byte b = mappedByteBuffer.get();
                ds[offset] = b;
            }

            Scanner scanner = new Scanner(new ByteArrayInputStream(ds)).useDelimiter(" ");

            while (scanner.hasNext()) {
                System.out.println(scanner.next() + " ");
            }

        } catch (IOException e) {}
    }

    /**
     * 填充和释放缓冲区
     */
    private static void drainBuffer (CharBuffer buffer) {
        while (buffer.hasRemaining()) {
            System.out.println(buffer.get());
        }
        System.out.println("");
    }

    private static int index = 0;

    private static String [] strings = {
            "A random string value",
            "The product of an infinite number of monkeys",
            "Hey hey we're the Monkees",
            "Opening act for the Monkees: Jimi Hendrix",
            "'Scuse me while I kiss this fly", // Sorry Jimi ;-)
            "Help Me! Help Me!",
    };

    private static boolean fillBuffer (CharBuffer buffer) {
        if (index >= strings.length) {
            return false;
        }

        String string = strings[index++];

        for (int i = 0; i < string.length(); i++) {
            buffer.put(string.charAt(i));
        }

        return true;
    }
    
    public static void main(String[] args) throws Exception{
        CharBuffer buffer = CharBuffer.allocate(100);

        while (fillBuffer(buffer)) {
            buffer.flip();
            drainBuffer(buffer);
            buffer.clear();
        }

        // 复制缓冲区
        CharBuffer charBuffer = CharBuffer.allocate(8);
        charBuffer.position(3).limit(6).mark().position(5);
        CharBuffer dupeBuffer = charBuffer.duplicate();
        charBuffer.clear();
    }

}
