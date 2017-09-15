package com.tencent.mm.modelrecovery;

import com.tencent.gmtrace.GMTrace;
import com.tencent.mars.smc.IDKey;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.sdk.platformtools.aa;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.recovery.model.RecoveryStatusItem;
import com.tencent.recovery.report.RecoveryReporter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map.Entry;
import java.util.Set;

public final class b
{
  public static HashMap<String, Integer> hOp;
  
  static
  {
    GMTrace.i(4514279063552L, 33634);
    HashMap localHashMap = new HashMap();
    hOp = localHashMap;
    localHashMap.put(aa.getPackageName(), Integer.valueOf(0));
    hOp.put(aa.getPackageName() + ":push", Integer.valueOf(20));
    hOp.put(aa.getPackageName() + ":tools", Integer.valueOf(40));
    hOp.put(aa.getPackageName() + ":exdevice", Integer.valueOf(60));
    hOp.put(aa.getPackageName() + ":sandbox", Integer.valueOf(80));
    GMTrace.o(4514279063552L, 33634);
  }
  
  public static void Ih()
  {
    GMTrace.i(4513876410368L, 33631);
    Object localObject = RecoveryReporter.a(aa.getContext(), "ProcessStatus", RecoveryStatusItem.class);
    v.i("MicroMsg.Recovery.WXRecoveryReporter", "reportStatus " + ((List)localObject).size());
    HashMap localHashMap1 = new HashMap();
    HashMap localHashMap2 = new HashMap();
    Iterator localIterator = ((List)localObject).iterator();
    if (localIterator.hasNext())
    {
      RecoveryStatusItem localRecoveryStatusItem = (RecoveryStatusItem)localIterator.next();
      label117:
      b localb;
      label144:
      label173:
      int i;
      if (localHashMap1.containsKey(localRecoveryStatusItem.processName))
      {
        localObject = (a)localHashMap1.get(localRecoveryStatusItem.processName);
        if (!localHashMap2.containsKey(localRecoveryStatusItem.processName)) {
          break label256;
        }
        localb = (b)localHashMap2.get(localRecoveryStatusItem.processName);
        ((a)localObject).hOq += 1;
        if (localRecoveryStatusItem.wNX != 1) {
          break label267;
        }
        ((a)localObject).hOt += 1;
        i = 0;
        switch (localRecoveryStatusItem.wNZ)
        {
        }
      }
      for (;;)
      {
        if (i == 0) {
          v.i("MicroMsg.Recovery.WXRecoveryReporter", "recovery statics not set exception");
        }
        localHashMap1.put(localRecoveryStatusItem.processName, localObject);
        localHashMap2.put(localRecoveryStatusItem.processName, localb);
        break;
        localObject = new a();
        break label117;
        label256:
        localb = new b();
        break label144;
        label267:
        ((a)localObject).hOu += 1;
        break label173;
        if (localRecoveryStatusItem.wNX == 1)
        {
          localb.hOw += 1;
          switch (localRecoveryStatusItem.wOa)
          {
          default: 
            break;
          case 4096: 
            localb.hOE += 1;
            i = 1;
            break;
          case 65536: 
          case 1048576: 
            localb.hOA += 1;
            i = 1;
            break;
          }
        }
        else
        {
          localb.hOx += 1;
          switch (localRecoveryStatusItem.wOa)
          {
          default: 
            break;
          case 4096: 
            localb.hOF += 1;
            i = 1;
            break;
          case 65536: 
          case 1048576: 
            localb.hOB += 1;
            i = 1;
            continue;
            if (localRecoveryStatusItem.wNX == 1)
            {
              localb.hOy += 1;
              switch (localRecoveryStatusItem.wOa)
              {
              default: 
                break;
              case 4096: 
                localb.hOG += 1;
                i = 1;
                break;
              case 65536: 
              case 1048576: 
                localb.hOC += 1;
                i = 1;
                break;
              }
            }
            else
            {
              localb.hOz += 1;
              switch (localRecoveryStatusItem.wOa)
              {
              default: 
                break;
              case 4096: 
                localb.hOH += 1;
                i = 1;
                break;
              case 65536: 
              case 1048576: 
                localb.hOD += 1;
                i = 1;
              }
            }
            break;
          }
        }
      }
    }
    b(localHashMap1);
    c(localHashMap2);
    RecoveryReporter.bq(aa.getContext(), "ProcessStatus");
    GMTrace.o(4513876410368L, 33631);
  }
  
  private static void b(HashMap<String, a> paramHashMap)
  {
    GMTrace.i(4514010628096L, 33632);
    ArrayList localArrayList = new ArrayList();
    Iterator localIterator = paramHashMap.entrySet().iterator();
    while (localIterator.hasNext())
    {
      Object localObject = (Map.Entry)localIterator.next();
      if (hOp.containsKey(((Map.Entry)localObject).getKey()))
      {
        int i = ((Integer)hOp.get(((Map.Entry)localObject).getKey())).intValue();
        localObject = (a)((Map.Entry)localObject).getValue();
        IDKey localIDKey;
        if (((a)localObject).hOq > 0)
        {
          localIDKey = new IDKey();
          localIDKey.SetID(424);
          localIDKey.SetKey(i + 0);
          localIDKey.SetValue(((a)localObject).hOq);
          localArrayList.add(localIDKey);
        }
        if (((a)localObject).hOr > 0)
        {
          localIDKey = new IDKey();
          localIDKey.SetID(424);
          localIDKey.SetKey(i + 1);
          localIDKey.SetValue(((a)localObject).hOr);
          localArrayList.add(localIDKey);
        }
        if (((a)localObject).hOs > 0)
        {
          localIDKey = new IDKey();
          localIDKey.SetID(424);
          localIDKey.SetKey(i + 2);
          localIDKey.SetValue(((a)localObject).hOs);
          localArrayList.add(localIDKey);
        }
        if (((a)localObject).hOt > 0)
        {
          localIDKey = new IDKey();
          localIDKey.SetID(424);
          localIDKey.SetKey(i + 3);
          localIDKey.SetValue(((a)localObject).hOt);
          localArrayList.add(localIDKey);
        }
        if (((a)localObject).hOu > 0)
        {
          localIDKey = new IDKey();
          localIDKey.SetID(424);
          localIDKey.SetKey(i + 4);
          localIDKey.SetValue(((a)localObject).hOu);
          localArrayList.add(localIDKey);
        }
        if (((a)localObject).hOv > 0)
        {
          localIDKey = new IDKey();
          localIDKey.SetID(424);
          localIDKey.SetKey(i + 5);
          localIDKey.SetValue(((a)localObject).hOv);
          localArrayList.add(localIDKey);
        }
      }
    }
    if (localArrayList.size() > 0) {
      g.oSF.b(localArrayList, true);
    }
    v.i("MicroMsg.Recovery.WXRecoveryReporter", "report recovery generalObj %s %s", new Object[] { aa.um(), paramHashMap.toString() });
    GMTrace.o(4514010628096L, 33632);
  }
  
  private static void c(HashMap<String, b> paramHashMap)
  {
    GMTrace.i(4514144845824L, 33633);
    ArrayList localArrayList = new ArrayList();
    Iterator localIterator = paramHashMap.entrySet().iterator();
    while (localIterator.hasNext())
    {
      Object localObject = (Map.Entry)localIterator.next();
      if (hOp.containsKey(((Map.Entry)localObject).getKey()))
      {
        int i = ((Integer)hOp.get(((Map.Entry)localObject).getKey())).intValue();
        localObject = (b)((Map.Entry)localObject).getValue();
        IDKey localIDKey;
        if (((b)localObject).hOw > 0)
        {
          localIDKey = new IDKey();
          localIDKey.SetID(442);
          localIDKey.SetKey(i + 0);
          localIDKey.SetValue(((b)localObject).hOw);
          localArrayList.add(localIDKey);
        }
        if (((b)localObject).hOx > 0)
        {
          localIDKey = new IDKey();
          localIDKey.SetID(442);
          localIDKey.SetKey(i + 1);
          localIDKey.SetValue(((b)localObject).hOx);
          localArrayList.add(localIDKey);
        }
        if (((b)localObject).hOy > 0)
        {
          localIDKey = new IDKey();
          localIDKey.SetID(442);
          localIDKey.SetKey(i + 2);
          localIDKey.SetValue(((b)localObject).hOy);
          localArrayList.add(localIDKey);
        }
        if (((b)localObject).hOz > 0)
        {
          localIDKey = new IDKey();
          localIDKey.SetID(442);
          localIDKey.SetKey(i + 3);
          localIDKey.SetValue(((b)localObject).hOz);
          localArrayList.add(localIDKey);
        }
        if (((b)localObject).hOA > 0)
        {
          localIDKey = new IDKey();
          localIDKey.SetID(442);
          localIDKey.SetKey(i + 4);
          localIDKey.SetValue(((b)localObject).hOA);
          localArrayList.add(localIDKey);
        }
        if (((b)localObject).hOB > 0)
        {
          localIDKey = new IDKey();
          localIDKey.SetID(442);
          localIDKey.SetKey(i + 5);
          localIDKey.SetValue(((b)localObject).hOB);
          localArrayList.add(localIDKey);
        }
        if (((b)localObject).hOC > 0)
        {
          localIDKey = new IDKey();
          localIDKey.SetID(442);
          localIDKey.SetKey(i + 6);
          localIDKey.SetValue(((b)localObject).hOC);
          localArrayList.add(localIDKey);
        }
        if (((b)localObject).hOD > 0)
        {
          localIDKey = new IDKey();
          localIDKey.SetID(442);
          localIDKey.SetKey(i + 7);
          localIDKey.SetValue(((b)localObject).hOD);
          localArrayList.add(localIDKey);
        }
        if (((b)localObject).hOE > 0)
        {
          localIDKey = new IDKey();
          localIDKey.SetID(442);
          localIDKey.SetKey(i + 8);
          localIDKey.SetValue(((b)localObject).hOE);
          localArrayList.add(localIDKey);
        }
        if (((b)localObject).hOF > 0)
        {
          localIDKey = new IDKey();
          localIDKey.SetID(442);
          localIDKey.SetKey(i + 9);
          localIDKey.SetValue(((b)localObject).hOF);
          localArrayList.add(localIDKey);
        }
        if (((b)localObject).hOG > 0)
        {
          localIDKey = new IDKey();
          localIDKey.SetID(442);
          localIDKey.SetKey(i + 10);
          localIDKey.SetValue(((b)localObject).hOG);
          localArrayList.add(localIDKey);
        }
        if (((b)localObject).hOH > 0)
        {
          localIDKey = new IDKey();
          localIDKey.SetID(442);
          localIDKey.SetKey(i + 11);
          localIDKey.SetValue(((b)localObject).hOH);
          localArrayList.add(localIDKey);
        }
      }
    }
    if (localArrayList.size() > 0) {
      g.oSF.b(localArrayList, true);
    }
    v.i("MicroMsg.Recovery.WXRecoveryReporter", "report recovery statusObj %s %s", new Object[] { aa.um(), paramHashMap.toString() });
    GMTrace.o(4514144845824L, 33633);
  }
  
  public static final class a
  {
    public int hOq;
    public int hOr;
    public int hOs;
    public int hOt;
    public int hOu;
    public int hOv;
    
    public a()
    {
      GMTrace.i(4512131579904L, 33618);
      GMTrace.o(4512131579904L, 33618);
    }
    
    public final String toString()
    {
      GMTrace.i(4512265797632L, 33619);
      Object localObject = new StringBuffer();
      if (this.hOq > 0) {
        ((StringBuffer)localObject).append("totalCount:" + this.hOq + " ");
      }
      if (this.hOr > 0) {
        ((StringBuffer)localObject).append("enterRecoveryCount:" + this.hOr + " ");
      }
      if (this.hOs > 0) {
        ((StringBuffer)localObject).append("existRecoveryProcessCount:" + this.hOs + " ");
      }
      if (this.hOt > 0) {
        ((StringBuffer)localObject).append("foregroundExpCount:" + this.hOt + " ");
      }
      if (this.hOu > 0) {
        ((StringBuffer)localObject).append("backgroundExpCount:" + this.hOu + " ");
      }
      if (this.hOv > 0) {
        ((StringBuffer)localObject).append("normalCount:" + this.hOv + " ");
      }
      localObject = ((StringBuffer)localObject).toString();
      GMTrace.o(4512265797632L, 33619);
      return (String)localObject;
    }
  }
  
  public static final class b
  {
    public int hOA;
    public int hOB;
    public int hOC;
    public int hOD;
    public int hOE;
    public int hOF;
    public int hOG;
    public int hOH;
    public int hOw;
    public int hOx;
    public int hOy;
    public int hOz;
    
    public b()
    {
      GMTrace.i(4511863144448L, 33616);
      GMTrace.o(4511863144448L, 33616);
    }
    
    public final String toString()
    {
      GMTrace.i(4511997362176L, 33617);
      Object localObject = new StringBuffer();
      if (this.hOw > 0) {
        ((StringBuffer)localObject).append("appForegroundExpCount:" + this.hOw + " ");
      }
      if (this.hOx > 0) {
        ((StringBuffer)localObject).append("appBackgroundExpCount:" + this.hOx + " ");
      }
      if (this.hOy > 0) {
        ((StringBuffer)localObject).append("componentForegroundExpCount:" + this.hOy + " ");
      }
      if (this.hOz > 0) {
        ((StringBuffer)localObject).append("componentBackgroundExpCount:" + this.hOz + " ");
      }
      if (this.hOA > 0) {
        ((StringBuffer)localObject).append("appForegroundCrashOrAnrExpCount:" + this.hOA + " ");
      }
      if (this.hOB > 0) {
        ((StringBuffer)localObject).append("appBackgroundCrashOrAnrExpCount:" + this.hOB + " ");
      }
      if (this.hOC > 0) {
        ((StringBuffer)localObject).append("componentForegroundCrashOrAnrExpCount:" + this.hOC + " ");
      }
      if (this.hOD > 0) {
        ((StringBuffer)localObject).append("componentBackgroundCrashOrAnrExpCount:" + this.hOD + " ");
      }
      if (this.hOE > 0) {
        ((StringBuffer)localObject).append("appForegroundTimeoutExpCount:" + this.hOE + " ");
      }
      if (this.hOF > 0) {
        ((StringBuffer)localObject).append("appBackgroundTimeoutExpCount:" + this.hOF + " ");
      }
      if (this.hOG > 0) {
        ((StringBuffer)localObject).append("componentForegroundTimeoutExpCount:" + this.hOG + " ");
      }
      if (this.hOH > 0) {
        ((StringBuffer)localObject).append("componentBackgroundTimeoutExpCount:" + this.hOH + " ");
      }
      localObject = ((StringBuffer)localObject).toString();
      GMTrace.o(4511997362176L, 33617);
      return (String)localObject;
    }
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/modelrecovery/b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */