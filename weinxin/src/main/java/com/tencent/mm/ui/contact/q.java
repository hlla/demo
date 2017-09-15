package com.tencent.mm.ui.contact;

import android.app.Activity;
import android.content.res.Resources;
import android.os.Looper;
import android.widget.ListView;
import com.tencent.gmtrace.GMTrace;
import com.tencent.mm.R.l;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.fts.a.j;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.ui.contact.a.c;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class q
  extends m
{
  private int count;
  private String fRC;
  private ad handler;
  private com.tencent.mm.plugin.fts.a.a.a lYt;
  private String[] lYu;
  private List<com.tencent.mm.plugin.fts.a.a.i> maq;
  private List<com.tencent.mm.plugin.fts.a.a.i> nvJ;
  private int vTY;
  private int vTZ;
  private int vWA;
  private int vWB;
  private boolean vWC;
  private int vWD;
  private boolean vWE;
  private int vWF;
  private List<com.tencent.mm.plugin.fts.a.a.i> vWG;
  private List<com.tencent.mm.plugin.fts.a.a.i> vWH;
  private List<Integer> vWI;
  private j vWJ;
  protected j vWK;
  private List<String> vWy;
  private int vWz;
  
  public q(MMBaseSelectContactUI paramMMBaseSelectContactUI, List<String> paramList, boolean paramBoolean, int paramInt)
  {
    super(paramMMBaseSelectContactUI, paramBoolean, paramInt);
    GMTrace.i(1709262766080L, 12735);
    this.vWz = Integer.MAX_VALUE;
    this.vWA = Integer.MAX_VALUE;
    this.vWB = Integer.MAX_VALUE;
    this.vWC = true;
    this.vWD = Integer.MAX_VALUE;
    this.vTY = Integer.MAX_VALUE;
    this.vWE = true;
    this.vWF = Integer.MAX_VALUE;
    this.vTZ = Integer.MAX_VALUE;
    this.vWG = null;
    this.nvJ = null;
    this.maq = null;
    this.vWH = null;
    this.handler = new ad(Looper.getMainLooper());
    this.vWJ = new j()
    {
      public final void a(com.tencent.mm.plugin.fts.a.a.g paramAnonymousg)
      {
        GMTrace.i(17924106485760L, 133545);
        switch (paramAnonymousg.aMA)
        {
        }
        for (;;)
        {
          GMTrace.o(17924106485760L, 133545);
          return;
          if ((q.a(q.this) == null) || (!q.a(q.this).equals(q.a(q.this))))
          {
            GMTrace.o(17924106485760L, 133545);
            return;
          }
          q.b(q.this);
          q.a(q.this, paramAnonymousg.lYu);
          q.a(q.this, paramAnonymousg.lYv);
          q.b(q.this, paramAnonymousg.lYv);
          com.tencent.mm.plugin.fts.a.d.aD(paramAnonymousg.lYv);
          boolean bool = q.c(q.this);
          q.a(q.this, paramAnonymousg.lWr.fRC, bool);
          GMTrace.o(17924106485760L, 133545);
          return;
          if (!paramAnonymousg.lWr.fRC.equals(q.d(q.this)))
          {
            GMTrace.o(17924106485760L, 133545);
            return;
          }
          q.c(q.this);
        }
      }
    };
    this.vWK = new j()
    {
      public final void a(com.tencent.mm.plugin.fts.a.a.g paramAnonymousg)
      {
        GMTrace.i(17927327711232L, 133569);
        switch (paramAnonymousg.aMA)
        {
        }
        for (;;)
        {
          GMTrace.o(17927327711232L, 133569);
          return;
          if ((q.a(q.this) != null) && (q.a(q.this).equals(q.a(q.this))))
          {
            q.a(q.this, paramAnonymousg.lYu);
            q.a(q.this, paramAnonymousg.lYv);
            if (paramAnonymousg.lYv.size() > 0) {
              switch (((com.tencent.mm.plugin.fts.a.a.i)paramAnonymousg.lYv.get(0)).type)
              {
              case 131073: 
              case 131074: 
              default: 
                v.i("MicroMsg.MMSearchContactAdapter", "not support search");
              }
            }
            for (;;)
            {
              boolean bool = q.c(q.this);
              q.a(q.this, paramAnonymousg.lWr.fRC, bool);
              GMTrace.o(17927327711232L, 133569);
              return;
              q.c(q.this, paramAnonymousg.lYv);
              continue;
              q.d(q.this, paramAnonymousg.lYv);
              continue;
              q.e(q.this, paramAnonymousg.lYv);
            }
            if (!paramAnonymousg.lWr.fRC.equals(q.d(q.this)))
            {
              GMTrace.o(17927327711232L, 133569);
              return;
            }
            q.c(q.this);
          }
        }
      }
    };
    this.count = 0;
    this.vWy = paramList;
    this.vWI = new ArrayList();
    v.i("MicroMsg.MMSearchContactAdapter", "Create!");
    Of();
    GMTrace.o(1709262766080L, 12735);
  }
  
  private void Of()
  {
    GMTrace.i(1709933854720L, 12740);
    v.i("MicroMsg.MMSearchContactAdapter", "initData!");
    this.fRC = null;
    bYa();
    clearTask();
    clearCache();
    GMTrace.o(1709933854720L, 12740);
  }
  
  private void bYa()
  {
    GMTrace.i(1709799636992L, 12739);
    this.vWA = Integer.MAX_VALUE;
    this.vWB = Integer.MAX_VALUE;
    this.vWC = true;
    this.vWD = Integer.MAX_VALUE;
    this.vTY = Integer.MAX_VALUE;
    this.vWE = true;
    this.vWF = Integer.MAX_VALUE;
    this.vTZ = Integer.MAX_VALUE;
    this.vWG = null;
    this.nvJ = null;
    this.maq = null;
    this.vWH = null;
    this.lYu = null;
    clearCache();
    notifyDataSetChanged();
    GMTrace.o(1709799636992L, 12739);
  }
  
  private static int cM(List<? extends Object> paramList)
  {
    GMTrace.i(1710470725632L, 12744);
    if (paramList == null)
    {
      GMTrace.o(1710470725632L, 12744);
      return 0;
    }
    int i = paramList.size();
    GMTrace.o(1710470725632L, 12744);
    return i;
  }
  
  private void clearTask()
  {
    GMTrace.i(1709665419264L, 12738);
    if (this.lYt != null)
    {
      ((com.tencent.mm.plugin.fts.a.l)h.j(com.tencent.mm.plugin.fts.a.l.class)).cancelSearchTask(this.lYt);
      this.lYt = null;
    }
    GMTrace.o(1709665419264L, 12738);
  }
  
  private com.tencent.mm.ui.contact.a.a ed(int paramInt1, int paramInt2)
  {
    GMTrace.i(1710873378816L, 12747);
    com.tencent.mm.ui.contact.a.g localg = new com.tencent.mm.ui.contact.a.g(paramInt2);
    localg.mbB = this.vWg.getActivity().getResources().getString(paramInt1);
    GMTrace.o(1710873378816L, 12747);
    return localg;
  }
  
  private void f(String paramString, boolean paramBoolean1, boolean paramBoolean2)
  {
    GMTrace.i(1710202290176L, 12742);
    int i = cM(this.vWG);
    int m = cM(this.nvJ);
    int k = cM(this.maq);
    int j = cM(this.vWH);
    if (i > 0)
    {
      this.vWA = 0;
      i = i + 1 + 0;
      if (m <= 0) {
        break label318;
      }
      this.vWB = i;
      if ((m <= 3) || ((k <= 0) && (j <= 0))) {
        break label300;
      }
      if (!this.vWC) {
        break label276;
      }
      i += 4;
      this.vWD = i;
      i += 1;
      label115:
      if ((this.lYu.length <= 1) || (bcI())) {
        break label327;
      }
      this.vWz = i;
      i += 1;
      label143:
      if (k <= 0) {
        break label378;
      }
      this.vTY = i;
      if ((k <= 3) || (j <= 0)) {
        break label360;
      }
      if (!this.vWE) {
        break label336;
      }
      i += 4;
      this.vWF = i;
      i += 1;
      label190:
      if (j <= 0) {
        break label387;
      }
      this.vTZ = i;
      i += j + 1;
    }
    for (;;)
    {
      v.i("MicroMsg.MMSearchContactAdapter", "setCount %d", new Object[] { Integer.valueOf(i) });
      this.count = i;
      if (paramBoolean2) {
        aZ(paramString, paramBoolean1);
      }
      clearCache();
      notifyDataSetChanged();
      GMTrace.o(1710202290176L, 12742);
      return;
      this.vWA = Integer.MAX_VALUE;
      i = 0;
      break;
      label276:
      i += m + 1;
      this.vWD = i;
      i += 1;
      break label115;
      label300:
      this.vWD = Integer.MAX_VALUE;
      i += m + 1;
      break label115;
      label318:
      this.vWB = Integer.MAX_VALUE;
      break label115;
      label327:
      this.vWz = Integer.MAX_VALUE;
      break label143;
      label336:
      i += k + 1;
      this.vWF = i;
      i += 1;
      break label190;
      label360:
      this.vWF = Integer.MAX_VALUE;
      i += k + 1;
      break label190;
      label378:
      this.vTY = Integer.MAX_VALUE;
      break label190;
      label387:
      this.vTZ = Integer.MAX_VALUE;
    }
  }
  
  private static com.tencent.mm.ui.contact.a.a u(int paramInt1, int paramInt2, boolean paramBoolean)
  {
    GMTrace.i(1710739161088L, 12746);
    com.tencent.mm.ui.contact.a.i locali = new com.tencent.mm.ui.contact.a.i(paramInt2);
    locali.roM = paramInt1;
    locali.vYN = paramBoolean;
    GMTrace.o(1710739161088L, 12746);
    return locali;
  }
  
  public final boolean BH(int paramInt)
  {
    boolean bool = true;
    GMTrace.i(1711276032000L, 12750);
    paramInt -= this.vWg.bcP().getHeaderViewsCount();
    if (paramInt == this.vWD) {
      if (this.vWC)
      {
        paramInt = this.vWg.bcP().getSelectedItemPosition();
        this.vWC = false;
        f(this.fRC, true, false);
        this.vWg.bcP().setSelection(paramInt);
      }
    }
    for (;;)
    {
      GMTrace.o(1711276032000L, 12750);
      return bool;
      this.vWC = true;
      f(this.fRC, true, false);
      this.vWg.bcP().setSelection(this.vWD);
      continue;
      if (paramInt == this.vWF)
      {
        if (this.vWE)
        {
          paramInt = this.vWg.bcP().getSelectedItemPosition();
          this.vWE = false;
          f(this.fRC, true, false);
          this.vWg.bcP().setSelection(paramInt);
        }
        else
        {
          this.vWE = true;
          f(this.fRC, true, false);
          this.vWg.bcP().setSelection(this.vWF);
        }
      }
      else
      {
        com.tencent.mm.ui.contact.a.a locala = BG(paramInt);
        if ((locala != null) && (locala.vYm) && (this.vWz != Integer.MAX_VALUE))
        {
          if (locala.position == this.vWz)
          {
            u.BI(1);
            bool = false;
          }
          else
          {
            u.BI(0);
          }
        }
        else {
          bool = false;
        }
      }
    }
  }
  
  public final void QZ()
  {
    GMTrace.i(1710068072448L, 12741);
    Of();
    GMTrace.o(1710068072448L, 12741);
  }
  
  public void a(String paramString, int[] paramArrayOfInt, boolean paramBoolean)
  {
    GMTrace.i(1709531201536L, 12737);
    clearTask();
    this.fRC = paramString;
    this.vWI.clear();
    int j = paramArrayOfInt.length;
    int i = 0;
    while (i < j)
    {
      int k = paramArrayOfInt[i];
      this.vWI.add(Integer.valueOf(k));
      i += 1;
    }
    HashSet localHashSet = new HashSet();
    if (!paramBoolean) {
      localHashSet.add("filehelper");
    }
    v.i("MicroMsg.MMSearchContactAdapter", "doSearch: query=%s", new Object[] { this.fRC });
    com.tencent.mm.plugin.fts.a.a.f localf = new com.tencent.mm.plugin.fts.a.a.f();
    localf.fRC = paramString;
    localf.lYn = paramArrayOfInt;
    localf.lYp = 3;
    localf.lYs = this.vWJ;
    localf.handler = this.handler;
    localf.scene = 1;
    localf.lYq = localHashSet;
    this.lYt = ((com.tencent.mm.plugin.fts.a.l)h.j(com.tencent.mm.plugin.fts.a.l.class)).search(1, localf);
    GMTrace.o(1709531201536L, 12737);
  }
  
  public void aZ(String paramString, boolean paramBoolean)
  {
    GMTrace.i(1709396983808L, 12736);
    if (this.vWf != null) {
      this.vWf.r(paramString, getCount(), paramBoolean);
    }
    GMTrace.o(1709396983808L, 12736);
  }
  
  protected boolean c(com.tencent.mm.ui.contact.a.a parama)
  {
    GMTrace.i(1711141814272L, 12749);
    int j = parama.position;
    int k = this.vWA;
    int m = this.vWB;
    int n = this.vTY;
    int i1 = this.vTZ;
    int i = 0;
    while (i < 4)
    {
      if (j + 1 == new int[] { k, m, n, i1 }[i])
      {
        GMTrace.o(1711141814272L, 12749);
        return true;
      }
      i += 1;
    }
    GMTrace.o(1711141814272L, 12749);
    return false;
  }
  
  public void finish()
  {
    GMTrace.i(1711007596544L, 12748);
    super.finish();
    v.i("MicroMsg.MMSearchContactAdapter", "finish!");
    Of();
    GMTrace.o(1711007596544L, 12748);
  }
  
  public int getCount()
  {
    GMTrace.i(1710336507904L, 12743);
    int i = this.count;
    GMTrace.o(1710336507904L, 12743);
    return i;
  }
  
  public com.tencent.mm.ui.contact.a.a hf(int paramInt)
  {
    GMTrace.i(1710604943360L, 12745);
    Object localObject;
    if (paramInt == this.vWz)
    {
      localObject = new com.tencent.mm.ui.contact.a.f(paramInt);
      ((com.tencent.mm.ui.contact.a.f)localObject).lYu = this.lYu;
      ((com.tencent.mm.ui.contact.a.f)localObject).vYm = true;
    }
    for (;;)
    {
      if (localObject != null)
      {
        ((com.tencent.mm.ui.contact.a.a)localObject).fRC = this.fRC;
        ((com.tencent.mm.ui.contact.a.a)localObject).scene = this.scene;
      }
      GMTrace.o(1710604943360L, 12745);
      return (com.tencent.mm.ui.contact.a.a)localObject;
      if (paramInt == this.vWA)
      {
        localObject = ed(R.l.ene, paramInt);
      }
      else if (paramInt == this.vWB)
      {
        localObject = ed(R.l.emW, paramInt);
      }
      else if (paramInt == this.vTY)
      {
        localObject = ed(R.l.emV, paramInt);
      }
      else if (paramInt == this.vTZ)
      {
        localObject = ed(R.l.emU, paramInt);
      }
      else if (paramInt == this.vWD)
      {
        localObject = u(R.l.emW, paramInt, this.vWC);
      }
      else if (paramInt == this.vWF)
      {
        localObject = u(R.l.emV, paramInt, this.vWE);
      }
      else
      {
        int i;
        if (paramInt > this.vTZ)
        {
          i = paramInt - this.vTZ - 1;
          localObject = new com.tencent.mm.ui.contact.a.d(paramInt);
          ((com.tencent.mm.ui.contact.a.d)localObject).iIW = ((com.tencent.mm.plugin.fts.a.a.i)this.vWH.get(i));
          ((com.tencent.mm.ui.contact.a.d)localObject).lYu = this.lYu;
          ((com.tencent.mm.ui.contact.a.a)localObject).vWh = bcI();
          ((com.tencent.mm.ui.contact.a.d)localObject).vYm = true;
          ((com.tencent.mm.ui.contact.a.d)localObject).mbs = (i + 1);
          ((com.tencent.mm.ui.contact.a.d)localObject).cc(((com.tencent.mm.ui.contact.a.d)localObject).iIW.type, ((com.tencent.mm.ui.contact.a.d)localObject).iIW.hOZ);
        }
        else if (paramInt > this.vTY)
        {
          i = paramInt - this.vTY - 1;
          localObject = new c(paramInt);
          ((c)localObject).iIW = ((com.tencent.mm.plugin.fts.a.a.i)this.maq.get(i));
          ((c)localObject).lYu = this.lYu;
          ((com.tencent.mm.ui.contact.a.a)localObject).vWh = bcI();
          ((c)localObject).vYm = true;
          ((c)localObject).mbs = (i + 1);
          ((c)localObject).cc(((c)localObject).iIW.type, ((c)localObject).iIW.hOZ);
        }
        else if (paramInt > this.vWB)
        {
          i = paramInt - this.vWB - 1;
          localObject = new com.tencent.mm.ui.contact.a.d(paramInt);
          ((com.tencent.mm.ui.contact.a.d)localObject).iIW = ((com.tencent.mm.plugin.fts.a.a.i)this.nvJ.get(i));
          ((com.tencent.mm.ui.contact.a.d)localObject).lYu = this.lYu;
          ((com.tencent.mm.ui.contact.a.a)localObject).vWh = bcI();
          ((com.tencent.mm.ui.contact.a.d)localObject).vYm = true;
          ((com.tencent.mm.ui.contact.a.d)localObject).mbs = (i + 1);
          ((com.tencent.mm.ui.contact.a.d)localObject).cc(((com.tencent.mm.ui.contact.a.d)localObject).iIW.type, ((com.tencent.mm.ui.contact.a.d)localObject).iIW.hOZ);
        }
        else if (paramInt > this.vWA)
        {
          i = paramInt - this.vWA - 1;
          com.tencent.mm.plugin.fts.a.a.i locali = (com.tencent.mm.plugin.fts.a.a.i)this.vWG.get(i);
          if ((locali.type == 131072) || (locali.type == 131076))
          {
            localObject = new com.tencent.mm.ui.contact.a.d(paramInt);
            ((com.tencent.mm.ui.contact.a.d)localObject).iIW = locali;
            ((com.tencent.mm.ui.contact.a.d)localObject).lYu = this.lYu;
            ((com.tencent.mm.ui.contact.a.a)localObject).vWh = bcI();
            ((com.tencent.mm.ui.contact.a.d)localObject).vYl = true;
            ((com.tencent.mm.ui.contact.a.d)localObject).vYm = true;
            ((com.tencent.mm.ui.contact.a.d)localObject).mbs = (i + 1);
            ((com.tencent.mm.ui.contact.a.d)localObject).cc(((com.tencent.mm.ui.contact.a.d)localObject).iIW.type, ((com.tencent.mm.ui.contact.a.d)localObject).iIW.hOZ);
          }
          else if (locali.type == 131075)
          {
            localObject = new c(paramInt);
            ((c)localObject).iIW = locali;
            ((c)localObject).lYu = this.lYu;
            ((com.tencent.mm.ui.contact.a.a)localObject).vWh = bcI();
            ((c)localObject).vYl = true;
            ((c)localObject).vYm = true;
            ((c)localObject).mbs = (i + 1);
            ((c)localObject).cc(((c)localObject).iIW.type, ((c)localObject).iIW.hOZ);
          }
          else
          {
            v.e("MicroMsg.MMSearchContactAdapter", "createTopHitsDataItem return unkown type %d", new Object[] { Integer.valueOf(locali.type) });
            localObject = null;
          }
        }
        else
        {
          v.e("MicroMsg.MMSearchContactAdapter", "unkown position=%d", new Object[] { Integer.valueOf(paramInt) });
          localObject = null;
        }
      }
    }
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/ui/contact/q.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */