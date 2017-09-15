package com.tencent.c.e;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public final class e
{
  public static byte[] bx(byte[] paramArrayOfByte)
  {
    try
    {
      MessageDigest localMessageDigest = MessageDigest.getInstance("MD5");
      localMessageDigest.update(paramArrayOfByte);
      paramArrayOfByte = localMessageDigest.digest();
      return paramArrayOfByte;
    }
    catch (Exception paramArrayOfByte)
    {
      return null;
    }
    catch (NoSuchAlgorithmException paramArrayOfByte) {}
    return null;
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/c/e/e.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */