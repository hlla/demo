package com.tencent.mm.plugin.ac;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.text.TextUtils;
import android.widget.Toast;
import com.tencent.gmtrace.GMTrace;
import com.tencent.mm.R.l;
import com.tencent.mm.a.g;
import com.tencent.mm.modelbiz.w;
import com.tencent.mm.sdk.platformtools.aa;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bf;
import com.tencent.mm.sdk.platformtools.r;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.storage.ar;
import com.tencent.mm.storage.x;
import com.tencent.mm.u.ap;
import com.tencent.mm.x.b;
import com.tencent.mm.x.h;
import com.tencent.mm.x.i;
import com.tencent.mm.x.n;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public final class c
  extends a
{
  public static String prQ;
  
  static
  {
    GMTrace.i(15048357445632L, 112119);
    prQ = "";
    GMTrace.o(15048357445632L, 112119);
  }
  
  public c()
  {
    GMTrace.i(6618947256320L, 49315);
    GMTrace.o(6618947256320L, 49315);
  }
  
  public final int getType()
  {
    GMTrace.i(6619081474048L, 49316);
    GMTrace.o(6619081474048L, 49316);
    return 2;
  }
  
  public final void n(Context paramContext, Intent paramIntent)
  {
    GMTrace.i(6619215691776L, 49317);
    final String str1 = com.tencent.mm.plugin.base.a.a.rJ(r.i(paramIntent, "id"));
    final String str2 = com.tencent.mm.plugin.base.a.a.rJ(r.i(paramIntent, "ext_info"));
    Object localObject1 = r.i(paramIntent, "token");
    if ((TextUtils.isEmpty(str1)) || (TextUtils.isEmpty(str2)) || (TextUtils.isEmpty((CharSequence)localObject1)))
    {
      v.e("MicroMsg.WebViewShortcutEntry", "jump to webview  failed, username or appId or token is null or nil.");
      GMTrace.o(6619215691776L, 49317);
      return;
    }
    Object localObject2 = new StringBuilder();
    ap.yY();
    if (!((String)localObject1).equals(com.tencent.mm.plugin.base.a.d.bo(str2, com.tencent.mm.u.c.uH())))
    {
      localObject2 = aa.getContext().getSharedPreferences("app_brand_global_sp", 0);
      if (localObject2 == null)
      {
        v.w("MicroMsg.WebViewShortcutEntry", "jump to webview failed, sp is null.");
        GMTrace.o(6619215691776L, 49317);
        return;
      }
      localObject3 = ((SharedPreferences)localObject2).getStringSet("uin_set", new HashSet());
      if ((localObject3 == null) || (((Set)localObject3).isEmpty()))
      {
        v.w("MicroMsg.WebViewShortcutEntry", "jump to webview failed, uin set is null or nil.");
        GMTrace.o(6619215691776L, 49317);
        return;
      }
      localObject2 = new HashSet();
      localObject3 = ((Set)localObject3).iterator();
      while (((Iterator)localObject3).hasNext()) {
        ((Set)localObject2).add(com.tencent.mm.plugin.base.a.a.bo(str2, (String)((Iterator)localObject3).next()));
      }
      if (!((Set)localObject2).contains(localObject1))
      {
        v.e("MicroMsg.WebViewShortcutEntry", "jump to webview failed, illegal token(%s).", new Object[] { localObject1 });
        Toast.makeText(paramContext, paramContext.getString(R.l.fnC), 1).show();
        GMTrace.o(6619215691776L, 49317);
        return;
      }
    }
    paramIntent.putExtra("type", 0);
    paramIntent.putExtra("id", "");
    localObject2 = "https://game.weixin.qq.com/cgi-bin/h5/static/gameloading/index.html?wegame_ssid=25&appid=" + str2;
    localObject1 = localObject2;
    if (!bf.mA(prQ)) {
      localObject1 = (String)localObject2 + "&" + prQ;
    }
    localObject2 = new Intent();
    ((Intent)localObject2).putExtra("rawUrl", (String)localObject1);
    ((Intent)localObject2).putExtra("from_shortcut", true);
    ((Intent)localObject2).putExtra("game_hv_menu_appid", str2);
    ((Intent)localObject2).addFlags(67108864);
    ((Intent)localObject2).addFlags(268435456);
    com.tencent.mm.bb.d.b(paramContext, "webview", ".ui.tools.game.H5GameWebViewUI", (Intent)localObject2);
    w.DR().hB(str1);
    localObject1 = r.i(paramIntent, "digest");
    if (TextUtils.isEmpty((CharSequence)localObject1))
    {
      v.i("MicroMsg.WebViewShortcutEntry", "digest is null");
      GMTrace.o(6619215691776L, 49317);
      return;
    }
    ap.yY();
    localObject2 = com.tencent.mm.u.c.wR().Rb(str1);
    if ((localObject2 == null) || (bf.mA(((x)localObject2).tK())))
    {
      v.i("MicroMsg.WebViewShortcutEntry", "no need update, displayName is null");
      GMTrace.o(6619215691776L, 49317);
      return;
    }
    localObject2 = ((x)localObject2).tK();
    Object localObject3 = n.Bm().hs(str1);
    if ((localObject3 == null) || (bf.mA(((h)localObject3).Bt())))
    {
      v.i("MicroMsg.WebViewShortcutEntry", "no need update, imgFlag is null");
      GMTrace.o(6619215691776L, 49317);
      return;
    }
    if (((String)localObject1).equals(g.n(((String)localObject2 + ((h)localObject3).Bt()).getBytes())))
    {
      v.i("MicroMsg.WebViewShortcutEntry", "no need update, digest is same");
      GMTrace.o(6619215691776L, 49317);
      return;
    }
    localObject1 = b.a(str1, false, -1);
    if ((localObject1 == null) || (((Bitmap)localObject1).isRecycled()))
    {
      v.i("MicroMsg.WebViewShortcutEntry", "icon is not downloaded, next time update");
      GMTrace.o(6619215691776L, 49317);
      return;
    }
    v.i("MicroMsg.WebViewShortcutEntry", "update shortcut, displayName = %s", new Object[] { localObject2 });
    com.tencent.mm.plugin.base.a.d.d(paramContext, str1, str2, com.tencent.mm.plugin.base.a.a.rJ(r.i(paramIntent, "ext_info_1")));
    ae.f(new Runnable()
    {
      public final void run()
      {
        GMTrace.i(6619752562688L, 49321);
        com.tencent.mm.plugin.base.a.d.a(aa.getContext(), str1, str2, null);
        GMTrace.o(6619752562688L, 49321);
      }
    }, 1000L);
    GMTrace.o(6619215691776L, 49317);
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/plugin/ac/c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */