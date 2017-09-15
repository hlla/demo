package com.tencent.mm.pluginsdk.ui;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.util.Base64;
import com.tencent.gmtrace.GMTrace;
import com.tencent.mm.R.l;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bf;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.storage.t;
import com.tencent.mm.u.ap;
import com.tencent.mm.u.c;
import com.tencent.mm.ui.base.g;

public final class k
{
  public static boolean dD(Context paramContext)
  {
    GMTrace.i(1166620491776L, 8692);
    if (!ac.Ps("network_doctor_shown"))
    {
      GMTrace.o(1166620491776L, 8692);
      return false;
    }
    g.a(paramContext, R.l.eDm, R.l.dIG, new DialogInterface.OnClickListener()
    {
      public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
      {
        GMTrace.i(1200980230144L, 8948);
        this.val$context.startActivity(new Intent("android.settings.WIRELESS_SETTINGS"));
        GMTrace.o(1200980230144L, 8948);
      }
    }, null);
    GMTrace.o(1166620491776L, 8692);
    return true;
  }
  
  public static boolean u(Context paramContext, final String paramString1, final String paramString2)
  {
    GMTrace.i(1166486274048L, 8691);
    if (!ac.Ps("wap_reporter_shown"))
    {
      GMTrace.o(1166486274048L, 8691);
      return false;
    }
    g.a(paramContext, R.l.eLx, R.l.dIG, R.l.dIm, R.l.dGk, new DialogInterface.OnClickListener()
    {
      public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
      {
        GMTrace.i(923015315456L, 6877);
        paramAnonymousDialogInterface = this.val$context;
        String str2 = paramString1;
        String str1 = paramString2;
        if (paramAnonymousDialogInterface == null)
        {
          v.w("Micromsg.NetworkErrAlert", "reportViaWap: context is null");
          GMTrace.o(923015315456L, 6877);
          return;
        }
        if (str2 == null) {
          v.w("Micromsg.NetworkErrAlert", "reportViaWap: ip is null");
        }
        if (str1 == null) {
          v.w("Micromsg.NetworkErrAlert", "reportViaWap: errMsg is null");
        }
        ap.yY();
        String str3 = (String)c.vr().get(2, null);
        str3 = "http://w.mail.qq.com/cgi-bin/mmfeedback?t=mmfeedback&f=xhtml" + "&u=" + Base64.encodeToString(str3.getBytes(), 8);
        str2 = str3 + "&i=" + Base64.encodeToString(bf.ap(str2, "").getBytes(), 8);
        str1 = str2 + "&e=" + Base64.encodeToString(bf.ap(str1, "").getBytes(), 8);
        str1 = str1 + "&autologin=n";
        v.d("Micromsg.NetworkErrAlert", "upload error to " + str1);
        bf.F(paramAnonymousDialogInterface, str1);
        GMTrace.o(923015315456L, 6877);
      }
    }, null);
    GMTrace.o(1166486274048L, 8691);
    return true;
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/pluginsdk/ui/k.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */