package com.tencent.mm.ui.chatting;

import android.content.Context;
import android.view.ContextMenu;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.gmtrace.GMTrace;
import com.tencent.mm.R.g;
import com.tencent.mm.R.h;
import com.tencent.mm.R.i;
import com.tencent.mm.R.l;
import com.tencent.mm.e.b.ce;
import com.tencent.mm.pluginsdk.model.app.an;
import com.tencent.mm.pluginsdk.model.app.k;
import com.tencent.mm.pluginsdk.model.app.l;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.storage.au;
import com.tencent.mm.t.f;
import com.tencent.mm.t.f.a;
import com.tencent.mm.u.ay;

public final class bq
  extends ag
{
  public bq()
  {
    super(58);
    GMTrace.i(2498731442176L, 18617);
    GMTrace.o(2498731442176L, 18617);
  }
  
  public final View a(LayoutInflater paramLayoutInflater, View paramView)
  {
    GMTrace.i(2498865659904L, 18618);
    Object localObject;
    if ((paramView != null) && (paramView.getTag() != null) && ((paramView.getTag() instanceof a)))
    {
      localObject = paramView;
      if (((a)paramView.getTag()).type == this.klJ) {}
    }
    else
    {
      localObject = new bi(paramLayoutInflater, R.i.cXU);
      ((View)localObject).setTag(new a(this.klJ).dp((View)localObject));
    }
    GMTrace.o(2498865659904L, 18618);
    return (View)localObject;
  }
  
  public final void a(ag.a parama, int paramInt, En_5b8fbb1e.a parama1, au paramau, String paramString)
  {
    GMTrace.i(2498999877632L, 18619);
    a locala = (a)parama;
    f localf = an.bDc().ec(paramau.field_msgId);
    String str = paramau.field_content;
    if ((localf != null) && (str != null))
    {
      paramString = f.a.B(str, paramau.field_reserved);
      paramau = new ds(paramau, parama1.vvA, paramInt, null, 0, (byte)0);
      if ((paramString != null) && ((paramString.showType == 3) || (paramString.hia == 3)))
      {
        locala.hAQ.setImageResource(R.g.bfF);
        locala.vCa.setText(paramString.hif);
      }
      parama.vAj.setOnLongClickListener(parama1.vzN.vDd);
      parama.vAj.setOnTouchListener(parama1.vzN.vDf);
      parama.vAj.setTag(paramau);
      parama.vAj.setOnClickListener(parama1.vzN.vDb);
      GMTrace.o(2498999877632L, 18619);
      return;
    }
    if (localf == null) {}
    for (boolean bool = true;; bool = false)
    {
      v.e("MicroMsg.ChattingItemHardDeviceMsgPush", "amessage:%b, %s, %d, %s", new Object[] { Boolean.valueOf(bool), str, Long.valueOf(paramau.field_msgId), paramString });
      paramString = null;
      break;
    }
  }
  
  public final boolean a(ContextMenu paramContextMenu, View paramView, au paramau)
  {
    GMTrace.i(2499134095360L, 18620);
    paramContextMenu.add(((ds)paramView.getTag()).position, 100, 0, paramView.getContext().getString(R.l.dUh));
    GMTrace.o(2499134095360L, 18620);
    return false;
  }
  
  public final boolean a(MenuItem paramMenuItem, En_5b8fbb1e.a parama, au paramau)
  {
    GMTrace.i(2499268313088L, 18621);
    switch (paramMenuItem.getItemId())
    {
    }
    for (;;)
    {
      GMTrace.o(2499268313088L, 18621);
      return false;
      parama = paramau.field_content;
      paramMenuItem = null;
      if (parama != null) {
        paramMenuItem = f.a.ek(parama);
      }
      if (paramMenuItem != null) {
        l.ed(paramau.field_msgId);
      }
      ay.L(paramau.field_msgId);
    }
  }
  
  public final boolean a(View paramView, En_5b8fbb1e.a parama, au paramau)
  {
    GMTrace.i(2499402530816L, 18622);
    GMTrace.o(2499402530816L, 18622);
    return false;
  }
  
  final class a
    extends ag.a
  {
    protected ImageView hAQ;
    protected TextView vCa;
    
    public a(int paramInt)
    {
      super();
      GMTrace.i(2266400555008L, 16886);
      GMTrace.o(2266400555008L, 16886);
    }
    
    public final a dp(View paramView)
    {
      GMTrace.i(2266534772736L, 16887);
      super.dl(paramView);
      this.mdQ = ((CheckBox)paramView.findViewById(R.h.bzW));
      this.hAQ = ((ImageView)paramView.findViewById(R.h.ctq));
      this.vCa = ((TextView)paramView.findViewById(R.h.cIx));
      GMTrace.o(2266534772736L, 16887);
      return this;
    }
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/ui/chatting/bq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */