package com.google.android.finsky.da.a;

import com.google.android.finsky.cv.b;
import com.google.android.finsky.utils.FinskyLog;
import com.google.android.finsky.utils.a.a;
import com.google.protobuf.nano.InvalidProtocolBufferNanoException;
import com.google.protobuf.nano.g;

final class q
  implements a
{
  private static b a(byte[] paramArrayOfByte)
  {
    try
    {
      paramArrayOfByte = (b)g.a(new b(), paramArrayOfByte);
      return paramArrayOfByte;
    }
    catch (InvalidProtocolBufferNanoException paramArrayOfByte)
    {
      FinskyLog.e("Failed to decode notification content proto.", new Object[0]);
    }
    return null;
  }
}


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/com/google/android/finsky/da/a/q.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */