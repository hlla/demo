package com.tencent.c.e;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public final class c
{
  private static void a(byte[] paramArrayOfByte, int[] paramArrayOfInt)
  {
    int j = 0;
    int k = paramArrayOfByte.length;
    int i = 0;
    while (i < k >> 2)
    {
      int m = j + 1;
      paramArrayOfByte[j] &= 0xFF;
      int n = paramArrayOfInt[i];
      j = m + 1;
      paramArrayOfInt[i] = (n | (paramArrayOfByte[m] & 0xFF) << 8);
      n = paramArrayOfInt[i];
      m = j + 1;
      paramArrayOfInt[i] = (n | (paramArrayOfByte[j] & 0xFF) << 16);
      n = paramArrayOfInt[i];
      j = m + 1;
      paramArrayOfInt[i] = ((paramArrayOfByte[m] & 0xFF) << 24 | n);
      i += 1;
    }
    if (j < paramArrayOfByte.length)
    {
      k = j + 1;
      paramArrayOfByte[j] &= 0xFF;
      j = 8;
      while (k < paramArrayOfByte.length)
      {
        paramArrayOfInt[i] |= (paramArrayOfByte[k] & 0xFF) << j;
        k += 1;
        j += 8;
      }
    }
  }
  
  private static byte[] bw(byte[] paramArrayOfByte)
  {
    Object localObject = paramArrayOfByte;
    if (paramArrayOfByte != null)
    {
      localObject = paramArrayOfByte;
      if (paramArrayOfByte.length <= 16) {}
    }
    try
    {
      localObject = MessageDigest.getInstance("MD5");
      ((MessageDigest)localObject).update(paramArrayOfByte);
      localObject = ((MessageDigest)localObject).digest();
      return (byte[])localObject;
    }
    catch (NoSuchAlgorithmException paramArrayOfByte) {}
    return null;
  }
  
  public static byte[] cdB()
  {
    try
    {
      Object localObject = new StringBuffer();
      int i = 0;
      while (i < "http://pmir.3g.qq.com".length())
      {
        ((StringBuffer)localObject).append((char)("http://pmir.3g.qq.com".charAt(i) + new int[] { -36, -46, -45, -77, -22, -10, 47, -77, -72, -69, -32, 25, 21, -21, -6, -75, -71, 31, -39, -49, -49 }[i]));
        i += 1;
      }
      localObject = ((StringBuffer)localObject).toString().getBytes("UTF-8");
      return (byte[])localObject;
    }
    catch (UnsupportedEncodingException localUnsupportedEncodingException) {}
    return null;
  }
  
  public static byte[] j(byte[] paramArrayOfByte1, byte[] paramArrayOfByte2)
  {
    int m = 0;
    byte[] arrayOfByte = bw(paramArrayOfByte2);
    paramArrayOfByte2 = paramArrayOfByte1;
    if (paramArrayOfByte1 != null)
    {
      paramArrayOfByte2 = paramArrayOfByte1;
      if (arrayOfByte != null)
      {
        if (paramArrayOfByte1.length != 0) {
          break label31;
        }
        paramArrayOfByte2 = paramArrayOfByte1;
      }
    }
    label31:
    int i;
    int[] arrayOfInt;
    label119:
    do
    {
      int n;
      do
      {
        return paramArrayOfByte2;
        if (paramArrayOfByte1.length % 4 == 0)
        {
          i = (paramArrayOfByte1.length >>> 2) + 1;
          arrayOfInt = new int[i];
          a(paramArrayOfByte1, arrayOfInt);
          arrayOfInt[(i - 1)] = paramArrayOfByte1.length;
          if (arrayOfByte.length % 4 != 0) {
            break label119;
          }
        }
        for (i = arrayOfByte.length >>> 2;; i = (arrayOfByte.length >>> 2) + 1)
        {
          j = i;
          if (i < 4) {
            j = 4;
          }
          paramArrayOfByte1 = new int[j];
          i = 0;
          while (i < j)
          {
            paramArrayOfByte1[i] = 0;
            i += 1;
          }
          i = (paramArrayOfByte1.length >>> 2) + 2;
          break;
        }
        a(arrayOfByte, paramArrayOfByte1);
        int i2 = arrayOfInt.length - 1;
        i = arrayOfInt[i2];
        j = 52 / (i2 + 1) + 6;
        k = 0;
        while (j > 0)
        {
          n = -1640531527 + k;
          int i3 = n >>> 2 & 0x3;
          int i1 = 0;
          k = i;
          i = i1;
          while (i < i2)
          {
            i1 = arrayOfInt[(i + 1)];
            i4 = arrayOfInt[i];
            k = ((k ^ paramArrayOfByte1[(i & 0x3 ^ i3)]) + (i1 ^ n) ^ (k >>> 5 ^ i1 << 2) + (i1 >>> 3 ^ k << 4)) + i4;
            arrayOfInt[i] = k;
            i += 1;
          }
          i1 = arrayOfInt[0];
          int i4 = arrayOfInt[i2];
          i = ((paramArrayOfByte1[(i & 0x3 ^ i3)] ^ k) + (i1 ^ n) ^ (k >>> 5 ^ i1 << 2) + (i1 >>> 3 ^ k << 4)) + i4;
          arrayOfInt[i2] = i;
          k = n;
          j -= 1;
        }
        paramArrayOfByte1 = new byte[arrayOfInt.length << 2];
        n = arrayOfInt.length;
        i = paramArrayOfByte1.length >> 2;
        j = i;
        if (i > n) {
          j = n;
        }
        i = 0;
        k = m;
        while (i < j)
        {
          m = k + 1;
          paramArrayOfByte1[k] = ((byte)(arrayOfInt[i] & 0xFF));
          k = m + 1;
          paramArrayOfByte1[m] = ((byte)(arrayOfInt[i] >>> 8 & 0xFF));
          m = k + 1;
          paramArrayOfByte1[k] = ((byte)(arrayOfInt[i] >>> 16 & 0xFF));
          k = m + 1;
          paramArrayOfByte1[m] = ((byte)(arrayOfInt[i] >>> 24 & 0xFF));
          i += 1;
        }
        paramArrayOfByte2 = paramArrayOfByte1;
      } while (n <= j);
      paramArrayOfByte2 = paramArrayOfByte1;
    } while (k >= paramArrayOfByte1.length);
    int j = k + 1;
    paramArrayOfByte1[k] = ((byte)(arrayOfInt[i] & 0xFF));
    int k = 8;
    for (;;)
    {
      paramArrayOfByte2 = paramArrayOfByte1;
      if (k > 24) {
        break;
      }
      paramArrayOfByte2 = paramArrayOfByte1;
      if (j >= paramArrayOfByte1.length) {
        break;
      }
      paramArrayOfByte1[j] = ((byte)(arrayOfInt[i] >>> k & 0xFF));
      k += 8;
      j += 1;
    }
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/c/e/c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */