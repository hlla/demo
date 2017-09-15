package com.tencent.mm.pluginsdk.model.app;

import com.tencent.gmtrace.GMTrace;

final class r
{
  public String appId;
  public int hRU;
  
  public r(String paramString, int paramInt)
  {
    GMTrace.i(822217801728L, 6126);
    this.appId = paramString;
    this.hRU = paramInt;
    GMTrace.o(822217801728L, 6126);
  }
  
  public final boolean equals(Object paramObject)
  {
    GMTrace.i(822352019456L, 6127);
    if (paramObject == null)
    {
      GMTrace.o(822352019456L, 6127);
      return false;
    }
    if (!(paramObject instanceof r))
    {
      GMTrace.o(822352019456L, 6127);
      return false;
    }
    paramObject = (r)paramObject;
    if ((((r)paramObject).appId.equals(this.appId)) && (((r)paramObject).hRU == this.hRU))
    {
      GMTrace.o(822352019456L, 6127);
      return true;
    }
    GMTrace.o(822352019456L, 6127);
    return false;
  }
  
  public final String toString()
  {
    GMTrace.i(822486237184L, 6128);
    String str = this.appId + this.hRU;
    GMTrace.o(822486237184L, 6128);
    return str;
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/pluginsdk/model/app/r.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */