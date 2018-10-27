package com.google.android.finsky.cv;

import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.a;
import com.google.protobuf.nano.b;
import com.google.wireless.android.a.b.a.a.bt;

public final class f
  extends b
{
  public int a = 0;
  public long b = 0L;
  public g c = null;
  public int d = 0;
  public long e = 0L;
  
  public f()
  {
    this.unknownFieldData = null;
    this.cachedSize = -1;
  }
  
  private final f b(a parama)
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
      case 40: 
        this.a |= 0x4;
        int j = parama.j();
        try
        {
          this.d = bt.a(parama.e());
          this.a |= 0x4;
        }
        catch (IllegalArgumentException localIllegalArgumentException)
        {
          parama.e(j);
          a(parama, i);
        }
        break;
      case 24: 
        this.e = parama.f();
        this.a |= 0x2;
        break;
      case 16: 
        this.b = parama.f();
        this.a |= 0x1;
        break;
      case 10: 
        if (this.c == null) {
          this.c = new g();
        }
        parama.a(this.c);
      }
    }
  }
  
  protected final int a()
  {
    int j = super.a();
    g localg = this.c;
    int i = j;
    if (localg != null) {
      i = j + CodedOutputByteBufferNano.d(1, localg);
    }
    j = i;
    if ((this.a & 0x1) != 0) {
      j = i + CodedOutputByteBufferNano.f(2, this.b);
    }
    i = j;
    if ((this.a & 0x2) != 0) {
      i = j + CodedOutputByteBufferNano.f(3, this.e);
    }
    j = i;
    if ((this.a & 0x4) != 0) {
      j = i + CodedOutputByteBufferNano.d(5, this.d);
    }
    return j;
  }
  
  public final void a(CodedOutputByteBufferNano paramCodedOutputByteBufferNano)
  {
    g localg = this.c;
    if (localg != null) {
      paramCodedOutputByteBufferNano.b(1, localg);
    }
    if ((this.a & 0x1) != 0) {
      paramCodedOutputByteBufferNano.b(2, this.b);
    }
    if ((this.a & 0x2) != 0) {
      paramCodedOutputByteBufferNano.b(3, this.e);
    }
    if ((this.a & 0x4) != 0) {
      paramCodedOutputByteBufferNano.a(5, this.d);
    }
    super.a(paramCodedOutputByteBufferNano);
  }
}


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/com/google/android/finsky/cv/f.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */