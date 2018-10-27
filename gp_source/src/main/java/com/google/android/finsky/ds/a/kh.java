package com.google.android.finsky.ds.a;

import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.b;
import com.google.protobuf.nano.d;
import com.google.protobuf.nano.j;
import java.util.Arrays;

public final class kh
  extends b
{
  private int a = 0;
  private String b = "";
  private String c = "";
  private bu d = null;
  private byte[] e = j.b;
  
  public kh()
  {
    this.unknownFieldData = null;
    this.cachedSize = -1;
  }
  
  protected final int a()
  {
    int j = super.a();
    int i = j;
    if ((this.a & 0x1) != 0) {
      i = j + CodedOutputByteBufferNano.b(1, this.c);
    }
    j = i;
    if ((this.a & 0x4) != 0) {
      j = i + CodedOutputByteBufferNano.b(2, this.e);
    }
    bu localbu = this.d;
    i = j;
    if (localbu != null) {
      i = j + CodedOutputByteBufferNano.d(3, localbu);
    }
    j = i;
    if ((this.a & 0x2) != 0) {
      j = i + CodedOutputByteBufferNano.b(4, this.b);
    }
    return j;
  }
  
  public final void a(CodedOutputByteBufferNano paramCodedOutputByteBufferNano)
  {
    if ((this.a & 0x1) != 0) {
      paramCodedOutputByteBufferNano.a(1, this.c);
    }
    if ((this.a & 0x4) != 0) {
      paramCodedOutputByteBufferNano.a(2, this.e);
    }
    bu localbu = this.d;
    if (localbu != null) {
      paramCodedOutputByteBufferNano.b(3, localbu);
    }
    if ((this.a & 0x2) != 0) {
      paramCodedOutputByteBufferNano.a(4, this.b);
    }
    super.a(paramCodedOutputByteBufferNano);
  }
  
  public final boolean equals(Object paramObject)
  {
    if (paramObject != this)
    {
      Object localObject;
      if ((paramObject instanceof kh))
      {
        paramObject = (kh)paramObject;
        if (((this.a & 0x1) == (((kh)paramObject).a & 0x1)) && (this.c.equals(((kh)paramObject).c)) && ((this.a & 0x2) == (((kh)paramObject).a & 0x2)) && (this.b.equals(((kh)paramObject).b)) && ((this.a & 0x4) == (((kh)paramObject).a & 0x4)) && (Arrays.equals(this.e, ((kh)paramObject).e)))
        {
          localObject = this.d;
          if (localObject != null) {
            break label168;
          }
          if (((kh)paramObject).d != null) {}
        }
      }
      label168:
      while (((bu)localObject).equals(((kh)paramObject).d))
      {
        localObject = this.unknownFieldData;
        if ((localObject == null) || (((d)localObject).a()))
        {
          paramObject = ((kh)paramObject).unknownFieldData;
          return (paramObject == null) || (((d)paramObject).a());
        }
        return this.unknownFieldData.equals(((kh)paramObject).unknownFieldData);
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
    int i1 = this.b.hashCode();
    int i2 = Arrays.hashCode(this.e);
    Object localObject = this.d;
    if (localObject != null) {}
    for (int i = ((bu)localObject).hashCode();; i = 0)
    {
      localObject = this.unknownFieldData;
      int j = k;
      if (localObject != null)
      {
        j = k;
        if (!((d)localObject).a()) {
          j = this.unknownFieldData.hashCode();
        }
      }
      return (i + ((((m + 527) * 31 + n) * 31 + i1) * 31 + i2) * 31) * 31 + j;
    }
  }
}


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/com/google/android/finsky/ds/a/kh.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */