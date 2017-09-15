package com.tencent.mm.compatible.d;

import com.tencent.gmtrace.GMTrace;

public final class s
{
  public int gRg;
  public int gRh;
  public int gRi;
  public int gRj;
  public int gRk;
  public int gRl;
  public int gRm;
  public int gRn;
  
  public s()
  {
    GMTrace.i(13805769719808L, 102861);
    reset();
    GMTrace.o(13805769719808L, 102861);
  }
  
  public final void reset()
  {
    GMTrace.i(13805903937536L, 102862);
    this.gRg = -1;
    this.gRh = -1;
    this.gRi = -1;
    this.gRj = -1;
    this.gRk = -1;
    this.gRl = -1;
    this.gRm = -1;
    this.gRn = -1;
    GMTrace.o(13805903937536L, 102862);
  }
  
  public final String toString()
  {
    GMTrace.i(13806038155264L, 102863);
    String str = String.format("MMSightRecorderInfo, recorderType: %s, needRotateEachFrame: %s, enableHighResolutionRecord: %s, landscapeRecordModeEnable: %s, transcodeDecoderType: %s, mediaPlayerType : %s strategybit: %s, recorderOption: %s", new Object[] { Integer.valueOf(this.gRg), Integer.valueOf(this.gRh), Integer.valueOf(this.gRi), Integer.valueOf(this.gRj), Integer.valueOf(this.gRk), Integer.valueOf(this.gRl), Integer.valueOf(this.gRm), Integer.valueOf(this.gRn) });
    GMTrace.o(13806038155264L, 102863);
    return str;
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/compatible/d/s.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */