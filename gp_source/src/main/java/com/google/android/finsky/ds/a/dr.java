package com.google.android.finsky.ds.a;

import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.b;
import com.google.protobuf.nano.d;
import com.google.protobuf.nano.f;

public final class dr
  extends b
{
  private static volatile dr[] b;
  public String a = "";
  private int c = 0;
  
  public dr()
  {
    this.unknownFieldData = null;
    this.cachedSize = -1;
  }
  
  public static dr[] b()
  {
    if (b == null) {}
    synchronized (f.a)
    {
      if (b == null) {
        b = new dr[0];
      }
      return b;
    }
  }
  
  protected final int a()
  {
    int j = super.a();
    int i = j;
    if ((this.c & 0x1) != 0) {
      i = j + CodedOutputByteBufferNano.b(1, this.a);
    }
    return i;
  }
  
  public final dr a(String paramString)
  {
    if (paramString != null)
    {
      this.c |= 0x1;
      this.a = paramString;
      return this;
    }
    throw new NullPointerException();
  }
  
  public final void a(CodedOutputByteBufferNano paramCodedOutputByteBufferNano)
  {
    if ((this.c & 0x1) != 0) {
      paramCodedOutputByteBufferNano.a(1, this.a);
    }
    super.a(paramCodedOutputByteBufferNano);
  }
  
  public final boolean equals(Object paramObject)
  {
    if (paramObject != this)
    {
      if ((paramObject instanceof dr))
      {
        paramObject = (dr)paramObject;
        if (((this.c & 0x1) == (((dr)paramObject).c & 0x1)) && (this.a.equals(((dr)paramObject).a)))
        {
          d locald = this.unknownFieldData;
          if ((locald != null) && (!locald.a())) {
            break label82;
          }
          paramObject = ((dr)paramObject).unknownFieldData;
        }
      }
      return (paramObject == null) || (((d)paramObject).a());
      label82:
      return this.unknownFieldData.equals(((dr)paramObject).unknownFieldData);
    }
    return true;
  }
  
  public final int hashCode()
  {
    int j = 0;
    int k = getClass().getName().hashCode();
    int m = this.a.hashCode();
    d locald = this.unknownFieldData;
    int i = j;
    if (locald != null)
    {
      i = j;
      if (!locald.a()) {
        i = this.unknownFieldData.hashCode();
      }
    }
    return i + ((k + 527) * 31 + m) * 31;
  }
}


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/com/google/android/finsky/ds/a/dr.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */