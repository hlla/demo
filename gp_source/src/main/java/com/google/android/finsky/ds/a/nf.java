package com.google.android.finsky.ds.a;

import com.google.protobuf.CodedOutputStream;
import com.google.protobuf.bb;
import com.google.protobuf.cl;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.b;
import com.google.protobuf.nano.d;
import com.google.protobuf.nano.g;
import com.google.wireless.android.finsky.dfe.d.a.b.a;

public final class nf
  extends b
{
  public q a = null;
  public t b = null;
  public aj c = null;
  public bi d = null;
  public je e = null;
  public nh f = null;
  private a g = null;
  
  public nf()
  {
    this.unknownFieldData = null;
    this.cachedSize = -1;
  }
  
  protected final int a()
  {
    int j = super.a();
    Object localObject = this.c;
    int i = j;
    if (localObject != null) {
      i = j + CodedOutputByteBufferNano.d(1, (g)localObject);
    }
    localObject = this.e;
    j = i;
    if (localObject != null) {
      j = i + CodedOutputByteBufferNano.d(2, (g)localObject);
    }
    localObject = this.b;
    i = j;
    if (localObject != null) {
      i = j + CodedOutputByteBufferNano.d(3, (g)localObject);
    }
    localObject = this.a;
    j = i;
    if (localObject != null) {
      j = i + CodedOutputByteBufferNano.d(4, (g)localObject);
    }
    localObject = this.d;
    i = j;
    if (localObject != null) {
      i = j + CodedOutputByteBufferNano.d(5, (g)localObject);
    }
    localObject = this.g;
    j = i;
    if (localObject != null) {
      j = i + CodedOutputStream.c(6, (cl)localObject);
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
    Object localObject = this.c;
    if (localObject != null) {
      paramCodedOutputByteBufferNano.b(1, (g)localObject);
    }
    localObject = this.e;
    if (localObject != null) {
      paramCodedOutputByteBufferNano.b(2, (g)localObject);
    }
    localObject = this.b;
    if (localObject != null) {
      paramCodedOutputByteBufferNano.b(3, (g)localObject);
    }
    localObject = this.a;
    if (localObject != null) {
      paramCodedOutputByteBufferNano.b(4, (g)localObject);
    }
    localObject = this.d;
    if (localObject != null) {
      paramCodedOutputByteBufferNano.b(5, (g)localObject);
    }
    localObject = this.g;
    if (localObject != null) {
      paramCodedOutputByteBufferNano.a(6, (cl)localObject);
    }
    localObject = this.f;
    if (localObject != null) {
      paramCodedOutputByteBufferNano.b(7, (g)localObject);
    }
    super.a(paramCodedOutputByteBufferNano);
  }
  
  public final boolean equals(Object paramObject)
  {
    if (paramObject != this)
    {
      Object localObject;
      if ((paramObject instanceof nf))
      {
        paramObject = (nf)paramObject;
        localObject = this.c;
        if (localObject != null) {
          break label255;
        }
        if (((nf)paramObject).c != null) {}
      }
      label255:
      while (((aj)localObject).equals(((nf)paramObject).c))
      {
        localObject = this.e;
        if (localObject == null) {
          if (((nf)paramObject).e != null) {}
        }
        while (((je)localObject).equals(((nf)paramObject).e))
        {
          localObject = this.b;
          if (localObject == null) {
            if (((nf)paramObject).b != null) {}
          }
          while (((t)localObject).equals(((nf)paramObject).b))
          {
            localObject = this.a;
            if (localObject == null) {
              if (((nf)paramObject).a != null) {}
            }
            while (((q)localObject).equals(((nf)paramObject).a))
            {
              localObject = this.d;
              if (localObject == null) {
                if (((nf)paramObject).d != null) {}
              }
              while (((bi)localObject).equals(((nf)paramObject).d))
              {
                localObject = this.g;
                if (localObject == null) {
                  if (((nf)paramObject).g != null) {}
                }
                while (((bb)localObject).equals(((nf)paramObject).g))
                {
                  localObject = this.f;
                  if (localObject == null) {
                    if (((nf)paramObject).f != null) {}
                  }
                  while (((nh)localObject).equals(((nf)paramObject).f))
                  {
                    localObject = this.unknownFieldData;
                    if ((localObject == null) || (((d)localObject).a()))
                    {
                      paramObject = ((nf)paramObject).unknownFieldData;
                      return (paramObject == null) || (((d)paramObject).a());
                    }
                    return this.unknownFieldData.equals(((nf)paramObject).unknownFieldData);
                  }
                  return false;
                }
                return false;
              }
              return false;
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
    int i4 = 0;
    int i5 = getClass().getName().hashCode();
    Object localObject = this.c;
    if (localObject != null) {}
    for (int i = ((aj)localObject).hashCode();; i = 0)
    {
      localObject = this.e;
      if (localObject != null) {}
      for (int j = ((je)localObject).hashCode();; j = 0)
      {
        localObject = this.b;
        if (localObject != null) {}
        for (int k = ((t)localObject).hashCode();; k = 0)
        {
          localObject = this.a;
          if (localObject != null) {}
          for (int m = ((q)localObject).hashCode();; m = 0)
          {
            localObject = this.d;
            if (localObject != null) {}
            for (int n = ((bi)localObject).hashCode();; n = 0)
            {
              localObject = this.g;
              if (localObject != null) {}
              for (int i1 = ((bb)localObject).hashCode();; i1 = 0)
              {
                localObject = this.f;
                if (localObject != null) {}
                for (int i2 = ((nh)localObject).hashCode();; i2 = 0)
                {
                  localObject = this.unknownFieldData;
                  int i3 = i4;
                  if (localObject != null)
                  {
                    i3 = i4;
                    if (!((d)localObject).a()) {
                      i3 = this.unknownFieldData.hashCode();
                    }
                  }
                  return (i2 + (i1 + (n + (m + (k + (j + (i + (i5 + 527) * 31) * 31) * 31) * 31) * 31) * 31) * 31) * 31 + i3;
                }
              }
            }
          }
        }
      }
    }
  }
}


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/com/google/android/finsky/ds/a/nf.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */