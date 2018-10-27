package com.google.android.c;

import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.util.zip.ZipException;

public final class c
{
  public long a = -1L;
  public int b = -1;
  public long c = -1L;
  public String d;
  public int e = -1;
  public long f = -1L;
  public int g;
  
  c(byte[] paramArrayOfByte, InputStream paramInputStream)
  {
    b.a(paramInputStream, paramArrayOfByte, 0, paramArrayOfByte.length);
    paramArrayOfByte = new a(paramArrayOfByte);
    int j = paramArrayOfByte.a();
    if (j != 33639248L) {
      d.a("Central Directory Entry", j);
    }
    paramArrayOfByte.a = 8;
    j = (char)paramArrayOfByte.b();
    if ((j & 0x1) != 0)
    {
      paramArrayOfByte = new StringBuilder(45);
      paramArrayOfByte.append("Invalid General Purpose Bit Flag: ");
      paramArrayOfByte.append(j);
      throw new ZipException(paramArrayOfByte.toString());
    }
    this.b = ((char)paramArrayOfByte.b());
    paramArrayOfByte.b();
    paramArrayOfByte.b();
    paramArrayOfByte.a();
    this.a = (paramArrayOfByte.a() & 0xFFFFFFFF);
    this.f = (paramArrayOfByte.a() & 0xFFFFFFFF);
    this.e = ((char)paramArrayOfByte.b());
    j = (char)paramArrayOfByte.b();
    int k = (char)paramArrayOfByte.b();
    if (j >= 32768) {
      this.g |= 0x1;
    }
    if (k < 32768) {}
    for (;;)
    {
      paramArrayOfByte.a = 42;
      this.c = (paramArrayOfByte.a() & 0xFFFFFFFF);
      paramArrayOfByte = new byte[this.e];
      int m = paramArrayOfByte.length;
      b.a(paramInputStream, paramArrayOfByte, 0, m);
      for (;;)
      {
        if (i >= m) {}
        for (;;)
        {
          try
          {
            this.d = new String(paramArrayOfByte, 0, m, "UTF-8");
            if (j > 0) {
              b.a(paramInputStream, j);
            }
            if (k > 0) {
              b.a(paramInputStream, k);
            }
            return;
          }
          catch (UnsupportedEncodingException paramArrayOfByte)
          {
            throw new RuntimeException(paramArrayOfByte);
          }
          if (paramArrayOfByte[i] != 0) {
            continue;
          }
          this.g |= 0x10;
        }
        i += 1;
      }
      this.g |= 0x2;
    }
  }
  
  public final int hashCode()
  {
    return this.d.hashCode();
  }
  
  public final String toString()
  {
    return this.d;
  }
}


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/com/google/android/c/c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */