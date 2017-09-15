package com.tencent.mm.plugin.bbom;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.tencent.gmtrace.GMTrace;
import com.tencent.mm.R.l;
import com.tencent.mm.modelsimple.d;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.sdk.platformtools.aa;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bf;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.u.af;
import com.tencent.mm.u.ap;
import com.tencent.mm.ui.MMAppMgr;
import com.tencent.mm.y.e;
import com.tencent.mm.y.k;
import com.tencent.mm.y.n;

public final class j
  implements e
{
  static j jOi;
  
  public j()
  {
    GMTrace.i(8027025440768L, 59806);
    GMTrace.o(8027025440768L, 59806);
  }
  
  public final void a(int paramInt1, int paramInt2, String paramString, k paramk)
  {
    GMTrace.i(8027159658496L, 59807);
    if ((paramInt1 == 4) && (!ap.vd().foreground)) {}
    switch (paramInt2)
    {
    default: 
      if ((paramInt1 == 0) && (paramInt2 == 0)) {
        ap.getNotification().ox();
      }
      GMTrace.o(8027159658496L, 59807);
      return;
    case -311: 
    case -310: 
    case -205: 
    case -72: 
    case -9: 
    case -6: 
    case -4: 
    case -3: 
      ap.getNotification().dc(aa.getContext().getString(R.l.ezb));
      ap.hold();
      GMTrace.o(8027159658496L, 59807);
      return;
    case -140: 
      v.e("MicroMsg.NewSyncErrorProcessor", "alpha need whitelist : [%s]", new Object[] { paramString });
      if (!bf.mA(paramString)) {
        ap.getNotification().dc(paramString);
      }
      for (;;)
      {
        ap.hold();
        GMTrace.o(8027159658496L, 59807);
        return;
        ap.getNotification().dc(aa.getContext().getString(R.l.ezb));
      }
    case -100: 
      ap.getNotification().dc(aa.getContext().getString(R.l.eza));
      d.bd(aa.getContext());
      ap.hold();
      GMTrace.o(8027159658496L, 59807);
      return;
    case -999999: 
      new ad().post(new Runnable()
      {
        public final void run()
        {
          GMTrace.i(8029844013056L, 59827);
          ap.hold();
          MMAppMgr.ks(true);
          GMTrace.o(8029844013056L, 59827);
        }
      });
      GMTrace.o(8027159658496L, 59807);
      return;
    }
    paramString = aa.getContext().getSharedPreferences("system_config_prefs", 0);
    long l = paramString.getLong("recomended_update_ignore", -1L);
    if ((l != -1L) && (bf.az(l) < 86400L))
    {
      v.d("MicroMsg.NewSyncErrorProcessor", "skip update notification, last check=" + l);
      GMTrace.o(8027159658496L, 59807);
      return;
    }
    paramk = ap.getNotification();
    if (paramInt2 == -17) {}
    for (paramInt1 = 2;; paramInt1 = 1)
    {
      paramk.dN(paramInt1);
      paramString.edit().putLong("recomended_update_ignore", bf.Nz()).commit();
      g.oSF.a(405L, 27L, 1L, true);
      GMTrace.o(8027159658496L, 59807);
      return;
    }
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/plugin/bbom/j.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */