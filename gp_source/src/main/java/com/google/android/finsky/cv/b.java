package com.google.android.finsky.cv;

import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.g;
import com.google.protobuf.nano.j;
import com.google.wireless.android.a.b.a.a.bt;

public final class b
  extends com.google.protobuf.nano.b
{
  public String a = "";
  public int b = 0;
  public e c = null;
  public int d = 1;
  public e e = null;
  public d f = null;
  public String g = "";
  public String h = "";
  public long i = 0L;
  public a j = null;
  public a k = null;
  public byte[] l = j.b;
  public int m = 0;
  public String n = "";
  public int o = 0;
  
  public b()
  {
    this.unknownFieldData = null;
    this.cachedSize = -1;
  }
  
  private final b b(com.google.protobuf.nano.a parama)
  {
    for (;;)
    {
      int i1 = parama.a();
      switch (i1)
      {
      default: 
        if (super.a(parama, i1)) {}
        break;
      case 0: 
        return this;
      case 114: 
        this.l = parama.d();
        this.b |= 0x100;
        break;
      case 104: 
        this.b |= 0x80;
        int i2 = parama.j();
        try
        {
          this.o = bt.a(parama.e());
          this.b |= 0x80;
        }
        catch (IllegalArgumentException localIllegalArgumentException)
        {
          parama.e(i2);
          a(parama, i1);
        }
        break;
      case 98: 
        if (this.k == null) {
          this.k = new a();
        }
        parama.a(this.k);
        break;
      case 90: 
        if (this.j == null) {
          this.j = new a();
        }
        parama.a(this.j);
        break;
      case 82: 
        if (this.e == null) {
          this.e = new e();
        }
        parama.a(this.e);
        break;
      case 74: 
        if (this.c == null) {
          this.c = new e();
        }
        parama.a(this.c);
        break;
      case 66: 
        if (this.f == null) {
          this.f = new d();
        }
        parama.a(this.f);
        break;
      case 56: 
        this.m = parama.e();
        this.b |= 0x40;
        break;
      case 50: 
        this.g = parama.c();
        this.b |= 0x20;
        break;
      case 42: 
        this.n = parama.c();
        this.b |= 0x10;
        break;
      case 32: 
        this.d = parama.e();
        this.b |= 0x8;
        break;
      case 24: 
        this.i = parama.f();
        this.b |= 0x4;
        break;
      case 18: 
        this.a = parama.c();
        this.b |= 0x2;
        break;
      case 10: 
        this.h = parama.c();
        this.b |= 0x1;
      }
    }
  }
  
  protected final int a()
  {
    int i2 = super.a();
    int i1 = i2;
    if ((this.b & 0x1) != 0) {
      i1 = i2 + CodedOutputByteBufferNano.b(1, this.h);
    }
    i2 = i1;
    if ((this.b & 0x2) != 0) {
      i2 = i1 + CodedOutputByteBufferNano.b(2, this.a);
    }
    i1 = i2;
    if ((this.b & 0x4) != 0) {
      i1 = i2 + CodedOutputByteBufferNano.f(3, this.i);
    }
    i2 = i1;
    if ((this.b & 0x8) != 0) {
      i2 = i1 + CodedOutputByteBufferNano.d(4, this.d);
    }
    i1 = i2;
    if ((this.b & 0x10) != 0) {
      i1 = i2 + CodedOutputByteBufferNano.b(5, this.n);
    }
    i2 = i1;
    if ((this.b & 0x20) != 0) {
      i2 = i1 + CodedOutputByteBufferNano.b(6, this.g);
    }
    i1 = i2;
    if ((this.b & 0x40) != 0) {
      i1 = i2 + CodedOutputByteBufferNano.d(7, this.m);
    }
    Object localObject = this.f;
    i2 = i1;
    if (localObject != null) {
      i2 = i1 + CodedOutputByteBufferNano.d(8, (g)localObject);
    }
    localObject = this.c;
    i1 = i2;
    if (localObject != null) {
      i1 = i2 + CodedOutputByteBufferNano.d(9, (g)localObject);
    }
    localObject = this.e;
    i2 = i1;
    if (localObject != null) {
      i2 = i1 + CodedOutputByteBufferNano.d(10, (g)localObject);
    }
    localObject = this.j;
    i1 = i2;
    if (localObject != null) {
      i1 = i2 + CodedOutputByteBufferNano.d(11, (g)localObject);
    }
    localObject = this.k;
    i2 = i1;
    if (localObject != null) {
      i2 = i1 + CodedOutputByteBufferNano.d(12, (g)localObject);
    }
    i1 = i2;
    if ((this.b & 0x80) != 0) {
      i1 = i2 + CodedOutputByteBufferNano.d(13, this.o);
    }
    i2 = i1;
    if ((this.b & 0x100) != 0) {
      i2 = i1 + CodedOutputByteBufferNano.b(14, this.l);
    }
    return i2;
  }
  
  public final void a(CodedOutputByteBufferNano paramCodedOutputByteBufferNano)
  {
    if ((this.b & 0x1) != 0) {
      paramCodedOutputByteBufferNano.a(1, this.h);
    }
    if ((this.b & 0x2) != 0) {
      paramCodedOutputByteBufferNano.a(2, this.a);
    }
    if ((this.b & 0x4) != 0) {
      paramCodedOutputByteBufferNano.b(3, this.i);
    }
    if ((this.b & 0x8) != 0) {
      paramCodedOutputByteBufferNano.a(4, this.d);
    }
    if ((this.b & 0x10) != 0) {
      paramCodedOutputByteBufferNano.a(5, this.n);
    }
    if ((this.b & 0x20) != 0) {
      paramCodedOutputByteBufferNano.a(6, this.g);
    }
    if ((this.b & 0x40) != 0) {
      paramCodedOutputByteBufferNano.a(7, this.m);
    }
    Object localObject = this.f;
    if (localObject != null) {
      paramCodedOutputByteBufferNano.b(8, (g)localObject);
    }
    localObject = this.c;
    if (localObject != null) {
      paramCodedOutputByteBufferNano.b(9, (g)localObject);
    }
    localObject = this.e;
    if (localObject != null) {
      paramCodedOutputByteBufferNano.b(10, (g)localObject);
    }
    localObject = this.j;
    if (localObject != null) {
      paramCodedOutputByteBufferNano.b(11, (g)localObject);
    }
    localObject = this.k;
    if (localObject != null) {
      paramCodedOutputByteBufferNano.b(12, (g)localObject);
    }
    if ((this.b & 0x80) != 0) {
      paramCodedOutputByteBufferNano.a(13, this.o);
    }
    if ((this.b & 0x100) != 0) {
      paramCodedOutputByteBufferNano.a(14, this.l);
    }
    super.a(paramCodedOutputByteBufferNano);
  }
  
  public final boolean b()
  {
    return (this.b & 0x2) != 0;
  }
}


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/com/google/android/finsky/cv/b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */