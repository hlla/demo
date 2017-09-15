package com.tencent.mm.u;

import com.tencent.gmtrace.GMTrace;
import com.tencent.mm.bj.g.c;
import com.tencent.mm.sdk.platformtools.bf;
import com.tencent.mm.sdk.platformtools.v;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import junit.framework.Assert;

@Deprecated
public final class bn
{
  public static an hnM;
  private Map<String, am> hnK;
  private Map<am, Boolean> hnL;
  private String hnN;
  
  public bn()
  {
    GMTrace.i(668672720896L, 4982);
    this.hnK = new HashMap();
    this.hnL = new HashMap();
    this.hnN = "";
    GMTrace.o(668672720896L, 4982);
  }
  
  public final boolean a(String paramString, am paramam)
  {
    try
    {
      GMTrace.i(669612244992L, 4989);
      if (!bf.mA(this.hnN)) {
        Assert.assertTrue("REFUSE to addSubCore doing:" + this.hnN, false);
      }
      this.hnK.put(paramString, paramam);
      GMTrace.o(669612244992L, 4989);
      return true;
    }
    finally {}
  }
  
  public final void aM(boolean paramBoolean)
  {
    long l1;
    try
    {
      GMTrace.i(669075374080L, 4985);
      l1 = bf.NA();
      this.hnN = "onAccountPostReset";
      Iterator localIterator = this.hnK.entrySet().iterator();
      while (localIterator.hasNext())
      {
        Map.Entry localEntry = (Map.Entry)localIterator.next();
        long l2 = bf.NA();
        ((am)localEntry.getValue()).aM(paramBoolean);
        this.hnL.put(localEntry.getValue(), Boolean.valueOf(true));
        v.i("MicroMsg.MMCore.SubCoreMap", "onSubCoreAccountPostReset post:%s %d", new Object[] { localEntry.getKey(), Long.valueOf(bf.aA(l2)) });
      }
      this.hnN = "";
    }
    finally {}
    v.i("MicroMsg.MMCore.SubCoreMap", "onSubCoreAccountPostReset finish Count:%d time:%d", new Object[] { Integer.valueOf(this.hnK.size()), Long.valueOf(bf.aA(l1)) });
    GMTrace.o(669075374080L, 4985);
  }
  
  public final void aN(boolean paramBoolean)
  {
    long l1;
    try
    {
      GMTrace.i(668941156352L, 4984);
      l1 = bf.NA();
      this.hnN = "onSdcardMount";
      Iterator localIterator = this.hnK.entrySet().iterator();
      while (localIterator.hasNext())
      {
        Map.Entry localEntry = (Map.Entry)localIterator.next();
        if (bf.b((Boolean)this.hnL.get(localEntry.getValue()), false))
        {
          long l2 = bf.NA();
          ((am)localEntry.getValue()).aN(paramBoolean);
          v.i("MicroMsg.MMCore.SubCoreMap", "onSdcardMount %s time:%d", new Object[] { localEntry.getKey(), Long.valueOf(bf.aA(l2)) });
        }
      }
      this.hnN = "";
    }
    finally {}
    v.i("MicroMsg.MMCore.SubCoreMap", "onSubCoreSdcardMount finish Count:%d time:%d", new Object[] { Integer.valueOf(this.hnK.size()), Long.valueOf(bf.aA(l1)) });
    GMTrace.o(668941156352L, 4984);
  }
  
  public final void fl(int paramInt)
  {
    try
    {
      GMTrace.i(669478027264L, 4988);
      this.hnN = "clearSubCorePluginData";
      Iterator localIterator = this.hnK.entrySet().iterator();
      while (localIterator.hasNext()) {
        ((am)((Map.Entry)localIterator.next()).getValue()).eD(paramInt);
      }
      this.hnN = "";
    }
    finally {}
    GMTrace.o(669478027264L, 4988);
  }
  
  public final am gs(String paramString)
  {
    GMTrace.i(669746462720L, 4990);
    paramString = (am)this.hnK.get(paramString);
    GMTrace.o(669746462720L, 4990);
    return paramString;
  }
  
  /* Error */
  public final void zQ()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: ldc2_w 189
    //   5: sipush 4983
    //   8: invokestatic 26	com/tencent/gmtrace/GMTrace:i	(JI)V
    //   11: aload_0
    //   12: getfield 37	com/tencent/mm/u/bn:hnN	Ljava/lang/String;
    //   15: invokestatic 51	com/tencent/mm/sdk/platformtools/bf:mA	(Ljava/lang/String;)Z
    //   18: ifne +33 -> 51
    //   21: ldc 125
    //   23: ldc -64
    //   25: iconst_1
    //   26: anewarray 4	java/lang/Object
    //   29: dup
    //   30: iconst_0
    //   31: aload_0
    //   32: getfield 37	com/tencent/mm/u/bn:hnN	Ljava/lang/String;
    //   35: aastore
    //   36: invokestatic 195	com/tencent/mm/sdk/platformtools/v:w	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   39: ldc2_w 189
    //   42: sipush 4983
    //   45: invokestatic 40	com/tencent/gmtrace/GMTrace:o	(JI)V
    //   48: aload_0
    //   49: monitorexit
    //   50: return
    //   51: aload_0
    //   52: getfield 31	com/tencent/mm/u/bn:hnK	Ljava/util/Map;
    //   55: invokeinterface 198 1 0
    //   60: aload_0
    //   61: getfield 33	com/tencent/mm/u/bn:hnL	Ljava/util/Map;
    //   64: invokeinterface 198 1 0
    //   69: getstatic 200	com/tencent/mm/u/bn:hnM	Lcom/tencent/mm/u/an;
    //   72: ifnull +41 -> 113
    //   75: aload_0
    //   76: getstatic 200	com/tencent/mm/u/bn:hnM	Lcom/tencent/mm/u/an;
    //   79: invokeinterface 206 1 0
    //   84: putfield 31	com/tencent/mm/u/bn:hnK	Ljava/util/Map;
    //   87: ldc 125
    //   89: ldc -48
    //   91: iconst_1
    //   92: anewarray 4	java/lang/Object
    //   95: dup
    //   96: iconst_0
    //   97: aload_0
    //   98: getfield 31	com/tencent/mm/u/bn:hnK	Ljava/util/Map;
    //   101: invokeinterface 150 1 0
    //   106: invokestatic 155	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   109: aastore
    //   110: invokestatic 144	com/tencent/mm/sdk/platformtools/v:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   113: ldc2_w 189
    //   116: sipush 4983
    //   119: invokestatic 40	com/tencent/gmtrace/GMTrace:o	(JI)V
    //   122: goto -74 -> 48
    //   125: astore_1
    //   126: aload_0
    //   127: monitorexit
    //   128: aload_1
    //   129: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	130	0	this	bn
    //   125	4	1	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   2	48	125	finally
    //   51	113	125	finally
    //   113	122	125	finally
  }
  
  public final void zR()
  {
    long l1;
    try
    {
      GMTrace.i(669209591808L, 4986);
      l1 = bf.NA();
      this.hnN = "releaseSubCore";
      Iterator localIterator = this.hnK.entrySet().iterator();
      while (localIterator.hasNext())
      {
        Map.Entry localEntry = (Map.Entry)localIterator.next();
        if (bf.b((Boolean)this.hnL.get(localEntry.getValue()), false))
        {
          long l2 = bf.NA();
          v.i("MicroMsg.MMCore.SubCoreMap", "releaseSubCore release:%s begin...", new Object[] { localEntry.getKey() });
          ((am)localEntry.getValue()).onAccountRelease();
          v.i("MicroMsg.MMCore.SubCoreMap", "releaseSubCore release:%s %d", new Object[] { localEntry.getKey(), Long.valueOf(bf.aA(l2)) });
        }
      }
      this.hnN = "";
    }
    finally {}
    v.i("MicroMsg.MMCore.SubCoreMap", "releaseSubCore finish Count:%d time:%d", new Object[] { Integer.valueOf(this.hnK.size()), Long.valueOf(bf.aA(l1)) });
    GMTrace.o(669209591808L, 4986);
  }
  
  public final Map<Integer, g.c> zS()
  {
    try
    {
      GMTrace.i(669343809536L, 4987);
      this.hnN = "getSubCoreBaseDBFacotries";
      HashMap localHashMap = new HashMap();
      Iterator localIterator = this.hnK.entrySet().iterator();
      while (localIterator.hasNext())
      {
        Map.Entry localEntry = (Map.Entry)localIterator.next();
        if (((am)localEntry.getValue()).uh() != null) {
          localHashMap.putAll(((am)localEntry.getValue()).uh());
        }
      }
      this.hnN = "";
    }
    finally {}
    GMTrace.o(669343809536L, 4987);
    return localMap;
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/u/bn.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */