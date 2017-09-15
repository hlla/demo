package com.tencent.mm.u;

import com.tencent.gmtrace.GMTrace;
import com.tencent.mm.platformtools.n;
import com.tencent.mm.plugin.messenger.foundation.a.l;
import com.tencent.mm.plugin.messenger.foundation.a.m;
import com.tencent.mm.plugin.report.c;
import com.tencent.mm.protocal.c.bu;
import com.tencent.mm.sdk.platformtools.av;
import com.tencent.mm.sdk.platformtools.bf;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.storage.au;
import com.tencent.mm.y.d;
import com.tencent.mm.y.d.a;
import com.tencent.mm.y.d.b;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public final class bp
  implements d
{
  private Map<String, List<a>> hnT;
  private Map<String, List<a>> hnU;
  private Map<String, List<m>> hnV;
  public Map<String, l> hnW;
  
  public bp()
  {
    GMTrace.i(628138967040L, 4680);
    this.hnT = new HashMap();
    this.hnU = new HashMap();
    this.hnV = new HashMap();
    this.hnW = new ConcurrentHashMap();
    GMTrace.o(628138967040L, 4680);
  }
  
  @Deprecated
  private void a(String paramString, d.a parama, boolean paramBoolean)
  {
    GMTrace.i(628675837952L, 4684);
    if (paramBoolean) {}
    for (Map localMap = this.hnU;; localMap = this.hnT)
    {
      paramString = (List)localMap.get(paramString);
      if ((paramString != null) && (!paramString.isEmpty())) {
        break;
      }
      v.w("MicroMsg.SysCmdMsgExtension", "listener list is empty, return now");
      GMTrace.o(628675837952L, 4684);
      return;
    }
    v.i("MicroMsg.SysCmdMsgExtension", "listener list size is %d", new Object[] { Integer.valueOf(paramString.size()) });
    paramString = paramString.iterator();
    while (paramString.hasNext()) {
      ((a)paramString.next()).a(parama);
    }
    GMTrace.o(628675837952L, 4684);
  }
  
  public final void a(String paramString, l paraml)
  {
    GMTrace.i(14607720644608L, 108836);
    if ((bf.mA(paramString)) || (paraml == null))
    {
      GMTrace.o(14607720644608L, 108836);
      return;
    }
    if (this.hnW.containsKey(paramString)) {
      v.w("MicroMsg.SysCmdMsgExtension", "NewXmlConsumer for %s has exist! %s", new Object[] { paramString, bf.bJP() });
    }
    this.hnW.put(paramString, paraml);
    GMTrace.o(14607720644608L, 108836);
  }
  
  public final void a(String paramString, m paramm)
  {
    GMTrace.i(16766478581760L, 124920);
    if ((bf.mA(paramString)) || (paramm == null))
    {
      GMTrace.o(16766478581760L, 124920);
      return;
    }
    for (;;)
    {
      Object localObject;
      synchronized (this.hnV)
      {
        localObject = (List)this.hnV.get(paramString);
        if (localObject != null) {
          break label122;
        }
        localObject = new LinkedList();
        this.hnV.put(paramString, localObject);
        paramString = (String)localObject;
      }
      try
      {
        if (!paramString.contains(paramm)) {
          paramString.add(paramm);
        }
        GMTrace.o(16766478581760L, 124920);
        return;
      }
      finally {}
      paramString = finally;
      throw paramString;
      label122:
      paramString = (String)localObject;
    }
  }
  
  @Deprecated
  public final void a(String paramString, a parama, boolean paramBoolean)
  {
    GMTrace.i(628273184768L, 4681);
    if ((bf.mA(paramString)) || (parama == null))
    {
      GMTrace.o(628273184768L, 4681);
      return;
    }
    if (paramBoolean) {}
    for (Map localMap = this.hnU;; localMap = this.hnT)
    {
      List localList = (List)localMap.get(paramString);
      Object localObject = localList;
      if (localList == null)
      {
        localObject = new LinkedList();
        localMap.put(paramString, localObject);
      }
      if (!((List)localObject).contains(parama)) {
        ((List)localObject).add(parama);
      }
      GMTrace.o(628273184768L, 4681);
      return;
    }
  }
  
  public final d.b b(d.a parama)
  {
    GMTrace.i(628541620224L, 4683);
    Object localObject1 = parama.hsc;
    String str;
    switch (((bu)localObject1).mrC)
    {
    default: 
      v.w("MicroMsg.SysCmdMsgExtension", "cmdAM msgType is %d, ignore, return now", new Object[] { Integer.valueOf(((bu)localObject1).mrC) });
      GMTrace.o(628541620224L, 4683);
      return null;
    case 10001: 
      str = n.a(((bu)localObject1).tdx);
      n.a(((bu)localObject1).tdz);
      a(str, parama, false);
      c.oRz.A(10395, String.valueOf(((bu)localObject1).tdE));
      GMTrace.o(628541620224L, 4683);
      return null;
    }
    Object localObject2 = n.a(((bu)localObject1).tdz);
    if (bf.mA((String)localObject2))
    {
      v.e("MicroMsg.SysCmdMsgExtension", "null msg content");
      GMTrace.o(628541620224L, 4683);
      return null;
    }
    if (((String)localObject2).startsWith("~SEMI_XML~"))
    {
      localObject1 = av.PE((String)localObject2);
      if (localObject1 == null)
      {
        v.e("MicroMsg.SysCmdMsgExtension", "SemiXml values is null, msgContent %s", new Object[] { localObject2 });
        GMTrace.o(628541620224L, 4683);
        return null;
      }
      str = "brand_service";
      v.d("MicroMsg.SysCmdMsgExtension", "recieve a syscmd_newxml %s subType %s", new Object[] { localObject2, str });
      if (str != null) {
        a(str, parama, true);
      }
    }
    else
    {
      for (;;)
      {
        synchronized (this.hnV)
        {
          localObject2 = (List)this.hnV.get(str);
          if ((localObject2 == null) || (((List)localObject2).isEmpty()))
          {
            v.w("MicroMsg.SysCmdMsgExtension", "listener list is empty, return now");
            localObject2 = (l)this.hnW.get(str);
            if (localObject2 == null) {
              break;
            }
            parama = ((l)localObject2).a(str, (Map)localObject1, parama);
            GMTrace.o(628541620224L, 4683);
            return parama;
            int i = ((String)localObject2).indexOf("<sysmsg");
            if (i == -1)
            {
              v.e("MicroMsg.SysCmdMsgExtension", "msgContent not start with <sysmsg");
              GMTrace.o(628541620224L, 4683);
              return null;
            }
            localObject1 = ((String)localObject2).substring(i);
            v.d("MicroMsg.SysCmdMsgExtension", "oneliang, msg content:%s,sub content:%s", new Object[] { localObject2, localObject1 });
            localObject1 = bg.q((String)localObject1, "sysmsg");
            if (localObject1 == null)
            {
              v.e("MicroMsg.SysCmdMsgExtension", "XmlParser values is null, msgContent %s", new Object[] { localObject2 });
              GMTrace.o(628541620224L, 4683);
              return null;
            }
            str = (String)((Map)localObject1).get(".sysmsg.$type");
          }
        }
        v.i("MicroMsg.SysCmdMsgExtension", "listener list size is %d", new Object[] { Integer.valueOf(((List)localObject2).size()) });
        try
        {
          ??? = ((List)localObject2).iterator();
          while (((Iterator)???).hasNext()) {
            ((m)((Iterator)???).next()).b(str, (Map)localObject1);
          }
        }
        finally {}
      }
      v.e("MicroMsg.SysCmdMsgExtension", "no NewXmlConsumer to consume cmd %s!!", new Object[] { str });
    }
    GMTrace.o(628541620224L, 4683);
    return null;
  }
  
  public final void b(String paramString, m paramm)
  {
    GMTrace.i(16766612799488L, 124921);
    if ((bf.mA(paramString)) || (paramm == null))
    {
      GMTrace.o(16766612799488L, 124921);
      return;
    }
    synchronized (this.hnV)
    {
      paramString = (List)this.hnV.get(paramString);
      if (paramString == null) {}
    }
    GMTrace.o(16766612799488L, 124921);
  }
  
  @Deprecated
  public final void b(String paramString, a parama, boolean paramBoolean)
  {
    GMTrace.i(628407402496L, 4682);
    if ((bf.mA(paramString)) || (parama == null))
    {
      GMTrace.o(628407402496L, 4682);
      return;
    }
    if (paramBoolean) {}
    for (Map localMap = this.hnU;; localMap = this.hnT)
    {
      paramString = (List)localMap.get(paramString);
      if (paramString != null) {
        paramString.remove(parama);
      }
      GMTrace.o(628407402496L, 4682);
      return;
    }
  }
  
  public final void h(au paramau)
  {
    GMTrace.i(628810055680L, 4685);
    GMTrace.o(628810055680L, 4685);
  }
  
  public static abstract interface a
  {
    public abstract void a(d.a parama);
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/u/bp.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */