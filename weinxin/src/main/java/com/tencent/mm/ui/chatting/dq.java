package com.tencent.mm.ui.chatting;

import com.tencent.gmtrace.GMTrace;
import com.tencent.mm.a.e;
import com.tencent.mm.ah.d;
import com.tencent.mm.ah.f;
import com.tencent.mm.ah.n;
import com.tencent.mm.e.b.ce;
import com.tencent.mm.pluginsdk.model.app.an;
import com.tencent.mm.pluginsdk.model.app.b;
import com.tencent.mm.pluginsdk.model.app.c;
import com.tencent.mm.sdk.platformtools.bf;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.storage.au;
import com.tencent.mm.t.f.a;

public final class dq
{
  public static String a(au paramau, f.a parama)
  {
    GMTrace.i(2127619424256L, 15852);
    String str2 = "";
    String str1 = str2;
    if (parama != null)
    {
      str1 = str2;
      if (!bf.mA(parama.fCN))
      {
        parama = an.abF().LV(parama.fCN);
        str1 = str2;
        if (parama != null)
        {
          str1 = str2;
          if (parama.ayY())
          {
            str1 = str2;
            if (e.aO(parama.field_fileFullPath)) {
              str1 = parama.field_fileFullPath;
            }
          }
        }
      }
    }
    if (!bf.mA(str1))
    {
      v.d("MicroMsg.HistoryExportUtil", "get hd appmsg image path ok, %s", new Object[] { str1 });
      GMTrace.o(2127619424256L, 15852);
      return str1;
    }
    if (paramau != null) {
      str1 = n.GT().v(paramau.field_imgPath, true);
    }
    v.d("MicroMsg.HistoryExportUtil", "try get thumb appmsg image path finish, %s", new Object[] { str1 });
    GMTrace.o(2127619424256L, 15852);
    return str1;
  }
  
  public static String eL(long paramLong)
  {
    GMTrace.i(2127216771072L, 15849);
    String str = f(n.GT().aj(paramLong));
    if (str != null)
    {
      GMTrace.o(2127216771072L, 15849);
      return str;
    }
    GMTrace.o(2127216771072L, 15849);
    return null;
  }
  
  public static String eM(long paramLong)
  {
    GMTrace.i(2127350988800L, 15850);
    String str = f(n.GT().ai(paramLong));
    if (str != null)
    {
      GMTrace.o(2127350988800L, 15850);
      return str;
    }
    GMTrace.o(2127350988800L, 15850);
    return null;
  }
  
  private static String f(d paramd)
  {
    GMTrace.i(2127485206528L, 15851);
    if (paramd != null)
    {
      if (paramd.GC())
      {
        str = paramd.hEH;
        if ((str != null) && (e.aO(str)))
        {
          GMTrace.o(2127485206528L, 15851);
          return str;
        }
      }
      String str = paramd.hEH;
      str = n.GT().m(str, null, null);
      if ((str != null) && (e.aO(str)))
      {
        GMTrace.o(2127485206528L, 15851);
        return str;
      }
      paramd = paramd.hEJ;
      paramd = n.GT().m(paramd, null, null);
      if ((paramd != null) && (e.aO(paramd)))
      {
        GMTrace.o(2127485206528L, 15851);
        return paramd;
      }
    }
    GMTrace.o(2127485206528L, 15851);
    return null;
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/ui/chatting/dq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */