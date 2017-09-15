package com.tencent.mm.plugin.report.service;

import android.app.ActivityManager;
import android.app.ActivityManager.MemoryInfo;
import android.content.Context;
import android.os.StatFs;
import android.util.SparseArray;
import com.tencent.gmtrace.GMTrace;
import com.tencent.mm.compatible.util.h;
import com.tencent.mm.sdk.platformtools.aa;
import com.tencent.mm.sdk.platformtools.bf;
import com.tencent.mm.sdk.platformtools.v;
import java.io.File;
import java.io.FileFilter;
import java.util.HashMap;
import java.util.regex.Pattern;

public final class f
{
  private static SparseArray<Long> oSu;
  private static SparseArray<HashMap<Integer, Integer>> oSv;
  private static boolean oSw;
  private static long oSx;
  private static long oSy;
  private static long oSz;
  
  static
  {
    GMTrace.i(13121796177920L, 97765);
    oSu = new SparseArray();
    oSv = new SparseArray();
    oSw = true;
    oSx = 0L;
    oSy = 0L;
    oSz = 0L;
    GMTrace.o(13121796177920L, 97765);
  }
  
  private static void A(int paramInt, long paramLong)
  {
    GMTrace.i(13121393524736L, 97762);
    if (paramLong <= 0L)
    {
      GMTrace.o(13121393524736L, 97762);
      return;
    }
    if (paramLong < 1000L)
    {
      g.oSF.L(paramInt, 0, 1);
      GMTrace.o(13121393524736L, 97762);
      return;
    }
    if (paramLong < 2000L)
    {
      g.oSF.L(paramInt, 0, 3);
      GMTrace.o(13121393524736L, 97762);
      return;
    }
    if (paramLong < 5000L)
    {
      g.oSF.L(paramInt, 0, 5);
      GMTrace.o(13121393524736L, 97762);
      return;
    }
    if (paramLong < 10000L)
    {
      g.oSF.L(paramInt, 0, 7);
      GMTrace.o(13121393524736L, 97762);
      return;
    }
    g.oSF.L(paramInt, 0, 9);
    GMTrace.o(13121393524736L, 97762);
  }
  
  private static void B(int paramInt, long paramLong)
  {
    GMTrace.i(13121527742464L, 97763);
    long l;
    if (paramInt == 6)
    {
      l = System.currentTimeMillis();
      if (l < oSx + 60000L)
      {
        GMTrace.o(13121527742464L, 97763);
        return;
      }
      oSx = l;
    }
    for (;;)
    {
      a locala = a.aXC();
      if (!locala.hasInit) {
        break;
      }
      g.oSF.a(11335, true, false, new Object[] { Integer.valueOf(paramInt), Long.valueOf(paramLong), Integer.valueOf(locala.oSB), Long.valueOf(locala.oSA[0]), Long.valueOf(locala.oSA[1]), Long.valueOf(locala.oSD) });
      GMTrace.o(13121527742464L, 97763);
      return;
      if (paramInt == 7)
      {
        l = System.currentTimeMillis();
        if (l < oSy + 60000L)
        {
          GMTrace.o(13121527742464L, 97763);
          return;
        }
        oSy = l;
      }
      else if (paramInt == 8)
      {
        l = System.currentTimeMillis();
        if (l < oSz + 60000L)
        {
          GMTrace.o(13121527742464L, 97763);
          return;
        }
        oSz = l;
      }
    }
    g.oSF.a(11335, true, false, new Object[] { Integer.valueOf(paramInt), Long.valueOf(paramLong) });
    GMTrace.o(13121527742464L, 97763);
  }
  
  public static void cU(long paramLong)
  {
    GMTrace.i(13121125089280L, 97760);
    if (!oSw)
    {
      GMTrace.o(13121125089280L, 97760);
      return;
    }
    v.d("MicroMsg.ReportLogInfo", "ReportLogInfo operationBegin eventID:%d  with time:%d", new Object[] { Integer.valueOf(8), Long.valueOf(paramLong) });
    oSu.put(8, Long.valueOf(paramLong));
    GMTrace.o(13121125089280L, 97760);
  }
  
  public static void rU(int paramInt)
  {
    GMTrace.i(13120990871552L, 97759);
    if (!oSw)
    {
      GMTrace.o(13120990871552L, 97759);
      return;
    }
    oSu.put(paramInt, Long.valueOf(bf.NA()));
    v.d("MicroMsg.ReportLogInfo", "ReportLogInfo operationBegin eventID:%d  time:%d", new Object[] { Integer.valueOf(paramInt), Long.valueOf(bf.NA()) });
    GMTrace.o(13120990871552L, 97759);
  }
  
  public static void rV(int paramInt)
  {
    GMTrace.i(13121259307008L, 97761);
    if (!oSw)
    {
      GMTrace.o(13121259307008L, 97761);
      return;
    }
    Long localLong = (Long)oSu.get(paramInt);
    if (localLong == null)
    {
      GMTrace.o(13121259307008L, 97761);
      return;
    }
    if (localLong.longValue() == -1L)
    {
      GMTrace.o(13121259307008L, 97761);
      return;
    }
    oSu.put(paramInt, Long.valueOf(-1L));
    long l = bf.NA() - localLong.longValue();
    if (l <= 0L)
    {
      GMTrace.o(13121259307008L, 97761);
      return;
    }
    switch (paramInt)
    {
    }
    for (;;)
    {
      v.i("MicroMsg.ReportLogInfo", "ReportLogInfo operationEnd eventID:%d  time:%d", new Object[] { Integer.valueOf(paramInt), Long.valueOf(l) });
      GMTrace.o(13121259307008L, 97761);
      return;
      if (aa.urm)
      {
        g.oSF.c(23, 4, 5, (int)l, false);
      }
      else
      {
        B(1, l);
        A(227, l);
        g.oSF.c(23, 1, 2, (int)l, false);
        continue;
        B(3, l);
        A(229, l);
        g.oSF.c(27, 1, 2, (int)l, false);
        continue;
        B(2, l);
        A(228, l);
        g.oSF.c(28, 1, 2, (int)l, false);
        continue;
        B(6, l);
        continue;
        B(7, l);
        continue;
        B(8, l);
        continue;
        B(10, l);
        continue;
        B(14, l);
        continue;
        B(15, l);
        continue;
        B(9, l);
        continue;
        B(11, l);
        continue;
        B(16, l);
        continue;
        B(13, l);
        continue;
        B(12, l);
      }
    }
  }
  
  public static void rW(int paramInt)
  {
    GMTrace.i(13121661960192L, 97764);
    if (!oSw)
    {
      GMTrace.o(13121661960192L, 97764);
      return;
    }
    v.d("MicroMsg.ReportLogInfo", "ReportLogInfo stopOperation stop eventID:%d", new Object[] { Integer.valueOf(paramInt) });
    oSu.put(paramInt, Long.valueOf(-1L));
    GMTrace.o(13121661960192L, 97764);
  }
  
  public static final class a
  {
    public static a oSE;
    public volatile boolean hasInit;
    public long[] oSA;
    public int oSB;
    public String oSC;
    public long oSD;
    
    public a()
    {
      GMTrace.i(13117769646080L, 97735);
      GMTrace.o(13117769646080L, 97735);
    }
    
    public static a aXC()
    {
      try
      {
        GMTrace.i(13117903863808L, 97736);
        if (oSE == null)
        {
          locala = new a();
          oSE = locala;
          locala.oSB = ru();
          oSE.oSC = ro();
          locala = oSE;
          Object localObject2 = (ActivityManager)aa.getContext().getSystemService("activity");
          ActivityManager.MemoryInfo localMemoryInfo = new ActivityManager.MemoryInfo();
          ((ActivityManager)localObject2).getMemoryInfo(localMemoryInfo);
          locala.oSD = (localMemoryInfo.availMem >> 10);
          locala = oSE;
          localObject2 = new StatFs(h.getDataDirectory().getPath());
          long l1 = ((StatFs)localObject2).getBlockSize();
          long l2 = ((StatFs)localObject2).getBlockCount();
          localObject2 = new StatFs(h.getDataDirectory().getPath());
          long l3 = ((StatFs)localObject2).getBlockSize();
          locala.oSA = new long[] { l2 * l1, ((StatFs)localObject2).getAvailableBlocks() * l3 };
          oSE.hasInit = true;
        }
        a locala = oSE;
        GMTrace.o(13117903863808L, 97736);
        return locala;
      }
      finally {}
    }
    
    /* Error */
    private static String ro()
    {
      // Byte code:
      //   0: ldc2_w 120
      //   3: ldc 122
      //   5: invokestatic 34	com/tencent/gmtrace/GMTrace:i	(JI)V
      //   8: new 124	java/io/BufferedReader
      //   11: dup
      //   12: new 126	java/io/FileReader
      //   15: dup
      //   16: ldc -128
      //   18: invokespecial 129	java/io/FileReader:<init>	(Ljava/lang/String;)V
      //   21: invokespecial 132	java/io/BufferedReader:<init>	(Ljava/io/Reader;)V
      //   24: astore_1
      //   25: aload_1
      //   26: invokevirtual 135	java/io/BufferedReader:readLine	()Ljava/lang/String;
      //   29: invokevirtual 140	java/lang/String:trim	()Ljava/lang/String;
      //   32: astore_0
      //   33: aload_1
      //   34: invokevirtual 143	java/io/BufferedReader:close	()V
      //   37: ldc2_w 120
      //   40: ldc 122
      //   42: invokestatic 37	com/tencent/gmtrace/GMTrace:o	(JI)V
      //   45: aload_0
      //   46: areturn
      //   47: astore_1
      //   48: ldc -111
      //   50: astore_0
      //   51: ldc -109
      //   53: aload_1
      //   54: ldc -107
      //   56: iconst_0
      //   57: anewarray 4	java/lang/Object
      //   60: invokestatic 155	com/tencent/mm/sdk/platformtools/v:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
      //   63: goto -26 -> 37
      //   66: astore_1
      //   67: ldc -111
      //   69: astore_0
      //   70: ldc -109
      //   72: aload_1
      //   73: ldc -107
      //   75: iconst_0
      //   76: anewarray 4	java/lang/Object
      //   79: invokestatic 155	com/tencent/mm/sdk/platformtools/v:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
      //   82: goto -45 -> 37
      //   85: astore_1
      //   86: goto -16 -> 70
      //   89: astore_1
      //   90: goto -39 -> 51
      // Local variable table:
      //   start	length	slot	name	signature
      //   32	38	0	str	String
      //   24	10	1	localBufferedReader	java.io.BufferedReader
      //   47	7	1	localFileNotFoundException1	java.io.FileNotFoundException
      //   66	7	1	localIOException1	java.io.IOException
      //   85	1	1	localIOException2	java.io.IOException
      //   89	1	1	localFileNotFoundException2	java.io.FileNotFoundException
      // Exception table:
      //   from	to	target	type
      //   8	33	47	java/io/FileNotFoundException
      //   8	33	66	java/io/IOException
      //   33	37	85	java/io/IOException
      //   33	37	89	java/io/FileNotFoundException
    }
    
    private static int ru()
    {
      GMTrace.i(13118172299264L, 97738);
      try
      {
        int i = new File("/sys/devices/system/cpu/").listFiles(new a()).length;
        GMTrace.o(13118172299264L, 97738);
        return i;
      }
      catch (Exception localException)
      {
        v.printErrStackTrace("MicroMsg.ReportLogInfo", localException, "", new Object[0]);
        GMTrace.o(13118172299264L, 97738);
      }
      return 1;
    }
    
    final class a
      implements FileFilter
    {
      a()
      {
        GMTrace.i(13108911276032L, 97669);
        GMTrace.o(13108911276032L, 97669);
      }
      
      public final boolean accept(File paramFile)
      {
        GMTrace.i(13109045493760L, 97670);
        if (Pattern.matches("cpu[0-9]", paramFile.getName()))
        {
          GMTrace.o(13109045493760L, 97670);
          return true;
        }
        GMTrace.o(13109045493760L, 97670);
        return false;
      }
    }
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/plugin/report/service/f.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */