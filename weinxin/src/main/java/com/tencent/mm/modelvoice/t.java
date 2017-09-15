package com.tencent.mm.modelvoice;

import com.tencent.gmtrace.GMTrace;
import com.tencent.mm.c.b.a;
import com.tencent.mm.c.b.b;
import com.tencent.mm.c.b.c;
import com.tencent.mm.compatible.util.g.a;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.y.h.a;

public final class t
  implements a
{
  private static int fBt;
  public b fBr;
  String fyw;
  public h.a icb;
  public int status;
  
  static
  {
    GMTrace.i(544118669312L, 4054);
    fBt = 100;
    GMTrace.o(544118669312L, 4054);
  }
  
  public t(com.tencent.mm.compatible.b.b.a parama)
  {
    GMTrace.i(543179145216L, 4047);
    this.fyw = "";
    this.icb = null;
    this.status = 0;
    this.fBr = new b(parama);
    GMTrace.o(543179145216L, 4047);
  }
  
  public final void a(h.a parama)
  {
    GMTrace.i(543044927488L, 4046);
    this.icb = parama;
    GMTrace.o(543044927488L, 4046);
  }
  
  public final boolean bw(String paramString)
  {
    GMTrace.i(543313362944L, 4048);
    g.a locala = new g.a();
    if (this.fyw.length() > 0)
    {
      v.e("VoiceRecorder", "Duplicate Call startRecord , maybe Stop Fail Before");
      GMTrace.o(543313362944L, 4048);
      return false;
    }
    this.fyw = paramString;
    try
    {
      this.fBr.a(new com.tencent.mm.c.b.b.a()
      {
        public final void onError()
        {
          GMTrace.i(542105403392L, 4039);
          if (t.this.icb != null) {
            t.this.icb.onError();
          }
          try
          {
            t.this.fBr.release();
            t.this.status = -1;
            GMTrace.o(542105403392L, 4039);
            return;
          }
          catch (Exception localException)
          {
            v.e("VoiceRecorder", "setErrorListener File[" + t.this.fyw + "] ErrMsg[" + localException.getStackTrace() + "]");
            GMTrace.o(542105403392L, 4039);
          }
        }
      });
      this.fBr.pa();
      this.fBr.pb();
      this.fBr.oZ();
      this.fBr.setOutputFile(this.fyw);
      this.fBr.setMaxDuration(70000);
      this.fBr.prepare();
      this.fBr.start();
      v.d("VoiceRecorder", "StartRecord File[" + this.fyw + "] start time:" + locala.se());
      this.status = 1;
      GMTrace.o(543313362944L, 4048);
      return true;
    }
    catch (Exception paramString)
    {
      v.e("VoiceRecorder", "StartRecord File[" + this.fyw + "] ErrMsg[" + paramString.getMessage() + "]");
      this.status = -1;
      GMTrace.o(543313362944L, 4048);
    }
    return false;
  }
  
  public final int getMaxAmplitude()
  {
    GMTrace.i(543581798400L, 4050);
    if (this.status == 1)
    {
      int i = this.fBr.getMaxAmplitude();
      if (i > fBt) {
        fBt = i;
      }
      i = i * 100 / fBt;
      GMTrace.o(543581798400L, 4050);
      return i;
    }
    GMTrace.o(543581798400L, 4050);
    return 0;
  }
  
  public final int getStatus()
  {
    GMTrace.i(542776492032L, 4044);
    int i = this.status;
    GMTrace.o(542776492032L, 4044);
    return i;
  }
  
  public final boolean oX()
  {
    GMTrace.i(543447580672L, 4049);
    if (this.fBr == null)
    {
      GMTrace.o(543447580672L, 4049);
      return true;
    }
    try
    {
      this.fBr.pd();
      this.fBr.release();
      this.fyw = "";
      this.status = 0;
      GMTrace.o(543447580672L, 4049);
      return true;
    }
    catch (Exception localException)
    {
      v.e("VoiceRecorder", "StopRecord File[" + this.fyw + "] ErrMsg[" + localException.getMessage() + "]");
      this.status = -1;
      GMTrace.o(543447580672L, 4049);
    }
    return false;
  }
  
  public final int oY()
  {
    GMTrace.i(542910709760L, 4045);
    b localb = this.fBr;
    if (((localb.fzn == com.tencent.mm.compatible.b.b.a.gMY) || (localb.fzn == com.tencent.mm.compatible.b.b.a.gNa)) && (localb.fzm != null))
    {
      int i = localb.fzm.fAa;
      GMTrace.o(542910709760L, 4045);
      return i;
    }
    GMTrace.o(542910709760L, 4045);
    return 1;
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/modelvoice/t.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */