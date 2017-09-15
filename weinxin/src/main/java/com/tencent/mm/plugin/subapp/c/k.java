package com.tencent.mm.plugin.subapp.c;

import com.tencent.gmtrace.GMTrace;
import com.tencent.mm.e.b.di;
import com.tencent.mm.sdk.e.e;
import com.tencent.mm.sdk.e.i;
import com.tencent.mm.sdk.platformtools.v;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import junit.framework.Assert;

public final class k
  extends i<g>
{
  public static final String[] gUn;
  private static long iag;
  e gUp;
  Map<String, c> qRU;
  
  static
  {
    GMTrace.i(5837934297088L, 43496);
    gUn = new String[] { i.a(g.gTF, "VoiceRemindInfo") };
    iag = 0L;
    GMTrace.o(5837934297088L, 43496);
  }
  
  public k(e parame)
  {
    super(parame, g.gTF, "VoiceRemindInfo", di.gaA);
    GMTrace.i(5837397426176L, 43492);
    this.qRU = new HashMap();
    this.gUp = parame;
    GMTrace.o(5837397426176L, 43492);
  }
  
  public static String lv(String paramString)
  {
    GMTrace.i(5837531643904L, 43493);
    long l = System.currentTimeMillis();
    String str2 = new SimpleDateFormat("ssHHmmMMddyy").format(new Date(l));
    String str1 = str2;
    if (paramString != null)
    {
      str1 = str2;
      if (paramString.length() > 1) {
        str1 = str2 + com.tencent.mm.a.g.n(paramString.getBytes()).substring(0, 7);
      }
    }
    paramString = str1 + l % 10000L;
    paramString = new StringBuilder().append(paramString);
    l = iag;
    iag = 1L + l;
    paramString = l;
    GMTrace.o(5837531643904L, 43493);
    return paramString;
  }
  
  public final boolean gR(String paramString)
  {
    GMTrace.i(5837665861632L, 43494);
    if (paramString.length() > 0) {}
    for (boolean bool = true;; bool = false)
    {
      Assert.assertTrue(bool);
      if (this.gUp.delete("VoiceRemindInfo", "filename= ?", new String[] { paramString }) <= 0) {
        v.w("MicroMsg.VoiceRemindStorage", "delete failed, no such file:" + paramString);
      }
      GMTrace.o(5837665861632L, 43494);
      return true;
    }
  }
  
  public final void lX(String paramString)
  {
    GMTrace.i(5837800079360L, 43495);
    c localc = (c)this.qRU.get(paramString);
    if (localc != null)
    {
      localc.Lv();
      this.qRU.remove(paramString);
    }
    GMTrace.o(5837800079360L, 43495);
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/plugin/subapp/c/k.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */