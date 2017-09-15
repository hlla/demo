package com.tencent.mm.ui.chatting;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import com.tencent.gmtrace.GMTrace;
import com.tencent.mm.bk.a;
import com.tencent.mm.opensdk.modelmsg.ShowMessageFromWX.Req;
import com.tencent.mm.opensdk.modelmsg.ShowMessageFromWX.Resp;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.pluginsdk.model.app.g;
import com.tencent.mm.pluginsdk.model.app.g.c;
import com.tencent.mm.sdk.e.k;
import com.tencent.mm.sdk.platformtools.v;
import java.util.HashMap;
import java.util.Map;

public final class eu
  implements do
{
  private static k<do, Bundle> vNp;
  public Context context;
  public final Map<String, ShowMessageFromWX.Req> vNs;
  
  static
  {
    GMTrace.i(2254186741760L, 16795);
    vNp = new k() {};
    GMTrace.o(2254186741760L, 16795);
  }
  
  public eu(Context paramContext)
  {
    GMTrace.i(2253515653120L, 16790);
    this.vNs = new HashMap();
    this.context = paramContext;
    GMTrace.o(2253515653120L, 16790);
  }
  
  public static void ad(Bundle paramBundle)
  {
    GMTrace.i(2253649870848L, 16791);
    vNp.by(paramBundle);
    vNp.doNotify();
    GMTrace.o(2253649870848L, 16791);
  }
  
  public final void a(final String paramString1, final WXMediaMessage paramWXMediaMessage, final String paramString2, final String paramString3)
  {
    GMTrace.i(2253918306304L, 16793);
    v.d("MicroMsg.WXAppMessageShower", "request pkg = %s, openId = %s", new Object[] { paramString1, paramString3 });
    a.post(new Runnable()
    {
      public final void run()
      {
        GMTrace.i(17908537229312L, 133429);
        final ShowMessageFromWX.Req localReq = g.c(eu.this.context, paramWXMediaMessage, paramString3);
        g.a(eu.this.context, paramString1, paramString2, localReq, 0, new g.c()
        {
          public final void ev(boolean paramAnonymous2Boolean)
          {
            GMTrace.i(17906523963392L, 133414);
            if (paramAnonymous2Boolean) {
              eu.this.vNs.put(localReq.transaction, localReq);
            }
            GMTrace.o(17906523963392L, 133414);
          }
        }, null);
        GMTrace.o(17908537229312L, 133429);
      }
    });
    GMTrace.o(2253918306304L, 16793);
  }
  
  public final void ac(Bundle paramBundle)
  {
    GMTrace.i(2253784088576L, 16792);
    String str = Uri.parse(paramBundle.getString("_mmessage_content")).getQueryParameter("appid");
    v.d("MicroMsg.WXAppMessageShower", "handleResp, appid = " + str);
    paramBundle = new ShowMessageFromWX.Resp(paramBundle);
    v.i("MicroMsg.WXAppMessageShower", "handleResp, errCode = " + paramBundle.errCode + ", type = " + paramBundle.getType());
    if ((ShowMessageFromWX.Req)this.vNs.get(paramBundle.transaction) == null)
    {
      v.e("MicroMsg.WXAppMessageShower", "invalid resp, check transaction failed, transaction=" + paramBundle.transaction);
      GMTrace.o(2253784088576L, 16792);
      return;
    }
    this.vNs.remove(paramBundle.transaction);
    GMTrace.o(2253784088576L, 16792);
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/ui/chatting/eu.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */