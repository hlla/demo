package com.tencent.mm.as;

import com.tencent.gmtrace.GMTrace;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.sdk.platformtools.bf;
import com.tencent.mm.sdk.platformtools.v;

public final class i
{
  private static a hPB;
  
  static
  {
    GMTrace.i(1300569784320L, 9690);
    hPB = new a();
    GMTrace.o(1300569784320L, 9690);
  }
  
  public static void Is()
  {
    GMTrace.i(1299093389312L, 9679);
    hPB.hPD = System.currentTimeMillis();
    v.v("MicroMsg.FTS.FTSWebReportLogic", "startH5Report %s", new Object[] { Long.valueOf(hPB.hPD) });
    GMTrace.o(1299093389312L, 9679);
  }
  
  public static void It()
  {
    GMTrace.i(1299227607040L, 9680);
    a locala = hPB;
    locala.hPE += System.currentTimeMillis() - hPB.hPD;
    v.v("MicroMsg.FTS.FTSWebReportLogic", "stopH5Report %s", new Object[] { Long.valueOf(hPB.hPE) });
    GMTrace.o(1299227607040L, 9680);
  }
  
  public static void Iu()
  {
    GMTrace.i(1299361824768L, 9681);
    a locala = hPB;
    locala.hJH += System.currentTimeMillis() - hPB.hPF;
    v.v("MicroMsg.FTS.FTSWebReportLogic", "stopTotalReport %s", new Object[] { Long.valueOf(hPB.hJH) });
    GMTrace.o(1299361824768L, 9681);
  }
  
  public static void Iv()
  {
    GMTrace.i(1299496042496L, 9682);
    a locala = hPB;
    if (!locala.hPG)
    {
      g.oSF.i(12044, new Object[] { Integer.valueOf(locala.scene), Integer.valueOf(locala.hPC), Long.valueOf(locala.hPE / 1000L), Long.valueOf(locala.hJH / 1000L) });
      locala.hPG = true;
    }
    v.v("MicroMsg.FTS.FTSWebReportLogic", "reportTime");
    GMTrace.o(1299496042496L, 9682);
  }
  
  public static void a(int paramInt1, int paramInt2, int paramInt3, int paramInt4, String paramString)
  {
    GMTrace.i(17863708508160L, 133095);
    g.oSF.i(14457, new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Long.valueOf(System.currentTimeMillis()), Integer.valueOf(d.hOW), Integer.valueOf(paramInt3), Integer.valueOf(paramInt4), paramString });
    GMTrace.o(17863708508160L, 133095);
  }
  
  public static void a(int paramInt1, int paramInt2, String paramString1, int paramInt3, int paramInt4, String paramString2, int paramInt5)
  {
    GMTrace.i(17862903201792L, 133089);
    v.v("MicroMsg.FTS.FTSWebReportLogic", "kvReportWebSearchGuideDisplay %d %d %s %d %d %s %d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString1, Integer.valueOf(paramInt3), Integer.valueOf(paramInt4), paramString2, Integer.valueOf(paramInt5) });
    g.oSF.i(12098, new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(d.hOW), Integer.valueOf(paramInt2), paramString1, Integer.valueOf(paramInt3), Integer.valueOf(paramInt4), paramString2, Integer.valueOf(paramInt5) });
    GMTrace.o(17862903201792L, 133089);
  }
  
  public static void a(int paramInt1, String paramString1, String paramString2, int paramInt2, int paramInt3)
  {
    GMTrace.i(1300435566592L, 9689);
    g.oSF.i(13810, new Object[] { Integer.valueOf(paramInt1), paramString1, paramString2, Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), Integer.valueOf(0) });
    GMTrace.o(1300435566592L, 9689);
  }
  
  public static void a(int paramInt1, String paramString, boolean paramBoolean1, boolean paramBoolean2, int paramInt2)
  {
    GMTrace.i(1298824953856L, 9677);
    int i;
    if (paramBoolean1) {
      i = 3;
    }
    for (;;)
    {
      g.oSF.i(12042, new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(1), Integer.valueOf(i), Integer.valueOf(paramInt2), bf.ap(paramString, "").replace(",", " ") });
      GMTrace.o(1298824953856L, 9677);
      return;
      if (paramBoolean2) {
        i = 2;
      } else {
        i = 1;
      }
    }
  }
  
  public static void aW(int paramInt1, int paramInt2)
  {
    GMTrace.i(16175115272192L, 120514);
    g.oSF.i(12845, new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(0), Integer.valueOf(paramInt2) });
    GMTrace.o(16175115272192L, 120514);
  }
  
  public static final void aX(int paramInt1, int paramInt2)
  {
    GMTrace.i(17863171637248L, 133091);
    if (paramInt1 == 21) {
      g.oSF.a(649L, paramInt2, 1L, true);
    }
    GMTrace.o(17863171637248L, 133091);
  }
  
  public static void aY(int paramInt1, int paramInt2)
  {
    GMTrace.i(17863305854976L, 133092);
    b(paramInt1, paramInt2, "");
    GMTrace.o(17863305854976L, 133092);
  }
  
  public static void b(int paramInt1, int paramInt2, String paramString)
  {
    GMTrace.i(17863440072704L, 133093);
    a(paramInt1, paramInt2, 0, 0, paramString);
    GMTrace.o(17863440072704L, 133093);
  }
  
  public static void c(String paramString, int paramInt1, int paramInt2, int paramInt3)
  {
    GMTrace.i(1299898695680L, 9685);
    g.oSF.i(12639, new Object[] { bf.ap(paramString, "").replace(",", " "), Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(0), Integer.valueOf(paramInt3) });
    GMTrace.o(1299898695680L, 9685);
  }
  
  public static void g(int paramInt, String paramString1, String paramString2)
  {
    GMTrace.i(1300301348864L, 9688);
    g.oSF.i(13809, new Object[] { Integer.valueOf(paramInt), paramString1, paramString2, Integer.valueOf(0) });
    GMTrace.o(1300301348864L, 9688);
  }
  
  public static void gp(int paramInt)
  {
    GMTrace.i(1298959171584L, 9678);
    hPB.scene = paramInt;
    hPB.hPC = 1;
    hPB.hPD = System.currentTimeMillis();
    hPB.hPE = 0L;
    hPB.hPF = System.currentTimeMillis();
    hPB.hJH = 0L;
    hPB.hPG = false;
    v.v("MicroMsg.FTS.FTSWebReportLogic", "initReport %d %d", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(1) });
    GMTrace.o(1298959171584L, 9678);
  }
  
  public static void gq(int paramInt)
  {
    GMTrace.i(1299630260224L, 9683);
    v.v("MicroMsg.FTS.FTSWebReportLogic", "kvReportWebSearchVisit %d", new Object[] { Integer.valueOf(paramInt) });
    g.oSF.i(12041, new Object[] { Integer.valueOf(paramInt), Integer.valueOf(d.hOW) });
    GMTrace.o(1299630260224L, 9683);
  }
  
  public static final void gr(int paramInt)
  {
    GMTrace.i(17863037419520L, 133090);
    g.oSF.a(649L, paramInt, 1L, true);
    GMTrace.o(17863037419520L, 133090);
  }
  
  public static final void ka(String paramString)
  {
    GMTrace.i(16175249489920L, 120515);
    v.v("MicroMsg.FTS.FTSWebReportLogic", "reportWebSuggestClick %s", new Object[] { paramString });
    g.oSF.A(12721, paramString);
    GMTrace.o(16175249489920L, 120515);
  }
  
  public static void p(int paramInt, String paramString)
  {
    GMTrace.i(1298690736128L, 9676);
    g.oSF.A(paramInt, paramString);
    GMTrace.o(1298690736128L, 9676);
  }
  
  public static void q(int paramInt1, int paramInt2, int paramInt3)
  {
    GMTrace.i(17863574290432L, 133094);
    a(paramInt1, 3, paramInt2, paramInt3, "");
    GMTrace.o(17863574290432L, 133094);
  }
  
  public static void q(int paramInt, String paramString)
  {
    GMTrace.i(16262625230848L, 121166);
    g.oSF.i(12070, new Object[] { Integer.valueOf(paramInt), Integer.valueOf(d.hOW), paramString, Integer.valueOf(4), Integer.valueOf(0), "", Integer.valueOf(1), Integer.valueOf(0) });
    GMTrace.o(16262625230848L, 121166);
  }
  
  public static final class a
  {
    long hJH;
    int hPC;
    long hPD;
    long hPE;
    long hPF;
    boolean hPG;
    int scene;
    
    public a()
    {
      GMTrace.i(1325802717184L, 9878);
      this.hPG = true;
      GMTrace.o(1325802717184L, 9878);
    }
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/as/i.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */