package com.tencent.mm.plugin.sight.base;

import com.tencent.gmtrace.GMTrace;
import com.tencent.mm.sdk.platformtools.bf;

public final class a
{
  public int height;
  public int hzG;
  public int hzt;
  public int lKu;
  public int nEx;
  public int prU;
  public int width;
  
  public a()
  {
    GMTrace.i(9370544898048L, 69816);
    this.lKu = 0;
    this.hzG = 0;
    this.width = 0;
    this.height = 0;
    this.nEx = 0;
    this.prU = 0;
    this.hzt = 0;
    GMTrace.o(9370544898048L, 69816);
  }
  
  public final int bbH()
  {
    GMTrace.i(9370679115776L, 69817);
    int i = bf.ex(this.lKu);
    GMTrace.o(9370679115776L, 69817);
    return i;
  }
  
  public final String toString()
  {
    GMTrace.i(9370813333504L, 69818);
    String str = "[ videoDuration: " + this.lKu + " videoBitrate: " + this.hzG + " width: " + this.width + " height: " + this.height + " frameRate: " + this.nEx + " audioChannel: " + this.prU + " audioBitrate: " + this.hzt + "]";
    GMTrace.o(9370813333504L, 69818);
    return str;
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/plugin/sight/base/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */