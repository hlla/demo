package com.google.android.finsky.ds.a;

import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.b;
import com.google.protobuf.nano.d;
import com.google.protobuf.nano.f;
import com.google.protobuf.nano.g;
import com.google.protobuf.nano.j;
import java.util.Arrays;

public final class ck
  extends b
{
  public String a = "";
  public ds[] b = ds.b();
  public String c = "";
  public fb d = null;
  public String e = "";
  public byte[] f = j.b;
  private int g = 0;
  private String h = "";
  
  public ck()
  {
    this.unknownFieldData = null;
    this.cachedSize = -1;
  }
  
  protected final int a()
  {
    int j = super.a();
    int i = j;
    if ((this.g & 0x1) != 0) {
      i = j + CodedOutputByteBufferNano.b(1, this.h);
    }
    j = i;
    if ((this.g & 0x2) != 0) {
      j = i + CodedOutputByteBufferNano.b(2, this.c);
    }
    i = j;
    if ((this.g & 0x4) != 0) {
      i = j + CodedOutputByteBufferNano.b(3, this.e);
    }
    Object localObject = this.b;
    j = i;
    if (localObject != null)
    {
      j = i;
      if (localObject.length > 0)
      {
        j = 0;
        for (;;)
        {
          localObject = this.b;
          if (j >= localObject.length) {
            break;
          }
          localObject = localObject[j];
          int k = i;
          if (localObject != null) {
            k = i + CodedOutputByteBufferNano.d(4, (g)localObject);
          }
          j += 1;
          i = k;
        }
        j = i;
      }
    }
    localObject = this.d;
    i = j;
    if (localObject != null) {
      i = j + CodedOutputByteBufferNano.d(5, (g)localObject);
    }
    j = i;
    if ((this.g & 0x8) != 0) {
      j = i + CodedOutputByteBufferNano.b(6, this.f);
    }
    i = j;
    if ((this.g & 0x10) != 0) {
      i = j + CodedOutputByteBufferNano.b(7, this.a);
    }
    return i;
  }
  
  public final void a(CodedOutputByteBufferNano paramCodedOutputByteBufferNano)
  {
    if ((this.g & 0x1) != 0) {
      paramCodedOutputByteBufferNano.a(1, this.h);
    }
    if ((this.g & 0x2) != 0) {
      paramCodedOutputByteBufferNano.a(2, this.c);
    }
    if ((this.g & 0x4) != 0) {
      paramCodedOutputByteBufferNano.a(3, this.e);
    }
    Object localObject = this.b;
    if ((localObject == null) || (localObject.length <= 0)) {}
    int i;
    do
    {
      localObject = this.d;
      if (localObject != null) {
        paramCodedOutputByteBufferNano.b(5, (g)localObject);
      }
      if ((this.g & 0x8) != 0) {
        paramCodedOutputByteBufferNano.a(6, this.f);
      }
      if ((this.g & 0x10) != 0) {
        paramCodedOutputByteBufferNano.a(7, this.a);
      }
      super.a(paramCodedOutputByteBufferNano);
      return;
      i = 0;
      localObject = this.b;
    } while (i >= localObject.length);
    localObject = localObject[i];
    if (localObject == null) {}
    for (;;)
    {
      i += 1;
      break;
      paramCodedOutputByteBufferNano.b(4, (g)localObject);
    }
  }
  
  public final boolean equals(Object paramObject)
  {
    if (paramObject != this)
    {
      Object localObject;
      if ((paramObject instanceof ck))
      {
        paramObject = (ck)paramObject;
        if (((this.g & 0x1) == (((ck)paramObject).g & 0x1)) && (this.h.equals(((ck)paramObject).h)) && ((this.g & 0x2) == (((ck)paramObject).g & 0x2)) && (this.c.equals(((ck)paramObject).c)) && ((this.g & 0x4) == (((ck)paramObject).g & 0x4)) && (this.e.equals(((ck)paramObject).e)) && (f.a(this.b, ((ck)paramObject).b)))
        {
          localObject = this.d;
          if (localObject != null) {
            break label244;
          }
          if (((ck)paramObject).d != null) {}
        }
      }
      label244:
      while (((fb)localObject).equals(((ck)paramObject).d))
      {
        if (((this.g & 0x8) == (((ck)paramObject).g & 0x8)) && (Arrays.equals(this.f, ((ck)paramObject).f)) && ((this.g & 0x10) == (((ck)paramObject).g & 0x10)) && (this.a.equals(((ck)paramObject).a)))
        {
          localObject = this.unknownFieldData;
          if ((localObject == null) || (((d)localObject).a())) {
            paramObject = ((ck)paramObject).unknownFieldData;
          }
        }
        else
        {
          return (paramObject == null) || (((d)paramObject).a());
        }
        return this.unknownFieldData.equals(((ck)paramObject).unknownFieldData);
      }
      return false;
    }
    return true;
  }
  
  public final int hashCode()
  {
    int k = 0;
    int m = getClass().getName().hashCode();
    int n = this.h.hashCode();
    int i1 = this.c.hashCode();
    int i2 = this.e.hashCode();
    int i3 = f.a(this.b);
    Object localObject = this.d;
    if (localObject != null) {}
    for (int i = ((fb)localObject).hashCode();; i = 0)
    {
      int i4 = Arrays.hashCode(this.f);
      int i5 = this.a.hashCode();
      localObject = this.unknownFieldData;
      int j = k;
      if (localObject != null)
      {
        j = k;
        if (!((d)localObject).a()) {
          j = this.unknownFieldData.hashCode();
        }
      }
      return (((i + (((((m + 527) * 31 + n) * 31 + i1) * 31 + i2) * 31 + i3) * 31) * 31 + i4) * 31 + i5) * 31 + j;
    }
  }
}


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/com/google/android/finsky/ds/a/ck.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */