package com.tencent.mm.ui.contact.a;

import android.content.Context;
import android.text.TextPaint;
import android.view.View;
import android.view.ViewGroup;
import com.tencent.gmtrace.GMTrace;
import com.tencent.mm.R.f;
import com.tencent.mm.sdk.platformtools.aa;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.storage.x;

public abstract class a
{
  public static final int maP;
  public static final TextPaint maQ;
  public static final int maR;
  public static final TextPaint maS;
  public String fEK;
  public String fRC;
  public boolean jYD;
  public x jht;
  public final int klJ;
  public int mbs;
  public int mbx;
  public int mby;
  public final int position;
  public int scene;
  public boolean vWh;
  public boolean vWi;
  public boolean vYk;
  public boolean vYl;
  public boolean vYm;
  
  static
  {
    GMTrace.i(1776774283264L, 13238);
    maP = com.tencent.mm.bg.a.T(aa.getContext(), R.f.aXH);
    maR = com.tencent.mm.bg.a.T(aa.getContext(), R.f.aXr);
    maQ = new TextPaint();
    maS = new TextPaint();
    maQ.setTextSize(maP);
    maS.setTextSize(maR);
    GMTrace.o(1776774283264L, 13238);
  }
  
  public a(int paramInt1, int paramInt2)
  {
    GMTrace.i(1775968976896L, 13232);
    this.klJ = paramInt1;
    this.position = paramInt2;
    v.i("MicroMsg.BaseContactDataItem", "Create BaseContactDataItem viewType=%d | position=%d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    GMTrace.o(1775968976896L, 13232);
  }
  
  public abstract b Oc();
  
  public abstract a Od();
  
  public boolean axZ()
  {
    GMTrace.i(1776640065536L, 13237);
    GMTrace.o(1776640065536L, 13237);
    return false;
  }
  
  public abstract void br(Context paramContext);
  
  public final void cc(int paramInt1, int paramInt2)
  {
    GMTrace.i(1776505847808L, 13236);
    this.mbx = paramInt1;
    this.mby = paramInt2;
    GMTrace.o(1776505847808L, 13236);
  }
  
  public class a
  {
    public a()
    {
      GMTrace.i(1771808227328L, 13201);
      GMTrace.o(1771808227328L, 13201);
    }
  }
  
  public abstract class b
  {
    public b()
    {
      GMTrace.i(1773418840064L, 13213);
      GMTrace.o(1773418840064L, 13213);
    }
    
    public abstract boolean Oe();
    
    public abstract View a(Context paramContext, ViewGroup paramViewGroup);
    
    public abstract void a(Context paramContext, a.a parama, a parama1, boolean paramBoolean1, boolean paramBoolean2);
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/ui/contact/a/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */