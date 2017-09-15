package com.tencent.mm.pluginsdk.ui.d;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.widget.Toast;
import com.tencent.gmtrace.GMTrace;
import com.tencent.mm.R.l;
import com.tencent.mm.kernel.a;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.downloader.model.FileDownloadTaskInfo;
import com.tencent.mm.plugin.downloader.model.f.a;
import com.tencent.mm.pluginsdk.model.app.p;
import com.tencent.mm.pluginsdk.model.app.q;
import com.tencent.mm.sdk.platformtools.aa;
import com.tencent.mm.sdk.platformtools.bf;
import com.tencent.mm.sdk.platformtools.f;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.storage.t;
import com.tencent.mm.storage.w.a;
import com.tencent.mm.ui.base.s;
import java.io.File;

public final class o
{
  public static void d(Context paramContext, Bundle paramBundle)
  {
    GMTrace.i(1204335673344L, 8973);
    if (paramBundle != null) {}
    for (int i = paramBundle.getInt("fromScene");; i = 0)
    {
      com.tencent.mm.plugin.report.service.g.oSF.i(11621, new Object[] { Integer.valueOf(i), Integer.valueOf(0) });
      paramBundle = com.tencent.mm.plugin.downloader.model.e.akG().tF("http://dianhua.qq.com/cgi-bin/cloudgrptemplate?t=dianhuaben_download&channel=100008");
      if ((paramBundle == null) || (paramBundle.status != 3)) {
        break;
      }
      v.i("MicroMsg.WxPhoneBookHelper", "weixin phonebook already download successfully, install directly");
      if (com.tencent.mm.a.e.aO(paramBundle.path)) {
        q.e(paramContext, Uri.fromFile(new File(paramBundle.path)));
      }
      GMTrace.o(1204335673344L, 8973);
      return;
    }
    s.makeText(paramContext, paramContext.getString(R.l.dUQ), 2000).show();
    paramBundle = new f.a();
    paramBundle.tH("http://dianhua.qq.com/cgi-bin/cloudgrptemplate?t=dianhuaben_download&channel=100008");
    paramBundle.tJ(paramContext.getString(R.l.dUW));
    paramBundle.kW(1);
    paramBundle.dl(true);
    com.tencent.mm.plugin.downloader.model.e.akG().a(paramBundle.kFl);
    GMTrace.o(1204335673344L, 8973);
  }
  
  public static boolean oz()
  {
    boolean bool3 = true;
    GMTrace.i(1204201455616L, 8972);
    if (!h.vG().uV())
    {
      v.e("MicroMsg.WxPhoneBookHelper", "needDisplayWxPBMenuItem, account not ready");
      GMTrace.o(1204201455616L, 8972);
      return false;
    }
    boolean bool4;
    boolean bool1;
    label97:
    boolean bool2;
    if ((!bf.Hq()) && (f.fuN != 1) && (bf.getInt(com.tencent.mm.i.g.sV().getValue("ShowWeixinPBIntro"), 0) == 0) && (!p.n(aa.getContext(), "com.tencent.pb")))
    {
      i = 1;
      if (i != 0) {
        break label196;
      }
      bool4 = bf.Hq();
      if (f.fuN == 1) {
        break label181;
      }
      bool1 = true;
      if (bf.getInt(com.tencent.mm.i.g.sV().getValue("ShowWeixinPBIntro"), 0) != 0) {
        break label186;
      }
      bool2 = true;
      label114:
      if (p.n(aa.getContext(), "com.tencent.pb")) {
        break label191;
      }
    }
    for (;;)
    {
      v.d("MicroMsg.WxPhoneBookHelper", "%b, %b, %b, %b", new Object[] { Boolean.valueOf(bool4), Boolean.valueOf(bool1), Boolean.valueOf(bool2), Boolean.valueOf(bool3) });
      GMTrace.o(1204201455616L, 8972);
      return false;
      i = 0;
      break;
      label181:
      bool1 = false;
      break label97;
      label186:
      bool2 = false;
      break label114;
      label191:
      bool3 = false;
    }
    label196:
    int i = bf.a((Integer)h.vI().vr().get(w.a.uyD, null), 3);
    v.v("MicroMsg.WxPhoneBookHelper", "needDisplayWxPBMenuItem, counter = %d", new Object[] { Integer.valueOf(i) });
    if (i <= 0)
    {
      GMTrace.o(1204201455616L, 8972);
      return false;
    }
    h.vI().vr().set(352257, Integer.valueOf(i - 1));
    GMTrace.o(1204201455616L, 8972);
    return true;
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/pluginsdk/ui/d/o.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */