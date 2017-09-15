package com.tencent.mm.plugin.bbom;

import com.tencent.gmtrace.GMTrace;
import com.tencent.mm.e.a.cx;
import com.tencent.mm.e.a.gu;
import com.tencent.mm.e.a.kg;
import com.tencent.mm.e.a.qf;
import com.tencent.mm.modelmulti.q;
import com.tencent.mm.modelmulti.r;
import com.tencent.mm.modelstat.n;
import com.tencent.mm.plugin.messenger.foundation.a.a.f;
import com.tencent.mm.pluginsdk.model.app.an;
import com.tencent.mm.pluginsdk.model.app.i;
import com.tencent.mm.protocal.c.ano;
import com.tencent.mm.protocal.c.bgb;
import com.tencent.mm.protocal.d;
import com.tencent.mm.protocal.i.f;
import com.tencent.mm.protocal.i.g;
import com.tencent.mm.protocal.y.b;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.u.ao;
import com.tencent.mm.u.ba;
import com.tencent.mm.u.c;

public final class a
  implements com.tencent.mm.plugin.auth.a.a
{
  public a()
  {
    GMTrace.i(8023804215296L, 59782);
    GMTrace.o(8023804215296L, 59782);
  }
  
  public final void a(i.f paramf, i.g paramg, boolean paramBoolean)
  {
    GMTrace.i(8023938433024L, 59783);
    if ((paramg.sXG.ueL & 0x2) != 0)
    {
      paramf = paramg.sXG.ueN;
      if (!paramBoolean)
      {
        com.tencent.mm.u.ap.yY();
        c.eD(paramf.tbV);
      }
      paramg = com.tencent.mm.x.b.hd(com.tencent.mm.u.m.xL());
      ao.hlE.gf(paramg);
      if (paramf.tbS != 0)
      {
        com.tencent.mm.u.ap.yY();
        c.wZ().bo(paramf.tbS + "@qqim", 3);
      }
      com.tencent.mm.x.b.d(paramf.tbS, 3);
    }
    for (;;)
    {
      n.gH(1);
      if (!paramBoolean) {
        break;
      }
      paramf = new gu();
      paramf.fLW.fLX = false;
      com.tencent.mm.sdk.b.a.uql.m(paramf);
      paramf = new qf();
      paramf.fXa.fXb = true;
      com.tencent.mm.sdk.b.a.uql.m(paramf);
      GMTrace.o(8023938433024L, 59783);
      return;
      v.w("MicroMsg.BigBallAuthHandle", "summerauth updateProfile acctsect not set!");
    }
    com.tencent.mm.u.ap.vL().D(new Runnable()
    {
      public final void run()
      {
        GMTrace.i(8024341086208L, 59786);
        ba.gp("ver" + d.sXh);
        an.aRl().bQ(com.tencent.mm.plugin.w.a.aRk().bCS());
        com.tencent.mm.sdk.b.a locala = com.tencent.mm.sdk.b.a.uql;
        if (locala == null)
        {
          v.e("MicroMsg.BigBallAuthHandle", "EventPool is null.");
          GMTrace.o(8024341086208L, 59786);
          return;
        }
        Object localObject = new gu();
        ((gu)localObject).fLW.fLX = true;
        locala.m((com.tencent.mm.sdk.b.b)localObject);
        localObject = new qf();
        ((qf)localObject).fXa.fXb = true;
        locala.m((com.tencent.mm.sdk.b.b)localObject);
        locala.m(new cx());
        locala.m(new kg());
        q.Hz().gg(3);
        v.i("MicroMsg.BigBallAuthHandle", "summerbadcr triggerSync bgfg after manual auth");
        GMTrace.o(8024341086208L, 59786);
      }
      
      public final String toString()
      {
        GMTrace.i(8024475303936L, 59787);
        String str = super.toString() + "|onGYNetEnd2";
        GMTrace.o(8024475303936L, 59787);
        return str;
      }
    });
    GMTrace.o(8023938433024L, 59783);
  }
  
  public final void a(y.b paramb, String paramString1, int paramInt1, String paramString2, String paramString3, int paramInt2)
  {
    GMTrace.i(8024072650752L, 59784);
    paramString1 = com.tencent.mm.x.b.hd(com.tencent.mm.u.m.xL());
    ao.hlE.gf(paramString1);
    com.tencent.mm.x.b.d(paramInt1, 3);
    com.tencent.mm.u.ap.yY();
    c.wZ().bo(paramb.sYz.tQR, 2);
    if (paramInt1 != 0)
    {
      com.tencent.mm.u.ap.yY();
      c.wZ().bo(paramInt1 + "@qqim", 3);
    }
    GMTrace.o(8024072650752L, 59784);
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/plugin/bbom/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */