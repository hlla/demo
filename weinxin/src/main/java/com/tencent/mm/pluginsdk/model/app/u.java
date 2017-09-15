package com.tencent.mm.pluginsdk.model.app;

import com.tencent.gmtrace.GMTrace;

final class u
{
  public String appId;
  public byte[] data;
  public int hRU;
  
  public u(String paramString, int paramInt, byte[] paramArrayOfByte)
  {
    GMTrace.i(829733994496L, 6182);
    this.appId = paramString;
    this.hRU = paramInt;
    this.data = paramArrayOfByte;
    GMTrace.o(829733994496L, 6182);
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/pluginsdk/model/app/u.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */