package com.google.android.c;

import java.io.BufferedInputStream;
import java.io.Closeable;
import java.io.DataInputStream;
import java.io.File;
import java.io.InputStream;
import java.io.RandomAccessFile;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.zip.Inflater;
import java.util.zip.ZipException;

public final class d
  implements Closeable
{
  public final List a = new ArrayList();
  private final LinkedHashMap b = new LinkedHashMap();
  private RandomAccessFile c;
  
  public d(File paramFile)
  {
    this.c = new RandomAccessFile(paramFile.getPath(), "r");
    long l1 = -22L + this.c.length();
    if (l1 < 0L)
    {
      l1 = this.c.length();
      paramFile = new StringBuilder(53);
      paramFile.append("File too short to be a zip file: ");
      paramFile.append(l1);
      throw new ZipException(paramFile.toString());
    }
    this.c.seek(0L);
    if (Integer.reverseBytes(this.c.readInt()) == 67324752L)
    {
      long l3 = -65536L + l1;
      if (l3 < 0L) {}
      for (;;)
      {
        this.c.seek(l1);
        if (Integer.reverseBytes(this.c.readInt()) == 101010256L)
        {
          paramFile = new byte[18];
          this.c.readFully(paramFile);
          paramFile = new a(paramFile);
          int i = (char)paramFile.b();
          int k = (char)paramFile.b();
          int j = (char)paramFile.b();
          int m = paramFile.b();
          paramFile.a += 4;
          l1 = paramFile.a() & 0xFFFFFFFF;
          if ((j != (char)m) || (i != 0) || (k != 0)) {
            break;
          }
          paramFile = new BufferedInputStream(new e(this.c, l1), 4096);
          byte[] arrayOfByte = new byte[46];
          i = 0;
          while (i < j)
          {
            c localc = new c(arrayOfByte, paramFile);
            if (localc.c >= l1) {
              throw new ZipException("Local file header offset is after central directory");
            }
            Object localObject = localc.d;
            localObject = (c)this.b.put(localObject, localc);
            if (localObject != null)
            {
              ((c)localObject).g |= 0x20;
              localc.g |= 0x20;
            }
            this.a.add(localc);
            i += 1;
          }
        }
        l3 = l1 - 1L;
        l1 = l3;
        if (l3 < l2)
        {
          throw new ZipException("End Of Central Directory signature not found");
          l2 = l3;
        }
      }
    }
    throw new ZipException("Not a zip archive");
    throw new ZipException("Spanned archives not supported");
  }
  
  static void a(String paramString, int paramInt)
  {
    String str = String.format("%08x", new Object[] { Integer.valueOf(paramInt) });
    StringBuilder localStringBuilder = new StringBuilder(String.valueOf(paramString).length() + 26 + String.valueOf(str).length());
    localStringBuilder.append(paramString);
    localStringBuilder.append(" signature not found; was ");
    localStringBuilder.append(str);
    throw new ZipException(localStringBuilder.toString());
  }
  
  public final InputStream a(c paramc, boolean paramBoolean)
  {
    ??? = paramc.d;
    if (this.c == null) {
      throw new IllegalStateException("Zip file closed");
    }
    int i;
    if (??? != null)
    {
      paramc = (c)this.b.get(???);
      if (paramc == null) {
        paramc = (c)this.b.get(String.valueOf(???).concat("/"));
      }
      for (;;)
      {
        if (paramc != null) {
          synchronized (this.c)
          {
            e locale = new e((RandomAccessFile)???, paramc.c);
            DataInputStream localDataInputStream = new DataInputStream(locale);
            i = Integer.reverseBytes(localDataInputStream.readInt());
            if (i == 67324752L)
            {
              localDataInputStream.skipBytes(2);
              i = (char)Short.reverseBytes(localDataInputStream.readShort());
              if ((i & 0x1) != 0) {
                break;
              }
              localDataInputStream.skipBytes(18);
              i = (char)Short.reverseBytes(localDataInputStream.readShort());
              int j = (char)Short.reverseBytes(localDataInputStream.readShort());
              localDataInputStream.close();
              if (i != paramc.e) {
                paramc.g |= 0x8;
              }
              if (j >= 32768) {
                paramc.g |= 0x4;
              }
              if (!paramBoolean)
              {
                locale.skip(i + j);
                if (paramc.b != 0)
                {
                  locale.a = (locale.b + paramc.a);
                  i = Math.max(1024, (int)Math.min(paramc.f, 4096L));
                  paramc = new f(locale, new Inflater(true), i, paramc);
                  return paramc;
                }
                long l = locale.b;
                locale.a = (paramc.f + l);
                return locale;
              }
              return null;
            }
            a("Local File Header", i);
          }
        }
        return null;
      }
    }
    throw new NullPointerException("entryName == null");
    paramc = new StringBuilder(45);
    paramc.append("Invalid General Purpose Bit Flag: ");
    paramc.append(i);
    throw new ZipException(paramc.toString());
  }
  
  public final void close()
  {
    RandomAccessFile localRandomAccessFile = this.c;
    if (localRandomAccessFile != null) {
      try
      {
        this.c = null;
        localRandomAccessFile.close();
        return;
      }
      finally {}
    }
  }
}


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/com/google/android/c/d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */