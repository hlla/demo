package com.tencent.mm.pluginsdk;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.net.Uri;
import android.widget.Toast;
import com.tencent.gmtrace.GMTrace;
import com.tencent.mm.R.l;
import com.tencent.mm.e.a.br;
import com.tencent.mm.e.a.hf;
import com.tencent.mm.e.a.hf.a;
import com.tencent.mm.kernel.h;
import com.tencent.mm.modelsimple.ah;
import com.tencent.mm.modelsimple.l;
import com.tencent.mm.pluginsdk.wallet.PayInfo;
import com.tencent.mm.protocal.GeneralControlWrapper;
import com.tencent.mm.protocal.JsapiPermissionWrapper;
import com.tencent.mm.protocal.c.bfo;
import com.tencent.mm.protocal.c.ch;
import com.tencent.mm.sdk.platformtools.aa;
import com.tencent.mm.sdk.platformtools.bf;
import com.tencent.mm.sdk.platformtools.f;
import com.tencent.mm.sdk.platformtools.u;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.storage.aq;
import com.tencent.mm.storage.ar;
import com.tencent.mm.u.ag.a;
import com.tencent.mm.u.ag.b;
import com.tencent.mm.u.ag.b.a;
import com.tencent.mm.u.ap;
import com.tencent.mm.u.m;
import com.tencent.mm.u.o;
import com.tencent.mm.ui.MMWizardActivity;
import com.tencent.mm.ui.base.b;
import com.tencent.mm.y.e;
import com.tencent.mm.y.k;
import com.tencent.mm.y.n;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

public final class d
{
  public static String szE;
  private static final Map<String, Long> szF;
  
  static
  {
    GMTrace.i(1240708677632L, 9244);
    szE = "";
    HashMap localHashMap = new HashMap();
    szF = localHashMap;
    localHashMap.put("weixin://", Long.valueOf(0L));
    szF.put("weixin://dl/stickers", Long.valueOf(1L));
    szF.put("weixin://dl/games", Long.valueOf(2L));
    szF.put("weixin://dl/moments", Long.valueOf(4L));
    szF.put("weixin://dl/add", Long.valueOf(8L));
    szF.put("weixin://dl/shopping", Long.valueOf(16L));
    szF.put("weixin://dl/groupchat", Long.valueOf(32L));
    szF.put("weixin://dl/scan", Long.valueOf(64L));
    szF.put("weixin://dl/profile", Long.valueOf(128L));
    szF.put("weixin://dl/settings", Long.valueOf(256L));
    szF.put("weixin://dl/general", Long.valueOf(512L));
    szF.put("weixin://dl/help", Long.valueOf(1024L));
    szF.put("weixin://dl/notifications", Long.valueOf(2048L));
    szF.put("weixin://dl/terms", Long.valueOf(4096L));
    szF.put("weixin://dl/chat", Long.valueOf(8192L));
    szF.put("weixin://dl/features", Long.valueOf(16384L));
    szF.put("weixin://dl/clear", Long.valueOf(32768L));
    szF.put("weixin://dl/feedback", Long.valueOf(65536L));
    szF.put("weixin://dl/faq", Long.valueOf(131072L));
    szF.put("weixin://dl/recommendation", Long.valueOf(262144L));
    szF.put("weixin://dl/groups", Long.valueOf(524288L));
    szF.put("weixin://dl/tags", Long.valueOf(1048576L));
    szF.put("weixin://dl/officialaccounts", Long.valueOf(2097152L));
    szF.put("weixin://dl/posts", Long.valueOf(4194304L));
    szF.put("weixin://dl/favorites", Long.valueOf(8388608L));
    szF.put("weixin://dl/privacy", Long.valueOf(16777216L));
    szF.put("weixin://dl/security", Long.valueOf(33554432L));
    szF.put("weixin://dl/wallet", Long.valueOf(67108864L));
    szF.put("weixin://dl/businessPay", Long.valueOf(134217728L));
    szF.put("weixin://dl/businessPay/", Long.valueOf(134217728L));
    szF.put("weixin://dl/wechatout", Long.valueOf(268435456L));
    szF.put("weixin://dl/protection", Long.valueOf(1073741824L));
    szF.put("weixin://dl/card", Long.valueOf(2147483648L));
    szF.put("weixin://dl/about", Long.valueOf(1125899906842624L));
    szF.put("weixin://dl/blacklist", Long.valueOf(4294967296L));
    szF.put("weixin://dl/textsize", Long.valueOf(8589934592L));
    szF.put("weixin://dl/sight", Long.valueOf(17179869184L));
    szF.put("weixin://dl/languages", Long.valueOf(34359738368L));
    szF.put("weixin://dl/chathistory", Long.valueOf(68719476736L));
    szF.put("weixin://dl/bindqq", Long.valueOf(137438953472L));
    szF.put("weixin://dl/bindmobile", Long.valueOf(274877906944L));
    szF.put("weixin://dl/bindemail", Long.valueOf(549755813888L));
    szF.put("weixin://dl/securityassistant", Long.valueOf(1099511627776L));
    szF.put("weixin://dl/broadcastmessage", Long.valueOf(2199023255552L));
    szF.put("weixin://dl/setname", Long.valueOf(4398046511104L));
    szF.put("weixin://dl/myQRcode", Long.valueOf(8796093022208L));
    szF.put("weixin://dl/myaddress", Long.valueOf(17592186044416L));
    szF.put("weixin://dl/hidemoments", Long.valueOf(35184372088832L));
    szF.put("weixin://dl/blockmoments", Long.valueOf(70368744177664L));
    szF.put("weixin://dl/stickersetting", Long.valueOf(140737488355328L));
    szF.put("weixin://dl/log", Long.valueOf(281474976710656L));
    szF.put("weixin://dl/wechatoutcoupon", Long.valueOf(562949953421312L));
    szF.put("weixin://dl/wechatoutshare", Long.valueOf(18014398509481984L));
    szF.put("weixin://dl/personalemoticon", Long.valueOf(4503599627370496L));
    szF.put("weixin://dl/designeremoji", Long.valueOf(9007199254740992L));
    szF.put("weixin://dl/sightdraft", Long.valueOf(576460752303423488L));
    szF.put("weixin://dl/jumpWxa/", Long.valueOf(576460752303423489L));
    GMTrace.o(1240708677632L, 9244);
  }
  
  private static void K(Context paramContext, int paramInt)
  {
    GMTrace.i(1240171806720L, 9240);
    String str;
    if ((!f.uqJ) && (u.bID().equals("zh_CN"))) {
      str = paramContext.getString(R.l.fmP);
    }
    for (;;)
    {
      v.d("MicroMsg.DeepLinkHelper", "using faq webpage");
      Intent localIntent = new Intent();
      localIntent.putExtra("rawUrl", str);
      localIntent.putExtra("show_feedback", false);
      localIntent.putExtra("geta8key_session_id", paramInt);
      com.tencent.mm.bb.d.b(paramContext, "webview", ".ui.tools.WebViewUI", localIntent);
      GMTrace.o(1240171806720L, 9240);
      return;
      if (u.bID().equals("zh_HK")) {
        str = paramContext.getString(R.l.fmQ);
      } else if (u.bID().equals("zh_TW")) {
        str = paramContext.getString(R.l.fmR);
      } else {
        str = paramContext.getString(R.l.fmS);
      }
    }
  }
  
  public static boolean LC(String paramString)
  {
    GMTrace.i(1238426976256L, 9227);
    paramString = LG(paramString);
    if ((szF.containsKey(paramString)) || (LD(paramString)))
    {
      GMTrace.o(1238426976256L, 9227);
      return true;
    }
    GMTrace.o(1238426976256L, 9227);
    return false;
  }
  
  public static boolean LD(String paramString)
  {
    GMTrace.i(1238561193984L, 9228);
    if ((!bf.mA(paramString)) && (paramString.startsWith("weixin://dl/business")))
    {
      GMTrace.o(1238561193984L, 9228);
      return true;
    }
    GMTrace.o(1238561193984L, 9228);
    return false;
  }
  
  private static boolean LE(String paramString)
  {
    GMTrace.i(1238963847168L, 9231);
    if (((paramString.equals("weixin://dl/wechatout")) || (paramString.equals("weixin://dl/wechatoutcoupon")) || (paramString.equals("weixin://dl/wechatoutshare"))) && (!Boolean.valueOf(com.tencent.mm.plugin.ipcall.d.aDF()).booleanValue()))
    {
      paramString = new Intent();
      paramString.setFlags(268435456);
      paramString.setClassName(aa.getContext(), "com.tencent.mm.plugin.webview.ui.tools.WebViewUI");
      paramString.putExtra("rawUrl", "https://support.weixin.qq.com/deeplink/noaccess#wechat_redirect");
      aa.getContext().startActivity(paramString);
      GMTrace.o(1238963847168L, 9231);
      return true;
    }
    GMTrace.o(1238963847168L, 9231);
    return false;
  }
  
  public static boolean LF(String paramString)
  {
    GMTrace.i(1239500718080L, 9235);
    boolean bool = a(null, paramString, 0, (int)System.currentTimeMillis(), null);
    GMTrace.o(1239500718080L, 9235);
    return bool;
  }
  
  private static String LG(String paramString)
  {
    GMTrace.i(1240306024448L, 9241);
    String str = null;
    if (!bf.mA(paramString))
    {
      paramString = Uri.parse(paramString);
      str = paramString.getScheme() + "://" + paramString.getHost() + paramString.getPath();
    }
    GMTrace.o(1240306024448L, 9241);
    return str;
  }
  
  public static boolean X(String paramString, long paramLong)
  {
    GMTrace.i(1238292758528L, 9226);
    if (!bf.mA(paramString))
    {
      paramString = LG(paramString);
      if (!szF.containsKey(paramString)) {
        break label92;
      }
    }
    label92:
    for (long l = ((Long)szF.get(paramString)).longValue();; l = -1L)
    {
      if ((l != -1L) && ((l == 0L) || ((l & paramLong) == l))) {}
      for (boolean bool = true;; bool = false)
      {
        GMTrace.o(1238292758528L, 9226);
        return bool;
      }
    }
  }
  
  public static void a(Context paramContext, String paramString, int paramInt, a parama)
  {
    GMTrace.i(1239366500352L, 9234);
    a(paramContext, paramString, paramInt, parama, null, null);
    GMTrace.o(1239366500352L, 9234);
  }
  
  public static void a(Context paramContext, final String paramString1, final int paramInt, final a parama, String paramString2, String paramString3)
  {
    GMTrace.i(1239232282624L, 9233);
    LinkedList localLinkedList = new LinkedList();
    ch localch = new ch();
    if ((!bf.mA(paramString2)) && (!bf.mA(paramString3)))
    {
      v.i("MicroMsg.DeepLinkHelper", "package name = %s, package signature = %s", new Object[] { paramString2, paramString3 });
      localch.tdU = paramString2;
      localch.signature = paramString3;
      localLinkedList.add(localch);
    }
    if (LE(paramString1))
    {
      GMTrace.o(1239232282624L, 9233);
      return;
    }
    paramString2 = new ah(paramString1, paramInt, localLinkedList);
    paramContext = new e()
    {
      public final void a(int paramAnonymousInt1, int paramAnonymousInt2, String paramAnonymousString, k paramAnonymousk)
      {
        GMTrace.i(898721906688L, 6696);
        ap.vd().b(1200, this);
        v.i("MicroMsg.DeepLinkHelper", "doTicketsDeepLink: errType = %s; errCode = %s; errMsg = %s", new Object[] { Integer.valueOf(paramAnonymousInt1), Integer.valueOf(paramAnonymousInt2), paramAnonymousString });
        boolean bool2 = false;
        boolean bool3 = false;
        boolean bool1 = bool3;
        String str;
        if (paramAnonymousk != null)
        {
          bool1 = bool3;
          if ((paramAnonymousk instanceof ah))
          {
            str = ((ah)paramAnonymousk).Jz();
            if (!d.LC(str)) {
              break label284;
            }
          }
        }
        for (bool1 = bool2;; bool1 = true)
        {
          try
          {
            v.i("MicroMsg.DeepLinkHelper", "doTicketsDeepLink: deepLinkUri = %s", new Object[] { str });
            bool1 = bool2;
            bool2 = d.a(this.val$context, str, paramInt, paramString1);
            bool1 = bool2;
            com.tencent.mm.plugin.report.service.g.oSF.i(11405, new Object[] { paramString1, Integer.valueOf(paramInt), Integer.valueOf(1), str });
            bool1 = bool2;
          }
          catch (Exception localException)
          {
            for (;;)
            {
              v.printErrStackTrace("MicroMsg.DeepLinkHelper", localException, "", new Object[] { "" });
              com.tencent.mm.plugin.report.service.g.oSF.i(11405, new Object[] { paramString1, Integer.valueOf(paramInt), Integer.valueOf(0), str });
            }
          }
          if (parama != null) {
            parama.a(paramAnonymousInt1, paramAnonymousInt2, paramAnonymousString, paramAnonymousk, bool1);
          }
          GMTrace.o(898721906688L, 6696);
          return;
          label284:
          v.i("MicroMsg.DeepLinkHelper", "doTicketsDeepLink: translate failed");
          Intent localIntent = new Intent();
          localIntent.setFlags(268435456);
          localIntent.setClassName(aa.getContext(), "com.tencent.mm.plugin.webview.ui.tools.WebViewUI");
          localIntent.putExtra("rawUrl", "https://support.weixin.qq.com/deeplink/noaccess#wechat_redirect");
          localIntent.putExtra("showShare", false);
          aa.getContext().startActivity(localIntent);
          com.tencent.mm.plugin.report.service.g.oSF.i(11405, new Object[] { paramString1, Integer.valueOf(paramInt), Integer.valueOf(0), str });
        }
      }
    };
    ap.vd().a(1200, paramContext);
    ap.vd().a(paramString2, 0);
    GMTrace.o(1239232282624L, 9233);
  }
  
  public static void a(Context paramContext, final String paramString1, final String paramString2, final int paramInt, String paramString3, final a parama)
  {
    GMTrace.i(1239098064896L, 9232);
    if (bf.mA(paramString1)) {
      paramString1 = paramString3;
    }
    while (LE(paramString1))
    {
      GMTrace.o(1239098064896L, 9232);
      return;
    }
    paramString3 = new l(paramString1, paramString2, paramInt, (int)System.currentTimeMillis());
    paramContext = new e()
    {
      public final void a(int paramAnonymousInt1, int paramAnonymousInt2, String paramAnonymousString, k paramAnonymousk)
      {
        GMTrace.i(1234132008960L, 9195);
        ap.vd().b(233, this);
        v.i("MicroMsg.DeepLinkHelper", "[oneliang][doDeepLink][onSceneEnd]:errType:%s,errCode:%s,errMsg:%s", new Object[] { Integer.valueOf(paramAnonymousInt1), Integer.valueOf(paramAnonymousInt2), paramAnonymousString });
        boolean bool2 = false;
        boolean bool3 = false;
        boolean bool1 = bool3;
        l locall;
        String str;
        if (paramAnonymousk != null)
        {
          bool1 = bool3;
          if ((paramAnonymousk instanceof l))
          {
            locall = (l)paramAnonymousk;
            v.d("MicroMsg.DeepLinkHelper", "bitset:" + locall.IX());
            long l = locall.IX();
            str = locall.IR();
            if (!d.X(str, l)) {
              break label339;
            }
          }
        }
        for (bool1 = bool2;; bool1 = true)
        {
          try
          {
            v.i("MicroMsg.DeepLinkHelper", "[oneliang] uri: %s", new Object[] { str });
            bool1 = bool2;
            bool2 = d.c(this.val$context, locall.IZ(), str);
            bool1 = bool2;
            com.tencent.mm.plugin.report.service.g.oSF.i(11405, new Object[] { str, Integer.valueOf(1), Integer.valueOf(paramInt), paramString2, bf.mz(paramString1) });
            bool1 = bool2;
          }
          catch (Exception localException)
          {
            for (;;)
            {
              v.printErrStackTrace("MicroMsg.DeepLinkHelper", localException, "", new Object[] { "" });
              com.tencent.mm.plugin.report.service.g.oSF.i(11405, new Object[] { str, Integer.valueOf(0), Integer.valueOf(paramInt), paramString2, bf.mz(paramString1) });
            }
          }
          if (parama != null) {
            parama.a(paramAnonymousInt1, paramAnonymousInt2, paramAnonymousString, paramAnonymousk, bool1);
          }
          GMTrace.o(1234132008960L, 9195);
          return;
          label339:
          v.i("MicroMsg.DeepLinkHelper", "[oneliang] no permission");
          Intent localIntent = new Intent();
          localIntent.setFlags(268435456);
          localIntent.setClassName(aa.getContext(), "com.tencent.mm.plugin.webview.ui.tools.WebViewUI");
          localIntent.putExtra("rawUrl", "https://support.weixin.qq.com/deeplink/noaccess#wechat_redirect");
          localIntent.putExtra("geta8key_session_id", localException.IZ());
          aa.getContext().startActivity(localIntent);
          com.tencent.mm.plugin.report.service.g.oSF.i(11405, new Object[] { str, Integer.valueOf(0), Integer.valueOf(paramInt), paramString2, bf.mz(paramString1) });
        }
      }
    };
    ap.vd().a(233, paramContext);
    ap.vd().a(paramString3, 0);
    GMTrace.o(1239098064896L, 9232);
  }
  
  private static boolean a(final Context paramContext, String paramString1, int paramInt1, int paramInt2, String paramString2)
  {
    GMTrace.i(17950413160448L, 133741);
    Object localObject1 = LG(paramString1);
    if (bf.mA((String)localObject1))
    {
      GMTrace.o(17950413160448L, 133741);
      return false;
    }
    long l;
    Object localObject3;
    Object localObject2;
    if (szF.containsKey(localObject1))
    {
      l = ((Long)szF.get(localObject1)).longValue();
      v.i("MicroMsg.DeepLinkHelper", "gotoUri, deepLinkMap contains uri, result = %d", new Object[] { Long.valueOf(l) });
      localObject1 = null;
      localObject3 = new Intent();
      ((Intent)localObject3).setFlags(268435456);
      if (l == 0L)
      {
        localObject1 = "com.tencent.mm.ui.LauncherUI";
        localObject2 = localObject3;
        if (bf.mA((String)localObject1)) {
          break label3048;
        }
        ((Intent)localObject2).setClassName(aa.getContext(), (String)localObject1);
        if (paramContext == null) {
          break label3007;
        }
      }
    }
    for (;;)
    {
      String str1;
      String str2;
      int i;
      try
      {
        paramContext.startActivity((Intent)localObject2);
        GMTrace.o(17950413160448L, 133741);
        return true;
        if (l == 1L)
        {
          localObject1 = "com.tencent.mm.plugin.emoji.ui.v2.EmojiStoreV2UI";
          com.tencent.mm.plugin.report.service.g.oSF.i(12065, new Object[] { Integer.valueOf(7) });
          localObject2 = localObject3;
          break;
        }
        if (l == 2L)
        {
          ((Intent)localObject3).putExtra("from_deeplink", true);
          ((Intent)localObject3).putExtra("game_report_from_scene", 6);
          localObject1 = "com.tencent.mm.plugin.game.ui.GameCenterUI";
          localObject2 = localObject3;
          break;
        }
        if (l == 4L)
        {
          if ((m.xW() & 0x8000) == 0)
          {
            paramInt1 = 1;
            localObject2 = localObject3;
            if (paramInt1 == 0) {
              break;
            }
            localObject1 = "com.tencent.mm.plugin.sns.ui.En_424b8e16";
            ((Intent)localObject3).putExtra("sns_timeline_NeedFirstLoadint", true);
            localObject2 = localObject3;
            break;
          }
          paramInt1 = 0;
          continue;
        }
        if (l == 8L)
        {
          localObject1 = "com.tencent.mm.plugin.subapp.ui.pluginapp.AddMoreFriendsUI";
          localObject2 = localObject3;
          break;
        }
        if (l == 16L)
        {
          paramString1 = new hf();
          com.tencent.mm.sdk.b.a.uql.m(paramString1);
          paramString1 = paramString1.fMx.url;
          localObject2 = localObject3;
          if (bf.mA(paramString1)) {
            break;
          }
          ((Intent)localObject3).putExtra("rawUrl", paramString1);
          ((Intent)localObject3).putExtra("useJs", true);
          ((Intent)localObject3).putExtra("vertical_scroll", true);
          ((Intent)localObject3).putExtra("geta8key_session_id", paramInt2);
          localObject1 = "com.tencent.mm.plugin.webview.ui.tools.WebViewUI";
          localObject2 = localObject3;
          break;
        }
        if (l == 32L)
        {
          ((Intent)localObject3).putExtra("titile", aa.getContext().getString(R.l.dCJ));
          ((Intent)localObject3).putExtra("list_type", 0);
          ((Intent)localObject3).putExtra("list_attr", com.tencent.mm.ui.contact.s.q(new int[] { com.tencent.mm.ui.contact.s.vWQ, 256, 512 }));
          localObject1 = "com.tencent.mm.ui.contact.SelectContactUI";
          localObject2 = localObject3;
          break;
        }
        if (l == 64L)
        {
          localObject1 = "com.tencent.mm.plugin.scanner.ui.BaseScanUI";
          ((Intent)localObject3).putExtra("animation_pop_in", true);
          localObject2 = localObject3;
          break;
        }
        if (l == 128L)
        {
          localObject1 = "com.tencent.mm.plugin.setting.ui.setting.SettingsPersonalInfoUI";
          localObject2 = localObject3;
          break;
        }
        if (l == 256L)
        {
          localObject1 = "com.tencent.mm.plugin.setting.ui.setting.SettingsUI";
          localObject2 = localObject3;
          break;
        }
        if (l == 512L)
        {
          localObject1 = "com.tencent.mm.plugin.setting.ui.setting.SettingsAboutSystemUI";
          localObject2 = localObject3;
          break;
        }
        if (l == 1024L)
        {
          K(aa.getContext(), paramInt2);
          localObject2 = localObject3;
          break;
        }
        if (l == 2048L)
        {
          localObject1 = "com.tencent.mm.plugin.setting.ui.setting.SettingsNotificationUI";
          localObject2 = localObject3;
          break;
        }
        if (l == 4096L)
        {
          ((Intent)localObject3).putExtra("title", aa.getContext().getResources().getString(R.l.eGL));
          ((Intent)localObject3).putExtra("rawUrl", aa.getContext().getResources().getString(R.l.eZh));
          ((Intent)localObject3).putExtra("showShare", false);
          ((Intent)localObject3).putExtra("geta8key_session_id", paramInt2);
          localObject1 = "com.tencent.mm.plugin.webview.ui.tools.WebViewUI";
          localObject2 = localObject3;
          break;
        }
        if (l == 8192L)
        {
          localObject1 = "com.tencent.mm.plugin.setting.ui.setting.SettingsChattingUI";
          localObject2 = localObject3;
          break;
        }
        if (l == 16384L)
        {
          localObject1 = "com.tencent.mm.plugin.setting.ui.setting.SettingsPluginsUI";
          localObject2 = localObject3;
          break;
        }
        if (l == 32768L)
        {
          localObject1 = "com.tencent.mm.plugin.clean.ui.CleanUI";
          localObject2 = localObject3;
          break;
        }
        if (l == 65536L) {
          try
          {
            paramInt1 = paramString1.indexOf("?");
            if (paramInt1 <= 0) {
              break label4042;
            }
            paramString1 = paramString1.substring(paramInt1 + 1);
            h.vG();
            paramInt1 = com.tencent.mm.kernel.a.uH();
            paramString2 = URLEncoder.encode(com.tencent.mm.protocal.d.sXf, "utf-8");
            localObject2 = URLEncoder.encode(bf.bJI(), "utf-8");
            str1 = URLEncoder.encode(com.tencent.mm.compatible.d.p.rA(), "utf-8");
            str2 = URLEncoder.encode(com.tencent.mm.protocal.d.sXa, "utf-8");
            String str3 = URLEncoder.encode(com.tencent.mm.protocal.d.sXb, "utf-8");
            String str4 = URLEncoder.encode(com.tencent.mm.protocal.d.sXc, "utf-8");
            String str5 = URLEncoder.encode(ap.uY(), "utf-8");
            String str6 = URLEncoder.encode(bf.ep(aa.getContext()), "utf-8");
            paramString2 = new StringBuilder("&uin=").append(paramInt1).append("&deviceName=").append(paramString2).append("&timeZone=").append((String)localObject2).append("&imei=").append(str1).append("&deviceBrand=").append(str2).append("&deviceModel=").append(str3).append("&ostype=").append(str4).append("&clientSeqID=").append(str5).append("&signature=").append(str6).append("&scene=");
            if (bf.mA(paramString1))
            {
              paramInt1 = 0;
              paramString2 = paramInt1;
              paramString1 = "https://support.weixin.qq.com/cgi-bin/mmsupport-bin/readtemplate?t=feedback/index" + "&version=" + com.tencent.mm.protocal.d.sXh + "&lang=" + u.ea(aa.getContext()) + "&" + bf.mz(paramString1) + paramString2;
              ((Intent)localObject3).putExtra("showShare", false);
              ((Intent)localObject3).putExtra("rawUrl", paramString1);
              ((Intent)localObject3).putExtra("neverGetA8Key", true);
              ((Intent)localObject3).putExtra("geta8key_session_id", paramInt2);
              ((Intent)localObject3).putExtra("hardcode_jspermission", JsapiPermissionWrapper.sXt);
              ((Intent)localObject3).putExtra("hardcode_general_ctrl", GeneralControlWrapper.sXq);
              localObject1 = "com.tencent.mm.plugin.webview.ui.tools.WebViewUI";
              localObject2 = localObject3;
              break;
            }
            paramInt1 = 1;
            continue;
          }
          catch (UnsupportedEncodingException paramString1)
          {
            v.e("MicroMsg.DeepLinkHelper", "[oneliang]UnsupportedEncodingException:%s", new Object[] { paramString1.getMessage() });
            localObject2 = localObject3;
          }
        }
        if (l == 131072L)
        {
          h.vG();
          paramInt1 = com.tencent.mm.kernel.a.uH();
          ap.yY();
          i = bf.f((Integer)com.tencent.mm.u.c.vr().get(12304, null));
          paramString1 = aa.getContext().getString(R.l.eUh, new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(i) });
          ((Intent)localObject3).putExtra("showShare", false);
          ((Intent)localObject3).putExtra("rawUrl", paramString1);
          ((Intent)localObject3).putExtra("geta8key_session_id", paramInt2);
          localObject1 = "com.tencent.mm.plugin.webview.ui.tools.WebViewUI";
          localObject2 = localObject3;
          break;
        }
        if (l == 262144L)
        {
          localObject1 = "com.tencent.mm.plugin.subapp.ui.friend.FMessageConversationUI";
          localObject2 = localObject3;
          break;
        }
        if (l == 524288L)
        {
          localObject1 = "com.tencent.mm.ui.contact.ChatroomContactUI";
          localObject2 = localObject3;
          break;
        }
        if (l == 1048576L)
        {
          localObject1 = "com.tencent.mm.plugin.label.ui.ContactLabelManagerUI";
          localObject2 = localObject3;
          break;
        }
        if (l == 2097152L)
        {
          localObject1 = "com.tencent.mm.plugin.brandservice.ui.BrandServiceIndexUI";
          localObject2 = localObject3;
          break;
        }
        if (l == 268435456L)
        {
          ((Intent)localObject3).putExtra("IPCallAddressUI_KFrom", 1);
          com.tencent.mm.bb.d.b(aa.getContext(), "ipcall", ".ui.IPCallAddressUI", (Intent)localObject3);
          GMTrace.o(17950413160448L, 133741);
          return true;
        }
        if (l == 4194304L)
        {
          ap.yY();
          ((Intent)localObject3).putExtra("sns_userName", (String)com.tencent.mm.u.c.vr().get(2, null));
          ((Intent)localObject3).addFlags(67108864);
          ap.yY();
          paramInt1 = bf.a((Integer)com.tencent.mm.u.c.vr().get(68389, null), 0);
          ap.yY();
          com.tencent.mm.u.c.vr().set(68389, Integer.valueOf(paramInt1 + 1));
          localObject1 = "com.tencent.mm.plugin.sns.ui.SnsUserUI";
          localObject2 = localObject3;
          break;
        }
        if (l == 8388608L)
        {
          localObject1 = "com.tencent.mm.plugin.favorite.ui.FavoriteIndexUI";
          localObject2 = localObject3;
          break;
        }
        if (l == 16777216L)
        {
          localObject1 = "com.tencent.mm.plugin.setting.ui.setting.SettingsPrivacyUI";
          localObject2 = localObject3;
          break;
        }
        if (l == 33554432L)
        {
          localObject1 = "com.tencent.mm.plugin.setting.ui.setting.SettingsAccountInfoUI";
          localObject2 = localObject3;
          break;
        }
        if (l == 67108864L)
        {
          localObject1 = "com.tencent.mm.plugin.mall.ui.MallIndexUI";
          localObject2 = localObject3;
          break;
        }
        if (l == 134217728L)
        {
          if ((paramContext != null) && (!bf.mA(paramString1)) && (paramString1.startsWith("weixin://dl/businessPay")))
          {
            paramString2 = Uri.parse(paramString1);
            if (paramString2 == null) {
              continue;
            }
            paramString1 = paramString2.getQueryParameter("reqkey");
            localObject2 = paramString2.getQueryParameter("appid");
            if (!bf.mA(paramString1))
            {
              paramString2 = new PayInfo();
              paramString2.fJy = paramString1;
              paramString2.appId = ((String)localObject2);
              paramString2.fRl = 36;
              paramString2.mpc = false;
              localObject2 = new Intent();
              ((Intent)localObject2).putExtra("key_pay_info", paramString2);
              if (m.xY())
              {
                com.tencent.mm.bb.d.b(paramContext, "wallet_payu", ".pay.ui.WalletPayUPayUI", (Intent)localObject2, 1);
                break;
              }
              com.tencent.mm.bb.d.b(paramContext, "wallet", ".pay.ui.WalletPayUI", (Intent)localObject2, 1);
              break;
            }
            v.w("MicroMsg.DeepLinkHelper", "reqkey null");
          }
          localObject2 = null;
          break;
          v.w("MicroMsg.DeepLinkHelper", "payUri null");
          continue;
        }
        if (l == 1073741824L)
        {
          localObject1 = "com.tencent.mm.plugin.safedevice.ui.MySafeDeviceListUI";
          localObject2 = localObject3;
          break;
        }
        if (l == 2147483648L)
        {
          localObject1 = "com.tencent.mm.plugin.card.ui.CardHomePageUI";
          localObject2 = localObject3;
          break;
        }
        if (l == 4294967296L)
        {
          ((Intent)localObject3).putExtra("filter_type", com.tencent.mm.u.t.fT(aa.getContext().getString(R.l.eqx)).getType());
          ((Intent)localObject3).putExtra("titile", aa.getContext().getString(R.l.eTE));
          ((Intent)localObject3).putExtra("list_attr", 32768);
          localObject1 = "com.tencent.mm.ui.contact.SelectSpecialContactUI";
          localObject2 = localObject3;
          break;
        }
        if (l == 8589934592L)
        {
          localObject1 = "com.tencent.mm.plugin.setting.ui.setting.SettingsFontUI";
          localObject2 = localObject3;
          break;
        }
        if (l == 17179869184L)
        {
          localObject1 = "com.tencent.mm.plugin.setting.ui.setting.SettingsAboutSystemUI";
          localObject2 = localObject3;
          break;
        }
        if (l == 34359738368L)
        {
          localObject1 = "com.tencent.mm.plugin.setting.ui.setting.SettingsLanguageUI";
          localObject2 = localObject3;
          break;
        }
        if (l == 68719476736L)
        {
          localObject1 = "com.tencent.mm.plugin.backup.backupmoveui.BackupUI";
          localObject2 = localObject3;
          break;
        }
        if (l == 137438953472L)
        {
          ((Intent)localObject3).setClassName(aa.getContext(), "com.tencent.mm.ui.bindqq.BindQQUI");
          MMWizardActivity.w(paramContext, (Intent)localObject3);
          GMTrace.o(17950413160448L, 133741);
          return true;
        }
        if (l == 274877906944L)
        {
          ((Intent)localObject3).setClassName(aa.getContext(), "com.tencent.mm.ui.bindmobile.BindMContactIntroUI");
          MMWizardActivity.w(paramContext, (Intent)localObject3);
          GMTrace.o(17950413160448L, 133741);
          return true;
        }
        if (l == 549755813888L)
        {
          localObject1 = "com.tencent.mm.plugin.setting.ui.setting.SettingsModifyEmailAddrUI";
          localObject2 = localObject3;
          break;
        }
        if (l == 1099511627776L)
        {
          com.tencent.mm.bb.d.b(aa.getContext(), "profile", ".ui.ContactInfoUI", ((Intent)localObject3).putExtra("Contact_User", "qqsync"));
          GMTrace.o(17950413160448L, 133741);
          return true;
        }
        if (l == 2199023255552L)
        {
          localObject1 = "com.tencent.mm.plugin.masssend.ui.MassSendHistoryUI";
          localObject2 = localObject3;
          break;
        }
        if (l == 4398046511104L)
        {
          localObject1 = "com.tencent.mm.plugin.setting.ui.setting.SettingsModifyNameUI";
          localObject2 = localObject3;
          break;
        }
        if (l == 8796093022208L)
        {
          localObject1 = "com.tencent.mm.plugin.setting.ui.setting.SelfQRCodeUI";
          localObject2 = localObject3;
          break;
        }
        if (l == 17592186044416L)
        {
          ((Intent)localObject3).putExtra("launch_from_webview", false);
          com.tencent.mm.bb.d.a(aa.getContext(), "address", ".ui.WalletSelectAddrUI", (Intent)localObject3, true);
          GMTrace.o(17950413160448L, 133741);
          return true;
        }
        if (l == 35184372088832L)
        {
          ((Intent)localObject3).putExtra("k_sns_tag_id", 4L);
          ((Intent)localObject3).putExtra("k_sns_from_settings_about_sns", 1);
          com.tencent.mm.bb.d.b(aa.getContext(), "sns", ".ui.SnsBlackDetailUI", (Intent)localObject3);
          GMTrace.o(17950413160448L, 133741);
          return true;
        }
        if (l == 70368744177664L)
        {
          ((Intent)localObject3).putExtra("k_sns_tag_id", 5L);
          ((Intent)localObject3).putExtra("k_sns_from_settings_about_sns", 2);
          ((Intent)localObject3).putExtra("k_tag_detail_sns_block_scene", 8);
          com.tencent.mm.bb.d.b(aa.getContext(), "sns", ".ui.SnsTagDetailUI", (Intent)localObject3);
          localObject2 = localObject3;
          break;
        }
        if (l == 140737488355328L)
        {
          localObject1 = "com.tencent.mm.plugin.emoji.ui.EmojiMineUI";
          localObject2 = localObject3;
          break;
        }
        if (l == 281474976710656L)
        {
          paramContext = new br();
          paramContext.fEX.fEZ = "//uplog";
          paramContext.fEX.context = aa.getContext();
          com.tencent.mm.sdk.b.a.uql.m(paramContext);
          GMTrace.o(17950413160448L, 133741);
          return true;
        }
        if (l == 562949953421312L)
        {
          ((Intent)localObject3).putExtra("IPCallAddressUI_KFrom", 1);
          com.tencent.mm.bb.d.b(aa.getContext(), "ipcall", ".ui.IPCallAddressUI", (Intent)localObject3);
          com.tencent.mm.bb.d.b(aa.getContext(), "ipcall", ".ui.IPCallShareCouponUI", (Intent)localObject3);
          GMTrace.o(17950413160448L, 133741);
          return true;
        }
        if (l == 18014398509481984L)
        {
          ((Intent)localObject3).putExtra("IPCallAddressUI_KFrom", 1);
          com.tencent.mm.bb.d.b(aa.getContext(), "ipcall", ".ui.IPCallAddressUI", (Intent)localObject3);
          com.tencent.mm.bb.d.b(aa.getContext(), "ipcall", ".ui.IPCallShareCouponUI", (Intent)localObject3);
          com.tencent.mm.bb.d.b(aa.getContext(), "ipcall", ".ui.IPCallShareCouponCardUI", (Intent)localObject3);
          localObject2 = localObject3;
          break;
        }
        if (l == 576460752303423488L)
        {
          ((Intent)localObject3).putExtra("IPCallAddressUI_KFrom", 1);
          ((Intent)localObject3).setClassName(aa.getContext(), "com.tencent.mm.plugin.sight.draft.ui.SightDraftUI");
          aa.getContext().startActivity((Intent)localObject3);
          localObject2 = localObject3;
          break;
        }
        if (l == 1125899906842624L)
        {
          localObject1 = "com.tencent.mm.plugin.setting.ui.setting.SettingsAboutMicroMsgUI";
          localObject2 = localObject3;
          break;
        }
        if (l == 4503599627370496L)
        {
          ((Intent)localObject3).putExtra("emoji_tab", 1);
          localObject1 = "com.tencent.mm.plugin.emoji.ui.v2.EmojiStoreV2UI";
          com.tencent.mm.plugin.report.service.g.oSF.i(12065, new Object[] { Integer.valueOf(7) });
          localObject2 = localObject3;
          break;
        }
        if (l == 9007199254740992L)
        {
          localObject1 = "com.tencent.mm.plugin.emoji.ui.v2.EmojiStoreV2SingleProductUI";
          localObject2 = localObject3;
          break;
        }
        localObject2 = localObject3;
        if (l != 576460752303423489L) {
          break;
        }
        localObject2 = Uri.parse(paramString1);
        paramString1 = ((Uri)localObject2).getQueryParameter("appid");
        localObject1 = ((Uri)localObject2).getQueryParameter("userName");
        localObject2 = ((Uri)localObject2).getQueryParameter("path");
        v.i("MicroMsg.DeepLinkHelper", "appid = %s, userName = %s, path = %s, translateLinkScene = %d", new Object[] { paramString1, localObject1, localObject2, Integer.valueOf(paramInt1) });
        if (paramInt1 == 2)
        {
          ((com.tencent.mm.plugin.appbrand.i.c)h.h(com.tencent.mm.plugin.appbrand.i.c.class)).a(paramContext, (String)localObject1, (String)localObject2, 1065, URLEncoder.encode(paramString2), "");
          GMTrace.o(17950413160448L, 133741);
          return true;
        }
        if (paramInt1 == 1)
        {
          ((com.tencent.mm.plugin.appbrand.i.c)h.h(com.tencent.mm.plugin.appbrand.i.c.class)).a(paramContext, (String)localObject1, (String)localObject2, 1069, paramString1, paramString1);
          continue;
        }
        if (paramInt1 == 6)
        {
          ((com.tencent.mm.plugin.appbrand.i.c)h.h(com.tencent.mm.plugin.appbrand.i.c.class)).a(paramContext, (String)localObject1, (String)localObject2, 1007, URLEncoder.encode(paramString2), "");
          continue;
        }
        if (paramInt1 == 7)
        {
          ((com.tencent.mm.plugin.appbrand.i.c)h.h(com.tencent.mm.plugin.appbrand.i.c.class)).a(paramContext, (String)localObject1, (String)localObject2, 1008, URLEncoder.encode(paramString2), "");
          continue;
        }
        ((com.tencent.mm.plugin.appbrand.i.c)h.h(com.tencent.mm.plugin.appbrand.i.c.class)).a(paramContext, (String)localObject1, (String)localObject2, 1000, URLEncoder.encode(paramString2), "");
        continue;
        label3007:
        aa.getContext().startActivity((Intent)localObject2);
        b.x(aa.getContext(), (Intent)localObject2);
        continue;
      }
      catch (Exception paramContext)
      {
        v.printErrStackTrace("MicroMsg.DeepLinkHelper", paramContext, "", new Object[] { "" });
        continue;
      }
      label3048:
      GMTrace.o(17950413160448L, 133741);
      return false;
      if (((String)localObject1).startsWith("weixin://dl/businessTempSession/"))
      {
        localObject2 = new Intent();
        ((Intent)localObject2).setFlags(268435456);
        localObject3 = Uri.parse(paramString1);
        if (localObject3 == null)
        {
          v.e("MicroMsg.DeepLinkHelper", "tempsession uri is null");
          GMTrace.o(17950413160448L, 133741);
          return false;
        }
        str1 = ((Uri)localObject3).getQueryParameter("sessionFrom");
        str2 = ((Uri)localObject3).getQueryParameter("showtype");
        localObject1 = ((Uri)localObject3).getQueryParameter("username");
        paramString2 = (String)localObject1;
        if (bf.mA((String)localObject1)) {
          paramString2 = ((Uri)localObject3).getQueryParameter("userName");
        }
        if (bf.mA(paramString2))
        {
          v.e("MicroMsg.DeepLinkHelper", "tempsession user is null");
          GMTrace.o(17950413160448L, 133741);
          return false;
        }
        i = bf.getInt(bf.mz(((Uri)localObject3).getQueryParameter("scene")), 0);
        paramInt2 = paramInt1;
        if (i != 0)
        {
          paramInt2 = paramInt1;
          if (paramInt1 == 4)
          {
            v.i("MicroMsg.DeepLinkHelper", "Jsapi assign scene to " + i);
            paramInt2 = i;
          }
        }
        v.i("MicroMsg.DeepLinkHelper", "tempsession jump, %s, %s, %s, %s, %s.", new Object[] { paramString2, str1, Integer.valueOf(paramInt2), paramString1, str2 });
        ((Intent)localObject2).setClassName(aa.getContext(), "com.tencent.mm.ui.chatting.En_5b8fbb1e");
        ((Intent)localObject2).putExtra("Chat_User", paramString2);
        ((Intent)localObject2).putExtra("finish_direct", true);
        ((Intent)localObject2).putExtra("key_is_temp_session", true);
        ((Intent)localObject2).putExtra("key_temp_session_from", str1);
        ((Intent)localObject2).putExtra("key_temp_session_scene", paramInt2);
        ((Intent)localObject2).putExtra("key_temp_session_show_type", bf.getInt(str2, 0));
        ap.yY();
        paramString1 = com.tencent.mm.u.c.wR().Rb(paramString2);
        if ((paramString1 == null) || ((int)paramString1.gTG <= 0)) {
          ag.a.hlA.a(paramString2, "", new ag.b.a()
          {
            public final void p(String paramAnonymousString, boolean paramAnonymousBoolean)
            {
              GMTrace.i(1235071533056L, 9202);
              if (!paramAnonymousBoolean)
              {
                v.e("MicroMsg.DeepLinkHelper", "getContact fail, %s", new Object[] { paramAnonymousString });
                GMTrace.o(1235071533056L, 9202);
                return;
              }
              this.val$intent.putExtra("Chat_User", paramAnonymousString);
              try
              {
                if (paramContext != null)
                {
                  paramContext.startActivity(this.val$intent);
                  GMTrace.o(1235071533056L, 9202);
                  return;
                }
              }
              catch (Exception paramAnonymousString)
              {
                v.printErrStackTrace("MicroMsg.DeepLinkHelper", paramAnonymousString, "", new Object[] { "" });
                GMTrace.o(1235071533056L, 9202);
                return;
              }
              aa.getContext().startActivity(this.val$intent);
              GMTrace.o(1235071533056L, 9202);
            }
          });
        }
        for (;;)
        {
          GMTrace.o(17950413160448L, 133741);
          return true;
          paramContext.startActivity((Intent)localObject2);
        }
      }
      if ((((String)localObject1).startsWith("weixin://dl/businessGame/detail/")) || (((String)localObject1).startsWith("weixin://dl/businessGame/detail")))
      {
        v.i("MicroMsg.DeepLinkHelper", "gotoUri, uri startsWith GAME_DETAIL");
        localObject1 = Uri.parse(paramString1);
        paramString1 = null;
        paramString2 = new Intent();
        if (localObject1 != null)
        {
          localObject1 = ((Uri)localObject1).getQueryParameter("appid");
          paramString1 = "com.tencent.mm.plugin.game.ui.GameDetailUI";
          paramString2.putExtra("game_app_id", (String)localObject1);
          paramString2.putExtra("game_report_from_scene", 6);
        }
        if (!bf.mA(paramString1))
        {
          paramString2.setClassName(aa.getContext(), paramString1);
          if (paramContext != null) {}
          try
          {
            paramContext.startActivity(paramString2);
            for (;;)
            {
              GMTrace.o(17950413160448L, 133741);
              return true;
              aa.getContext().startActivity(paramString2);
              b.x(aa.getContext(), paramString2);
            }
          }
          catch (Exception paramContext)
          {
            for (;;)
            {
              v.printErrStackTrace("MicroMsg.DeepLinkHelper", paramContext, "", new Object[] { "" });
            }
          }
        }
        GMTrace.o(17950413160448L, 133741);
        return false;
      }
      if ((((String)localObject1).startsWith("weixin://dl/businessGame/library/")) || (((String)localObject1).startsWith("weixin://dl/businessGame/library")))
      {
        v.i("MicroMsg.DeepLinkHelper", "gotoUri, uri startsWith GAME_LIBRARY");
        paramString1 = new Intent();
        if (!bf.mA("com.tencent.mm.plugin.game.ui.GameLibraryUI"))
        {
          paramString1.putExtra("game_report_from_scene", 6);
          paramString1.setClassName(aa.getContext(), "com.tencent.mm.plugin.game.ui.GameLibraryUI");
          if (paramContext != null) {}
          try
          {
            paramContext.startActivity(paramString1);
            for (;;)
            {
              GMTrace.o(17950413160448L, 133741);
              return true;
              aa.getContext().startActivity(paramString1);
              b.x(aa.getContext(), paramString1);
            }
          }
          catch (Exception paramContext)
          {
            for (;;)
            {
              v.printErrStackTrace("MicroMsg.DeepLinkHelper", paramContext, "", new Object[] { "" });
            }
          }
        }
        GMTrace.o(17950413160448L, 133741);
        return false;
      }
      if ((((String)localObject1).startsWith("weixin://dl/businessWebview/link/")) || (((String)localObject1).startsWith("weixin://dl/businessWebview/link")))
      {
        v.i("MicroMsg.DeepLinkHelper", "gotoUri, uri startsWith H5_LINK");
        localObject1 = Uri.parse(paramString1);
        paramString2 = new Intent();
        paramString1 = null;
        if (localObject1 != null)
        {
          localObject1 = ((Uri)localObject1).getQueryParameter("url");
          v.i("MicroMsg.DeepLinkHelper", "gotoUri, rawUrl = %s, translateLinkScene: %s", new Object[] { localObject1, Integer.valueOf(paramInt1) });
          paramString1 = "com.tencent.mm.plugin.webview.ui.tools.WebViewUI";
          paramString2.putExtra("rawUrl", (String)localObject1);
          paramString2.putExtra("geta8key_session_id", paramInt2);
          paramString2.addFlags(268435456);
          if (paramInt1 != 1) {
            break label3960;
          }
          paramString2.putExtra("show_openapp_dialog", false);
          paramString2.putExtra("pay_channel", 40);
        }
        for (;;)
        {
          paramString2.putExtra("transaction_for_openapi_openwebview", szE);
          if (!bf.mA(paramString1))
          {
            paramString2.setClassName(aa.getContext(), paramString1);
            if (paramContext != null) {}
            try
            {
              paramContext.startActivity(paramString2);
              for (;;)
              {
                GMTrace.o(17950413160448L, 133741);
                return true;
                label3960:
                if (paramInt1 != 2) {
                  break;
                }
                paramString2.putExtra("pay_channel", 39);
                break;
                aa.getContext().startActivity(paramString2);
                b.x(aa.getContext(), paramString2);
              }
            }
            catch (Exception paramContext)
            {
              for (;;)
              {
                v.printErrStackTrace("MicroMsg.DeepLinkHelper", paramContext, "", new Object[] { "" });
              }
            }
          }
        }
        GMTrace.o(17950413160448L, 133741);
        return false;
      }
      GMTrace.o(17950413160448L, 133741);
      return false;
      label4042:
      paramString1 = "";
    }
  }
  
  public static boolean a(Context paramContext, String paramString1, int paramInt, String paramString2)
  {
    GMTrace.i(17950278942720L, 133740);
    boolean bool = a(paramContext, paramString1, paramInt, (int)System.currentTimeMillis(), paramString2);
    GMTrace.o(17950278942720L, 133740);
    return bool;
  }
  
  public static void aM(Context paramContext, String paramString)
  {
    GMTrace.i(1240574459904L, 9243);
    if (bf.mA(paramString))
    {
      v.e("MicroMsg.DeepLinkHelper", "cpan gotoLoginUI url is null. finish");
      GMTrace.o(1240574459904L, 9243);
      return;
    }
    Object localObject;
    if (paramString.startsWith("weixin://dl/login/phone_view"))
    {
      localObject = Uri.parse(paramString);
      paramString = ((Uri)localObject).getQueryParameter("cc");
      localObject = ((Uri)localObject).getQueryParameter("num");
      v.d("MicroMsg.DeepLinkHelper", "cpan gotoLoginUI cc:%s num:%s", new Object[] { paramString, localObject });
      Intent localIntent = new Intent();
      localIntent.putExtra("input_country_code", paramString);
      localIntent.putExtra("input_mobile_number", (String)localObject);
      localIntent.putExtra("from_deep_link", true);
      localIntent.putExtra("mobile_input_purpose", 1);
      localIntent.addFlags(268435456);
      com.tencent.mm.bb.d.b(paramContext, "accountsync", "com.tencent.mm.ui.account.mobile.MobileInputUI", localIntent);
      GMTrace.o(1240574459904L, 9243);
      return;
    }
    if (paramString.startsWith("weixin://dl/login/common_view"))
    {
      paramString = Uri.parse(paramString).getQueryParameter("username");
      v.d("MicroMsg.DeepLinkHelper", "cpan gotoLoginUI  username:%s", new Object[] { paramString });
      localObject = new Intent();
      ((Intent)localObject).putExtra("login_username", paramString);
      ((Intent)localObject).putExtra("from_deep_link", true);
      ((Intent)localObject).addFlags(268435456);
      com.tencent.mm.bb.d.b(paramContext, "accountsync", "com.tencent.mm.ui.account.LoginUI", (Intent)localObject);
      GMTrace.o(1240574459904L, 9243);
      return;
    }
    v.e("MicroMsg.DeepLinkHelper", "cpan gotoLoginUI url not Correct:%s", new Object[] { paramString });
    GMTrace.o(1240574459904L, 9243);
  }
  
  public static boolean c(Context paramContext, int paramInt, String paramString)
  {
    GMTrace.i(1239634935808L, 9236);
    boolean bool = a(paramContext, paramString, 0, paramInt, null);
    GMTrace.o(1239634935808L, 9236);
    return bool;
  }
  
  public static void dq(Context paramContext)
  {
    GMTrace.i(1240037588992L, 9239);
    K(paramContext, (int)System.currentTimeMillis());
    GMTrace.o(1240037588992L, 9239);
  }
  
  public static boolean i(Uri paramUri)
  {
    GMTrace.i(1238695411712L, 9229);
    if (paramUri == null)
    {
      GMTrace.o(1238695411712L, 9229);
      return false;
    }
    if (!bf.mA(paramUri.getQueryParameter("ticket")))
    {
      GMTrace.o(1238695411712L, 9229);
      return true;
    }
    boolean bool = j(paramUri);
    GMTrace.o(1238695411712L, 9229);
    return bool;
  }
  
  public static boolean j(Uri paramUri)
  {
    GMTrace.i(1238829629440L, 9230);
    if (paramUri == null)
    {
      GMTrace.o(1238829629440L, 9230);
      return false;
    }
    if ((paramUri.toString().startsWith("weixin://dl/business/tempsession/")) || (paramUri.toString().startsWith("weixin://dl/businessTempSession/")))
    {
      GMTrace.o(1238829629440L, 9230);
      return true;
    }
    GMTrace.o(1238829629440L, 9230);
    return false;
  }
  
  public static void s(final Context paramContext, String paramString1, String paramString2)
  {
    GMTrace.i(1240440242176L, 9242);
    if (LE(paramString2))
    {
      GMTrace.o(1240440242176L, 9242);
      return;
    }
    com.tencent.mm.ui.base.p localp = com.tencent.mm.ui.base.g.a(paramContext, "", true, null);
    int j = 6;
    int i = j;
    if (!bf.mA(paramString1))
    {
      if (!o.dH(paramString1)) {
        break label86;
      }
      i = 7;
    }
    for (;;)
    {
      a(paramContext, paramString2, i, new a()
      {
        public final void a(int paramAnonymousInt1, int paramAnonymousInt2, String paramAnonymousString, k paramAnonymousk, boolean paramAnonymousBoolean)
        {
          GMTrace.i(1230239694848L, 9166);
          v.i("MicroMsg.DeepLinkHelper", "DeepLinkHelper.DeepLinkCallback, %d, %d, %s, %b", new Object[] { Integer.valueOf(paramAnonymousInt1), Integer.valueOf(paramAnonymousInt2), paramAnonymousString, Boolean.valueOf(paramAnonymousBoolean) });
          if ((this.szI != null) && (this.szI.isShowing())) {
            this.szI.dismiss();
          }
          if ((paramAnonymousk != null) && (paramAnonymousInt1 != 0) && (paramAnonymousInt2 != 0) && ((paramAnonymousk instanceof ah)))
          {
            paramAnonymousString = ((ah)paramAnonymousk).JA();
            if ((paramAnonymousString != null) && (paramContext != null)) {
              com.tencent.mm.ui.base.s.makeText(paramContext, paramContext.getString(R.l.dIG) + " : " + bf.mz(paramAnonymousString.uet), 0).show();
            }
          }
          GMTrace.o(1230239694848L, 9166);
        }
      });
      GMTrace.o(1240440242176L, 9242);
      return;
      label86:
      i = j;
      if (o.eV(paramString1)) {
        i = 9;
      }
    }
  }
  
  public static abstract interface a
  {
    public abstract void a(int paramInt1, int paramInt2, String paramString, k paramk, boolean paramBoolean);
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/pluginsdk/d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */