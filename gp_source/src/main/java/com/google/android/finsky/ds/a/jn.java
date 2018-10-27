package com.google.android.finsky.ds.a;

import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.a;
import com.google.protobuf.nano.b;
import com.google.protobuf.nano.d;

public final class jn
  extends b
{
  public int a = 0;
  public String b = "";
  public int c = 1;
  public String d = "";
  
  public jn()
  {
    this.unknownFieldData = null;
    this.cachedSize = -1;
  }
  
  private final jn b(a parama)
  {
    for (;;)
    {
      int i = parama.a();
      switch (i)
      {
      default: 
        if (super.a(parama, i)) {}
        break;
      case 0: 
        return this;
      case 26: 
        this.d = parama.c();
        this.a |= 0x4;
        break;
      case 18: 
        this.b = parama.c();
        this.a |= 0x2;
        break;
      case 8: 
        this.a |= 0x1;
        int j = parama.j();
        int k;
        do
        {
          try
          {
            k = parama.e();
            if (k > 0) {
              continue;
            }
            StringBuilder localStringBuilder = new StringBuilder(52);
            localStringBuilder.append(k);
            localStringBuilder.append(" is not a valid enum RemoteEscalationType");
            throw new IllegalArgumentException(localStringBuilder.toString());
          }
          catch (IllegalArgumentException localIllegalArgumentException)
          {
            parama.e(j);
            a(parama, i);
          }
          break;
        } while (k > 2);
        this.c = k;
        this.a |= 0x1;
      }
    }
  }
  
  protected final int a()
  {
    int j = super.a();
    int i = j;
    if ((this.a & 0x1) != 0) {
      i = j + CodedOutputByteBufferNano.d(1, this.c);
    }
    j = i;
    if ((this.a & 0x2) != 0) {
      j = i + CodedOutputByteBufferNano.b(2, this.b);
    }
    i = j;
    if ((this.a & 0x4) != 0) {
      i = j + CodedOutputByteBufferNano.b(3, this.d);
    }
    return i;
  }
  
  public final void a(CodedOutputByteBufferNano paramCodedOutputByteBufferNano)
  {
    if ((this.a & 0x1) != 0) {
      paramCodedOutputByteBufferNano.a(1, this.c);
    }
    if ((this.a & 0x2) != 0) {
      paramCodedOutputByteBufferNano.a(2, this.b);
    }
    if ((this.a & 0x4) != 0) {
      paramCodedOutputByteBufferNano.a(3, this.d);
    }
    super.a(paramCodedOutputByteBufferNano);
  }
  
  public final boolean equals(Object paramObject)
  {
    if (paramObject != this)
    {
      if ((paramObject instanceof jn))
      {
        paramObject = (jn)paramObject;
        int i = this.a;
        int j = ((jn)paramObject).a;
        if (((i & 0x1) == (j & 0x1)) && (this.c == ((jn)paramObject).c) && ((i & 0x2) == (j & 0x2)) && (this.b.equals(((jn)paramObject).b)) && ((this.a & 0x4) == (((jn)paramObject).a & 0x4)) && (this.d.equals(((jn)paramObject).d)))
        {
          d locald = this.unknownFieldData;
          if ((locald != null) && (!locald.a())) {
            break label138;
          }
          paramObject = ((jn)paramObject).unknownFieldData;
        }
      }
      return (paramObject == null) || (((d)paramObject).a());
      label138:
      return this.unknownFieldData.equals(((jn)paramObject).unknownFieldData);
    }
    return true;
  }
  
  public final int hashCode()
  {
    int j = 0;
    int k = getClass().getName().hashCode();
    int m = this.c;
    int n = this.b.hashCode();
    int i1 = this.d.hashCode();
    d locald = this.unknownFieldData;
    int i = j;
    if (locald != null)
    {
      i = j;
      if (!locald.a()) {
        i = this.unknownFieldData.hashCode();
      }
    }
    return i + ((((k + 527) * 31 + m) * 31 + n) * 31 + i1) * 31;
  }
}


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/com/google/android/finsky/ds/a/jn.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */