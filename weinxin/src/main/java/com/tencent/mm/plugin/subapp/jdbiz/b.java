package com.tencent.mm.plugin.subapp.jdbiz;

import com.tencent.gmtrace.GMTrace;
import com.tencent.mm.pluginsdk.l.e;
import com.tencent.mm.sdk.platformtools.bf;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.storage.t;
import com.tencent.mm.u.ap;
import com.tencent.mm.u.c;
import java.util.Map;

public final class b
  implements l.e
{
  public String fSi;
  public long hUP;
  public String iconUrl;
  public String jumpUrl;
  public String qQV;
  public String qQW;
  public boolean qQX;
  public boolean qQY;
  public String qQZ;
  public String qRa;
  public long qRb;
  public long qRc;
  public long qRd;
  public long qRe;
  public String qRf;
  public String qRg;
  public String qRh;
  public String qRi;
  public long startTime;
  public String title;
  
  public b()
  {
    GMTrace.i(5852564029440L, 43605);
    this.qQV = "";
    this.qQW = "";
    this.hUP = 0L;
    this.title = "";
    this.iconUrl = "";
    this.qQX = false;
    this.qQY = false;
    this.qQZ = "";
    this.qRa = "";
    this.qRf = "";
    this.qRg = "";
    this.qRh = "";
    this.qRi = "";
    this.jumpUrl = "";
    this.fSi = "";
    GMTrace.o(5852564029440L, 43605);
  }
  
  public static b bmw()
  {
    GMTrace.i(5852698247168L, 43606);
    ap.yY();
    String str = (String)c.vr().get(327942, "");
    b localb = new b();
    v.i("MicroMsg.JdMsgContent", " create xml : " + str);
    localb.FS(str);
    GMTrace.o(5852698247168L, 43606);
    return localb;
  }
  
  public final void FS(String paramString)
  {
    GMTrace.i(5852832464896L, 43607);
    this.qQV = "";
    this.qQW = "";
    this.hUP = 0L;
    this.qQZ = "";
    this.qQX = false;
    this.qQY = false;
    this.qRg = "";
    this.qRh = "";
    this.qRi = "";
    this.qRf = "";
    this.jumpUrl = "";
    this.fSi = "";
    this.fSi = paramString;
    if (bf.mA(paramString))
    {
      GMTrace.o(5852832464896L, 43607);
      return;
    }
    v.i("MicroMsg.JdMsgContent", "feed xml %s", new Object[] { paramString });
    paramString = bg.q(paramString, "sysmsg");
    if (paramString != null)
    {
      this.qQV = bf.ap((String)paramString.get(".sysmsg.biztype"), "");
      this.qRf = bf.ap((String)paramString.get(".sysmsg.alert"), "");
      this.qQW = bf.ap((String)paramString.get(".sysmsg.activityid"), "");
      this.startTime = bf.PY((String)paramString.get(".sysmsg.starttime"));
      this.hUP = bf.PY((String)paramString.get(".sysmsg.expiretime"));
      this.title = bf.ap((String)paramString.get(".sysmsg.content.title"), "");
      this.iconUrl = bf.ap((String)paramString.get(".sysmsg.content.icon"), "");
      this.jumpUrl = bf.ap((String)paramString.get(".sysmsg.content.jumpurl"), "");
      this.qRb = bf.PY((String)paramString.get(".sysmsg.content.urlstarttime"));
      this.qRc = bf.PY((String)paramString.get(".sysmsg.content.urlexpiretime"));
      this.qQZ = bf.ap((String)paramString.get(".sysmsg.content.jdcelltitle"), "");
      this.qRa = bf.ap((String)paramString.get(".sysmsg.content.jdcellicon"), "");
      this.qRd = bf.PY((String)paramString.get(".sysmsg.content.titlestarttime"));
      this.qRe = bf.PY((String)paramString.get(".sysmsg.content.titleexpiretime"));
      this.qQX = "1".equals(paramString.get(".sysmsg.content.findshowreddot"));
      this.qQY = "1".equals(paramString.get(".sysmsg.content.jdcellshowred"));
      this.qRg = bf.ap((String)paramString.get(".sysmsg.content.alertviewtitle"), "");
      this.qRh = bf.ap((String)paramString.get(".sysmsg.content.alertviewconfirm"), "");
      this.qRi = bf.ap((String)paramString.get(".sysmsg.content.alertviewcancel"), "");
    }
    GMTrace.o(5852832464896L, 43607);
  }
  
  public final boolean a(b paramb)
  {
    GMTrace.i(5853235118080L, 43610);
    if (paramb == null)
    {
      GMTrace.o(5853235118080L, 43610);
      return true;
    }
    if (!bf.ap(this.qQW, "").equals(bf.ap(paramb.qQW, "")))
    {
      GMTrace.o(5853235118080L, 43610);
      return true;
    }
    GMTrace.o(5853235118080L, 43610);
    return false;
  }
  
  public final boolean axw()
  {
    GMTrace.i(5852966682624L, 43608);
    if (this.startTime < System.currentTimeMillis() / 1000L)
    {
      GMTrace.o(5852966682624L, 43608);
      return true;
    }
    GMTrace.o(5852966682624L, 43608);
    return false;
  }
  
  public final String bmA()
  {
    GMTrace.i(5853637771264L, 43613);
    String str = this.qQZ;
    GMTrace.o(5853637771264L, 43613);
    return str;
  }
  
  public final boolean bmB()
  {
    GMTrace.i(5853771988992L, 43614);
    boolean bool = this.qQY;
    GMTrace.o(5853771988992L, 43614);
    return bool;
  }
  
  public final String bmC()
  {
    GMTrace.i(5853906206720L, 43615);
    String str = this.qQV;
    GMTrace.o(5853906206720L, 43615);
    return str;
  }
  
  public final String bmD()
  {
    GMTrace.i(5854040424448L, 43616);
    String str = this.jumpUrl;
    GMTrace.o(5854040424448L, 43616);
    return str;
  }
  
  public final boolean bmx()
  {
    GMTrace.i(5853100900352L, 43609);
    if ((this.hUP != 0L) && (this.hUP < System.currentTimeMillis() / 1000L))
    {
      GMTrace.o(5853100900352L, 43609);
      return true;
    }
    GMTrace.o(5853100900352L, 43609);
    return false;
  }
  
  public final String bmy()
  {
    GMTrace.i(5853369335808L, 43611);
    String str = bf.ap(this.fSi, "");
    GMTrace.o(5853369335808L, 43611);
    return str;
  }
  
  public final String bmz()
  {
    GMTrace.i(5853503553536L, 43612);
    String str = this.qQW;
    GMTrace.o(5853503553536L, 43612);
    return str;
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/plugin/subapp/jdbiz/b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */