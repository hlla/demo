package com.tencent.mm.ui.contact.a;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.TextView;
import com.tencent.gmtrace.GMTrace;
import com.tencent.mm.R.g;
import com.tencent.mm.R.h;
import com.tencent.mm.R.i;
import com.tencent.mm.R.l;

public final class j
  extends a
{
  private a vYS;
  b vYT;
  
  public j(int paramInt)
  {
    super(7, paramInt);
    GMTrace.i(16856672894976L, 125592);
    this.vYS = new a();
    this.vYT = new b();
    GMTrace.o(16856672894976L, 125592);
  }
  
  public final a.b Oc()
  {
    GMTrace.i(16856941330432L, 125594);
    a locala = this.vYS;
    GMTrace.o(16856941330432L, 125594);
    return locala;
  }
  
  protected final a.a Od()
  {
    GMTrace.i(16857075548160L, 125595);
    b localb = this.vYT;
    GMTrace.o(16857075548160L, 125595);
    return localb;
  }
  
  public final void br(Context paramContext)
  {
    GMTrace.i(16856807112704L, 125593);
    GMTrace.o(16856807112704L, 125593);
  }
  
  public final class a
    extends a.b
  {
    public a()
    {
      super();
      GMTrace.i(16856136024064L, 125588);
      GMTrace.o(16856136024064L, 125588);
    }
    
    public final boolean Oe()
    {
      GMTrace.i(16856538677248L, 125591);
      GMTrace.o(16856538677248L, 125591);
      return false;
    }
    
    public final View a(Context paramContext, ViewGroup paramViewGroup)
    {
      GMTrace.i(16856270241792L, 125589);
      paramContext = LayoutInflater.from(paramContext).inflate(R.i.dnD, paramViewGroup, false);
      paramViewGroup = (j.b)j.this.vYT;
      paramViewGroup.ipc = ((TextView)paramContext.findViewById(R.h.cIY));
      paramViewGroup.ipa = paramContext.findViewById(R.h.cBJ);
      paramViewGroup.ipe = ((CheckBox)paramContext.findViewById(R.h.cBy));
      paramContext.setTag(paramViewGroup);
      GMTrace.o(16856270241792L, 125589);
      return paramContext;
    }
    
    public final void a(Context paramContext, a.a parama, a parama1, boolean paramBoolean1, boolean paramBoolean2)
    {
      GMTrace.i(16856404459520L, 125590);
      paramContext = (j.b)parama;
      paramContext.ipc.setText(R.l.eQf);
      paramContext.ipe.setBackgroundResource(R.g.bgV);
      paramContext.ipe.setChecked(paramBoolean2);
      paramContext.ipe.setEnabled(true);
      paramContext.ipe.setVisibility(0);
      paramContext.ipa.setBackgroundResource(R.g.beo);
      GMTrace.o(16856404459520L, 125590);
    }
  }
  
  public final class b
    extends a.a
  {
    public View ipa;
    public TextView ipc;
    public CheckBox ipe;
    
    public b()
    {
      super();
      GMTrace.i(16857209765888L, 125596);
      GMTrace.o(16857209765888L, 125596);
    }
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/ui/contact/a/j.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */