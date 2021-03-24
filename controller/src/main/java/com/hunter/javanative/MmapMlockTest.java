package com.hunter.javanative;

import org.apache.hadoop.hdfs.server.datanode.fsdataset.impl.MappableBlock;
import org.apache.hadoop.io.IOUtils;
import org.apache.hadoop.io.nativeio.NativeIO;

import java.io.FileInputStream;
import java.io.IOException;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;

/**
 * @author hunter.yang
 * @version 1.0
 * @description null
 * @date 2021/3/11 13:45
 */
public class MmapMlockTest {

    public static MappableBlock load(long length, FileInputStream blockIn, FileInputStream metaIn, String blockFileName) throws IOException {
        MappableBlock mappableBlock = null;
        MappedByteBuffer mmap = null;
        FileChannel blockChannel = null;
        try {
            // 获取块数据的FileChannel对象
            blockChannel = blockIn.getChannel();
            if (blockChannel == null) {
                throw new IOException("Block InputStream has no FileChannel.");
            }
            // 这里开始进行内存的映射操作
            mmap = blockChannel.map(FileChannel.MapMode.READ_ONLY, 0 ,length);
            NativeIO.POSIX.getCacheManipulator().mlock(blockFileName, mmap, length);
//            mappableBlock = new MappableBlock(mmap, length);
        }finally {
            IOUtils.closeStream(blockChannel);
            if (mappableBlock == null) {
                // 解除地址区域的对象映射
                NativeIO.POSIX.munmap(mmap);
            }
        }
        return mappableBlock;
    }
}
