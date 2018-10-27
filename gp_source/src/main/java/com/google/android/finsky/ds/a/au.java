package com.google.android.finsky.ds.a;

import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.b;
import com.google.protobuf.nano.d;
import com.google.protobuf.nano.f;
import com.google.protobuf.nano.j;
import java.util.Arrays;

public final class au
  extends b
{
  private static volatile au[] e;
  public at a = null;
  public String b = "";
  public byte[] c = j.b;
  public byte[] d = j.b;
  private int f = 0;
  private int g = 0;
  
  public au()
  {
    this.unknownFieldData = null;
    this.cachedSize = -1;
  }
  
  public static au[] b()
  {
    if (e == null) {}
    synchronized (f.a)
    {
      if (e == null) {
        e = new au[0];
      }
      return e;
    }
  }
  
  protected final int a()
  {
    int j = super.a();
    int i = j;
    if ((this.f & 0x1) != 0) {
      i = j + CodedOutputByteBufferNano.d(1, this.g);
    }
    j = i;
    if ((this.f & 0x2) != 0) {
      j = i + CodedOutputByteBufferNano.b(2, this.b);
    }
    at localat = this.a;
    i = j;
    if (localat != null) {
      i = j + CodedOutputByteBufferNano.d(3, localat);
    }
    j = i;
    if ((this.f & 0x4) != 0) {
      j = i + CodedOutputByteBufferNano.b(4, this.c);
    }
    i = j;
    if ((this.f & 0x8) != 0) {
      i = j + CodedOutputByteBufferNano.b(5, this.d);
    }
    return i;
  }
  
  public final void a(CodedOutputByteBufferNano paramCodedOutputByteBufferNano)
  {
    if ((this.f & 0x1) != 0) {
      paramCodedOutputByteBufferNano.a(1, this.g);
    }
    if ((this.f & 0x2) != 0) {
      paramCodedOutputByteBufferNano.a(2, this.b);
    }
    at localat = this.a;
    if (localat != null) {
      paramCodedOutputByteBufferNano.b(3, localat);
    }
    if ((this.f & 0x4) != 0) {
      paramCodedOutputByteBufferNano.a(4, this.c);
    }
    if ((this.f & 0x8) != 0) {
      paramCodedOutputByteBufferNano.a(5, this.d);
    }
    super.a(paramCodedOutputByteBufferNano);
  }
  
  public final boolean equals(Object paramObject)
  {
    if (paramObject != this)
    {
      Object localObject;
      if ((paramObject instanceof au))
      {
        paramObject = (au)paramObject;
        int i = this.f;
        int j = ((au)paramObject).f;
        if (((i & 0x1) == (j & 0x1)) && (this.g == ((au)paramObject).g) && ((i & 0x2) == (j & 0x2)) && (this.b.equals(((au)paramObject).b)))
        {
          localObject = this.a;
          if (localObject != null) {
            break label199;
          }
          if (((au)paramObject).a != null) {}
        }
      }
      label199:
      while (((at)localObject).equals(((au)paramObject).a))
      {
        if (((this.f & 0x4) == (((au)paramObject).f & 0x4)) && (Arrays.equals(this.c, ((au)paramObject).c)) && ((this.f & 0x8) == (((au)paramObject).f & 0x8)) && (Arrays.equals(this.d, ((au)paramObject).d)))
        {
          localObject = this.unknownFieldData;
          if ((localObject == null) || (((d)localObject).a())) {
            paramObject = ((au)paramObject).unknownFieldData;
          }
        }
        else
        {
          return (paramObject == null) || (((d)paramObject).a());
        }
        return this.unknownFieldData.equals(((au)paramObject).unknownFieldData);
      }
      return false;
    }
    return true;
  }
  
  public final int hashCode()
  {
    int k = 0;
    int m = getClass().getName().hashCode();
    int n = this.g;
    int i1 = this.b.hashCode();
    Object localObject = this.a;
    if (localObject != null) {}
    for (int i = ((at)localObject).hashCode();; i = 0)
    {
      int i2 = Arrays.hashCode(this.c);
      int i3 = Arrays.hashCode(this.d);
      localObject = this.unknownFieldData;
      int j = k;
      if (localObject != null)
      {
        j = k;
        if (!((d)localObject).a()) {
          j = this.unknownFieldData.hashCode();
        }
      }
      return (((i + (((m + 527) * 31 + n) * 31 + i1) * 31) * 31 + i2) * 31 + i3) * 31 + j;
    }
  }
}


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/com/google/android/finsky/ds/a/au.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */