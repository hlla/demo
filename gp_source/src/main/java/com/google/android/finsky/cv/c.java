package com.google.android.finsky.cv;

import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.b;
import com.google.protobuf.nano.f;
import com.google.protobuf.nano.j;

public final class c
  extends b
{
  private static volatile c[] j;
  public int a = 0;
  public boolean b = false;
  public byte[] c = j.b;
  public int d = 0;
  public String e = "";
  public long f = 0L;
  public int g = -1;
  public h h = null;
  public String i = "";
  
  public c()
  {
    this.unknownFieldData = null;
    this.cachedSize = -1;
  }
  
  public static c[] b()
  {
    if (j == null) {}
    synchronized (f.a)
    {
      if (j == null) {
        j = new c[0];
      }
      return j;
    }
  }
  
  protected final int a()
  {
    int m = super.a();
    int k = m;
    if ((this.a & 0x1) != 0) {
      k = m + CodedOutputByteBufferNano.b(1, this.e);
    }
    m = k;
    if (this.g == 0) {
      m = k + CodedOutputByteBufferNano.b(2, this.i);
    }
    k = m;
    if (this.g == 1) {
      k = m + CodedOutputByteBufferNano.b(3, this.c);
    }
    m = k;
    if (this.g == 2) {
      m = k + CodedOutputByteBufferNano.f(4, this.f);
    }
    k = m;
    if (this.g == 3) {
      k = m + (CodedOutputByteBufferNano.d(40) + 1);
    }
    m = k;
    if (this.g == 4) {
      m = k + CodedOutputByteBufferNano.d(6, this.h);
    }
    k = m;
    if (this.g == 5) {
      k = m + CodedOutputByteBufferNano.d(7, this.d);
    }
    return k;
  }
  
  public final void a(CodedOutputByteBufferNano paramCodedOutputByteBufferNano)
  {
    if ((this.a & 0x1) != 0) {
      paramCodedOutputByteBufferNano.a(1, this.e);
    }
    if (this.g == 0) {
      paramCodedOutputByteBufferNano.a(2, this.i);
    }
    if (this.g == 1) {
      paramCodedOutputByteBufferNano.a(3, this.c);
    }
    if (this.g == 2) {
      paramCodedOutputByteBufferNano.b(4, this.f);
    }
    if (this.g == 3) {
      paramCodedOutputByteBufferNano.a(5, this.b);
    }
    if (this.g == 4) {
      paramCodedOutputByteBufferNano.b(6, this.h);
    }
    if (this.g == 5) {
      paramCodedOutputByteBufferNano.a(7, this.d);
    }
    super.a(paramCodedOutputByteBufferNano);
  }
}


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/com/google/android/finsky/cv/c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */