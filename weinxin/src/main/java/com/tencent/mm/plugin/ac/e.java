package com.tencent.mm.plugin.ac;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.text.TextUtils;
import android.widget.Toast;
import com.tencent.gmtrace.GMTrace;
import com.tencent.mm.R.l;
import com.tencent.mm.e.a.bp;
import com.tencent.mm.e.a.bp.b;
import com.tencent.mm.e.a.pr;
import com.tencent.mm.e.a.pr.b;
import com.tencent.mm.plugin.appbrand.config.WxaAttributes;
import com.tencent.mm.sdk.platformtools.aa;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.r;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.u.ap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public final class e
  extends a
{
  public e()
  {
    GMTrace.i(6620155215872L, 49324);
    GMTrace.o(6620155215872L, 49324);
  }
  
  public final int getType()
  {
    GMTrace.i(6620289433600L, 49325);
    GMTrace.o(6620289433600L, 49325);
    return 1;
  }
  
  public final void n(final Context paramContext, Intent paramIntent)
  {
    GMTrace.i(6620423651328L, 49326);
    com.tencent.mm.plugin.report.service.g.oSF.a(443L, 2L, 1L, false);
    final String str = com.tencent.mm.plugin.base.a.a.rJ(r.i(paramIntent, "id"));
    Object localObject1 = com.tencent.mm.plugin.base.a.a.rJ(r.i(paramIntent, "ext_info"));
    Object localObject2 = r.i(paramIntent, "token");
    final int i = r.a(paramIntent, "ext_info_1", 0);
    if ((TextUtils.isEmpty(str)) || (TextUtils.isEmpty((CharSequence)localObject1)) || (TextUtils.isEmpty((CharSequence)localObject2)))
    {
      v.e("MiroMsg.WxaShortcutEntry", "jump to Wxa failed, username or appId or token is null or nil.");
      i = 0;
    }
    for (;;)
    {
      if (i == 0) {
        com.tencent.mm.plugin.report.service.g.oSF.a(443L, 3L, 1L, false);
      }
      GMTrace.o(6620423651328L, 49326);
      return;
      if (!com.tencent.mm.t.h.em(str))
      {
        v.e("MiroMsg.WxaShortcutEntry", "jump to Wxa failed, username %s invalid ", new Object[] { str });
        com.tencent.mm.plugin.report.c.oRz.a(647L, 1L, 1L, false);
        i = 0;
      }
      else
      {
        localObject3 = new StringBuilder();
        ap.yY();
        if (!((String)localObject2).equals(com.tencent.mm.plugin.base.a.a.bo((String)localObject1, com.tencent.mm.u.c.uH())))
        {
          localObject3 = aa.getContext().getSharedPreferences("app_brand_global_sp", 0);
          if (localObject3 == null)
          {
            v.w("MiroMsg.WxaShortcutEntry", "jump to Wxa failed, sp is null.");
            i = 0;
            continue;
          }
          Object localObject4 = ((SharedPreferences)localObject3).getStringSet("uin_set", new HashSet());
          if ((localObject4 == null) || (((Set)localObject4).isEmpty()))
          {
            v.w("MiroMsg.WxaShortcutEntry", "jump to Wxa failed, uin set is null or nil.");
            i = 0;
            continue;
          }
          localObject3 = new HashSet();
          localObject4 = ((Set)localObject4).iterator();
          while (((Iterator)localObject4).hasNext()) {
            ((Set)localObject3).add(com.tencent.mm.plugin.base.a.a.bo((String)localObject1, (String)((Iterator)localObject4).next()));
          }
          if (!((Set)localObject3).contains(localObject2))
          {
            v.e("MiroMsg.WxaShortcutEntry", "jump to Wxa failed, illegal token(%s).", new Object[] { localObject2 });
            i = 0;
            continue;
          }
        }
        if ((com.tencent.mm.sdk.a.b.bIk()) || (i != 1)) {
          break;
        }
        v.i("MiroMsg.WxaShortcutEntry", "can not open testing WeApp in released WeChat.");
        i = 0;
      }
    }
    localObject2 = new pr();
    ((pr)localObject2).fWr.appId = ((String)localObject1);
    ((pr)localObject2).fWr.userName = str;
    ((pr)localObject2).fWr.fWu = i;
    ((pr)localObject2).fWr.scene = 1023;
    ((pr)localObject2).fWr.fWx = true;
    ((pr)localObject2).fWr.context = paramContext;
    ((pr)localObject2).fWr.fWy = false;
    com.tencent.mm.sdk.b.a.uql.m((com.tencent.mm.sdk.b.b)localObject2);
    if (((pr)localObject2).fWs.fWD) {
      v.i("MiroMsg.WxaShortcutEntry", "open wxa with id : %s", new Object[] { str });
    }
    for (;;)
    {
      localObject1 = r.i(paramIntent, "digest");
      if (TextUtils.isEmpty((CharSequence)localObject1)) {
        break label694;
      }
      localObject2 = ((com.tencent.mm.plugin.appbrand.i.b)com.tencent.mm.kernel.h.h(com.tencent.mm.plugin.appbrand.i.b.class)).og(str);
      if (localObject2 != null) {
        break label594;
      }
      v.e("MiroMsg.WxaShortcutEntry", "no such WeApp(%s)", new Object[] { str });
      i = 1;
      break;
      if (i == 1) {
        Toast.makeText(paramContext, R.l.dDE, 0).show();
      } else if (i == 2) {
        Toast.makeText(paramContext, R.l.dEO, 0).show();
      }
    }
    label594:
    Object localObject3 = ((WxaAttributes)localObject2).field_nickname;
    if (!((String)localObject1).equals(com.tencent.mm.a.g.n(((String)localObject3 + ((WxaAttributes)localObject2).field_roundedSquareIconURL + ((WxaAttributes)localObject2).field_bigHeadURL).getBytes())))
    {
      v.i("MiroMsg.WxaShortcutEntry", "update shortcut for wxa(%s)", new Object[] { str });
      if (paramContext != null) {
        break label718;
      }
      v.e("MicroMsg.AppBrandShortcutManager", "remove fail, context or username is null.");
    }
    for (;;)
    {
      ae.f(new Runnable()
      {
        public final void run()
        {
          GMTrace.i(6620692086784L, 49328);
          com.tencent.mm.plugin.base.a.a.b(paramContext, str, i);
          GMTrace.o(6620692086784L, 49328);
        }
      }, 1000L);
      label694:
      paramIntent.putExtra("type", 0);
      paramIntent.putExtra("id", "");
      i = 1;
      break;
      label718:
      if (paramIntent == null)
      {
        v.e("MicroMsg.AppBrandShortcutManager", "remove fail, intent is null");
      }
      else
      {
        localObject1 = new bp();
        ((bp)localObject1).fEP.username = str;
        com.tencent.mm.sdk.b.a.uql.m((com.tencent.mm.sdk.b.b)localObject1);
        if (((bp)localObject1).fEQ.fES != null) {
          break label794;
        }
        v.e("MicroMsg.AppBrandShortcutManager", "no such WeApp(%s)", new Object[] { str });
      }
    }
    label794:
    if (TextUtils.isEmpty(((bp)localObject1).fEQ.fER)) {}
    for (localObject1 = str;; localObject1 = ((bp)localObject1).fEQ.fER)
    {
      localObject2 = new Intent("com.android.launcher.action.UNINSTALL_SHORTCUT");
      ((Intent)localObject2).putExtra("android.intent.extra.shortcut.NAME", (String)localObject1);
      ((Intent)localObject2).putExtra("duplicate", false);
      ((Intent)localObject2).putExtra("android.intent.extra.shortcut.INTENT", paramIntent);
      paramContext.sendBroadcast((Intent)localObject2);
      v.i("MicroMsg.AppBrandShortcutManager", "remove shortcut %s", new Object[] { str });
      break;
    }
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/plugin/ac/e.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */