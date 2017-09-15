package com.tencent.mm.compatible.g;

import com.tencent.gmtrace.GMTrace;
import com.tencent.mm.sdk.platformtools.v;

public final class a
{
  public int fFx;
  public String gSb;
  public long gSc;
  public int gSd;
  
  public a()
  {
    GMTrace.i(13824023330816L, 102997);
    this.gSb = null;
    this.gSc = -1L;
    this.gSd = -1;
    this.fFx = -1;
    this.gSb = null;
    this.gSc = -1L;
    this.gSd = -1;
    this.fFx = -1;
    GMTrace.o(13824023330816L, 102997);
  }
  
  public final String rW()
  {
    GMTrace.i(13824157548544L, 102998);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.gSb);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gSc);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gSd);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.fFx);
    v.d("MicroMsg.AudioRecorderInfo", " getStatInfo " + ((StringBuffer)localObject).toString());
    localObject = ((StringBuffer)localObject).toString();
    GMTrace.o(13824157548544L, 102998);
    return (String)localObject;
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/compatible/g/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */