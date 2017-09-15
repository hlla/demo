package com.tencent.mm.ui.conversation.a;

import android.content.Context;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.gmtrace.GMTrace;
import com.tencent.mm.R.h;
import com.tencent.mm.R.i;
import com.tencent.mm.R.l;
import com.tencent.mm.e.a.hz;
import com.tencent.mm.e.a.qt;
import com.tencent.mm.modelmulti.m;
import com.tencent.mm.pluginsdk.ui.b.b;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.v;

public final class n
  extends b
{
  private TextView ipc;
  private View jHa;
  private ImageView jaK;
  private boolean wdH;
  boolean wdL;
  private c wdM;
  
  public n(Context paramContext)
  {
    super(paramContext);
    GMTrace.i(14504775647232L, 108069);
    this.wdH = false;
    this.jHa = null;
    this.wdL = false;
    if ((!this.wdH) && (this.view != null))
    {
      this.jHa = this.view.findViewById(R.h.cJc);
      this.ipc = ((TextView)this.view.findViewById(R.h.cJa));
      this.jaK = ((ImageView)this.view.findViewById(R.h.cJb));
      this.wdH = true;
      this.wdM = new c() {};
      a.uql.b(this.wdM);
    }
    GMTrace.o(14504775647232L, 108069);
  }
  
  public final boolean Xd()
  {
    GMTrace.i(14505044082688L, 108071);
    if (!this.wdL)
    {
      v.i("MicroMsg.TryNewInitBanner", "summerinit update but initFailed[%b] just ret update false", new Object[] { Boolean.valueOf(this.wdL) });
      this.jHa.setVisibility(8);
      GMTrace.o(14505044082688L, 108071);
      return false;
    }
    if (!m.Hw())
    {
      v.i("MicroMsg.TryNewInitBanner", "summerinit update but not need init just update false");
      this.wdL = false;
      this.jHa.setVisibility(8);
      GMTrace.o(14505044082688L, 108071);
      return false;
    }
    this.ipc.setText(R.l.dMP);
    this.jaK.setVisibility(0);
    this.jHa.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        GMTrace.i(14510412791808L, 108111);
        v.i("MicroMsg.TryNewInitBanner", "summerinit onClick trynewinit layout start try");
        n.this.setVisibility(8);
        a.uql.m(new qt());
        v.i("MicroMsg.TryNewInitBanner", "summerinit onClick tryNeeInitAgain done callBack (now by event to notice initbanner)");
        GMTrace.o(14510412791808L, 108111);
      }
    });
    this.jHa.setVisibility(0);
    if (this.jHa.getVisibility() == 0) {}
    for (boolean bool = true;; bool = false)
    {
      v.i("MicroMsg.TryNewInitBanner", "summerinit update set visible [%b]", new Object[] { Boolean.valueOf(bool) });
      GMTrace.o(14505044082688L, 108071);
      return true;
    }
  }
  
  public final void destroy()
  {
    GMTrace.i(14505312518144L, 108073);
    a.uql.c(this.wdM);
    GMTrace.o(14505312518144L, 108073);
  }
  
  public final int getLayoutId()
  {
    GMTrace.i(14504909864960L, 108070);
    int i = R.i.dpa;
    GMTrace.o(14504909864960L, 108070);
    return i;
  }
  
  public final void setVisibility(int paramInt)
  {
    GMTrace.i(14505178300416L, 108072);
    if (this.jHa != null) {
      this.jHa.setVisibility(paramInt);
    }
    GMTrace.o(14505178300416L, 108072);
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/ui/conversation/a/n.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */