package com.tencent.mm.app;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import com.tencent.gmtrace.GMTrace;
import com.tencent.mm.ap.t;
import com.tencent.mm.e.a.ql;
import com.tencent.mm.modelbiz.BizInfo;
import com.tencent.mm.modelmulti.b.a;
import com.tencent.mm.modelmulti.m;
import com.tencent.mm.modelmulti.q;
import com.tencent.mm.modelmulti.r;
import com.tencent.mm.pluginsdk.j;
import com.tencent.mm.pluginsdk.l.a;
import com.tencent.mm.pluginsdk.l.k;
import com.tencent.mm.pluginsdk.model.app.p;
import com.tencent.mm.protocal.c.amb;
import com.tencent.mm.protocal.c.awo;
import com.tencent.mm.sdk.platformtools.aa;
import com.tencent.mm.sdk.platformtools.d;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.storage.au.a;
import com.tencent.mm.storage.x;
import com.tencent.mm.u.ap;
import com.tencent.mm.ui.LauncherUI;
import com.tencent.mm.ui.MMAppMgr;
import com.tencent.mm.ui.base.s;
import com.tencent.mm.ui.p.a;

final class o
  implements com.tencent.mm.pluginsdk.f, com.tencent.mm.pluginsdk.g, com.tencent.mm.pluginsdk.h, j
{
  o()
  {
    GMTrace.i(12990933893120L, 96790);
    GMTrace.o(12990933893120L, 96790);
  }
  
  public final Bitmap a(Activity paramActivity, int paramInt1, int paramInt2, Intent paramIntent)
  {
    GMTrace.i(12993886683136L, 96812);
    if (paramInt2 != -1)
    {
      GMTrace.o(12993886683136L, 96812);
      return null;
    }
    switch (paramInt1)
    {
    }
    for (;;)
    {
      GMTrace.o(12993886683136L, 96812);
      return null;
      paramIntent = com.tencent.mm.pluginsdk.ui.tools.k.b(paramActivity.getApplicationContext(), paramIntent, com.tencent.mm.compatible.util.e.gSw);
      if (paramIntent == null)
      {
        GMTrace.o(12993886683136L, 96812);
        return null;
      }
      Intent localIntent = new Intent();
      localIntent.setClassName(paramActivity, "com.tencent.mm.ui.tools.CropImageNewUI");
      localIntent.putExtra("CropImageMode", 1);
      localIntent.putExtra("CropImage_OutputPath", com.tencent.mm.compatible.util.e.gSw + "temp.avatar");
      localIntent.putExtra("CropImage_ImgPath", paramIntent);
      paramActivity.startActivityForResult(localIntent, 4);
      GMTrace.o(12993886683136L, 96812);
      return null;
      if (paramIntent == null)
      {
        GMTrace.o(12993886683136L, 96812);
        return null;
      }
      localIntent = new Intent();
      localIntent.setClassName(paramActivity, "com.tencent.mm.ui.tools.CropImageNewUI");
      localIntent.putExtra("CropImageMode", 1);
      localIntent.putExtra("CropImage_Filter", true);
      localIntent.putExtra("CropImage_OutputPath", com.tencent.mm.compatible.util.e.gSw + "temp.avatar");
      localIntent.putExtra("CropImage_ImgPath", null);
      com.tencent.mm.ui.tools.a.a(paramActivity, paramIntent, localIntent, com.tencent.mm.compatible.util.e.gSw, 4);
      GMTrace.o(12993886683136L, 96812);
      return null;
      if (paramIntent == null)
      {
        GMTrace.o(12993886683136L, 96812);
        return null;
      }
      paramActivity = paramIntent.getStringExtra("CropImage_OutputPath");
      if (paramActivity != null) {
        break;
      }
      v.e("MicroMsg.WorkerModelCallback", "crop picture failed");
    }
    v.e("MicroMsg.WorkerModelCallback", "crop picture path %s ", new Object[] { paramActivity });
    paramActivity = d.Pf(paramActivity);
    GMTrace.o(12993886683136L, 96812);
    return paramActivity;
  }
  
  public final com.tencent.mm.y.k a(com.tencent.mm.y.f paramf)
  {
    GMTrace.i(12994155118592L, 96814);
    if (m.Hw())
    {
      paramf = new com.tencent.mm.modelmulti.g(paramf);
      GMTrace.o(12994155118592L, 96814);
      return paramf;
    }
    q.Hz().gg(4);
    GMTrace.o(12994155118592L, 96814);
    return null;
  }
  
  public final void a(Context paramContext, au.a parama, Bundle paramBundle)
  {
    GMTrace.i(12995094642688L, 96821);
    com.tencent.mm.ui.contact.e.a(paramContext, parama, true, true, paramBundle);
    GMTrace.o(12995094642688L, 96821);
  }
  
  public final void a(Context paramContext, x paramx, au.a parama, Bundle paramBundle, String paramString)
  {
    GMTrace.i(12995228860416L, 96822);
    com.tencent.mm.ui.contact.e.a(paramContext, paramx, parama, true, true, paramBundle, paramString);
    GMTrace.o(12995228860416L, 96822);
  }
  
  public final void a(Context paramContext, String paramString1, String paramString2, String paramString3, int paramInt1, int paramInt2, int paramInt3, String paramString4, String paramString5)
  {
    GMTrace.i(12992410288128L, 96801);
    l.k localk = l.a.szQ;
    if (localk != null) {
      localk.a(paramContext, paramString1, paramString2, paramString3, paramInt1, paramInt2, paramInt3, paramString4, 0L, paramString5);
    }
    GMTrace.o(12992410288128L, 96801);
  }
  
  public final void a(Context paramContext, String paramString1, String paramString2, String paramString3, long paramLong)
  {
    GMTrace.i(12992544505856L, 96802);
    paramContext = l.a.szQ;
    if (paramContext != null) {
      paramContext.a(paramString1, paramString2, 2, 4, paramString3, paramLong);
    }
    GMTrace.o(12992544505856L, 96802);
  }
  
  public final void a(Intent paramIntent, awo paramawo, int paramInt)
  {
    GMTrace.i(12994826207232L, 96819);
    com.tencent.mm.pluginsdk.ui.tools.c.a(paramIntent, paramawo, paramInt);
    GMTrace.o(12994826207232L, 96819);
  }
  
  public final void a(Intent paramIntent, String paramString)
  {
    GMTrace.i(12995363078144L, 96823);
    com.tencent.mm.ui.contact.e.a(paramIntent, paramString);
    GMTrace.o(12995363078144L, 96823);
  }
  
  public final void a(BizInfo paramBizInfo, Activity paramActivity, x paramx)
  {
    GMTrace.i(12994557771776L, 96817);
    com.tencent.mm.ui.tools.b.a(paramBizInfo, paramActivity, paramx, false);
    GMTrace.o(12994557771776L, 96817);
  }
  
  public final void a(BizInfo paramBizInfo, Activity paramActivity, x paramx, boolean paramBoolean, Runnable paramRunnable)
  {
    GMTrace.i(12994423554048L, 96816);
    com.tencent.mm.ui.tools.b.a(paramBizInfo, paramActivity, paramx, paramBoolean, paramRunnable, 0);
    GMTrace.o(12994423554048L, 96816);
  }
  
  public final void a(amb paramamb, String paramString)
  {
    GMTrace.i(12995631513600L, 96825);
    ((com.tencent.mm.plugin.messenger.foundation.a.c)com.tencent.mm.kernel.h.h(com.tencent.mm.plugin.messenger.foundation.a.c.class)).a(paramamb, paramString, null, true, false);
    GMTrace.o(12995631513600L, 96825);
  }
  
  public final boolean a(Context paramContext, int paramInt1, int paramInt2, String paramString)
  {
    GMTrace.i(12993081376768L, 96806);
    boolean bool = p.a.a(paramContext, paramInt1, paramInt2, paramString, 4);
    GMTrace.o(12993081376768L, 96806);
    return bool;
  }
  
  public final boolean a(x paramx)
  {
    GMTrace.i(12994289336320L, 96815);
    boolean bool = com.tencent.mm.modelmulti.a.a(paramx);
    GMTrace.o(12994289336320L, 96815);
    return bool;
  }
  
  public final void ah(Context paramContext)
  {
    GMTrace.i(12993618247680L, 96810);
    MMAppMgr.eA(paramContext);
    GMTrace.o(12993618247680L, 96810);
  }
  
  public final com.tencent.mm.y.k am(boolean paramBoolean)
  {
    GMTrace.i(12992812941312L, 96804);
    if (paramBoolean) {
      t.Id().gk(4);
    }
    com.tencent.mm.ap.k localk = new com.tencent.mm.ap.k(4);
    ap.vd().a(localk, 0);
    GMTrace.o(12992812941312L, 96804);
    return localk;
  }
  
  public final boolean b(Context paramContext, int paramInt1, int paramInt2, String paramString)
  {
    GMTrace.i(12993215594496L, 96807);
    boolean bool = p.a.a(paramContext, paramInt1, paramInt2, paramString, 7);
    GMTrace.o(12993215594496L, 96807);
    return bool;
  }
  
  public final String bm(String paramString)
  {
    GMTrace.i(12991604981760L, 96795);
    if (com.tencent.mm.pluginsdk.model.app.g.aJ(paramString, false) != null)
    {
      paramString = com.tencent.mm.pluginsdk.model.app.g.aJ(paramString, false).field_packageName;
      GMTrace.o(12991604981760L, 96795);
      return paramString;
    }
    GMTrace.o(12991604981760L, 96795);
    return "";
  }
  
  public final boolean bn(String paramString)
  {
    GMTrace.i(12991873417216L, 96797);
    boolean bool = com.tencent.mm.pluginsdk.model.app.g.bn(paramString);
    GMTrace.o(12991873417216L, 96797);
    return bool;
  }
  
  public final boolean bo(String paramString)
  {
    GMTrace.i(12992947159040L, 96805);
    boolean bool = com.tencent.mm.pluginsdk.model.app.g.bo(paramString);
    GMTrace.o(12992947159040L, 96805);
    return bool;
  }
  
  public final void bp(String paramString)
  {
    GMTrace.i(12995497295872L, 96824);
    q.HA().a(new b.a(paramString, 0, 0, 0, 0));
    GMTrace.o(12995497295872L, 96824);
  }
  
  public final boolean c(Activity paramActivity)
  {
    GMTrace.i(12993484029952L, 96809);
    if (!com.tencent.mm.compatible.util.f.rZ())
    {
      s.eP(paramActivity);
      GMTrace.o(12993484029952L, 96809);
      return false;
    }
    com.tencent.mm.pluginsdk.ui.tools.k.X(paramActivity);
    GMTrace.o(12993484029952L, 96809);
    return true;
  }
  
  public final void cT(int paramInt)
  {
    GMTrace.i(12991202328576L, 96792);
    v.d("MicroMsg.WorkerModelCallback", "trigger netscene sync, scene[%d]", new Object[] { Integer.valueOf(paramInt) });
    q.Hz().gg(paramInt);
    GMTrace.o(12991202328576L, 96792);
  }
  
  public final void d(Activity paramActivity)
  {
    GMTrace.i(12993752465408L, 96811);
    MMAppMgr.d(paramActivity);
    GMTrace.o(12993752465408L, 96811);
  }
  
  public final String e(Context paramContext, String paramString1, String paramString2)
  {
    GMTrace.i(12992141852672L, 96799);
    paramContext = p.e(paramContext, paramString1, paramString2);
    GMTrace.o(12992141852672L, 96799);
    return paramContext;
  }
  
  public final String i(String paramString, int paramInt)
  {
    GMTrace.i(12991470764032L, 96794);
    if (com.tencent.mm.pluginsdk.model.app.g.cv(paramString, paramInt) != null)
    {
      paramString = com.tencent.mm.pluginsdk.model.app.g.cv(paramString, paramInt).field_packageName;
      GMTrace.o(12991470764032L, 96794);
      return paramString;
    }
    GMTrace.o(12991470764032L, 96794);
    return "";
  }
  
  public final String m(Context paramContext, String paramString)
  {
    GMTrace.i(12991739199488L, 96796);
    paramContext = com.tencent.mm.pluginsdk.model.app.g.m(paramContext, paramString);
    GMTrace.o(12991739199488L, 96796);
    return paramContext;
  }
  
  public final boolean n(Context paramContext, String paramString)
  {
    GMTrace.i(12992007634944L, 96798);
    boolean bool = com.tencent.mm.pluginsdk.model.app.g.n(paramContext, paramString);
    GMTrace.o(12992007634944L, 96798);
    return bool;
  }
  
  public final void oA()
  {
    GMTrace.i(12994960424960L, 96820);
    com.tencent.mm.booter.o.oA();
    GMTrace.o(12994960424960L, 96820);
  }
  
  public final boolean oB()
  {
    GMTrace.i(12995765731328L, 96826);
    boolean bool = m.Hw();
    GMTrace.o(12995765731328L, 96826);
    return bool;
  }
  
  public final void ou()
  {
    GMTrace.i(12991068110848L, 96791);
    q.Hz().gg(7);
    GMTrace.o(12991068110848L, 96791);
  }
  
  public final com.tencent.mm.y.g ov()
  {
    GMTrace.i(12991336546304L, 96793);
    com.tencent.mm.c.a.a locala = new com.tencent.mm.c.a.a(aa.getContext());
    GMTrace.o(12991336546304L, 96793);
    return locala;
  }
  
  public final void ow()
  {
    GMTrace.i(12992678723584L, 96803);
    ql localql = new ql();
    localql.fXp.fXr = true;
    com.tencent.mm.sdk.b.a.uql.m(localql);
    GMTrace.o(12992678723584L, 96803);
  }
  
  public final void ox()
  {
    GMTrace.i(12993349812224L, 96808);
    MMAppMgr.ox();
    GMTrace.o(12993349812224L, 96808);
  }
  
  public final Intent oy()
  {
    GMTrace.i(12994020900864L, 96813);
    Intent localIntent = new Intent(aa.getContext(), LauncherUI.class);
    localIntent.putExtra("nofification_type", "talkroom_notification");
    localIntent.addFlags(67108864);
    GMTrace.o(12994020900864L, 96813);
    return localIntent;
  }
  
  public final boolean oz()
  {
    GMTrace.i(12994691989504L, 96818);
    boolean bool = com.tencent.mm.pluginsdk.ui.d.o.oz();
    GMTrace.o(12994691989504L, 96818);
    return bool;
  }
  
  public final String s(String paramString1, String paramString2)
  {
    GMTrace.i(12992276070400L, 96800);
    paramString1 = p.s(paramString1, paramString2);
    GMTrace.o(12992276070400L, 96800);
    return paramString1;
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/app/o.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */