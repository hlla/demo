package com.tencent.mm.ui.chatting;

import android.content.Context;
import android.view.ContextMenu;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.tencent.gmtrace.GMTrace;
import com.tencent.mm.R.g;
import com.tencent.mm.R.i;
import com.tencent.mm.R.l;
import com.tencent.mm.e.b.ce;
import com.tencent.mm.pluginsdk.ui.d.h;
import com.tencent.mm.sdk.platformtools.bf;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.storage.au;
import com.tencent.mm.t.f.a;
import com.tencent.mm.ui.widget.MMTextView;
import java.net.URLDecoder;

final class am
  extends ag.c
{
  private En_5b8fbb1e.a vAn;
  
  public am()
  {
    super(67);
    GMTrace.i(2216337342464L, 16513);
    GMTrace.o(2216337342464L, 16513);
  }
  
  private static String Tn(String paramString)
  {
    GMTrace.i(2216605777920L, 16515);
    try
    {
      paramString = f.a.ek(paramString);
      if (paramString != null)
      {
        paramString = URLDecoder.decode(paramString.content, "UTF-8");
        GMTrace.o(2216605777920L, 16515);
        return paramString;
      }
    }
    catch (Exception paramString)
    {
      v.e("MicroMsg.ChattingItemTextTo", "getMsgContent error: %s", new Object[] { paramString.getMessage() });
      GMTrace.o(2216605777920L, 16515);
    }
    return "";
  }
  
  public final View a(LayoutInflater paramLayoutInflater, View paramView)
  {
    GMTrace.i(2216471560192L, 16514);
    Object localObject;
    if (paramView != null)
    {
      localObject = paramView;
      if (((ag.a)paramView.getTag()).type == this.klJ) {}
    }
    else
    {
      localObject = new bi(paramLayoutInflater, R.i.cYp);
      ((View)localObject).setTag(new w(this.klJ).p((View)localObject, false));
    }
    GMTrace.o(2216471560192L, 16514);
    return (View)localObject;
  }
  
  public final void a(ag.a parama, int paramInt, En_5b8fbb1e.a parama1, au paramau, String paramString)
  {
    int i = 8;
    GMTrace.i(2216739995648L, 16516);
    this.vAn = parama1;
    parama = (w)parama;
    if (bUg())
    {
      if (parama.oCh != null) {
        parama.oCh.setVisibility(8);
      }
      if ((paramau.field_status == 1) || (paramau.field_status == 5))
      {
        if (parama.vwJ != null) {
          parama.vwJ.setVisibility(8);
        }
        parama.vyo.setBackgroundResource(R.g.bej);
        paramau.uId = true;
      }
    }
    while (parama.oCh == null) {
      for (;;)
      {
        paramString = Tn(paramau.field_content);
        if (bf.mA(paramString)) {
          v.e("MicroMsg.ChattingItemTextTo", "[carl] text to, content is null! why?? localid : %s, svrid : %s", new Object[] { Long.valueOf(paramau.field_msgId), Long.valueOf(paramau.field_msgSvrId) });
        }
        parama.vyp.lg(true);
        parama.vyo.setMinWidth(0);
        parama.vyo.setText(paramString);
        paramString = parama.vyo;
        i = paramau.field_type;
        String str = parama1.bTW();
        if (i != 301989937) {
          h.a(paramString, str);
        }
        paramString.getText();
        paramString = ds.a(paramau, parama1.vvA, paramInt);
        parama.vyo.setTag(paramString);
        parama.vyo.setOnClickListener(parama1.vzN.vDb);
        parama.vyo.setOnLongClickListener(parama1.vzN.vDd);
        parama.vyo.wuG = parama1.vzN.vDh;
        a(paramInt, parama, paramau, parama1.vzN.hrv, parama1.vvA, parama1.vzN.vDb);
        GMTrace.o(2216739995648L, 16516);
        return;
        parama.vyo.setBackgroundResource(R.g.bei);
        if (parama.vwJ != null) {
          if (a(parama1.vzN, paramau.field_msgId))
          {
            if (paramau.uId)
            {
              paramString = new AlphaAnimation(0.5F, 1.0F);
              paramString.setDuration(300L);
              parama.vyo.startAnimation(paramString);
              paramau.uId = false;
            }
            parama.vwJ.setVisibility(0);
          }
          else
          {
            parama.vwJ.setVisibility(8);
          }
        }
      }
    }
    paramString = parama.oCh;
    if (paramau.field_status >= 2) {}
    for (;;)
    {
      paramString.setVisibility(i);
      break;
      i = 0;
    }
  }
  
  public final boolean a(ContextMenu paramContextMenu, View paramView, au paramau)
  {
    GMTrace.i(2216874213376L, 16517);
    paramContextMenu.add(((ds)paramView.getTag()).position, 100, 0, paramView.getContext().getString(R.l.dUh));
    GMTrace.o(2216874213376L, 16517);
    return false;
  }
  
  public final boolean a(MenuItem paramMenuItem, En_5b8fbb1e.a parama, au paramau)
  {
    GMTrace.i(2217008431104L, 16518);
    GMTrace.o(2217008431104L, 16518);
    return false;
  }
  
  public final boolean a(View paramView, En_5b8fbb1e.a parama, au paramau)
  {
    GMTrace.i(2217142648832L, 16519);
    GMTrace.o(2217142648832L, 16519);
    return false;
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/ui/chatting/am.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */