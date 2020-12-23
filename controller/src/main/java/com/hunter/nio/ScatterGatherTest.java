package com.hunter.nio;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.MappedByteBuffer;
import java.nio.channels.*;

/**
 * @description: 对于通道批量read 、 write
 * ScatteringByteChannel、GatheringByteChannel
 * @author: hunter.yang
 * @date: 20201123 13:25
 */
public class ScatterGatherTest {

    private static final Integer TYPE_PING = 1;

    private static final Integer TYPE_FILE = 2;

    public static void main(String[] args) throws Exception {

        ScatteringByteChannel channel = new ScatteringByteChannel() {
            @Override
            public long read(ByteBuffer[] dsts, int offset, int length) throws IOException {
                return 0;
            }

            @Override
            public long read(ByteBuffer[] dsts) throws IOException {
                return 0;
            }

            @Override
            public int read(ByteBuffer dst) throws IOException {
                return 0;
            }

            @Override
            public boolean isOpen() {
                return false;
            }

            @Override
            public void close() throws IOException {

            }
        };

        ByteBuffer header = ByteBuffer.allocateDirect (10);
        ByteBuffer body = ByteBuffer.allocateDirect (80);
        header.put( "hello".getBytes()).flip();
        ByteBuffer [] buffers = { header, body };
        long bytesRead = channel.read (buffers);


        FileChannel fileChannel = new FileChannel() {
            @Override
            public int read(ByteBuffer dst) throws IOException {
                return 0;
            }

            @Override
            public long read(ByteBuffer[] dsts, int offset, int length) throws IOException {
                return 0;
            }

            @Override
            public int write(ByteBuffer src) throws IOException {
                return 0;
            }

            @Override
            public long write(ByteBuffer[] srcs, int offset, int length) throws IOException {
                return 0;
            }

            @Override
            public long position() throws IOException {
                return 0;
            }

            @Override
            public FileChannel position(long newPosition) throws IOException {
                return null;
            }

            @Override
            public long size() throws IOException {
                return 0;
            }

            @Override
            public FileChannel truncate(long size) throws IOException {
                return null;
            }

            @Override
            public void force(boolean metaData) throws IOException {

            }

            @Override
            public long transferTo(long position, long count, WritableByteChannel target) throws IOException {
                return 0;
            }

            @Override
            public long transferFrom(ReadableByteChannel src, long position, long count) throws IOException {
                return 0;
            }

            @Override
            public int read(ByteBuffer dst, long position) throws IOException {
                return 0;
            }

            @Override
            public int write(ByteBuffer src, long position) throws IOException {
                return 0;
            }

            @Override
            public MappedByteBuffer map(MapMode mode, long position, long size) throws IOException {
                return null;
            }

            @Override
            public FileLock lock(long position, long size, boolean shared) throws IOException {
                return null;
            }

            @Override
            public FileLock tryLock(long position, long size, boolean shared) throws IOException {
                return null;
            }

            @Override
            protected void implCloseChannel() throws IOException {

            }
        };


        body.clear( );
        body.put("FOO".getBytes()).flip( ); // "FOO" as bytes
        header.clear( );
        header.putShort (TYPE_FILE.shortValue()).putLong (body.limit()).flip( );
//        long bytesWritten = channel.write (buffers);

        System.out.println(bytesRead);
    }

}
