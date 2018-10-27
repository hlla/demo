package com.google.android.finsky.ds.a;

import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.a;
import com.google.protobuf.nano.b;
import com.google.protobuf.nano.d;

public final class dy
  extends b
{
  public String a = "";
  public int b = 0;
  public boolean c = false;
  private int d = 0;
  
  public dy()
  {
    this.unknownFieldData = null;
    this.cachedSize = -1;
  }
  
  private final dy b(a parama)
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
      case 24: 
        this.c = parama.b();
        this.d |= 0x4;
        break;
      case 18: 
        this.a = parama.c();
        this.d |= 0x2;
        break;
      case 8: 
        this.d |= 0x1;
        int j = parama.j();
        int k;
        do
        {
          try
          {
            k = parama.e();
            if (k >= 0) {
              continue;
            }
            StringBuilder localStringBuilder = new StringBuilder(41);
            localStringBuilder.append(k);
            localStringBuilder.append(" is not a valid enum Treatment");
            throw new IllegalArgumentException(localStringBuilder.toString());
          }
          catch (IllegalArgumentException localIllegalArgumentException)
          {
            parama.e(j);
            a(parama, i);
          }
          break;
        } while (k > 3);
        this.b = k;
        this.d |= 0x1;
      }
    }
  }
  
  protected final int a()
  {
    int j = super.a();
    int i = j;
    if ((this.d & 0x1) != 0) {
      i = j + CodedOutputByteBufferNano.d(1, this.b);
    }
    j = i;
    if ((this.d & 0x2) != 0) {
      j = i + CodedOutputByteBufferNano.b(2, this.a);
    }
    i = j;
    if ((this.d & 0x4) != 0) {
      i = j + (CodedOutputByteBufferNano.d(24) + 1);
    }
    return i;
  }
  
  public final void a(CodedOutputByteBufferNano paramCodedOutputByteBufferNano)
  {
    if ((this.d & 0x1) != 0) {
      paramCodedOutputByteBufferNano.a(1, this.b);
    }
    if ((this.d & 0x2) != 0) {
      paramCodedOutputByteBufferNano.a(2, this.a);
    }
    if ((this.d & 0x4) != 0) {
      paramCodedOutputByteBufferNano.a(3, this.c);
    }
    super.a(paramCodedOutputByteBufferNano);
  }
  
  public final boolean equals(Object paramObject)
  {
    if (paramObject != this)
    {
      if ((paramObject instanceof dy))
      {
        paramObject = (dy)paramObject;
        int i = this.d;
        int j = ((dy)paramObject).d;
        if (((i & 0x1) == (j & 0x1)) && (this.b == ((dy)paramObject).b) && ((i & 0x2) == (j & 0x2)) && (this.a.equals(((dy)paramObject).a)) && ((this.d & 0x4) == (((dy)paramObject).d & 0x4)) && (this.c == ((dy)paramObject).c))
        {
          d locald = this.unknownFieldData;
          if ((locald != null) && (!locald.a())) {
            break label135;
          }
          paramObject = ((dy)paramObject).unknownFieldData;
        }
      }
      return (paramObject == null) || (((d)paramObject).a());
      label135:
      return this.unknownFieldData.equals(((dy)paramObject).unknownFieldData);
    }
    return true;
  }
  
  public final int hashCode()
  {
    int k = getClass().getName().hashCode();
    int m = this.b;
    int n = this.a.hashCode();
    if (!this.c) {}
    for (int j = 1237;; j = 1231)
    {
      d locald = this.unknownFieldData;
      int i;
      if (locald != null) {
        if (!locald.a()) {
          i = this.unknownFieldData.hashCode();
        }
      }
      for (;;)
      {
        return i + (j + (((k + 527) * 31 + m) * 31 + n) * 31) * 31;
        i = 0;
        continue;
        i = 0;
      }
    }
  }
}


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/com/google/android/finsky/ds/a/dy.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */