package com.google.android.finsky.e.a;

import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.b;
import com.google.protobuf.nano.f;
import com.google.protobuf.nano.g;

public final class a
  extends b
{
  private static volatile a[] f;
  public String a = "";
  public int b = 0;
  public long c = -1L;
  public String d = "";
  public boolean e = true;
  
  public a()
  {
    this.unknownFieldData = null;
    this.cachedSize = -1;
  }
  
  public static a[] Z_()
  {
    if (f == null) {}
    synchronized (f.a)
    {
      if (f == null) {
        f = new a[0];
      }
      return f;
    }
  }
  
  public static a a(byte[] paramArrayOfByte)
  {
    return (a)g.a(new a(), paramArrayOfByte);
  }
  
  protected final int a()
  {
    int j = super.a();
    int i = j;
    if ((this.b & 0x1) != 0) {
      i = j + CodedOutputByteBufferNano.f(1, this.c);
    }
    j = i;
    if ((this.b & 0x2) != 0) {
      j = i + CodedOutputByteBufferNano.b(2, this.d);
    }
    i = j;
    if ((this.b & 0x4) != 0) {
      i = j + CodedOutputByteBufferNano.b(3, this.a);
    }
    j = i;
    if ((this.b & 0x8) != 0) {
      j = i + (CodedOutputByteBufferNano.d(32) + 1);
    }
    return j;
  }
  
  public final a a(String paramString)
  {
    if (paramString != null)
    {
      this.b |= 0x2;
      this.d = paramString;
      return this;
    }
    throw new NullPointerException();
  }
  
  public final a a(boolean paramBoolean)
  {
    this.b |= 0x8;
    this.e = paramBoolean;
    return this;
  }
  
  public final void a(CodedOutputByteBufferNano paramCodedOutputByteBufferNano)
  {
    if ((this.b & 0x1) != 0) {
      paramCodedOutputByteBufferNano.b(1, this.c);
    }
    if ((this.b & 0x2) != 0) {
      paramCodedOutputByteBufferNano.a(2, this.d);
    }
    if ((this.b & 0x4) != 0) {
      paramCodedOutputByteBufferNano.a(3, this.a);
    }
    if ((this.b & 0x8) != 0) {
      paramCodedOutputByteBufferNano.a(4, this.e);
    }
    super.a(paramCodedOutputByteBufferNano);
  }
  
  public final a b(String paramString)
  {
    if (paramString != null)
    {
      this.b |= 0x4;
      this.a = paramString;
      return this;
    }
    throw new NullPointerException();
  }
}


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/com/google/android/finsky/e/a/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */