package com.tencent.mm.pluginsdk.model.app;

import com.tencent.gmtrace.GMTrace;
import com.tencent.mm.kernel.b;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.w.a;
import com.tencent.mm.sdk.platformtools.bf;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.y.n;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Vector;

public final class m
  implements t
{
  public Vector<String> sBT;
  private volatile boolean sBU;
  private List<String> sBt;
  
  public m()
  {
    GMTrace.i(814835826688L, 6071);
    this.sBU = false;
    this.sBT = new Vector();
    this.sBt = new ArrayList();
    a.aBz().a(1, this);
    GMTrace.o(814835826688L, 6071);
  }
  
  private void aBm()
  {
    int i = 20;
    GMTrace.i(815238479872L, 6074);
    if (this.sBU)
    {
      v.d("MicroMsg.AppSettingService", "tryDoScene fail, doing Scene");
      GMTrace.o(815238479872L, 6074);
      return;
    }
    if (this.sBT.size() <= 0)
    {
      v.d("MicroMsg.AppSettingService", "tryDoScene fail, appIdList is empty");
      GMTrace.o(815238479872L, 6074);
      return;
    }
    v.d("MicroMsg.AppSettingService", "tryDoScene, appid list size = " + this.sBT.size());
    int j = this.sBT.size();
    if (j > 20) {}
    for (;;)
    {
      this.sBU = true;
      this.sBt.addAll(this.sBT.subList(0, i));
      x localx = new x(1, new ae(this.sBt));
      h.vH().gXs.a(localx, 0);
      GMTrace.o(815238479872L, 6074);
      return;
      i = j;
    }
  }
  
  public final void Jj(String paramString)
  {
    GMTrace.i(814970044416L, 6072);
    v.d("MicroMsg.AppSettingService", "appId = " + paramString);
    if (bf.mA(paramString))
    {
      v.e("MicroMsg.AppSettingService", "add appId is null");
      GMTrace.o(814970044416L, 6072);
      return;
    }
    if (!this.sBT.contains(paramString)) {
      this.sBT.add(paramString);
    }
    aBm();
    GMTrace.o(814970044416L, 6072);
  }
  
  public final void a(int paramInt1, int paramInt2, String paramString, w paramw)
  {
    GMTrace.i(815372697600L, 6075);
    if (paramw.getType() != 1)
    {
      GMTrace.o(815372697600L, 6075);
      return;
    }
    this.sBU = false;
    paramString = ((ae)paramw).sCl;
    v.d("MicroMsg.AppSettingService", "onSceneEnd, list size = " + paramString.size());
    this.sBT.removeAll(this.sBt);
    this.sBt.clear();
    aBm();
    GMTrace.o(815372697600L, 6075);
  }
  
  public final void bQ(List<String> paramList)
  {
    GMTrace.i(815104262144L, 6073);
    if ((paramList == null) || (paramList.size() == 0))
    {
      v.e("MicroMsg.AppSettingService", "addAll list is null");
      GMTrace.o(815104262144L, 6073);
      return;
    }
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      String str = (String)paramList.next();
      if ((!bf.mA(str)) && (!this.sBT.contains(str))) {
        this.sBT.add(str);
      }
    }
    aBm();
    GMTrace.o(815104262144L, 6073);
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/pluginsdk/model/app/m.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */