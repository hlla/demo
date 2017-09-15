package com.tencent.mm.ui.chatting;

import android.app.Activity;
import android.content.Context;
import android.view.ContextMenu;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import com.tencent.gmtrace.GMTrace;
import com.tencent.mm.R.i;
import com.tencent.mm.R.l;
import com.tencent.mm.e.b.ce;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.pluginsdk.c.d;
import com.tencent.mm.pluginsdk.ui.emoji.RTChattingEmojiView;
import com.tencent.mm.sdk.platformtools.bf;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.storage.aj;
import com.tencent.mm.storage.au;
import com.tencent.mm.u.ap;
import com.tencent.mm.ui.l;
import com.tencent.mm.ui.q;

final class bl
  extends ag.b
{
  private En_5b8fbb1e.a vAn;
  
  public bl()
  {
    super(14);
    GMTrace.i(2494973345792L, 18589);
    GMTrace.o(2494973345792L, 18589);
  }
  
  public final View a(LayoutInflater paramLayoutInflater, View paramView)
  {
    GMTrace.i(2495107563520L, 18590);
    Object localObject;
    if ((paramView != null) && (paramView.getTag() != null))
    {
      localObject = paramView;
      if (((ag.a)paramView.getTag()).type == this.klJ) {}
    }
    else
    {
      localObject = new bi(paramLayoutInflater, R.i.cXH);
      ((View)localObject).setTag(new dn(this.klJ).p((View)localObject, true));
    }
    GMTrace.o(2495107563520L, 18590);
    return (View)localObject;
  }
  
  public final void a(ag.a parama, int paramInt, En_5b8fbb1e.a parama1, au paramau, String paramString)
  {
    GMTrace.i(2495241781248L, 18591);
    this.vAn = parama1;
    com.tencent.mm.storage.a.c localc = ((com.tencent.mm.plugin.emoji.b.c)h.j(com.tencent.mm.plugin.emoji.b.c.class)).getEmojiMgr().tX(paramau.field_imgPath);
    dn localdn = (dn)parama;
    if (localc != null)
    {
      parama = aj.RC(paramau.field_content);
      localdn.vwH.a(localc, paramau.field_msgId, parama);
      if ((localc.bCM()) && (!parama.hZO))
      {
        parama.hZO = true;
        paramau.setContent(parama.bLG());
        ap.yY();
        com.tencent.mm.u.c.wT().a(paramau.field_msgId, paramau);
      }
    }
    parama = "";
    if ((localc != null) && (localc.bCM())) {
      if (localc.field_name.startsWith("jsb_j")) {
        parama = this.vAn.uRf.uRz.getString(R.l.ecz);
      }
    }
    for (;;)
    {
      localdn.vwH.setContentDescription(this.vAn.uRf.uRz.getString(R.l.edG) + parama);
      localdn.vwH.setTag(new ds(paramau, parama1.vvA, paramInt, paramString, 0, (byte)0));
      localdn.vwH.setOnClickListener(parama1.vzN.vDb);
      localdn.vwH.setOnLongClickListener(parama1.vzN.vDd);
      localdn.vwH.setOnTouchListener(parama1.vzN.vDf);
      GMTrace.o(2495241781248L, 18591);
      return;
      if (localc.field_name.startsWith("jsb_s"))
      {
        parama = this.vAn.uRf.uRz.getString(R.l.ecA);
      }
      else if (localc.field_name.startsWith("jsb_b"))
      {
        parama = this.vAn.uRf.uRz.getString(R.l.ecy);
      }
      else if (localc.field_name.startsWith("dice"))
      {
        parama = localc.field_name.replace("dice_", "").replace(".png", "");
        continue;
        parama = bf.ap(((com.tencent.mm.plugin.emoji.b.c)h.j(com.tencent.mm.plugin.emoji.b.c.class)).getEmojiMgr().ua(localc.EQ()), "");
      }
    }
  }
  
  public final boolean a(ContextMenu paramContextMenu, View paramView, au paramau)
  {
    GMTrace.i(2495510216704L, 18593);
    int i;
    com.tencent.mm.storage.a.c localc;
    if (paramau.bMd())
    {
      ap.yY();
      if (com.tencent.mm.u.c.isSDCardAvailable())
      {
        i = ((ds)paramView.getTag()).position;
        localc = ((com.tencent.mm.plugin.emoji.b.c)h.j(com.tencent.mm.plugin.emoji.b.c.class)).getEmojiMgr().tX(paramau.field_imgPath);
        if (localc == null)
        {
          if (paramau == null) {}
          for (paramContextMenu = "";; paramContextMenu = paramau.field_imgPath)
          {
            v.w("MicroMsg.emoji.ChattingItemEmojiFrom", "emoji is null. md5:%s", new Object[] { paramContextMenu });
            GMTrace.o(2495510216704L, 18593);
            return true;
          }
        }
        boolean bool = localc.bNh();
        if ((localc.field_catalog != com.tencent.mm.storage.a.c.uJj) && (!localc.bNj()) && (!localc.bNk()))
        {
          if (!bool) {
            break label419;
          }
          paramContextMenu.add(i, 104, 0, paramView.getContext().getString(R.l.dUq));
        }
        if ((localc.field_catalog == com.tencent.mm.storage.a.c.uJj) || (bf.mA(localc.field_groupId)) || ((!bf.mA(localc.field_groupId)) && (((com.tencent.mm.plugin.emoji.b.c)h.j(com.tencent.mm.plugin.emoji.b.c.class)).getEmojiMgr().ub(localc.field_groupId))))
        {
          if (!bool) {
            break label431;
          }
          paramContextMenu.add(i, 113, 0, R.l.eLz);
        }
      }
    }
    for (;;)
    {
      if ((!bf.mA(localc.field_groupId)) && (!localc.bCM()) && (!localc.bNk())) {
        paramContextMenu.add(i, 127, 0, R.l.dUs);
      }
      if (!this.vAn.bVz()) {
        paramContextMenu.add(i, 100, 0, paramView.getContext().getString(R.l.dUf));
      }
      g.oSF.i(12789, new Object[] { Integer.valueOf(0), localc.EQ(), Integer.valueOf(0), localc.field_designerID, localc.field_groupId, "", "", "", "", localc.field_activityid });
      GMTrace.o(2495510216704L, 18593);
      return true;
      label419:
      v.i("MicroMsg.emoji.ChattingItemEmojiFrom", "file do no exist. cant do add or resend.");
      break;
      label431:
      v.i("MicroMsg.emoji.ChattingItemEmojiFrom", "file do no exist. cant do add or resend.");
    }
  }
  
  public final boolean a(MenuItem paramMenuItem, En_5b8fbb1e.a parama, au paramau)
  {
    GMTrace.i(2495644434432L, 18594);
    GMTrace.o(2495644434432L, 18594);
    return false;
  }
  
  public final boolean a(View paramView, En_5b8fbb1e.a parama, au paramau)
  {
    GMTrace.i(2495778652160L, 18595);
    GMTrace.o(2495778652160L, 18595);
    return false;
  }
  
  protected final boolean a(En_5b8fbb1e.a parama)
  {
    GMTrace.i(2495375998976L, 18592);
    boolean bool = parama.vvA;
    GMTrace.o(2495375998976L, 18592);
    return bool;
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/ui/chatting/bl.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */