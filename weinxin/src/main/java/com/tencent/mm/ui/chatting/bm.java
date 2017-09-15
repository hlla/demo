package com.tencent.mm.ui.chatting;

import android.app.Activity;
import android.content.Context;
import android.text.Html;
import android.view.ContextMenu;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewStub;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.tencent.gmtrace.GMTrace;
import com.tencent.mm.R.h;
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

final class bm
  extends ag.c
{
  private En_5b8fbb1e.a vAn;
  
  public bm()
  {
    super(15);
    GMTrace.i(2298881245184L, 17128);
    GMTrace.o(2298881245184L, 17128);
  }
  
  public final View a(LayoutInflater paramLayoutInflater, View paramView)
  {
    GMTrace.i(2299015462912L, 17129);
    Object localObject;
    if ((paramView != null) && (paramView.getTag() != null))
    {
      localObject = paramView;
      if (((ag.a)paramView.getTag()).type == this.klJ) {}
    }
    else
    {
      localObject = new bi(paramLayoutInflater, R.i.cYm);
      ((View)localObject).setTag(new dn(this.klJ).p((View)localObject, false));
    }
    GMTrace.o(2299015462912L, 17129);
    return (View)localObject;
  }
  
  public final void a(ag.a parama, int paramInt, En_5b8fbb1e.a parama1, au paramau, String paramString)
  {
    GMTrace.i(2299149680640L, 17130);
    this.vAn = parama1;
    paramString = (dn)parama;
    com.tencent.mm.storage.a.c localc = ((com.tencent.mm.plugin.emoji.b.c)h.j(com.tencent.mm.plugin.emoji.b.c.class)).getEmojiMgr().tX(paramau.field_imgPath);
    ImageView localImageView;
    if (localc != null)
    {
      parama = aj.RC(paramau.field_content);
      paramString.vwH.a(localc, paramau.field_msgId, parama);
      if (paramString.vGl != null)
      {
        if (!parama.uHA) {
          break label617;
        }
        paramString.vGl.setVisibility(0);
        TextView localTextView = (TextView)paramString.mgy.findViewById(R.h.bBg).findViewById(R.h.bAm);
        localTextView.setText(Html.fromHtml(parama1.getString(R.l.ecg)));
        localImageView = (ImageView)paramString.mgy.findViewById(R.h.bBg).findViewById(R.h.bAl);
        localTextView.setTag(new ds(paramau, false, paramInt, parama1.vzN.hrv, 8, false, "", "", "", "", localc.field_groupId, "", true, false));
        localTextView.setOnClickListener(parama1.vzN.vDb);
        if (!((com.tencent.mm.plugin.emoji.b.c)h.j(com.tencent.mm.plugin.emoji.b.c.class)).getEmojiMgr().alw()) {
          break label607;
        }
        localImageView.setVisibility(0);
        localImageView.setTag(new ds(paramau, parama1.vvA, paramInt, parama1.vzN.hrv, 11, (byte)0));
        localImageView.setOnClickListener(parama1.vzN.vDb);
      }
      if ((localc.bCM()) && (!parama.hZO))
      {
        parama.hZO = true;
        paramau.setContent(parama.bLG());
        ap.yY();
        paramau.dv(com.tencent.mm.u.c.wT().cA(paramau.field_msgId).field_status);
        ap.yY();
        com.tencent.mm.u.c.wT().N(paramau);
      }
      if (!bUg()) {
        break label651;
      }
      paramString.oCh.setVisibility(8);
      if ((paramau == null) || (paramau.field_status != 2) || (!a(parama1.vzN, paramau.field_msgId))) {
        break label630;
      }
      if (paramString.vwJ != null) {
        paramString.vwJ.setVisibility(0);
      }
    }
    label412:
    parama = "";
    if (localc.bCM()) {
      if (localc.field_name.startsWith("jsb_j")) {
        parama = this.vAn.uRf.uRz.getString(R.l.ecz);
      }
    }
    for (;;)
    {
      paramString.vwH.setContentDescription(this.vAn.uRf.uRz.getString(R.l.edG) + parama);
      paramString.vwH.setTag(new ds(paramau, parama1.vvA, paramInt, parama1.vzN.hrv, 0, (byte)0));
      paramString.vwH.setOnClickListener(parama1.vzN.vDb);
      paramString.vwH.setOnLongClickListener(parama1.vzN.vDd);
      paramString.vwH.setOnTouchListener(parama1.vzN.vDf);
      a(paramInt, paramString, paramau, parama1.vzN.hrv, parama1.vvA, parama1.vzN.vDb);
      GMTrace.o(2299149680640L, 17130);
      return;
      label607:
      localImageView.setVisibility(8);
      break;
      label617:
      paramString.vGl.setVisibility(8);
      break;
      label630:
      if (paramString.vwJ == null) {
        break label412;
      }
      paramString.vwJ.setVisibility(8);
      break label412;
      label651:
      if (paramString.vwJ != null) {
        paramString.vwJ.setVisibility(8);
      }
      if (paramString.oCh == null) {
        break label412;
      }
      paramString.oCh.setVisibility(0);
      if (paramau.field_status < 2) {
        break label412;
      }
      paramString.oCh.setVisibility(8);
      break label412;
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
    GMTrace.i(2299283898368L, 17131);
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
            v.w("MicroMsg.emoji.ChattingItemEmojiTo", "emoji is null. md5:%s", new Object[] { paramContextMenu });
            GMTrace.o(2299283898368L, 17131);
            return true;
          }
        }
        boolean bool = localc.bNh();
        if ((localc.field_catalog != com.tencent.mm.storage.a.c.uJj) && (!localc.bNj()) && (!localc.bNk()))
        {
          if (!bool) {
            break label524;
          }
          paramContextMenu.add(i, 104, 0, paramView.getContext().getString(R.l.dUq));
        }
        if ((localc.field_catalog == com.tencent.mm.storage.a.c.uJj) || (bf.mA(localc.field_groupId)) || ((!bf.mA(localc.field_groupId)) && (((com.tencent.mm.plugin.emoji.b.c)h.j(com.tencent.mm.plugin.emoji.b.c.class)).getEmojiMgr().ub(localc.field_groupId))))
        {
          if (!bool) {
            break label536;
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
      if ((!paramau.bLN()) && (paramau.bMd()) && ((paramau.field_status == 2) || (paramau.gxz == 1)) && (ao(paramau)) && (Tm(paramau.field_talker))) {
        paramContextMenu.add(i, 123, 0, paramView.getContext().getString(R.l.dUp));
      }
      if (!this.vAn.bVz()) {
        paramContextMenu.add(i, 100, 0, paramView.getContext().getString(R.l.dUf));
      }
      if (paramau.field_status == 5) {
        paramContextMenu.add(i, 103, 0, paramView.getContext().getString(R.l.dVe));
      }
      g.oSF.i(12789, new Object[] { Integer.valueOf(0), localc.EQ(), Integer.valueOf(0), localc.field_designerID, localc.field_groupId, "", "", "", "", "", localc.field_activityid });
      GMTrace.o(2299283898368L, 17131);
      return true;
      label524:
      v.i("MicroMsg.emoji.ChattingItemEmojiTo", "emoji file no exist. cannot save or resend.");
      break;
      label536:
      v.i("MicroMsg.emoji.ChattingItemEmojiTo", "emoji file no exist. cannot save or resend.");
    }
  }
  
  public final boolean a(MenuItem paramMenuItem, En_5b8fbb1e.a parama, au paramau)
  {
    GMTrace.i(2299418116096L, 17132);
    GMTrace.o(2299418116096L, 17132);
    return false;
  }
  
  public final boolean a(View paramView, En_5b8fbb1e.a parama, au paramau)
  {
    GMTrace.i(2299552333824L, 17133);
    GMTrace.o(2299552333824L, 17133);
    return false;
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/ui/chatting/bm.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */