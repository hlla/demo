package com.google.android.finsky.ds.a;

import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.d;
import com.google.protobuf.nano.f;
import com.google.protobuf.nano.g;

public final class ed
  extends com.google.protobuf.nano.b
{
  public af a = null;
  public ag b = null;
  public ah[] c = ah.b();
  public mf d = null;
  public String e = "";
  public b f = null;
  public String g = "";
  private int h = 0;
  
  public ed()
  {
    this.unknownFieldData = null;
    this.cachedSize = -1;
  }
  
  protected final int a()
  {
    int j = super.a();
    Object localObject = this.a;
    int i = j;
    if (localObject != null) {
      i = j + CodedOutputByteBufferNano.d(1, (g)localObject);
    }
    j = i;
    if ((this.h & 0x1) != 0) {
      j = i + CodedOutputByteBufferNano.b(2, this.g);
    }
    i = j;
    if ((this.h & 0x2) != 0) {
      i = j + CodedOutputByteBufferNano.b(3, this.e);
    }
    localObject = this.c;
    j = i;
    if (localObject != null)
    {
      j = i;
      if (localObject.length > 0)
      {
        j = 0;
        for (;;)
        {
          localObject = this.c;
          if (j >= localObject.length) {
            break;
          }
          localObject = localObject[j];
          int k = i;
          if (localObject != null) {
            k = i + CodedOutputByteBufferNano.d(4, (g)localObject);
          }
          j += 1;
          i = k;
        }
        j = i;
      }
    }
    localObject = this.b;
    i = j;
    if (localObject != null) {
      i = j + CodedOutputByteBufferNano.d(5, (g)localObject);
    }
    localObject = this.d;
    j = i;
    if (localObject != null) {
      j = i + CodedOutputByteBufferNano.d(6, (g)localObject);
    }
    localObject = this.f;
    i = j;
    if (localObject != null) {
      i = j + CodedOutputByteBufferNano.d(7, (g)localObject);
    }
    return i;
  }
  
  public final void a(CodedOutputByteBufferNano paramCodedOutputByteBufferNano)
  {
    Object localObject = this.a;
    if (localObject != null) {
      paramCodedOutputByteBufferNano.b(1, (g)localObject);
    }
    if ((this.h & 0x1) != 0) {
      paramCodedOutputByteBufferNano.a(2, this.g);
    }
    if ((this.h & 0x2) != 0) {
      paramCodedOutputByteBufferNano.a(3, this.e);
    }
    localObject = this.c;
    if ((localObject == null) || (localObject.length <= 0)) {}
    int i;
    do
    {
      localObject = this.b;
      if (localObject != null) {
        paramCodedOutputByteBufferNano.b(5, (g)localObject);
      }
      localObject = this.d;
      if (localObject != null) {
        paramCodedOutputByteBufferNano.b(6, (g)localObject);
      }
      localObject = this.f;
      if (localObject != null) {
        paramCodedOutputByteBufferNano.b(7, (g)localObject);
      }
      super.a(paramCodedOutputByteBufferNano);
      return;
      i = 0;
      localObject = this.c;
    } while (i >= localObject.length);
    localObject = localObject[i];
    if (localObject == null) {}
    for (;;)
    {
      i += 1;
      break;
      paramCodedOutputByteBufferNano.b(4, (g)localObject);
    }
  }
  
  public final boolean equals(Object paramObject)
  {
    if (paramObject != this)
    {
      Object localObject;
      if ((paramObject instanceof ed))
      {
        paramObject = (ed)paramObject;
        localObject = this.a;
        if (localObject != null) {
          break label240;
        }
        if (((ed)paramObject).a != null) {}
      }
      label227:
      label240:
      while (((af)localObject).equals(((ed)paramObject).a))
      {
        if (((this.h & 0x1) == (((ed)paramObject).h & 0x1)) && (this.g.equals(((ed)paramObject).g)) && ((this.h & 0x2) == (((ed)paramObject).h & 0x2)) && (this.e.equals(((ed)paramObject).e)) && (f.a(this.c, ((ed)paramObject).c)))
        {
          localObject = this.b;
          if (localObject != null) {
            break label227;
          }
          if (((ed)paramObject).b != null) {}
        }
        while (((ag)localObject).equals(((ed)paramObject).b))
        {
          localObject = this.d;
          if (localObject == null) {
            if (((ed)paramObject).d != null) {}
          }
          while (((mf)localObject).equals(((ed)paramObject).d))
          {
            localObject = this.f;
            if (localObject == null) {
              if (((ed)paramObject).f != null) {}
            }
            while (((b)localObject).equals(((ed)paramObject).f))
            {
              localObject = this.unknownFieldData;
              if ((localObject == null) || (((d)localObject).a()))
              {
                paramObject = ((ed)paramObject).unknownFieldData;
                return (paramObject == null) || (((d)paramObject).a());
              }
              return this.unknownFieldData.equals(((ed)paramObject).unknownFieldData);
            }
            return false;
          }
          return false;
        }
        return false;
      }
      return false;
    }
    return true;
  }
  
  public final int hashCode()
  {
    int i1 = 0;
    int i2 = getClass().getName().hashCode();
    Object localObject = this.a;
    if (localObject != null) {}
    for (int i = ((af)localObject).hashCode();; i = 0)
    {
      int i3 = this.g.hashCode();
      int i4 = this.e.hashCode();
      int i5 = f.a(this.c);
      localObject = this.b;
      if (localObject != null) {}
      for (int j = ((ag)localObject).hashCode();; j = 0)
      {
        localObject = this.d;
        if (localObject != null) {}
        for (int k = ((mf)localObject).hashCode();; k = 0)
        {
          localObject = this.f;
          if (localObject != null) {}
          for (int m = ((b)localObject).hashCode();; m = 0)
          {
            localObject = this.unknownFieldData;
            int n = i1;
            if (localObject != null)
            {
              n = i1;
              if (!((d)localObject).a()) {
                n = this.unknownFieldData.hashCode();
              }
            }
            return (m + (k + (j + ((((i + (i2 + 527) * 31) * 31 + i3) * 31 + i4) * 31 + i5) * 31) * 31) * 31) * 31 + n;
          }
        }
      }
    }
  }
}


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/com/google/android/finsky/ds/a/ed.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */