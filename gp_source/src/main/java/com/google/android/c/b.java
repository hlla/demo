package com.google.android.c;

import java.io.EOFException;
import java.io.InputStream;

public final class b
{
  public static void a(InputStream paramInputStream, int paramInt)
  {
    if (paramInt != 0) {
      while (paramInt > 0)
      {
        long l1 = paramInt;
        long l2 = paramInputStream.skip(l1);
        if (l2 >= 0L) {
          paramInt = (int)(l1 - l2);
        } else {
          throw new EOFException();
        }
      }
    }
  }
  
  public static void a(InputStream paramInputStream, byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    if (paramInt2 != 0)
    {
      if (paramInputStream == null) {
        throw new NullPointerException("in == null");
      }
      if (paramArrayOfByte != null)
      {
        int i = paramArrayOfByte.length;
        if ((paramInt2 >= 0) && (i >= paramInt2)) {
          for (;;)
          {
            if (paramInt2 <= 0) {
              return;
            }
            i = paramInputStream.read(paramArrayOfByte, paramInt1, paramInt2);
            if (i < 0) {
              break;
            }
            paramInt1 += i;
            paramInt2 -= i;
          }
        }
      }
      else
      {
        throw new NullPointerException("dst == null");
      }
      throw new ArrayIndexOutOfBoundsException();
      throw new EOFException();
    }
  }
}


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/com/google/android/c/b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */