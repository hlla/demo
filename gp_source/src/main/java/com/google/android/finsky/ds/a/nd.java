package com.google.android.finsky.ds.a;

import com.google.protobuf.CodedOutputStream;
import com.google.protobuf.cl;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.b;
import com.google.protobuf.nano.d;
import com.google.protobuf.nano.f;
import com.google.protobuf.nano.g;
import com.google.protobuf.nano.j;
import com.google.wireless.android.finsky.dfe.s.a.a;

public final class nd
  extends b
{
  public String a = "";
  public int b = 0;
  public String c = "";
  public nc[] d = nc.b();
  public String e = "";
  public String f = "";
  public String g = "";
  public nl[] h = nl.b();
  private String i = "";
  private long j = 0L;
  private String[] k = j.h;
  private long l = 0L;
  private a[] m = new a[0];
  
  public nd()
  {
    this.unknownFieldData = null;
    this.cachedSize = -1;
  }
  
  protected final int a()
  {
    int i6 = 0;
    int i1 = super.a();
    Object localObject = this.d;
    int n = i1;
    int i2;
    if (localObject != null)
    {
      n = i1;
      if (localObject.length > 0)
      {
        n = i1;
        i1 = 0;
        for (;;)
        {
          localObject = this.d;
          if (i1 >= localObject.length) {
            break;
          }
          localObject = localObject[i1];
          i2 = n;
          if (localObject != null) {
            i2 = n + CodedOutputByteBufferNano.d(1, (g)localObject);
          }
          i1 += 1;
          n = i2;
        }
      }
    }
    i1 = n;
    if ((this.b & 0x1) != 0) {
      i1 = n + CodedOutputByteBufferNano.b(2, this.f);
    }
    n = i1;
    if ((this.b & 0x2) != 0) {
      n = i1 + CodedOutputByteBufferNano.b(3, this.g);
    }
    i1 = n;
    if ((this.b & 0x4) != 0) {
      i1 = n + CodedOutputByteBufferNano.b(4, this.c);
    }
    n = i1;
    if ((this.b & 0x8) != 0) {
      n = i1 + CodedOutputByteBufferNano.f(5, this.l);
    }
    if ((this.b & 0x10) != 0) {
      n += CodedOutputByteBufferNano.f(6, this.j);
    }
    for (;;)
    {
      localObject = this.k;
      int i3;
      if (localObject != null) {
        if (localObject.length > 0)
        {
          i1 = 0;
          i2 = 0;
          i3 = 0;
          localObject = this.k;
          if (i1 >= localObject.length) {
            n = n + i2 + i3;
          }
        }
      }
      for (;;)
      {
        localObject = this.m;
        i1 = n;
        if (localObject != null)
        {
          i1 = n;
          if (localObject.length > 0)
          {
            i1 = 0;
            for (;;)
            {
              localObject = this.m;
              if (i1 >= localObject.length) {
                break;
              }
              localObject = localObject[i1];
              i2 = n;
              if (localObject != null) {
                i2 = n + CodedOutputStream.c(8, (cl)localObject);
              }
              i1 += 1;
              n = i2;
            }
            i1 = n;
          }
        }
        i2 = i1;
        if ((this.b & 0x20) != 0) {
          i2 = i1 + CodedOutputByteBufferNano.b(12, this.a);
        }
        n = i2;
        if ((this.b & 0x40) != 0) {
          n = i2 + CodedOutputByteBufferNano.b(13, this.i);
        }
        localObject = this.h;
        i1 = n;
        if (localObject != null)
        {
          i1 = n;
          if (localObject.length > 0)
          {
            i2 = i6;
            for (;;)
            {
              localObject = this.h;
              i1 = n;
              if (i2 >= localObject.length) {
                break;
              }
              localObject = localObject[i2];
              i1 = n;
              if (localObject != null) {
                i1 = n + CodedOutputByteBufferNano.d(14, (g)localObject);
              }
              i2 += 1;
              n = i1;
            }
          }
        }
        n = i1;
        if ((this.b & 0x80) != 0) {
          n = i1 + CodedOutputByteBufferNano.b(15, this.e);
        }
        return n;
        localObject = localObject[i1];
        int i5 = i2;
        int i4 = i3;
        if (localObject != null)
        {
          i4 = i3 + 1;
          i5 = i2 + CodedOutputByteBufferNano.a((String)localObject);
        }
        i1 += 1;
        i2 = i5;
        i3 = i4;
        break;
      }
    }
  }
  
  public final void a(CodedOutputByteBufferNano paramCodedOutputByteBufferNano)
  {
    int i1 = 0;
    Object localObject = this.d;
    if ((localObject == null) || (localObject.length <= 0)) {}
    int n;
    label232:
    do
    {
      if ((this.b & 0x1) != 0) {
        paramCodedOutputByteBufferNano.a(2, this.f);
      }
      if ((this.b & 0x2) != 0) {
        paramCodedOutputByteBufferNano.a(3, this.g);
      }
      if ((this.b & 0x4) != 0) {
        paramCodedOutputByteBufferNano.a(4, this.c);
      }
      if ((this.b & 0x8) != 0) {
        paramCodedOutputByteBufferNano.b(5, this.l);
      }
      if ((this.b & 0x10) != 0) {
        paramCodedOutputByteBufferNano.b(6, this.j);
      }
      localObject = this.k;
      if ((localObject == null) || (localObject.length <= 0)) {}
      do
      {
        localObject = this.m;
        if ((localObject == null) || (localObject.length <= 0)) {}
        do
        {
          if ((this.b & 0x20) != 0) {
            paramCodedOutputByteBufferNano.a(12, this.a);
          }
          if ((this.b & 0x40) != 0) {
            paramCodedOutputByteBufferNano.a(13, this.i);
          }
          localObject = this.h;
          if (localObject != null)
          {
            n = i1;
            if (localObject.length > 0) {
              break label232;
            }
          }
          do
          {
            if ((this.b & 0x80) != 0) {
              paramCodedOutputByteBufferNano.a(15, this.e);
            }
            super.a(paramCodedOutputByteBufferNano);
            return;
            localObject = this.h;
          } while (n >= localObject.length);
          localObject = localObject[n];
          if (localObject == null) {}
          for (;;)
          {
            n += 1;
            break;
            paramCodedOutputByteBufferNano.b(14, (g)localObject);
          }
          n = 0;
          localObject = this.m;
        } while (n >= localObject.length);
        localObject = localObject[n];
        if (localObject == null) {}
        for (;;)
        {
          n += 1;
          break;
          paramCodedOutputByteBufferNano.a(8, (cl)localObject);
        }
        n = 0;
        localObject = this.k;
      } while (n >= localObject.length);
      localObject = localObject[n];
      if (localObject == null) {}
      for (;;)
      {
        n += 1;
        break;
        paramCodedOutputByteBufferNano.a(7, (String)localObject);
      }
      n = 0;
      localObject = this.d;
    } while (n >= localObject.length);
    localObject = localObject[n];
    if (localObject == null) {}
    for (;;)
    {
      n += 1;
      break;
      paramCodedOutputByteBufferNano.b(1, (g)localObject);
    }
  }
  
  public final boolean equals(Object paramObject)
  {
    if (paramObject != this)
    {
      if ((paramObject instanceof nd))
      {
        paramObject = (nd)paramObject;
        if ((f.a(this.d, ((nd)paramObject).d)) && ((this.b & 0x1) == (((nd)paramObject).b & 0x1)) && (this.f.equals(((nd)paramObject).f)) && ((this.b & 0x2) == (((nd)paramObject).b & 0x2)) && (this.g.equals(((nd)paramObject).g)) && ((this.b & 0x4) == (((nd)paramObject).b & 0x4)) && (this.c.equals(((nd)paramObject).c)))
        {
          int n = this.b;
          int i1 = ((nd)paramObject).b;
          if (((n & 0x8) == (i1 & 0x8)) && (this.l == ((nd)paramObject).l) && ((n & 0x10) == (i1 & 0x10)) && (this.j == ((nd)paramObject).j) && (f.a(this.k, ((nd)paramObject).k)) && (f.a(this.m, ((nd)paramObject).m)) && ((this.b & 0x20) == (((nd)paramObject).b & 0x20)) && (this.a.equals(((nd)paramObject).a)) && ((this.b & 0x40) == (((nd)paramObject).b & 0x40)) && (this.i.equals(((nd)paramObject).i)) && (f.a(this.h, ((nd)paramObject).h)) && ((this.b & 0x80) == (((nd)paramObject).b & 0x80)) && (this.e.equals(((nd)paramObject).e)))
          {
            d locald = this.unknownFieldData;
            if ((locald != null) && (!locald.a())) {
              break label350;
            }
            paramObject = ((nd)paramObject).unknownFieldData;
          }
        }
      }
      return (paramObject == null) || (((d)paramObject).a());
      label350:
      return this.unknownFieldData.equals(((nd)paramObject).unknownFieldData);
    }
    return true;
  }
  
  public final int hashCode()
  {
    int i1 = 0;
    int i2 = getClass().getName().hashCode();
    int i3 = f.a(this.d);
    int i4 = this.f.hashCode();
    int i5 = this.g.hashCode();
    int i6 = this.c.hashCode();
    long l1 = this.l;
    long l2 = this.j;
    int i7 = (int)(l1 >>> 32 ^ l1);
    int i8 = (int)(l2 >>> 32 ^ l2);
    int i9 = f.a(this.k);
    int i10 = f.a(this.m);
    int i11 = this.a.hashCode();
    int i12 = this.i.hashCode();
    int i13 = f.a(this.h);
    int i14 = this.e.hashCode();
    d locald = this.unknownFieldData;
    int n = i1;
    if (locald != null)
    {
      n = i1;
      if (!locald.a()) {
        n = this.unknownFieldData.hashCode();
      }
    }
    return n + (((((((((((((i2 + 527) * 31 + i3) * 31 + i4) * 31 + i5) * 31 + i6) * 31 + i7) * 31 + i8) * 31 + i9) * 31 + i10) * 31 + i11) * 31 + i12) * 31 + i13) * 31 + i14) * 31;
  }
}


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/com/google/android/finsky/ds/a/nd.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */