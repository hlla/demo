package com.tencent.mm.sdk.platformtools;

import com.tencent.gmtrace.GMTrace;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import junit.framework.Assert;

public final class y
{
  public static b gJr;
  private static int uqZ;
  public static Map<Integer, y> urb;
  private static boolean urd;
  public static boolean ure;
  public long hpD;
  private final boolean nHV;
  public long roN;
  public final int ura;
  private final a urc;
  
  static
  {
    GMTrace.i(13870328446976L, 103342);
    urb = new HashMap();
    urd = false;
    GMTrace.o(13870328446976L, 103342);
  }
  
  public y(a parama)
  {
    GMTrace.i(13869791576064L, 103338);
    this.hpD = 0L;
    this.roN = 0L;
    Assert.assertTrue("bumper not initialized", urd);
    this.urc = parama;
    this.nHV = true;
    if (uqZ >= 8192) {
      uqZ = 0;
    }
    int i = uqZ + 1;
    uqZ = i;
    this.ura = i;
    GMTrace.o(13869791576064L, 103338);
  }
  
  public static void a(b paramb)
  {
    GMTrace.i(13869523140608L, 103336);
    urd = true;
    gJr = paramb;
    GMTrace.o(13869523140608L, 103336);
  }
  
  public static long bII()
  {
    GMTrace.i(13869925793792L, 103339);
    ure = false;
    LinkedList localLinkedList = new LinkedList();
    Object localObject = new HashSet();
    ((Set)localObject).addAll(urb.keySet());
    localObject = ((Set)localObject).iterator();
    long l1 = Long.MAX_VALUE;
    if (((Iterator)localObject).hasNext())
    {
      Integer localInteger = (Integer)((Iterator)localObject).next();
      y localy = (y)urb.get(localInteger);
      if (localy == null) {
        break label289;
      }
      long l3 = bf.aB(localy.hpD);
      long l2 = l3;
      if (l3 < 0L) {
        l2 = 0L;
      }
      if (l2 > localy.roN)
      {
        if ((!localy.urc.oQ()) || (!localy.nHV)) {
          localLinkedList.add(localInteger);
        }
        for (;;)
        {
          localy.hpD = bf.NB();
          break;
          l1 = localy.roN;
        }
      }
      if (localy.roN - l2 >= l1) {
        break label289;
      }
      l1 = localy.roN - l2;
    }
    label289:
    for (;;)
    {
      break;
      int i = 0;
      while (i < localLinkedList.size())
      {
        urb.remove(localLinkedList.get(i));
        i += 1;
      }
      if ((!ure) && (l1 == Long.MAX_VALUE) && (gJr != null))
      {
        gJr.cancel();
        v.v("MicroMsg.MAlarmHandler", "cancel bumper for no more handler");
      }
      GMTrace.o(13869925793792L, 103339);
      return l1;
    }
  }
  
  public static boolean et(long paramLong)
  {
    GMTrace.i(13870194229248L, 103341);
    v.d("MicroMsg.MAlarmHandler", "check need prepare: check=" + paramLong);
    Iterator localIterator = urb.entrySet().iterator();
    long l1 = Long.MAX_VALUE;
    while (localIterator.hasNext())
    {
      y localy = (y)((Map.Entry)localIterator.next()).getValue();
      if (localy == null) {
        break label178;
      }
      long l3 = bf.aB(localy.hpD);
      long l2 = l3;
      if (l3 < 0L) {
        l2 = 0L;
      }
      if (l2 > localy.roN)
      {
        l1 = localy.roN;
      }
      else
      {
        if (localy.roN - l2 >= l1) {
          break label178;
        }
        l1 = localy.roN - l2;
      }
    }
    label178:
    for (;;)
    {
      break;
      if (l1 > paramLong)
      {
        GMTrace.o(13870194229248L, 103341);
        return true;
      }
      GMTrace.o(13870194229248L, 103341);
      return false;
    }
  }
  
  public final void KI()
  {
    GMTrace.i(13870060011520L, 103340);
    urb.remove(Integer.valueOf(this.ura));
    GMTrace.o(13870060011520L, 103340);
  }
  
  protected final void finalize()
  {
    GMTrace.i(13869657358336L, 103337);
    KI();
    super.finalize();
    GMTrace.o(13869657358336L, 103337);
  }
  
  public static abstract interface a
  {
    public abstract boolean oQ();
  }
  
  public static abstract interface b
  {
    public abstract void cancel();
    
    public abstract void prepare();
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/sdk/platformtools/y.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */