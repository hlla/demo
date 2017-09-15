package com.tencent.mm.ui.conversation;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import com.tencent.gmtrace.GMTrace;
import com.tencent.mm.e.a.ae;
import com.tencent.mm.e.a.ir;
import com.tencent.mm.network.m.a;
import com.tencent.mm.platformtools.u;
import com.tencent.mm.pluginsdk.ui.b.b;
import com.tencent.mm.sdk.e.m.b;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.ai.a;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.u.al;
import com.tencent.mm.u.ap;
import com.tencent.mm.x.d.a;
import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public final class a
  implements m.b, al, d.a
{
  Context context;
  com.tencent.mm.network.m oWA;
  List<b> vZc;
  List<b> vZd;
  List<b> vZe;
  List<b> vZf;
  List<b> vZg;
  com.tencent.mm.sdk.b.c vZh;
  com.tencent.mm.sdk.b.c vZi;
  public ListView vZj;
  public View vZk;
  
  public a()
  {
    GMTrace.i(14483032375296L, 107907);
    this.vZc = new LinkedList();
    this.vZd = new LinkedList();
    this.vZe = new LinkedList();
    this.vZf = new LinkedList();
    this.vZg = new LinkedList();
    GMTrace.o(14483032375296L, 107907);
  }
  
  private static void cS(List<b> paramList)
  {
    GMTrace.i(14681674612736L, 109387);
    paramList = paramList.iterator();
    while (paramList.hasNext()) {
      ((b)paramList.next()).setVisibility(8);
    }
    GMTrace.o(14681674612736L, 109387);
  }
  
  static void cT(List<b> paramList)
  {
    GMTrace.i(14484106117120L, 107915);
    paramList = paramList.iterator();
    while (paramList.hasNext()) {
      ((b)paramList.next()).release();
    }
    GMTrace.o(14484106117120L, 107915);
  }
  
  static void cU(List<b> paramList)
  {
    GMTrace.i(14484240334848L, 107916);
    Iterator localIterator = paramList.iterator();
    while (localIterator.hasNext()) {
      ((b)localIterator.next()).destroy();
    }
    paramList.clear();
    GMTrace.o(14484240334848L, 107916);
  }
  
  public final void a(int paramInt, com.tencent.mm.sdk.e.m paramm, Object paramObject)
  {
    GMTrace.i(14483435028480L, 107910);
    if (ap.zb())
    {
      ap.yY();
      if (paramm == com.tencent.mm.u.c.vr())
      {
        paramInt = u.aC(paramObject);
        if (8193 == paramInt) {
          bYi();
        }
        if (42 == paramInt) {
          bYi();
        }
      }
    }
    GMTrace.o(14483435028480L, 107910);
  }
  
  public final void bYi()
  {
    int j = 1;
    GMTrace.i(14483166593024L, 107908);
    if ((this.context == null) || (!ap.zb()))
    {
      GMTrace.o(14483166593024L, 107908);
      return;
    }
    v.i("MicroMsg.BannerHelper", "updateBanner, :%d", new Object[] { Integer.valueOf(hashCode()) });
    boolean bool1 = j(this.vZc, true);
    boolean bool2 = j(this.vZd, true);
    boolean bool3 = j(this.vZe, true);
    boolean bool4 = j(this.vZf, true);
    int i = j;
    if (!bool1)
    {
      i = j;
      if (!bool2)
      {
        i = j;
        if (!bool3)
        {
          if (!bool4) {
            break label220;
          }
          i = j;
        }
      }
    }
    if (bool2)
    {
      cS(this.vZe);
      cS(this.vZf);
    }
    for (;;)
    {
      if ((i != 0) && (this.vZj.getVisibility() != 0))
      {
        this.vZj.setVisibility(0);
        this.vZk.setVisibility(8);
      }
      Iterator localIterator = this.vZg.iterator();
      while (localIterator.hasNext())
      {
        b localb = (b)localIterator.next();
        if (localb != null) {
          localb.Xd();
        }
      }
      label220:
      i = 0;
      break;
      if (bool3) {
        cS(this.vZf);
      }
    }
    GMTrace.o(14483166593024L, 107908);
  }
  
  final void cQ(List<b> paramList)
  {
    GMTrace.i(14483703463936L, 107912);
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      b localb = (b)paramList.next();
      this.vZj.addHeaderView(localb.getView());
    }
    GMTrace.o(14483703463936L, 107912);
  }
  
  final void cR(List<b> paramList)
  {
    GMTrace.i(14483837681664L, 107913);
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      b localb = (b)paramList.next();
      if (localb.getView() != null) {
        this.vZj.removeHeaderView(localb.getView());
      }
    }
    GMTrace.o(14483837681664L, 107913);
  }
  
  public final void ho(String paramString)
  {
    GMTrace.i(14483300810752L, 107909);
    if ((ap.zb()) && (!ap.uP()) && (u.mz(paramString).length() > 0) && (paramString.equals(com.tencent.mm.u.m.xL()))) {
      bYi();
    }
    GMTrace.o(14483300810752L, 107909);
  }
  
  final boolean j(List<b> paramList, boolean paramBoolean)
  {
    GMTrace.i(14483971899392L, 107914);
    paramList = paramList.iterator();
    boolean bool = false;
    if (paramList.hasNext())
    {
      b localb = (b)paramList.next();
      View localView = ((ViewGroup)localb.getView()).getChildAt(0);
      if (localb.Xd())
      {
        if ((localView != null) && (localView.getVisibility() == 0)) {}
        for (bool = true;; bool = false)
        {
          v.i("MicroMsg.BannerHelper", "refreshAndReturnIsVisible[true] :%s, checkAll:%b, isVisible:%b, hc:%d", new Object[] { localb, Boolean.valueOf(paramBoolean), Boolean.valueOf(bool), Integer.valueOf(hashCode()) });
          if (paramBoolean) {
            break;
          }
          GMTrace.o(14483971899392L, 107914);
          return true;
        }
      }
      if ((localView != null) && (localView.getVisibility() == 0)) {
        v.i("MicroMsg.BannerHelper", "refreshAndReturnIsVisible[false] but visible :%s, checkAll:%b, hc:%d", new Object[] { localb, Boolean.valueOf(paramBoolean), Integer.valueOf(hashCode()) });
      }
    }
    for (;;)
    {
      break;
      GMTrace.o(14483971899392L, 107914);
      return bool;
      bool = true;
    }
  }
  
  public final void yP()
  {
    GMTrace.i(14483569246208L, 107911);
    bYi();
    GMTrace.o(14483569246208L, 107911);
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/ui/conversation/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */