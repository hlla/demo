package com.google.android.finsky.cv;

import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.b;
import com.google.wireless.android.a.b.a.a.bt;

public final class g
  extends b
{
  public int a = 0;
  public long b = 0L;
  public long c = 0L;
  public com.google.android.finsky.e.a.a d = null;
  public int e = 0;
  public String f = "";
  private int g = -1;
  private i h = null;
  
  public g()
  {
    this.unknownFieldData = null;
    this.cachedSize = -1;
  }
  
  private final g b(com.google.protobuf.nano.a parama)
  {
    for (;;)
    {
      int i = parama.a();
      switch (i)
      {
      default: 
        if (super.a(parama, i)) {}
        break;
      case 0: 
        return this;
      case 48: 
        this.b = parama.f();
        this.a |= 0x8;
        break;
      case 40: 
        this.a |= 0x4;
        int j = parama.j();
        try
        {
          this.e = bt.a(parama.e());
          this.a |= 0x4;
        }
        catch (IllegalArgumentException localIllegalArgumentException)
        {
          parama.e(j);
          a(parama, i);
        }
        break;
      case 32: 
        this.c = parama.f();
        this.a |= 0x2;
        break;
      case 26: 
        if (this.d == null) {
          this.d = new com.google.android.finsky.e.a.a();
        }
        parama.a(this.d);
        break;
      case 18: 
        if (this.h == null) {
          this.h = new i();
        }
        parama.a(this.h);
        this.g = 0;
        break;
      case 10: 
        this.f = parama.c();
        this.a |= 0x1;
      }
    }
  }
  
  protected final int a()
  {
    int j = super.a();
    int i = j;
    if ((this.a & 0x1) != 0) {
      i = j + CodedOutputByteBufferNano.b(1, this.f);
    }
    j = i;
    if (this.g == 0) {
      j = i + CodedOutputByteBufferNano.d(2, this.h);
    }
    com.google.android.finsky.e.a.a locala = this.d;
    i = j;
    if (locala != null) {
      i = j + CodedOutputByteBufferNano.d(3, locala);
    }
    j = i;
    if ((this.a & 0x2) != 0) {
      j = i + CodedOutputByteBufferNano.f(4, this.c);
    }
    i = j;
    if ((this.a & 0x4) != 0) {
      i = j + CodedOutputByteBufferNano.d(5, this.e);
    }
    j = i;
    if ((this.a & 0x8) != 0) {
      j = i + CodedOutputByteBufferNano.f(6, this.b);
    }
    return j;
  }
  
  public final g a(i parami)
  {
    this.g = -1;
    this.g = 0;
    this.h = parami;
    return this;
  }
  
  public final void a(CodedOutputByteBufferNano paramCodedOutputByteBufferNano)
  {
    if ((this.a & 0x1) != 0) {
      paramCodedOutputByteBufferNano.a(1, this.f);
    }
    if (this.g == 0) {
      paramCodedOutputByteBufferNano.b(2, this.h);
    }
    com.google.android.finsky.e.a.a locala = this.d;
    if (locala != null) {
      paramCodedOutputByteBufferNano.b(3, locala);
    }
    if ((this.a & 0x2) != 0) {
      paramCodedOutputByteBufferNano.b(4, this.c);
    }
    if ((this.a & 0x4) != 0) {
      paramCodedOutputByteBufferNano.a(5, this.e);
    }
    if ((this.a & 0x8) != 0) {
      paramCodedOutputByteBufferNano.b(6, this.b);
    }
    super.a(paramCodedOutputByteBufferNano);
  }
  
  public final i b()
  {
    if (this.g != 0) {
      return null;
    }
    return this.h;
  }
}


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/com/google/android/finsky/cv/g.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */