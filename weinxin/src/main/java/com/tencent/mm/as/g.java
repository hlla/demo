package com.tencent.mm.as;

import com.tencent.gmtrace.GMTrace;
import com.tencent.mars.smc.IDKey;
import com.tencent.mm.modelsns.d;
import com.tencent.mm.plugin.fts.d.a.a;
import com.tencent.mm.sdk.platformtools.bf;
import com.tencent.mm.sdk.platformtools.v;
import java.util.ArrayList;

public final class g
{
  public static void a(a parama, c paramc)
  {
    GMTrace.i(16671586648064L, 124213);
    int j = parama.mbs;
    String str3 = parama.mbu;
    long l2 = parama.mbv;
    int k = f(parama.mbx, parama.mby, parama.axZ());
    int i;
    switch (parama.klJ)
    {
    case 10: 
    case 11: 
    case 12: 
    case 15: 
    default: 
      GMTrace.o(16671586648064L, 124213);
      return;
    case 1: 
      i = 3;
    }
    for (;;)
    {
      long l1 = System.currentTimeMillis() - paramc.hOS;
      if ((l1 < 0L) || (paramc.hOS == 0L)) {
        l1 = 0L;
      }
      parama = String.format("%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s", new Object[] { Integer.valueOf(parama.maK), Integer.valueOf(i), Integer.valueOf(j), bf.ap(str3, ""), Long.valueOf(l2), Integer.valueOf(k), Integer.valueOf(parama.Sr()), Integer.valueOf(go(parama.axY())), parama.Sq(), Long.valueOf(l1), Integer.valueOf(paramc.hOT) });
      v.v("MicroMsg.FTS.FTSReportLogic", "report detail page click: %s", new Object[] { parama });
      com.tencent.mm.plugin.report.service.g.oSF.A(11310, parama);
      GMTrace.o(16671586648064L, 124213);
      return;
      i = 4;
      continue;
      i = 5;
      continue;
      i = 10;
      continue;
      i = 11;
      continue;
      i = 12;
      continue;
      i = 13;
      continue;
      i = 14;
      continue;
      i = 16;
      continue;
      i = 15;
      continue;
      i = 17;
      continue;
      i = 20;
      continue;
      d locald = new d();
      String str2 = parama.fRC;
      String str1 = str2;
      if (str2 != null) {
        str1 = str2.replaceAll(",", " ");
      }
      locald.n("20KeyWordId", str1 + ",");
      locald.n("21ViewType", "2,");
      locald.n("22OpType", "2,");
      locald.n("23ResultCount", ",");
      locald.n("24ClickPos", parama.mbt + ",");
      locald.n("25ClickAppUserName", parama.info + ",");
      v.i("MicroMsg.FTS.FTSReportLogic", "report oreh LocalSearchWeApp(13963), %s", new Object[] { locald.JH() });
      com.tencent.mm.plugin.report.service.g.oSF.i(13963, new Object[] { locald });
      i = 19;
    }
  }
  
  public static void a(a parama, h paramh)
  {
    GMTrace.i(16671452430336L, 124212);
    int k = parama.mbs;
    int m = parama.mbt;
    String str3 = parama.mbu;
    long l2 = parama.mbv;
    int n = f(parama.mbx, parama.mby, parama.axZ());
    int i;
    int j;
    if (parama.mbr == -8)
    {
      i = 2;
      j = 1;
    }
    for (;;)
    {
      long l1 = System.currentTimeMillis() - paramh.hOS;
      if ((l1 < 0L) || (paramh.hOS == 0L)) {
        l1 = 0L;
      }
      parama = String.format("%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s", new Object[] { Integer.valueOf(parama.maK), Integer.valueOf(i), Integer.valueOf(k), Integer.valueOf(j), Integer.valueOf(m), bf.ap(str3, ""), Long.valueOf(l2), Integer.valueOf(n), Integer.valueOf(0), Integer.valueOf(parama.Sr()), Integer.valueOf(go(parama.axY())), parama.Sq(), Long.valueOf(l1), Integer.valueOf(paramh.hPt), Integer.valueOf(paramh.hPu), Integer.valueOf(paramh.hPv), Integer.valueOf(paramh.hPw), Integer.valueOf(paramh.hPx), Integer.valueOf(paramh.hPy), Integer.valueOf(paramh.hPz), Integer.valueOf(paramh.hPA) });
      v.v("MicroMsg.FTS.FTSReportLogic", "report home page click: %d, %s", new Object[] { Integer.valueOf(10991), parama });
      com.tencent.mm.plugin.report.service.g.oSF.A(10991, parama);
      GMTrace.o(16671452430336L, 124212);
      return;
      switch (parama.klJ)
      {
      case 11: 
      case 15: 
      default: 
        GMTrace.o(16671452430336L, 124212);
        return;
      case 1: 
        i = 3;
        j = 1;
        break;
      case 2: 
        i = 4;
        j = 1;
        break;
      case 4: 
        i = 5;
        j = 1;
        break;
      case 3: 
        i = 10;
        j = 1;
        break;
      case 6: 
        i = 11;
        j = 1;
        break;
      case 14: 
        i = 15;
        j = 1;
        break;
      case 5: 
        i = 16;
        j = 1;
        break;
      case 13: 
        i = 17;
        j = 1;
        break;
      case 7: 
        i = 12;
        j = 1;
        break;
      case 8: 
        i = 13;
        j = 1;
        break;
      case 9: 
        i = 14;
        j = 1;
        break;
      case 17: 
        i = 20;
        j = 1;
        break;
      case 12: 
        j = 2;
        if (parama.mbr == -5)
        {
          i = 16;
        }
        else if (parama.mbr == -3)
        {
          i = 4;
        }
        else if (parama.mbr == -4)
        {
          i = 3;
        }
        else if (parama.mbr == -1)
        {
          i = 12;
        }
        else if (parama.mbr == -2)
        {
          i = 11;
        }
        else
        {
          GMTrace.o(16671452430336L, 124212);
          return;
        }
        break;
      case 10: 
        if (parama.mbw)
        {
          i = 8;
          j = 1;
        }
        else
        {
          i = 9;
          j = 1;
        }
        break;
      case 16: 
        d locald = new d();
        String str2 = parama.fRC;
        String str1 = str2;
        if (str2 != null) {
          str1 = str2.replaceAll(",", " ");
        }
        locald.n("20KeyWordId", str1 + ",");
        locald.n("21ViewType", "1,");
        locald.n("22OpType", "2,");
        locald.n("23ResultCount", ",");
        locald.n("24ClickPos", parama.mbt + ",");
        locald.n("25ClickAppUserName", parama.info + ",");
        v.i("MicroMsg.FTS.FTSReportLogic", "report oreh LocalSearchWeApp(13963), %s", new Object[] { locald.JH() });
        com.tencent.mm.plugin.report.service.g.oSF.i(13963, new Object[] { locald });
        i = 19;
        j = 1;
      }
    }
  }
  
  public static void a(String paramString, boolean paramBoolean1, int paramInt1, int paramInt2, boolean paramBoolean2)
  {
    GMTrace.i(1321239314432L, 9844);
    switch (paramInt2)
    {
    default: 
      paramInt2 = 0;
      if (!paramBoolean1) {
        break label155;
      }
      if (!paramBoolean2) {
        break;
      }
    }
    for (paramInt1 = 1;; paramInt1 = 0)
    {
      paramString = String.format("%s,%s,%s,%s", new Object[] { paramString, Integer.valueOf(3), Integer.valueOf(paramInt2), Integer.valueOf(paramInt1) });
      v.i("MicroMsg.FTS.FTSReportLogic", "reportKvQuery %d %s", new Object[] { Integer.valueOf(11062), paramString });
      com.tencent.mm.plugin.report.service.g.oSF.A(11062, paramString);
      GMTrace.o(1321239314432L, 9844);
      return;
      paramInt2 = 2;
      break;
      paramInt2 = 1;
      break;
    }
    label155:
    if (paramInt1 > 0)
    {
      if (paramBoolean2) {}
      for (paramInt1 = 1;; paramInt1 = 0)
      {
        paramString = String.format("%s,%s,%s,%s", new Object[] { paramString, Integer.valueOf(2), Integer.valueOf(paramInt2), Integer.valueOf(paramInt1) });
        break;
      }
    }
    if (paramBoolean2) {}
    for (paramInt1 = 1;; paramInt1 = 0)
    {
      paramString = String.format("%s,%s,%s,%s", new Object[] { paramString, Integer.valueOf(1), Integer.valueOf(paramInt2), Integer.valueOf(paramInt1) });
      break;
    }
  }
  
  public static final void bm(boolean paramBoolean)
  {
    int j = 1;
    GMTrace.i(1321910403072L, 9849);
    com.tencent.mm.plugin.report.service.g localg;
    if (paramBoolean)
    {
      i = 1;
      v.v("MicroMsg.FTS.FTSReportLogic", "reportFTSCreateChatroom: %d %d", new Object[] { Integer.valueOf(13970), Integer.valueOf(i) });
      localg = com.tencent.mm.plugin.report.service.g.oSF;
      if (!paramBoolean) {
        break label87;
      }
    }
    label87:
    for (int i = j;; i = 0)
    {
      localg.i(13970, new Object[] { Integer.valueOf(i) });
      GMTrace.o(1321910403072L, 9849);
      return;
      i = 0;
      break;
    }
  }
  
  public static final int f(int paramInt1, int paramInt2, boolean paramBoolean)
  {
    GMTrace.i(1321507749888L, 9846);
    if (paramBoolean)
    {
      GMTrace.o(1321507749888L, 9846);
      return 15;
    }
    if (paramInt1 == 131072)
    {
      switch (paramInt2)
      {
      case 8: 
      case 9: 
      case 10: 
      case 12: 
      case 13: 
      case 14: 
      default: 
        GMTrace.o(1321507749888L, 9846);
        return 0;
      case 1: 
        GMTrace.o(1321507749888L, 9846);
        return 1;
      case 2: 
        GMTrace.o(1321507749888L, 9846);
        return 2;
      case 3: 
        GMTrace.o(1321507749888L, 9846);
        return 3;
      case 4: 
        GMTrace.o(1321507749888L, 9846);
        return 4;
      case 5: 
        GMTrace.o(1321507749888L, 9846);
        return 5;
      case 6: 
        GMTrace.o(1321507749888L, 9846);
        return 6;
      case 7: 
        GMTrace.o(1321507749888L, 9846);
        return 7;
      case 11: 
        GMTrace.o(1321507749888L, 9846);
        return 8;
      case 16: 
        GMTrace.o(1321507749888L, 9846);
        return 10;
      case 17: 
      case 18: 
        GMTrace.o(1321507749888L, 9846);
        return 9;
      }
      GMTrace.o(1321507749888L, 9846);
      return 16;
    }
    if (paramInt1 == 131075)
    {
      switch (paramInt2)
      {
      default: 
        GMTrace.o(1321507749888L, 9846);
        return 0;
      case 1: 
      case 5: 
        GMTrace.o(1321507749888L, 9846);
        return 12;
      case 2: 
      case 6: 
        GMTrace.o(1321507749888L, 9846);
        return 13;
      case 3: 
      case 7: 
        GMTrace.o(1321507749888L, 9846);
        return 14;
      }
      GMTrace.o(1321507749888L, 9846);
      return 11;
    }
    if (paramInt1 == 65536)
    {
      GMTrace.o(1321507749888L, 9846);
      return 17;
    }
    GMTrace.o(1321507749888L, 9846);
    return 0;
  }
  
  private static int go(int paramInt)
  {
    GMTrace.i(1321641967616L, 9847);
    switch (paramInt)
    {
    case 33: 
    default: 
      GMTrace.o(1321641967616L, 9847);
      return 0;
    case 37: 
      GMTrace.o(1321641967616L, 9847);
      return 16;
    case 32: 
      GMTrace.o(1321641967616L, 9847);
      return 4;
    case 34: 
      GMTrace.o(1321641967616L, 9847);
      return 5;
    case 35: 
      GMTrace.o(1321641967616L, 9847);
      return 6;
    case 36: 
      GMTrace.o(1321641967616L, 9847);
      return 6;
    case 29: 
      GMTrace.o(1321641967616L, 9847);
      return 1;
    case 30: 
      GMTrace.o(1321641967616L, 9847);
      return 2;
    }
    GMTrace.o(1321641967616L, 9847);
    return 3;
  }
  
  public static void j(int paramInt, long paramLong)
  {
    GMTrace.i(1320836661248L, 9841);
    v.v("MicroMsg.FTS.FTSReportLogic", "reportIDKey: type=%d time=%d", new Object[] { Integer.valueOf(paramInt), Long.valueOf(paramLong) });
    switch (paramInt)
    {
    }
    for (;;)
    {
      GMTrace.o(1320836661248L, 9841);
      return;
      IDKey localIDKey1 = new IDKey();
      localIDKey1.SetID(79);
      localIDKey1.SetKey(paramInt + 1);
      localIDKey1.SetValue((int)paramLong);
      IDKey localIDKey2 = new IDKey();
      localIDKey2.SetID(79);
      localIDKey2.SetKey(paramInt + 2);
      localIDKey2.SetValue(1);
      ArrayList localArrayList = new ArrayList();
      localArrayList.add(localIDKey1);
      localArrayList.add(localIDKey2);
      com.tencent.mm.plugin.report.service.g.oSF.b(localArrayList, false);
    }
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/as/g.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */