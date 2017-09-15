package com.tencent.mm.ui.chatting;

import android.content.Context;
import android.view.ContextMenu;
import android.view.View;
import android.widget.ProgressBar;
import com.tencent.gmtrace.GMTrace;
import com.tencent.mm.R.l;
import com.tencent.mm.aa.a;
import com.tencent.mm.aa.a.a;
import com.tencent.mm.e.b.ce;
import com.tencent.mm.pluginsdk.ui.d.h;
import com.tencent.mm.storage.au;
import com.tencent.mm.ui.widget.celltextview.CellTextView;

final class by
  extends cc
{
  private En_5b8fbb1e.a vAn;
  
  public by()
  {
    super(37);
    GMTrace.i(2254992048128L, 16801);
    GMTrace.o(2254992048128L, 16801);
  }
  
  public final void a(ag.a parama, int paramInt, En_5b8fbb1e.a parama1, au paramau, String paramString)
  {
    GMTrace.i(2255126265856L, 16802);
    this.vAn = parama1;
    parama = (ek)parama;
    paramString = a.a.iH(paramau.field_content);
    if (paramau.field_status >= 2) {
      parama.oCh.setVisibility(8);
    }
    for (;;)
    {
      h.a(parama.xoi.getContext(), a.a(paramString), (int)parama.xoi.getTextSize(), null, "");
      parama.xoi.setTag(new ds(paramau, parama1.vvA, paramInt, null, 0, (byte)0));
      parama.xoi.setOnClickListener(parama1.vzN.vDb);
      parama.xoi.setOnLongClickListener(parama1.vzN.vDd);
      a(paramInt, parama, paramau, parama1.vzN.hrv, parama1.vvA, parama1.vzN.vDb);
      GMTrace.o(2255126265856L, 16802);
      return;
      parama.oCh.setVisibility(0);
    }
  }
  
  public final boolean a(ContextMenu paramContextMenu, View paramView, au paramau)
  {
    GMTrace.i(2255260483584L, 16803);
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
    GMTrace.o(2255260483584L, 16803);
    return true;
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/ui/chatting/by.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */