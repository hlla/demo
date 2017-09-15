package com.tencent.mm.booter;

import com.tencent.gmtrace.GMTrace;
import com.tencent.mm.platformtools.u;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.storage.s;
import com.tencent.mm.storage.w;
import java.util.Locale;

public final class z
{
  public static z gKu;
  public long gKA;
  public int gKB;
  public int gKC;
  public int gKD;
  public int gKE;
  public s gKv;
  public a gKw;
  public long gKx;
  public long gKy;
  public String gKz;
  public boolean hasInit;
  
  static
  {
    GMTrace.i(500497907712L, 3729);
    gKu = new z();
    GMTrace.o(500497907712L, 3729);
  }
  
  private z()
  {
    GMTrace.i(500229472256L, 3727);
    this.gKA = -1L;
    this.gKB = 20;
    this.gKC = 24;
    this.gKD = 30;
    this.gKE = 10800;
    this.hasInit = false;
    this.gKv = new s(w.hgg + "staytime.cfg");
    GMTrace.o(500229472256L, 3727);
  }
  
  public final void cY(String paramString)
  {
    GMTrace.i(500363689984L, 3728);
    if ((paramString == null) || (this.gKw == null))
    {
      if (this.gKw == null) {}
      for (boolean bool = true;; bool = false)
      {
        v.i("MicroMsg.StayTimeReport", "exitChattingUI chatUser or reprotingItem is null, chatUser:%s, reportingItem is null:%b", new Object[] { paramString, Boolean.valueOf(bool) });
        GMTrace.o(500363689984L, 3728);
        return;
      }
    }
    if (!paramString.equals(this.gKw.gKF))
    {
      v.i("MicroMsg.StayTimeReport", "exitChattingUI no startedUI: %s, start:", new Object[] { paramString, this.gKw.gKF });
      GMTrace.o(500363689984L, 3728);
      return;
    }
    paramString = this.gKw;
    paramString.time += u.aB(this.gKx) / 1000L;
    paramString = (String)this.gKv.get(5, "");
    this.gKv.set(5, paramString + this.gKw.toString());
    long l = this.gKv.getLong(4, 0L);
    int i = this.gKv.yv(6) + 1;
    this.gKv.setInt(6, i);
    v.i("MicroMsg.StayTimeReport", "exitChattingUI, chatUser:%s, type:%d, stayTime:%d, stayWebTime:%d, chattingReportCnt:%d", new Object[] { this.gKw.gKF, Integer.valueOf(this.gKw.type), Long.valueOf(this.gKw.time), Integer.valueOf(this.gKw.gKJ), Integer.valueOf(i) });
    if ((u.az(l) > this.gKE) || (i > this.gKD)) {}
    for (i = 1;; i = 0)
    {
      if (i != 0)
      {
        paramString = (String)this.gKv.get(5, "");
        paramString = paramString + "," + l + "," + u.Nz();
        v.i("MicroMsg.StayTimeReport", "report %d: %s", new Object[] { Integer.valueOf(13062), paramString });
        g.oSF.A(13062, paramString);
        this.gKv.setInt(6, 0);
        this.gKv.set(5, "");
      }
      this.gKw = null;
      GMTrace.o(500363689984L, 3728);
      return;
    }
  }
  
  public final class a
  {
    public int fCB;
    public String gKF;
    public int gKG;
    public int gKH;
    public long gKI;
    public int gKJ;
    public long time;
    public int type;
    
    public a()
    {
      GMTrace.i(492713279488L, 3671);
      GMTrace.o(492713279488L, 3671);
    }
    
    public final String toString()
    {
      GMTrace.i(492847497216L, 3672);
      String str = String.format(Locale.US, "%d#%d#%d#%d#%d#%d#%d#%s|", new Object[] { Integer.valueOf(this.type), Long.valueOf(this.time), Integer.valueOf(this.gKG), Integer.valueOf(this.fCB), Integer.valueOf(this.gKH), Long.valueOf(this.gKI), Integer.valueOf(this.gKJ), this.gKF });
      GMTrace.o(492847497216L, 3672);
      return str;
    }
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/booter/z.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */