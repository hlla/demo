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
import com.tencent.mm.sdk.platformtools.av;
import com.tencent.mm.sdk.platformtools.bf;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.storage.au;
import com.tencent.mm.t.f.a;
import com.tencent.mm.u.ap;
import com.tencent.mm.u.ay;
import com.tencent.mm.ui.l;
import com.tencent.mm.ui.q;
import java.util.Map;

final class ai
  extends ag.b
{
  private En_5b8fbb1e.a vAn;
  private final int vAo;
  
  public ai()
  {
    super(63);
    GMTrace.i(2514569134080L, 18735);
    this.vAo = 1;
    GMTrace.o(2514569134080L, 18735);
  }
  
  public final View a(LayoutInflater paramLayoutInflater, View paramView)
  {
    GMTrace.i(2514703351808L, 18736);
    Object localObject;
    if ((paramView != null) && (paramView.getTag() != null) && ((paramView.getTag() instanceof f)))
    {
      localObject = paramView;
      if (((ag.a)paramView.getTag()).type == this.klJ) {}
    }
    else
    {
      localObject = new bi(paramLayoutInflater, R.i.cXy);
      ((View)localObject).setTag(new f(this.klJ).df((View)localObject));
    }
    GMTrace.o(2514703351808L, 18736);
    return (View)localObject;
  }
  
  public final void a(ag.a parama, int paramInt, En_5b8fbb1e.a parama1, au paramau, String paramString)
  {
    GMTrace.i(2514837569536L, 18737);
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
        GMTrace.o(2514837569536L, 18737);
        return;
      }
    }
  }
  
  public final boolean a(ContextMenu paramContextMenu, View paramView, au paramau)
  {
    GMTrace.i(2514971787264L, 18738);
    paramContextMenu.add(((ds)paramView.getTag()).position, 100, 0, this.vAn.getString(R.l.dUh));
    GMTrace.o(2514971787264L, 18738);
    return false;
  }
  
  public final boolean a(MenuItem paramMenuItem, En_5b8fbb1e.a parama, au paramau)
  {
    GMTrace.i(2515106004992L, 18739);
    switch (paramMenuItem.getItemId())
    {
    default: 
      GMTrace.o(2515106004992L, 18739);
      return false;
    }
    ay.L(paramau.field_msgId);
    GMTrace.o(2515106004992L, 18739);
    return true;
  }
  
  public final boolean a(View paramView, En_5b8fbb1e.a parama, au paramau)
  {
    GMTrace.i(2515240222720L, 18740);
    paramView = paramau.field_content;
    if (paramView != null)
    {
      paramView = f.a.B(paramView, paramau.field_reserved);
      if (!bf.mA(paramView.hiM))
      {
        if (paramView.hiN == 1)
        {
          v.d("MicroMsg.ChattingItemAppMsgC2CNewYearFrom", "onItemClick hasplay, skip");
          paramau = new Intent();
          paramau.putExtra("key_native_url", paramView.hiM);
          paramau.putExtra("key_username", parama.bTW());
          paramau.putExtra("key_image_id", paramView.hiP);
          paramau.putExtra("key_image_aes_key", paramView.hiQ);
          paramau.putExtra("key_image_length", paramView.hiR);
          d.b(parama.uRf.uRz, "luckymoney", ".ui.LuckyMoneyNewYearReceiveUI", paramau);
          GMTrace.o(2515240222720L, 18740);
          return true;
        }
        v.d("MicroMsg.ChattingItemAppMsgC2CNewYearFrom", "onItemClick play egg emoj");
        Intent localIntent = new Intent();
        localIntent.putExtra("key_native_url", paramView.hiM);
        localIntent.putExtra("key_username", parama.bTW());
        localIntent.putExtra("key_image_id", paramView.hiP);
        localIntent.putExtra("key_image_aes_key", paramView.hiQ);
        localIntent.putExtra("key_image_length", paramView.hiR);
        d.b(parama.uRf.uRz, "luckymoney", ".ui.LuckyMoneyNewYearReceiveUI", localIntent);
        paramView.hiN = 1;
        paramau.setContent(f.a.a(paramView, null, null));
        if ((paramau != null) && (paramau.axH())) {
          break label292;
        }
      }
    }
    for (;;)
    {
      ap.yY();
      com.tencent.mm.u.c.wT().a(paramau.field_msgId, paramau);
      GMTrace.o(2515240222720L, 18740);
      return true;
      try
      {
        label292:
        parama = paramau.field_content;
        int i = parama.indexOf("<msg>");
        paramView = parama;
        if (i > 0)
        {
          paramView = parama;
          if (i < parama.length()) {
            paramView = parama.substring(i).trim();
          }
        }
        paramView = bg.q(paramView, "msg");
        if ((paramView != null) && (paramView.size() > 0)) {
          paramau.cJ(av.ae(paramView));
        }
      }
      catch (Exception paramView)
      {
        v.e("MicroMsg.ChattingItemAppMsgC2CNewYearFrom", paramView.getMessage());
      }
    }
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/ui/chatting/ai.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */