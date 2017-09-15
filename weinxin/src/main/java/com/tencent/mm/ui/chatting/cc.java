package com.tencent.mm.ui.chatting;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.text.Spannable;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.text.style.AbsoluteSizeSpan;
import android.view.ContextMenu;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.widget.ImageView;
import android.widget.ProgressBar;
import com.tencent.gmtrace.GMTrace;
import com.tencent.mm.R.g;
import com.tencent.mm.R.h;
import com.tencent.mm.R.i;
import com.tencent.mm.R.l;
import com.tencent.mm.app.plugin.c;
import com.tencent.mm.e.b.ce;
import com.tencent.mm.modelbiz.e;
import com.tencent.mm.plugin.fts.d.b.a.b;
import com.tencent.mm.plugin.fts.d.b.b;
import com.tencent.mm.plugin.fts.d.d.a;
import com.tencent.mm.plugin.fts.d.f;
import com.tencent.mm.pluginsdk.model.app.g;
import com.tencent.mm.pluginsdk.ui.d.h;
import com.tencent.mm.sdk.platformtools.bf;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.storage.au;
import com.tencent.mm.storage.x;
import com.tencent.mm.u.q.b;
import com.tencent.mm.ui.l;
import com.tencent.mm.ui.widget.MMTextView.a;
import com.tencent.mm.ui.widget.celltextview.CellTextView;
import com.tencent.mm.ui.widget.celltextview.CellTextView.b;
import com.tencent.mm.ui.widget.celltextview.CellTextView.c;
import java.util.ArrayList;

class cc
  extends ag.c
  implements CellTextView.c
{
  public static final int vCC;
  public static final int vCD;
  private En_5b8fbb1e.a vAn;
  
  static
  {
    GMTrace.i(17899276206080L, 133360);
    vCC = R.h.bAF;
    vCD = R.h.bAE;
    GMTrace.o(17899276206080L, 133360);
  }
  
  public cc(int paramInt)
  {
    super(paramInt);
    GMTrace.i(2503429062656L, 18652);
    GMTrace.o(2503429062656L, 18652);
  }
  
  private void a(CellTextView paramCellTextView, CharSequence paramCharSequence1, CharSequence paramCharSequence2, CharSequence paramCharSequence3)
  {
    GMTrace.i(18999324704768L, 141556);
    SpannableStringBuilder localSpannableStringBuilder = new SpannableStringBuilder();
    if ((this.vAn.vHt >= 0L) && (this.vAn.vHu != null) && (this.vAn.vHu.size() > 0)) {
      localSpannableStringBuilder.append(f.b(com.tencent.mm.plugin.fts.d.b.a.a(paramCharSequence1, this.vAn.vHu, a.b.mbV, d.a.maO)).mbY);
    }
    for (;;)
    {
      localSpannableStringBuilder.append("\n");
      localSpannableStringBuilder.append(paramCharSequence3);
      localSpannableStringBuilder.append("\n");
      localSpannableStringBuilder.append(paramCharSequence2);
      int i = paramCharSequence1.length() + 1;
      int j = paramCharSequence3.length();
      if (TextUtils.isEmpty(paramCellTextView.caI()))
      {
        paramCellTextView.S(localSpannableStringBuilder);
        paramCellTextView.measure(0, 0);
      }
      paramCharSequence1 = this.vAn.getResources().getDrawable(R.g.bkP);
      paramCharSequence1.setBounds(0, 0, paramCellTextView.getMeasuredWidth() - paramCellTextView.getPaddingLeft() - paramCellTextView.getPaddingRight(), 2);
      paramCharSequence1 = new com.tencent.mm.ui.widget.d(paramCharSequence1);
      localSpannableStringBuilder.setSpan(new AbsoluteSizeSpan(4, true), i, i + j + 1, 33);
      localSpannableStringBuilder.setSpan(paramCharSequence1, i, j + i, 33);
      paramCellTextView.S(localSpannableStringBuilder);
      GMTrace.o(18999324704768L, 141556);
      return;
      localSpannableStringBuilder.append(paramCharSequence1);
    }
  }
  
  private String ap(au paramau)
  {
    GMTrace.i(2503965933568L, 18656);
    if (paramau != null)
    {
      String str = com.tencent.mm.u.q.fQ(paramau.field_msgSvrId);
      q.b localb = com.tencent.mm.u.q.yC().n(str, true);
      localb.l("prePublishId", "msg_" + paramau.field_msgSvrId);
      localb.l("preUsername", a(this.vAn, paramau));
      localb.l("preChatName", b(this.vAn, paramau));
      GMTrace.o(2503965933568L, 18656);
      return str;
    }
    GMTrace.o(2503965933568L, 18656);
    return null;
  }
  
  public final View a(LayoutInflater paramLayoutInflater, View paramView)
  {
    GMTrace.i(2503563280384L, 18653);
    Object localObject;
    if (paramView != null)
    {
      localObject = paramView;
      if (((ag.a)paramView.getTag()).type == this.klJ) {}
    }
    else
    {
      localObject = new bi(paramLayoutInflater, R.i.cYa);
      ((View)localObject).setTag(new ek(this.klJ).p((View)localObject, false));
    }
    GMTrace.o(2503563280384L, 18653);
    return (View)localObject;
  }
  
  public void a(ag.a parama, int paramInt, En_5b8fbb1e.a parama1, au paramau, final String paramString)
  {
    GMTrace.i(2503697498112L, 18654);
    this.vAn = parama1;
    paramString = (ek)parama;
    paramString.xoi.setTag(vCC, Long.valueOf(paramau.field_msgId));
    paramString.xoi.setTag(vCD, Boolean.valueOf(true));
    Object localObject1;
    int i;
    label231:
    int j;
    label250:
    Object localObject2;
    if (bUg())
    {
      if (paramString.oCh != null) {
        paramString.oCh.setVisibility(8);
      }
      if ((paramau.field_status == 1) || (paramau.field_status == 5))
      {
        if (paramString.vwJ != null) {
          paramString.vwJ.setVisibility(8);
        }
        paramString.xoi.setBackgroundResource(R.g.bej);
        paramau.uId = true;
        localObject1 = paramau.field_content;
        if (bf.mA((String)localObject1)) {
          v.e("MicroMsg.ChattingItemTextTo", "[carl] text to, content is null! why?? localid : %s, svrid : %s", new Object[] { Long.valueOf(paramau.field_msgId), Long.valueOf(paramau.field_msgSvrId) });
        }
        i = 0;
        if (!c.oL()) {
          break label675;
        }
        paramString.vyp.lg(false);
        if (!paramau.bMi()) {
          break label641;
        }
        if (!paramau.bMm()) {
          break label630;
        }
        paramString.vyp.Tw(paramau.field_transBrandWording);
        i = 1;
        if ((paramau.gxv == null) || (!paramau.bMr())) {
          break label687;
        }
        j = 1;
        if ((i == 0) || (j != 0)) {
          break label774;
        }
        if ((!x.em(parama1.vzN.hrv)) && (!x.em(parama1.vzN.fJC))) {
          break label693;
        }
        parama = paramString.xoi.getContext();
        paramString.xoi.getTextSize();
        parama = h.d(parama, (CharSequence)localObject1, 1);
        localObject1 = paramString.xoi.getContext();
        localObject2 = paramau.field_transContent;
        paramString.xoi.getTextSize();
        localObject1 = h.d((Context)localObject1, (CharSequence)localObject2, 1);
        localObject2 = paramString.xoi;
        ap(paramau);
        a((CellTextView)localObject2, parama, (CharSequence)localObject1, " ");
      }
    }
    for (;;)
    {
      parama = ds.a(paramau, parama1.vvA, paramInt);
      paramString.xoi.setTag(parama);
      paramString.xoi.setOnClickListener(parama1.vzN.vDb);
      paramString.xoi.setOnLongClickListener(parama1.vzN.vDd);
      paramString.xoi.xoj = this;
      paramString.xoi.a(new CellTextView.b()
      {
        public final void Q(CharSequence paramAnonymousCharSequence)
        {
          GMTrace.i(17917261381632L, 133494);
          if (((Boolean)paramString.xoi.getTag(cc.vCD)).booleanValue())
          {
            com.tencent.mm.ui.chatting.d.a.a.bXu();
            com.tencent.mm.ui.chatting.d.a.a.bXv().a(paramAnonymousCharSequence, ((Long)paramString.xoi.getTag(cc.vCC)).longValue());
          }
          GMTrace.o(17917261381632L, 133494);
        }
      });
      a(paramInt, paramString, paramau, parama1.vzN.hrv, parama1.vvA, parama1.vzN.vDb);
      GMTrace.o(2503697498112L, 18654);
      return;
      paramString.xoi.setBackgroundResource(R.g.bei);
      if (paramString.vwJ == null) {
        break;
      }
      if (a(parama1.vzN, paramau.field_msgId))
      {
        if (paramau.uId)
        {
          parama = new AlphaAnimation(0.5F, 1.0F);
          parama.setDuration(300L);
          paramString.xoi.startAnimation(parama);
          paramau.uId = false;
        }
        paramString.vwJ.setVisibility(0);
        break;
      }
      paramString.vwJ.setVisibility(8);
      break;
      if (paramString.oCh == null) {
        break;
      }
      parama = paramString.oCh;
      if (paramau.field_status >= 2) {}
      for (i = 8;; i = 0)
      {
        parama.setVisibility(i);
        break;
      }
      label630:
      paramString.vyp.bUE();
      break label231;
      label641:
      if (parama1.au(paramau) == ChattingTranslateView.a.vFT)
      {
        paramString.vyp.bUF();
        break label231;
      }
      paramString.vyp.bUE();
      break label231;
      label675:
      paramString.vyp.lg(true);
      break label231;
      label687:
      j = 0;
      break label250;
      label693:
      parama = h.a(paramString.xoi.getContext(), (CharSequence)localObject1, (int)paramString.xoi.getTextSize(), 1);
      localObject1 = h.a(paramString.xoi.getContext(), paramau.field_transContent, (int)paramString.xoi.getTextSize(), 1);
      localObject2 = paramString.xoi;
      ap(paramau);
      a((CellTextView)localObject2, parama, (CharSequence)localObject1, " ");
      continue;
      label774:
      if (j == 0)
      {
        paramString.a(paramString.xoi);
        parama = h.a(paramString.xoi.getContext(), (CharSequence)localObject1, (int)paramString.xoi.getTextSize(), Integer.valueOf(31), ap(paramau));
        long l = paramau.field_msgId;
        if ((parama1.vHt == l) && (parama1.vHs) && (parama1.vHu != null) && (parama1.vHu.size() > 0)) {}
        for (i = 1;; i = 0)
        {
          if (i == 0) {
            break label911;
          }
          parama = f.b(com.tencent.mm.plugin.fts.d.b.a.a(parama, parama1.vHu, a.b.mbV, d.a.maO));
          paramString.xoi.S(parama.mbY);
          break;
        }
        label911:
        paramString.xoi.S(parama);
      }
      else
      {
        if (paramau.gxv.contains("notify@all")) {}
        for (parama = "";; parama = paramString.xoi.getContext().getString(R.l.eMJ, new Object[] { "@" }) + "\n")
        {
          if (i == 0) {
            break label1110;
          }
          parama = h.a(paramString.xoi.getContext(), parama + localObject1, (int)paramString.xoi.getTextSize(), ap(paramau), Integer.valueOf(31));
          localObject1 = h.a(paramString.xoi.getContext(), paramau.field_transContent, (int)paramString.xoi.getTextSize(), ap(paramau), Integer.valueOf(31));
          localObject2 = paramString.xoi;
          ap(paramau);
          a((CellTextView)localObject2, parama, (CharSequence)localObject1, " ");
          break;
        }
        label1110:
        parama = h.a(paramString.xoi.getContext(), parama + localObject1, (int)paramString.xoi.getTextSize(), Integer.valueOf(31), ap(paramau));
        paramString.xoi.S(parama);
      }
    }
  }
  
  public boolean a(ContextMenu paramContextMenu, View paramView, au paramau)
  {
    GMTrace.i(2504100151296L, 18657);
    int i;
    int j;
    if ((paramau.gxv != null) && (paramau.gxv.contains("announcement@all")))
    {
      i = 1;
      if ((paramau.bMa()) || (paramau.bLS()))
      {
        j = ((ds)paramView.getTag()).position;
        if (paramau.bMa()) {
          paramContextMenu.add(j, 102, 0, paramView.getContext().getString(R.l.dUe));
        }
        paramContextMenu.add(j, 108, 0, paramView.getContext().getString(R.l.eLz));
        if (paramau.field_status == 5) {
          paramContextMenu.add(j, 103, 0, paramView.getContext().getString(R.l.dVe));
        }
        if (com.tencent.mm.bb.d.Jr("favorite")) {
          paramContextMenu.add(j, 116, 0, paramView.getContext().getString(R.l.eFS));
        }
        if (g.L(this.vAn.uRf.uRz, paramau.field_type)) {
          paramContextMenu.add(j, 128, 0, paramView.getContext().getString(R.l.dUm));
        }
        if ((i == 0) && (!paramau.bLN()) && (paramau.bMa()) && ((paramau.field_status == 2) || (paramau.gxz == 1)) && (ao(paramau)) && (Tm(paramau.field_talker))) {
          paramContextMenu.add(j, 123, 0, paramView.getContext().getString(R.l.dUp));
        }
        if (c.oL())
        {
          if ((!paramau.bMi()) || (!paramau.bMm())) {
            break label399;
          }
          paramContextMenu.add(j, 124, 0, paramView.getContext().getString(R.l.dUu));
        }
      }
    }
    for (;;)
    {
      if ((paramau.bMa()) && (e.Dn())) {
        this.vAn.bVz();
      }
      if (!this.vAn.bVz()) {
        paramContextMenu.add(j, 100, 0, paramView.getContext().getString(R.l.dUh));
      }
      GMTrace.o(2504100151296L, 18657);
      return true;
      i = 0;
      break;
      label399:
      paramContextMenu.add(j, 124, 0, paramView.getContext().getString(R.l.dUw));
    }
  }
  
  public final boolean a(MenuItem paramMenuItem, En_5b8fbb1e.a parama, au paramau)
  {
    GMTrace.i(2504234369024L, 18658);
    GMTrace.o(2504234369024L, 18658);
    return false;
  }
  
  public final boolean a(View paramView, En_5b8fbb1e.a parama, au paramau)
  {
    GMTrace.i(2504368586752L, 18659);
    GMTrace.o(2504368586752L, 18659);
    return false;
  }
  
  public final boolean dq(View paramView)
  {
    GMTrace.i(18999458922496L, 141557);
    boolean bool = this.vAn.vzN.vDh.dq(paramView);
    GMTrace.o(18999458922496L, 141557);
    return bool;
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/ui/chatting/cc.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */