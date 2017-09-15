package com.tencent.mm.p;

import com.tencent.gmtrace.GMTrace;
import com.tencent.mm.platformtools.n;
import com.tencent.mm.protocal.c.bu;
import com.tencent.mm.sdk.platformtools.aa;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.sdk.platformtools.bf;
import com.tencent.mm.sdk.platformtools.v;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArrayList;

public final class c
{
  public volatile boolean gUj;
  private volatile boolean gUk;
  public List<Map<String, String>> gUl;
  
  public c()
  {
    GMTrace.i(4504481169408L, 33561);
    this.gUj = false;
    this.gUk = false;
    this.gUl = new CopyOnWriteArrayList();
    GMTrace.o(4504481169408L, 33561);
  }
  
  private static bu a(bu parambu)
  {
    boolean bool = true;
    GMTrace.i(4504883822592L, 33564);
    if (parambu == null)
    {
      GMTrace.o(4504883822592L, 33564);
      return null;
    }
    Object localObject = parambu.tdx;
    int i = parambu.mrC;
    if (parambu.tdz == null) {}
    for (;;)
    {
      v.i("MicroMsg.FunctionMsgFetcher", "processAddMsg, fromUser: %s, msgType: %s, content==null: %s", new Object[] { localObject, Integer.valueOf(i), Boolean.valueOf(bool) });
      localObject = bf.mz(n.a(parambu.tdx));
      if ("readerapp".equals(localObject))
      {
        parambu.tdx = n.mw("newsapp");
        parambu.mrC = 12399999;
      }
      if (("blogapp".equals(localObject)) || ("newsapp".equals(localObject))) {
        parambu.mrC = 12399999;
      }
      GMTrace.o(4504883822592L, 33564);
      return parambu;
      bool = false;
    }
  }
  
  public static void b(List<d> paramList, boolean paramBoolean)
  {
    GMTrace.i(4505420693504L, 33568);
    if (paramList != null)
    {
      Object localObject2;
      try
      {
        if (paramList.size() <= 0) {
          break label328;
        }
        localObject1 = new ArrayList();
        paramList = paramList.iterator();
        while (paramList.hasNext())
        {
          localObject2 = (d)paramList.next();
          if (((d)localObject2).field_needShow)
          {
            ((d)localObject2).b(a(((d)localObject2).field_addMsg));
            ((List)localObject1).add(localObject2);
          }
        }
      }
      catch (Exception paramList)
      {
        v.e("MicroMsg.FunctionMsgFetcher", "callbackToUpdate error: %s", new Object[] { paramList.getMessage() });
        GMTrace.o(4505420693504L, 33568);
        return;
      }
      tmp125_122[0] = Integer.valueOf(((List)localObject1).size());
      Object[] tmp137_125 = tmp125_122;
      tmp137_125[1] = Boolean.valueOf(paramBoolean);
      v.d("MicroMsg.FunctionMsgFetcher", "callbackToUpdate, msgList.size: %s, isShow: %s", tmp137_125);
      paramList = c((Collection)localObject1);
      Object localObject1 = paramList.keySet().iterator();
      while (((Iterator)localObject1).hasNext())
      {
        int i = ((Integer)((Iterator)localObject1).next()).intValue();
        Object localObject3 = (List)paramList.get(Integer.valueOf(i));
        localObject2 = new HashMap();
        localObject3 = ((List)localObject3).iterator();
        while (((Iterator)localObject3).hasNext())
        {
          d locald = (d)((Iterator)localObject3).next();
          ((Map)localObject2).put(locald.field_functionmsgid, locald.field_addMsg);
        }
        localObject3 = (List)i.ue().gUA.get(Integer.valueOf(i));
        if (localObject3 != null)
        {
          localObject3 = ((List)localObject3).iterator();
          while (((Iterator)localObject3).hasNext()) {
            ((f)((Iterator)localObject3).next()).a(0, (Map)localObject2, paramBoolean);
          }
        }
      }
    }
    label328:
    GMTrace.o(4505420693504L, 33568);
  }
  
  private static Map<Integer, List<d>> c(Collection<d> paramCollection)
  {
    GMTrace.i(4505554911232L, 33569);
    HashMap localHashMap = new HashMap();
    Iterator localIterator = paramCollection.iterator();
    while (localIterator.hasNext())
    {
      d locald = (d)localIterator.next();
      if (locald.field_addMsg != null)
      {
        List localList = (List)localHashMap.get(Integer.valueOf(locald.field_addMsg.mrC));
        paramCollection = localList;
        if (localList == null) {
          paramCollection = new ArrayList();
        }
        paramCollection.add(locald);
        localHashMap.put(Integer.valueOf(locald.field_addMsg.mrC), paramCollection);
      }
    }
    GMTrace.o(4505554911232L, 33569);
    return localHashMap;
  }
  
  public final boolean tW()
  {
    boolean bool;
    try
    {
      GMTrace.i(4504749604864L, 33563);
      if (this.gUl.size() <= 0)
      {
        v.i("MicroMsg.FunctionMsgFetcher", "processNextNewXml, all process finished");
        bool = false;
        GMTrace.o(4504749604864L, 33563);
      }
      for (;;)
      {
        return bool;
        if (!this.gUk) {
          break;
        }
        v.i("MicroMsg.FunctionMsgFetcher", "processNextNewXml, processing new xml");
        bool = false;
        GMTrace.o(4504749604864L, 33563);
      }
      this.gUk = true;
    }
    finally {}
    Object localObject2 = (Map)this.gUl.remove(0);
    Object localObject4 = (String)((Map)localObject2).get(".sysmsg.functionmsg.cgi");
    int j = bf.getInt((String)((Map)localObject2).get(".sysmsg.functionmsg.cmdid"), 0);
    String str1 = (String)((Map)localObject2).get(".sysmsg.functionmsg.functionmsgid");
    long l1 = bf.getLong((String)((Map)localObject2).get(".sysmsg.functionmsg.version"), 0L);
    int i = bf.getInt((String)((Map)localObject2).get(".sysmsg.functionmsg.op"), 0);
    int k = bf.getInt((String)((Map)localObject2).get(".sysmsg.functionmsg.retryinterval"), 0);
    int m = bf.getInt((String)((Map)localObject2).get(".sysmsg.functionmsg.reportid"), 0);
    int n = bf.getInt((String)((Map)localObject2).get(".sysmsg.functionmsg.successkey"), 0);
    int i1 = bf.getInt((String)((Map)localObject2).get(".sysmsg.functionmsg.failkey"), 0);
    int i2 = bf.getInt((String)((Map)localObject2).get(".sysmsg.functionmsg.finalfailkey"), 0);
    String str2 = (String)((Map)localObject2).get(".sysmsg.functionmsg.custombuff");
    v.d("MicroMsg.FunctionMsgFetcher", "processNextNewXml, cgi: %s, cmdId: %s, functionMsgId: %s, version: %s, op: %s, retryInterval: %s, reportId: %s, successKey: %s, failKey: %s, finalKey: %s, customBuff: %s", new Object[] { localObject4, Integer.valueOf(j), str1, Long.valueOf(l1), Integer.valueOf(i), Integer.valueOf(k), Integer.valueOf(m), Integer.valueOf(n), Integer.valueOf(i1), Integer.valueOf(i2), str2 });
    Object localObject3 = new d();
    if (!bf.mA((String)localObject4)) {
      ((d)localObject3).field_cgi = ((String)localObject4);
    }
    ((d)localObject3).field_cmdid = j;
    if (!bf.mA(str1)) {
      ((d)localObject3).field_functionmsgid = str1;
    }
    ((d)localObject3).field_version = l1;
    ((d)localObject3).field_retryinterval = k;
    ((d)localObject3).field_reportid = m;
    ((d)localObject3).field_successkey = n;
    ((d)localObject3).field_failkey = i1;
    ((d)localObject3).field_finalfailkey = i2;
    if (!bf.mA(str2)) {
      ((d)localObject3).field_custombuff = str2;
    }
    ((d)localObject3).field_status = -1;
    ((d)localObject3).b(null);
    j = Integer.valueOf((String)((Map)localObject2).get("FUNCTION_MSG_ADD_MSG_CREATE_TIME_KEY")).intValue();
    localObject2 = i.uf().dO(((d)localObject3).field_functionmsgid);
    if (localObject2 != null) {
      v.i("MicroMsg.FunctionMsgFetcher", "fetchInternal, functionMsgItem.status: %s, version: %s, preVersion: %s", new Object[] { Integer.valueOf(((d)localObject2).field_status), Long.valueOf(((d)localObject2).field_version), Long.valueOf(((d)localObject2).field_preVersion) });
    }
    v.d("MicroMsg.FunctionMsgFetcher", "fetchInternal, functionMsgItem: %s", new Object[] { localObject2 });
    if (i == 0)
    {
      ((d)localObject3).field_needShow = true;
      if (localObject2 == null)
      {
        v.i("MicroMsg.FunctionMsgFetcher", "fetchInternal, functionMsgId: %s, op update, insert a new one", new Object[] { ((d)localObject3).field_functionmsgid });
        i.uf().b((com.tencent.mm.sdk.e.c)localObject3);
      }
      for (;;)
      {
        tY();
        bool = true;
        GMTrace.o(4504749604864L, 33563);
        break;
        if (((d)localObject2).field_version < ((d)localObject3).field_version)
        {
          v.i("MicroMsg.FunctionMsgFetcher", "fetchInternal, functionMsgId: %s, op update, update the exist one", new Object[] { ((d)localObject3).field_functionmsgid });
          ((d)localObject2).field_preVersion = ((d)localObject2).field_version;
          ((d)localObject3).field_preVersion = ((d)localObject2).field_version;
          i.uf().a(((d)localObject2).field_functionmsgid, (d)localObject3);
        }
      }
    }
    if (i == 1)
    {
      v.i("MicroMsg.FunctionMsgFetcher", "fetchInternal, op delete");
      if (localObject2 != null)
      {
        v.i("MicroMsg.FunctionMsgFetcher", "fetchInternal, functionMsgId: %s, op delete, newFunctionMsgItem.version: %s, functionMsgItem.version: %s", new Object[] { ((d)localObject2).field_functionmsgid, Long.valueOf(((d)localObject3).field_version), Long.valueOf(((d)localObject2).field_version) });
        if (((d)localObject3).field_version != ((d)localObject2).field_version)
        {
          l1 = ((d)localObject3).field_version;
          if (l1 != 0L) {}
        }
        else if (localObject2 == null) {}
      }
    }
    for (;;)
    {
      try
      {
        localObject4 = a(((d)localObject2).field_addMsg);
        if (localObject4 != null) {
          break label1357;
        }
        bool = true;
        v.d("MicroMsg.FunctionMsgFetcher", "callbackToDelete, msgContent==null: %s", new Object[] { Boolean.valueOf(bool) });
        if (localObject4 != null)
        {
          localObject3 = Collections.singletonMap(((d)localObject2).field_functionmsgid, ((d)localObject2).field_addMsg);
          localObject4 = (List)i.ue().gUA.get(Integer.valueOf(((bu)localObject4).mrC));
          if (localObject4 != null)
          {
            localObject4 = ((List)localObject4).iterator();
            if (((Iterator)localObject4).hasNext())
            {
              ((f)((Iterator)localObject4).next()).a(1, (Map)localObject3, false);
              continue;
            }
          }
        }
        i.uf().a((com.tencent.mm.sdk.e.c)localObject2, new String[0]);
      }
      catch (Exception localException)
      {
        v.e("MicroMsg.FunctionMsgFetcher", "callbackToDelete error: %s", new Object[] { localException.getMessage() });
      }
      for (;;)
      {
        tZ();
        break;
        v.i("MicroMsg.FunctionMsgFetcher", "fetchInternal, functionMsgId: %s, op delete, the origin one not exist", new Object[] { localException.field_functionmsgid });
      }
      if (i == 2)
      {
        localException.field_needShow = false;
        if (localObject2 == null)
        {
          v.i("MicroMsg.FunctionMsgFetcher", "fetchInternal, functionMsgId: %s, op update but no show, insert a new one", new Object[] { localException.field_functionmsgid });
          i.uf().b(localException);
        }
        for (;;)
        {
          tY();
          break;
          if (((d)localObject2).field_version < localException.field_version)
          {
            v.i("MicroMsg.FunctionMsgFetcher", "fetchInternal, functionMsgId: %s, op update but no show, update the exist one, preVersion: %s", new Object[] { localException.field_functionmsgid, Long.valueOf(((d)localObject2).field_preVersion) });
            ((d)localObject2).field_preVersion = ((d)localObject2).field_version;
            localException.field_preVersion = ((d)localObject2).field_version;
            i.uf().a(((d)localObject2).field_functionmsgid, localException);
          }
        }
      }
      long l2;
      if (i == 3)
      {
        v.i("MicroMsg.FunctionMsgFetcher", "fetchInternal, functionMsgId: %s, op show, functionMsgItem: %s", new Object[] { localException.field_functionmsgid, localObject2 });
        localException.field_needShow = true;
        if (localObject2 != null)
        {
          l1 = localException.field_version;
          l2 = ((d)localObject2).field_version;
          if (((d)localObject2).field_addMsg != null) {
            break label1351;
          }
        }
      }
      label1351:
      for (bool = true;; bool = false)
      {
        v.i("MicroMsg.FunctionMsgFetcher", "fetchInternal, op show, newFunctionMsgItem.version: %s, functionMsgItem.version: %s, functionMsgItem.msgContent == null: %s", new Object[] { Long.valueOf(l1), Long.valueOf(l2), Boolean.valueOf(bool) });
        if ((((d)localObject2).field_version >= localException.field_version) || (localException.field_version == 0L))
        {
          ((d)localObject2).field_needShow = true;
          if (((d)localObject2).field_addMsg != null)
          {
            v.i("MicroMsg.FunctionMsgFetcher", "show, update create time to: %s", new Object[] { Integer.valueOf(j) });
            ((d)localObject2).field_addMsg.ofk = j;
          }
          i.uf().a(((d)localObject2).field_functionmsgid, (d)localObject2);
          if (((d)localObject2).field_addMsg != null) {
            b(Collections.singletonList(localObject2), true);
          }
        }
        tZ();
        break;
      }
      label1357:
      bool = false;
    }
  }
  
  public final boolean tX()
  {
    try
    {
      GMTrace.i(4505018040320L, 33565);
      boolean bool = this.gUj;
      GMTrace.o(4505018040320L, 33565);
      return bool;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
  
  public final void tY()
  {
    for (;;)
    {
      try
      {
        GMTrace.i(4505152258048L, 33566);
        if (this.gUj)
        {
          v.j("MicroMsg.FunctionMsgFetcher", "fetchAllIfNeed, isFetching, ignore this", new Object[0]);
          tZ();
          GMTrace.o(4505152258048L, 33566);
          return;
        }
        if (!al.isNetworkConnected(aa.getContext()))
        {
          v.j("MicroMsg.FunctionMsgFetcher", "fetchAllIfNeed network not connected, ignore this", new Object[0]);
          tZ();
          GMTrace.o(4505152258048L, 33566);
          continue;
        }
        this.gUj = true;
      }
      finally {}
      List localList = i.uf().ua();
      v.d("MicroMsg.FunctionMsgFetcher", "fetchAllIfNeed, fetchItems: %s", new Object[] { localList });
      if ((localList != null) && (localList.size() > 0))
      {
        v.i("MicroMsg.FunctionMsgFetcher", "fetchAllIfNeed, fetchItem.size: %s", new Object[] { Integer.valueOf(localList.size()) });
        new b(localList, new b.a()
        {
          public final void q(List<d> paramAnonymousList)
          {
            GMTrace.i(4507836612608L, 33586);
            c.this.gUj = false;
            if (paramAnonymousList != null)
            {
              v.i("MicroMsg.FunctionMsgFetcher", "onFetchFinish, fetchSuccessList.size: %s", new Object[] { paramAnonymousList });
              c.b(paramAnonymousList, false);
            }
            c.this.tZ();
            GMTrace.o(4507836612608L, 33586);
          }
        }).start();
        GMTrace.o(4505152258048L, 33566);
      }
      else
      {
        this.gUj = false;
        tZ();
        GMTrace.o(4505152258048L, 33566);
      }
    }
  }
  
  public final void tZ()
  {
    GMTrace.i(4505286475776L, 33567);
    v.j("MicroMsg.FunctionMsgFetcher", "loopToNextNewXml", new Object[0]);
    this.gUk = false;
    tW();
    GMTrace.o(4505286475776L, 33567);
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/p/c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */