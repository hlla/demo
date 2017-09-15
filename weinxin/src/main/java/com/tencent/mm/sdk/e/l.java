package com.tencent.mm.sdk.e;

import com.tencent.gmtrace.GMTrace;

public final class l
{
  String fDq;
  public Object obj;
  public int uvE;
  public j uvF;
  
  public l()
  {
    GMTrace.i(13962804461568L, 104031);
    this.fDq = null;
    this.uvF = null;
    this.uvE = -1;
    this.obj = null;
    GMTrace.o(13962804461568L, 104031);
  }
  
  l(String paramString)
  {
    GMTrace.i(13962938679296L, 104032);
    this.fDq = paramString;
    this.uvF = null;
    this.uvE = -1;
    this.obj = null;
    GMTrace.o(13962938679296L, 104032);
  }
  
  public final String toString()
  {
    GMTrace.i(13963072897024L, 104033);
    String str = "MStorageEventData [event=" + this.fDq + ", eventId=" + this.uvE + ", stg=" + this.uvF + ", obj=" + this.obj + "]";
    GMTrace.o(13963072897024L, 104033);
    return str;
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/sdk/e/l.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */