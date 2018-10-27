package com.google.android.finsky.ds.a;

import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.b;
import com.google.protobuf.nano.d;
import com.google.protobuf.nano.f;
import com.google.protobuf.nano.g;
import com.google.protobuf.nano.j;
import java.util.Arrays;

public final class be
  extends b
{
  private static volatile be[] c;
  public bc[] a = bc.b();
  public String b = "";
  private int d = 0;
  private byte[] e = j.b;
  
  public be()
  {
    this.unknownFieldData = null;
    this.cachedSize = -1;
  }
  
  public static be[] b()
  {
    if (c == null) {}
    synchronized (f.a)
    {
      if (c == null) {
        c = new be[0];
      }
      return c;
    }
  }
  
  protected final int a()
  {
    int j = super.a();
    int i = j;
    if ((this.d & 0x1) != 0) {
      i = j + CodedOutputByteBufferNano.b(1, this.b);
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
    i = j;
    if ((this.d & 0x2) != 0) {
      i = j + CodedOutputByteBufferNano.b(3, this.e);
    }
    return i;
  }
  
  public final void a(CodedOutputByteBufferNano paramCodedOutputByteBufferNano)
  {
    if ((this.d & 0x1) != 0) {
      paramCodedOutputByteBufferNano.a(1, this.b);
    }
    Object localObject = this.a;
    if ((localObject == null) || (localObject.length <= 0)) {}
    int i;
    do
    {
      if ((this.d & 0x2) != 0) {
        paramCodedOutputByteBufferNano.a(3, this.e);
      }
      super.a(paramCodedOutputByteBufferNano);
      return;
      i = 0;
      localObject = this.a;
    } while (i >= localObject.length);
    localObject = localObject[i];
    if (localObject == null) {}
    for (;;)
    {
      i += 1;
      break;
      paramCodedOutputByteBufferNano.b(2, (g)localObject);
    }
  }
  
  public final boolean equals(Object paramObject)
  {
    if (paramObject != this)
    {
      if ((paramObject instanceof be))
      {
        paramObject = (be)paramObject;
        if (((this.d & 0x1) == (((be)paramObject).d & 0x1)) && (this.b.equals(((be)paramObject).b)) && (f.a(this.a, ((be)paramObject).a)) && ((this.d & 0x2) == (((be)paramObject).d & 0x2)) && (Arrays.equals(this.e, ((be)paramObject).e)))
        {
          d locald = this.unknownFieldData;
          if ((locald != null) && (!locald.a())) {
            break label125;
          }
          paramObject = ((be)paramObject).unknownFieldData;
        }
      }
      return (paramObject == null) || (((d)paramObject).a());
      label125:
      return this.unknownFieldData.equals(((be)paramObject).unknownFieldData);
    }
    return true;
  }
  
  public final int hashCode()
  {
    int j = 0;
    int k = getClass().getName().hashCode();
    int m = this.b.hashCode();
    int n = f.a(this.a);
    int i1 = Arrays.hashCode(this.e);
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


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/com/google/android/finsky/ds/a/be.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */