package com.google.android.finsky.ds.a;

import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.a;
import com.google.protobuf.nano.b;
import com.google.protobuf.nano.d;
import com.google.protobuf.nano.f;
import com.google.protobuf.nano.j;

public final class ib
  extends b
{
  private int a = 0;
  private int b = 0;
  private String c = "";
  private String[] d = j.h;
  
  public ib()
  {
    this.unknownFieldData = null;
    this.cachedSize = -1;
  }
  
  private final ib b(a parama)
  {
    for (;;)
    {
      i = parama.a();
      switch (i)
      {
      default: 
        if (super.a(parama, i)) {}
        break;
      case 0: 
        return this;
      case 24: 
        this.a |= 0x2;
        j = parama.j();
        int k;
        do
        {
          try
          {
            k = parama.e();
            if (k >= 0) {
              continue;
            }
            StringBuilder localStringBuilder = new StringBuilder(46);
            localStringBuilder.append(k);
            localStringBuilder.append(" is not a valid enum PointsTextType");
            throw new IllegalArgumentException(localStringBuilder.toString());
          }
          catch (IllegalArgumentException localIllegalArgumentException)
          {
            parama.e(j);
            a(parama, i);
          }
          break;
        } while (k > 2);
        this.b = k;
        this.a |= 0x2;
        break;
      case 18: 
        this.c = parama.c();
        this.a |= 0x1;
      }
    }
    int j = j.a(parama, 10);
    String[] arrayOfString1 = this.d;
    if (arrayOfString1 != null) {}
    for (int i = arrayOfString1.length;; i = 0)
    {
      String[] arrayOfString2 = new String[j + i];
      j = i;
      if (i != 0)
      {
        System.arraycopy(arrayOfString1, 0, arrayOfString2, 0, i);
        j = i;
      }
      while (j < arrayOfString2.length - 1)
      {
        arrayOfString2[j] = parama.c();
        parama.a();
        j += 1;
      }
      arrayOfString2[j] = parama.c();
      this.d = arrayOfString2;
      break;
    }
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
      if ((this.a & 0x1) != 0) {
        j = i + CodedOutputByteBufferNano.b(2, this.c);
      }
      i = j;
      if ((this.a & 0x2) != 0) {
        i = j + CodedOutputByteBufferNano.d(3, this.b);
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
      if ((this.a & 0x1) != 0) {
        paramCodedOutputByteBufferNano.a(2, this.c);
      }
      if ((this.a & 0x2) != 0) {
        paramCodedOutputByteBufferNano.a(3, this.b);
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
      if ((paramObject instanceof ib))
      {
        paramObject = (ib)paramObject;
        if ((f.a(this.d, ((ib)paramObject).d)) && ((this.a & 0x1) == (((ib)paramObject).a & 0x1)) && (this.c.equals(((ib)paramObject).c)) && ((this.a & 0x2) == (((ib)paramObject).a & 0x2)) && (this.b == ((ib)paramObject).b))
        {
          d locald = this.unknownFieldData;
          if ((locald != null) && (!locald.a())) {
            break label122;
          }
          paramObject = ((ib)paramObject).unknownFieldData;
        }
      }
      return (paramObject == null) || (((d)paramObject).a());
      label122:
      return this.unknownFieldData.equals(((ib)paramObject).unknownFieldData);
    }
    return true;
  }
  
  public final int hashCode()
  {
    int j = 0;
    int k = getClass().getName().hashCode();
    int m = f.a(this.d);
    int n = this.c.hashCode();
    int i1 = this.b;
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


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/com/google/android/finsky/ds/a/ib.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */