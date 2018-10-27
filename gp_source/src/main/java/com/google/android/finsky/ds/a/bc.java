package com.google.android.finsky.ds.a;

import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.b;
import com.google.protobuf.nano.d;
import com.google.protobuf.nano.f;
import com.google.protobuf.nano.g;
import com.google.protobuf.nano.j;
import java.util.Arrays;

public final class bc
  extends b
{
  private static volatile bc[] d;
  public bu a = null;
  public fb b = null;
  public String c = "";
  private int e = 0;
  private byte[] f = j.b;
  
  public bc()
  {
    this.unknownFieldData = null;
    this.cachedSize = -1;
  }
  
  public static bc[] b()
  {
    if (d == null) {}
    synchronized (f.a)
    {
      if (d == null) {
        d = new bc[0];
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
    Object localObject = this.a;
    j = i;
    if (localObject != null) {
      j = i + CodedOutputByteBufferNano.d(2, (g)localObject);
    }
    localObject = this.b;
    i = j;
    if (localObject != null) {
      i = j + CodedOutputByteBufferNano.d(3, (g)localObject);
    }
    j = i;
    if ((this.e & 0x2) != 0) {
      j = i + CodedOutputByteBufferNano.b(4, this.f);
    }
    return j;
  }
  
  public final void a(CodedOutputByteBufferNano paramCodedOutputByteBufferNano)
  {
    if ((this.e & 0x1) != 0) {
      paramCodedOutputByteBufferNano.a(1, this.c);
    }
    Object localObject = this.a;
    if (localObject != null) {
      paramCodedOutputByteBufferNano.b(2, (g)localObject);
    }
    localObject = this.b;
    if (localObject != null) {
      paramCodedOutputByteBufferNano.b(3, (g)localObject);
    }
    if ((this.e & 0x2) != 0) {
      paramCodedOutputByteBufferNano.a(4, this.f);
    }
    super.a(paramCodedOutputByteBufferNano);
  }
  
  public final boolean equals(Object paramObject)
  {
    if (paramObject != this)
    {
      Object localObject;
      if ((paramObject instanceof bc))
      {
        paramObject = (bc)paramObject;
        if (((this.e & 0x1) == (((bc)paramObject).e & 0x1)) && (this.c.equals(((bc)paramObject).c)))
        {
          localObject = this.a;
          if (localObject != null) {
            break label168;
          }
          if (((bc)paramObject).a != null) {}
        }
      }
      label168:
      while (((bu)localObject).equals(((bc)paramObject).a))
      {
        localObject = this.b;
        if (localObject == null) {
          if (((bc)paramObject).b != null) {}
        }
        while (((fb)localObject).equals(((bc)paramObject).b))
        {
          if (((this.e & 0x2) == (((bc)paramObject).e & 0x2)) && (Arrays.equals(this.f, ((bc)paramObject).f)))
          {
            localObject = this.unknownFieldData;
            if ((localObject == null) || (((d)localObject).a())) {
              paramObject = ((bc)paramObject).unknownFieldData;
            }
          }
          else
          {
            return (paramObject == null) || (((d)paramObject).a());
          }
          return this.unknownFieldData.equals(((bc)paramObject).unknownFieldData);
        }
        return false;
      }
      return false;
    }
    return true;
  }
  
  public final int hashCode()
  {
    int m = 0;
    int n = getClass().getName().hashCode();
    int i1 = this.c.hashCode();
    Object localObject = this.a;
    if (localObject != null) {}
    for (int i = ((bu)localObject).hashCode();; i = 0)
    {
      localObject = this.b;
      if (localObject != null) {}
      for (int j = ((fb)localObject).hashCode();; j = 0)
      {
        int i2 = Arrays.hashCode(this.f);
        localObject = this.unknownFieldData;
        int k = m;
        if (localObject != null)
        {
          k = m;
          if (!((d)localObject).a()) {
            k = this.unknownFieldData.hashCode();
          }
        }
        return ((j + (i + ((n + 527) * 31 + i1) * 31) * 31) * 31 + i2) * 31 + k;
      }
    }
  }
}


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/com/google/android/finsky/ds/a/bc.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */