package com.tencent.mm.plugin.sandbox;

import android.content.Context;
import android.content.DialogInterface.OnCancelListener;
import android.content.Intent;
import com.tencent.gmtrace.GMTrace;
import com.tencent.mm.bj.g.c;
import com.tencent.mm.pluginsdk.l.t;
import com.tencent.mm.pluginsdk.l.u;
import com.tencent.mm.pluginsdk.l.v;
import com.tencent.mm.sandbox.a.a;
import com.tencent.mm.sandbox.monitor.ExceptionMonitorService;
import com.tencent.mm.sandbox.monitor.c;
import com.tencent.mm.sandbox.updater.AppUpdaterUI;
import com.tencent.mm.sandbox.updater.Updater;
import com.tencent.mm.sdk.platformtools.aa;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.u.am;
import java.util.HashMap;

public class SubCoreSandBox
  implements l.v, am
{
  public static boolean oTV;
  public static boolean oTW;
  
  static
  {
    GMTrace.i(8935947894784L, 66578);
    oTV = false;
    oTW = false;
    GMTrace.o(8935947894784L, 66578);
  }
  
  public SubCoreSandBox()
  {
    GMTrace.i(8933800411136L, 66562);
    v.i("MicroMsg.SubCoreSandBox", "SubCoreSandBox constructor at: " + System.currentTimeMillis());
    GMTrace.o(8933800411136L, 66562);
  }
  
  public final String DC(String paramString)
  {
    GMTrace.i(8935545241600L, 66575);
    paramString = c.DC(paramString);
    GMTrace.o(8935545241600L, 66575);
    return paramString;
  }
  
  public final l.t a(Context paramContext, DialogInterface.OnCancelListener paramOnCancelListener)
  {
    GMTrace.i(8934739935232L, 66569);
    paramContext = Updater.c(paramContext, paramOnCancelListener);
    GMTrace.o(8934739935232L, 66569);
    return paramContext;
  }
  
  public final void aM(boolean paramBoolean)
  {
    GMTrace.i(8934203064320L, 66565);
    v.i("MicroMsg.SubCoreSandBox", "SubCoreSandBox onAccountPostReset at: " + System.currentTimeMillis());
    GMTrace.o(8934203064320L, 66565);
  }
  
  public final void aN(boolean paramBoolean)
  {
    GMTrace.i(8934337282048L, 66566);
    v.i("MicroMsg.SubCoreSandBox", "SubCoreSandBox onSdcardMount at: " + System.currentTimeMillis());
    GMTrace.o(8934337282048L, 66566);
  }
  
  public final void aXM()
  {
    GMTrace.i(8934605717504L, 66568);
    Updater.yj(16);
    GMTrace.o(8934605717504L, 66568);
  }
  
  public final l.u aXN()
  {
    GMTrace.i(8935411023872L, 66574);
    a locala = new a(2);
    GMTrace.o(8935411023872L, 66574);
    return locala;
  }
  
  public final l.t b(Context paramContext, DialogInterface.OnCancelListener paramOnCancelListener)
  {
    GMTrace.i(8934874152960L, 66570);
    paramContext = Updater.d(paramContext, paramOnCancelListener);
    GMTrace.o(8934874152960L, 66570);
    return paramContext;
  }
  
  public final l.t cL(Context paramContext)
  {
    GMTrace.i(8935008370688L, 66571);
    paramContext = Updater.dT(paramContext);
    GMTrace.o(8935008370688L, 66571);
    return paramContext;
  }
  
  public final void cM(Context paramContext)
  {
    GMTrace.i(8935142588416L, 66572);
    Updater.cM(paramContext);
    GMTrace.o(8935142588416L, 66572);
  }
  
  public final void d(String paramString1, int paramInt, String paramString2, String paramString3)
  {
    GMTrace.i(8935276806144L, 66573);
    Updater.d(paramString1, paramInt, paramString2, paramString3);
    GMTrace.o(8935276806144L, 66573);
  }
  
  public final void eD(int paramInt)
  {
    GMTrace.i(8934068846592L, 66564);
    v.i("MicroMsg.SubCoreSandBox", "SubCoreSandBox clearPluginData at: " + System.currentTimeMillis());
    GMTrace.o(8934068846592L, 66564);
  }
  
  public final void gF(boolean paramBoolean)
  {
    GMTrace.i(8935813677056L, 66577);
    oTV = true;
    oTW = paramBoolean;
    GMTrace.o(8935813677056L, 66577);
  }
  
  public final void l(Context paramContext, Intent paramIntent)
  {
    GMTrace.i(8935679459328L, 66576);
    if (paramContext != null)
    {
      paramIntent.setClass(paramContext, ExceptionMonitorService.class);
      aa.getContext().startService(paramIntent);
    }
    GMTrace.o(8935679459328L, 66576);
  }
  
  public final void m(Context paramContext, Intent paramIntent)
  {
    GMTrace.i(18997311438848L, 141541);
    if (paramIntent != null)
    {
      paramIntent.setClass(paramContext, AppUpdaterUI.class);
      paramContext.startActivity(paramIntent);
    }
    GMTrace.o(18997311438848L, 141541);
  }
  
  public final void onAccountRelease()
  {
    GMTrace.i(8934471499776L, 66567);
    v.i("MicroMsg.SubCoreSandBox", "SubCoreSandBox onAccountRelease at: " + System.currentTimeMillis());
    GMTrace.o(8934471499776L, 66567);
  }
  
  public final HashMap<Integer, g.c> uh()
  {
    GMTrace.i(8933934628864L, 66563);
    v.i("MicroMsg.SubCoreSandBox", "SubCoreSandBox getBaseDBFactories at: " + System.currentTimeMillis());
    GMTrace.o(8933934628864L, 66563);
    return null;
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/plugin/sandbox/SubCoreSandBox.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */