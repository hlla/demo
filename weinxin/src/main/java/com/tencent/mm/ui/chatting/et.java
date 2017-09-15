package com.tencent.mm.ui.chatting;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.net.Uri;
import android.os.Build.VERSION;
import android.os.Bundle;
import com.tencent.gmtrace.GMTrace;
import com.tencent.mm.R.k;
import com.tencent.mm.R.l;
import com.tencent.mm.kernel.h;
import com.tencent.mm.opensdk.channel.MMessageActV2;
import com.tencent.mm.opensdk.channel.MMessageActV2.Args;
import com.tencent.mm.opensdk.modelmsg.GetMessageFromWX.Req;
import com.tencent.mm.opensdk.modelmsg.GetMessageFromWX.Resp;
import com.tencent.mm.opensdk.modelmsg.WXImageObject;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.pluginsdk.model.app.an;
import com.tencent.mm.pluginsdk.model.app.f;
import com.tencent.mm.pluginsdk.model.app.i;
import com.tencent.mm.pluginsdk.model.app.p;
import com.tencent.mm.pluginsdk.ui.applet.k.a;
import com.tencent.mm.sdk.e.k;
import com.tencent.mm.sdk.platformtools.aa;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.storage.t;
import com.tencent.mm.u.ap;
import com.tencent.mm.u.bm;
import com.tencent.mm.ui.q;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public final class et
  implements do
{
  static k<do, Bundle> vNp;
  public En_5b8fbb1e.a vAn;
  final Set<String> vNo;
  
  static
  {
    GMTrace.i(2184930394112L, 16279);
    vNp = new k() {};
    GMTrace.o(2184930394112L, 16279);
  }
  
  protected et(En_5b8fbb1e.a parama)
  {
    GMTrace.i(2183856652288L, 16271);
    this.vNo = new HashSet();
    this.vAn = parama;
    GMTrace.o(2183856652288L, 16271);
  }
  
  private k.a a(final WXMediaMessage paramWXMediaMessage, final f paramf)
  {
    GMTrace.i(17916724510720L, 133490);
    paramWXMediaMessage = new k.a()
    {
      public final void a(boolean paramAnonymousBoolean, String paramAnonymousString, int paramAnonymousInt)
      {
        GMTrace.i(2186943660032L, 16294);
        if (paramAnonymousBoolean)
        {
          paramAnonymousString = null;
          if (paramWXMediaMessage.getType() == 8)
          {
            if (paramWXMediaMessage.thumbData == null)
            {
              v.e("MicroMsg.WXAppMessageReceiver", "code should not reach here due to WXMediaMessage::checkArgs, sendEmoji Fail cause thumbData is null");
              GMTrace.o(2186943660032L, 16294);
              return;
            }
            String str = ((com.tencent.mm.plugin.emoji.b.c)h.j(com.tencent.mm.plugin.emoji.b.c.class)).getEmojiMgr().a(et.this.vAn.uRf.uRz, paramWXMediaMessage, paramf.field_appId);
            paramAnonymousString = str;
            if (str == null)
            {
              v.v("MicroMsg.WXAppMessageReceiver", "sendEmoji Fail cause emojiconmd5 is null");
              GMTrace.o(2186943660032L, 16294);
              return;
            }
          }
          bm.zN().c(27, new Object[] { Integer.valueOf(1) });
          v.v("MicroMsg.WXAppMessageReceiver", "onDialogClick, messageAction = %s, messageExt = %s", new Object[] { paramWXMediaMessage.messageAction, paramWXMediaMessage.messageExt });
          com.tencent.mm.pluginsdk.model.app.l.a(paramWXMediaMessage, paramf.field_appId, paramf.field_appName, et.this.vAn.bTW(), 1, paramAnonymousString);
        }
        GMTrace.o(2186943660032L, 16294);
      }
    };
    GMTrace.o(17916724510720L, 133490);
    return paramWXMediaMessage;
  }
  
  @TargetApi(9)
  static void a(Context paramContext, Set<String> paramSet)
  {
    GMTrace.i(2184661958656L, 16277);
    Object localObject2 = null;
    Object localObject1 = localObject2;
    if (paramSet != null)
    {
      localObject1 = localObject2;
      if (paramSet.size() > 0)
      {
        localObject1 = new StringBuilder();
        paramSet = paramSet.iterator();
        while (paramSet.hasNext())
        {
          ((StringBuilder)localObject1).append((String)paramSet.next());
          ((StringBuilder)localObject1).append(";");
        }
        localObject1 = ((StringBuilder)localObject1).toString();
      }
    }
    paramContext = paramContext.getSharedPreferences(aa.bIQ(), 0).edit();
    paramContext.putString("transactions_array_key", (String)localObject1);
    if (Build.VERSION.SDK_INT > 8)
    {
      paramContext.apply();
      GMTrace.o(2184661958656L, 16277);
      return;
    }
    paramContext.commit();
    GMTrace.o(2184661958656L, 16277);
  }
  
  public static void ad(Bundle paramBundle)
  {
    GMTrace.i(2183990870016L, 16272);
    vNp.by(paramBundle);
    vNp.doNotify();
    GMTrace.o(2183990870016L, 16272);
  }
  
  private String o(f paramf)
  {
    GMTrace.i(2184393523200L, 16275);
    paramf = this.vAn.getString(R.l.dXf, new Object[] { com.tencent.mm.pluginsdk.model.app.g.a(this.vAn.uRf.uRz, paramf, null) });
    GMTrace.o(2184393523200L, 16275);
    return paramf;
  }
  
  public final void ac(Bundle paramBundle)
  {
    int j = 1;
    int m = 0;
    int k = 0;
    GMTrace.i(2184125087744L, 16273);
    if (this.vAn.bVq())
    {
      v.v("MicroMsg.WXAppMessageReceiver", "handleResp Chatting is a fragment but not foregound");
      GMTrace.o(2184125087744L, 16273);
      return;
    }
    Object localObject2 = Uri.parse(paramBundle.getString("_mmessage_content")).getQueryParameter("appid");
    Object localObject1 = new GetMessageFromWX.Resp(paramBundle);
    paramBundle = ((GetMessageFromWX.Resp)localObject1).message;
    Object localObject4;
    Object localObject3;
    if (this.vNo.size() == 0)
    {
      localObject4 = this.vAn.uRf.uRz;
      localObject3 = new HashSet();
      localObject4 = ((Context)localObject4).getSharedPreferences(aa.bIQ(), 0).getString("transactions_array_key", null);
      if ((localObject4 != null) && (((String)localObject4).length() > 0))
      {
        localObject4 = ((String)localObject4).split(";");
        int n = localObject4.length;
        i = 0;
        while (i < n)
        {
          ((Set)localObject3).add(localObject4[i]);
          i += 1;
        }
      }
      this.vNo.addAll((Collection)localObject3);
    }
    if (!this.vNo.contains(((GetMessageFromWX.Resp)localObject1).transaction))
    {
      v.e("MicroMsg.WXAppMessageReceiver", "invalid resp, check transaction failed, transaction=" + ((GetMessageFromWX.Resp)localObject1).transaction);
      GMTrace.o(2184125087744L, 16273);
      return;
    }
    this.vNo.remove(((GetMessageFromWX.Resp)localObject1).transaction);
    a(this.vAn.uRf.uRz, this.vNo);
    localObject1 = new f();
    ((f)localObject1).field_appId = ((String)localObject2);
    v.d("MicroMsg.WXAppMessageReceiver", "handleResp, appId = " + (String)localObject2);
    if (!an.aRk().b((com.tencent.mm.sdk.e.c)localObject1, new String[0]))
    {
      v.e("MicroMsg.WXAppMessageReceiver", "unregistered app, ignore request, appId = " + (String)localObject2);
      GMTrace.o(2184125087744L, 16273);
      return;
    }
    int i = paramBundle.getType();
    switch (i)
    {
    case 6: 
    default: 
      v.e("MicroMsg.WXAppMessageReceiver", "unknown type = " + i);
      i = 0;
    case 1: 
    case 2: 
    case 3: 
    case 4: 
    case 5: 
      for (;;)
      {
        if (i == 0) {
          v.e("MicroMsg.WXAppMessageReceiver", "deal fail, result is false");
        }
        GMTrace.o(2184125087744L, 16273);
        return;
        localObject2 = this.vAn.uRf;
        localObject3 = paramBundle.description;
        o((f)localObject1);
        i = k;
        if (com.tencent.mm.pluginsdk.ui.applet.d.a((com.tencent.mm.ui.l)localObject2, (String)localObject3, false, a(paramBundle, (f)localObject1)) != null) {
          i = 1;
        }
        continue;
        if ((paramBundle.thumbData != null) && (paramBundle.thumbData.length > 0))
        {
          localObject2 = this.vAn.uRf;
          localObject3 = paramBundle.thumbData;
          o((f)localObject1);
          paramBundle = com.tencent.mm.pluginsdk.ui.applet.d.a((com.tencent.mm.ui.l)localObject2, (byte[])localObject3, false, a(paramBundle, (f)localObject1));
          if (paramBundle != null) {
            break label691;
          }
          v.e("MicroMsg.WXAppMessageReceiver", "showDialogItem3 fail, invalid argument");
        }
        for (i = m;; i = 1)
        {
          break;
          localObject2 = (WXImageObject)paramBundle.mediaObject;
          if ((((WXImageObject)localObject2).imageData != null) && (((WXImageObject)localObject2).imageData.length > 0))
          {
            localObject3 = this.vAn.uRf;
            localObject2 = ((WXImageObject)localObject2).imageData;
            o((f)localObject1);
            paramBundle = com.tencent.mm.pluginsdk.ui.applet.d.a((com.tencent.mm.ui.l)localObject3, (byte[])localObject2, false, a(paramBundle, (f)localObject1));
            break label563;
          }
          localObject3 = this.vAn.uRf;
          localObject2 = ((WXImageObject)localObject2).imagePath;
          o((f)localObject1);
          paramBundle = com.tencent.mm.pluginsdk.ui.applet.d.b((com.tencent.mm.ui.l)localObject3, (String)localObject2, false, a(paramBundle, (f)localObject1));
          break label563;
        }
        if ((paramBundle.thumbData != null) && (paramBundle.thumbData.length > 0))
        {
          localObject2 = this.vAn.uRf;
          localObject3 = paramBundle.title;
          o((f)localObject1);
        }
        for (paramBundle = com.tencent.mm.pluginsdk.ui.applet.d.a((com.tencent.mm.ui.l)localObject2, (String)localObject3, false, 2, a(paramBundle, (f)localObject1));; paramBundle = com.tencent.mm.pluginsdk.ui.applet.d.a((com.tencent.mm.ui.l)localObject2, i, (String)localObject3, false, a(paramBundle, (f)localObject1)))
        {
          i = j;
          if (paramBundle != null) {
            break;
          }
          i = 0;
          break;
          localObject2 = this.vAn.uRf;
          i = R.k.dsW;
          localObject3 = paramBundle.title;
          o((f)localObject1);
        }
        if ((paramBundle.thumbData != null) && (paramBundle.thumbData.length > 0))
        {
          localObject2 = this.vAn.uRf;
          localObject3 = paramBundle.title;
          o((f)localObject1);
        }
        for (paramBundle = com.tencent.mm.pluginsdk.ui.applet.d.a((com.tencent.mm.ui.l)localObject2, (String)localObject3, false, 1, a(paramBundle, (f)localObject1));; paramBundle = com.tencent.mm.pluginsdk.ui.applet.d.a((com.tencent.mm.ui.l)localObject2, i, (String)localObject3, false, a(paramBundle, (f)localObject1)))
        {
          i = j;
          if (paramBundle != null) {
            break;
          }
          i = 0;
          break;
          localObject2 = this.vAn.uRf;
          i = R.k.dth;
          localObject3 = paramBundle.title;
          o((f)localObject1);
        }
        localObject2 = this.vAn.uRf;
        localObject3 = paramBundle.title;
        localObject4 = paramBundle.description;
        o((f)localObject1);
        i = j;
        if (com.tencent.mm.pluginsdk.ui.applet.d.a((com.tencent.mm.ui.l)localObject2, (String)localObject3, (String)localObject4, false, "", a(paramBundle, (f)localObject1)) == null) {
          i = 0;
        }
      }
    case 7: 
      label563:
      label691:
      if ((paramBundle.thumbData != null) && (paramBundle.thumbData.length > 0))
      {
        localObject2 = this.vAn.uRf;
        localObject3 = paramBundle.title;
        o((f)localObject1);
      }
      for (paramBundle = com.tencent.mm.pluginsdk.ui.applet.d.a((com.tencent.mm.ui.l)localObject2, (String)localObject3, false, 0, a(paramBundle, (f)localObject1));; paramBundle = com.tencent.mm.pluginsdk.ui.applet.d.a((com.tencent.mm.ui.l)localObject2, i, (String)localObject3, false, a(paramBundle, (f)localObject1)))
      {
        i = j;
        if (paramBundle != null) {
          break;
        }
        i = 0;
        break;
        localObject2 = this.vAn.uRf;
        i = R.k.dtk;
        localObject3 = paramBundle.title;
        o((f)localObject1);
      }
    }
    if ((paramBundle.thumbData != null) && (paramBundle.thumbData.length > 0))
    {
      localObject2 = this.vAn.uRf;
      localObject3 = paramBundle.thumbData;
      o((f)localObject1);
    }
    for (paramBundle = com.tencent.mm.pluginsdk.ui.applet.d.a((com.tencent.mm.ui.l)localObject2, (byte[])localObject3, false, a(paramBundle, (f)localObject1));; paramBundle = com.tencent.mm.pluginsdk.ui.applet.d.a((com.tencent.mm.ui.l)localObject2, i, (String)localObject3, false, a(paramBundle, (f)localObject1)))
    {
      i = j;
      if (paramBundle != null) {
        break;
      }
      i = 0;
      break;
      localObject2 = this.vAn.uRf;
      i = R.k.dtk;
      localObject3 = paramBundle.title;
      o((f)localObject1);
    }
  }
  
  public final boolean eT(String paramString1, String paramString2)
  {
    GMTrace.i(2184259305472L, 16274);
    v.d("MicroMsg.WXAppMessageReceiver", "request, pkg = " + paramString1 + ", openId = " + paramString2);
    GetMessageFromWX.Req localReq = new GetMessageFromWX.Req();
    localReq.username = this.vAn.bTW();
    localReq.transaction = com.tencent.mm.a.g.n(com.tencent.mm.platformtools.u.NA().getBytes());
    localReq.openId = paramString2;
    paramString2 = this.vAn.SA(aa.bIN());
    Object localObject = this.vAn.uRf.uRz;
    localReq.lang = com.tencent.mm.sdk.platformtools.u.d(paramString2);
    ap.yY();
    localReq.country = ((String)com.tencent.mm.u.c.vr().get(274436, null));
    paramString2 = new Bundle();
    localReq.toBundle(paramString2);
    p.aa(paramString2);
    p.ab(paramString2);
    localObject = new MMessageActV2.Args();
    ((MMessageActV2.Args)localObject).targetPkgName = paramString1;
    ((MMessageActV2.Args)localObject).bundle = paramString2;
    boolean bool = MMessageActV2.send(this.vAn.uRf.uRz, (MMessageActV2.Args)localObject);
    this.vNo.add(localReq.transaction);
    a(this.vAn.uRf.uRz, this.vNo);
    GMTrace.o(2184259305472L, 16274);
    return bool;
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/ui/chatting/et.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */