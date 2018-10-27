package com.a.a;

import com.b.a.f;
import java.io.EOFException;
import java.nio.Buffer;
import java.nio.ByteBuffer;
import java.util.logging.Level;
import java.util.logging.Logger;

public abstract class a
  implements c
{
  private static Logger a = Logger.getLogger(a.class.getName());
  private ThreadLocal b = new b();
  
  public final com.a.a.a.a a(f paramf, com.a.a.a.b paramb)
  {
    long l = paramf.b();
    ((ByteBuffer)this.b.get()).rewind().limit(8);
    int i;
    do
    {
      i = paramf.a((ByteBuffer)this.b.get());
      if (i == 8)
      {
        ((ByteBuffer)this.b.get()).rewind();
        l = e.a((ByteBuffer)this.b.get());
        if (l >= 8L) {}
        while (l <= 1L)
        {
          localObject = e.f((ByteBuffer)this.b.get());
          if (l == 1L)
          {
            ((ByteBuffer)this.b.get()).limit(16);
            paramf.a((ByteBuffer)this.b.get());
            ((ByteBuffer)this.b.get()).position(8);
            l = e.c((ByteBuffer)this.b.get()) - 16L;
          }
          for (;;)
          {
            if ("uuid".equals(localObject))
            {
              ((ByteBuffer)this.b.get()).limit(((ByteBuffer)this.b.get()).limit() + 16);
              paramf.a((ByteBuffer)this.b.get());
              byte[] arrayOfByte = new byte[16];
              i = ((ByteBuffer)this.b.get()).position() - 16;
              while (i < ((ByteBuffer)this.b.get()).position())
              {
                arrayOfByte[(i - (((ByteBuffer)this.b.get()).position() - 16))] = ((ByteBuffer)this.b.get()).get(i);
                i += 1;
              }
              l -= 16L;
            }
            for (;;)
            {
              if (!(paramb instanceof com.a.a.a.a)) {}
              for (;;)
              {
                paramb = a((String)localObject);
                paramb.a();
                ((ByteBuffer)this.b.get()).rewind();
                paramb.a(paramf, (ByteBuffer)this.b.get(), l, this);
                return paramb;
                ((com.a.a.a.a)paramb).b();
              }
            }
            if (l == 0L) {
              l = paramf.a() - paramf.b();
            } else {
              l = -8L + l;
            }
          }
        }
        paramf = a;
        paramb = Level.SEVERE;
        Object localObject = new StringBuilder(80);
        ((StringBuilder)localObject).append("Plausibility check failed: size < 8 (size = ");
        ((StringBuilder)localObject).append(l);
        ((StringBuilder)localObject).append("). Stop parsing!");
        paramf.logp(paramb, "com.coremedia.iso.AbstractBoxParser", "parseBox", ((StringBuilder)localObject).toString());
        return null;
      }
    } while (i >= 0);
    paramf.a(l);
    throw new EOFException();
  }
  
  public abstract com.a.a.a.a a(String paramString);
}


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/com/a/a/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */