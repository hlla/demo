package com.google.android.finsky.ds.a;

import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.b;
import com.google.protobuf.nano.d;

public final class cy
  extends b
{
  public boolean a = false;
  private int b = 0;
  private boolean c = true;
  
  public cy()
  {
    this.unknownFieldData = null;
    this.cachedSize = -1;
  }
  
  protected final int a()
  {
    int j = super.a();
    int i = j;
    if ((this.b & 0x1) != 0) {
      i = j + (CodedOutputByteBufferNano.d(8) + 1);
    }
    j = i;
    if ((this.b & 0x2) != 0) {
      j = i + (CodedOutputByteBufferNano.d(16) + 1);
    }
    return j;
  }
  
  public final void a(CodedOutputByteBufferNano paramCodedOutputByteBufferNano)
  {
    if ((this.b & 0x1) != 0) {
      paramCodedOutputByteBufferNano.a(1, this.a);
    }
    if ((this.b & 0x2) != 0) {
      paramCodedOutputByteBufferNano.a(2, this.c);
    }
    super.a(paramCodedOutputByteBufferNano);
  }
  
  public final boolean equals(Object paramObject)
  {
    if (paramObject != this)
    {
      if ((paramObject instanceof cy))
      {
        paramObject = (cy)paramObject;
        int i = this.b;
        int j = ((cy)paramObject).b;
        if (((i & 0x1) == (j & 0x1)) && (this.a == ((cy)paramObject).a) && ((i & 0x2) == (j & 0x2)) && (this.c == ((cy)paramObject).c))
        {
          d locald = this.unknownFieldData;
          if ((locald != null) && (!locald.a())) {
            break label106;
          }
          paramObject = ((cy)paramObject).unknownFieldData;
        }
      }
      return (paramObject == null) || (((d)paramObject).a());
      label106:
      return this.unknownFieldData.equals(((cy)paramObject).unknownFieldData);
    }
    return true;
  }
  
  public final int hashCode()
  {
    int k = 1237;
    int m = getClass().getName().hashCode();
    if (!this.a) {}
    for (int j = 1237;; j = 1231)
    {
      if (!this.c) {}
      for (;;)
      {
        d locald = this.unknownFieldData;
        int i;
        if (locald != null) {
          if (!locald.a()) {
            i = this.unknownFieldData.hashCode();
          }
        }
        for (;;)
        {
          return i + ((j + (m + 527) * 31) * 31 + k) * 31;
          i = 0;
          continue;
          i = 0;
        }
        k = 1231;
      }
    }
  }
}


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/com/google/android/finsky/ds/a/cy.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */