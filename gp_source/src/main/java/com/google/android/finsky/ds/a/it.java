package com.google.android.finsky.ds.a;

import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.a;
import com.google.protobuf.nano.b;
import com.google.protobuf.nano.j;
import java.util.Arrays;

public final class it
  extends b
{
  public d a = null;
  public String b = "";
  public int c = 0;
  private int d = 0;
  private byte[] e = j.b;
  
  public it()
  {
    this.unknownFieldData = null;
    this.cachedSize = -1;
  }
  
  private final it b(a parama)
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
      case 34: 
        this.e = parama.d();
        this.d |= 0x4;
        break;
      case 26: 
        if (this.a == null) {
          this.a = new d();
        }
        parama.a(this.a);
        break;
      case 18: 
        this.b = parama.c();
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
            StringBuilder localStringBuilder = new StringBuilder(36);
            localStringBuilder.append(k);
            localStringBuilder.append(" is not a valid enum Type");
            throw new IllegalArgumentException(localStringBuilder.toString());
          }
          catch (IllegalArgumentException localIllegalArgumentException)
          {
            parama.e(j);
            a(parama, i);
          }
          break;
        } while (k > 4);
        this.c = k;
        this.d |= 0x1;
      }
    }
  }
  
  protected final int a()
  {
    int j = super.a();
    int i = j;
    if ((this.d & 0x1) != 0) {
      i = j + CodedOutputByteBufferNano.d(1, this.c);
    }
    j = i;
    if ((this.d & 0x2) != 0) {
      j = i + CodedOutputByteBufferNano.b(2, this.b);
    }
    d locald = this.a;
    i = j;
    if (locald != null) {
      i = j + CodedOutputByteBufferNano.d(3, locald);
    }
    j = i;
    if ((this.d & 0x4) != 0) {
      j = i + CodedOutputByteBufferNano.b(4, this.e);
    }
    return j;
  }
  
  public final void a(CodedOutputByteBufferNano paramCodedOutputByteBufferNano)
  {
    if ((this.d & 0x1) != 0) {
      paramCodedOutputByteBufferNano.a(1, this.c);
    }
    if ((this.d & 0x2) != 0) {
      paramCodedOutputByteBufferNano.a(2, this.b);
    }
    d locald = this.a;
    if (locald != null) {
      paramCodedOutputByteBufferNano.b(3, locald);
    }
    if ((this.d & 0x4) != 0) {
      paramCodedOutputByteBufferNano.a(4, this.e);
    }
    super.a(paramCodedOutputByteBufferNano);
  }
  
  public final boolean equals(Object paramObject)
  {
    if (paramObject != this)
    {
      Object localObject;
      if ((paramObject instanceof it))
      {
        paramObject = (it)paramObject;
        int i = this.d;
        int j = ((it)paramObject).d;
        if (((i & 0x1) == (j & 0x1)) && (this.c == ((it)paramObject).c) && ((i & 0x2) == (j & 0x2)) && (this.b.equals(((it)paramObject).b)))
        {
          localObject = this.a;
          if (localObject != null) {
            break label168;
          }
          if (((it)paramObject).a != null) {}
        }
      }
      label168:
      while (((d)localObject).equals(((it)paramObject).a))
      {
        if (((this.d & 0x4) == (((it)paramObject).d & 0x4)) && (Arrays.equals(this.e, ((it)paramObject).e)))
        {
          localObject = this.unknownFieldData;
          if ((localObject == null) || (((com.google.protobuf.nano.d)localObject).a())) {
            paramObject = ((it)paramObject).unknownFieldData;
          }
        }
        else
        {
          return (paramObject == null) || (((com.google.protobuf.nano.d)paramObject).a());
        }
        return this.unknownFieldData.equals(((it)paramObject).unknownFieldData);
      }
      return false;
    }
    return true;
  }
  
  public final int hashCode()
  {
    int k = 0;
    int m = getClass().getName().hashCode();
    int n = this.c;
    int i1 = this.b.hashCode();
    Object localObject = this.a;
    if (localObject != null) {}
    for (int i = ((d)localObject).hashCode();; i = 0)
    {
      int i2 = Arrays.hashCode(this.e);
      localObject = this.unknownFieldData;
      int j = k;
      if (localObject != null)
      {
        j = k;
        if (!((com.google.protobuf.nano.d)localObject).a()) {
          j = this.unknownFieldData.hashCode();
        }
      }
      return ((i + (((m + 527) * 31 + n) * 31 + i1) * 31) * 31 + i2) * 31 + j;
    }
  }
}


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/com/google/android/finsky/ds/a/it.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */