package com.google.android.finsky.ds.a;

import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.b;
import com.google.protobuf.nano.d;
import com.google.protobuf.nano.g;

public final class nm
  extends b
{
  public fb a = null;
  public nn b = null;
  public String c = "";
  public String d = "";
  public String e = "";
  private int f = 0;
  private String g = "";
  
  public nm()
  {
    this.unknownFieldData = null;
    this.cachedSize = -1;
  }
  
  protected final int a()
  {
    int j = super.a();
    int i = j;
    if ((this.f & 0x1) != 0) {
      i = j + CodedOutputByteBufferNano.b(1, this.e);
    }
    j = i;
    if ((this.f & 0x2) != 0) {
      j = i + CodedOutputByteBufferNano.b(2, this.c);
    }
    i = j;
    if ((this.f & 0x4) != 0) {
      i = j + CodedOutputByteBufferNano.b(3, this.d);
    }
    Object localObject = this.a;
    j = i;
    if (localObject != null) {
      j = i + CodedOutputByteBufferNano.d(4, (g)localObject);
    }
    i = j;
    if ((this.f & 0x8) != 0) {
      i = j + CodedOutputByteBufferNano.b(5, this.g);
    }
    localObject = this.b;
    j = i;
    if (localObject != null) {
      j = i + CodedOutputByteBufferNano.d(6, (g)localObject);
    }
    return j;
  }
  
  public final void a(CodedOutputByteBufferNano paramCodedOutputByteBufferNano)
  {
    if ((this.f & 0x1) != 0) {
      paramCodedOutputByteBufferNano.a(1, this.e);
    }
    if ((this.f & 0x2) != 0) {
      paramCodedOutputByteBufferNano.a(2, this.c);
    }
    if ((this.f & 0x4) != 0) {
      paramCodedOutputByteBufferNano.a(3, this.d);
    }
    Object localObject = this.a;
    if (localObject != null) {
      paramCodedOutputByteBufferNano.b(4, (g)localObject);
    }
    if ((this.f & 0x8) != 0) {
      paramCodedOutputByteBufferNano.a(5, this.g);
    }
    localObject = this.b;
    if (localObject != null) {
      paramCodedOutputByteBufferNano.b(6, (g)localObject);
    }
    super.a(paramCodedOutputByteBufferNano);
  }
  
  public final boolean equals(Object paramObject)
  {
    if (paramObject != this)
    {
      Object localObject;
      if ((paramObject instanceof nm))
      {
        paramObject = (nm)paramObject;
        if (((this.f & 0x1) == (((nm)paramObject).f & 0x1)) && (this.e.equals(((nm)paramObject).e)) && ((this.f & 0x2) == (((nm)paramObject).f & 0x2)) && (this.c.equals(((nm)paramObject).c)) && ((this.f & 0x4) == (((nm)paramObject).f & 0x4)) && (this.d.equals(((nm)paramObject).d)))
        {
          localObject = this.a;
          if (localObject != null) {
            break label228;
          }
          if (((nm)paramObject).a != null) {}
        }
      }
      label215:
      label228:
      while (((fb)localObject).equals(((nm)paramObject).a))
      {
        if (((this.f & 0x8) == (((nm)paramObject).f & 0x8)) && (this.g.equals(((nm)paramObject).g)))
        {
          localObject = this.b;
          if (localObject != null) {
            break label215;
          }
          if (((nm)paramObject).b != null) {}
        }
        while (((nn)localObject).equals(((nm)paramObject).b))
        {
          localObject = this.unknownFieldData;
          if ((localObject == null) || (((d)localObject).a()))
          {
            paramObject = ((nm)paramObject).unknownFieldData;
            return (paramObject == null) || (((d)paramObject).a());
          }
          return this.unknownFieldData.equals(((nm)paramObject).unknownFieldData);
        }
        return false;
      }
      return false;
    }
    return true;
  }
  
  public final int hashCode()
  {
    int m = 0;
    int n = getClass().getName().hashCode();
    int i1 = this.e.hashCode();
    int i2 = this.c.hashCode();
    int i3 = this.d.hashCode();
    Object localObject = this.a;
    if (localObject != null) {}
    for (int i = ((fb)localObject).hashCode();; i = 0)
    {
      int i4 = this.g.hashCode();
      localObject = this.b;
      if (localObject != null) {}
      for (int j = ((nn)localObject).hashCode();; j = 0)
      {
        localObject = this.unknownFieldData;
        int k = m;
        if (localObject != null)
        {
          k = m;
          if (!((d)localObject).a()) {
            k = this.unknownFieldData.hashCode();
          }
        }
        return (j + ((i + ((((n + 527) * 31 + i1) * 31 + i2) * 31 + i3) * 31) * 31 + i4) * 31) * 31 + k;
      }
    }
  }
}


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/com/google/android/finsky/ds/a/nm.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */