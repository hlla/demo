package com.tencent.mm.pluginsdk.k.a.b;

import com.tencent.gmtrace.GMTrace;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.sdk.platformtools.bf;

public final class j
{
  private static final int sEp;
  private static final int sEq;
  private static final int sEr;
  
  static
  {
    GMTrace.i(844632162304L, 6293);
    sEp = i.b.sEl.fRM;
    sEq = i.b.sEn.fRM;
    sEr = i.b.sEm.fRM;
    GMTrace.o(844632162304L, 6293);
  }
  
  public static void a(int paramInt1, int paramInt2, int paramInt3, boolean paramBoolean, String paramString)
  {
    GMTrace.i(844229509120L, 6290);
    int j = sEq;
    if (paramBoolean) {}
    for (int i = 0;; i = 1)
    {
      a(paramInt1, paramInt2, "", paramInt3, j, i, a.sEt - 1, 1, 1, 1, paramString);
      GMTrace.o(844229509120L, 6290);
      return;
    }
  }
  
  public static void a(int paramInt1, int paramInt2, int paramInt3, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, boolean paramBoolean4, String paramString)
  {
    GMTrace.i(844363726848L, 6291);
    int n = sEr;
    int i;
    int i1;
    int j;
    label34:
    int k;
    if (paramBoolean1)
    {
      i = 0;
      i1 = a.sEt;
      if (!paramBoolean3) {
        break label90;
      }
      j = 0;
      if (!paramBoolean2) {
        break label96;
      }
      k = 0;
      label42:
      if (!paramBoolean4) {
        break label102;
      }
    }
    label90:
    label96:
    label102:
    for (int m = 0;; m = 1)
    {
      a(paramInt1, paramInt2, "", paramInt3, n, i, i1 - 1, j, k, m, paramString);
      GMTrace.o(844363726848L, 6291);
      return;
      i = 1;
      break;
      j = 1;
      break label34;
      k = 1;
      break label42;
    }
  }
  
  private static void a(int paramInt1, int paramInt2, String paramString1, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7, int paramInt8, int paramInt9, String paramString2)
  {
    GMTrace.i(844497944576L, 6292);
    g.oSF.i(11906, new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString1, Integer.valueOf(paramInt3), Integer.valueOf(paramInt4), Integer.valueOf(paramInt5), Integer.valueOf(paramInt6), Integer.valueOf(paramInt7), Integer.valueOf(paramInt8), Integer.valueOf(paramInt9) });
    if ((!bf.mA(paramString2)) && (!paramString2.equals("0"))) {
      g.oSF.i(11907, new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString1, Integer.valueOf(paramInt3), Integer.valueOf(paramInt4), Integer.valueOf(paramInt5), Integer.valueOf(paramInt6), Integer.valueOf(paramInt7), Integer.valueOf(paramInt8), Integer.valueOf(paramInt9), paramString2 });
    }
    GMTrace.o(844497944576L, 6292);
  }
  
  public static void a(int paramInt1, int paramInt2, String paramString1, int paramInt3, int paramInt4, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, String paramString2)
  {
    GMTrace.i(844095291392L, 6289);
    int m = sEp;
    int i;
    int j;
    if (paramBoolean2)
    {
      i = 0;
      if (!paramBoolean3) {
        break label76;
      }
      j = 0;
      label30:
      if (!paramBoolean1) {
        break label82;
      }
    }
    label76:
    label82:
    for (int k = 0;; k = 1)
    {
      a(paramInt1, paramInt2, paramString1, paramInt3, m, i, paramInt4 - 1, j, 1, k, paramString2);
      GMTrace.o(844095291392L, 6289);
      return;
      i = 1;
      break;
      j = 1;
      break label30;
    }
  }
  
  public static void eh(long paramLong)
  {
    GMTrace.i(843961073664L, 6288);
    u(paramLong, 2L);
    GMTrace.o(843961073664L, 6288);
  }
  
  public static void u(long paramLong1, long paramLong2)
  {
    GMTrace.i(843826855936L, 6287);
    if ((paramLong1 > 0L) && (197L != paramLong1)) {
      g.oSF.a(paramLong1, paramLong2, 1L, false);
    }
    g.oSF.a(197L, paramLong2, 1L, false);
    GMTrace.o(843826855936L, 6287);
  }
  
  public static enum a
  {
    static
    {
      GMTrace.i(852685225984L, 6353);
      sEs = 1;
      sEt = 2;
      sEu = 3;
      sEv = 4;
      sEw = 5;
      sEx = 6;
      sEy = new int[] { sEs, sEt, sEu, sEv, sEw, sEx };
      GMTrace.o(852685225984L, 6353);
    }
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/pluginsdk/k/a/b/j.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */