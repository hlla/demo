package com.tencent.mm.pluginsdk.ui.tools;

import com.tencent.gmtrace.GMTrace;
import com.tencent.mm.a.o;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bf;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.storage.t;
import com.tencent.mm.storage.w.a;
import com.tencent.mm.u.ap;
import com.tencent.mm.u.c;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Map;

public final class i
{
  public static void a(a parama)
  {
    GMTrace.i(1130515922944L, 8423);
    ap.vL().D(new Runnable()
    {
      public final void run()
      {
        GMTrace.i(1125952520192L, 8389);
        HttpURLConnection localHttpURLConnection;
        try
        {
          i.a locala = this.sUU;
          v.i("MicroMsg.QQMailUnreadHelper", "dz[getUnreadCount]");
          ap.yY();
          localObject = (String)c.vr().get(-1535680990, "");
          ap.yY();
          long l = new o(bf.f((Integer)c.vr().get(9, null))).longValue();
          if ((bf.mA((String)localObject)) || (l == 0L))
          {
            ap.yY();
            c.vr().a(w.a.uyG, Integer.valueOf(-1));
            v.w("MicroMsg.QQMailUnreadHelper", "dz[getUnreadEmailCountAndSet: authkey or uin is null]");
            ae.v(new i.2(locala));
            GMTrace.o(1125952520192L, 8389);
            return;
          }
          localHttpURLConnection = (HttpURLConnection)new URL("https://qqmail.weixin.qq.com/cgi-bin/getunreadmailcount?f=xml&appname=qqmail_weixin&charset=utf-8&clientip=0").openConnection();
          localHttpURLConnection.setConnectTimeout(15000);
          localHttpURLConnection.setReadTimeout(20000);
          localHttpURLConnection.setRequestProperty("Cookie", String.format("skey=%s;uin=o%d;", new Object[] { localObject, Long.valueOf(l) }));
          if (localHttpURLConnection.getResponseCode() >= 300)
          {
            localHttpURLConnection.disconnect();
            v.w("MicroMsg.QQMailUnreadHelper", "dz[getUnreadCount http 300]");
            ae.v(new i.3(locala));
            GMTrace.o(1125952520192L, 8389);
            return;
          }
        }
        catch (Exception localException)
        {
          v.printErrStackTrace("MicroMsg.QQMailUnreadHelper", localException, "", new Object[0]);
          v.e("MicroMsg.QQMailUnreadHelper", "getUnreadCountAsync exception");
          GMTrace.o(1125952520192L, 8389);
          return;
        }
        Object localObject = bg.q(bf.convertStreamToString(localHttpURLConnection.getInputStream()), "Response");
        if ((localObject != null) && (bf.getInt((String)((Map)localObject).get(".Response.error.code"), -1) == 0)) {}
        for (int i = bf.getInt((String)((Map)localObject).get(".Response.result.UnreadCount"), -1);; i = -1)
        {
          if (i < 0)
          {
            ae.v(new i.4(localException));
            GMTrace.o(1125952520192L, 8389);
            return;
          }
          ap.yY();
          c.vr().a(w.a.uyG, Integer.valueOf(i));
          ae.v(new i.5(localException, i));
          GMTrace.o(1125952520192L, 8389);
          return;
        }
      }
    });
    GMTrace.o(1130515922944L, 8423);
  }
  
  public static abstract interface a
  {
    public abstract void aUx();
    
    public abstract void rz(int paramInt);
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/pluginsdk/ui/tools/i.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */