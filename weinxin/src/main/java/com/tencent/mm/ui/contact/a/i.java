package com.tencent.mm.ui.contact.a;

import android.content.Context;
import android.content.res.Resources;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.gmtrace.GMTrace;
import com.tencent.mm.R.h;
import com.tencent.mm.R.i;
import com.tencent.mm.R.l;
import com.tencent.mm.plugin.fts.d.e;

public final class i
  extends a
{
  public int roM;
  a.a vYL;
  public boolean vYN;
  private b vYO;
  
  public i(int paramInt)
  {
    super(1, paramInt);
    GMTrace.i(1769526525952L, 13184);
    this.vYO = new b();
    this.vYL = new a();
    GMTrace.o(1769526525952L, 13184);
  }
  
  public final a.b Oc()
  {
    GMTrace.i(1769794961408L, 13186);
    b localb = this.vYO;
    GMTrace.o(1769794961408L, 13186);
    return localb;
  }
  
  protected final a.a Od()
  {
    GMTrace.i(1769929179136L, 13187);
    a.a locala = this.vYL;
    GMTrace.o(1769929179136L, 13187);
    return locala;
  }
  
  public final void br(Context paramContext)
  {
    GMTrace.i(1769660743680L, 13185);
    GMTrace.o(1769660743680L, 13185);
  }
  
  public final class a
    extends a.a
  {
    public TextView vYP;
    public ImageView vYQ;
    
    public a()
    {
      super();
      GMTrace.i(1771137138688L, 13196);
      GMTrace.o(1771137138688L, 13196);
    }
  }
  
  public final class b
    extends a.b
  {
    public b()
    {
      super();
      GMTrace.i(1771271356416L, 13197);
      GMTrace.o(1771271356416L, 13197);
    }
    
    public final boolean Oe()
    {
      GMTrace.i(1771674009600L, 13200);
      GMTrace.o(1771674009600L, 13200);
      return false;
    }
    
    public final View a(Context paramContext, ViewGroup paramViewGroup)
    {
      GMTrace.i(1771405574144L, 13198);
      paramContext = LayoutInflater.from(paramContext).inflate(R.i.dnC, paramViewGroup, false);
      paramViewGroup = (i.a)i.this.vYL;
      paramViewGroup.vYP = ((TextView)paramContext.findViewById(R.h.clf));
      paramViewGroup.vYQ = ((ImageView)paramContext.findViewById(R.h.ckY));
      paramContext.setTag(paramViewGroup);
      GMTrace.o(1771405574144L, 13198);
      return paramContext;
    }
    
    public final void a(Context paramContext, a.a parama, a parama1, boolean paramBoolean1, boolean paramBoolean2)
    {
      GMTrace.i(1771539791872L, 13199);
      parama = (i.a)parama;
      parama1 = (i)parama1;
      paramContext = paramContext.getResources();
      if (i.this.vYN)
      {
        e.a(paramContext.getString(R.l.ePW, new Object[] { paramContext.getString(parama1.roM) }), parama.vYP);
        parama.vYQ.setRotation(0.0F);
        GMTrace.o(1771539791872L, 13199);
        return;
      }
      e.a(paramContext.getString(R.l.ePX), parama.vYP);
      parama.vYQ.setRotation(180.0F);
      GMTrace.o(1771539791872L, 13199);
    }
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/ui/contact/a/i.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */