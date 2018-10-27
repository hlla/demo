package com.google.android.finsky.ds.a;

import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.b;
import com.google.protobuf.nano.d;
import com.google.protobuf.nano.f;
import com.google.protobuf.nano.j;
import java.util.Arrays;

public final class cs
  extends b
{
  private static volatile cs[] d;
  public byte[] a = j.b;
  public fb b = null;
  public String c = "";
  private int e = 0;
  
  public cs()
  {
    this.unknownFieldData = null;
    this.cachedSize = -1;
  }
  
  public static cs[] b()
  {
    if (d == null) {}
    synchronized (f.a)
    {
      if (d == null) {
        d = new cs[0];
      }
      return d;
    }
  }
  
  protected final int a()
  {
    int j = super.a();
    int i = j;
    if ((this.e & 0x1) != 0) {
      i = j + CodedOutputByteBufferNano.b(1, this.c);
    }
    fb localfb = this.b;
    j = i;
    if (localfb != null) {
      j = i + CodedOutputByteBufferNano.d(2, localfb);
    }
    i = j;
    if ((this.e & 0x2) != 0) {
      i = j + CodedOutputByteBufferNano.b(3, this.a);
    }
    return i;
  }
  
  public final void a(CodedOutputByteBufferNano paramCodedOutputByteBufferNano)
  {
    if ((this.e & 0x1) != 0) {
      paramCodedOutputByteBufferNano.a(1, this.c);
    }
    fb localfb = this.b;
    if (localfb != null) {
      paramCodedOutputByteBufferNano.b(2, localfb);
    }
    if ((this.e & 0x2) != 0) {
      paramCodedOutputByteBufferNano.a(3, this.a);
    }
    super.a(paramCodedOutputByteBufferNano);
  }
  
  public final boolean equals(Object paramObject)
  {
    if (paramObject != this)
    {
      Object localObject;
      if ((paramObject instanceof cs))
      {
        paramObject = (cs)paramObject;
        if (((this.e & 0x1) == (((cs)paramObject).e & 0x1)) && (this.c.equals(((cs)paramObject).c)))
        {
          localObject = this.b;
          if (localObject != null) {
            break label139;
          }
          if (((cs)paramObject).b != null) {}
        }
      }
      label139:
      while (((fb)localObject).equals(((cs)paramObject).b))
      {
        if (((this.e & 0x2) == (((cs)paramObject).e & 0x2)) && (Arrays.equals(this.a, ((cs)paramObject).a)))
        {
          localObject = this.unknownFieldData;
          if ((localObject == null) || (((d)localObject).a())) {
            paramObject = ((cs)paramObject).unknownFieldData;
          }
        }
        else
        {
          return (paramObject == null) || (((d)paramObject).a());
        }
        return this.unknownFieldData.equals(((cs)paramObject).unknownFieldData);
      }
      return false;
    }
    return true;
  }
  
  public final int hashCode()
  {
    int k = 0;
    int m = getClass().getName().hashCode();
    int n = this.c.hashCode();
    Object localObject = this.b;
    if (localObject != null) {}
    for (int i = ((fb)localObject).hashCode();; i = 0)
    {
      int i1 = Arrays.hashCode(this.a);
      localObject = this.unknownFieldData;
      int j = k;
      if (localObject != null)
      {
        j = k;
        if (!((d)localObject).a()) {
          j = this.unknownFieldData.hashCode();
        }
      }
      return ((i + ((m + 527) * 31 + n) * 31) * 31 + i1) * 31 + j;
    }
  }
}


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/com/google/android/finsky/ds/a/cs.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */