package com.google.android.c;

import java.io.IOException;
import java.io.InputStream;
import java.util.zip.Inflater;
import java.util.zip.InflaterInputStream;

final class f
  extends InflaterInputStream
{
  private long a = 0L;
  private final c b;
  
  public f(InputStream paramInputStream, Inflater paramInflater, int paramInt, c paramc)
  {
    super(paramInputStream, paramInflater, paramInt);
    this.b = paramc;
  }
  
  public final int available()
  {
    if (super.available() != 0) {
      return (int)(this.b.f - this.a);
    }
    return 0;
  }
  
  public final int read(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    try
    {
      paramInt1 = super.read(paramArrayOfByte, paramInt1, paramInt2);
      if (paramInt1 == -1)
      {
        l1 = this.b.f;
        long l2 = this.a;
        if (l1 != l2)
        {
          paramArrayOfByte = new StringBuilder(76);
          paramArrayOfByte.append("Size mismatch on inflated file: ");
          paramArrayOfByte.append(l2);
          paramArrayOfByte.append(" vs ");
          paramArrayOfByte.append(l1);
          throw new IOException(paramArrayOfByte.toString());
        }
      }
      else
      {
        this.a += paramInt1;
      }
      return paramInt1;
    }
    catch (IOException paramArrayOfByte)
    {
      paramArrayOfByte = this.b.d;
      long l1 = this.a;
      StringBuilder localStringBuilder = new StringBuilder(String.valueOf(paramArrayOfByte).length() + 56);
      localStringBuilder.append("Error reading data for ");
      localStringBuilder.append(paramArrayOfByte);
      localStringBuilder.append(" near offset ");
      localStringBuilder.append(l1);
      throw new IOException(localStringBuilder.toString());
    }
  }
}


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/com/google/android/c/f.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */