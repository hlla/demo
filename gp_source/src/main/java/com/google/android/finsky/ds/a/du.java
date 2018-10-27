package com.google.android.finsky.ds.a;

import com.google.protobuf.CodedOutputStream;
import com.google.protobuf.bb;
import com.google.protobuf.bh;
import com.google.protobuf.cl;
import com.google.protobuf.cw;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.b;
import com.google.protobuf.nano.d;
import com.google.protobuf.nano.f;
import com.google.protobuf.nano.g;
import com.google.wireless.android.finsky.d.cm;

public final class du
  extends b
{
  private static volatile du[] a;
  private long b = 0L;
  private boolean c = false;
  private com.google.n.b.a.a d = null;
  private int e = 0;
  private long f = 0L;
  private int g = 1;
  private dv h = null;
  private cm i = null;
  
  public du()
  {
    this.unknownFieldData = null;
    this.cachedSize = -1;
  }
  
  private final du b(com.google.protobuf.nano.a parama)
  {
    for (;;)
    {
      int j = parama.a();
      switch (j)
      {
      default: 
        if (super.a(parama, j)) {}
        break;
      case 0: 
        return this;
      case 218: 
        this.i = ((cm)parama.a((cw)cm.a.a(bh.d, null)));
        break;
      case 176: 
        this.c = parama.b();
        this.e |= 0x2;
        break;
      case 162: 
        this.d = ((com.google.n.b.a.a)parama.a((cw)com.google.n.b.a.a.b.a(bh.d, null)));
        break;
      case 122: 
        if (this.h == null) {
          this.h = new dv();
        }
        parama.a(this.h);
        break;
      case 96: 
        this.f = parama.f();
        this.e |= 0x4;
        break;
      case 88: 
        this.e |= 0x1;
        int k = parama.j();
        try
        {
          this.g = dt.a(parama.e());
          this.e |= 0x1;
        }
        catch (IllegalArgumentException localIllegalArgumentException)
        {
          parama.e(k);
          a(parama, j);
        }
        break;
      case 81: 
        this.b = parama.h();
      }
    }
  }
  
  public static du[] b()
  {
    if (a == null) {}
    synchronized (f.a)
    {
      if (a == null) {
        a = new du[0];
      }
      return a;
    }
  }
  
  protected final int a()
  {
    int k = super.a() + (CodedOutputByteBufferNano.d(80) + 8);
    int j = k;
    if ((this.e & 0x1) != 0) {
      j = k + CodedOutputByteBufferNano.d(11, this.g);
    }
    k = j;
    if ((this.e & 0x4) != 0) {
      k = j + CodedOutputByteBufferNano.f(12, this.f);
    }
    Object localObject = this.h;
    j = k;
    if (localObject != null) {
      j = k + CodedOutputByteBufferNano.d(15, (g)localObject);
    }
    localObject = this.d;
    k = j;
    if (localObject != null) {
      k = j + CodedOutputStream.c(20, (cl)localObject);
    }
    j = k;
    if ((this.e & 0x2) != 0) {
      j = k + (CodedOutputByteBufferNano.d(176) + 1);
    }
    localObject = this.i;
    k = j;
    if (localObject != null) {
      k = j + CodedOutputStream.c(27, (cl)localObject);
    }
    return k;
  }
  
  public final void a(CodedOutputByteBufferNano paramCodedOutputByteBufferNano)
  {
    paramCodedOutputByteBufferNano.c(10, this.b);
    if ((this.e & 0x1) != 0) {
      paramCodedOutputByteBufferNano.a(11, this.g);
    }
    if ((this.e & 0x4) != 0) {
      paramCodedOutputByteBufferNano.b(12, this.f);
    }
    Object localObject = this.h;
    if (localObject != null) {
      paramCodedOutputByteBufferNano.b(15, (g)localObject);
    }
    localObject = this.d;
    if (localObject != null) {
      paramCodedOutputByteBufferNano.a(20, (cl)localObject);
    }
    if ((this.e & 0x2) != 0) {
      paramCodedOutputByteBufferNano.a(22, this.c);
    }
    localObject = this.i;
    if (localObject != null) {
      paramCodedOutputByteBufferNano.a(27, (cl)localObject);
    }
    super.a(paramCodedOutputByteBufferNano);
  }
  
  public final boolean equals(Object paramObject)
  {
    if (paramObject != this)
    {
      Object localObject;
      if ((paramObject instanceof du))
      {
        paramObject = (du)paramObject;
        if (this.b == ((du)paramObject).b)
        {
          int j = this.e;
          int k = ((du)paramObject).e;
          if (((j & 0x1) == (k & 0x1)) && (this.g == ((du)paramObject).g) && ((j & 0x2) == (k & 0x2)) && (this.c == ((du)paramObject).c))
          {
            localObject = this.i;
            if (localObject != null) {
              break label239;
            }
            if (((du)paramObject).i != null) {}
          }
        }
      }
      label225:
      label239:
      while (((bb)localObject).equals(((du)paramObject).i))
      {
        if (((this.e & 0x4) == (((du)paramObject).e & 0x4)) && (this.f == ((du)paramObject).f))
        {
          localObject = this.h;
          if (localObject != null) {
            break label225;
          }
          if (((du)paramObject).h != null) {}
        }
        while (((dv)localObject).equals(((du)paramObject).h))
        {
          localObject = this.d;
          if (localObject == null) {
            if (((du)paramObject).d != null) {}
          }
          while (((bb)localObject).equals(((du)paramObject).d))
          {
            localObject = this.unknownFieldData;
            if ((localObject == null) || (((d)localObject).a()))
            {
              paramObject = ((du)paramObject).unknownFieldData;
              return (paramObject == null) || (((d)paramObject).a());
            }
            return this.unknownFieldData.equals(((du)paramObject).unknownFieldData);
          }
          return false;
        }
        return false;
      }
      return false;
    }
    return true;
  }
  
  public final int hashCode()
  {
    int i2 = 0;
    int i3 = getClass().getName().hashCode();
    long l = this.b;
    int i4 = (int)(l ^ l >>> 32);
    int i5 = this.g;
    if (!this.c) {}
    for (int j = 1237;; j = 1231)
    {
      Object localObject = this.i;
      if (localObject != null) {}
      for (int k = ((bb)localObject).hashCode();; k = 0)
      {
        l = this.f;
        localObject = this.h;
        int i6 = (int)(l ^ l >>> 32);
        if (localObject != null) {}
        for (int m = ((dv)localObject).hashCode();; m = 0)
        {
          localObject = this.d;
          if (localObject != null) {}
          for (int n = ((bb)localObject).hashCode();; n = 0)
          {
            localObject = this.unknownFieldData;
            int i1 = i2;
            if (localObject != null)
            {
              i1 = i2;
              if (!((d)localObject).a()) {
                i1 = this.unknownFieldData.hashCode();
              }
            }
            return (n + (m + ((k + (j + (((i3 + 527) * 31 + i4) * 31 + i5) * 31) * 31) * 31 + i6) * 31) * 31) * 31 + i1;
          }
        }
      }
    }
  }
}


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/com/google/android/finsky/ds/a/du.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */