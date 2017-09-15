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
import com.tencent.mm.storage.au;
import com.tencent.mm.storage.x;
import com.tencent.mm.u.ay;
import com.tencent.mm.u.q.b;
import com.tencent.mm.ui.l;
import com.tencent.mm.ui.widget.MMTextView.a;
import com.tencent.mm.ui.widget.celltextview.CellTextView;
import com.tencent.mm.ui.widget.celltextview.CellTextView.b;
import com.tencent.mm.ui.widget.celltextview.CellTextView.c;
import java.util.ArrayList;

class cb
  extends ag.b
  implements CellTextView.c
{
  public static final int vCC;
  public static final int vCD;
  private En_5b8fbb1e.a vAn;
  
  static
  {
    GMTrace.i(17907329269760L, 133420);
    vCC = R.h.bAF;
    vCD = R.h.bAE;
    GMTrace.o(17907329269760L, 133420);
  }
  
  public cb(int paramInt)
  {
    super(paramInt);
    GMTrace.i(2284922601472L, 17024);
    GMTrace.o(2284922601472L, 17024);
  }
  
  private void a(CellTextView paramCellTextView, CharSequence paramCharSequence1, CharSequence paramCharSequence2, CharSequence paramCharSequence3)
  {
    GMTrace.i(18999593140224L, 141558);
    SpannableStringBuilder localSpannableStringBuilder = new SpannableStringBuilder();
    if ((this.vAn.vHt >= 0L) && (this.vAn.vHu != null) && (this.vAn.vHu.size() > 0)) {
      localSpannableStringBuilder.append(f.b(com.tencent.mm.plugin.fts.d.b.a.a(paramCharSequence1, this.vAn.vHu, a.b.mbV, d.a.maN)).mbY);
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
      paramCharSequence1 = this.vAn.getResources().getDrawable(R.g.bkO);
      paramCharSequence1.setBounds(0, 0, paramCellTextView.getMeasuredWidth() - paramCellTextView.getPaddingLeft() - paramCellTextView.getPaddingRight(), 2);
      localSpannableStringBuilder.setSpan(new com.tencent.mm.ui.widget.d(paramCharSequence1), i, i + j, 33);
      localSpannableStringBuilder.setSpan(new AbsoluteSizeSpan(4, true), i, j + i + 1, 33);
      paramCellTextView.S(localSpannableStringBuilder);
      GMTrace.o(18999593140224L, 141558);
      return;
      localSpannableStringBuilder.append(paramCharSequence1);
    }
  }
  
  private String ap(au paramau)
  {
    GMTrace.i(2285593690112L, 17029);
    if (paramau != null)
    {
      String str = com.tencent.mm.u.q.fQ(paramau.field_msgSvrId);
      q.b localb = com.tencent.mm.u.q.yC().n(str, true);
      localb.l("prePublishId", "msg_" + paramau.field_msgSvrId);
      localb.l("preUsername", a(this.vAn, paramau));
      localb.l("preChatName", b(this.vAn, paramau));
      GMTrace.o(2285593690112L, 17029);
      return str;
    }
    GMTrace.o(2285593690112L, 17029);
    return null;
  }
  
  public View a(LayoutInflater paramLayoutInflater, View paramView)
  {
    GMTrace.i(2285056819200L, 17025);
    Object localObject;
    if (paramView != null)
    {
      localObject = paramView;
      if (((ag.a)paramView.getTag()).type == this.klJ) {}
    }
    else
    {
      localObject = new bi(paramLayoutInflater, R.i.cXv);
      ((View)localObject).setTag(new ek(this.klJ).p((View)localObject, true));
    }
    GMTrace.o(2285056819200L, 17025);
    return (View)localObject;
  }
  
  public void a(ag.a parama, int paramInt, En_5b8fbb1e.a parama1, au paramau, String paramString)
  {
    GMTrace.i(2285325254656L, 17027);
    this.vAn = parama1;
    final ek localek = (ek)parama;
    Object localObject2 = paramau.field_content;
    paramString = paramau.field_transContent;
    Object localObject1 = parama1.vzN.fJC;
    localek.xoi.setTag(vCC, Long.valueOf(paramau.field_msgId));
    localek.xoi.setTag(vCD, Boolean.valueOf(true));
    int i = 0;
    int j;
    if (c.oL())
    {
      localek.vyp.lg(false);
      if (paramau.bMi()) {
        if (paramau.bMm())
        {
          localek.vyp.Tw(paramau.field_transBrandWording);
          i = 1;
          if ((!parama1.vvA) || (parama1.sLe)) {
            break label1036;
          }
          j = ay.gh((String)localObject2);
          if (j == -1) {
            break label1036;
          }
          parama = ((String)localObject2).substring(0, j).trim();
          if ((parama == null) || (parama.length() <= 0)) {
            break label1030;
          }
          label177:
          localObject1 = ((String)localObject2).substring(j + 1).trim();
          if (i == 0) {
            break label1013;
          }
          localObject2 = paramString.substring(j + 1).trim();
          paramString = parama;
          parama = (ag.a)localObject2;
          localObject2 = localObject1;
          localObject1 = paramString;
          paramString = (String)localObject2;
        }
      }
    }
    for (;;)
    {
      a(localek, parama1, paramau, (String)localObject1);
      a(localek, parama1, (String)localObject1, paramau);
      if ((paramau.gxv != null) && (paramau.bMr()))
      {
        j = 1;
        label268:
        if ((i == 0) || (j != 0)) {
          break label638;
        }
        if ((!x.em(parama1.vzN.hrv)) && (!x.em(parama1.vzN.fJC))) {
          break label561;
        }
        parama = localek.xoi.getContext();
        localek.xoi.getTextSize();
        parama = h.d(parama, paramString, 1);
        paramString = localek.xoi.getContext();
        localObject1 = paramau.field_transContent;
        localek.xoi.getTextSize();
        paramString = h.d(paramString, (CharSequence)localObject1, 1);
        localObject1 = localek.xoi;
        ap(paramau);
        a((CellTextView)localObject1, parama, paramString, " ");
      }
      for (;;)
      {
        parama = ds.a(paramau, parama1.vvA, paramInt);
        localek.xoi.setTag(parama);
        localek.xoi.setOnClickListener(parama1.vzN.vDb);
        localek.xoi.setOnLongClickListener(parama1.vzN.vDd);
        localek.xoi.xoj = this;
        localek.xoi.setTag(vCC, Long.valueOf(paramau.field_msgId));
        localek.xoi.a(new CellTextView.b()
        {
          public final void Q(CharSequence paramAnonymousCharSequence)
          {
            GMTrace.i(17907866140672L, 133424);
            if (((Boolean)localek.xoi.getTag(cb.vCD)).booleanValue())
            {
              com.tencent.mm.ui.chatting.d.a.a.bXu();
              com.tencent.mm.ui.chatting.d.a.a.bXv().a(paramAnonymousCharSequence, ((Long)localek.xoi.getTag(cb.vCC)).longValue());
            }
            GMTrace.o(17907866140672L, 133424);
          }
        });
        GMTrace.o(2285325254656L, 17027);
        return;
        localek.vyp.bUE();
        break;
        if (parama1.au(paramau) == ChattingTranslateView.a.vFT)
        {
          localek.vyp.bUF();
          break;
        }
        localek.vyp.bUE();
        break;
        localek.vyp.lg(true);
        break;
        j = 0;
        break label268;
        label561:
        paramString = h.a(localek.xoi.getContext(), paramString, (int)localek.xoi.getTextSize(), 1);
        parama = h.a(localek.xoi.getContext(), parama, (int)localek.xoi.getTextSize(), 1);
        localObject1 = localek.xoi;
        ap(paramau);
        a((CellTextView)localObject1, paramString, parama, " ");
        continue;
        label638:
        if (j == 0)
        {
          localek.a(localek.xoi);
          parama = h.a(localek.xoi.getContext(), paramString, (int)localek.xoi.getTextSize(), Integer.valueOf(31), ap(paramau));
          if ((parama1.vHt >= 0L) && (parama1.vHu != null) && (parama1.vHu.size() > 0))
          {
            parama = f.b(com.tencent.mm.plugin.fts.d.b.a.a(parama, parama1.vHu, a.b.mbV, d.a.maN));
            localek.xoi.S(parama.mbY);
          }
          else
          {
            localek.xoi.S(parama);
          }
        }
        else if (j != 0)
        {
          if (paramau.gxv.contains("notify@all")) {}
          for (localObject1 = "";; localObject1 = localek.xoi.getContext().getString(R.l.eMJ, new Object[] { "@" }) + "\n")
          {
            if (i == 0) {
              break label949;
            }
            paramString = h.a(localek.xoi.getContext(), localObject1 + paramString, (int)localek.xoi.getTextSize(), ap(paramau), Integer.valueOf(31));
            parama = h.a(localek.xoi.getContext(), parama, (int)localek.xoi.getTextSize(), ap(paramau), Integer.valueOf(31));
            localObject1 = localek.xoi;
            ap(paramau);
            a((CellTextView)localObject1, paramString, parama, " ");
            break;
          }
          label949:
          parama = h.a(localek.xoi.getContext(), localObject1 + paramString, (int)localek.xoi.getTextSize(), Integer.valueOf(31), ap(paramau));
          localek.xoi.S(parama);
        }
      }
      label1013:
      localObject2 = parama;
      parama = paramString;
      paramString = (String)localObject1;
      localObject1 = localObject2;
      continue;
      label1030:
      parama = (ag.a)localObject1;
      break label177;
      label1036:
      parama = paramString;
      paramString = (String)localObject2;
    }
  }
  
  public boolean a(ContextMenu paramContextMenu, View paramView, au paramau)
  {
    GMTrace.i(2285862125568L, 17031);
    int i;
    if ((paramau.bMa()) || (paramau.bLS()))
    {
      i = ((ds)paramView.getTag()).position;
      if (paramau.bMa()) {
        paramContextMenu.add(i, 102, 0, paramView.getContext().getString(R.l.dUe));
      }
      paramContextMenu.add(i, 108, 0, paramView.getContext().getString(R.l.eLz));
      if (com.tencent.mm.bb.d.Jr("favorite")) {
        paramContextMenu.add(i, 116, 0, paramView.getContext().getString(R.l.eFS));
      }
      if (g.L(this.vAn.uRf.uRz, paramau.field_type)) {
        paramContextMenu.add(i, 128, 0, paramView.getContext().getString(R.l.dUm));
      }
      if ((paramau.bMa()) && (e.Dn())) {
        this.vAn.bVz();
      }
      if (!this.vAn.bVz()) {
        paramContextMenu.add(i, 100, 0, paramView.getContext().getString(R.l.dUh));
      }
      if (c.oL())
      {
        if ((!paramau.bMi()) || (!paramau.bMm())) {
          break label266;
        }
        paramContextMenu.add(i, 124, 0, paramView.getContext().getString(R.l.dUu));
      }
    }
    for (;;)
    {
      GMTrace.o(2285862125568L, 17031);
      return true;
      label266:
      paramContextMenu.add(i, 124, 0, paramView.getContext().getString(R.l.dUw));
    }
  }
  
  public final boolean a(MenuItem paramMenuItem, En_5b8fbb1e.a parama, au paramau)
  {
    GMTrace.i(2285996343296L, 17032);
    GMTrace.o(2285996343296L, 17032);
    return false;
  }
  
  public final boolean a(View paramView, En_5b8fbb1e.a parama, au paramau)
  {
    GMTrace.i(2286130561024L, 17033);
    GMTrace.o(2286130561024L, 17033);
    return false;
  }
  
  protected final boolean a(En_5b8fbb1e.a parama)
  {
    GMTrace.i(2285191036928L, 17026);
    boolean bool = parama.vvA;
    GMTrace.o(2285191036928L, 17026);
    return bool;
  }
  
  protected boolean bUf()
  {
    GMTrace.i(2285727907840L, 17030);
    GMTrace.o(2285727907840L, 17030);
    return false;
  }
  
  public final boolean dq(View paramView)
  {
    GMTrace.i(18999727357952L, 141559);
    boolean bool = this.vAn.vzN.vDh.dq(paramView);
    GMTrace.o(18999727357952L, 141559);
    return bool;
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/ui/chatting/cb.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */