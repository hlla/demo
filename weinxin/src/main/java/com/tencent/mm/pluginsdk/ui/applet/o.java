package com.tencent.mm.pluginsdk.ui.applet;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.Intent;
import com.tencent.gmtrace.GMTrace;
import com.tencent.mm.R.l;
import com.tencent.mm.bb.d;
import com.tencent.mm.modelsimple.l;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.ai.a;
import com.tencent.mm.sdk.platformtools.bf;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.storage.t;
import com.tencent.mm.u.ap;
import com.tencent.mm.u.c;
import com.tencent.mm.ui.base.g;
import com.tencent.mm.ui.base.p;
import com.tencent.mm.y.e;
import com.tencent.mm.y.k;
import com.tencent.mm.y.n;

public final class o
  implements e
{
  public Context context;
  public p lVC;
  private ai ouW;
  public l pbp;
  private String sLS;
  
  public o(Context paramContext)
  {
    GMTrace.i(935094910976L, 6967);
    this.ouW = new ai(new ai.a()
    {
      public final boolean oQ()
      {
        GMTrace.i(959790972928L, 7151);
        o localo = o.this;
        Context localContext = o.this.context;
        o.this.context.getString(R.l.dIG);
        localo.lVC = g.a(localContext, o.this.context.getString(R.l.dIV), true, new DialogInterface.OnCancelListener()
        {
          public final void onCancel(DialogInterface paramAnonymous2DialogInterface)
          {
            GMTrace.i(958180360192L, 7139);
            ap.vd().c(o.this.pbp);
            o.this.lVC = null;
            GMTrace.o(958180360192L, 7139);
          }
        });
        GMTrace.o(959790972928L, 7151);
        return false;
      }
    }, false);
    this.context = paramContext;
    GMTrace.o(935094910976L, 6967);
  }
  
  private void MT(String paramString)
  {
    GMTrace.i(935363346432L, 6969);
    Intent localIntent = new Intent();
    localIntent.putExtra("rawUrl", this.context.getString(R.l.dYZ, new Object[] { paramString }));
    localIntent.putExtra("useJs", true);
    localIntent.putExtra("vertical_scroll", true);
    localIntent.putExtra("neverGetA8Key", true);
    d.b(this.context, "webview", ".ui.tools.ContactQZoneWebView", localIntent);
    GMTrace.o(935363346432L, 6969);
  }
  
  public final void MS(String paramString)
  {
    GMTrace.i(935229128704L, 6968);
    if ((paramString == null) || (paramString.length() == 0))
    {
      v.e("MicroMsg.ViewQZone", "go fail, qqNum is null");
      GMTrace.o(935229128704L, 6968);
      return;
    }
    this.sLS = paramString;
    ap.yY();
    String str1 = (String)c.vr().get(46, null);
    ap.yY();
    String str2 = bf.mz((String)c.vr().get(72, null));
    v.i("MicroMsg.ViewQZone", "get a2key:[%s], get new a2key:[%s]", new Object[] { str1, str2 });
    if ((bf.mA(str1)) && (bf.mA(str2)))
    {
      MT(paramString);
      GMTrace.o(935229128704L, 6968);
      return;
    }
    ap.vd().a(233, this);
    this.pbp = new l(com.tencent.mm.a.o.aY(paramString), (int)System.currentTimeMillis());
    ap.vd().a(this.pbp, 0);
    this.ouW.v(3000L, 3000L);
    GMTrace.o(935229128704L, 6968);
  }
  
  public final void a(int paramInt1, int paramInt2, String paramString, k paramk)
  {
    GMTrace.i(935497564160L, 6970);
    this.ouW.KI();
    if (this.lVC != null) {
      this.lVC.dismiss();
    }
    ap.vd().b(233, this);
    if ((paramInt1 == 0) && (paramInt2 == 0))
    {
      paramString = (l)paramk;
      paramk = paramString.IR();
      if ((paramk == null) || (paramk.length() == 0))
      {
        MT(this.sLS);
        GMTrace.o(935497564160L, 6970);
        return;
      }
      Intent localIntent = new Intent();
      localIntent.putExtra("rawUrl", paramk);
      localIntent.putExtra("useJs", true);
      localIntent.putExtra("vertical_scroll", true);
      localIntent.putExtra("neverGetA8Key", true);
      localIntent.putExtra("geta8key_session_id", paramString.IZ());
      d.b(this.context, "webview", ".ui.tools.ContactQZoneWebView", localIntent);
      GMTrace.o(935497564160L, 6970);
      return;
    }
    v.e("MicroMsg.ViewQZone", "getA8Key fail, errType = " + paramInt1 + ", errCode = " + paramInt2);
    MT(this.sLS);
    GMTrace.o(935497564160L, 6970);
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/pluginsdk/ui/applet/o.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */