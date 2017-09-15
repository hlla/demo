package com.tencent.mm.pluginsdk.model.app;

import android.content.Context;
import android.os.Looper;
import com.tencent.gmtrace.GMTrace;
import com.tencent.mm.kernel.b;
import com.tencent.mm.plugin.w.a;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.ai.a;
import com.tencent.mm.sdk.platformtools.bf;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.u.x.b;
import com.tencent.mm.y.e;
import com.tencent.mm.y.k;
import com.tencent.mm.y.n;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Vector;

public final class h
  implements t, x.b, e
{
  private List<String> pkz;
  private List<String> sBH;
  private List<String> sBI;
  private volatile boolean sBJ;
  private List<String> sBt;
  public Map<String, Integer> sBu;
  private ai sBv;
  
  public h()
  {
    GMTrace.i(823157325824L, 6133);
    this.sBt = null;
    this.pkz = null;
    this.sBu = null;
    this.sBJ = false;
    this.sBv = new ai(Looper.getMainLooper(), new ai.a()
    {
      public final boolean oQ()
      {
        GMTrace.i(796850651136L, 5937);
        h.this.sBu.clear();
        GMTrace.o(796850651136L, 5937);
        return false;
      }
    }, false);
    this.sBt = new ArrayList();
    this.pkz = new ArrayList();
    this.sBu = new HashMap();
    this.sBH = new Vector();
    this.sBI = new ArrayList();
    this.sBv.v(600000L, 600000L);
    com.tencent.mm.kernel.h.vH().gXs.a(231, this);
    a.aBz().a(7, this);
    GMTrace.o(823157325824L, 6133);
  }
  
  private void Ma(String paramString)
  {
    for (;;)
    {
      try
      {
        GMTrace.i(823559979008L, 6136);
        if ((!bf.mA(paramString)) && (!this.sBH.contains(paramString)))
        {
          if (!Mc(paramString))
          {
            v.e("MicroMsg.AppInfoService", "this app has reach the max retry count, appid is %s", new Object[] { paramString });
            GMTrace.o(823559979008L, 6136);
            return;
          }
          v.i("MicroMsg.AppInfoService", "add appid:[%s]", new Object[] { paramString });
          this.sBH.add(paramString);
          GMTrace.o(823559979008L, 6136);
          continue;
        }
      }
      finally {}
      tmp117_114[0] = paramString;
      v.i("MicroMsg.AppInfoService", "should not add this appid:[%s], it is already runing", tmp117_114);
      GMTrace.o(823559979008L, 6136);
    }
  }
  
  private boolean Mc(String paramString)
  {
    GMTrace.i(823962632192L, 6139);
    if (paramString == null)
    {
      v.e("MicroMsg.AppInfoService", "increaseCounter fail, appId is null");
      GMTrace.o(823962632192L, 6139);
      return false;
    }
    Integer localInteger = Integer.valueOf(bf.a((Integer)this.sBu.get(paramString), 0));
    if (localInteger.intValue() >= 5)
    {
      v.e("MicroMsg.AppInfoService", "increaseCounter fail, has reached the max try count");
      GMTrace.o(823962632192L, 6139);
      return false;
    }
    this.sBu.put(paramString, Integer.valueOf(localInteger.intValue() + 1));
    GMTrace.o(823962632192L, 6139);
    return true;
  }
  
  private void bCR()
  {
    int i = 20;
    GMTrace.i(823828414464L, 6138);
    if (this.sBJ)
    {
      v.d("MicroMsg.AppInfoService", " batch get appinfo doing now");
      GMTrace.o(823828414464L, 6138);
      return;
    }
    if ((this.sBH == null) || (this.sBH.isEmpty()))
    {
      v.d("MicroMsg.AppInfoService", "batchwaitinglist is empty, no need to doscene");
      GMTrace.o(823828414464L, 6138);
      return;
    }
    int j = this.sBH.size();
    if (j > 20) {}
    for (;;)
    {
      try
      {
        this.sBI.addAll(this.sBH.subList(0, i));
        if ((this.sBI != null) && (!this.sBI.isEmpty()))
        {
          this.sBJ = true;
          x localx = new x(7, new ad(this.sBI));
          com.tencent.mm.kernel.h.vH().gXs.a(localx, 0);
        }
        GMTrace.o(823828414464L, 6138);
        return;
      }
      finally {}
      i = j;
    }
  }
  
  public final void Mb(String paramString)
  {
    GMTrace.i(823694196736L, 6137);
    if ((paramString == null) || (paramString.length() == 0))
    {
      v.e("MicroMsg.AppInfoService", "push fail, appId is null");
      GMTrace.o(823694196736L, 6137);
      return;
    }
    v.i("MicroMsg.AppInfoService", "push appid : " + paramString);
    Ma(paramString);
    bCR();
    GMTrace.o(823694196736L, 6137);
  }
  
  public final void a(int paramInt1, int paramInt2, String paramString, w paramw)
  {
    GMTrace.i(824231067648L, 6141);
    if (paramw.getType() != 7)
    {
      v.d("MicroMsg.AppInfoService", "not the getappinfolist scene, ignore");
      GMTrace.o(824231067648L, 6141);
      return;
    }
    try
    {
      if ((this.sBI != null) && (!this.sBI.isEmpty()))
      {
        this.sBH.removeAll(this.sBI);
        this.sBI.clear();
      }
      this.sBJ = false;
      bCR();
      GMTrace.o(824231067648L, 6141);
      return;
    }
    finally {}
  }
  
  public final void a(int paramInt1, int paramInt2, String paramString, k paramk)
  {
    GMTrace.i(824096849920L, 6140);
    paramInt1 = paramk.getType();
    switch (paramInt1)
    {
    default: 
      v.e("MicroMsg.AppInfoService", "error type: " + paramInt1);
    case 231: 
      do
      {
        GMTrace.o(824096849920L, 6140);
        return;
        paramString = ((ac)paramk).appId;
        if (this.sBt.contains(paramString)) {
          this.sBt.remove(paramString);
        }
      } while (this.pkz.size() <= 0);
      paramString = (String)this.pkz.remove(0);
      if ((paramString == null) || (paramString.length() == 0))
      {
        v.e("MicroMsg.AppInfoService", "startDownload fail, appId is null");
        paramInt1 = 0;
      }
      while (paramInt1 != 0)
      {
        this.sBt.add(paramString);
        GMTrace.o(824096849920L, 6140);
        return;
        if (!Mc(paramString))
        {
          v.e("MicroMsg.AppInfoService", "increaseCounter fail");
          paramInt1 = 0;
        }
        else
        {
          paramk = new ac(paramString);
          com.tencent.mm.kernel.h.vH().gXs.a(paramk, 0);
          paramInt1 = 1;
        }
      }
    }
    try
    {
      if ((this.sBI != null) && (!this.sBI.isEmpty()))
      {
        this.sBH.removeAll(this.sBI);
        this.sBI.clear();
      }
      this.sBJ = false;
      bCR();
      GMTrace.o(824096849920L, 6140);
      return;
    }
    finally {}
  }
  
  public final void at(LinkedList<String> paramLinkedList)
  {
    GMTrace.i(823425761280L, 6135);
    if ((paramLinkedList == null) || (paramLinkedList.size() == 0))
    {
      v.e("MicroMsg.AppInfoService", "batch push appinfo err: null or nil applist");
      GMTrace.o(823425761280L, 6135);
      return;
    }
    paramLinkedList = paramLinkedList.iterator();
    while (paramLinkedList.hasNext()) {
      Ma((String)paramLinkedList.next());
    }
    bCR();
    GMTrace.o(823425761280L, 6135);
  }
  
  public final String m(Context paramContext, String paramString)
  {
    GMTrace.i(823291543552L, 6134);
    paramContext = g.m(paramContext, paramString);
    GMTrace.o(823291543552L, 6134);
    return paramContext;
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/pluginsdk/model/app/h.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */