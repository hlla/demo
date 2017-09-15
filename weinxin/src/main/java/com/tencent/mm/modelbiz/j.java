package com.tencent.mm.modelbiz;

import com.tencent.gmtrace.GMTrace;
import com.tencent.mm.modelgeo.a.a;
import com.tencent.mm.sdk.e.m;
import com.tencent.mm.sdk.e.m.b;
import com.tencent.mm.sdk.platformtools.bf;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.storage.ar;
import org.json.JSONObject;

public final class j
{
  private a.a gKf;
  public int hvA;
  public boolean hvB;
  public m.b hvC;
  public int hvx;
  private com.tencent.mm.modelgeo.c hvy;
  private int hvz;
  public String userName;
  
  protected j()
  {
    GMTrace.i(4530653626368L, 33756);
    this.userName = null;
    this.hvx = 0;
    this.hvz = 2;
    this.hvA = 10;
    this.hvB = false;
    this.hvC = new m.b()
    {
      public final void a(int paramAnonymousInt, m paramAnonymousm, Object paramAnonymousObject)
      {
        GMTrace.i(4529445666816L, 33747);
        if ((paramAnonymousObject == null) || (!(paramAnonymousObject instanceof String)))
        {
          v.i("MicroMsg.ReportLocation", "onNotifyChange obj not String event:%d stg:%s obj:%s", new Object[] { Integer.valueOf(paramAnonymousInt), paramAnonymousm, paramAnonymousObject });
          GMTrace.o(4529445666816L, 33747);
          return;
        }
        if ((j.this.userName.equals((String)paramAnonymousObject)) && (j.this.hvx == 1))
        {
          v.i("MicroMsg.ReportLocation", "contactStgUpdate, %s", new Object[] { j.this.userName });
          j.this.ik(j.this.userName);
          ((com.tencent.mm.plugin.messenger.foundation.a.h)com.tencent.mm.kernel.h.h(com.tencent.mm.plugin.messenger.foundation.a.h.class)).wR().b(j.this.hvC);
        }
        GMTrace.o(4529445666816L, 33747);
      }
    };
    this.gKf = new a.a()
    {
      long lastReportTime;
      
      public final boolean a(boolean paramAnonymousBoolean, float paramAnonymousFloat1, float paramAnonymousFloat2, int paramAnonymousInt, double paramAnonymousDouble1, double paramAnonymousDouble2, double paramAnonymousDouble3)
      {
        GMTrace.i(15659719196672L, 116674);
        if (!paramAnonymousBoolean)
        {
          GMTrace.o(15659719196672L, 116674);
          return true;
        }
        v.i("MicroMsg.ReportLocation", "LBSManager notify. lat:%f, lng:%f", new Object[] { Float.valueOf(paramAnonymousFloat2), Float.valueOf(paramAnonymousFloat1) });
        if (bf.Nz() >= this.lastReportTime + j.this.hvA)
        {
          j.a(j.this.userName, 11, 0, paramAnonymousFloat2, paramAnonymousFloat1, (int)paramAnonymousDouble2);
          this.lastReportTime = bf.Nz();
        }
        if (j.this.hvx == 2) {
          j.this.DA();
        }
        if (!j.this.hvB)
        {
          j.this.hvB = true;
          com.tencent.mm.modelstat.n.a(2013, paramAnonymousFloat1, paramAnonymousFloat2, (int)paramAnonymousDouble2);
        }
        GMTrace.o(15659719196672L, 116674);
        return true;
      }
    };
    this.hvA = bf.getInt(((com.tencent.mm.plugin.zero.b.a)com.tencent.mm.kernel.h.h(com.tencent.mm.plugin.zero.b.a.class)).sW().z("BrandService", "continueLocationReportInterval"), 5);
    if (this.hvA < this.hvz) {
      this.hvA = this.hvz;
    }
    v.i("MicroMsg.ReportLocation", "reportLocation interval %d", new Object[] { Integer.valueOf(this.hvA) });
    GMTrace.o(4530653626368L, 33756);
  }
  
  public static void a(String paramString, int paramInt1, int paramInt2, float paramFloat1, float paramFloat2, int paramInt3)
  {
    GMTrace.i(4531324715008L, 33761);
    if (paramInt2 == 3) {}
    for (String str = "<event></event>";; str = String.format("<event><location><errcode>%d</errcode><data><latitude>%f</latitude><longitude>%f</longitude><precision>%d</precision></data></location></event>", new Object[] { Integer.valueOf(paramInt2), Float.valueOf(paramFloat1), Float.valueOf(paramFloat2), Integer.valueOf(paramInt3) }))
    {
      v.i("MicroMsg.ReportLocation", "doScene, info: %s", new Object[] { str });
      com.tencent.mm.kernel.h.vH().gXs.a(new p(paramString, paramInt1, str), 0);
      GMTrace.o(4531324715008L, 33761);
      return;
    }
  }
  
  public static void ii(String paramString)
  {
    GMTrace.i(4530787844096L, 33757);
    a(paramString, 10, 0, 0.0F, 0.0F, 0);
    GMTrace.o(4530787844096L, 33757);
  }
  
  public static void ij(String paramString)
  {
    GMTrace.i(4530922061824L, 33758);
    a(paramString, 12, 0, 0.0F, 0.0F, 0);
    GMTrace.o(4530922061824L, 33758);
  }
  
  public final void DA()
  {
    GMTrace.i(4531190497280L, 33760);
    v.i("MicroMsg.ReportLocation", "Stop report");
    this.hvx = 0;
    if (this.hvy != null) {
      this.hvy.c(this.gKf);
    }
    if (com.tencent.mm.kernel.h.vG().uV()) {
      ((com.tencent.mm.plugin.messenger.foundation.a.h)com.tencent.mm.kernel.h.h(com.tencent.mm.plugin.messenger.foundation.a.h.class)).wR().b(this.hvC);
    }
    GMTrace.o(4531190497280L, 33760);
  }
  
  public final void ik(String paramString)
  {
    GMTrace.i(4531056279552L, 33759);
    v.i("MicroMsg.ReportLocation", "Start report");
    this.userName = paramString;
    Object localObject = e.hW(paramString);
    if (localObject == null)
    {
      GMTrace.o(4531056279552L, 33759);
      return;
    }
    if (this.hvx != 0) {
      DA();
    }
    this.hvx = 0;
    if (((BizInfo)localObject).CB())
    {
      v.i("MicroMsg.ReportLocation", "need update contact %s", new Object[] { paramString });
      com.tencent.mm.x.b.he(paramString);
    }
    BizInfo.ExtInfo localExtInfo = ((BizInfo)localObject).bd(false);
    if (localExtInfo == null)
    {
      GMTrace.o(4531056279552L, 33759);
      return;
    }
    if ((localExtInfo.CD()) && (((BizInfo)localObject).CA()))
    {
      this.hvy = com.tencent.mm.modelgeo.c.Gl();
      localObject = ((BizInfo)localObject).bd(false);
      boolean bool;
      if (((BizInfo.ExtInfo)localObject).hug != null)
      {
        if (bf.getInt(((BizInfo.ExtInfo)localObject).hug.optString("ReportLocationType"), 0) == 2)
        {
          bool = true;
          ((BizInfo.ExtInfo)localObject).hut = bool;
        }
      }
      else {
        if (!((BizInfo.ExtInfo)localObject).hut) {
          break label223;
        }
      }
      label223:
      for (int i = 3;; i = 2)
      {
        this.hvx = i;
        if ((!com.tencent.mm.modelgeo.c.Gm()) && (!com.tencent.mm.modelgeo.c.Gn())) {
          break label228;
        }
        this.hvy.a(this.gKf, true);
        GMTrace.o(4531056279552L, 33759);
        return;
        bool = false;
        break;
      }
      label228:
      a(paramString, 11, 2, 0.0F, 0.0F, 0);
      GMTrace.o(4531056279552L, 33759);
      return;
    }
    if ((localExtInfo.CD()) && (!((BizInfo)localObject).CA())) {
      a(paramString, 11, 1, 0.0F, 0.0F, 0);
    }
    GMTrace.o(4531056279552L, 33759);
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/modelbiz/j.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */