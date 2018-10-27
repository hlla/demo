package com.google.android.finsky.ds.a;

import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.b;
import com.google.protobuf.nano.d;
import com.google.protobuf.nano.f;
import com.google.protobuf.nano.g;
import com.google.protobuf.nano.j;

public final class u
  extends b
{
  public fb a = null;
  public bu b = null;
  public bu c = null;
  public String[] d = j.h;
  public String e = "";
  public String f = "";
  private int g = 0;
  private String h = "";
  
  public u()
  {
    this.unknownFieldData = null;
    this.cachedSize = -1;
  }
  
  protected final int a()
  {
    int j = 0;
    int i = super.a();
    Object localObject = this.d;
    int k;
    int m;
    if (localObject != null) {
      if (localObject.length > 0)
      {
        k = 0;
        m = 0;
        localObject = this.d;
        if (j >= localObject.length) {
          i = i + k + m;
        }
      }
    }
    for (;;)
    {
      j = i;
      if ((this.g & 0x1) != 0) {
        j = i + CodedOutputByteBufferNano.b(2, this.h);
      }
      localObject = this.a;
      i = j;
      if (localObject != null) {
        i = j + CodedOutputByteBufferNano.d(3, (g)localObject);
      }
      j = i;
      if ((this.g & 0x2) != 0) {
        j = i + CodedOutputByteBufferNano.b(4, this.f);
      }
      i = j;
      if ((this.g & 0x4) != 0) {
        i = j + CodedOutputByteBufferNano.b(5, this.e);
      }
      localObject = this.c;
      j = i;
      if (localObject != null) {
        j = i + CodedOutputByteBufferNano.d(6, (g)localObject);
      }
      localObject = this.b;
      i = j;
      if (localObject != null) {
        i = j + CodedOutputByteBufferNano.d(7, (g)localObject);
      }
      return i;
      localObject = localObject[j];
      int i1 = k;
      int n = m;
      if (localObject != null)
      {
        n = m + 1;
        i1 = k + CodedOutputByteBufferNano.a((String)localObject);
      }
      j += 1;
      k = i1;
      m = n;
      break;
    }
  }
  
  public final void a(CodedOutputByteBufferNano paramCodedOutputByteBufferNano)
  {
    Object localObject = this.d;
    if ((localObject == null) || (localObject.length <= 0)) {}
    int i;
    do
    {
      if ((this.g & 0x1) != 0) {
        paramCodedOutputByteBufferNano.a(2, this.h);
      }
      localObject = this.a;
      if (localObject != null) {
        paramCodedOutputByteBufferNano.b(3, (g)localObject);
      }
      if ((this.g & 0x2) != 0) {
        paramCodedOutputByteBufferNano.a(4, this.f);
      }
      if ((this.g & 0x4) != 0) {
        paramCodedOutputByteBufferNano.a(5, this.e);
      }
      localObject = this.c;
      if (localObject != null) {
        paramCodedOutputByteBufferNano.b(6, (g)localObject);
      }
      localObject = this.b;
      if (localObject != null) {
        paramCodedOutputByteBufferNano.b(7, (g)localObject);
      }
      super.a(paramCodedOutputByteBufferNano);
      return;
      i = 0;
      localObject = this.d;
    } while (i >= localObject.length);
    localObject = localObject[i];
    if (localObject == null) {}
    for (;;)
    {
      i += 1;
      break;
      paramCodedOutputByteBufferNano.a(1, (String)localObject);
    }
  }
  
  public final boolean equals(Object paramObject)
  {
    if (paramObject != this)
    {
      Object localObject;
      if ((paramObject instanceof u))
      {
        paramObject = (u)paramObject;
        if ((f.a(this.d, ((u)paramObject).d)) && ((this.g & 0x1) == (((u)paramObject).g & 0x1)) && (this.h.equals(((u)paramObject).h)))
        {
          localObject = this.a;
          if (localObject != null) {
            break label240;
          }
          if (((u)paramObject).a != null) {}
        }
      }
      label227:
      label240:
      while (((fb)localObject).equals(((u)paramObject).a))
      {
        if (((this.g & 0x2) == (((u)paramObject).g & 0x2)) && (this.f.equals(((u)paramObject).f)) && ((this.g & 0x4) == (((u)paramObject).g & 0x4)) && (this.e.equals(((u)paramObject).e)))
        {
          localObject = this.c;
          if (localObject != null) {
            break label227;
          }
          if (((u)paramObject).c != null) {}
        }
        while (((bu)localObject).equals(((u)paramObject).c))
        {
          localObject = this.b;
          if (localObject == null) {
            if (((u)paramObject).b != null) {}
          }
          while (((bu)localObject).equals(((u)paramObject).b))
          {
            localObject = this.unknownFieldData;
            if ((localObject == null) || (((d)localObject).a()))
            {
              paramObject = ((u)paramObject).unknownFieldData;
              return (paramObject == null) || (((d)paramObject).a());
            }
            return this.unknownFieldData.equals(((u)paramObject).unknownFieldData);
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
    int n = 0;
    int i1 = getClass().getName().hashCode();
    int i2 = f.a(this.d);
    int i3 = this.h.hashCode();
    Object localObject = this.a;
    if (localObject != null) {}
    for (int i = ((fb)localObject).hashCode();; i = 0)
    {
      int i4 = this.f.hashCode();
      int i5 = this.e.hashCode();
      localObject = this.c;
      if (localObject != null) {}
      for (int j = ((bu)localObject).hashCode();; j = 0)
      {
        localObject = this.b;
        if (localObject != null) {}
        for (int k = ((bu)localObject).hashCode();; k = 0)
        {
          localObject = this.unknownFieldData;
          int m = n;
          if (localObject != null)
          {
            m = n;
            if (!((d)localObject).a()) {
              m = this.unknownFieldData.hashCode();
            }
          }
          return (k + (j + (((i + (((i1 + 527) * 31 + i2) * 31 + i3) * 31) * 31 + i4) * 31 + i5) * 31) * 31) * 31 + m;
        }
      }
    }
  }
}


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/com/google/android/finsky/ds/a/u.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */