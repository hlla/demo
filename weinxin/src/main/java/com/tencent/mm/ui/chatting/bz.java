package com.tencent.mm.ui.chatting;

import android.view.ContextMenu;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import com.tencent.gmtrace.GMTrace;
import com.tencent.mm.R.h;
import com.tencent.mm.R.i;
import com.tencent.mm.e.b.ce;
import com.tencent.mm.storage.au;

final class bz
  extends ag
{
  private bw vCA;
  private ca vCz;
  
  public bz()
  {
    super(5);
    GMTrace.i(2364916367360L, 17620);
    this.vCz = new ca();
    this.vCA = new bw();
    GMTrace.o(2364916367360L, 17620);
  }
  
  public final View a(LayoutInflater paramLayoutInflater, View paramView)
  {
    GMTrace.i(2365050585088L, 17621);
    View localView;
    if ((paramView != null) && (paramView.getTag() != null))
    {
      localView = paramView;
      if (((ag.a)paramView.getTag()).type == this.klJ) {}
    }
    else
    {
      localView = paramLayoutInflater.inflate(R.i.cXZ, null);
      paramLayoutInflater = new b(this.klJ);
      paramLayoutInflater.mgy = localView;
      paramLayoutInflater.kvw = ((TextView)localView.findViewById(R.h.bBt));
      paramLayoutInflater.stp = ((TextView)localView.findViewById(R.h.bAb));
      localView.setTag(paramLayoutInflater);
    }
    GMTrace.o(2365050585088L, 17621);
    return localView;
  }
  
  public final void a(ag.a parama, int paramInt, En_5b8fbb1e.a parama1, au paramau, String paramString)
  {
    GMTrace.i(2365184802816L, 17622);
    if (paramau.field_type == 10002) {}
    for (paramString = this.vCA;; paramString = this.vCz)
    {
      paramString.a(parama, paramInt, parama1, paramau);
      GMTrace.o(2365184802816L, 17622);
      return;
    }
  }
  
  public final boolean a(ContextMenu paramContextMenu, View paramView, au paramau)
  {
    GMTrace.i(2365453238272L, 17624);
    GMTrace.o(2365453238272L, 17624);
    return false;
  }
  
  public final boolean a(MenuItem paramMenuItem, En_5b8fbb1e.a parama, au paramau)
  {
    GMTrace.i(2365587456000L, 17625);
    GMTrace.o(2365587456000L, 17625);
    return false;
  }
  
  public final boolean a(View paramView, En_5b8fbb1e.a parama, au paramau)
  {
    GMTrace.i(2365721673728L, 17626);
    GMTrace.o(2365721673728L, 17626);
    return false;
  }
  
  protected final boolean bUf()
  {
    GMTrace.i(2365319020544L, 17623);
    GMTrace.o(2365319020544L, 17623);
    return false;
  }
  
  static abstract interface a
  {
    public abstract void a(ag.a parama, int paramInt, En_5b8fbb1e.a parama1, au paramau);
  }
  
  final class b
    extends ag.a
  {
    View mgy;
    TextView stp;
    
    public b(int paramInt)
    {
      super();
      GMTrace.i(2510542602240L, 18705);
      GMTrace.o(2510542602240L, 18705);
    }
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/ui/chatting/bz.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */