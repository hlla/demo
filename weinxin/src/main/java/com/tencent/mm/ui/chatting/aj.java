package com.tencent.mm.ui.chatting;

import android.content.Intent;
import android.view.ContextMenu;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import com.tencent.gmtrace.GMTrace;
import com.tencent.mm.R.i;
import com.tencent.mm.R.l;
import com.tencent.mm.bb.d;
import com.tencent.mm.e.b.ce;
import com.tencent.mm.sdk.platformtools.bf;
import com.tencent.mm.storage.au;
import com.tencent.mm.t.f.a;
import com.tencent.mm.u.ay;
import com.tencent.mm.ui.l;
import com.tencent.mm.ui.q;

final class aj
  extends ag.c
{
  private En_5b8fbb1e.a vAn;
  
  public aj()
  {
    super(64);
    GMTrace.i(2183051345920L, 16265);
    GMTrace.o(2183051345920L, 16265);
  }
  
  public final View a(LayoutInflater paramLayoutInflater, View paramView)
  {
    GMTrace.i(2183185563648L, 16266);
    Object localObject;
    if ((paramView != null) && (paramView.getTag() != null) && ((paramView.getTag() instanceof f)))
    {
      localObject = paramView;
      if (((ag.a)paramView.getTag()).type == this.klJ) {}
    }
    else
    {
      localObject = new bi(paramLayoutInflater, R.i.cYd);
      ((View)localObject).setTag(new f(this.klJ).df((View)localObject));
    }
    GMTrace.o(2183185563648L, 16266);
    return (View)localObject;
  }
  
  public final void a(ag.a parama, int paramInt, En_5b8fbb1e.a parama1, au paramau, String paramString)
  {
    GMTrace.i(2183319781376L, 16267);
    this.vAn = parama1;
    paramString = paramau.field_content;
    if (paramString != null) {}
    for (paramString = f.a.B(paramString, paramau.field_reserved);; paramString = null)
    {
      f localf = (f)parama;
      if (paramString != null) {
        if (paramau.field_isSend != 1) {
          break label156;
        }
      }
      label156:
      for (paramString = paramString.hiH;; paramString = paramString.hiI)
      {
        localf.vwz.setText(paramString);
        parama.vAj.setOnClickListener(parama1.vzN.vDb);
        parama.vAj.setOnLongClickListener(parama1.vzN.vDd);
        parama.vAj.setOnTouchListener(parama1.vzN.vDf);
        parama1 = new ds(paramau, this.vAn.vvA, paramInt, null, 0, (byte)0);
        parama.vAj.setTag(parama1);
        GMTrace.o(2183319781376L, 16267);
        return;
      }
    }
  }
  
  public final boolean a(ContextMenu paramContextMenu, View paramView, au paramau)
  {
    GMTrace.i(2183453999104L, 16268);
    paramContextMenu.add(((ds)paramView.getTag()).position, 100, 0, this.vAn.getString(R.l.dUh));
    GMTrace.o(2183453999104L, 16268);
    return false;
  }
  
  public final boolean a(MenuItem paramMenuItem, En_5b8fbb1e.a parama, au paramau)
  {
    GMTrace.i(2183588216832L, 16269);
    switch (paramMenuItem.getItemId())
    {
    default: 
      GMTrace.o(2183588216832L, 16269);
      return false;
    }
    ay.L(paramau.field_msgId);
    GMTrace.o(2183588216832L, 16269);
    return true;
  }
  
  public final boolean a(View paramView, En_5b8fbb1e.a parama, au paramau)
  {
    GMTrace.i(2183722434560L, 16270);
    paramView = paramau.field_content;
    if (paramView != null)
    {
      paramView = f.a.B(paramView, paramau.field_reserved);
      if (!bf.mA(paramView.hiM))
      {
        paramau = new Intent();
        paramau.putExtra("key_native_url", paramView.hiM);
        paramau.putExtra("key_image_id", paramView.hiP);
        paramau.putExtra("key_image_aes_key", paramView.hiQ);
        paramau.putExtra("key_image_length", paramView.hiR);
        paramau.putExtra("key_username", parama.bTW());
        d.b(parama.uRf.uRz, "luckymoney", ".ui.LuckyMoneyNewYearReceiveUI", paramau);
      }
    }
    GMTrace.o(2183722434560L, 16270);
    return true;
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/ui/chatting/aj.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */