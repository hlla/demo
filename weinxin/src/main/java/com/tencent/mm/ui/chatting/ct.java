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

final class ct
  extends ag
{
  public ct()
  {
    super(38);
    GMTrace.i(2271635046400L, 16925);
    GMTrace.o(2271635046400L, 16925);
  }
  
  public final View a(LayoutInflater paramLayoutInflater, View paramView)
  {
    GMTrace.i(2271769264128L, 16926);
    View localView;
    if ((paramView != null) && (paramView.getTag() != null))
    {
      localView = paramView;
      if (((ag.a)paramView.getTag()).type == this.klJ) {}
    }
    else
    {
      localView = paramLayoutInflater.inflate(R.i.cYx, null);
      localView.setTag(new es(this.klJ).ds(localView));
    }
    GMTrace.o(2271769264128L, 16926);
    return localView;
  }
  
  public final void a(ag.a parama, int paramInt, En_5b8fbb1e.a parama1, au paramau, String paramString)
  {
    GMTrace.i(2272037699584L, 16928);
    parama.kvw.setVisibility(0);
    parama.kvw.setText(o.o(parama1.uRf.uRz, paramau.field_createTime));
    GMTrace.o(2272037699584L, 16928);
  }
  
  public final boolean a(ContextMenu paramContextMenu, View paramView, au paramau)
  {
    GMTrace.i(2272171917312L, 16929);
    GMTrace.o(2272171917312L, 16929);
    return false;
  }
  
  public final boolean a(MenuItem paramMenuItem, En_5b8fbb1e.a parama, au paramau)
  {
    GMTrace.i(2272306135040L, 16930);
    GMTrace.o(2272306135040L, 16930);
    return false;
  }
  
  public final boolean a(View paramView, En_5b8fbb1e.a parama, au paramau)
  {
    GMTrace.i(2272440352768L, 16931);
    GMTrace.o(2272440352768L, 16931);
    return false;
  }
  
  protected final boolean bUf()
  {
    GMTrace.i(2271903481856L, 16927);
    GMTrace.o(2271903481856L, 16927);
    return false;
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/ui/chatting/ct.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */