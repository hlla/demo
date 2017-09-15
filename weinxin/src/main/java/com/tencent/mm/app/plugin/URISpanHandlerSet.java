package com.tencent.mm.app.plugin;

import android.app.Activity;
import android.app.Service;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Looper;
import android.widget.Toast;
import com.tencent.gmtrace.GMTrace;
import com.tencent.mm.R.l;
import com.tencent.mm.e.a.bl;
import com.tencent.mm.e.a.bm;
import com.tencent.mm.e.a.gr;
import com.tencent.mm.e.a.gr.a;
import com.tencent.mm.e.a.mh;
import com.tencent.mm.e.a.rr;
import com.tencent.mm.modelbiz.BizInfo;
import com.tencent.mm.modelsimple.ah;
import com.tencent.mm.plugin.messenger.foundation.a.a.f;
import com.tencent.mm.pluginsdk.d.a;
import com.tencent.mm.pluginsdk.ui.applet.i;
import com.tencent.mm.protocal.c.bfo;
import com.tencent.mm.sdk.platformtools.aa;
import com.tencent.mm.sdk.platformtools.bf;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.storage.aq;
import com.tencent.mm.storage.ar;
import com.tencent.mm.storage.ay;
import com.tencent.mm.storage.x;
import com.tencent.mm.u.ap;
import com.tencent.mm.u.q;
import com.tencent.mm.u.q.b;
import com.tencent.mm.ui.HomeUI;
import com.tencent.mm.ui.LauncherUI;
import com.tencent.mm.ui.MMWizardActivity;
import com.tencent.mm.ui.base.s;
import com.tencent.mm.ui.bindmobile.BindMContactIntroUI;
import com.tencent.mm.ui.bindmobile.MobileFriendUI;
import com.tencent.mm.ui.chatting.En_5b8fbb1e;
import com.tencent.mm.ui.contact.AddressUI;
import com.tencent.mm.ui.contact.SelectContactUI;
import com.tencent.mm.y.k;
import com.tencent.mm.y.n;
import java.io.UnsupportedEncodingException;
import java.lang.annotation.Annotation;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.net.URLDecoder;
import java.util.HashMap;
import java.util.List;

class URISpanHandlerSet
{
  public Context mContext;
  
  public URISpanHandlerSet(Context paramContext)
  {
    GMTrace.i(13025427849216L, 97047);
    this.mContext = null;
    if (paramContext == null) {}
    for (paramContext = aa.getContext();; paramContext = this.mContext)
    {
      this.mContext = paramContext;
      GMTrace.o(13025427849216L, 97047);
      return;
    }
  }
  
  @URISpanHandlerSet.a
  class AAUriSpanHandler
    extends URISpanHandlerSet.BaseUriSpanHandler
  {
    AAUriSpanHandler()
    {
      super();
      GMTrace.i(13025964720128L, 97051);
      GMTrace.o(13025964720128L, 97051);
    }
    
    final boolean a(i parami, final com.tencent.mm.pluginsdk.ui.d.e parame)
    {
      GMTrace.i(13026367373312L, 97054);
      final Object localObject1;
      final Object localObject2;
      if (parami.type == 35)
      {
        for (;;)
        {
          try
          {
            localObject1 = Uri.parse(parami.url).getQueryParameter("billno");
            if (bf.mA((String)localObject1))
            {
              v.e("MicroMsg.URISpanHandlerSet", "url error, billno is null");
              GMTrace.o(13026367373312L, 97054);
              return true;
            }
            if (!(parami.data instanceof Bundle)) {
              continue;
            }
            parame = ((Bundle)parami.data).getString("chatroom_name");
            localObject2 = new Intent();
            ((Intent)localObject2).putExtra("bill_no", (String)localObject1);
            ((Intent)localObject2).putExtra("enter_scene", 3);
            ((Intent)localObject2).putExtra("chatroom", parame);
            com.tencent.mm.bb.d.b(URISpanHandlerSet.this.mContext, "aa", ".ui.PaylistAAUI", (Intent)localObject2);
          }
          catch (Exception parame)
          {
            v.e("MicroMsg.URISpanHandlerSet", "handle click new aa open detail link error: %s, url: %s", new Object[] { parame.getMessage(), parami.url });
            continue;
          }
          GMTrace.o(13026367373312L, 97054);
          return true;
          if (!(parami.data instanceof String)) {
            continue;
          }
          parame = parami.data.toString();
        }
        v.e("MicroMsg.URISpanHandlerSet", "illegal data type, %s", new Object[] { parami });
        GMTrace.o(13026367373312L, 97054);
        return true;
      }
      if (parami.type == 37) {}
      for (;;)
      {
        final long l;
        try
        {
          parame = Uri.parse(parami.url).getQueryParameter("billno");
          if (bf.mA(parame))
          {
            v.e("MicroMsg.URISpanHandlerSet", "url error, billno is null");
            GMTrace.o(13026367373312L, 97054);
            return true;
          }
          if (!(parami.data instanceof Bundle))
          {
            v.e("MicroMsg.URISpanHandlerSet", "error data!");
            GMTrace.o(13026367373312L, 97054);
            return true;
          }
          localObject1 = (Bundle)parami.data;
          localObject2 = ((Bundle)localObject1).getString("chatroom_name");
          if (bf.mA((String)localObject2))
          {
            v.e("MicroMsg.URISpanHandlerSet", "empty chatroom!");
            GMTrace.o(13026367373312L, 97054);
            return true;
          }
          l = ((Bundle)localObject1).getLong("msg_id", -1L);
          if (l < 0L)
          {
            v.e("MicroMsg.URISpanHandlerSet", "msgId is null");
            GMTrace.o(13026367373312L, 97054);
            return true;
          }
          com.tencent.mm.ui.base.g.a(URISpanHandlerSet.this.mContext, R.l.dAI, -1, R.l.dAM, R.l.cancel, new DialogInterface.OnClickListener()
          {
            public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
            {
              GMTrace.i(13006905802752L, 96909);
              paramAnonymousDialogInterface = new bl();
              paramAnonymousDialogInterface.fEI.fEJ = parame;
              paramAnonymousDialogInterface.fEI.fEK = localObject2;
              paramAnonymousDialogInterface.fEI.fEL = l;
              com.tencent.mm.sdk.b.a.uql.m(paramAnonymousDialogInterface);
              GMTrace.o(13006905802752L, 96909);
            }
          }, null);
        }
        catch (Exception parame)
        {
          v.e("MicroMsg.URISpanHandlerSet", "handle click new aa close link error: %s, url: %s", new Object[] { parame.getMessage(), parami.url });
          continue;
        }
        GMTrace.o(13026367373312L, 97054);
        return false;
        if (parami.type == 36) {
          try
          {
            localObject2 = Uri.parse(parami.url).getQueryParameter("billno");
            if (bf.mA((String)localObject2))
            {
              v.e("MicroMsg.URISpanHandlerSet", "url error, billno is null");
              GMTrace.o(13026367373312L, 97054);
              return true;
            }
            parame = null;
            if ((parami.data instanceof Bundle))
            {
              localObject1 = (Bundle)parami.data;
              if (localObject1 != null)
              {
                parame = (com.tencent.mm.pluginsdk.ui.d.e)localObject1;
                if (!bf.mA(((Bundle)localObject1).getString("chatroom_name"))) {}
              }
              else
              {
                v.e("MicroMsg.URISpanHandlerSet", "empty chatroom!");
                GMTrace.o(13026367373312L, 97054);
                return true;
              }
            }
            localObject1 = parame.getString("chatroom_name");
            l = parame.getLong("msg_id", -1L);
            com.tencent.mm.ui.base.g.a(URISpanHandlerSet.this.mContext, R.l.dAK, -1, R.l.dAL, R.l.cancel, new DialogInterface.OnClickListener()
            {
              public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
              {
                GMTrace.i(13025293631488L, 97046);
                paramAnonymousDialogInterface = new bm();
                paramAnonymousDialogInterface.fEM.fEJ = localObject2;
                paramAnonymousDialogInterface.fEM.fEK = localObject1;
                paramAnonymousDialogInterface.fEM.fEL = l;
                com.tencent.mm.sdk.b.a.uql.m(paramAnonymousDialogInterface);
                GMTrace.o(13025293631488L, 97046);
              }
            }, null);
          }
          catch (Exception parame)
          {
            v.e("MicroMsg.URISpanHandlerSet", "handle click new aa urge notify link error: %s, url: %s", new Object[] { parame.getMessage(), parami.url });
          }
        }
      }
    }
    
    final boolean a(String paramString, boolean paramBoolean, com.tencent.mm.pluginsdk.o paramo, Bundle paramBundle)
    {
      GMTrace.i(13026501591040L, 97055);
      GMTrace.o(13026501591040L, 97055);
      return false;
    }
    
    final i bv(String paramString)
    {
      GMTrace.i(13026098937856L, 97052);
      if (paramString.trim().toLowerCase().startsWith("weixin://weixinnewaa/opendetail"))
      {
        paramString = new i(paramString, 35, null);
        GMTrace.o(13026098937856L, 97052);
        return paramString;
      }
      if (paramString.trim().toLowerCase().startsWith("weixin://weixinnewaa/closeurgenotify"))
      {
        paramString = new i(paramString, 36, null);
        GMTrace.o(13026098937856L, 97052);
        return paramString;
      }
      if (paramString.trim().toLowerCase().startsWith("weixin://weixinnewaa/closeaa"))
      {
        paramString = new i(paramString, 37, null);
        GMTrace.o(13026098937856L, 97052);
        return paramString;
      }
      GMTrace.o(13026098937856L, 97052);
      return null;
    }
    
    final int[] oN()
    {
      GMTrace.i(13026233155584L, 97053);
      GMTrace.o(13026233155584L, 97053);
      return new int[] { 35, 36, 37 };
    }
  }
  
  @URISpanHandlerSet.a
  class AddressUriSpanHandler
    extends URISpanHandlerSet.BaseUriSpanHandler
  {
    AddressUriSpanHandler()
    {
      super();
      GMTrace.i(17861426806784L, 133078);
      GMTrace.o(17861426806784L, 133078);
    }
    
    final boolean a(i parami, com.tencent.mm.pluginsdk.ui.d.e parame)
    {
      GMTrace.i(17861829459968L, 133081);
      if (parami.type == 44)
      {
        parami = Uri.parse("geo:0,0?q=" + Uri.encode(parami.url));
        parame = new Intent("android.intent.action.VIEW");
        parame.setData(parami);
        parame.addFlags(268435456);
        if (parame.resolveActivity(aa.getContext().getPackageManager()) != null)
        {
          aa.getContext().startActivity(parame);
          com.tencent.mm.plugin.report.service.g.oSF.a(653L, 1L, 1L, false);
        }
        for (;;)
        {
          GMTrace.o(17861829459968L, 133081);
          return true;
          v.w("MicroMsg.URISpanHandlerSet", "Cannot find map app");
          com.tencent.mm.plugin.report.service.g.oSF.a(653L, 2L, 1L, false);
        }
      }
      GMTrace.o(17861829459968L, 133081);
      return false;
    }
    
    final boolean a(String paramString, boolean paramBoolean, com.tencent.mm.pluginsdk.o paramo, Bundle paramBundle)
    {
      GMTrace.i(17861963677696L, 133082);
      GMTrace.o(17861963677696L, 133082);
      return false;
    }
    
    final i bv(String paramString)
    {
      GMTrace.i(17861561024512L, 133079);
      GMTrace.o(17861561024512L, 133079);
      return null;
    }
    
    final int[] oN()
    {
      GMTrace.i(17861695242240L, 133080);
      GMTrace.o(17861695242240L, 133080);
      return new int[] { 44 };
    }
  }
  
  @URISpanHandlerSet.a
  class AlphaInstallUriSpanHandler
    extends URISpanHandlerSet.BaseUriSpanHandler
  {
    AlphaInstallUriSpanHandler()
    {
      super();
      GMTrace.i(13027977986048L, 97066);
      GMTrace.o(13027977986048L, 97066);
    }
    
    final boolean a(i parami, com.tencent.mm.pluginsdk.ui.d.e parame)
    {
      GMTrace.i(13028380639232L, 97069);
      if (parami.type == 32)
      {
        parami = parami.url.replace("weixin://alphainstall?", "");
        parame = Uri.parse(parami).getQueryParameter("md5");
        parame = com.tencent.mm.compatible.util.e.hgk + parame + ".apk";
        if (com.tencent.mm.a.e.aO(parame)) {
          bf.i(parame, aa.getContext());
        }
        for (;;)
        {
          GMTrace.o(13028380639232L, 97069);
          return true;
          parame = new Intent();
          parame.putExtra("rawUrl", parami.toString());
          com.tencent.mm.bb.d.b(URISpanHandlerSet.this.mContext, "webview", ".ui.tools.WebViewUI", parame);
        }
      }
      GMTrace.o(13028380639232L, 97069);
      return false;
    }
    
    final boolean a(String paramString, boolean paramBoolean, com.tencent.mm.pluginsdk.o paramo, Bundle paramBundle)
    {
      GMTrace.i(13028514856960L, 97070);
      GMTrace.o(13028514856960L, 97070);
      return false;
    }
    
    final i bv(String paramString)
    {
      GMTrace.i(13028112203776L, 97067);
      if (paramString.trim().toLowerCase().startsWith("weixin://alphainstall?"))
      {
        paramString = new i(paramString, 32, null);
        GMTrace.o(13028112203776L, 97067);
        return paramString;
      }
      GMTrace.o(13028112203776L, 97067);
      return null;
    }
    
    final int[] oN()
    {
      GMTrace.i(13028246421504L, 97068);
      GMTrace.o(13028246421504L, 97068);
      return new int[] { 32 };
    }
  }
  
  abstract class BaseUriSpanHandler
  {
    public BaseUriSpanHandler()
    {
      GMTrace.i(13006100496384L, 96903);
      GMTrace.o(13006100496384L, 96903);
    }
    
    abstract boolean a(i parami, com.tencent.mm.pluginsdk.ui.d.e parame);
    
    abstract boolean a(String paramString, boolean paramBoolean, com.tencent.mm.pluginsdk.o paramo, Bundle paramBundle);
    
    abstract i bv(String paramString);
    
    abstract int[] oN();
  }
  
  @URISpanHandlerSet.a
  class BindMobileUrilSpanHandler
    extends URISpanHandlerSet.BaseUriSpanHandler
  {
    BindMobileUrilSpanHandler()
    {
      super();
      GMTrace.i(13009590157312L, 96929);
      GMTrace.o(13009590157312L, 96929);
    }
    
    final boolean a(i parami, com.tencent.mm.pluginsdk.ui.d.e parame)
    {
      GMTrace.i(13009992810496L, 96932);
      if (parami.type == 5)
      {
        if (parame != null) {
          parame.a(parami);
        }
        MMWizardActivity.w(URISpanHandlerSet.this.mContext, new Intent(URISpanHandlerSet.this.mContext, BindMContactIntroUI.class));
        GMTrace.o(13009992810496L, 96932);
        return true;
      }
      GMTrace.o(13009992810496L, 96932);
      return false;
    }
    
    final boolean a(String paramString, boolean paramBoolean, com.tencent.mm.pluginsdk.o paramo, Bundle paramBundle)
    {
      GMTrace.i(13010127028224L, 96933);
      if (paramString.equals("weixin://setting/bindphone"))
      {
        paramString = new Intent(URISpanHandlerSet.this.mContext, BindMContactIntroUI.class);
        if ((URISpanHandlerSet.this.mContext instanceof Service)) {
          paramString.addFlags(268435456);
        }
        MMWizardActivity.w(URISpanHandlerSet.this.mContext, paramString);
        GMTrace.o(13010127028224L, 96933);
        return true;
      }
      GMTrace.o(13010127028224L, 96933);
      return false;
    }
    
    final i bv(String paramString)
    {
      GMTrace.i(13009724375040L, 96930);
      if (paramString.trim().startsWith("weixin://setting/bindphone"))
      {
        paramString = new i(paramString, 5, null);
        GMTrace.o(13009724375040L, 96930);
        return paramString;
      }
      GMTrace.o(13009724375040L, 96930);
      return null;
    }
    
    final int[] oN()
    {
      GMTrace.i(13009858592768L, 96931);
      GMTrace.o(13009858592768L, 96931);
      return new int[] { 5 };
    }
  }
  
  @URISpanHandlerSet.a
  class BizMsgMenuUriSpanHandler
    extends URISpanHandlerSet.BaseUriSpanHandler
  {
    BizMsgMenuUriSpanHandler()
    {
      super();
      GMTrace.i(17862097895424L, 133083);
      GMTrace.o(17862097895424L, 133083);
    }
    
    final boolean a(i parami, com.tencent.mm.pluginsdk.ui.d.e parame)
    {
      GMTrace.i(17862500548608L, 133086);
      if (43 == parami.type)
      {
        if (bf.mA(parami.username))
        {
          v.w("MicroMsg.URISpanHandlerSet", "BizMsgMenuUriSpanHandler Username is null.");
          GMTrace.o(17862500548608L, 133086);
          return true;
        }
        v.d("MicroMsg.URISpanHandlerSet", "BizMsgMenuUriSpanHandler, url:%s", new Object[] { parami.url });
        Object localObject = Uri.parse(parami.url.trim());
        parame = ((Uri)localObject).getQueryParameter("msgmenuid");
        localObject = ((Uri)localObject).getQueryParameter("msgmenucontent");
        com.tencent.mm.plugin.report.service.g.oSF.i(14522, new Object[] { bf.mz(parame), parami.username });
        if ((bf.mA(parame)) || (bf.mA((String)localObject)))
        {
          v.w("MicroMsg.URISpanHandlerSet", "BizMsgMenuUriSpanHandler id or msgContent is null.");
          GMTrace.o(17862500548608L, 133086);
          return true;
        }
        try
        {
          localObject = URLDecoder.decode((String)localObject, "UTF-8");
          HashMap localHashMap = new HashMap();
          localHashMap.put("bizmsgmenuid", parame);
          parami = new com.tencent.mm.modelmulti.j(parami.username, (String)localObject, com.tencent.mm.u.o.fG(parami.username), 291, localHashMap);
          ap.vd().a(parami, 0);
          GMTrace.o(17862500548608L, 133086);
          return true;
        }
        catch (UnsupportedEncodingException parami)
        {
          for (;;)
          {
            v.w("MicroMsg.URISpanHandlerSet", "BizMsgMenuUriSpanHandler exp, msg = %s", new Object[] { parami.getMessage() });
          }
        }
      }
      GMTrace.o(17862500548608L, 133086);
      return false;
    }
    
    final boolean a(String paramString, boolean paramBoolean, com.tencent.mm.pluginsdk.o paramo, Bundle paramBundle)
    {
      GMTrace.i(17862634766336L, 133087);
      GMTrace.o(17862634766336L, 133087);
      return false;
    }
    
    final i bv(String paramString)
    {
      GMTrace.i(17862232113152L, 133084);
      if (paramString.trim().startsWith("weixin://bizmsgmenu"))
      {
        paramString = new i(paramString, 43, null);
        GMTrace.o(17862232113152L, 133084);
        return paramString;
      }
      GMTrace.o(17862232113152L, 133084);
      return null;
    }
    
    final int[] oN()
    {
      GMTrace.i(17862366330880L, 133085);
      GMTrace.o(17862366330880L, 133085);
      return new int[] { 43 };
    }
  }
  
  @URISpanHandlerSet.a
  class CardUriSpanHandler
    extends URISpanHandlerSet.BaseUriSpanHandler
  {
    CardUriSpanHandler()
    {
      super();
      GMTrace.i(13022206623744L, 97023);
      GMTrace.o(13022206623744L, 97023);
    }
    
    final boolean a(i parami, com.tencent.mm.pluginsdk.ui.d.e parame)
    {
      GMTrace.i(13022609276928L, 97026);
      GMTrace.o(13022609276928L, 97026);
      return false;
    }
    
    final boolean a(String paramString, boolean paramBoolean, com.tencent.mm.pluginsdk.o paramo, Bundle paramBundle)
    {
      GMTrace.i(13022743494656L, 97027);
      if (paramString.startsWith("wxcard://cardjumptype=1"))
      {
        paramString = null;
        if (paramo != null) {
          paramString = paramo.bCn().toString();
        }
        paramo = new Intent();
        paramo.putExtra("user_name", paramString);
        paramo.putExtra("view_type", 1);
        com.tencent.mm.bb.d.b(URISpanHandlerSet.this.mContext, "card", ".ui.CardViewUI", paramo);
        GMTrace.o(13022743494656L, 97027);
        return true;
      }
      GMTrace.o(13022743494656L, 97027);
      return false;
    }
    
    final i bv(String paramString)
    {
      GMTrace.i(13022340841472L, 97024);
      GMTrace.o(13022340841472L, 97024);
      return null;
    }
    
    final int[] oN()
    {
      GMTrace.i(13022475059200L, 97025);
      GMTrace.o(13022475059200L, 97025);
      return new int[0];
    }
  }
  
  @URISpanHandlerSet.a
  class ContactUriSpanHandler
    extends URISpanHandlerSet.BaseUriSpanHandler
  {
    ContactUriSpanHandler()
    {
      super();
      GMTrace.i(13022877712384L, 97028);
      GMTrace.o(13022877712384L, 97028);
    }
    
    final boolean a(i parami, com.tencent.mm.pluginsdk.ui.d.e parame)
    {
      int k = 0;
      GMTrace.i(13023280365568L, 97031);
      int i = parami.type;
      if ((i == 23) || (i == 21) || (i == 22) || (i == 2))
      {
        aq localaq = (aq)parami.r(aq.class);
        if (parame != null) {
          parame.a(parami);
        }
        if (localaq == null)
        {
          com.tencent.mm.ui.base.g.b(URISpanHandlerSet.this.mContext, URISpanHandlerSet.this.mContext.getString(R.l.ewd), URISpanHandlerSet.this.mContext.getString(R.l.dIG), true);
          GMTrace.o(13023280365568L, 97031);
          return false;
        }
        if (localaq.getType().equals("@t.qq.com"))
        {
          ap.yY();
          if (com.tencent.mm.u.c.wZ().AF("@t.qq.com") == null) {
            break label388;
          }
          i = 1;
          if (i == 0) {
            com.tencent.mm.ui.base.g.b(URISpanHandlerSet.this.mContext, URISpanHandlerSet.this.mContext.getString(R.l.ewd), URISpanHandlerSet.this.mContext.getString(R.l.dIG), true);
          }
        }
        int j;
        if (localaq.getType().equals("@domain.android"))
        {
          ap.yY();
          parami = com.tencent.mm.u.c.wZ().aKd();
          j = k;
          if (parami.size() > 0) {
            i = 0;
          }
        }
        for (;;)
        {
          j = k;
          if (i < parami.size())
          {
            if (((ay)parami.get(i)).isEnable()) {
              j = 1;
            }
          }
          else
          {
            if (j == 0) {
              com.tencent.mm.ui.base.g.b(URISpanHandlerSet.this.mContext, URISpanHandlerSet.this.mContext.getString(R.l.ewd), URISpanHandlerSet.this.mContext.getString(R.l.dIG), true);
            }
            parami = new Intent();
            parami.setClass(URISpanHandlerSet.this.mContext, SelectContactUI.class);
            parami.putExtra("Contact_GroupFilter_Type", localaq.getType()).putExtra("Contact_GroupFilter_Str", localaq.bLM()).putExtra("Contact_GroupFilter_DisplayName", localaq.tK());
            parami.addFlags(268435456);
            URISpanHandlerSet.this.mContext.startActivity(parami);
            GMTrace.o(13023280365568L, 97031);
            return true;
            label388:
            i = 0;
            break;
          }
          i += 1;
        }
      }
      GMTrace.o(13023280365568L, 97031);
      return false;
    }
    
    final boolean a(String paramString, boolean paramBoolean, com.tencent.mm.pluginsdk.o paramo, Bundle paramBundle)
    {
      GMTrace.i(13023414583296L, 97032);
      if ((paramString.equals("weixin://contacts/microblog/")) || (paramString.equals("weixin://contacts/micromessenger/")) || (paramString.equals("weixin://contacts/all/")))
      {
        paramo = com.tencent.mm.u.t.fU(URISpanHandlerSet.this.mContext.getString(R.l.eqA));
        if (paramString.equals("weixin://contacts/microblog/")) {
          paramo = com.tencent.mm.u.t.fU(URISpanHandlerSet.this.mContext.getString(R.l.eqz));
        }
        if (paramString.equals("weixin://contacts/micromessenger/")) {
          paramo = com.tencent.mm.u.t.fU(URISpanHandlerSet.this.mContext.getString(R.l.eqA));
        }
        if (paramString.equals("weixin://contacts/all/")) {
          paramo = com.tencent.mm.u.t.fU(URISpanHandlerSet.this.mContext.getString(R.l.eqw));
        }
        paramString = new Intent();
        paramString.setClass(URISpanHandlerSet.this.mContext, SelectContactUI.class);
        paramString.putExtra("Contact_GroupFilter_Type", paramo.getType()).putExtra("Contact_GroupFilter_Str", paramo.bLM()).putExtra("Contact_GroupFilter_DisplayName", paramo.tK());
        paramString.addFlags(268435456);
        GMTrace.o(13023414583296L, 97032);
        return true;
      }
      GMTrace.o(13023414583296L, 97032);
      return false;
    }
    
    final i bv(String paramString)
    {
      Object localObject = null;
      GMTrace.i(13023011930112L, 97029);
      if (paramString.trim().equals("weixin://contacts/all/")) {
        localObject = new i(paramString, 23, new aq("@all.android", null, URISpanHandlerSet.this.mContext.getString(R.l.eqw), null, true, true));
      }
      for (;;)
      {
        GMTrace.o(13023011930112L, 97029);
        return (i)localObject;
        if (paramString.trim().equals("weixin://contacts/microblog/"))
        {
          localObject = new i(paramString, 22, com.tencent.mm.u.t.fU(URISpanHandlerSet.this.mContext.getString(R.l.eqz)));
        }
        else if (paramString.trim().equals("weixin://contacts/micromessenger/"))
        {
          localObject = new i(paramString, 2, new aq("@micromsg.qq.com", null, URISpanHandlerSet.this.mContext.getString(R.l.eqA), null, true, true));
        }
        else if (paramString.trim().startsWith("weixin://contacts/"))
        {
          localObject = paramString.trim().substring(0, paramString.trim().length() - 1);
          int i = ((String)localObject).lastIndexOf("/");
          if (i == -1)
          {
            GMTrace.o(13023011930112L, 97029);
            return null;
          }
          localObject = ((String)localObject).substring(i + 1);
          localObject = new i(paramString, 21, com.tencent.mm.u.t.I("@" + (String)localObject, URISpanHandlerSet.this.mContext.getString(R.l.eqy)));
        }
      }
    }
    
    final int[] oN()
    {
      GMTrace.i(13023146147840L, 97030);
      GMTrace.o(13023146147840L, 97030);
      return new int[] { 23, 21, 22, 2 };
    }
  }
  
  @URISpanHandlerSet.a(oO=URISpanHandlerSet.PRIORITY.LOW)
  class DeeplinkUriSpanHandler
    extends URISpanHandlerSet.BaseUriSpanHandler
  {
    DeeplinkUriSpanHandler()
    {
      super();
      GMTrace.i(13027306897408L, 97061);
      GMTrace.o(13027306897408L, 97061);
    }
    
    final boolean a(final i parami, final com.tencent.mm.pluginsdk.ui.d.e parame)
    {
      GMTrace.i(13027709550592L, 97064);
      v.i("MicroMsg.URISpanHandlerSet", "DeeplinkUriSpanHandler handleSpanClick %d, %s", new Object[] { Integer.valueOf(parami.type), parami.url });
      if (parame != null) {}
      for (parame = (String)parame.a(parami);; parame = null)
      {
        if (parami.type == 30)
        {
          parami = bf.mz(parami.url);
          final BizInfo localBizInfo;
          if ((parami.startsWith("weixin://shieldBrandMsg/")) || (parami.startsWith("weixin://receiveBrandMsg/")))
          {
            if (bf.mA(parame))
            {
              v.e("MicroMsg.URISpanHandlerSet", "DeeplinkUriSpanHandler username is null");
              GMTrace.o(13027709550592L, 97064);
              return true;
            }
            localBizInfo = com.tencent.mm.modelbiz.e.hW(parame);
            if (localBizInfo == null)
            {
              v.e("MicroMsg.URISpanHandlerSet", "DeeplinkUriSpanHandler BizInfo is null");
              GMTrace.o(13027709550592L, 97064);
              return true;
            }
            if (parami.startsWith("weixin://shieldBrandMsg/")) {
              com.tencent.mm.ui.base.g.a(URISpanHandlerSet.this.mContext, R.l.eXT, R.l.dIG, R.l.eXS, R.l.cancel, new DialogInterface.OnClickListener()
              {
                public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
                {
                  GMTrace.i(13025830502400L, 97050);
                  paramAnonymousInt = localBizInfo.field_brandFlag;
                  localBizInfo.field_brandFlag |= 0x1;
                  v.i("MicroMsg.URISpanHandlerSet", "shield biz msg %s, %s, old = %d, new = %d", new Object[] { parami, parame, Integer.valueOf(paramAnonymousInt), Integer.valueOf(localBizInfo.field_brandFlag) });
                  com.tencent.mm.modelbiz.e.f(localBizInfo);
                  GMTrace.o(13025830502400L, 97050);
                }
              }, null);
            }
          }
          for (;;)
          {
            GMTrace.o(13027709550592L, 97064);
            return true;
            if (parami.startsWith("weixin://receiveBrandMsg/"))
            {
              com.tencent.mm.ui.base.g.a(URISpanHandlerSet.this.mContext, R.l.eXR, R.l.dIG, R.l.eXQ, R.l.cancel, new DialogInterface.OnClickListener()
              {
                public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
                {
                  GMTrace.i(13030796558336L, 97087);
                  paramAnonymousInt = localBizInfo.field_brandFlag;
                  localBizInfo.field_brandFlag &= 0xFFFFFFFE;
                  v.i("MicroMsg.URISpanHandlerSet", "receive biz msg %s, %s, old = %d, new = %d", new Object[] { parami, parame, Integer.valueOf(paramAnonymousInt), Integer.valueOf(localBizInfo.field_brandFlag) });
                  com.tencent.mm.modelbiz.e.f(localBizInfo);
                  GMTrace.o(13030796558336L, 97087);
                }
              }, null);
              continue;
              if (com.tencent.mm.pluginsdk.d.i(Uri.parse(parami)))
              {
                com.tencent.mm.pluginsdk.d.s(URISpanHandlerSet.this.mContext, parame, parami);
              }
              else if (parami.startsWith("weixin://receiveWeAppKFMsg"))
              {
                if (bf.mA(parame))
                {
                  v.e("MicroMsg.URISpanHandlerSet", "DeeplinkUriSpanHandler username is null, handle the BUILTIN_RECEIVE_WEAPP_KFMSG ,  the herfUrl is %s", new Object[] { parami });
                  GMTrace.o(13027709550592L, 97064);
                  return true;
                }
                com.tencent.mm.ui.base.g.a(URISpanHandlerSet.this.mContext, R.l.dFH, R.l.dIG, R.l.dFG, R.l.cancel, new DialogInterface.OnClickListener()
                {
                  public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
                  {
                    GMTrace.i(13031736082432L, 97094);
                    v.i("MicroMsg.URISpanHandlerSet", "AppBrandServiceHelper switchTo to receive msg for username %s", new Object[] { parame });
                    com.tencent.mm.ui.d.b.j(URISpanHandlerSet.this.mContext, parame, true);
                    GMTrace.o(13031736082432L, 97094);
                  }
                }, null);
              }
              else
              {
                com.tencent.mm.pluginsdk.d.a(URISpanHandlerSet.this.mContext, parami, parame, 1, parami, null);
              }
            }
          }
        }
        GMTrace.o(13027709550592L, 97064);
        return false;
      }
    }
    
    final boolean a(String paramString, boolean paramBoolean, final com.tencent.mm.pluginsdk.o paramo, Bundle paramBundle)
    {
      GMTrace.i(13027843768320L, 97065);
      if ((bf.mA(paramString)) || (paramBundle == null))
      {
        if (paramString == null)
        {
          paramBoolean = true;
          if (paramBundle != null) {
            break label75;
          }
        }
        label75:
        for (boolean bool = true;; bool = false)
        {
          v.e("MicroMsg.URISpanHandlerSet", "url is null ? %b, paramsBundle is null ? %b", new Object[] { Boolean.valueOf(paramBoolean), Boolean.valueOf(bool) });
          GMTrace.o(13027843768320L, 97065);
          return false;
          paramBoolean = false;
          break;
        }
      }
      if (com.tencent.mm.pluginsdk.d.i(Uri.parse(paramString)))
      {
        int j = paramBundle.getInt("key_scene", -1);
        v.d("MicroMsg.URISpanHandlerSet", "DeeplinkUriSpanHandler jump, %d, %s", new Object[] { Integer.valueOf(j), paramString });
        int i = j;
        if (j == -1) {
          i = 5;
        }
        paramo = com.tencent.mm.ui.base.g.a(URISpanHandlerSet.this.mContext, "", true, null);
        com.tencent.mm.pluginsdk.d.a(URISpanHandlerSet.this.mContext, paramString, i, new d.a()
        {
          public final void a(int paramAnonymousInt1, int paramAnonymousInt2, String paramAnonymousString, k paramAnonymousk, boolean paramAnonymousBoolean)
          {
            GMTrace.i(13024354107392L, 97039);
            if ((paramo != null) && (paramo.isShowing())) {
              paramo.dismiss();
            }
            if ((paramAnonymousk != null) && (paramAnonymousInt1 != 0) && (paramAnonymousInt2 != 0) && ((paramAnonymousk instanceof ah)))
            {
              paramAnonymousString = ((ah)paramAnonymousk).JA();
              if ((paramAnonymousString != null) && (URISpanHandlerSet.this.mContext != null)) {
                s.makeText(URISpanHandlerSet.this.mContext, URISpanHandlerSet.this.mContext.getString(R.l.dIG) + " : " + bf.mz(paramAnonymousString.uet), 0).show();
              }
            }
            GMTrace.o(13024354107392L, 97039);
          }
        });
        GMTrace.o(13027843768320L, 97065);
        return true;
      }
      GMTrace.o(13027843768320L, 97065);
      return false;
    }
    
    final i bv(String paramString)
    {
      GMTrace.i(13027441115136L, 97062);
      v.i("MicroMsg.URISpanHandlerSet", "DeeplinkUriSpanHandler getHrefFromUrl %s", new Object[] { paramString });
      if (paramString.trim().toLowerCase().startsWith("weixin://"))
      {
        paramString = new i(paramString, 30, null);
        GMTrace.o(13027441115136L, 97062);
        return paramString;
      }
      GMTrace.o(13027441115136L, 97062);
      return null;
    }
    
    final int[] oN()
    {
      GMTrace.i(13027575332864L, 97063);
      GMTrace.o(13027575332864L, 97063);
      return new int[] { 30 };
    }
  }
  
  @URISpanHandlerSet.a
  class EmotionStoreUriSpanHandler
    extends URISpanHandlerSet.BaseUriSpanHandler
  {
    EmotionStoreUriSpanHandler()
    {
      super();
      GMTrace.i(13024488325120L, 97040);
      GMTrace.o(13024488325120L, 97040);
    }
    
    final boolean a(i parami, com.tencent.mm.pluginsdk.ui.d.e parame)
    {
      GMTrace.i(13024890978304L, 97043);
      if (parami.type == 29)
      {
        if (parame != null) {
          parame.a(parami);
        }
        parame = new Intent();
        parame.putExtra("download_entrance_scene", 21);
        parame.putExtra("extra_id", (String)parami.r(String.class));
        parame.putExtra("preceding_scence", 3);
        com.tencent.mm.bb.d.b(URISpanHandlerSet.this.mContext, "emoji", ".ui.EmojiStoreDetailUI", parame);
        GMTrace.o(13024890978304L, 97043);
        return true;
      }
      GMTrace.o(13024890978304L, 97043);
      return false;
    }
    
    final boolean a(String paramString, boolean paramBoolean, com.tencent.mm.pluginsdk.o paramo, Bundle paramBundle)
    {
      GMTrace.i(13025025196032L, 97044);
      GMTrace.o(13025025196032L, 97044);
      return false;
    }
    
    final i bv(String paramString)
    {
      GMTrace.i(13024622542848L, 97041);
      if (paramString.trim().startsWith("weixin://emoticonstore/"))
      {
        int i = paramString.lastIndexOf("/");
        String str = "";
        if (i != -1) {
          str = paramString.substring(i + 1);
        }
        paramString = new i(paramString, 29, str);
        GMTrace.o(13024622542848L, 97041);
        return paramString;
      }
      GMTrace.o(13024622542848L, 97041);
      return null;
    }
    
    final int[] oN()
    {
      GMTrace.i(13024756760576L, 97042);
      GMTrace.o(13024756760576L, 97042);
      return new int[] { 29 };
    }
  }
  
  @URISpanHandlerSet.a
  class EnterRoomUriSpanHandler
    extends URISpanHandlerSet.BaseUriSpanHandler
  {
    EnterRoomUriSpanHandler()
    {
      super();
      GMTrace.i(13037507444736L, 97137);
      GMTrace.o(13037507444736L, 97137);
    }
    
    final boolean a(i parami, com.tencent.mm.pluginsdk.ui.d.e parame)
    {
      GMTrace.i(13037910097920L, 97140);
      GMTrace.o(13037910097920L, 97140);
      return false;
    }
    
    final boolean a(String paramString, boolean paramBoolean, com.tencent.mm.pluginsdk.o paramo, Bundle paramBundle)
    {
      GMTrace.i(13038044315648L, 97141);
      if (paramString.startsWith("weixin://jump/mainframe/"))
      {
        int i = paramString.trim().lastIndexOf("/");
        if ((i >= 0) && (i < paramString.trim().length() - 1))
        {
          paramString = paramString.trim().substring(i + 1);
          if (com.tencent.mm.u.o.dH(paramString))
          {
            ap.yY();
            paramo = com.tencent.mm.u.c.wR().Rb(paramString);
            if ((paramo == null) || ((int)paramo.gTG == 0))
            {
              paramo = new x();
              paramo.setUsername(paramString);
              ap.yY();
              com.tencent.mm.u.c.wR().R(paramo);
            }
          }
          paramString = new Intent(URISpanHandlerSet.this.mContext, En_5b8fbb1e.class).putExtra("Chat_User", paramString).putExtra("Chat_Mode", 1);
          if ((URISpanHandlerSet.this.mContext instanceof Service)) {
            paramString.addFlags(268435456);
          }
          URISpanHandlerSet.this.mContext.startActivity(paramString);
          GMTrace.o(13038044315648L, 97141);
          return true;
        }
      }
      GMTrace.o(13038044315648L, 97141);
      return false;
    }
    
    final i bv(String paramString)
    {
      GMTrace.i(13037641662464L, 97138);
      GMTrace.o(13037641662464L, 97138);
      return null;
    }
    
    final int[] oN()
    {
      GMTrace.i(13037775880192L, 97139);
      GMTrace.o(13037775880192L, 97139);
      return new int[0];
    }
  }
  
  @URISpanHandlerSet.a
  class ExposeUriSpanHandler
    extends URISpanHandlerSet.BaseUriSpanHandler
  {
    ExposeUriSpanHandler()
    {
      super();
      GMTrace.i(13008919068672L, 96924);
      GMTrace.o(13008919068672L, 96924);
    }
    
    final boolean a(i parami, com.tencent.mm.pluginsdk.ui.d.e parame)
    {
      GMTrace.i(13009321721856L, 96927);
      Intent localIntent;
      if (parami.type == 31)
      {
        localIntent = new Intent();
        parami = (String)parame.a(parami);
        localIntent.putExtra("k_username", parami);
        if ((bf.mA(parami)) || (!parami.endsWith("@chatroom"))) {
          break label134;
        }
      }
      label134:
      for (int i = 36;; i = 39)
      {
        localIntent.putExtra("showShare", false);
        localIntent.putExtra("rawUrl", String.format("https://weixin110.qq.com/security/readtemplate?t=weixin_report/w_type&scene=%d#wechat_redirect", new Object[] { Integer.valueOf(i) }));
        com.tencent.mm.bb.d.b(URISpanHandlerSet.this.mContext, "webview", ".ui.tools.WebViewUI", localIntent);
        GMTrace.o(13009321721856L, 96927);
        return true;
        GMTrace.o(13009321721856L, 96927);
        return false;
      }
    }
    
    final boolean a(String paramString, boolean paramBoolean, com.tencent.mm.pluginsdk.o paramo, Bundle paramBundle)
    {
      GMTrace.i(13009455939584L, 96928);
      GMTrace.o(13009455939584L, 96928);
      return false;
    }
    
    final i bv(String paramString)
    {
      GMTrace.i(13009053286400L, 96925);
      if (paramString.trim().toLowerCase().equals("weixin://expose/"))
      {
        paramString = new i(paramString, 31, null);
        GMTrace.o(13009053286400L, 96925);
        return paramString;
      }
      GMTrace.o(13009053286400L, 96925);
      return null;
    }
    
    final int[] oN()
    {
      GMTrace.i(13009187504128L, 96926);
      GMTrace.o(13009187504128L, 96926);
      return new int[] { 31 };
    }
  }
  
  @URISpanHandlerSet.a
  class FeedbackUriSpanHandler
    extends URISpanHandlerSet.BaseUriSpanHandler
  {
    FeedbackUriSpanHandler()
    {
      super();
      GMTrace.i(13016703696896L, 96982);
      GMTrace.o(13016703696896L, 96982);
    }
    
    final boolean a(i parami, com.tencent.mm.pluginsdk.ui.d.e parame)
    {
      GMTrace.i(13017106350080L, 96985);
      if (parami.type == 34)
      {
        parame = parami.url.trim().replace("weixin://feedback/next/", "");
        v.d("MicroMsg.URISpanHandlerSet", "FeedbackUriSpanHandler, url:%s, content:%s", new Object[] { parami.url, parame });
        ap.vd().a(new com.tencent.mm.pluginsdk.model.m(com.tencent.mm.compatible.d.p.rP(), parame, 8), 0);
        GMTrace.o(13017106350080L, 96985);
        return true;
      }
      GMTrace.o(13017106350080L, 96985);
      return false;
    }
    
    final boolean a(String paramString, boolean paramBoolean, com.tencent.mm.pluginsdk.o paramo, Bundle paramBundle)
    {
      GMTrace.i(13017240567808L, 96986);
      GMTrace.o(13017240567808L, 96986);
      return false;
    }
    
    final i bv(String paramString)
    {
      GMTrace.i(13016837914624L, 96983);
      if (paramString.trim().startsWith("weixin://feedback/next/"))
      {
        paramString = new i(paramString, 34, null);
        GMTrace.o(13016837914624L, 96983);
        return paramString;
      }
      GMTrace.o(13016837914624L, 96983);
      return null;
    }
    
    final int[] oN()
    {
      GMTrace.i(13016972132352L, 96984);
      GMTrace.o(13016972132352L, 96984);
      return new int[] { 34 };
    }
  }
  
  @URISpanHandlerSet.a
  class FlowStatUriSpanHandler
    extends URISpanHandlerSet.BaseUriSpanHandler
  {
    FlowStatUriSpanHandler()
    {
      super();
      GMTrace.i(13010261245952L, 96934);
      GMTrace.o(13010261245952L, 96934);
    }
    
    final boolean a(i parami, com.tencent.mm.pluginsdk.ui.d.e parame)
    {
      GMTrace.i(13010663899136L, 96937);
      if (parami.type == 16)
      {
        if (parame != null) {
          parame.a(parami);
        }
        parami = LauncherUI.bPy();
        if (parami != null) {
          parami.uPX.SC("tab_settings");
        }
        GMTrace.o(13010663899136L, 96937);
        return true;
      }
      GMTrace.o(13010663899136L, 96937);
      return false;
    }
    
    final boolean a(String paramString, boolean paramBoolean, com.tencent.mm.pluginsdk.o paramo, Bundle paramBundle)
    {
      GMTrace.i(13010798116864L, 96938);
      if (paramString.equals("weixin://flowstat"))
      {
        paramString = LauncherUI.bPy();
        if (paramString != null) {
          paramString.uPX.SC("tab_settings");
        }
        GMTrace.o(13010798116864L, 96938);
        return true;
      }
      GMTrace.o(13010798116864L, 96938);
      return false;
    }
    
    final i bv(String paramString)
    {
      GMTrace.i(13010395463680L, 96935);
      if (paramString.trim().startsWith("weixin://flowstat"))
      {
        paramString = new i(paramString, 16, null);
        GMTrace.o(13010395463680L, 96935);
        return paramString;
      }
      GMTrace.o(13010395463680L, 96935);
      return null;
    }
    
    final int[] oN()
    {
      GMTrace.i(13010529681408L, 96936);
      GMTrace.o(13010529681408L, 96936);
      return new int[] { 16 };
    }
  }
  
  @URISpanHandlerSet.a
  class FriendMobileUriSpanHandler
    extends URISpanHandlerSet.BaseUriSpanHandler
  {
    FriendMobileUriSpanHandler()
    {
      super();
      GMTrace.i(13039520710656L, 97152);
      GMTrace.o(13039520710656L, 97152);
    }
    
    final boolean a(i parami, com.tencent.mm.pluginsdk.ui.d.e parame)
    {
      GMTrace.i(13039923363840L, 97155);
      if (parami.type == 20)
      {
        if (parame != null) {
          parame.a(parami);
        }
        parami = new Intent(URISpanHandlerSet.this.mContext, MobileFriendUI.class);
        URISpanHandlerSet.this.mContext.startActivity(parami);
        GMTrace.o(13039923363840L, 97155);
        return true;
      }
      GMTrace.o(13039923363840L, 97155);
      return false;
    }
    
    final boolean a(String paramString, boolean paramBoolean, com.tencent.mm.pluginsdk.o paramo, Bundle paramBundle)
    {
      GMTrace.i(13040057581568L, 97156);
      if (paramString.equals("weixin://findfriend/mobile"))
      {
        paramString = new Intent(URISpanHandlerSet.this.mContext, MobileFriendUI.class);
        if ((URISpanHandlerSet.this.mContext instanceof Service)) {
          paramString.addFlags(268435456);
        }
        URISpanHandlerSet.this.mContext.startActivity(paramString);
        GMTrace.o(13040057581568L, 97156);
        return true;
      }
      GMTrace.o(13040057581568L, 97156);
      return false;
    }
    
    final i bv(String paramString)
    {
      GMTrace.i(13039654928384L, 97153);
      if (paramString.trim().startsWith("weixin://findfriend/mobile"))
      {
        paramString = new i(paramString, 20, null);
        GMTrace.o(13039654928384L, 97153);
        return paramString;
      }
      GMTrace.o(13039654928384L, 97153);
      return null;
    }
    
    final int[] oN()
    {
      GMTrace.i(13039789146112L, 97154);
      GMTrace.o(13039789146112L, 97154);
      return new int[] { 20 };
    }
  }
  
  @URISpanHandlerSet.a
  class FriendSearchUriSpanHandler
    extends URISpanHandlerSet.BaseUriSpanHandler
  {
    FriendSearchUriSpanHandler()
    {
      super();
      GMTrace.i(13019388051456L, 97002);
      GMTrace.o(13019388051456L, 97002);
    }
    
    final boolean a(i parami, com.tencent.mm.pluginsdk.ui.d.e parame)
    {
      GMTrace.i(13019790704640L, 97005);
      if (parami.type == 17)
      {
        if (parame != null) {
          parame.a(parami);
        }
        com.tencent.mm.bb.d.w(URISpanHandlerSet.this.mContext, "subapp", ".ui.pluginapp.ContactSearchUI");
        GMTrace.o(13019790704640L, 97005);
        return true;
      }
      GMTrace.o(13019790704640L, 97005);
      return false;
    }
    
    final boolean a(String paramString, boolean paramBoolean, com.tencent.mm.pluginsdk.o paramo, Bundle paramBundle)
    {
      GMTrace.i(13019924922368L, 97006);
      if (paramString.equals("weixin://findfriend/search"))
      {
        paramString = new Intent();
        if ((URISpanHandlerSet.this.mContext instanceof Service)) {
          paramString.addFlags(268435456);
        }
        com.tencent.mm.bb.d.b(URISpanHandlerSet.this.mContext, "subapp", ".ui.pluginapp.ContactSearchUI", paramString);
        GMTrace.o(13019924922368L, 97006);
        return true;
      }
      GMTrace.o(13019924922368L, 97006);
      return false;
    }
    
    final i bv(String paramString)
    {
      GMTrace.i(13019522269184L, 97003);
      if (paramString.trim().startsWith("weixin://findfriend/search"))
      {
        paramString = new i(paramString, 17, null);
        GMTrace.o(13019522269184L, 97003);
        return paramString;
      }
      GMTrace.o(13019522269184L, 97003);
      return null;
    }
    
    final int[] oN()
    {
      GMTrace.i(13019656486912L, 97004);
      GMTrace.o(13019656486912L, 97004);
      return new int[] { 17 };
    }
  }
  
  @URISpanHandlerSet.a
  class FriendShareUriSpanHandler
    extends URISpanHandlerSet.BaseUriSpanHandler
  {
    FriendShareUriSpanHandler()
    {
      super();
      GMTrace.i(13017374785536L, 96987);
      GMTrace.o(13017374785536L, 96987);
    }
    
    final boolean a(i parami, com.tencent.mm.pluginsdk.ui.d.e parame)
    {
      GMTrace.i(13017777438720L, 96990);
      if (parami.type == 18)
      {
        if (parame != null) {
          parame.a(parami);
        }
        com.tencent.mm.bb.d.w(URISpanHandlerSet.this.mContext, "setting", ".ui.qrcode.ShareMicroMsgChoiceUI");
        GMTrace.o(13017777438720L, 96990);
        return true;
      }
      GMTrace.o(13017777438720L, 96990);
      return false;
    }
    
    final boolean a(String paramString, boolean paramBoolean, com.tencent.mm.pluginsdk.o paramo, Bundle paramBundle)
    {
      GMTrace.i(13017911656448L, 96991);
      if (paramString.equals("weixin://findfriend/share"))
      {
        paramString = new Intent();
        if ((URISpanHandlerSet.this.mContext instanceof Service)) {
          paramString.addFlags(268435456);
        }
        com.tencent.mm.bb.d.b(URISpanHandlerSet.this.mContext, "setting", ".ui.qrcode.ShareMicroMsgChoiceUI", paramString);
        GMTrace.o(13017911656448L, 96991);
        return true;
      }
      GMTrace.o(13017911656448L, 96991);
      return false;
    }
    
    final i bv(String paramString)
    {
      GMTrace.i(13017509003264L, 96988);
      if (paramString.trim().startsWith("weixin://findfriend/share"))
      {
        paramString = new i(paramString, 18, null);
        GMTrace.o(13017509003264L, 96988);
        return paramString;
      }
      GMTrace.o(13017509003264L, 96988);
      return null;
    }
    
    final int[] oN()
    {
      GMTrace.i(13017643220992L, 96989);
      GMTrace.o(13017643220992L, 96989);
      return new int[] { 18 };
    }
  }
  
  @URISpanHandlerSet.a
  class HttpUriSpanHandler
    extends URISpanHandlerSet.BaseUriSpanHandler
  {
    HttpUriSpanHandler()
    {
      super();
      GMTrace.i(13020193357824L, 97008);
      GMTrace.o(13020193357824L, 97008);
    }
    
    final boolean a(i parami, com.tencent.mm.pluginsdk.ui.d.e parame)
    {
      GMTrace.i(13020596011008L, 97011);
      Object localObject1;
      if (parami.type == 1)
      {
        parami.r(aq.class);
        localObject1 = com.tencent.mm.u.t.I("@" + parami.url, URISpanHandlerSet.this.mContext.getString(R.l.eqy));
        if (parame == null) {
          break label374;
        }
      }
      label359:
      label374:
      for (parame = (String)parame.a(parami);; parame = null)
      {
        Object localObject2;
        if ((localObject1 == null) || (!((aq)localObject1).fFL))
        {
          localObject2 = parami.url;
          localObject1 = localObject2;
          if (!((String)localObject2).toLowerCase().startsWith("http")) {
            localObject1 = "http://" + (String)localObject2;
          }
          localObject2 = new Intent();
          ((Intent)localObject2).putExtra("rawUrl", (String)localObject1);
          if ((parami.data != null) && ((parami.data instanceof Integer))) {
            ((Intent)localObject2).putExtra("geta8key_scene", ((Integer)parami.data).intValue());
          }
          parami = parami.iCm;
          if (!bf.mA(parami))
          {
            Object localObject3 = q.yC().fP(parami);
            if (localObject3 != null)
            {
              localObject1 = ((q.b)localObject3).getString("prePublishId", null);
              String str = ((q.b)localObject3).getString("preUsername", null);
              localObject3 = ((q.b)localObject3).getString("preChatName", null);
              ((Intent)localObject2).putExtra("reportSessionId", parami);
              ((Intent)localObject2).putExtra("KPublisherId", (String)localObject1);
              ((Intent)localObject2).putExtra("geta8key_username", (String)localObject3);
              ((Intent)localObject2).putExtra("pre_username", str);
              ((Intent)localObject2).putExtra("prePublishId", (String)localObject1);
              ((Intent)localObject2).putExtra("preUsername", str);
              ((Intent)localObject2).putExtra("preChatName", (String)localObject3);
              ((Intent)localObject2).putExtra("preChatTYPE", com.tencent.mm.u.p.G(str, (String)localObject3));
            }
          }
          if (!bf.mA(parame)) {
            break label359;
          }
        }
        for (parami = null;; parami = parame)
        {
          ((Intent)localObject2).putExtra("geta8key_username", parami);
          com.tencent.mm.bb.d.b(URISpanHandlerSet.this.mContext, "webview", ".ui.tools.WebViewUI", (Intent)localObject2);
          GMTrace.o(13020596011008L, 97011);
          return true;
        }
        GMTrace.o(13020596011008L, 97011);
        return false;
      }
    }
    
    final boolean a(String paramString, boolean paramBoolean, com.tencent.mm.pluginsdk.o paramo, Bundle paramBundle)
    {
      GMTrace.i(13020730228736L, 97012);
      GMTrace.o(13020730228736L, 97012);
      return false;
    }
    
    final i bv(String paramString)
    {
      GMTrace.i(13020327575552L, 97009);
      if (paramString.trim().toLowerCase().startsWith("http")) {}
      for (paramString = new i(paramString, 1, null);; paramString = null)
      {
        GMTrace.o(13020327575552L, 97009);
        return paramString;
      }
    }
    
    final int[] oN()
    {
      GMTrace.i(13020461793280L, 97010);
      GMTrace.o(13020461793280L, 97010);
      return new int[] { 1 };
    }
  }
  
  @URISpanHandlerSet.a
  class JumpActivityUriSpanHandler
    extends URISpanHandlerSet.BaseUriSpanHandler
  {
    JumpActivityUriSpanHandler()
    {
      super();
      GMTrace.i(13005429407744L, 96898);
      GMTrace.o(13005429407744L, 96898);
    }
    
    final boolean a(i parami, com.tencent.mm.pluginsdk.ui.d.e parame)
    {
      GMTrace.i(13005832060928L, 96901);
      GMTrace.o(13005832060928L, 96901);
      return false;
    }
    
    final boolean a(String paramString, boolean paramBoolean, com.tencent.mm.pluginsdk.o paramo, Bundle paramBundle)
    {
      GMTrace.i(13005966278656L, 96902);
      if (paramString.toLowerCase().startsWith("weixin://jump/"))
      {
        paramString = paramString.split("/");
        paramString = paramString[(paramString.length - 1)];
        if ("mainframe".equalsIgnoreCase(paramString))
        {
          paramString = new Intent(URISpanHandlerSet.this.mContext, LauncherUI.class);
          if ((URISpanHandlerSet.this.mContext instanceof Service)) {
            paramString.addFlags(268435456);
          }
          paramString.addFlags(67108864);
          URISpanHandlerSet.this.mContext.startActivity(paramString);
        }
        for (;;)
        {
          GMTrace.o(13005966278656L, 96902);
          return true;
          if ("shake".equalsIgnoreCase(paramString))
          {
            com.tencent.mm.plugin.report.service.g.oSF.A(10221, "1");
            paramString = new Intent();
            paramString.addFlags(67108864);
            if ((URISpanHandlerSet.this.mContext instanceof Service)) {
              paramString.addFlags(268435456);
            }
            com.tencent.mm.bb.d.b(URISpanHandlerSet.this.mContext, "shake", ".ui.ShakeReportUI", paramString);
            if ((URISpanHandlerSet.this.mContext != null) && ((URISpanHandlerSet.this.mContext instanceof Activity))) {
              ((Activity)URISpanHandlerSet.this.mContext).finish();
            }
          }
          else if ("scanqrcode".equalsIgnoreCase(paramString))
          {
            paramString = new Intent();
            paramString.putExtra("BaseScanUI_select_scan_mode", 1);
            paramString.putExtra("GetFriendQRCodeUI.INTENT_FROM_ACTIVITY", 2);
            paramString.setFlags(65536);
            paramString.addFlags(67108864);
            if ((URISpanHandlerSet.this.mContext instanceof Service)) {
              paramString.addFlags(268435456);
            }
            com.tencent.mm.bb.d.b(URISpanHandlerSet.this.mContext, "scanner", ".ui.BaseScanUI", paramString);
          }
        }
      }
      GMTrace.o(13005966278656L, 96902);
      return false;
    }
    
    final i bv(String paramString)
    {
      GMTrace.i(13005563625472L, 96899);
      GMTrace.o(13005563625472L, 96899);
      return null;
    }
    
    final int[] oN()
    {
      GMTrace.i(13005697843200L, 96900);
      GMTrace.o(13005697843200L, 96900);
      return new int[0];
    }
  }
  
  @URISpanHandlerSet.a
  class LuckyMoneyUriSpanHandler
    extends URISpanHandlerSet.BaseUriSpanHandler
  {
    LuckyMoneyUriSpanHandler()
    {
      super();
      GMTrace.i(13015227301888L, 96971);
      GMTrace.o(13015227301888L, 96971);
    }
    
    final boolean a(i parami, com.tencent.mm.pluginsdk.ui.d.e parame)
    {
      GMTrace.i(13015629955072L, 96974);
      if (parami.type == 33)
      {
        parame = new Intent();
        parame.putExtra("key_native_url", parami.url);
        com.tencent.mm.bb.d.b(URISpanHandlerSet.this.mContext, "luckymoney", ".ui.LuckyMoneyDetailUI", parame);
        com.tencent.mm.plugin.report.service.g.oSF.i(12097, new Object[] { Integer.valueOf(11), Integer.valueOf(0), Long.valueOf(System.currentTimeMillis()) });
        com.tencent.mm.plugin.report.service.g.oSF.i(11850, new Object[] { Integer.valueOf(4), Integer.valueOf(1) });
        GMTrace.o(13015629955072L, 96974);
        return true;
      }
      GMTrace.o(13015629955072L, 96974);
      return false;
    }
    
    final boolean a(String paramString, boolean paramBoolean, com.tencent.mm.pluginsdk.o paramo, Bundle paramBundle)
    {
      GMTrace.i(13015764172800L, 96975);
      GMTrace.o(13015764172800L, 96975);
      return false;
    }
    
    final i bv(String paramString)
    {
      GMTrace.i(13015361519616L, 96972);
      if (paramString.trim().toLowerCase().startsWith("weixin://weixinhongbao/"))
      {
        paramString = new i(paramString, 33, null);
        GMTrace.o(13015361519616L, 96972);
        return paramString;
      }
      GMTrace.o(13015361519616L, 96972);
      return null;
    }
    
    final int[] oN()
    {
      GMTrace.i(13015495737344L, 96973);
      GMTrace.o(13015495737344L, 96973);
      return new int[] { 33 };
    }
  }
  
  static enum PRIORITY
  {
    static
    {
      GMTrace.i(13035225743360L, 97120);
      LOW = new PRIORITY("LOW", 0);
      NORMAL = new PRIORITY("NORMAL", 1);
      HIGH = new PRIORITY("HIGH", 2);
      $VALUES = new PRIORITY[] { LOW, NORMAL, HIGH };
      GMTrace.o(13035225743360L, 97120);
    }
    
    private PRIORITY()
    {
      GMTrace.i(13035091525632L, 97119);
      GMTrace.o(13035091525632L, 97119);
    }
  }
  
  @URISpanHandlerSet.a
  class PayTransferUriSpanHandler
    extends URISpanHandlerSet.BaseUriSpanHandler
  {
    PayTransferUriSpanHandler()
    {
      super();
      GMTrace.i(13026635808768L, 97056);
      GMTrace.o(13026635808768L, 97056);
    }
    
    final boolean a(i parami, com.tencent.mm.pluginsdk.ui.d.e parame)
    {
      GMTrace.i(13027038461952L, 97059);
      GMTrace.o(13027038461952L, 97059);
      return false;
    }
    
    final boolean a(String paramString, boolean paramBoolean, com.tencent.mm.pluginsdk.o paramo, Bundle paramBundle)
    {
      GMTrace.i(13027172679680L, 97060);
      if (paramString.startsWith("wxpay://"))
      {
        if (paramo == null) {
          break label255;
        }
        paramBundle = paramo.bCn().toString();
        paramo = paramo.bCo();
        if (!(paramo instanceof com.tencent.mm.plugin.wallet.a)) {
          break label250;
        }
        paramo = (com.tencent.mm.plugin.wallet.a)paramo;
      }
      for (;;)
      {
        if (bf.mA(paramBundle))
        {
          v.e("MicroMsg.URISpanHandlerSet", "SERVICE_JUMP_TO_PAY fail, null username");
          GMTrace.o(13027172679680L, 97060);
          return false;
        }
        String str = paramString.substring(8);
        paramString = str;
        if (str.indexOf("&") > 0) {
          paramString = str.split("&")[0];
        }
        int i = paramString.indexOf("=");
        if (i >= 0) {}
        for (paramString = paramString.substring(i + 1);; paramString = "")
        {
          if (bf.getInt(paramString, 0) == 1)
          {
            if ((com.tencent.mm.u.m.xZ()) || (com.tencent.mm.u.m.ya())) {
              com.tencent.mm.pluginsdk.wallet.e.a(URISpanHandlerSet.this.mContext, 5, paramBundle, 11, paramo);
            }
            for (;;)
            {
              GMTrace.o(13027172679680L, 97060);
              return true;
              com.tencent.mm.pluginsdk.wallet.e.a(URISpanHandlerSet.this.mContext, 2, paramBundle, 11, paramo);
            }
          }
          Toast.makeText(URISpanHandlerSet.this.mContext, URISpanHandlerSet.this.mContext.getString(R.l.eRh), 0).show();
          GMTrace.o(13027172679680L, 97060);
          return false;
          GMTrace.o(13027172679680L, 97060);
          return false;
        }
        label250:
        paramo = null;
        continue;
        label255:
        paramBundle = null;
        paramo = null;
      }
    }
    
    final i bv(String paramString)
    {
      GMTrace.i(13026770026496L, 97057);
      GMTrace.o(13026770026496L, 97057);
      return null;
    }
    
    final int[] oN()
    {
      GMTrace.i(13026904244224L, 97058);
      GMTrace.o(13026904244224L, 97058);
      return new int[0];
    }
  }
  
  @URISpanHandlerSet.a
  class PayUriSpanHandler
    extends URISpanHandlerSet.BaseUriSpanHandler
  {
    PayUriSpanHandler()
    {
      super();
      GMTrace.i(13014556213248L, 96966);
      GMTrace.o(13014556213248L, 96966);
    }
    
    final boolean a(i parami, com.tencent.mm.pluginsdk.ui.d.e parame)
    {
      GMTrace.i(13014958866432L, 96969);
      if (parami.type == 28)
      {
        if (parame != null) {
          parame.a(parami);
        }
        parame = new gr();
        parame.fLQ.actionCode = 11;
        parame.fLQ.result = parami.url;
        parame.fLQ.context = URISpanHandlerSet.this.mContext;
        parame.fLQ.fLS = new Bundle();
        parame.fLQ.fLS.putInt("pay_channel", 6);
        com.tencent.mm.sdk.b.a.uql.a(parame, Looper.myLooper());
        GMTrace.o(13014958866432L, 96969);
        return true;
      }
      GMTrace.o(13014958866432L, 96969);
      return false;
    }
    
    final boolean a(String paramString, boolean paramBoolean, com.tencent.mm.pluginsdk.o paramo, Bundle paramBundle)
    {
      GMTrace.i(13015093084160L, 96970);
      GMTrace.o(13015093084160L, 96970);
      return false;
    }
    
    final i bv(String paramString)
    {
      GMTrace.i(13014690430976L, 96967);
      GMTrace.o(13014690430976L, 96967);
      return null;
    }
    
    final int[] oN()
    {
      GMTrace.i(13014824648704L, 96968);
      GMTrace.o(13014824648704L, 96968);
      return new int[] { 28 };
    }
  }
  
  @URISpanHandlerSet.a
  class PhoneEmailUriSpanHandler
    extends URISpanHandlerSet.BaseUriSpanHandler
  {
    PhoneEmailUriSpanHandler()
    {
      super();
      GMTrace.i(13035359961088L, 97121);
      GMTrace.o(13035359961088L, 97121);
    }
    
    final boolean a(i parami, com.tencent.mm.pluginsdk.ui.d.e parame)
    {
      GMTrace.i(13035762614272L, 97124);
      Bundle localBundle;
      if (parami.type == 25)
      {
        parame = parami.username;
        localBundle = new Bundle();
        if ((parame != null) && (!parame.equals(com.tencent.mm.u.m.xL())))
        {
          localBundle.putString("Contact_User", parame);
          parame = com.tencent.mm.modelfriend.af.FZ().ja(parame);
          if ((parame == null) || (bf.mA(parame.EQ()))) {
            break label162;
          }
        }
      }
      label162:
      for (parame = bf.mz(parame.EY()).replace(" ", "");; parame = null)
      {
        localBundle.putString("Contact_Mobile_MD5", parame);
        localBundle.putInt("fromScene", 1);
        com.tencent.mm.pluginsdk.ui.d.j.a(URISpanHandlerSet.this.mContext, parami.url, null, localBundle);
        GMTrace.o(13035762614272L, 97124);
        return true;
        if (parami.type == 24) {
          com.tencent.mm.pluginsdk.ui.d.j.b(URISpanHandlerSet.this.mContext, parami.url, null);
        }
        GMTrace.o(13035762614272L, 97124);
        return false;
      }
    }
    
    final boolean a(String paramString, boolean paramBoolean, com.tencent.mm.pluginsdk.o paramo, Bundle paramBundle)
    {
      GMTrace.i(13035896832000L, 97125);
      GMTrace.o(13035896832000L, 97125);
      return false;
    }
    
    final i bv(String paramString)
    {
      GMTrace.i(13035494178816L, 97122);
      GMTrace.o(13035494178816L, 97122);
      return null;
    }
    
    final int[] oN()
    {
      GMTrace.i(13035628396544L, 97123);
      GMTrace.o(13035628396544L, 97123);
      return new int[] { 25, 24 };
    }
  }
  
  @URISpanHandlerSet.a
  class PluginUriSpanHandler
    extends URISpanHandlerSet.BaseUriSpanHandler
  {
    PluginUriSpanHandler()
    {
      super();
      GMTrace.i(13008247980032L, 96919);
      GMTrace.o(13008247980032L, 96919);
    }
    
    final boolean a(i parami, com.tencent.mm.pluginsdk.ui.d.e parame)
    {
      GMTrace.i(13008650633216L, 96922);
      GMTrace.o(13008650633216L, 96922);
      return false;
    }
    
    final boolean a(String paramString, boolean paramBoolean, com.tencent.mm.pluginsdk.o paramo, Bundle paramBundle)
    {
      GMTrace.i(13008784850944L, 96923);
      if (paramString.equals("weixin://plugin"))
      {
        paramString = new Intent();
        if ((URISpanHandlerSet.this.mContext instanceof Service)) {
          paramString.addFlags(268435456);
        }
        com.tencent.mm.bb.d.b(URISpanHandlerSet.this.mContext, "setting", ".ui.setting.SettingsPluginsUI", paramString);
        GMTrace.o(13008784850944L, 96923);
        return true;
      }
      GMTrace.o(13008784850944L, 96923);
      return false;
    }
    
    final i bv(String paramString)
    {
      GMTrace.i(13008382197760L, 96920);
      if (paramString.trim().startsWith("weixin://plugin"))
      {
        paramString = new i(paramString, 26, null);
        GMTrace.o(13008382197760L, 96920);
        return paramString;
      }
      GMTrace.o(13008382197760L, 96920);
      return null;
    }
    
    final int[] oN()
    {
      GMTrace.i(13008516415488L, 96921);
      GMTrace.o(13008516415488L, 96921);
      return new int[] { 26 };
    }
  }
  
  @URISpanHandlerSet.a
  class ProfileUriSpanHandler
    extends URISpanHandlerSet.BaseUriSpanHandler
  {
    ProfileUriSpanHandler()
    {
      super();
      GMTrace.i(13029991251968L, 97081);
      GMTrace.o(13029991251968L, 97081);
    }
    
    final boolean a(i parami, com.tencent.mm.pluginsdk.ui.d.e parame)
    {
      GMTrace.i(13030393905152L, 97084);
      if (parami.type == 3)
      {
        if (parame != null) {
          parame.a(parami);
        }
        parami = (String)parami.r(String.class);
        parame = new Intent();
        parame.addFlags(268435456);
        parame.putExtra("Contact_User", parami);
        ap.yY();
        x localx = com.tencent.mm.u.c.wR().Rb(parami);
        if ((localx != null) && ((int)localx.gTG > 0) && (com.tencent.mm.j.a.ez(localx.field_type))) {
          com.tencent.mm.ui.contact.e.a(parame, parami);
        }
        if (bf.mz(parami).length() > 0) {
          com.tencent.mm.bb.d.b(URISpanHandlerSet.this.mContext, "profile", ".ui.ContactInfoUI", parame);
        }
        GMTrace.o(13030393905152L, 97084);
        return true;
      }
      GMTrace.o(13030393905152L, 97084);
      return false;
    }
    
    final boolean a(String paramString, boolean paramBoolean, com.tencent.mm.pluginsdk.o paramo, Bundle paramBundle)
    {
      GMTrace.i(13030528122880L, 97085);
      if (paramString.startsWith("weixin://contacts/profile/"))
      {
        paramString = paramString.trim().replace("weixin://contacts/profile/", "").replace("/", "");
        if (bf.mA(paramString))
        {
          v.e("MicroMsg.URISpanHandlerSet", "jumpToActivity fail, user is null");
          GMTrace.o(13030528122880L, 97085);
          return true;
        }
        paramo = new Intent();
        paramo.addFlags(268435456);
        paramo.putExtra("Contact_User", paramString);
        ap.yY();
        paramBundle = com.tencent.mm.u.c.wR().Rb(paramString);
        if ((paramBundle != null) && ((int)paramBundle.gTG > 0) && (com.tencent.mm.j.a.ez(paramBundle.field_type))) {
          com.tencent.mm.ui.contact.e.a(paramo, paramString);
        }
        com.tencent.mm.bb.d.b(URISpanHandlerSet.this.mContext, "profile", ".ui.ContactInfoUI", paramo);
        GMTrace.o(13030528122880L, 97085);
        return true;
      }
      GMTrace.o(13030528122880L, 97085);
      return false;
    }
    
    final i bv(String paramString)
    {
      GMTrace.i(13030125469696L, 97082);
      if (paramString.trim().startsWith("weixin://contacts/profile/"))
      {
        paramString = new i(paramString, 3, paramString.trim().replace("weixin://contacts/profile/", "").replace("/", ""));
        GMTrace.o(13030125469696L, 97082);
        return paramString;
      }
      GMTrace.o(13030125469696L, 97082);
      return null;
    }
    
    final int[] oN()
    {
      GMTrace.i(13030259687424L, 97083);
      GMTrace.o(13030259687424L, 97083);
      return new int[] { 3 };
    }
  }
  
  @URISpanHandlerSet.a
  class ScanQrCodeUriSpanHandler
    extends URISpanHandlerSet.BaseUriSpanHandler
  {
    ScanQrCodeUriSpanHandler()
    {
      super();
      GMTrace.i(13030930776064L, 97088);
      GMTrace.o(13030930776064L, 97088);
    }
    
    final boolean a(i parami, com.tencent.mm.pluginsdk.ui.d.e parame)
    {
      GMTrace.i(13031333429248L, 97091);
      GMTrace.o(13031333429248L, 97091);
      return false;
    }
    
    final boolean a(String paramString, boolean paramBoolean, com.tencent.mm.pluginsdk.o paramo, Bundle paramBundle)
    {
      int j = 0;
      GMTrace.i(13031467646976L, 97092);
      if (paramString.equals("weixin://scanqrcode/"))
      {
        if (!paramBoolean)
        {
          v.e("MicroMsg.URISpanHandlerSet", "jumpToActivity, scan qrcode permission fail");
          GMTrace.o(13031467646976L, 97092);
          return true;
        }
        paramString = new Intent();
        paramString.putExtra("BaseScanUI_select_scan_mode", 1);
        int i = j;
        if (paramBundle != null)
        {
          i = j;
          if (paramBundle.getInt("fromScene") == 100) {
            i = 1;
          }
        }
        if (i == 0) {
          paramString.addFlags(67108864);
        }
        if ((URISpanHandlerSet.this.mContext instanceof Service)) {
          paramString.addFlags(268435456);
        }
        if (i != 0)
        {
          com.tencent.mm.bb.d.b(URISpanHandlerSet.this.mContext, "scanner", ".ui.SingleTopScanUI", paramString);
          GMTrace.o(13031467646976L, 97092);
          return true;
        }
        com.tencent.mm.bb.d.b(URISpanHandlerSet.this.mContext, "scanner", ".ui.BaseScanUI", paramString);
        GMTrace.o(13031467646976L, 97092);
        return true;
      }
      GMTrace.o(13031467646976L, 97092);
      return false;
    }
    
    final i bv(String paramString)
    {
      GMTrace.i(13031064993792L, 97089);
      GMTrace.o(13031064993792L, 97089);
      return null;
    }
    
    final int[] oN()
    {
      GMTrace.i(13031199211520L, 97090);
      GMTrace.o(13031199211520L, 97090);
      return new int[0];
    }
  }
  
  @URISpanHandlerSet.a
  class SetSafeDeviceUriSpanHandler
    extends URISpanHandlerSet.BaseUriSpanHandler
  {
    SetSafeDeviceUriSpanHandler()
    {
      super();
      GMTrace.i(13036031049728L, 97126);
      GMTrace.o(13036031049728L, 97126);
    }
    
    final boolean a(i parami, com.tencent.mm.pluginsdk.ui.d.e parame)
    {
      GMTrace.i(13036433702912L, 97129);
      GMTrace.o(13036433702912L, 97129);
      return false;
    }
    
    final boolean a(String paramString, boolean paramBoolean, com.tencent.mm.pluginsdk.o paramo, Bundle paramBundle)
    {
      GMTrace.i(13036567920640L, 97130);
      if (paramString.equals("weixin://setting/account/safedevice"))
      {
        ap.yY();
        paramString = (String)com.tencent.mm.u.c.vr().get(6, "");
        ap.yY();
        paramo = (String)com.tencent.mm.u.c.vr().get(4097, "");
        if (!bf.mA(paramString))
        {
          paramString = new Intent();
          if ((URISpanHandlerSet.this.mContext instanceof Service)) {
            paramString.addFlags(268435456);
          }
          com.tencent.mm.bb.d.w(URISpanHandlerSet.this.mContext, "safedevice", ".ui.MySafeDeviceListUI");
        }
        for (;;)
        {
          GMTrace.o(13036567920640L, 97130);
          return true;
          if (!bf.mA(paramo))
          {
            paramString = new Intent(URISpanHandlerSet.this.mContext, BindMContactIntroUI.class);
            paramString.putExtra("is_bind_for_safe_device", true);
            if ((URISpanHandlerSet.this.mContext instanceof Service)) {
              paramString.addFlags(268435456);
            }
            MMWizardActivity.w(URISpanHandlerSet.this.mContext, paramString);
          }
          else
          {
            paramString = new Intent();
            if ((URISpanHandlerSet.this.mContext instanceof Service)) {
              paramString.addFlags(268435456);
            }
            com.tencent.mm.bb.d.a(URISpanHandlerSet.this.mContext, "safedevice", ".ui.BindSafeDeviceUI", paramString);
          }
        }
      }
      GMTrace.o(13036567920640L, 97130);
      return false;
    }
    
    final i bv(String paramString)
    {
      GMTrace.i(13036165267456L, 97127);
      GMTrace.o(13036165267456L, 97127);
      return null;
    }
    
    final int[] oN()
    {
      GMTrace.i(13036299485184L, 97128);
      GMTrace.o(13036299485184L, 97128);
      return new int[0];
    }
  }
  
  @URISpanHandlerSet.a
  class SettingBindEmailUriSpanHandler
    extends URISpanHandlerSet.BaseUriSpanHandler
  {
    SettingBindEmailUriSpanHandler()
    {
      super();
      GMTrace.i(13020864446464L, 97013);
      GMTrace.o(13020864446464L, 97013);
    }
    
    final boolean a(i parami, com.tencent.mm.pluginsdk.ui.d.e parame)
    {
      GMTrace.i(13021267099648L, 97016);
      if (parami.type == 7)
      {
        if (parame != null) {
          parame.a(parami);
        }
        parami = LauncherUI.bPy();
        if (parami != null) {
          parami.uPX.SC("tab_settings");
        }
        GMTrace.o(13021267099648L, 97016);
        return true;
      }
      GMTrace.o(13021267099648L, 97016);
      return false;
    }
    
    final boolean a(String paramString, boolean paramBoolean, com.tencent.mm.pluginsdk.o paramo, Bundle paramBundle)
    {
      GMTrace.i(13021401317376L, 97017);
      GMTrace.o(13021401317376L, 97017);
      return false;
    }
    
    final i bv(String paramString)
    {
      GMTrace.i(13020998664192L, 97014);
      if (paramString.trim().startsWith("weixin://setting/bindemail"))
      {
        paramString = new i(paramString, 7, null);
        GMTrace.o(13020998664192L, 97014);
        return paramString;
      }
      GMTrace.o(13020998664192L, 97014);
      return null;
    }
    
    final int[] oN()
    {
      GMTrace.i(13021132881920L, 97015);
      GMTrace.o(13021132881920L, 97015);
      return new int[] { 7 };
    }
  }
  
  @URISpanHandlerSet.a
  class SettingBlacklistUriSpanHandler
    extends URISpanHandlerSet.BaseUriSpanHandler
  {
    SettingBlacklistUriSpanHandler()
    {
      super();
      GMTrace.i(13018045874176L, 96992);
      GMTrace.o(13018045874176L, 96992);
    }
    
    final boolean a(i parami, com.tencent.mm.pluginsdk.ui.d.e parame)
    {
      GMTrace.i(13018448527360L, 96995);
      if (parami.type == 14)
      {
        if (parame != null) {
          parame.a(parami);
        }
        parame = com.tencent.mm.u.t.fT(URISpanHandlerSet.this.mContext.getString(R.l.eqx));
        parami = new Intent();
        parami.setClass(URISpanHandlerSet.this.mContext, SelectContactUI.class);
        parami.putExtra("Contact_GroupFilter_Type", parame.getType());
        parami.putExtra("Contact_GroupFilter_DisplayName", parame.tK());
        parami.addFlags(67108864);
        parame = LauncherUI.bPy();
        if (parame != null) {
          parame.uPX.SC("tab_settings");
        }
        URISpanHandlerSet.this.mContext.startActivity(parami);
        GMTrace.o(13018448527360L, 96995);
        return true;
      }
      GMTrace.o(13018448527360L, 96995);
      return false;
    }
    
    final boolean a(String paramString, boolean paramBoolean, com.tencent.mm.pluginsdk.o paramo, Bundle paramBundle)
    {
      GMTrace.i(13018582745088L, 96996);
      if (paramString.equals("weixin://setting/blacklist"))
      {
        paramo = com.tencent.mm.u.t.fT(URISpanHandlerSet.this.mContext.getString(R.l.eqx));
        paramString = new Intent();
        paramString.setClass(URISpanHandlerSet.this.mContext, AddressUI.class);
        paramString.putExtra("Contact_GroupFilter_Type", paramo.getType());
        paramString.putExtra("Contact_GroupFilter_DisplayName", paramo.tK());
        paramString.addFlags(67108864);
        if ((URISpanHandlerSet.this.mContext instanceof Service)) {
          paramString.addFlags(268435456);
        }
        paramo = LauncherUI.bPy();
        if (paramo != null) {
          paramo.uPX.SC("tab_settings");
        }
        URISpanHandlerSet.this.mContext.startActivity(paramString);
        GMTrace.o(13018582745088L, 96996);
        return true;
      }
      GMTrace.o(13018582745088L, 96996);
      return false;
    }
    
    final i bv(String paramString)
    {
      GMTrace.i(13018180091904L, 96993);
      if (paramString.trim().startsWith("weixin://setting/blacklist"))
      {
        paramString = new i(paramString, 14, null);
        GMTrace.o(13018180091904L, 96993);
        return paramString;
      }
      GMTrace.o(13018180091904L, 96993);
      return null;
    }
    
    final int[] oN()
    {
      GMTrace.i(13018314309632L, 96994);
      GMTrace.o(13018314309632L, 96994);
      return new int[] { 14 };
    }
  }
  
  @URISpanHandlerSet.a
  class SettingHeadImgUriSpanHandler
    extends URISpanHandlerSet.BaseUriSpanHandler
  {
    SettingHeadImgUriSpanHandler()
    {
      super();
      GMTrace.i(13018716962816L, 96997);
      GMTrace.o(13018716962816L, 96997);
    }
    
    final boolean a(i parami, com.tencent.mm.pluginsdk.ui.d.e parame)
    {
      GMTrace.i(13019119616000L, 97000);
      if (parami.type == 6)
      {
        if (parame != null) {
          parame.a(parami);
        }
        parami = LauncherUI.bPy();
        if (parami != null) {
          parami.uPX.SC("tab_settings");
        }
        GMTrace.o(13019119616000L, 97000);
        return true;
      }
      GMTrace.o(13019119616000L, 97000);
      return false;
    }
    
    final boolean a(String paramString, boolean paramBoolean, com.tencent.mm.pluginsdk.o paramo, Bundle paramBundle)
    {
      GMTrace.i(13019253833728L, 97001);
      if (paramString.equals("weixin://setting/setheadimage"))
      {
        paramString = new Intent();
        paramString.putExtra("Contact_User", com.tencent.mm.u.m.xL());
        paramString.putExtra("Contact_Nick", com.tencent.mm.u.m.xN());
        paramString.putExtra("User_Avatar", true);
        if ((URISpanHandlerSet.this.mContext instanceof Service)) {
          paramString.addFlags(268435456);
        }
        com.tencent.mm.bb.d.b(URISpanHandlerSet.this.mContext, "profile", ".ui.ContactInfoUI", paramString);
        GMTrace.o(13019253833728L, 97001);
        return true;
      }
      GMTrace.o(13019253833728L, 97001);
      return false;
    }
    
    final i bv(String paramString)
    {
      GMTrace.i(13018851180544L, 96998);
      if (paramString.trim().startsWith("weixin://setting/setheadimage"))
      {
        paramString = new i(paramString, 6, null);
        GMTrace.o(13018851180544L, 96998);
        return paramString;
      }
      GMTrace.o(13018851180544L, 96998);
      return null;
    }
    
    final int[] oN()
    {
      GMTrace.i(13018985398272L, 96999);
      GMTrace.o(13018985398272L, 96999);
      return new int[] { 6 };
    }
  }
  
  @URISpanHandlerSet.a
  class SettingNotifyUriSpanHandler
    extends URISpanHandlerSet.BaseUriSpanHandler
  {
    SettingNotifyUriSpanHandler()
    {
      super();
      GMTrace.i(13029320163328L, 97076);
      GMTrace.o(13029320163328L, 97076);
    }
    
    final boolean a(i parami, com.tencent.mm.pluginsdk.ui.d.e parame)
    {
      GMTrace.i(13029722816512L, 97079);
      if (parami.type == 9)
      {
        if (parame != null) {
          parame.a(parami);
        }
        parami = LauncherUI.bPy();
        if (parami != null) {
          parami.uPX.SC("tab_settings");
        }
        com.tencent.mm.bb.d.w(URISpanHandlerSet.this.mContext, "setting", ".ui.setting.SettingsNotificationUI");
        GMTrace.o(13029722816512L, 97079);
        return true;
      }
      GMTrace.o(13029722816512L, 97079);
      return false;
    }
    
    final boolean a(String paramString, boolean paramBoolean, com.tencent.mm.pluginsdk.o paramo, Bundle paramBundle)
    {
      GMTrace.i(13029857034240L, 97080);
      if (paramString.equals("weixin://setting/notify"))
      {
        paramString = LauncherUI.bPy();
        if (paramString != null) {
          paramString.uPX.SC("tab_settings");
        }
        paramString = new Intent();
        paramString.addFlags(67108864);
        if ((URISpanHandlerSet.this.mContext instanceof Service)) {
          paramString.addFlags(268435456);
        }
        com.tencent.mm.bb.d.b(URISpanHandlerSet.this.mContext, "setting", ".ui.setting.SettingsNotificationUI", paramString);
        GMTrace.o(13029857034240L, 97080);
        return true;
      }
      GMTrace.o(13029857034240L, 97080);
      return false;
    }
    
    final i bv(String paramString)
    {
      GMTrace.i(13029454381056L, 97077);
      if (paramString.trim().startsWith("weixin://setting/notify"))
      {
        paramString = new i(paramString, 9, null);
        GMTrace.o(13029454381056L, 97077);
        return paramString;
      }
      GMTrace.o(13029454381056L, 97077);
      return null;
    }
    
    final int[] oN()
    {
      GMTrace.i(13029588598784L, 97078);
      GMTrace.o(13029588598784L, 97078);
      return new int[] { 9 };
    }
  }
  
  @URISpanHandlerSet.a
  class SettingPluginLomoUriSpanHandler
    extends URISpanHandlerSet.BaseUriSpanHandler
  {
    SettingPluginLomoUriSpanHandler()
    {
      super();
      GMTrace.i(13036836356096L, 97132);
      GMTrace.o(13036836356096L, 97132);
    }
    
    final boolean a(i parami, com.tencent.mm.pluginsdk.ui.d.e parame)
    {
      GMTrace.i(13037239009280L, 97135);
      if (parami.type == 12)
      {
        if (parame != null) {
          parame.a(parami);
        }
        parami = new Intent();
        parami.putExtra("Contact_User", "weibo");
        com.tencent.mm.bb.d.b(URISpanHandlerSet.this.mContext, "profile", ".ui.ContactInfoUI", parami);
        GMTrace.o(13037239009280L, 97135);
        return true;
      }
      GMTrace.o(13037239009280L, 97135);
      return false;
    }
    
    final boolean a(String paramString, boolean paramBoolean, com.tencent.mm.pluginsdk.o paramo, Bundle paramBundle)
    {
      GMTrace.i(13037373227008L, 97136);
      if (paramString.equals("weixin://setting/plugin/lomo"))
      {
        paramString = new Intent();
        paramString.putExtra("Contact_User", "weibo");
        if ((URISpanHandlerSet.this.mContext instanceof Service)) {
          paramString.addFlags(268435456);
        }
        com.tencent.mm.bb.d.b(URISpanHandlerSet.this.mContext, "profile", ".ui.ContactInfoUI", paramString);
        GMTrace.o(13037373227008L, 97136);
        return true;
      }
      GMTrace.o(13037373227008L, 97136);
      return false;
    }
    
    final i bv(String paramString)
    {
      GMTrace.i(13036970573824L, 97133);
      if (paramString.trim().startsWith("weixin://setting/plugin/lomo"))
      {
        paramString = new i(paramString, 12, null);
        GMTrace.o(13036970573824L, 97133);
        return paramString;
      }
      GMTrace.o(13036970573824L, 97133);
      return null;
    }
    
    final int[] oN()
    {
      GMTrace.i(13037104791552L, 97134);
      GMTrace.o(13037104791552L, 97134);
      return new int[] { 12 };
    }
  }
  
  @URISpanHandlerSet.a
  class SettingPluginQQMailUriSpanHandler
    extends URISpanHandlerSet.BaseUriSpanHandler
  {
    SettingPluginQQMailUriSpanHandler()
    {
      super();
      GMTrace.i(13021535535104L, 97018);
      GMTrace.o(13021535535104L, 97018);
    }
    
    final boolean a(i parami, com.tencent.mm.pluginsdk.ui.d.e parame)
    {
      GMTrace.i(13021938188288L, 97021);
      if (parami.type == 10)
      {
        if (parame != null) {
          parame.a(parami);
        }
        parami = new Intent();
        parami.putExtra("Contact_User", "qqmail");
        com.tencent.mm.bb.d.b(URISpanHandlerSet.this.mContext, "profile", ".ui.ContactInfoUI", parami);
        GMTrace.o(13021938188288L, 97021);
        return true;
      }
      GMTrace.o(13021938188288L, 97021);
      return false;
    }
    
    final boolean a(String paramString, boolean paramBoolean, com.tencent.mm.pluginsdk.o paramo, Bundle paramBundle)
    {
      GMTrace.i(13022072406016L, 97022);
      if (paramString.equals("weixin://setting/plugin/qqmail"))
      {
        paramString = new Intent();
        paramString.putExtra("Contact_User", "qqmail");
        if ((URISpanHandlerSet.this.mContext instanceof Service)) {
          paramString.addFlags(268435456);
        }
        com.tencent.mm.bb.d.b(URISpanHandlerSet.this.mContext, "profile", ".ui.ContactInfoUI", paramString);
        GMTrace.o(13022072406016L, 97022);
        return true;
      }
      GMTrace.o(13022072406016L, 97022);
      return false;
    }
    
    final i bv(String paramString)
    {
      GMTrace.i(13021669752832L, 97019);
      if (paramString.trim().startsWith("weixin://setting/plugin/qqmail"))
      {
        paramString = new i(paramString, 10, null);
        GMTrace.o(13021669752832L, 97019);
        return paramString;
      }
      GMTrace.o(13021669752832L, 97019);
      return null;
    }
    
    final int[] oN()
    {
      GMTrace.i(13021803970560L, 97020);
      GMTrace.o(13021803970560L, 97020);
      return new int[] { 10 };
    }
  }
  
  @URISpanHandlerSet.a
  class SettingPluginQQMsgUriSpanHandler
    extends URISpanHandlerSet.BaseUriSpanHandler
  {
    SettingPluginQQMsgUriSpanHandler()
    {
      super();
      GMTrace.i(13015898390528L, 96976);
      GMTrace.o(13015898390528L, 96976);
    }
    
    final boolean a(i parami, com.tencent.mm.pluginsdk.ui.d.e parame)
    {
      GMTrace.i(13016301043712L, 96979);
      GMTrace.o(13016301043712L, 96979);
      return false;
    }
    
    final boolean a(String paramString, boolean paramBoolean, com.tencent.mm.pluginsdk.o paramo, Bundle paramBundle)
    {
      GMTrace.i(13016435261440L, 96980);
      GMTrace.o(13016435261440L, 96980);
      return false;
    }
    
    final i bv(String paramString)
    {
      GMTrace.i(13016032608256L, 96977);
      if (paramString.trim().startsWith("weixin://setting/plugin/qqmsg"))
      {
        paramString = new i(paramString, 13, null);
        GMTrace.o(13016032608256L, 96977);
        return paramString;
      }
      GMTrace.o(13016032608256L, 96977);
      return null;
    }
    
    final int[] oN()
    {
      GMTrace.i(13016166825984L, 96978);
      GMTrace.o(13016166825984L, 96978);
      return new int[] { 13 };
    }
  }
  
  @URISpanHandlerSet.a
  class SettingPluginSxMsgUriSpanHandler
    extends URISpanHandlerSet.BaseUriSpanHandler
  {
    SettingPluginSxMsgUriSpanHandler()
    {
      super();
      GMTrace.i(13034152001536L, 97112);
      GMTrace.o(13034152001536L, 97112);
    }
    
    final boolean a(i parami, com.tencent.mm.pluginsdk.ui.d.e parame)
    {
      GMTrace.i(13034554654720L, 97115);
      GMTrace.o(13034554654720L, 97115);
      return false;
    }
    
    final boolean a(String paramString, boolean paramBoolean, com.tencent.mm.pluginsdk.o paramo, Bundle paramBundle)
    {
      GMTrace.i(13034688872448L, 97116);
      GMTrace.o(13034688872448L, 97116);
      return false;
    }
    
    final i bv(String paramString)
    {
      GMTrace.i(13034286219264L, 97113);
      if (paramString.trim().startsWith("weixin://setting/plugin/sxmsg"))
      {
        paramString = new i(paramString, 11, null);
        GMTrace.o(13034286219264L, 97113);
        return paramString;
      }
      GMTrace.o(13034286219264L, 97113);
      return null;
    }
    
    final int[] oN()
    {
      GMTrace.i(13034420436992L, 97114);
      GMTrace.o(13034420436992L, 97114);
      return new int[] { 11 };
    }
  }
  
  @URISpanHandlerSet.a
  class SettingPrivacyUriSpanHandler
    extends URISpanHandlerSet.BaseUriSpanHandler
  {
    SettingPrivacyUriSpanHandler()
    {
      super();
      GMTrace.i(13028649074688L, 97071);
      GMTrace.o(13028649074688L, 97071);
    }
    
    final boolean a(i parami, com.tencent.mm.pluginsdk.ui.d.e parame)
    {
      GMTrace.i(13029051727872L, 97074);
      if (parami.type == 15)
      {
        if (parame != null) {
          parame.a(parami);
        }
        parami = LauncherUI.bPy();
        if (parami != null) {
          parami.uPX.SC("tab_settings");
        }
        com.tencent.mm.bb.d.w(URISpanHandlerSet.this.mContext, "setting", ".ui.setting.SettingsPrivacyUI");
        GMTrace.o(13029051727872L, 97074);
        return true;
      }
      GMTrace.o(13029051727872L, 97074);
      return false;
    }
    
    final boolean a(String paramString, boolean paramBoolean, com.tencent.mm.pluginsdk.o paramo, Bundle paramBundle)
    {
      GMTrace.i(13029185945600L, 97075);
      if (paramString.equals("weixin://setting/privacy"))
      {
        paramString = LauncherUI.bPy();
        if (paramString != null) {
          paramString.uPX.SC("tab_settings");
        }
        paramString = new Intent();
        if ((URISpanHandlerSet.this.mContext instanceof Service)) {
          paramString.addFlags(268435456);
        }
        com.tencent.mm.bb.d.b(URISpanHandlerSet.this.mContext, "setting", ".ui.setting.SettingsPrivacyUI", paramString);
        GMTrace.o(13029185945600L, 97075);
        return true;
      }
      GMTrace.o(13029185945600L, 97075);
      return false;
    }
    
    final i bv(String paramString)
    {
      GMTrace.i(13028783292416L, 97072);
      if (paramString.trim().startsWith("weixin://setting/privacy"))
      {
        paramString = new i(paramString, 15, null);
        GMTrace.o(13028783292416L, 97072);
        return paramString;
      }
      GMTrace.o(13028783292416L, 97072);
      return null;
    }
    
    final int[] oN()
    {
      GMTrace.i(13028917510144L, 97073);
      GMTrace.o(13028917510144L, 97073);
      return new int[] { 15 };
    }
  }
  
  @URISpanHandlerSet.a
  class TransferUriSpanHandler
    extends URISpanHandlerSet.BaseUriSpanHandler
  {
    TransferUriSpanHandler()
    {
      super();
      GMTrace.i(16876402900992L, 125739);
      GMTrace.o(16876402900992L, 125739);
    }
    
    final boolean a(final i parami, com.tencent.mm.pluginsdk.ui.d.e parame)
    {
      GMTrace.i(16876805554176L, 125742);
      if (parami != null)
      {
        if (parami.type == 42)
        {
          com.tencent.mm.bb.d.w(URISpanHandlerSet.this.mContext, "wallet", ".balance.ui.lqt.WalletLqtDetailUI");
          GMTrace.o(16876805554176L, 125742);
          return true;
        }
        if (parami.type == 41)
        {
          com.tencent.mm.bb.d.w(URISpanHandlerSet.this.mContext, "wallet", ".balance.ui.WalletBalanceManagerUI");
          GMTrace.o(16876805554176L, 125742);
          return true;
        }
        if (parami.type == 39)
        {
          if ((parami.data != null) && ((parami.data instanceof Bundle)))
          {
            parami = (Bundle)parami.data;
            com.tencent.mm.ui.base.g.b(URISpanHandlerSet.this.mContext, URISpanHandlerSet.this.mContext.getString(R.l.eKp), URISpanHandlerSet.this.mContext.getString(R.l.dIk), URISpanHandlerSet.this.mContext.getString(R.l.eLl), URISpanHandlerSet.this.mContext.getString(R.l.dGk), new DialogInterface.OnClickListener()new DialogInterface.OnClickListener
            {
              public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
              {
                GMTrace.i(16877208207360L, 125745);
                paramAnonymousDialogInterface = parami.getString("transaction_id");
                String str = parami.getString("receiver_name");
                Intent localIntent = new Intent();
                localIntent.putExtra("transaction_id", paramAnonymousDialogInterface);
                localIntent.putExtra("receiver_name", str);
                com.tencent.mm.bb.d.b(aa.getContext(), "remittance", ".ui.RemittanceResendMsgUI", localIntent);
                GMTrace.o(16877208207360L, 125745);
              }
            }, new DialogInterface.OnClickListener()
            {
              public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
              {
                GMTrace.i(16876268683264L, 125738);
                GMTrace.o(16876268683264L, 125738);
              }
            });
          }
          GMTrace.o(16876805554176L, 125742);
          return true;
        }
        if (parami.type == 40)
        {
          if ((parami.data != null) && ((parami.data instanceof Bundle)))
          {
            parami = (Bundle)parami.data;
            parame = new mh();
            parame.fTp.fTq = parami.getString("transaction_id");
            parame.fTp.fSJ = parami.getString("transfer_id");
            parame.fTp.fTr = parami.getInt("total_fee");
            parame.fTp.fTs = parami.getString("sender_name");
            com.tencent.mm.sdk.b.a.uql.m(parame);
          }
          GMTrace.o(16876805554176L, 125742);
          return true;
        }
      }
      GMTrace.o(16876805554176L, 125742);
      return false;
    }
    
    final boolean a(String paramString, boolean paramBoolean, com.tencent.mm.pluginsdk.o paramo, Bundle paramBundle)
    {
      GMTrace.i(16876939771904L, 125743);
      GMTrace.o(16876939771904L, 125743);
      return false;
    }
    
    final i bv(String paramString)
    {
      GMTrace.i(16876537118720L, 125740);
      if (paramString.trim().toLowerCase().startsWith("weixin://wcpay/transfer/retrysendmsg"))
      {
        paramString = new i(paramString, 39, null);
        GMTrace.o(16876537118720L, 125740);
        return paramString;
      }
      if (paramString.trim().toLowerCase().startsWith("weixin://wcpay/transfer/rebacksendmsg"))
      {
        paramString = new i(paramString, 40, null);
        GMTrace.o(16876537118720L, 125740);
        return paramString;
      }
      if (paramString.trim().toLowerCase().startsWith("weixin://wcpay/transfer/watchbalance"))
      {
        paramString = new i(paramString, 41, null);
        GMTrace.o(16876537118720L, 125740);
        return paramString;
      }
      if (paramString.trim().toLowerCase().startsWith("weixin://wcpay/transfer/watchlqt"))
      {
        paramString = new i(paramString, 42, null);
        GMTrace.o(16876537118720L, 125740);
        return paramString;
      }
      GMTrace.o(16876537118720L, 125740);
      return null;
    }
    
    final int[] oN()
    {
      GMTrace.i(16876671336448L, 125741);
      GMTrace.o(16876671336448L, 125741);
      return new int[] { 39, 40, 41, 42 };
    }
  }
  
  @URISpanHandlerSet.a
  class VerifyContactUriSpanHandler
    extends URISpanHandlerSet.BaseUriSpanHandler
  {
    VerifyContactUriSpanHandler()
    {
      super();
      GMTrace.i(13038849622016L, 97147);
      GMTrace.o(13038849622016L, 97147);
    }
    
    final boolean a(i parami, com.tencent.mm.pluginsdk.ui.d.e parame)
    {
      GMTrace.i(13039252275200L, 97150);
      if (parami.type == 4)
      {
        if (parame != null) {
          parame.a(parami);
        }
        GMTrace.o(13039252275200L, 97150);
        return true;
      }
      GMTrace.o(13039252275200L, 97150);
      return false;
    }
    
    final boolean a(String paramString, boolean paramBoolean, com.tencent.mm.pluginsdk.o paramo, Bundle paramBundle)
    {
      GMTrace.i(13039386492928L, 97151);
      GMTrace.o(13039386492928L, 97151);
      return false;
    }
    
    final i bv(String paramString)
    {
      GMTrace.i(13038983839744L, 97148);
      if (paramString.trim().startsWith("weixin://findfriend/verifycontact"))
      {
        paramString = new i(paramString, 4, null);
        GMTrace.o(13038983839744L, 97148);
        return paramString;
      }
      GMTrace.o(13038983839744L, 97148);
      return null;
    }
    
    final int[] oN()
    {
      GMTrace.i(13039118057472L, 97149);
      GMTrace.o(13039118057472L, 97149);
      return new int[] { 4 };
    }
  }
  
  @URISpanHandlerSet.a
  class VoipCallAgainUrilSpanHandler
    extends URISpanHandlerSet.BaseUriSpanHandler
  {
    VoipCallAgainUrilSpanHandler()
    {
      super();
      GMTrace.i(13023548801024L, 97033);
      GMTrace.o(13023548801024L, 97033);
    }
    
    final boolean a(i parami, com.tencent.mm.pluginsdk.ui.d.e parame)
    {
      GMTrace.i(13023951454208L, 97036);
      if (parami.type == 38)
      {
        parame = Uri.parse(parami.url);
        parami = parame.getQueryParameter("username");
        parame = parame.getQueryParameter("isvideocall");
        rr localrr = new rr();
        localrr.fYy.fJB = 5;
        localrr.fYy.fJC = parami;
        localrr.fYy.context = URISpanHandlerSet.this.mContext;
        if ((parami != null) && (!parami.equals("")))
        {
          if ((parame != null) && (parame.equals("true"))) {}
          for (localrr.fYy.fYt = 2;; localrr.fYy.fYt = 4)
          {
            com.tencent.mm.sdk.b.a.uql.m(localrr);
            GMTrace.o(13023951454208L, 97036);
            return true;
          }
        }
      }
      GMTrace.o(13023951454208L, 97036);
      return false;
    }
    
    final boolean a(String paramString, boolean paramBoolean, com.tencent.mm.pluginsdk.o paramo, Bundle paramBundle)
    {
      GMTrace.i(13024085671936L, 97037);
      GMTrace.o(13024085671936L, 97037);
      return false;
    }
    
    final i bv(String paramString)
    {
      GMTrace.i(13023683018752L, 97034);
      if (paramString.trim().startsWith("weixin://voip/callagain/"))
      {
        paramString = new i(paramString, 38, null);
        GMTrace.o(13023683018752L, 97034);
        return paramString;
      }
      GMTrace.o(13023683018752L, 97034);
      return null;
    }
    
    final int[] oN()
    {
      GMTrace.i(13023817236480L, 97035);
      GMTrace.o(13023817236480L, 97035);
      return new int[] { 38 };
    }
  }
  
  @Retention(RetentionPolicy.RUNTIME)
  @Target({java.lang.annotation.ElementType.TYPE})
  static @interface a
  {
    URISpanHandlerSet.PRIORITY oO() default URISpanHandlerSet.PRIORITY.NORMAL;
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/app/plugin/URISpanHandlerSet.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */