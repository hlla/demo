package com.google.android.finsky.ds.a;

import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.a;
import com.google.protobuf.nano.b;
import com.google.protobuf.nano.d;
import com.google.protobuf.nano.f;
import com.google.protobuf.nano.g;
import com.google.protobuf.nano.j;

public final class fq
  extends b
{
  private fp[] a = fp.b();
  private int b = 0;
  private int c = 0;
  
  public fq()
  {
    this.unknownFieldData = null;
    this.cachedSize = -1;
  }
  
  private final fq b(a parama)
  {
    for (;;)
    {
      int i = parama.a();
      int j;
      switch (i)
      {
      default: 
        if (super.a(parama, i)) {}
        break;
      case 0: 
        return this;
      case 18: 
        j = j.a(parama, 18);
        fp[] arrayOffp1 = this.a;
        if (arrayOffp1 != null) {}
        for (i = arrayOffp1.length;; i = 0)
        {
          fp[] arrayOffp2 = new fp[j + i];
          j = i;
          if (i != 0)
          {
            System.arraycopy(arrayOffp1, 0, arrayOffp2, 0, i);
            j = i;
          }
          while (j < arrayOffp2.length - 1)
          {
            arrayOffp2[j] = new fp();
            parama.a(arrayOffp2[j]);
            parama.a();
            j += 1;
          }
          arrayOffp2[j] = new fp();
          parama.a(arrayOffp2[j]);
          this.a = arrayOffp2;
          break;
        }
      case 8: 
        this.b |= 0x1;
        j = parama.j();
        try
        {
          this.c = fw.a(parama.e());
          this.b |= 0x1;
        }
        catch (IllegalArgumentException localIllegalArgumentException)
        {
          parama.e(j);
          a(parama, i);
        }
      }
    }
  }
  
  protected final int a()
  {
    int j = super.a();
    int i = j;
    if ((this.b & 0x1) != 0) {
      i = j + CodedOutputByteBufferNano.d(1, this.c);
    }
    Object localObject = this.a;
    j = i;
    if (localObject != null)
    {
      j = i;
      if (localObject.length > 0)
      {
        j = 0;
        for (;;)
        {
          localObject = this.a;
          if (j >= localObject.length) {
            break;
          }
          localObject = localObject[j];
          int k = i;
          if (localObject != null) {
            k = i + CodedOutputByteBufferNano.d(2, (g)localObject);
          }
          j += 1;
          i = k;
        }
        j = i;
      }
    }
    return j;
  }
  
  public final void a(CodedOutputByteBufferNano paramCodedOutputByteBufferNano)
  {
    if ((this.b & 0x1) != 0) {
      paramCodedOutputByteBufferNano.a(1, this.c);
    }
    Object localObject = this.a;
    if ((localObject != null) && (localObject.length > 0))
    {
      int i = 0;
      localObject = this.a;
      if (i < localObject.length)
      {
        localObject = localObject[i];
        if (localObject == null) {}
        for (;;)
        {
          i += 1;
          break;
          paramCodedOutputByteBufferNano.b(2, (g)localObject);
        }
      }
    }
    super.a(paramCodedOutputByteBufferNano);
  }
  
  public final boolean equals(Object paramObject)
  {
    if (paramObject != this)
    {
      if ((paramObject instanceof fq))
      {
        paramObject = (fq)paramObject;
        if (((this.b & 0x1) == (((fq)paramObject).b & 0x1)) && (this.c == ((fq)paramObject).c) && (f.a(this.a, ((fq)paramObject).a)))
        {
          d locald = this.unknownFieldData;
          if ((locald != null) && (!locald.a())) {
            break label93;
          }
          paramObject = ((fq)paramObject).unknownFieldData;
        }
      }
      return (paramObject == null) || (((d)paramObject).a());
      label93:
      return this.unknownFieldData.equals(((fq)paramObject).unknownFieldData);
    }
    return true;
  }
  
  public final int hashCode()
  {
    int j = 0;
    int k = getClass().getName().hashCode();
    int m = this.c;
    int n = f.a(this.a);
    d locald = this.unknownFieldData;
    int i = j;
    if (locald != null)
    {
      i = j;
      if (!locald.a()) {
        i = this.unknownFieldData.hashCode();
      }
    }
    return i + (((k + 527) * 31 + m) * 31 + n) * 31;
  }
}


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/com/google/android/finsky/ds/a/fq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */