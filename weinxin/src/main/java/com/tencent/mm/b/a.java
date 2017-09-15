package com.tencent.mm.b;

import com.tencent.gmtrace.GMTrace;
import java.io.File;
import java.io.FileOutputStream;
import java.io.PrintStream;
import java.io.RandomAccessFile;

public final class a
{
  public a fuJ;
  public b fuK;
  
  public a(b paramb)
  {
    GMTrace.i(14022397132800L, 104475);
    this.fuK = null;
    this.fuK = paramb;
    GMTrace.o(14022397132800L, 104475);
  }
  
  public static a aZ(String paramString)
  {
    int i = 0;
    GMTrace.i(14022665568256L, 104477);
    if (paramString == null) {}
    for (;;)
    {
      if (i < 8)
      {
        GMTrace.o(14022665568256L, 104477);
        return null;
      }
      try
      {
        localObject = new File(paramString);
        if (((File)localObject).exists()) {
          i = (int)((File)localObject).length();
        }
      }
      catch (Exception paramString)
      {
        Object localObject;
        b localb;
        GMTrace.o(14022665568256L, 104477);
      }
    }
    localObject = a.r(d(paramString, i - 8, 8));
    if (localObject == null)
    {
      GMTrace.o(14022665568256L, 104477);
      return null;
    }
    if (((a)localObject).fuM >= 0)
    {
      localb = new b();
      localb.aD(d(paramString, i - ((a)localObject).fuM - 8, ((a)localObject).fuM));
      paramString = new a(localb);
      paramString.fuJ = ((a)localObject);
      GMTrace.o(14022665568256L, 104477);
      return paramString;
    }
    return null;
  }
  
  public static boolean ba(String paramString)
  {
    GMTrace.i(14022799785984L, 104478);
    if (paramString == null)
    {
      GMTrace.o(14022799785984L, 104478);
      return false;
    }
    File localFile = new File(paramString);
    if (!localFile.exists())
    {
      GMTrace.o(14022799785984L, 104478);
      return false;
    }
    a locala = aZ(paramString);
    if ((locala != null) && (locala.fuK != null)) {
      try
      {
        paramString = new File(paramString);
        if (paramString.exists())
        {
          boolean bool = locala.fuK.apkMd5.equalsIgnoreCase(g.a(paramString, (int)(localFile.length() - (locala.fuJ.fuM + 8) - 2L), new byte[] { 0, 0 }));
          GMTrace.o(14022799785984L, 104478);
          return bool;
        }
      }
      catch (Exception paramString) {}
    }
    GMTrace.o(14022799785984L, 104478);
    return false;
  }
  
  private static byte[] d(String paramString, int paramInt1, int paramInt2)
  {
    GMTrace.i(14022934003712L, 104479);
    if (paramString == null)
    {
      GMTrace.o(14022934003712L, 104479);
      return null;
    }
    Object localObject = new File(paramString);
    if (!((File)localObject).exists())
    {
      GMTrace.o(14022934003712L, 104479);
      return null;
    }
    if (paramInt2 == -1)
    {
      paramInt2 = (int)((File)localObject).length();
      for (;;)
      {
        if (paramInt1 < 0)
        {
          GMTrace.o(14022934003712L, 104479);
          return null;
        }
        if (paramInt2 <= 0)
        {
          GMTrace.o(14022934003712L, 104479);
          return null;
        }
        int i = paramInt2;
        if (paramInt1 + paramInt2 > (int)((File)localObject).length()) {
          i = (int)((File)localObject).length() - paramInt1;
        }
        try
        {
          localObject = new RandomAccessFile(paramString, "r");
          paramString = new byte[i];
          l = paramInt1;
        }
        catch (Exception paramString)
        {
          try
          {
            long l;
            ((RandomAccessFile)localObject).seek(l);
            ((RandomAccessFile)localObject).readFully(paramString);
            ((RandomAccessFile)localObject).close();
            for (;;)
            {
              GMTrace.o(14022934003712L, 104479);
              return paramString;
              paramString = paramString;
              paramString = null;
            }
          }
          catch (Exception localException)
          {
            for (;;) {}
          }
        }
      }
    }
  }
  
  public final int g(File paramFile)
  {
    GMTrace.i(14022531350528L, 104476);
    try
    {
      if (aZ(paramFile.getAbsolutePath()) != null)
      {
        System.out.println("Error: duplicate append apk external info!");
        GMTrace.o(14022531350528L, 104476);
        return -1;
      }
      byte[] arrayOfByte = this.fuK.toByteArray();
      Object localObject = new a(arrayOfByte.length);
      localObject = a.q(a.fuL << 32 | ((a)localObject).fuM);
      int i = (byte)((arrayOfByte.length + 8) % 256);
      int j = (byte)((arrayOfByte.length + 8) / 256);
      RandomAccessFile localRandomAccessFile = new RandomAccessFile(paramFile, "rw");
      localRandomAccessFile.seek(paramFile.length() - 2L);
      localRandomAccessFile.write(new byte[] { i, j });
      localRandomAccessFile.close();
      paramFile = new FileOutputStream(paramFile, true);
      paramFile.write(arrayOfByte);
      paramFile.write((byte[])localObject);
      paramFile.flush();
      paramFile.close();
      GMTrace.o(14022531350528L, 104476);
      return 0;
    }
    catch (Exception paramFile)
    {
      GMTrace.o(14022531350528L, 104476);
    }
    return -1;
  }
  
  public static final class a
  {
    static final long fuL;
    public int fuM;
    
    static
    {
      GMTrace.i(14021860261888L, 104471);
      fuL = "Micromsg".hashCode();
      GMTrace.o(14021860261888L, 104471);
    }
    
    public a(int paramInt)
    {
      GMTrace.i(14021994479616L, 104472);
      this.fuM = 0;
      this.fuM = paramInt;
      GMTrace.o(14021994479616L, 104472);
    }
    
    static byte[] q(long paramLong)
    {
      GMTrace.i(14022262915072L, 104474);
      byte[] arrayOfByte = new byte[8];
      int i = 0;
      for (;;)
      {
        if (i >= 8)
        {
          GMTrace.o(14022262915072L, 104474);
          return arrayOfByte;
        }
        arrayOfByte[i] = ((byte)(int)(paramLong >> i * 8 & 0xFF));
        i += 1;
      }
    }
    
    public static a r(byte[] paramArrayOfByte)
    {
      GMTrace.i(14022128697344L, 104473);
      long l;
      int i;
      if (paramArrayOfByte.length == 8)
      {
        l = 0L;
        i = 0;
        if (i >= paramArrayOfByte.length) {
          if (l >> 32 != fuL) {
            break label79;
          }
        }
      }
      label79:
      for (paramArrayOfByte = new a((int)l);; paramArrayOfByte = null)
      {
        GMTrace.o(14022128697344L, 104473);
        return paramArrayOfByte;
        l |= (paramArrayOfByte[i] & 0xFF) << i * 8;
        i += 1;
        break;
      }
    }
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/b/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */