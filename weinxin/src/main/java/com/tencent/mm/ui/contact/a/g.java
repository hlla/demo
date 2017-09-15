package com.tencent.mm.ui.contact.a;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.tencent.gmtrace.GMTrace;
import com.tencent.mm.R.h;
import com.tencent.mm.R.i;
import com.tencent.mm.plugin.fts.d.e;

public final class g
  extends a
{
  public String mbB;
  private b vYG;
  a vYH;
  
  public g(int paramInt)
  {
    super(0, paramInt);
    GMTrace.i(1767244824576L, 13167);
    this.vYG = new b();
    this.vYH = new a();
    GMTrace.o(1767244824576L, 13167);
  }
  
  public final a.b Oc()
  {
    GMTrace.i(1767513260032L, 13169);
    b localb = this.vYG;
    GMTrace.o(1767513260032L, 13169);
    return localb;
  }
  
  protected final a.a Od()
  {
    GMTrace.i(1767647477760L, 13170);
    a locala = this.vYH;
    GMTrace.o(1767647477760L, 13170);
    return locala;
  }
  
  public final void br(Context paramContext)
  {
    GMTrace.i(1767379042304L, 13168);
    GMTrace.o(1767379042304L, 13168);
  }
  
  public final class a
    extends a.a
  {
    public TextView kxs;
    
    public a()
    {
      super();
      GMTrace.i(1769123872768L, 13181);
      GMTrace.o(1769123872768L, 13181);
    }
  }
  
  public final class b
    extends a.b
  {
    public b()
    {
      super();
      GMTrace.i(1774761017344L, 13223);
      GMTrace.o(1774761017344L, 13223);
    }
    
    public final boolean Oe()
    {
      GMTrace.i(1775163670528L, 13226);
      GMTrace.o(1775163670528L, 13226);
      return false;
    }
    
    public final View a(Context paramContext, ViewGroup paramViewGroup)
    {
      GMTrace.i(1774895235072L, 13224);
      paramContext = LayoutInflater.from(paramContext).inflate(R.i.dnA, paramViewGroup, false);
      paramViewGroup = (g.a)g.this.vYH;
      paramViewGroup.kxs = ((TextView)paramContext.findViewById(R.h.bVZ));
      paramContext.setTag(paramViewGroup);
      GMTrace.o(1774895235072L, 13224);
      return paramContext;
    }
    
    public final void a(Context paramContext, a.a parama, a parama1, boolean paramBoolean1, boolean paramBoolean2)
    {
      GMTrace.i(1775029452800L, 13225);
      paramContext = (g.a)parama;
      e.a(((g)parama1).mbB, paramContext.kxs);
      GMTrace.o(1775029452800L, 13225);
    }
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/ui/contact/a/g.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */