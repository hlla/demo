package com.a.a;

import java.io.Closeable;

public class d
  extends com.b.a.d
  implements Closeable
{
  static
  {
    com.b.a.a.f.a(d.class);
  }
  
  public d(com.b.a.f paramf, c paramc)
  {
    a(paramf, paramf.a(), paramc);
  }
  
  public void close()
  {
    this.b.close();
  }
  
  public String toString()
  {
    String str = this.b.toString();
    StringBuilder localStringBuilder = new StringBuilder(String.valueOf(str).length() + 7);
    localStringBuilder.append("model(");
    localStringBuilder.append(str);
    localStringBuilder.append(")");
    return localStringBuilder.toString();
  }
}


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/com/a/a/d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */