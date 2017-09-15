package com.tencent.mm.plugin.fts.a;

import com.tencent.gmtrace.GMTrace;
import com.tencent.mars.smc.IDKey;
import com.tencent.mm.kernel.a;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.report.c;
import com.tencent.mm.sdk.platformtools.bf;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.storage.t;
import com.tencent.mm.storage.w.a;
import java.util.ArrayList;

public final class e
{
  public static final int[] lXV;
  
  static
  {
    GMTrace.i(18637742145536L, 138862);
    lXV = new int[] { 8, 9, 10, 11, 12, 14, 19, 20, 21, 22, 24, 25 };
    GMTrace.o(18637742145536L, 138862);
  }
  
  public static final void a(String paramString1, int paramInt, long paramLong, String paramString2)
  {
    GMTrace.i(18637205274624L, 138858);
    if (!d.b(paramInt, lXV))
    {
      GMTrace.o(18637205274624L, 138858);
      return;
    }
    if (com.tencent.mm.protocal.d.sXi)
    {
      h.vG();
      if (a.uH() % 50L != 1L)
      {
        GMTrace.o(18637205274624L, 138858);
        return;
      }
    }
    if ((paramInt > 0) && (!bf.mA(paramString1)))
    {
      h.vJ();
      long l = ((Long)h.vI().vr().get(w.a.uEx, Long.valueOf(0L))).longValue();
      v.v("MicroMsg.FTS.FTSReportLogic", "reportKVSearchTime: %d %s %d %d %s %d", new Object[] { Integer.valueOf(14175), paramString1, Integer.valueOf(paramInt), Long.valueOf(paramLong), bf.ap(paramString2, ""), Long.valueOf(l) });
      c.oRz.i(14175, new Object[] { bf.ap(paramString1, ""), Integer.valueOf(paramInt), Long.valueOf(paramLong), bf.ap(paramString2, ""), Long.valueOf(l) });
    }
    GMTrace.o(18637205274624L, 138858);
  }
  
  public static void mM(int paramInt)
  {
    GMTrace.i(18637607927808L, 138861);
    IDKey localIDKey = new IDKey();
    localIDKey.SetID(146);
    localIDKey.SetKey(0);
    localIDKey.SetValue(1);
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(localIDKey);
    if (paramInt != 1)
    {
      localIDKey = new IDKey();
      localIDKey.SetID(146);
      localIDKey.SetKey(2);
      localIDKey.SetValue(1);
      localArrayList.add(localIDKey);
      localIDKey = new IDKey();
      localIDKey.SetID(146);
      localIDKey.SetKey(paramInt);
      localIDKey.SetValue(1);
      localArrayList.add(localIDKey);
    }
    for (;;)
    {
      c.oRz.b(localArrayList, false);
      GMTrace.o(18637607927808L, 138861);
      return;
      localIDKey = new IDKey();
      localIDKey.SetID(146);
      localIDKey.SetKey(1);
      localIDKey.SetValue(1);
      localArrayList.add(localIDKey);
    }
  }
  
  public static void s(int paramInt, long paramLong)
  {
    GMTrace.i(18637339492352L, 138859);
    if (paramInt > 0)
    {
      int i = (paramInt - 1) * 2 + 1;
      v.v("MicroMsg.FTS.FTSReportLogic", "reportIDKeySearchTime: reportKey=%d taskId=%d", new Object[] { Integer.valueOf(i), Integer.valueOf(paramInt) });
      ArrayList localArrayList = new ArrayList();
      IDKey localIDKey = new IDKey();
      localIDKey.SetID(601);
      localIDKey.SetKey(i);
      localIDKey.SetValue((int)paramLong);
      localArrayList.add(localIDKey);
      localIDKey = new IDKey();
      localIDKey.SetID(601);
      localIDKey.SetKey(i + 1);
      localIDKey.SetValue(1);
      localArrayList.add(localIDKey);
      c.oRz.b(localArrayList, false);
    }
    GMTrace.o(18637339492352L, 138859);
  }
  
  public static void t(int paramInt, long paramLong)
  {
    GMTrace.i(18637473710080L, 138860);
    ArrayList localArrayList;
    IDKey localIDKey;
    if (paramInt > 0)
    {
      paramInt = (paramInt - 1) * 4 + 1;
      localArrayList = new ArrayList();
      localIDKey = new IDKey();
      localIDKey.SetID(602);
      localIDKey.SetKey(paramInt);
      localIDKey.SetValue(1);
      localArrayList.add(localIDKey);
      if (paramLong > 100L) {
        break label127;
      }
      localIDKey = new IDKey();
      localIDKey.SetID(602);
      localIDKey.SetKey(paramInt + 1);
      localIDKey.SetValue(1);
      localArrayList.add(localIDKey);
    }
    for (;;)
    {
      c.oRz.b(localArrayList, false);
      GMTrace.o(18637473710080L, 138860);
      return;
      label127:
      if (paramLong <= 500L)
      {
        localIDKey = new IDKey();
        localIDKey.SetID(602);
        localIDKey.SetKey(paramInt + 2);
        localIDKey.SetValue(1);
        localArrayList.add(localIDKey);
      }
      else
      {
        localIDKey = new IDKey();
        localIDKey.SetID(602);
        localIDKey.SetKey(paramInt + 3);
        localIDKey.SetValue(1);
        localArrayList.add(localIDKey);
      }
    }
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/plugin/fts/a/e.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */