package com.google.android.finsky.ds.a;

import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.a;
import com.google.protobuf.nano.b;
import com.google.protobuf.nano.d;
import com.google.protobuf.nano.f;
import com.google.protobuf.nano.j;
import java.util.Arrays;

public final class mg
  extends b
{
  private static volatile mg[] f;
  public int a = 0;
  public fb b = null;
  public String c = "";
  public String d = "";
  public byte[] e = j.b;
  private int g = 0;
  
  public mg()
  {
    this.unknownFieldData = null;
    this.cachedSize = -1;
  }
  
  private final mg b(a parama)
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
      case 58: 
        this.e = parama.d();
        this.g |= 0x8;
        break;
      case 50: 
        if (this.b == null) {
          this.b = new fb();
        }
        parama.a(this.b);
        break;
      case 40: 
        this.g |= 0x4;
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
            StringBuilder localStringBuilder = new StringBuilder(40);
            localStringBuilder.append(k);
            localStringBuilder.append(" is not a valid enum LineSize");
            throw new IllegalArgumentException(localStringBuilder.toString());
          }
          catch (IllegalArgumentException localIllegalArgumentException)
          {
            parama.e(j);
            a(parama, i);
          }
          break;
        } while (k > 2);
        this.a = k;
        this.g |= 0x4;
        break;
      case 34: 
        this.c = parama.c();
        this.g |= 0x2;
        break;
      case 26: 
        this.d = parama.c();
        this.g |= 0x1;
      }
    }
  }
  
  public static mg[] b()
  {
    if (f == null) {}
    synchronized (f.a)
    {
      if (f == null) {
        f = new mg[0];
      }
      return f;
    }
  }
  
  protected final int a()
  {
    int j = super.a();
    int i = j;
    if ((this.g & 0x1) != 0) {
      i = j + CodedOutputByteBufferNano.b(3, this.d);
    }
    j = i;
    if ((this.g & 0x2) != 0) {
      j = i + CodedOutputByteBufferNano.b(4, this.c);
    }
    i = j;
    if ((this.g & 0x4) != 0) {
      i = j + CodedOutputByteBufferNano.d(5, this.a);
    }
    fb localfb = this.b;
    j = i;
    if (localfb != null) {
      j = i + CodedOutputByteBufferNano.d(6, localfb);
    }
    i = j;
    if ((this.g & 0x8) != 0) {
      i = j + CodedOutputByteBufferNano.b(7, this.e);
    }
    return i;
  }
  
  public final void a(CodedOutputByteBufferNano paramCodedOutputByteBufferNano)
  {
    if ((this.g & 0x1) != 0) {
      paramCodedOutputByteBufferNano.a(3, this.d);
    }
    if ((this.g & 0x2) != 0) {
      paramCodedOutputByteBufferNano.a(4, this.c);
    }
    if ((this.g & 0x4) != 0) {
      paramCodedOutputByteBufferNano.a(5, this.a);
    }
    fb localfb = this.b;
    if (localfb != null) {
      paramCodedOutputByteBufferNano.b(6, localfb);
    }
    if ((this.g & 0x8) != 0) {
      paramCodedOutputByteBufferNano.a(7, this.e);
    }
    super.a(paramCodedOutputByteBufferNano);
  }
  
  public final boolean equals(Object paramObject)
  {
    if (paramObject != this)
    {
      Object localObject;
      if ((paramObject instanceof mg))
      {
        paramObject = (mg)paramObject;
        if (((this.g & 0x1) == (((mg)paramObject).g & 0x1)) && (this.d.equals(((mg)paramObject).d)) && ((this.g & 0x2) == (((mg)paramObject).g & 0x2)) && (this.c.equals(((mg)paramObject).c)) && ((this.g & 0x4) == (((mg)paramObject).g & 0x4)) && (this.a == ((mg)paramObject).a))
        {
          localObject = this.b;
          if (localObject != null) {
            break label196;
          }
          if (((mg)paramObject).b != null) {}
        }
      }
      label196:
      while (((fb)localObject).equals(((mg)paramObject).b))
      {
        if (((this.g & 0x8) == (((mg)paramObject).g & 0x8)) && (Arrays.equals(this.e, ((mg)paramObject).e)))
        {
          localObject = this.unknownFieldData;
          if ((localObject == null) || (((d)localObject).a())) {
            paramObject = ((mg)paramObject).unknownFieldData;
          }
        }
        else
        {
          return (paramObject == null) || (((d)paramObject).a());
        }
        return this.unknownFieldData.equals(((mg)paramObject).unknownFieldData);
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
    int i1 = this.c.hashCode();
    int i2 = this.a;
    Object localObject = this.b;
    if (localObject != null) {}
    for (int i = ((fb)localObject).hashCode();; i = 0)
    {
      int i3 = Arrays.hashCode(this.e);
      localObject = this.unknownFieldData;
      int j = k;
      if (localObject != null)
      {
        j = k;
        if (!((d)localObject).a()) {
          j = this.unknownFieldData.hashCode();
        }
      }
      return ((i + ((((m + 527) * 31 + n) * 31 + i1) * 31 + i2) * 31) * 31 + i3) * 31 + j;
    }
  }
}


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/com/google/android/finsky/ds/a/mg.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */