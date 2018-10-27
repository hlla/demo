package com.google.android.finsky.ds.a;

import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.b;
import com.google.protobuf.nano.d;
import com.google.protobuf.nano.j;
import java.util.Arrays;

public final class ln
  extends b
{
  public String a = "";
  public fb b = null;
  public byte[] c = j.b;
  public String d = "";
  private int e = 0;
  
  public ln()
  {
    this.unknownFieldData = null;
    this.cachedSize = -1;
  }
  
  protected final int a()
  {
    int j = super.a();
    int i = j;
    if ((this.e & 0x1) != 0) {
      i = j + CodedOutputByteBufferNano.b(1, this.d);
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
    j = i;
    if ((this.e & 0x4) != 0) {
      j = i + CodedOutputByteBufferNano.b(4, this.c);
    }
    return j;
  }
  
  public final void a(CodedOutputByteBufferNano paramCodedOutputByteBufferNano)
  {
    if ((this.e & 0x1) != 0) {
      paramCodedOutputByteBufferNano.a(1, this.d);
    }
    fb localfb = this.b;
    if (localfb != null) {
      paramCodedOutputByteBufferNano.b(2, localfb);
    }
    if ((this.e & 0x2) != 0) {
      paramCodedOutputByteBufferNano.a(3, this.a);
    }
    if ((this.e & 0x4) != 0) {
      paramCodedOutputByteBufferNano.a(4, this.c);
    }
    super.a(paramCodedOutputByteBufferNano);
  }
  
  public final boolean equals(Object paramObject)
  {
    if (paramObject != this)
    {
      Object localObject;
      if ((paramObject instanceof ln))
      {
        paramObject = (ln)paramObject;
        if (((this.e & 0x1) == (((ln)paramObject).e & 0x1)) && (this.d.equals(((ln)paramObject).d)))
        {
          localObject = this.b;
          if (localObject != null) {
            break label168;
          }
          if (((ln)paramObject).b != null) {}
        }
      }
      label168:
      while (((fb)localObject).equals(((ln)paramObject).b))
      {
        if (((this.e & 0x2) == (((ln)paramObject).e & 0x2)) && (this.a.equals(((ln)paramObject).a)) && ((this.e & 0x4) == (((ln)paramObject).e & 0x4)) && (Arrays.equals(this.c, ((ln)paramObject).c)))
        {
          localObject = this.unknownFieldData;
          if ((localObject == null) || (((d)localObject).a())) {
            paramObject = ((ln)paramObject).unknownFieldData;
          }
        }
        else
        {
          return (paramObject == null) || (((d)paramObject).a());
        }
        return this.unknownFieldData.equals(((ln)paramObject).unknownFieldData);
      }
      return false;
    }
    return true;
  }
  
  public final int hashCode()
  {
    int k = 0;
    int m = getClass().getName().hashCode();
    int n = this.d.hashCode();
    Object localObject = this.b;
    if (localObject != null) {}
    for (int i = ((fb)localObject).hashCode();; i = 0)
    {
      int i1 = this.a.hashCode();
      int i2 = Arrays.hashCode(this.c);
      localObject = this.unknownFieldData;
      int j = k;
      if (localObject != null)
      {
        j = k;
        if (!((d)localObject).a()) {
          j = this.unknownFieldData.hashCode();
        }
      }
      return (((i + ((m + 527) * 31 + n) * 31) * 31 + i1) * 31 + i2) * 31 + j;
    }
  }
}


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/com/google/android/finsky/ds/a/ln.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */