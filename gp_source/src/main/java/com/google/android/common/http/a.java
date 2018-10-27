package com.google.android.common.http;

import java.io.InputStream;
import org.apache.http.HttpEntity;
import org.apache.http.entity.HttpEntityWrapper;

public final class a
  extends HttpEntityWrapper
{
  public final long a;
  public final long b;
  public final long c;
  public final long d;
  public final String e;
  public final int f;
  
  public a(HttpEntity paramHttpEntity, String paramString, int paramInt, long paramLong1, long paramLong2, long paramLong3, long paramLong4)
  {
    super(paramHttpEntity);
    this.e = paramString;
    this.f = paramInt;
    this.d = paramLong1;
    this.c = paramLong2;
    this.b = paramLong3;
    this.a = paramLong4;
  }
  
  public final InputStream getContent()
  {
    return new b(this, super.getContent());
  }
}


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/com/google/android/common/http/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */