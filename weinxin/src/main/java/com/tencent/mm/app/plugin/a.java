package com.tencent.mm.app.plugin;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import com.tencent.gmtrace.GMTrace;
import com.tencent.mm.bb.d;
import com.tencent.mm.pluginsdk.l.w;
import com.tencent.mm.pluginsdk.o;
import com.tencent.mm.sdk.platformtools.bf;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.u.ap;
import com.tencent.mm.u.m;
import com.tencent.mm.ui.JSAPIUploadLogHelperUI;
import com.tencent.mm.ui.LauncherUI;
import com.tencent.mm.ui.MMWizardActivity;
import com.tencent.mm.ui.bindmobile.BindMContactIntroUI;
import com.tencent.mm.ui.contact.VoipAddressUI;
import java.util.ArrayList;
import java.util.Iterator;

public final class a
  implements l.w
{
  public a()
  {
    GMTrace.i(13007040020480L, 96910);
    GMTrace.o(13007040020480L, 96910);
  }
  
  private boolean a(Context paramContext, String paramString, boolean paramBoolean, o paramo, Bundle paramBundle)
  {
    GMTrace.i(13007711109120L, 96915);
    if (paramContext == null)
    {
      v.e("MicroMsg.MMURIJumpHandler", "jumpToUIInternal, context is null!");
      GMTrace.o(13007711109120L, 96915);
      return false;
    }
    if (paramString == null)
    {
      v.e("MicroMsg.MMURIJumpHandler", "jumpToUIInternal url is null");
      GMTrace.o(13007711109120L, 96915);
      return false;
    }
    if (paramString.startsWith("weixin://openSpecificView/"))
    {
      paramBoolean = b(paramContext, paramString, new Object[0]);
      GMTrace.o(13007711109120L, 96915);
      return paramBoolean;
    }
    e locale = e.oM();
    if (paramo == null) {}
    for (boolean bool = true;; bool = false)
    {
      v.d("MicroMsg.URISpanHandler", "handleUriJump, url:%s, isAllowScanQrCode:%b, callback==null:%b, mHighPriorityHandlerList.size:%d, mNormalPriorityHandlerList.size: %d, mLowPriorityHandlerList.size: %d", new Object[] { paramString, Boolean.valueOf(paramBoolean), Boolean.valueOf(bool), Integer.valueOf(locale.fxP.size()), Integer.valueOf(locale.fxQ.size()), Integer.valueOf(locale.fxR.size()) });
      if (paramContext != null) {
        break;
      }
      v.e("MicroMsg.URISpanHandler", "handleUriJump, context is null!");
      locale.fxO.mContext = null;
      GMTrace.o(13007711109120L, 96915);
      return false;
    }
    locale.mContext = paramContext;
    locale.fxO.mContext = locale.mContext;
    if (bf.mA(paramString))
    {
      v.d("MicroMsg.URISpanHandler", "handleUriJump, url is null");
      locale.mContext = null;
      locale.fxO.mContext = null;
      GMTrace.o(13007711109120L, 96915);
      return false;
    }
    paramContext = locale.fxP.iterator();
    URISpanHandlerSet.BaseUriSpanHandler localBaseUriSpanHandler;
    while (paramContext.hasNext())
    {
      localBaseUriSpanHandler = (URISpanHandlerSet.BaseUriSpanHandler)paramContext.next();
      if (localBaseUriSpanHandler.a(paramString, paramBoolean, paramo, paramBundle))
      {
        v.d("MicroMsg.URISpanHandler", "handleUriJump, %s handle", new Object[] { localBaseUriSpanHandler.getClass().getName() });
        locale.mContext = null;
        locale.fxO.mContext = null;
        GMTrace.o(13007711109120L, 96915);
        return true;
      }
    }
    paramContext = locale.fxQ.iterator();
    while (paramContext.hasNext())
    {
      localBaseUriSpanHandler = (URISpanHandlerSet.BaseUriSpanHandler)paramContext.next();
      if (localBaseUriSpanHandler.a(paramString, paramBoolean, paramo, paramBundle))
      {
        v.d("MicroMsg.URISpanHandler", "handleUriJump, %s handle", new Object[] { localBaseUriSpanHandler.getClass().getName() });
        locale.mContext = null;
        locale.fxO.mContext = null;
        GMTrace.o(13007711109120L, 96915);
        return true;
      }
    }
    paramContext = locale.fxR.iterator();
    while (paramContext.hasNext())
    {
      localBaseUriSpanHandler = (URISpanHandlerSet.BaseUriSpanHandler)paramContext.next();
      if (localBaseUriSpanHandler.a(paramString, paramBoolean, paramo, paramBundle))
      {
        v.d("MicroMsg.URISpanHandler", "handleUriJump, %s handle", new Object[] { localBaseUriSpanHandler.getClass().getName() });
        locale.mContext = null;
        locale.fxO.mContext = null;
        GMTrace.o(13007711109120L, 96915);
        return true;
      }
    }
    locale.mContext = null;
    locale.fxO.mContext = null;
    v.d("MicroMsg.URISpanHandler", "handleUriJump, nothing handle");
    GMTrace.o(13007711109120L, 96915);
    return false;
  }
  
  public final boolean a(Context paramContext, String paramString, boolean paramBoolean)
  {
    GMTrace.i(13007174238208L, 96911);
    paramBoolean = a(paramContext, paramString, paramBoolean, null);
    GMTrace.o(13007174238208L, 96911);
    return paramBoolean;
  }
  
  public final boolean a(Context paramContext, String paramString, boolean paramBoolean, Bundle paramBundle)
  {
    GMTrace.i(13007442673664L, 96913);
    paramBoolean = a(paramContext, paramString, paramBoolean, null, paramBundle);
    GMTrace.o(13007442673664L, 96913);
    return paramBoolean;
  }
  
  public final boolean a(Context paramContext, String paramString, boolean paramBoolean, o paramo)
  {
    GMTrace.i(13007308455936L, 96912);
    if (paramContext == null)
    {
      v.e("MicroMsg.MMURIJumpHandler", "jumpToURLWithCallback, context is null!");
      GMTrace.o(13007308455936L, 96912);
      return false;
    }
    if (paramString.startsWith("http"))
    {
      paramString = new Intent("android.intent.action.VIEW", Uri.parse(paramString));
      paramString.addFlags(268435456);
      try
      {
        paramContext.startActivity(paramString);
        GMTrace.o(13007308455936L, 96912);
        return true;
      }
      catch (Exception paramContext)
      {
        for (;;)
        {
          v.e("MicroMsg.MMURIJumpHandler", "openLinkInBrowser fail:%s", new Object[] { paramContext.getMessage() });
        }
      }
    }
    if (!b(paramContext, paramString, paramBoolean, paramo))
    {
      v.w("MicroMsg.MMURIJumpHandler", "jumpToUI failed, uri:%s", new Object[] { paramString });
      GMTrace.o(13007308455936L, 96912);
      return false;
    }
    GMTrace.o(13007308455936L, 96912);
    return false;
  }
  
  public final boolean b(Context paramContext, String paramString, boolean paramBoolean, o paramo)
  {
    GMTrace.i(13007576891392L, 96914);
    paramBoolean = a(paramContext, paramString, paramBoolean, paramo, null);
    GMTrace.o(13007576891392L, 96914);
    return paramBoolean;
  }
  
  public final boolean b(Context paramContext, String paramString, Object... paramVarArgs)
  {
    GMTrace.i(13007845326848L, 96916);
    if (paramString == null)
    {
      v.d("MicroMsg.MMURIJumpHandler", "openSpecificUI uri is null");
      GMTrace.o(13007845326848L, 96916);
      return false;
    }
    if (paramContext == null)
    {
      v.e("MicroMsg.MMURIJumpHandler", "openSpecificUI, context is null");
      GMTrace.o(13007845326848L, 96916);
      return false;
    }
    Intent localIntent = new Intent();
    localIntent.addFlags(268435456);
    String str2 = paramString.replace("weixin://openSpecificView/", "");
    String str1 = null;
    paramString = str1;
    if (paramVarArgs != null)
    {
      paramString = str1;
      if (paramVarArgs.length > 0) {
        paramString = (Bundle)paramVarArgs[0];
      }
    }
    if (str2.equalsIgnoreCase("contacts"))
    {
      localIntent.addFlags(67108864);
      localIntent.putExtra("preferred_tab", 2);
      paramContext.startActivity(localIntent.setClass(paramContext, LauncherUI.class));
    }
    for (;;)
    {
      GMTrace.o(13007845326848L, 96916);
      return true;
      if (str2.equalsIgnoreCase("newfriend"))
      {
        d.b(paramContext, "subapp", ".ui.friend.FMessageConversationUI", localIntent);
      }
      else if (str2.equalsIgnoreCase("addfriend"))
      {
        d.b(paramContext, "subapp", ".ui.pluginapp.AddMoreFriendsUI", localIntent);
      }
      else if (str2.equalsIgnoreCase("searchbrand"))
      {
        paramString = new Intent();
        paramString.putExtra("Contact_Scene", 39);
        d.b(paramContext, "brandservice", ".ui.SearchOrRecommendBizUI", paramString);
      }
      else if (str2.equalsIgnoreCase("discover"))
      {
        localIntent.addFlags(67108864);
        localIntent.putExtra("preferred_tab", 1);
        paramContext.startActivity(localIntent.setClass(paramContext, LauncherUI.class));
      }
      else if (str2.equalsIgnoreCase("timeline"))
      {
        d.b(paramContext, "sns", ".ui.En_424b8e16", localIntent);
      }
      else if (str2.equalsIgnoreCase("scan"))
      {
        d.b(paramContext, "scanner", ".ui.BaseScanUI", localIntent);
      }
      else if (str2.equalsIgnoreCase("myprofile"))
      {
        d.b(paramContext, "setting", ".ui.setting.SettingsPersonalInfoUI", localIntent);
      }
      else if (str2.equalsIgnoreCase("myaccount"))
      {
        d.b(paramContext, "setting", ".ui.setting.SettingsAccountInfoUI", localIntent);
      }
      else if (str2.equalsIgnoreCase("bindphone"))
      {
        MMWizardActivity.w(paramContext, localIntent.setClass(paramContext, BindMContactIntroUI.class));
      }
      else if (str2.equalsIgnoreCase("privacy"))
      {
        d.b(paramContext, "setting", ".ui.setting.SettingsPrivacyUI", localIntent);
      }
      else if (str2.equalsIgnoreCase("general"))
      {
        d.b(paramContext, "setting", ".ui.setting.SettingsAboutSystemUI", localIntent);
      }
      else
      {
        if (!str2.equalsIgnoreCase("invitevoip")) {
          break;
        }
        VoipAddressUI.eY(paramContext);
      }
    }
    if (str2.equalsIgnoreCase("expose")) {
      if (paramString == null) {
        break label832;
      }
    }
    label826:
    label832:
    for (paramString = paramString.getString("url");; paramString = "")
    {
      localIntent.putExtra("k_expose_url", paramString);
      localIntent.putExtra("k_username", m.xL());
      localIntent.putExtra("showShare", false);
      localIntent.putExtra("rawUrl", String.format("https://weixin110.qq.com/security/readtemplate?t=weixin_report/w_type&scene=%d#wechat_redirect", new Object[] { Integer.valueOf(34) }));
      d.b(paramContext, "webview", ".ui.tools.WebViewUI", localIntent);
      break;
      if (str2.equalsIgnoreCase("shakecard")) {
        if (paramString == null) {
          break label826;
        }
      }
      for (paramString = paramString.getString("extinfo");; paramString = "")
      {
        localIntent.putExtra("key_shake_card_from_scene", 3);
        localIntent.putExtra("shake_card", true);
        localIntent.putExtra("key_shake_card_ext_info", paramString);
        d.b(paramContext, "shake", ".ui.ShakeReportUI", localIntent);
        break;
        if (str2.equalsIgnoreCase("cardlistview"))
        {
          d.b(paramContext, "card", ".ui.CardHomePageUI", localIntent);
          break;
        }
        if (str2.equalsIgnoreCase("uploadlog"))
        {
          str1 = m.xL();
          paramVarArgs = str1;
          if (bf.mA(str1)) {
            paramVarArgs = "weixin";
          }
          try
          {
            i = bf.getInt(paramString.getString("extinfo"), 0);
            if ((ap.zb()) && (!ap.uP()))
            {
              bool = true;
              v.i("MicroMsg.MMURIJumpHandler", "upload log from jsapi, before upload, is-login:%b, time:%d", new Object[] { Boolean.valueOf(bool), Integer.valueOf(i) });
              paramString = new Intent(paramContext, JSAPIUploadLogHelperUI.class);
              paramString.putExtra("key_user", paramVarArgs);
              paramString.putExtra("key_time", i);
              paramContext.startActivity(paramString);
            }
          }
          catch (Exception paramString)
          {
            for (;;)
            {
              int i = 0;
              continue;
              boolean bool = false;
            }
          }
        }
        GMTrace.o(13007845326848L, 96916);
        return false;
      }
    }
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/app/plugin/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */