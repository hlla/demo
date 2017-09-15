package com.tencent.mm.as;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.util.Base64;
import com.tencent.gmtrace.GMTrace;
import com.tencent.mm.protocal.c.amx;
import com.tencent.mm.protocal.c.amy;
import com.tencent.mm.sdk.platformtools.aa;
import com.tencent.mm.sdk.platformtools.bf;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.u.m;
import com.tencent.mm.u.o;
import java.io.IOException;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;

public final class f
{
  public static amy hPr;
  
  private static String Ip()
  {
    GMTrace.i(1318286524416L, 9822);
    String str = "key_pb_most_search_biz_list" + m.xL();
    GMTrace.o(1318286524416L, 9822);
    return str;
  }
  
  public static amy Ir()
  {
    GMTrace.i(1318152306688L, 9821);
    Object localObject;
    if (hPr == null)
    {
      localObject = Ip();
      hPr = new amy();
      localObject = aa.getContext().getSharedPreferences("fts_recent_biz_sp", 0).getString((String)localObject, "");
      if (!bf.mA((String)localObject)) {
        localObject = Base64.decode(((String)localObject).getBytes(), 0);
      }
    }
    try
    {
      hPr.aD((byte[])localObject);
      localObject = hPr;
      GMTrace.o(1318152306688L, 9821);
      return (amy)localObject;
    }
    catch (IOException localIOException)
    {
      for (;;) {}
    }
  }
  
  public static void jZ(String paramString)
  {
    GMTrace.i(1318420742144L, 9823);
    if (!o.eV(paramString))
    {
      GMTrace.o(1318420742144L, 9823);
      return;
    }
    if (hPr == null) {
      Ir();
    }
    long l1 = System.currentTimeMillis();
    Object localObject1 = null;
    int i = 0;
    Object localObject2;
    if (i < hPr.jLs.size())
    {
      localObject2 = (amx)hPr.jLs.get(i);
      long l2 = (l1 - ((amx)localObject2).tPU) / 86400000L;
      ((amx)localObject2).tPT *= Math.pow(0.98D, l2);
      ((amx)localObject2).tPU = (l2 * 86400000L + ((amx)localObject2).tPU);
      v.d("MicroMsg.FTS.FTSMostSearchBizLogic", "after update: %.2f %d %s", new Object[] { Double.valueOf(((amx)localObject2).tPT), Long.valueOf(((amx)localObject2).tPU), ((amx)localObject2).tfa });
      if (!((amx)localObject2).tfa.equals(paramString)) {
        break label468;
      }
      localObject1 = localObject2;
    }
    label468:
    for (;;)
    {
      i += 1;
      break;
      if (localObject1 == null)
      {
        localObject1 = new amx();
        ((amx)localObject1).tPT = 1.0D;
        ((amx)localObject1).tPU = l1;
        ((amx)localObject1).tfa = paramString;
        hPr.jLs.add(localObject1);
        v.i("MicroMsg.FTS.FTSMostSearchBizLogic", "add new use %s", new Object[] { paramString });
      }
      for (;;)
      {
        Collections.sort(hPr.jLs, new Comparator() {});
        i = hPr.jLs.size() - 1;
        while ((i < hPr.jLs.size()) && (hPr.jLs.size() > 8))
        {
          if (((amx)hPr.jLs.get(i)).tPT < 0.5D) {
            hPr.jLs.remove(i);
          }
          i += 1;
        }
        ((amx)localObject1).tPT += 1.0D;
        v.i("MicroMsg.FTS.FTSMostSearchBizLogic", "update use %s %.2f", new Object[] { paramString, Double.valueOf(((amx)localObject1).tPT) });
      }
      paramString = aa.getContext().getSharedPreferences("fts_recent_biz_sp", 0);
      try
      {
        localObject1 = Ip();
        localObject2 = Base64.encodeToString(hPr.toByteArray(), 0);
        paramString.edit().putString((String)localObject1, (String)localObject2).commit();
        v.i("MicroMsg.FTS.FTSMostSearchBizLogic", "useBiz pbListString %s", new Object[] { localObject2 });
        GMTrace.o(1318420742144L, 9823);
        return;
      }
      catch (IOException paramString)
      {
        GMTrace.o(1318420742144L, 9823);
        return;
      }
    }
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/as/f.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */