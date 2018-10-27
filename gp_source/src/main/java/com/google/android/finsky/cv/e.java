package com.google.android.finsky.cv;

import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.b;
import com.google.protobuf.nano.g;

public final class e
  extends b
{
  public int a = 0;
  public String b = "";
  public c[] c = c.b();
  public String d = "";
  
  public e()
  {
    this.unknownFieldData = null;
    this.cachedSize = -1;
  }
  
  protected final int a()
  {
    int i = super.a();
    int j = i;
    if ((this.a & 0x1) != 0) {
      j = i + CodedOutputByteBufferNano.b(1, this.d);
    }
    i = j;
    if ((this.a & 0x2) != 0) {
      i = j + CodedOutputByteBufferNano.b(2, this.b);
    }
    Object localObject = this.c;
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
            k = i + CodedOutputByteBufferNano.d(3, (g)localObject);
          }
          j += 1;
          i = k;
        }
        j = i;
      }
    }
    return j;
  }
  
  public final void a(CodedOutputByteBufferNano paramCodedOutputByteBufferNano)
  {
    if ((this.a & 0x1) != 0) {
      paramCodedOutputByteBufferNano.a(1, this.d);
    }
    if ((this.a & 0x2) != 0) {
      paramCodedOutputByteBufferNano.a(2, this.b);
    }
    Object localObject = this.c;
    if ((localObject != null) && (localObject.length > 0))
    {
      int i = 0;
      localObject = this.c;
      if (i < localObject.length)
      {
        localObject = localObject[i];
        if (localObject == null) {}
        for (;;)
        {
          i += 1;
          break;
          paramCodedOutputByteBufferNano.b(3, (g)localObject);
        }
      }
    }
    super.a(paramCodedOutputByteBufferNano);
  }
}


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/com/google/android/finsky/cv/e.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */