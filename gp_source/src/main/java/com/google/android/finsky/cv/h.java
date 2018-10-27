package com.google.android.finsky.cv;

import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.b;
import com.google.protobuf.nano.j;

public final class h
  extends b
{
  public String[] a = j.h;
  
  public h()
  {
    this.unknownFieldData = null;
    this.cachedSize = -1;
  }
  
  protected final int a()
  {
    int i = 0;
    int i1 = super.a();
    Object localObject = this.a;
    if (localObject != null)
    {
      if (localObject.length > 0)
      {
        int j = 0;
        int m;
        for (int k = 0;; k = m)
        {
          localObject = this.a;
          if (i >= localObject.length) {
            return i1 + j + k;
          }
          localObject = localObject[i];
          int n = j;
          m = k;
          if (localObject != null)
          {
            m = k + 1;
            n = j + CodedOutputByteBufferNano.a((String)localObject);
          }
          i += 1;
          j = n;
        }
      }
      return i1;
    }
    return i1;
  }
  
  public final void a(CodedOutputByteBufferNano paramCodedOutputByteBufferNano)
  {
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
          paramCodedOutputByteBufferNano.a(1, (String)localObject);
        }
      }
    }
    super.a(paramCodedOutputByteBufferNano);
  }
}


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/com/google/android/finsky/cv/h.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */