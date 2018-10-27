package com.google.android.finsky.ds.a;

import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.b;
import com.google.protobuf.nano.d;
import com.google.protobuf.nano.f;
import com.google.protobuf.nano.g;

public final class ni
  extends b
{
  public as[] a = as.b();
  public as b = null;
  public boolean c = false;
  private int d = 0;
  
  public ni()
  {
    this.unknownFieldData = null;
    this.cachedSize = -1;
  }
  
  protected final int a()
  {
    int i = super.a();
    Object localObject = this.a;
    int j = i;
    if (localObject != null)
    {
      j = i;
      if (localObject.length > 0)
      {
        int k = 0;
        for (;;)
        {
          localObject = this.a;
          j = i;
          if (k >= localObject.length) {
            break;
          }
          localObject = localObject[k];
          j = i;
          if (localObject != null) {
            j = i + CodedOutputByteBufferNano.d(1, (g)localObject);
          }
          k += 1;
          i = j;
        }
      }
    }
    i = j;
    if ((this.d & 0x1) != 0) {
      i = j + (CodedOutputByteBufferNano.d(16) + 1);
    }
    localObject = this.b;
    j = i;
    if (localObject != null) {
      j = i + CodedOutputByteBufferNano.d(3, (g)localObject);
    }
    return j;
  }
  
  public final void a(CodedOutputByteBufferNano paramCodedOutputByteBufferNano)
  {
    Object localObject = this.a;
    if ((localObject == null) || (localObject.length <= 0)) {}
    int i;
    do
    {
      if ((this.d & 0x1) != 0) {
        paramCodedOutputByteBufferNano.a(2, this.c);
      }
      localObject = this.b;
      if (localObject != null) {
        paramCodedOutputByteBufferNano.b(3, (g)localObject);
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
      paramCodedOutputByteBufferNano.b(1, (g)localObject);
    }
  }
  
  public final boolean equals(Object paramObject)
  {
    if (paramObject != this)
    {
      Object localObject;
      if ((paramObject instanceof ni))
      {
        paramObject = (ni)paramObject;
        if ((f.a(this.a, ((ni)paramObject).a)) && ((this.d & 0x1) == (((ni)paramObject).d & 0x1)) && (this.c == ((ni)paramObject).c))
        {
          localObject = this.b;
          if (localObject != null) {
            break label121;
          }
          if (((ni)paramObject).b != null) {}
        }
      }
      label121:
      while (((as)localObject).equals(((ni)paramObject).b))
      {
        localObject = this.unknownFieldData;
        if ((localObject == null) || (((d)localObject).a()))
        {
          paramObject = ((ni)paramObject).unknownFieldData;
          return (paramObject == null) || (((d)paramObject).a());
        }
        return this.unknownFieldData.equals(((ni)paramObject).unknownFieldData);
      }
      return false;
    }
    return true;
  }
  
  public final int hashCode()
  {
    int m = 0;
    int n = getClass().getName().hashCode();
    int i1 = f.a(this.a);
    if (!this.c) {}
    for (int i = 1237;; i = 1231)
    {
      Object localObject = this.b;
      if (localObject != null) {}
      for (int j = ((as)localObject).hashCode();; j = 0)
      {
        localObject = this.unknownFieldData;
        int k = m;
        if (localObject != null)
        {
          k = m;
          if (!((d)localObject).a()) {
            k = this.unknownFieldData.hashCode();
          }
        }
        return (j + (i + ((n + 527) * 31 + i1) * 31) * 31) * 31 + k;
      }
    }
  }
}


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/com/google/android/finsky/ds/a/ni.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */