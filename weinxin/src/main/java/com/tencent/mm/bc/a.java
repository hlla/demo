package com.tencent.mm.bc;

import com.tencent.gmtrace.GMTrace;
import com.tencent.mm.sdk.platformtools.bf;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.storage.t;
import com.tencent.mm.u.ap;
import com.tencent.mm.u.bm;
import com.tencent.mm.u.c;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public final class a
{
  private static final Map<Integer, Integer> sWT;
  
  static
  {
    GMTrace.i(13046634250240L, 97205);
    sWT = new HashMap();
    GMTrace.o(13046634250240L, 97205);
  }
  
  public static void NC(String paramString)
  {
    GMTrace.i(13046500032512L, 97204);
    paramString = paramString + bGI();
    Iterator localIterator = sWT.entrySet().iterator();
    StringBuilder localStringBuilder = new StringBuilder();
    while (localIterator.hasNext())
    {
      Map.Entry localEntry = (Map.Entry)localIterator.next();
      if ((localEntry != null) && (localEntry.getKey() != null) && (localEntry.getValue() != null) && (((Integer)localEntry.getValue()).intValue() != 0))
      {
        localStringBuilder.append(localEntry.getKey());
        localStringBuilder.append('=');
        localStringBuilder.append(localEntry.getValue());
        localStringBuilder.append(',');
      }
    }
    sWT.clear();
    if (localStringBuilder.length() > 0)
    {
      v.d("MicroMsg.PostTaskFMessageCardStat", "append fmesage card click");
      bm.n(10, localStringBuilder.toString());
    }
    paramString = paramString + bGI();
    v.d("MicroMsg.PostTaskFMessageCardStat", "dkfm :" + paramString);
    try
    {
      ap.yY();
      c.vr().set(66819, Long.valueOf(bf.Nz()));
      GMTrace.o(13046500032512L, 97204);
      return;
    }
    catch (Exception paramString)
    {
      v.e("MicroMsg.PostTaskFMessageCardStat", "e:" + paramString.getMessage());
      GMTrace.o(13046500032512L, 97204);
    }
  }
  
  public static String bGI()
  {
    GMTrace.i(13046365814784L, 97203);
    StringBuilder localStringBuilder = new StringBuilder("[a=");
    if (ap.yY() == null) {}
    for (String str = "0";; str = "1")
    {
      str = str + " ";
      if (ap.yY() != null) {
        break;
      }
      GMTrace.o(13046365814784L, 97203);
      return str;
    }
    localStringBuilder = new StringBuilder().append(str).append("c=");
    ap.yY();
    if (c.vr() == null)
    {
      str = "0";
      str = str + " ";
      localStringBuilder = new StringBuilder().append(str).append("u=");
      if (!ap.zb()) {
        break label163;
      }
    }
    label163:
    for (str = "1";; str = "0")
    {
      str = str + "]";
      GMTrace.o(13046365814784L, 97203);
      return str;
      str = "1";
      break;
    }
  }
  
  public static void run()
  {
    GMTrace.i(13046097379328L, 97201);
    ap.yY();
    if (bf.az(bf.a((Long)c.vr().get(66819, null), 0L)) * 1000L > 1800000L) {}
    for (int i = 1;; i = 0)
    {
      if (i != 0) {
        NC("");
      }
      GMTrace.o(13046097379328L, 97201);
      return;
    }
  }
  
  public static void xP(int paramInt)
  {
    GMTrace.i(13046231597056L, 97202);
    int i = bf.f((Integer)sWT.get(Integer.valueOf(paramInt)));
    sWT.put(Integer.valueOf(paramInt), Integer.valueOf(i + 1));
    GMTrace.o(13046231597056L, 97202);
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/bc/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */