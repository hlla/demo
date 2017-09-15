package com.tencent.mm.ui.chatting;

import android.view.ContextMenu;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import com.tencent.gmtrace.GMTrace;
import com.tencent.mm.R.i;
import com.tencent.mm.e.b.ce;
import com.tencent.mm.pluginsdk.j.o;
import com.tencent.mm.storage.au;
import com.tencent.mm.ui.l;
import com.tencent.mm.ui.q;

final class cp
  extends ag
{
  public cp()
  {
    super(25);
    GMTrace.i(2226135236608L, 16586);
    GMTrace.o(2226135236608L, 16586);
  }
  
  public final View a(LayoutInflater paramLayoutInflater, View paramView)
  {
    GMTrace.i(2226269454336L, 16587);
    View localView;
    if ((paramView != null) && (paramView.getTag() != null))
    {
      localView = paramView;
      if (((ag.a)paramView.getTag()).type == this.klJ) {}
    }
    else
    {
      localView = paramLayoutInflater.inflate(R.i.cYx, null);
      localView.setTag(new er(this.klJ).ds(localView));
    }
    GMTrace.o(2226269454336L, 16587);
    return localView;
  }
  
  public final void a(ag.a parama, int paramInt, En_5b8fbb1e.a parama1, au paramau, String paramString)
  {
    GMTrace.i(2226537889792L, 16589);
    parama.kvw.setVisibility(0);
    parama.kvw.setText(o.n(parama1.uRf.uRz, paramau.field_createTime));
    GMTrace.o(2226537889792L, 16589);
  }
  
  public final boolean a(ContextMenu paramContextMenu, View paramView, au paramau)
  {
    GMTrace.i(2226672107520L, 16590);
    GMTrace.o(2226672107520L, 16590);
    return false;
  }
  
  public final boolean a(MenuItem paramMenuItem, En_5b8fbb1e.a parama, au paramau)
  {
    GMTrace.i(2226806325248L, 16591);
    GMTrace.o(2226806325248L, 16591);
    return false;
  }
  
  public final boolean a(View paramView, En_5b8fbb1e.a parama, au paramau)
  {
    GMTrace.i(2226940542976L, 16592);
    GMTrace.o(2226940542976L, 16592);
    return false;
  }
  
  protected final boolean bUf()
  {
    GMTrace.i(2226403672064L, 16588);
    GMTrace.o(2226403672064L, 16588);
    return false;
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/ui/chatting/cp.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */