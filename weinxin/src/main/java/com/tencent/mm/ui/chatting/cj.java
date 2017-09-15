package com.tencent.mm.ui.chatting;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.text.SpannableStringBuilder;
import android.text.style.CharacterStyle;
import android.text.style.ForegroundColorSpan;
import android.view.ContextMenu;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.tencent.gmtrace.GMTrace;
import com.tencent.mm.R.g;
import com.tencent.mm.R.i;
import com.tencent.mm.R.l;
import com.tencent.mm.bb.d;
import com.tencent.mm.bg.a;
import com.tencent.mm.e.b.ce;
import com.tencent.mm.modelstat.b;
import com.tencent.mm.modelvoice.n;
import com.tencent.mm.sdk.platformtools.bf;
import com.tencent.mm.sdk.platformtools.u;
import com.tencent.mm.storage.au;
import com.tencent.mm.u.ap;
import com.tencent.mm.u.c;
import com.tencent.mm.u.o;
import com.tencent.mm.ui.base.AnimImageView;
import com.tencent.mm.ui.base.g;
import com.tencent.mm.ui.l;
import com.tencent.mm.ui.q;
import com.tencent.mm.ui.widget.MMTextView;

final class cj
  extends ag.c
{
  private SpannableStringBuilder sJj;
  private CharacterStyle sJm;
  private int sJp;
  private En_5b8fbb1e.a vAn;
  
  public cj()
  {
    super(7);
    GMTrace.i(2161442291712L, 16104);
    this.sJp = 3;
    this.sJj = new SpannableStringBuilder();
    this.sJm = new ForegroundColorSpan(-5066062);
    GMTrace.o(2161442291712L, 16104);
  }
  
  public final View a(LayoutInflater paramLayoutInflater, View paramView)
  {
    GMTrace.i(2161576509440L, 16105);
    Object localObject;
    if ((paramView != null) && (paramView.getTag() != null))
    {
      localObject = paramView;
      if (((ag.a)paramView.getTag()).type == this.klJ) {}
    }
    else
    {
      localObject = new bi(paramLayoutInflater, R.i.cYr);
      ((View)localObject).setTag(new eq(this.klJ).s((View)localObject, false));
    }
    GMTrace.o(2161576509440L, 16105);
    return (View)localObject;
  }
  
  public final void a(ag.a parama, int paramInt, En_5b8fbb1e.a parama1, au paramau, String paramString)
  {
    GMTrace.i(2161710727168L, 16106);
    this.vAn = parama1;
    parama = (eq)parama;
    parama.vMU.veA = false;
    boolean bool = parama1.vvA;
    parama.vMV.veA = false;
    bool = parama1.vvA;
    a(parama1.vzN, paramau.field_msgId);
    eq.a(parama, paramau, paramInt, parama1, false);
    if (paramau.bMq())
    {
      paramString = parama1.v(paramau.field_msgId, paramau.field_imgPath);
      if (!bf.mA(paramString))
      {
        parama.vMY.setText(paramString);
        parama.vMT.setMinWidth(a.fromDPToPix(parama1.uRf.uRz, 80));
        parama.vMV.setMinWidth(a.fromDPToPix(parama1.uRf.uRz, 80));
        parama.vMY.setMinWidth(a.fromDPToPix(parama1.uRf.uRz, 80));
        parama.vMT.setMaxWidth(a.fromDPToPix(parama1.uRf.uRz, 204));
        parama.vMV.setMaxWidth(a.fromDPToPix(parama1.uRf.uRz, 204));
        parama.vMY.setMaxWidth(a.fromDPToPix(parama1.uRf.uRz, 204));
        parama.vMY.setVisibility(0);
        parama.vMZ.setVisibility(8);
        label244:
        if (!bUg()) {
          break label843;
        }
        if (parama.vNf != null) {
          parama.vNf.setVisibility(8);
        }
        if (parama.vwJ != null) {
          parama.vwJ.setVisibility(8);
        }
        if ((paramau.field_status != 1) && (paramau.field_status != 5)) {
          break label756;
        }
        parama.vNg.setBackgroundResource(R.g.bej);
        paramau.uId = true;
      }
    }
    for (;;)
    {
      a(paramInt, parama, paramau, parama1.vzN.hrv, parama1.vvA, parama1.vzN.vDb);
      GMTrace.o(2161710727168L, 16106);
      return;
      parama.vNa.setVisibility(0);
      parama.vMW.setVisibility(8);
      break label244;
      if (!parama1.eK(paramau.field_msgId)) {
        break;
      }
      paramString = parama1.v(paramau.field_msgId, paramau.field_imgPath);
      Object localObject = parama1.eJ(paramau.field_msgId);
      parama.vMT.setMinWidth(a.fromDPToPix(parama1.uRf.uRz, 80));
      parama.vMV.setMinWidth(a.fromDPToPix(parama1.uRf.uRz, 80));
      parama.vMY.setMinWidth(a.fromDPToPix(parama1.uRf.uRz, 80));
      parama.vMT.setMaxWidth(a.fromDPToPix(parama1.uRf.uRz, 204));
      parama.vMV.setMaxWidth(a.fromDPToPix(parama1.uRf.uRz, 204));
      parama.vMY.setMaxWidth(a.fromDPToPix(parama1.uRf.uRz, 204));
      if (!bf.mA(paramString))
      {
        SpannableStringBuilder localSpannableStringBuilder;
        if (localObject == eq.a.vNk)
        {
          this.sJj.clear();
          localObject = parama.vMY;
          localSpannableStringBuilder = this.sJj;
          if ((localSpannableStringBuilder == null) || (paramString == null) || (paramString.length() == 0)) {
            ((MMTextView)localObject).setText(localSpannableStringBuilder);
          }
        }
        for (;;)
        {
          parama.vMY.setVisibility(0);
          parama.vMW.setVisibility(0);
          parama.vNa.setVisibility(8);
          break;
          int j;
          if (paramString.length() < this.sJp) {
            j = paramString.length();
          }
          for (int i = 0;; i = j - this.sJp)
          {
            localSpannableStringBuilder.append(paramString).setSpan(this.sJm, i, j, 33);
            break;
            j = paramString.length();
          }
          parama.vMY.setText(paramString);
        }
      }
      if (localObject != eq.a.vNi)
      {
        parama.vMW.setVisibility(0);
        parama.vNa.setVisibility(8);
        parama.vMZ.setVisibility(0);
        parama.vMY.setVisibility(8);
        break label244;
      }
      parama.vNa.setVisibility(0);
      parama.vMW.setVisibility(8);
      break;
      label756:
      parama.vNg.setBackgroundResource(R.g.bei);
      if ((parama.vwJ != null) && (a(parama1.vzN, paramau.field_msgId)))
      {
        if (paramau.uId)
        {
          paramString = new AlphaAnimation(0.5F, 1.0F);
          paramString.setDuration(300L);
          parama.vNg.startAnimation(paramString);
          paramau.uId = false;
        }
        parama.vwJ.setVisibility(0);
        continue;
        label843:
        if (parama.vNf != null)
        {
          parama.vNf.setVisibility(0);
          if (paramau.field_status >= 2) {
            parama.vNf.setVisibility(8);
          }
        }
      }
    }
  }
  
  public final boolean a(ContextMenu paramContextMenu, View paramView, au paramau)
  {
    GMTrace.i(2161844944896L, 16107);
    ap.yY();
    int m;
    n localn;
    int k;
    int i;
    if (c.isSDCardAvailable())
    {
      m = ((ds)paramView.getTag()).position;
      localn = new n(paramau.field_content);
      if (((localn.time != 0L) || (paramau.field_isSend != 0)) && ((paramau.field_status != 1) || (paramau.field_isSend != 1)))
      {
        if (!this.vAn.jVH) {
          break label426;
        }
        paramContextMenu.add(m, 120, 0, R.l.dSv);
      }
      if (paramau.field_status == 5) {
        paramContextMenu.add(m, 103, 0, paramView.getContext().getString(R.l.dVe));
      }
      if (d.Jr("favorite")) {
        paramContextMenu.add(m, 116, 0, paramView.getContext().getString(R.l.eFS));
      }
      if ((!paramau.bLN()) && (paramau.bLP()) && ((paramau.field_status == 2) || (paramau.gxz == 1)) && (ao(paramau)) && (Tm(paramau.field_talker))) {
        paramContextMenu.add(m, 123, 0, paramView.getContext().getString(R.l.dUp));
      }
      k = 0;
      if (!paramau.bMq()) {
        break label452;
      }
      if (bf.mA(this.vAn.v(paramau.field_msgId, paramau.field_imgPath))) {
        break label444;
      }
      i = R.l.dUv;
    }
    for (;;)
    {
      int j = k;
      if (o.eV(paramau.field_talker))
      {
        j = k;
        if (u.bIz())
        {
          j = k;
          if (i != -1)
          {
            paramContextMenu.add(m, 121, 0, i);
            j = 1;
          }
        }
      }
      if (((localn.time != 0L) || (paramau.field_isSend != 0)) && ((paramau.field_status != 1) || (paramau.field_isSend != 1)) && (!this.vAn.bVz())) {
        paramContextMenu.add(m, 100, 0, paramView.getContext().getString(R.l.dUj));
      }
      if ((j == 0) && (u.bIz()) && (i != -1)) {
        paramContextMenu.add(m, 121, 0, i);
      }
      GMTrace.o(2161844944896L, 16107);
      return true;
      label426:
      paramContextMenu.add(m, 119, 0, R.l.dSu);
      break;
      label444:
      i = R.l.dUx;
      continue;
      label452:
      if (this.vAn.eK(paramau.field_msgId)) {
        i = R.l.dUt;
      } else {
        i = R.l.dUx;
      }
    }
  }
  
  public final boolean a(MenuItem paramMenuItem, final En_5b8fbb1e.a parama, final au paramau)
  {
    GMTrace.i(2161979162624L, 16108);
    switch (paramMenuItem.getItemId())
    {
    default: 
      GMTrace.o(2161979162624L, 16108);
      return false;
    case 119: 
      parama.lk(true);
      GMTrace.o(2161979162624L, 16108);
      return true;
    case 120: 
      parama.lk(false);
      GMTrace.o(2161979162624L, 16108);
      return true;
    }
    if (En_5b8fbb1e.a.bVS()) {
      g.a(parama.uRf.uRz, parama.uRf.uRz.getString(R.l.faP), "", new DialogInterface.OnClickListener()
      {
        public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
        {
          GMTrace.i(2519803625472L, 18774);
          En_5b8fbb1e.a.bVT();
          parama.aJ(paramau);
          GMTrace.o(2519803625472L, 18774);
        }
      });
    }
    for (;;)
    {
      b.hTV.w(paramau);
      GMTrace.o(2161979162624L, 16108);
      return true;
      parama.aJ(paramau);
    }
  }
  
  public final boolean a(View paramView, En_5b8fbb1e.a parama, au paramau)
  {
    GMTrace.i(2162113380352L, 16109);
    GMTrace.o(2162113380352L, 16109);
    return false;
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/ui/chatting/cj.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */