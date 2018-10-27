package com.b.a;

import com.a.a.a.a;
import com.a.a.c;
import java.nio.ByteBuffer;

public class b
  extends d
  implements a
{
  private String e;
  
  public b(String paramString)
  {
    this.e = paramString;
  }
  
  public final void a() {}
  
  public final void a(f paramf, long paramLong, c paramc)
  {
    this.b = paramf;
    this.d = paramf.b();
    paramf.a(paramf.b() + paramLong);
    this.c = paramf.b();
    this.a = paramc;
  }
  
  public final void a(f paramf, ByteBuffer paramByteBuffer, long paramLong, c paramc)
  {
    paramf.b();
    paramByteBuffer.remaining();
    if (paramByteBuffer.remaining() == 16) {}
    a(paramf, paramLong, paramc);
  }
  
  public final String b()
  {
    return this.e;
  }
}


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/com/b/a/b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */