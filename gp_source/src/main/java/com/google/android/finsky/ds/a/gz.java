package com.google.android.finsky.ds.a;

import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.b;
import com.google.protobuf.nano.d;
import com.google.protobuf.nano.f;
import com.google.protobuf.nano.g;

public final class gz
  extends b
{
  private int a = 0;
  private boolean b = false;
  private String c = "";
  private boolean d = false;
  private fb e = null;
  private String f = "";
  private lk[] g = lk.b();
  private String h = "";
  private String i = "";
  private String j = "";
  private bu k = null;
  private String l = "";
  
  public gz()
  {
    this.unknownFieldData = null;
    this.cachedSize = -1;
  }
  
  protected final int a()
  {
    int n = super.a();
    int m = n;
    if ((this.a & 0x1) != 0) {
      m = n + CodedOutputByteBufferNano.b(1, this.i);
    }
    n = m;
    if ((this.a & 0x4) != 0) {
      n = m + CodedOutputByteBufferNano.b(2, this.l);
    }
    m = n;
    if ((this.a & 0x8) != 0) {
      m = n + CodedOutputByteBufferNano.b(3, this.j);
    }
    n = m;
    if ((this.a & 0x10) != 0) {
      n = m + CodedOutputByteBufferNano.b(4, this.c);
    }
    m = n;
    if ((this.a & 0x20) != 0) {
      m = n + CodedOutputByteBufferNano.b(5, this.f);
    }
    n = m;
    if ((this.a & 0x40) != 0) {
      n = m + (CodedOutputByteBufferNano.d(48) + 1);
    }
    Object localObject = this.e;
    m = n;
    if (localObject != null) {
      m = n + CodedOutputByteBufferNano.d(7, (g)localObject);
    }
    n = m;
    if ((this.a & 0x80) != 0) {
      n = m + (CodedOutputByteBufferNano.d(64) + 1);
    }
    localObject = this.k;
    m = n;
    if (localObject != null) {
      m = n + CodedOutputByteBufferNano.d(9, (g)localObject);
    }
    localObject = this.g;
    n = m;
    if (localObject != null)
    {
      n = m;
      if (localObject.length > 0)
      {
        n = 0;
        for (;;)
        {
          localObject = this.g;
          if (n >= localObject.length) {
            break;
          }
          localObject = localObject[n];
          int i1 = m;
          if (localObject != null) {
            i1 = m + CodedOutputByteBufferNano.d(10, (g)localObject);
          }
          n += 1;
          m = i1;
        }
        n = m;
      }
    }
    m = n;
    if ((this.a & 0x2) != 0) {
      m = n + CodedOutputByteBufferNano.b(11, this.h);
    }
    return m;
  }
  
  public final void a(CodedOutputByteBufferNano paramCodedOutputByteBufferNano)
  {
    if ((this.a & 0x1) != 0) {
      paramCodedOutputByteBufferNano.a(1, this.i);
    }
    if ((this.a & 0x4) != 0) {
      paramCodedOutputByteBufferNano.a(2, this.l);
    }
    if ((this.a & 0x8) != 0) {
      paramCodedOutputByteBufferNano.a(3, this.j);
    }
    if ((this.a & 0x10) != 0) {
      paramCodedOutputByteBufferNano.a(4, this.c);
    }
    if ((this.a & 0x20) != 0) {
      paramCodedOutputByteBufferNano.a(5, this.f);
    }
    if ((this.a & 0x40) != 0) {
      paramCodedOutputByteBufferNano.a(6, this.b);
    }
    Object localObject = this.e;
    if (localObject != null) {
      paramCodedOutputByteBufferNano.b(7, (g)localObject);
    }
    if ((this.a & 0x80) != 0) {
      paramCodedOutputByteBufferNano.a(8, this.d);
    }
    localObject = this.k;
    if (localObject != null) {
      paramCodedOutputByteBufferNano.b(9, (g)localObject);
    }
    localObject = this.g;
    if ((localObject == null) || (localObject.length <= 0)) {}
    int m;
    do
    {
      if ((this.a & 0x2) != 0) {
        paramCodedOutputByteBufferNano.a(11, this.h);
      }
      super.a(paramCodedOutputByteBufferNano);
      return;
      m = 0;
      localObject = this.g;
    } while (m >= localObject.length);
    localObject = localObject[m];
    if (localObject == null) {}
    for (;;)
    {
      m += 1;
      break;
      paramCodedOutputByteBufferNano.b(10, (g)localObject);
    }
  }
  
  public final boolean equals(Object paramObject)
  {
    if (paramObject != this)
    {
      Object localObject;
      if ((paramObject instanceof gz))
      {
        paramObject = (gz)paramObject;
        if (((this.a & 0x1) == (((gz)paramObject).a & 0x1)) && (this.i.equals(((gz)paramObject).i)) && ((this.a & 0x2) == (((gz)paramObject).a & 0x2)) && (this.h.equals(((gz)paramObject).h)) && ((this.a & 0x4) == (((gz)paramObject).a & 0x4)) && (this.l.equals(((gz)paramObject).l)) && ((this.a & 0x8) == (((gz)paramObject).a & 0x8)) && (this.j.equals(((gz)paramObject).j)) && ((this.a & 0x10) == (((gz)paramObject).a & 0x10)) && (this.c.equals(((gz)paramObject).c)) && ((this.a & 0x20) == (((gz)paramObject).a & 0x20)) && (this.f.equals(((gz)paramObject).f)))
        {
          localObject = this.k;
          if (localObject != null) {
            break label362;
          }
          if (((gz)paramObject).k != null) {}
        }
      }
      label349:
      label362:
      while (((bu)localObject).equals(((gz)paramObject).k))
      {
        if (((this.a & 0x40) == (((gz)paramObject).a & 0x40)) && (this.b == ((gz)paramObject).b))
        {
          localObject = this.e;
          if (localObject != null) {
            break label349;
          }
          if (((gz)paramObject).e != null) {}
        }
        while (((fb)localObject).equals(((gz)paramObject).e))
        {
          if (((this.a & 0x80) == (((gz)paramObject).a & 0x80)) && (this.d == ((gz)paramObject).d) && (f.a(this.g, ((gz)paramObject).g)))
          {
            localObject = this.unknownFieldData;
            if ((localObject == null) || (((d)localObject).a())) {
              paramObject = ((gz)paramObject).unknownFieldData;
            }
          }
          else
          {
            return (paramObject == null) || (((d)paramObject).a());
          }
          return this.unknownFieldData.equals(((gz)paramObject).unknownFieldData);
        }
        return false;
      }
      return false;
    }
    return true;
  }
  
  public final int hashCode()
  {
    int i2 = 1237;
    int i4 = 0;
    int i5 = getClass().getName().hashCode();
    int i6 = this.i.hashCode();
    int i7 = this.h.hashCode();
    int i8 = this.l.hashCode();
    int i9 = this.j.hashCode();
    int i10 = this.c.hashCode();
    int i11 = this.f.hashCode();
    Object localObject = this.k;
    if (localObject != null) {}
    for (int m = ((bu)localObject).hashCode();; m = 0)
    {
      if (!this.b) {}
      for (int n = 1237;; n = 1231)
      {
        localObject = this.e;
        if (localObject != null) {}
        for (int i1 = ((fb)localObject).hashCode();; i1 = 0)
        {
          if (!this.d) {}
          for (;;)
          {
            int i12 = f.a(this.g);
            localObject = this.unknownFieldData;
            int i3 = i4;
            if (localObject != null)
            {
              i3 = i4;
              if (!((d)localObject).a()) {
                i3 = this.unknownFieldData.hashCode();
              }
            }
            return (((i1 + (n + (m + (((((((i5 + 527) * 31 + i6) * 31 + i7) * 31 + i8) * 31 + i9) * 31 + i10) * 31 + i11) * 31) * 31) * 31) * 31 + i2) * 31 + i12) * 31 + i3;
            i2 = 1231;
          }
        }
      }
    }
  }
}


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/com/google/android/finsky/ds/a/gz.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */