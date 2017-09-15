package com.tencent.mm.ui.bizchat;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.gmtrace.GMTrace;
import com.tencent.mm.R.f;
import com.tencent.mm.R.h;
import com.tencent.mm.R.i;
import com.tencent.mm.R.k;
import com.tencent.mm.ah.a.a.c;
import com.tencent.mm.ah.a.a.c.a;
import com.tencent.mm.ah.n;
import com.tencent.mm.pluginsdk.ui.d.h;
import java.util.HashMap;
import java.util.Map;

public final class a
  extends com.tencent.mm.ui.contact.a.a
{
  private static Map<String, c> vtw;
  public CharSequence ioW;
  public long jZq;
  public String username;
  public String vtv;
  private b vtx;
  a vty;
  
  static
  {
    GMTrace.i(2973862199296L, 22157);
    vtw = new HashMap();
    GMTrace.o(2973862199296L, 22157);
  }
  
  public a(int paramInt)
  {
    super(4, paramInt);
    GMTrace.i(2973191110656L, 22152);
    this.jZq = -1L;
    this.vtx = new b();
    this.vty = new a();
    GMTrace.o(2973191110656L, 22152);
  }
  
  public static c Th(String paramString)
  {
    GMTrace.i(16020093796352L, 119359);
    if (paramString == null)
    {
      GMTrace.o(16020093796352L, 119359);
      return null;
    }
    if ((vtw.containsKey(paramString)) && (vtw.get(paramString) != null))
    {
      paramString = (c)vtw.get(paramString);
      GMTrace.o(16020093796352L, 119359);
      return paramString;
    }
    Object localObject = new c.a();
    ((c.a)localObject).hIw = com.tencent.mm.modelbiz.a.e.iA(paramString);
    ((c.a)localObject).hIt = true;
    ((c.a)localObject).hIP = true;
    ((c.a)localObject).hII = R.k.ber;
    localObject = ((c.a)localObject).Hh();
    vtw.put(paramString, localObject);
    GMTrace.o(16020093796352L, 119359);
    return (c)localObject;
  }
  
  public final com.tencent.mm.ui.contact.a.a.b Oc()
  {
    GMTrace.i(2973459546112L, 22154);
    b localb = this.vtx;
    GMTrace.o(2973459546112L, 22154);
    return localb;
  }
  
  protected final com.tencent.mm.ui.contact.a.a.a Od()
  {
    GMTrace.i(2973593763840L, 22155);
    a locala = this.vty;
    GMTrace.o(2973593763840L, 22155);
    return locala;
  }
  
  public final void br(Context paramContext)
  {
    GMTrace.i(2973325328384L, 22153);
    this.ioW = h.c(paramContext, this.ioW, com.tencent.mm.bg.a.T(paramContext, R.f.aXH));
    GMTrace.o(2973325328384L, 22153);
  }
  
  public final class a
    extends com.tencent.mm.ui.contact.a.a.a
  {
    public ImageView ipb;
    public TextView ipd;
    public TextView jUr;
    
    public a()
    {
      super();
      GMTrace.i(2990102544384L, 22278);
      GMTrace.o(2990102544384L, 22278);
    }
  }
  
  public final class b
    extends com.tencent.mm.ui.contact.a.a.b
  {
    public b()
    {
      super();
      GMTrace.i(2984733835264L, 22238);
      GMTrace.o(2984733835264L, 22238);
    }
    
    public final boolean Oe()
    {
      GMTrace.i(2985136488448L, 22241);
      GMTrace.o(2985136488448L, 22241);
      return false;
    }
    
    public final View a(Context paramContext, ViewGroup paramViewGroup)
    {
      GMTrace.i(2984868052992L, 22239);
      if (com.tencent.mm.bg.a.dM(paramContext)) {}
      for (paramContext = LayoutInflater.from(paramContext).inflate(R.i.dny, paramViewGroup, false);; paramContext = LayoutInflater.from(paramContext).inflate(R.i.dnx, paramViewGroup, false))
      {
        paramViewGroup = (a.a)a.this.vty;
        paramViewGroup.ipb = ((ImageView)paramContext.findViewById(R.h.bqF));
        paramViewGroup.jUr = ((TextView)paramContext.findViewById(R.h.cIY));
        paramViewGroup.ipd = ((TextView)paramContext.findViewById(R.h.bHU));
        paramViewGroup.ipd.setVisibility(8);
        paramContext.setTag(paramViewGroup);
        GMTrace.o(2984868052992L, 22239);
        return paramContext;
      }
    }
    
    public final void a(Context paramContext, com.tencent.mm.ui.contact.a.a.a parama, com.tencent.mm.ui.contact.a.a parama1, boolean paramBoolean1, boolean paramBoolean2)
    {
      GMTrace.i(2985002270720L, 22240);
      paramContext = (a)parama1;
      parama = (a.a)parama;
      com.tencent.mm.plugin.fts.d.e.a(paramContext.ioW, parama.jUr);
      n.GX().a(paramContext.vtv, parama.ipb, a.Th(paramContext.username));
      GMTrace.o(2985002270720L, 22240);
    }
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/ui/bizchat/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */