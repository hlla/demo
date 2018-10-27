package com.example.testmemory;

import java.io.ByteArrayOutputStream;

/**
 * Created by Tangji on 2015/8/5.
 * 获取OutputStream内部的Buffer
 */
public class ByteArrayOutputStreamWrapper extends ByteArrayOutputStream {

    public byte[] getBuffer() {
        return buf;
    }
}
