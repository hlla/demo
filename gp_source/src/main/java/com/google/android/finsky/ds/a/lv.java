package com.google.android.finsky.ds.a;

import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.a;
import com.google.protobuf.nano.b;
import com.google.protobuf.nano.d;
import com.google.protobuf.nano.f;

public final class lv
  extends b
{
  private static volatile lv[] a;
  private int b = 0;
  private int c = 0;
  private String d = "";
  private bu e = null;
  
  public lv()
  {
    this.unknownFieldData = null;
    this.cachedSize = -1;
  }
  
  private final lv b(a parama)
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
        this.c |= 0x2;
        break;
      case 18: 
        if (this.e == null) {
          this.e = new bu();
        }
        parama.a(this.e);
        break;
      case 8: 
        this.c |= 0x1;
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
            StringBuilder localStringBuilder = new StringBuilder(34);
            localStringBuilder.append(k);
            localStringBuilder.append(" is not a valid enum Id");
            throw new IllegalArgumentException(localStringBuilder.toString());
          }
          catch (IllegalArgumentException localIllegalArgumentException)
          {
            parama.e(j);
            a(parama, i);
          }
          break;
        } while (k > 5);
        this.b = k;
        this.c |= 0x1;
      }
    }
  }
  
  public static lv[] b()
  {
    if (a == null) {}
    synchronized (f.a)
    {
      if (a == null) {
        a = new lv[0];
      }
      return a;
    }
  }
  
  protected final int a()
  {
    int j = super.a();
    int i = j;
    if ((this.c & 0x1) != 0) {
      i = j + CodedOutputByteBufferNano.d(1, this.b);
    }
    bu localbu = this.e;
    j = i;
    if (localbu != null) {
      j = i + CodedOutputByteBufferNano.d(2, localbu);
    }
    i = j;
    if ((this.c & 0x2) != 0) {
      i = j + CodedOutputByteBufferNano.b(3, this.d);
    }
    return i;
  }
  
  public final void a(CodedOutputByteBufferNano paramCodedOutputByteBufferNano)
  {
    if ((this.c & 0x1) != 0) {
      paramCodedOutputByteBufferNano.a(1, this.b);
    }
    bu localbu = this.e;
    if (localbu != null) {
      paramCodedOutputByteBufferNano.b(2, localbu);
    }
    if ((this.c & 0x2) != 0) {
      paramCodedOutputByteBufferNano.a(3, this.d);
    }
    super.a(paramCodedOutputByteBufferNano);
  }
  
  public final boolean equals(Object paramObject)
  {
    if (paramObject != this)
    {
      Object localObject;
      if ((paramObject instanceof lv))
      {
        paramObject = (lv)paramObject;
        if (((this.c & 0x1) == (((lv)paramObject).c & 0x1)) && (this.b == ((lv)paramObject).b))
        {
          localObject = this.e;
          if (localObject != null) {
            break label136;
          }
          if (((lv)paramObject).e != null) {}
        }
      }
      label136:
      while (((bu)localObject).equals(((lv)paramObject).e))
      {
        if (((this.c & 0x2) == (((lv)paramObject).c & 0x2)) && (this.d.equals(((lv)paramObject).d)))
        {
          localObject = this.unknownFieldData;
          if ((localObject == null) || (((d)localObject).a())) {
            paramObject = ((lv)paramObject).unknownFieldData;
          }
        }
        else
        {
          return (paramObject == null) || (((d)paramObject).a());
        }
        return this.unknownFieldData.equals(((lv)paramObject).unknownFieldData);
      }
      return false;
    }
    return true;
  }
  
  public final int hashCode()
  {
    int k = 0;
    int m = getClass().getName().hashCode();
    int n = this.b;
    Object localObject = this.e;
    if (localObject != null) {}
    for (int i = ((bu)localObject).hashCode();; i = 0)
    {
      int i1 = this.d.hashCode();
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


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/com/google/android/finsky/ds/a/lv.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */