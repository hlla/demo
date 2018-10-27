package com.google.android.c;

import java.io.InputStream;
import java.io.RandomAccessFile;

final class e
  extends InputStream
{
  public long a;
  public long b;
  private final RandomAccessFile c;
  
  public e(RandomAccessFile paramRandomAccessFile, long paramLong)
  {
    this.c = paramRandomAccessFile;
    this.b = paramLong;
    this.a = paramRandomAccessFile.length();
  }
  
  public final int available()
  {
    if (this.b < this.a) {
      return 1;
    }
    return 0;
  }
  
  public final int read()
  {
    synchronized (this.c)
    {
      this.c.seek(this.b);
      int i = this.c.read();
      if (i != -1) {
        this.b += 1L;
      }
      return i;
    }
  }
  
  public final int read(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    synchronized (this.c)
    {
      long l2 = this.a;
      long l1 = this.b;
      l2 -= l1;
      int i = paramInt2;
      if (paramInt2 > l2) {
        i = (int)l2;
      }
      this.c.seek(l1);
      paramInt1 = this.c.read(paramArrayOfByte, paramInt1, i);
      if (paramInt1 > 0)
      {
        this.b += paramInt1;
        return paramInt1;
      }
      return -1;
    }
  }
  
  public final long skip(long paramLong)
  {
    long l1 = this.a;
    long l3 = this.b;
    long l2 = l1 - l3;
    l1 = paramLong;
    if (paramLong > l2) {
      l1 = l2;
    }
    this.b = (l3 + l1);
    return l1;
  }
}


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/com/google/android/c/e.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */