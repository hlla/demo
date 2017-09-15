package com.tencent.mm.ui.chatting;

import android.content.Context;
import android.view.ContextMenu;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;
import com.tencent.gmtrace.GMTrace;
import com.tencent.mm.R.i;
import com.tencent.mm.R.l;
import com.tencent.mm.aa.a;
import com.tencent.mm.aa.a.a;
import com.tencent.mm.e.b.ce;
import com.tencent.mm.pluginsdk.ui.d.h;
import com.tencent.mm.storage.au;

final class bx
  extends cb
{
  private En_5b8fbb1e.a vAn;
  
  public bx()
  {
    super(36);
    GMTrace.i(2282104029184L, 17003);
    GMTrace.o(2282104029184L, 17003);
  }
  
  public final View a(LayoutInflater paramLayoutInflater, View paramView)
  {
    GMTrace.i(2282238246912L, 17004);
    Object localObject;
    if ((paramView != null) && (paramView.getTag() != null))
    {
      localObject = paramView;
      if (((ag.a)paramView.getTag()).type == this.klJ) {}
    }
    else
    {
      localObject = new bi(paramLayoutInflater, R.i.cXY);
      ((View)localObject).setTag(new eb(this.klJ).ds((View)localObject));
    }
    GMTrace.o(2282238246912L, 17004);
    return (View)localObject;
  }
  
  public final void a(ag.a parama, int paramInt, En_5b8fbb1e.a parama1, au paramau, String paramString)
  {
    GMTrace.i(2282372464640L, 17005);
    this.vAn = parama1;
    parama = (eb)parama;
    paramString = a.a.iH(paramau.field_content);
    String str = paramString.fOl;
    a(parama, parama1, paramau, str);
    a(parama, parama1, str, paramau);
    h.a(parama.stp.getContext(), a.a(paramString), (int)parama.stp.getTextSize(), null, "");
    parama.stp.setTag(new ds(paramau, parama1.vvA, paramInt, null, 0, (byte)0));
    parama.stp.setOnClickListener(parama1.vzN.vDb);
    parama.stp.setOnLongClickListener(parama1.vzN.vDd);
    GMTrace.o(2282372464640L, 17005);
  }
  
  public final boolean a(ContextMenu paramContextMenu, View paramView, au paramau)
  {
    GMTrace.i(2282640900096L, 17007);
    if (paramau.bMh())
    {
      int i = ((ds)paramView.getTag()).position;
      if (paramau.field_status == 5) {
        paramContextMenu.add(i, 103, 0, paramView.getContext().getString(R.l.dVe));
      }
      if (!this.vAn.bVz()) {
        paramContextMenu.add(i, 100, 0, paramView.getContext().getString(R.l.dUh));
      }
    }
    GMTrace.o(2282640900096L, 17007);
    return true;
  }
  
  protected final boolean bUf()
  {
    GMTrace.i(2282506682368L, 17006);
    GMTrace.o(2282506682368L, 17006);
    return false;
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/ui/chatting/bx.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */