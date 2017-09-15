package com.tencent.smtt.utils;

import java.io.Closeable;
import java.io.File;
import java.io.IOException;
import java.io.PrintStream;
import java.io.RandomAccessFile;

public final class d
  implements Closeable
{
  private final File iyn;
  public final RandomAccessFile wVv;
  private final byte[] wVw = new byte[8];
  public boolean wVx;
  
  private d(File paramFile)
  {
    this.iyn = paramFile;
    this.wVv = new RandomAccessFile(this.iyn, "r");
  }
  
  public d(String paramString)
  {
    this(new File(paramString));
  }
  
  public final int a(char[] paramArrayOfChar)
  {
    byte[] arrayOfByte = new byte[paramArrayOfChar.length];
    int j = this.wVv.read(arrayOfByte);
    int i = 0;
    while (i < paramArrayOfChar.length)
    {
      paramArrayOfChar[i] = ((char)arrayOfByte[i]);
      i += 1;
    }
    return j;
  }
  
  public final void close()
  {
    try
    {
      this.wVv.close();
      return;
    }
    catch (IOException localIOException)
    {
      System.out.println(localIOException);
    }
  }
  
  public final int readInt()
  {
    int j = this.wVv.readInt();
    int i = j;
    if (this.wVx) {
      i = (j & 0xFF000000) >>> 24 | (j & 0xFF) << 24 | (0xFF00 & j) << 8 | (0xFF0000 & j) >>> 8;
    }
    return i;
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/smtt/utils/d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */