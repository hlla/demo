package com.tencent.mm.ui.contact.a;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.gmtrace.GMTrace;
import com.tencent.mm.R.f;
import com.tencent.mm.R.h;
import com.tencent.mm.R.i;
import com.tencent.mm.e.b.af;
import com.tencent.mm.pluginsdk.ui.d.h;
import com.tencent.mm.u.n;

public class e
  extends a
{
  public CharSequence ioW;
  public String username;
  a vYA;
  public CharSequence vYx;
  public int vYy;
  private b vYz;
  
  public e(int paramInt)
  {
    super(4, paramInt);
    GMTrace.i(1770063396864L, 13188);
    this.vYy = 0;
    this.vYz = new b();
    this.vYA = new a();
    GMTrace.o(1770063396864L, 13188);
  }
  
  public final a.b Oc()
  {
    GMTrace.i(1770331832320L, 13190);
    b localb = this.vYz;
    GMTrace.o(1770331832320L, 13190);
    return localb;
  }
  
  protected final a.a Od()
  {
    GMTrace.i(1770466050048L, 13191);
    a locala = this.vYA;
    GMTrace.o(1770466050048L, 13191);
    return locala;
  }
  
  public void br(Context paramContext)
  {
    GMTrace.i(1770197614592L, 13189);
    if ((this.vYy != 0) && (this.vYx != null))
    {
      GMTrace.o(1770197614592L, 13189);
      return;
    }
    if (this.jht == null)
    {
      this.ioW = "";
      this.username = "";
      GMTrace.o(1770197614592L, 13189);
      return;
    }
    this.ioW = h.c(paramContext, n.c(this.jht), com.tencent.mm.bg.a.T(paramContext, R.f.aXH));
    this.username = this.jht.field_username;
    GMTrace.o(1770197614592L, 13189);
  }
  
  public final class a
    extends a.a
  {
    public ImageView ipb;
    public TextView ipd;
    public CheckBox ipe;
    public TextView jUr;
    
    public a()
    {
      super();
      GMTrace.i(1769258090496L, 13182);
      GMTrace.o(1769258090496L, 13182);
    }
  }
  
  public final class b
    extends a.b
  {
    public b()
    {
      super();
      GMTrace.i(1767781695488L, 13171);
      GMTrace.o(1767781695488L, 13171);
    }
    
    public final boolean Oe()
    {
      GMTrace.i(1768184348672L, 13174);
      GMTrace.o(1768184348672L, 13174);
      return false;
    }
    
    public final View a(Context paramContext, ViewGroup paramViewGroup)
    {
      GMTrace.i(1767915913216L, 13172);
      if (com.tencent.mm.bg.a.dM(paramContext)) {}
      for (paramContext = LayoutInflater.from(paramContext).inflate(R.i.dny, paramViewGroup, false);; paramContext = LayoutInflater.from(paramContext).inflate(R.i.dnx, paramViewGroup, false))
      {
        paramViewGroup = (e.a)e.this.vYA;
        paramViewGroup.ipb = ((ImageView)paramContext.findViewById(R.h.bqF));
        paramViewGroup.jUr = ((TextView)paramContext.findViewById(R.h.cIY));
        paramViewGroup.ipd = ((TextView)paramContext.findViewById(R.h.bHU));
        paramViewGroup.ipd.setVisibility(8);
        paramViewGroup.ipe = ((CheckBox)paramContext.findViewById(R.h.cBy));
        paramContext.setTag(paramViewGroup);
        GMTrace.o(1767915913216L, 13172);
        return paramContext;
      }
    }
    
    public final void a(Context paramContext, a.a parama, a parama1, boolean paramBoolean1, boolean paramBoolean2)
    {
      GMTrace.i(1768050130944L, 13173);
      paramContext = (e)parama1;
      parama = (e.a)parama;
      if ((e.this.vYy != 0) && (e.this.vYx != null))
      {
        parama.ipb.setImageResource(e.this.vYy);
        parama.jUr.setText(e.this.vYx);
        GMTrace.o(1768050130944L, 13173);
        return;
      }
      com.tencent.mm.plugin.fts.d.e.a(paramContext.ioW, parama.jUr);
      com.tencent.mm.pluginsdk.ui.a.b.a(parama.ipb, paramContext.username);
      if (e.this.vWh)
      {
        if (paramBoolean1)
        {
          parama.ipe.setChecked(true);
          parama.ipe.setEnabled(false);
        }
        for (;;)
        {
          parama.ipe.setVisibility(0);
          GMTrace.o(1768050130944L, 13173);
          return;
          parama.ipe.setChecked(paramBoolean2);
          parama.ipe.setEnabled(true);
        }
      }
      parama.ipe.setVisibility(8);
      GMTrace.o(1768050130944L, 13173);
    }
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/ui/contact/a/e.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */