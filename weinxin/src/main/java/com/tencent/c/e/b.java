package com.tencent.c.e;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.zip.DeflaterOutputStream;

public final class b
{
  public static byte[] l(byte[] paramArrayOfByte)
  {
    ByteArrayOutputStream localByteArrayOutputStream = new ByteArrayOutputStream();
    DeflaterOutputStream localDeflaterOutputStream = new DeflaterOutputStream(localByteArrayOutputStream);
    try
    {
      localDeflaterOutputStream.write(paramArrayOfByte);
      localDeflaterOutputStream.finish();
      paramArrayOfByte = localByteArrayOutputStream.toByteArray();
      return paramArrayOfByte;
    }
    catch (Exception paramArrayOfByte)
    {
      paramArrayOfByte = paramArrayOfByte;
      g.bS("deflater(), exception: " + paramArrayOfByte);
    }
    finally
    {
      try
      {
        localByteArrayOutputStream.close();
        localDeflaterOutputStream.close();
        return null;
        paramArrayOfByte = finally;
        try
        {
          localByteArrayOutputStream.close();
          localDeflaterOutputStream.close();
          throw paramArrayOfByte;
        }
        catch (IOException localIOException1)
        {
          for (;;) {}
        }
      }
      catch (IOException paramArrayOfByte)
      {
        for (;;) {}
      }
    }
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/c/e/b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */