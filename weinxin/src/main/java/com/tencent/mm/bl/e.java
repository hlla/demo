package com.tencent.mm.bl;

import com.tencent.gmtrace.GMTrace;

public final class e
{
  public static byte[] bp(byte[] paramArrayOfByte)
  {
    GMTrace.i(13154947956736L, 98012);
    int i = 0;
    while (i < paramArrayOfByte.length)
    {
      paramArrayOfByte[i] = ((byte)(paramArrayOfByte[i] ^ 0x12));
      i += 1;
    }
    GMTrace.o(13154947956736L, 98012);
    return paramArrayOfByte;
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/bl/e.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */