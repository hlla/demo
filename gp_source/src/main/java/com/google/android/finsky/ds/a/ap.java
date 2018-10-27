package com.google.android.finsky.ds.a;

import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.b;
import com.google.protobuf.nano.d;
import com.google.protobuf.nano.g;
import com.google.wireless.android.finsky.dfe.f.a.a;

public final class ap
  extends b
{
  public String a = "";
  public h b;
  public int c = 0;
  public String d;
  public hn e;
  public String f = "";
  public String g = "";
  public String h;
  public String i;
  public String j;
  public String k;
  private Integer l;
  private String m;
  private String n = "";
  private int o = 0;
  
  public ap()
  {
    if (a.a != null) {}
    for (Integer localInteger = Integer.valueOf(a.a.b);; localInteger = null)
    {
      this.l = localInteger;
      this.i = "";
      this.d = "";
      this.k = "";
      this.j = "";
      this.b = null;
      this.m = "";
      this.e = null;
      this.h = "";
      this.unknownFieldData = null;
      this.cachedSize = -1;
      return;
    }
  }
  
  protected final int a()
  {
    int i2 = super.a();
    int i1 = i2;
    if ((this.c & 0x1) != 0) {
      i1 = i2 + CodedOutputByteBufferNano.b(4, this.g);
    }
    i2 = i1;
    if ((this.c & 0x2) != 0) {
      i2 = i1 + CodedOutputByteBufferNano.b(5, this.f);
    }
    i1 = i2;
    if ((this.c & 0x4) != 0) {
      i1 = i2 + CodedOutputByteBufferNano.b(6, this.n);
    }
    i2 = i1;
    if ((this.c & 0x8) != 0) {
      i2 = i1 + CodedOutputByteBufferNano.d(7, this.o);
    }
    i1 = i2;
    if ((this.c & 0x10) != 0) {
      i1 = i2 + CodedOutputByteBufferNano.b(17, this.a);
    }
    i2 = i1;
    if ((this.c & 0x20) != 0)
    {
      localObject = this.l;
      i2 = i1;
      if (localObject != null) {
        i2 = i1 + CodedOutputByteBufferNano.d(27, ((Integer)localObject).intValue());
      }
    }
    i1 = i2;
    if ((this.c & 0x40) != 0) {
      i1 = i2 + CodedOutputByteBufferNano.b(28, this.i);
    }
    i2 = i1;
    if ((this.c & 0x80) != 0) {
      i2 = i1 + CodedOutputByteBufferNano.b(29, this.d);
    }
    i1 = i2;
    if ((this.c & 0x100) != 0) {
      i1 = i2 + CodedOutputByteBufferNano.b(30, this.k);
    }
    i2 = i1;
    if ((this.c & 0x200) != 0) {
      i2 = i1 + CodedOutputByteBufferNano.b(31, this.j);
    }
    Object localObject = this.b;
    i1 = i2;
    if (localObject != null) {
      i1 = i2 + CodedOutputByteBufferNano.d(32, (g)localObject);
    }
    i2 = i1;
    if ((this.c & 0x400) != 0) {
      i2 = i1 + CodedOutputByteBufferNano.b(33, this.m);
    }
    localObject = this.e;
    i1 = i2;
    if (localObject != null) {
      i1 = i2 + CodedOutputByteBufferNano.d(34, (g)localObject);
    }
    i2 = i1;
    if ((this.c & 0x800) != 0) {
      i2 = i1 + CodedOutputByteBufferNano.b(35, this.h);
    }
    return i2;
  }
  
  public final void a(CodedOutputByteBufferNano paramCodedOutputByteBufferNano)
  {
    if ((this.c & 0x1) != 0) {
      paramCodedOutputByteBufferNano.a(4, this.g);
    }
    if ((this.c & 0x2) != 0) {
      paramCodedOutputByteBufferNano.a(5, this.f);
    }
    if ((this.c & 0x4) != 0) {
      paramCodedOutputByteBufferNano.a(6, this.n);
    }
    if ((this.c & 0x8) != 0) {
      paramCodedOutputByteBufferNano.a(7, this.o);
    }
    if ((this.c & 0x10) != 0) {
      paramCodedOutputByteBufferNano.a(17, this.a);
    }
    if ((this.c & 0x20) != 0)
    {
      localObject = this.l;
      if (localObject != null) {
        paramCodedOutputByteBufferNano.a(27, ((Integer)localObject).intValue());
      }
    }
    if ((this.c & 0x40) != 0) {
      paramCodedOutputByteBufferNano.a(28, this.i);
    }
    if ((this.c & 0x80) != 0) {
      paramCodedOutputByteBufferNano.a(29, this.d);
    }
    if ((this.c & 0x100) != 0) {
      paramCodedOutputByteBufferNano.a(30, this.k);
    }
    if ((this.c & 0x200) != 0) {
      paramCodedOutputByteBufferNano.a(31, this.j);
    }
    Object localObject = this.b;
    if (localObject != null) {
      paramCodedOutputByteBufferNano.b(32, (g)localObject);
    }
    if ((this.c & 0x400) != 0) {
      paramCodedOutputByteBufferNano.a(33, this.m);
    }
    localObject = this.e;
    if (localObject != null) {
      paramCodedOutputByteBufferNano.b(34, (g)localObject);
    }
    if ((this.c & 0x800) != 0) {
      paramCodedOutputByteBufferNano.a(35, this.h);
    }
    super.a(paramCodedOutputByteBufferNano);
  }
  
  public final boolean equals(Object paramObject)
  {
    if (paramObject != this)
    {
      Object localObject;
      if ((paramObject instanceof ap))
      {
        paramObject = (ap)paramObject;
        if (((this.c & 0x1) == (((ap)paramObject).c & 0x1)) && (this.g.equals(((ap)paramObject).g)) && ((this.c & 0x2) == (((ap)paramObject).c & 0x2)) && (this.f.equals(((ap)paramObject).f)) && ((this.c & 0x4) == (((ap)paramObject).c & 0x4)) && (this.n.equals(((ap)paramObject).n)))
        {
          int i1 = this.c;
          int i2 = ((ap)paramObject).c;
          if (((i1 & 0x8) == (i2 & 0x8)) && (this.o == ((ap)paramObject).o) && ((i1 & 0x10) == (i2 & 0x10)) && (this.a.equals(((ap)paramObject).a)))
          {
            i1 = this.c;
            i2 = ((ap)paramObject).c;
            if (((i1 & 0x20) == (i2 & 0x20)) && (this.l == ((ap)paramObject).l) && ((i1 & 0x40) == (i2 & 0x40)) && (this.i.equals(((ap)paramObject).i)) && ((this.c & 0x80) == (((ap)paramObject).c & 0x80)) && (this.d.equals(((ap)paramObject).d)) && ((this.c & 0x100) == (((ap)paramObject).c & 0x100)) && (this.k.equals(((ap)paramObject).k)) && ((this.c & 0x200) == (((ap)paramObject).c & 0x200)) && (this.j.equals(((ap)paramObject).j)))
            {
              localObject = this.b;
              if (localObject != null) {
                break label484;
              }
              if (((ap)paramObject).b != null) {}
            }
          }
        }
      }
      label470:
      label484:
      while (((h)localObject).equals(((ap)paramObject).b))
      {
        if (((this.c & 0x400) == (((ap)paramObject).c & 0x400)) && (this.m.equals(((ap)paramObject).m)))
        {
          localObject = this.e;
          if (localObject != null) {
            break label470;
          }
          if (((ap)paramObject).e != null) {}
        }
        while (((hn)localObject).equals(((ap)paramObject).e))
        {
          if (((this.c & 0x800) == (((ap)paramObject).c & 0x800)) && (this.h.equals(((ap)paramObject).h)))
          {
            localObject = this.unknownFieldData;
            if ((localObject == null) || (((d)localObject).a())) {
              paramObject = ((ap)paramObject).unknownFieldData;
            }
          }
          else
          {
            return (paramObject == null) || (((d)paramObject).a());
          }
          return this.unknownFieldData.equals(((ap)paramObject).unknownFieldData);
        }
        return false;
      }
      return false;
    }
    return true;
  }
  
  public final int hashCode()
  {
    int i5 = 0;
    int i2 = (((((getClass().getName().hashCode() + 527) * 31 + this.g.hashCode()) * 31 + this.f.hashCode()) * 31 + this.n.hashCode()) * 31 + this.o) * 31 + this.a.hashCode();
    Object localObject = this.l;
    int i1 = i2;
    if (localObject != null) {
      i1 = i2 * 31 + ((Integer)localObject).intValue();
    }
    int i6 = this.i.hashCode();
    int i7 = this.d.hashCode();
    int i8 = this.k.hashCode();
    int i9 = this.j.hashCode();
    localObject = this.b;
    if (localObject != null) {}
    for (i2 = ((h)localObject).hashCode();; i2 = 0)
    {
      int i10 = this.m.hashCode();
      localObject = this.e;
      if (localObject != null) {}
      for (int i3 = ((hn)localObject).hashCode();; i3 = 0)
      {
        int i11 = this.h.hashCode();
        localObject = this.unknownFieldData;
        int i4 = i5;
        if (localObject != null)
        {
          i4 = i5;
          if (!((d)localObject).a()) {
            i4 = this.unknownFieldData.hashCode();
          }
        }
        return ((i3 + ((i2 + ((((i1 * 31 + i6) * 31 + i7) * 31 + i8) * 31 + i9) * 31) * 31 + i10) * 31) * 31 + i11) * 31 + i4;
      }
    }
  }
}


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/com/google/android/finsky/ds/a/ap.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */