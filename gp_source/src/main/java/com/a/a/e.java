package com.a.a;

import java.io.UnsupportedEncodingException;
import java.nio.ByteBuffer;

public final class e
{
  public static int a(byte paramByte)
  {
    int i = paramByte;
    if (paramByte < 0) {
      i = paramByte + 256;
    }
    return i;
  }
  
  public static long a(ByteBuffer paramByteBuffer)
  {
    long l2 = paramByteBuffer.getInt();
    long l1 = l2;
    if (l2 < 0L) {
      l1 = l2 + 4294967296L;
    }
    return l1;
  }
  
  public static int b(ByteBuffer paramByteBuffer)
  {
    return (a(paramByteBuffer.get()) << 8) + a(paramByteBuffer.get());
  }
  
  public static long c(ByteBuffer paramByteBuffer)
  {
    long l = a(paramByteBuffer) << 32;
    if (l < 0L) {
      throw new RuntimeException("I don't know how to deal with UInt64! long is not sufficient and I don't want to use BigInt");
    }
    return l + a(paramByteBuffer);
  }
  
  public static double d(ByteBuffer paramByteBuffer)
  {
    byte[] arrayOfByte = new byte[4];
    paramByteBuffer.get(arrayOfByte);
    int i = arrayOfByte[0];
    int j = arrayOfByte[1];
    int k = arrayOfByte[2];
    return (arrayOfByte[3] & 0xFF | i << 24 & 0xFF000000 | j << 16 & 0xFF0000 | k << 8 & 0xFF00) / 65536.0D;
  }
  
  public static double e(ByteBuffer paramByteBuffer)
  {
    byte[] arrayOfByte = new byte[4];
    paramByteBuffer.get(arrayOfByte);
    int i = arrayOfByte[0];
    int j = arrayOfByte[1];
    int k = arrayOfByte[2];
    return (arrayOfByte[3] & 0xFF | i << 24 & 0xFF000000 | j << 16 & 0xFF0000 | k << 8 & 0xFF00) / 1.073741824E9D;
  }
  
  public static String f(ByteBuffer paramByteBuffer)
  {
    byte[] arrayOfByte = new byte[4];
    paramByteBuffer.get(arrayOfByte);
    try
    {
      paramByteBuffer = new String(arrayOfByte, "ISO-8859-1");
      return paramByteBuffer;
    }
    catch (UnsupportedEncodingException paramByteBuffer)
    {
      throw new RuntimeException(paramByteBuffer);
    }
  }
}


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/com/a/a/e.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */