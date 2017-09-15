package com.tencent.mm.plugin.accountsync.a;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.tencent.gmtrace.GMTrace;
import com.tencent.mm.bj.g.c;
import com.tencent.mm.e.a.bb;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.messenger.foundation.a.m;
import com.tencent.mm.plugin.messenger.foundation.a.n;
import com.tencent.mm.pluginsdk.k.a.b.b.c;
import com.tencent.mm.sdk.platformtools.aa;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.ai.a;
import com.tencent.mm.sdk.platformtools.bf;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.u.af;
import com.tencent.mm.u.am;
import com.tencent.mm.u.ap;
import com.tencent.mm.u.bp;
import java.io.File;
import java.util.HashMap;
import java.util.Map;

public final class c
  implements am
{
  public static int hYG;
  public static int iru;
  private static ai irw;
  private a irt;
  private com.tencent.mm.plugin.accountsync.model.a irv;
  private m irx;
  private com.tencent.mm.sdk.b.c iry;
  
  static
  {
    GMTrace.i(7851334434816L, 58497);
    iru = a.irB;
    hYG = 0;
    irw = null;
    GMTrace.o(7851334434816L, 58497);
  }
  
  public c()
  {
    GMTrace.i(7850126475264L, 58488);
    this.irt = null;
    this.irx = new m()
    {
      public final void b(String paramAnonymousString, Map<String, String> paramAnonymousMap)
      {
        GMTrace.i(18472922775552L, 137634);
        if ((bf.mz(paramAnonymousString).equals("ChangeLaunchImage")) && (paramAnonymousMap != null))
        {
          paramAnonymousString = (String)paramAnonymousMap.get(".sysmsg.ChangeLaunchImage.BeginTime");
          String str = (String)paramAnonymousMap.get(".sysmsg.ChangeLaunchImage.EndTime");
          paramAnonymousMap = (String)paramAnonymousMap.get(".sysmsg.ChangeLaunchImage.ResId.SubType");
          v.i("MicroMsg.SubCoreAccountSync", "beginTime:%s,endTime:%s,subtype:%s", new Object[] { paramAnonymousString, str, paramAnonymousMap });
          if (!bf.D(new String[] { paramAnonymousString, str, paramAnonymousMap }))
          {
            int i = bf.PX(paramAnonymousMap);
            if (i > 0)
            {
              paramAnonymousMap = aa.getContext().getSharedPreferences("system_config_prefs", 0);
              paramAnonymousMap.edit().putLong("new_launch_image_begin_time", bf.PY(paramAnonymousString)).apply();
              paramAnonymousMap.edit().putInt("new_launch_image_sub_type", i).apply();
              paramAnonymousMap.edit().putLong("new_launch_image_end_time", bf.PY(str)).commit();
              paramAnonymousString = b.c.sDY;
              c.mP(com.tencent.mm.pluginsdk.k.a.b.b.dF(43, i));
            }
          }
        }
        GMTrace.o(18472922775552L, 137634);
      }
    };
    this.iry = new com.tencent.mm.sdk.b.c() {};
    GMTrace.o(7850126475264L, 58488);
  }
  
  public static void hi(int paramInt)
  {
    GMTrace.i(7850931781632L, 58494);
    iru = paramInt;
    switch (4.irA[(paramInt - 1)])
    {
    }
    for (;;)
    {
      GMTrace.o(7850931781632L, 58494);
      return;
      hYG = 0;
      if (irw == null) {
        irw = new ai(new ai.a()
        {
          public final boolean oQ()
          {
            GMTrace.i(7852139741184L, 58503);
            int i = c.hYG + 1;
            c.hYG = i;
            if ((i == 1) || (c.hYG == 16) || (c.hYG % 96 == 0)) {
              ap.getNotification().qj();
            }
            GMTrace.o(7852139741184L, 58503);
            return true;
          }
        }, true);
      }
      v.d("MicroMsg.SubCoreAccountSync", "[oneliang][SmsVerifyCodeState]Sent");
      irw.v(900000L, 900000L);
      GMTrace.o(7850931781632L, 58494);
      return;
      if (irw != null) {
        irw.KI();
      }
      v.d("MicroMsg.SubCoreAccountSync", "[oneliang][SmsVerifyCodeState]verified");
      iru = a.irB;
      ap.getNotification().qk();
      hYG = 0;
      irw = null;
    }
  }
  
  public static void mP(String paramString)
  {
    GMTrace.i(18472654340096L, 137632);
    v.i("MicroMsg.SubCoreAccountSync", "filePath: %s", new Object[] { paramString });
    if (!bf.mA(paramString))
    {
      paramString = new File(paramString);
      if (paramString.exists())
      {
        String str = com.tencent.mm.compatible.util.e.hgg + "splashWelcomeImg";
        if (com.tencent.mm.loader.stub.b.deleteFile(str)) {
          com.tencent.mm.a.e.p(paramString.getAbsolutePath(), str);
        }
      }
    }
    GMTrace.o(18472654340096L, 137632);
  }
  
  public final void aM(boolean paramBoolean)
  {
    GMTrace.i(7850663346176L, 58492);
    this.irv = new com.tencent.mm.plugin.accountsync.model.a();
    ((n)h.j(n.class)).getSysCmdMsgExtension().a("ChangeLaunchImage", this.irx);
    this.iry.bIo();
    GMTrace.o(7850663346176L, 58492);
  }
  
  public final void aN(boolean paramBoolean)
  {
    GMTrace.i(7850797563904L, 58493);
    GMTrace.o(7850797563904L, 58493);
  }
  
  public final void eD(int paramInt)
  {
    GMTrace.i(7850529128448L, 58491);
    GMTrace.o(7850529128448L, 58491);
  }
  
  public final void onAccountRelease()
  {
    GMTrace.i(7850260692992L, 58489);
    com.tencent.mm.plugin.accountsync.model.a locala = this.irv;
    com.tencent.mm.sdk.b.a.uql.c(locala.irJ);
    this.irv = null;
    ((n)h.j(n.class)).getSysCmdMsgExtension().b("ChangeLaunchImage", this.irx);
    this.iry.dead();
    GMTrace.o(7850260692992L, 58489);
  }
  
  public final HashMap<Integer, g.c> uh()
  {
    GMTrace.i(7850394910720L, 58490);
    GMTrace.o(7850394910720L, 58490);
    return null;
  }
  
  public static enum a
  {
    static
    {
      GMTrace.i(7853079265280L, 58510);
      irB = 1;
      irC = 2;
      irD = 3;
      irE = new int[] { irB, irC, irD };
      GMTrace.o(7853079265280L, 58510);
    }
    
    public static int[] OC()
    {
      GMTrace.i(7852945047552L, 58509);
      int[] arrayOfInt = (int[])irE.clone();
      GMTrace.o(7852945047552L, 58509);
      return arrayOfInt;
    }
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/plugin/accountsync/a/c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */