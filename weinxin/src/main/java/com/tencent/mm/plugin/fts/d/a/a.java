package com.tencent.mm.plugin.fts.d.a;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import com.tencent.gmtrace.GMTrace;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.fts.a.a.i;
import com.tencent.mm.plugin.fts.a.l;
import com.tencent.mm.plugin.fts.d.j.c;
import com.tencent.mm.sdk.platformtools.v;

public abstract class a
{
  public String fRC;
  public String info;
  public final int klJ;
  public int maK;
  public boolean mbp;
  public boolean mbq;
  public int mbr;
  public int mbs;
  public int mbt;
  public String mbu;
  public long mbv;
  public boolean mbw;
  public int mbx;
  public int mby;
  public boolean mbz;
  public final int position;
  
  public a(int paramInt1, int paramInt2)
  {
    GMTrace.i(16705543733248L, 124466);
    this.klJ = paramInt1;
    this.position = paramInt2;
    v.d("MicroMsg.FTS.FTSDataItem", "create data item | viewType=%d | position=%d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    GMTrace.o(16705543733248L, 124466);
  }
  
  public abstract b So();
  
  public abstract a Sp();
  
  public String Sq()
  {
    GMTrace.i(16706214821888L, 124471);
    GMTrace.o(16706214821888L, 124471);
    return "";
  }
  
  public int Sr()
  {
    GMTrace.i(16706080604160L, 124470);
    GMTrace.o(16706080604160L, 124470);
    return 0;
  }
  
  public abstract void a(Context paramContext, a parama, Object... paramVarArgs);
  
  public int axY()
  {
    GMTrace.i(16706349039616L, 124472);
    GMTrace.o(16706349039616L, 124472);
    return 0;
  }
  
  public boolean axZ()
  {
    GMTrace.i(16706483257344L, 124473);
    GMTrace.o(16706483257344L, 124473);
    return false;
  }
  
  public final void cc(int paramInt1, int paramInt2)
  {
    GMTrace.i(16705946386432L, 124469);
    this.mbx = paramInt1;
    this.mby = paramInt2;
    this.mbz = true;
    GMTrace.o(16705946386432L, 124469);
  }
  
  public abstract class a
  {
    public a()
    {
      GMTrace.i(16708362305536L, 124487);
      GMTrace.o(16708362305536L, 124487);
    }
  }
  
  public abstract class b
  {
    public b()
    {
      GMTrace.i(16706617475072L, 124474);
      GMTrace.o(16706617475072L, 124474);
    }
    
    public static void a(String paramString, i parami)
    {
      GMTrace.i(18565264572416L, 138322);
      ((l)h.j(l.class)).updateTopHitsRank(paramString, parami, 0);
      GMTrace.o(18565264572416L, 138322);
    }
    
    public abstract View a(Context paramContext, ViewGroup paramViewGroup);
    
    public abstract void a(Context paramContext, a.a parama, a paramVarArgs);
    
    public abstract boolean a(Context paramContext, a paramVarArgs);
    
    public final void ce(View paramView)
    {
      GMTrace.i(16707154345984L, 124478);
      if (a.this.mbq)
      {
        paramView.setBackgroundResource(j.c.beo);
        GMTrace.o(16707154345984L, 124478);
        return;
      }
      paramView.setBackgroundResource(j.c.ben);
      GMTrace.o(16707154345984L, 124478);
    }
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/plugin/fts/d/a/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */