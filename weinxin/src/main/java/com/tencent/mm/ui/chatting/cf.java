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
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.tencent.gmtrace.GMTrace;
import com.tencent.mm.R.i;
import com.tencent.mm.R.l;
import com.tencent.mm.e.b.ce;
import com.tencent.mm.modelbiz.w;
import com.tencent.mm.modelstat.b;
import com.tencent.mm.modelvoice.n;
import com.tencent.mm.sdk.platformtools.bf;
import com.tencent.mm.sdk.platformtools.u;
import com.tencent.mm.storage.ar;
import com.tencent.mm.storage.au;
import com.tencent.mm.storage.t;
import com.tencent.mm.storage.x;
import com.tencent.mm.u.ap;
import com.tencent.mm.u.c;
import com.tencent.mm.u.o;
import com.tencent.mm.ui.a.a.a;
import com.tencent.mm.ui.base.AnimImageView;
import com.tencent.mm.ui.base.g;
import com.tencent.mm.ui.l;
import com.tencent.mm.ui.widget.MMTextView;

final class cf
  extends ag.b
{
  private SpannableStringBuilder sJj;
  private CharacterStyle sJm;
  private int sJp;
  private En_5b8fbb1e.a vAn;
  
  public cf()
  {
    super(6);
    GMTrace.i(2244523065344L, 16723);
    this.sJp = 3;
    this.sJj = new SpannableStringBuilder();
    this.sJm = new ForegroundColorSpan(-5066062);
    GMTrace.o(2244523065344L, 16723);
  }
  
  public final View a(LayoutInflater paramLayoutInflater, View paramView)
  {
    GMTrace.i(2244657283072L, 16724);
    Object localObject;
    if ((paramView != null) && (paramView.getTag() != null))
    {
      localObject = paramView;
      if (((ag.a)paramView.getTag()).type == this.klJ) {}
    }
    else
    {
      localObject = new bi(paramLayoutInflater, R.i.cXO);
      ((View)localObject).setTag(new eq(this.klJ).s((View)localObject, true));
    }
    GMTrace.o(2244657283072L, 16724);
    return (View)localObject;
  }
  
  public final void a(ag.a parama, int paramInt, En_5b8fbb1e.a parama1, au paramau, String paramString)
  {
    GMTrace.i(2244925718528L, 16726);
    this.vAn = parama1;
    parama = (eq)parama;
    parama.vMU.veA = true;
    boolean bool = parama1.vvA;
    parama.vMV.veA = true;
    bool = parama1.vvA;
    a(parama1.vzN, paramau.field_msgId);
    eq.a(parama, paramau, paramInt, parama1, true);
    if (paramau.bMq())
    {
      paramString = parama1.v(paramau.field_msgId, paramau.field_imgPath);
      if (!bf.mA(paramString))
      {
        parama.vMY.setText(paramString);
        parama.vMT.setMinWidth(com.tencent.mm.bg.a.fromDPToPix(parama1.uRf.uRz, 80));
        parama.vMV.setMinWidth(com.tencent.mm.bg.a.fromDPToPix(parama1.uRf.uRz, 80));
        parama.vMY.setMinWidth(com.tencent.mm.bg.a.fromDPToPix(parama1.uRf.uRz, 80));
        parama.vMT.setMaxWidth(com.tencent.mm.bg.a.fromDPToPix(parama1.uRf.uRz, 204));
        parama.vMV.setMaxWidth(com.tencent.mm.bg.a.fromDPToPix(parama1.uRf.uRz, 204));
        parama.vMY.setMaxWidth(com.tencent.mm.bg.a.fromDPToPix(parama1.uRf.uRz, 204));
        parama.vMY.setVisibility(0);
        parama.vMZ.setVisibility(8);
        label244:
        paramString = new n(paramau.field_content);
        if (paramString.time != 0L) {
          break label749;
        }
        parama.vwV.setVisibility(8);
      }
    }
    for (;;)
    {
      paramau = paramau.gxt;
      if ((paramau != null) && (paramau.length() != 0)) {
        break label940;
      }
      parama.vwP.setVisibility(8);
      GMTrace.o(2244925718528L, 16726);
      return;
      paramau.dG(paramau.gxu & 0xFFFFFFBF);
      parama.vNa.setVisibility(0);
      parama.vMW.setVisibility(8);
      break label244;
      if (!parama1.eK(paramau.field_msgId)) {
        break;
      }
      paramString = parama1.v(paramau.field_msgId, paramau.field_imgPath);
      Object localObject = parama1.eJ(paramau.field_msgId);
      SpannableStringBuilder localSpannableStringBuilder;
      if (!bf.mA(paramString)) {
        if (localObject == eq.a.vNk)
        {
          this.sJj.clear();
          localObject = parama.vMY;
          localSpannableStringBuilder = this.sJj;
          if ((localSpannableStringBuilder == null) || (paramString == null) || (paramString.length() == 0))
          {
            ((MMTextView)localObject).setText(localSpannableStringBuilder);
            label448:
            parama.vMY.setVisibility(0);
            parama.vMW.setVisibility(0);
            parama.vNa.setVisibility(8);
            parama.vMZ.setVisibility(8);
          }
        }
      }
      for (;;)
      {
        parama.vMT.setMinWidth(com.tencent.mm.bg.a.fromDPToPix(parama1.uRf.uRz, 80));
        parama.vMV.setMinWidth(com.tencent.mm.bg.a.fromDPToPix(parama1.uRf.uRz, 80));
        parama.vMY.setMinWidth(com.tencent.mm.bg.a.fromDPToPix(parama1.uRf.uRz, 80));
        parama.vMT.setMaxWidth(com.tencent.mm.bg.a.fromDPToPix(parama1.uRf.uRz, 204));
        parama.vMV.setMaxWidth(com.tencent.mm.bg.a.fromDPToPix(parama1.uRf.uRz, 204));
        parama.vMY.setMaxWidth(com.tencent.mm.bg.a.fromDPToPix(parama1.uRf.uRz, 204));
        break;
        if (paramString.length() < this.sJp) {
          i = paramString.length();
        }
        for (paramInt = 0;; paramInt = i - this.sJp)
        {
          localSpannableStringBuilder.append(paramString).setSpan(this.sJm, paramInt, i, 33);
          break;
          i = paramString.length();
        }
        parama.vMY.setText(paramString);
        break label448;
        if (localObject != eq.a.vNi)
        {
          parama.vMW.setVisibility(0);
          parama.vNa.setVisibility(8);
          parama.vMY.setVisibility(8);
          parama.vMZ.setVisibility(0);
        }
        else
        {
          parama.vNa.setVisibility(0);
          parama.vMW.setVisibility(8);
          parama.vMZ.setVisibility(8);
        }
      }
      label749:
      if (((parama1.vzN.vCX != null) && (parama1.vzN.vCX.vxN == paramau.field_msgId)) || (com.tencent.mm.modelvoice.q.C(paramau)))
      {
        paramInt = 1;
        label788:
        localObject = parama.vwV;
        if (paramInt == 0) {
          break label867;
        }
      }
      label867:
      for (int i = 8;; i = 0)
      {
        ((ImageView)localObject).setVisibility(i);
        i = (int)com.tencent.mm.modelvoice.q.aw(paramString.time);
        if (paramInt != 0) {
          break label873;
        }
        parama.vMS.setContentDescription(String.format(parama1.uRf.uRz.getString(R.l.far), new Object[] { Integer.valueOf(i) }));
        break;
        paramInt = 0;
        break label788;
      }
      label873:
      paramString = a.a.uVh;
      localObject = parama.vMS;
      parama1.eK(parama1.vzN.fJC);
      paramString.F((View)localObject, i);
      paramString = a.a.uVh;
      localObject = parama.vMT;
      parama1.eK(parama1.vzN.fJC);
      paramString.F((View)localObject, i);
    }
    label940:
    parama.vwP.setVisibility(0);
    b(parama1, parama.vwP, ds.TE(paramau));
    GMTrace.o(2244925718528L, 16726);
  }
  
  public final boolean a(ContextMenu paramContextMenu, View paramView, au paramau)
  {
    GMTrace.i(2245059936256L, 16727);
    ap.yY();
    int m;
    int i;
    label183:
    label232:
    int k;
    if (c.isSDCardAvailable())
    {
      m = ((ds)paramView.getTag()).position;
      if (((new n(paramau.field_content).time != 0L) || (paramau.field_isSend != 0)) && ((paramau.field_status != 1) || (paramau.field_isSend != 1)))
      {
        ap.yY();
        Boolean localBoolean = (Boolean)c.vr().get(26, null);
        Object localObject = localBoolean;
        if (localBoolean == null) {
          localObject = Boolean.valueOf(false);
        }
        if (!((Boolean)localObject).booleanValue()) {
          break label430;
        }
        paramContextMenu.add(m, 120, 0, R.l.dSv);
        ap.yY();
        localObject = c.wR().Rb(paramau.field_talker);
        if ((o.fh(paramau.field_talker)) || (o.fE(paramau.field_talker)) || (localObject == null) || (((x)localObject).bKU())) {
          break label448;
        }
        i = 1;
        if (com.tencent.mm.bb.d.Jr("favorite")) {
          paramContextMenu.add(m, 116, 0, paramView.getContext().getString(R.l.eFS));
        }
        if (i != 0)
        {
          if (w.DH().fx(2) <= 0) {
            break label454;
          }
          i = 1;
          if ((i != 0) && (!this.vAn.bVz())) {
            paramContextMenu.add(m, 114, 0, paramView.getContext().getString(R.l.dUd));
          }
        }
        k = 0;
        if (!paramau.bMq()) {
          break label468;
        }
        if (bf.mA(this.vAn.v(paramau.field_msgId, paramau.field_imgPath))) {
          break label460;
        }
        i = R.l.dUv;
      }
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
      if (!this.vAn.bVz()) {
        paramContextMenu.add(m, 100, 0, paramView.getContext().getString(R.l.dUj));
      }
      if ((j == 0) && (u.bIz()) && (i != -1)) {
        paramContextMenu.add(m, 121, 0, i);
      }
      GMTrace.o(2245059936256L, 16727);
      return true;
      label430:
      paramContextMenu.add(m, 119, 0, R.l.dSu);
      break;
      label448:
      i = 0;
      break label183;
      label454:
      i = 0;
      break label232;
      label460:
      i = R.l.dUx;
      continue;
      label468:
      if (this.vAn.eK(paramau.field_msgId)) {
        i = R.l.dUt;
      } else {
        i = R.l.dUx;
      }
    }
  }
  
  public final boolean a(MenuItem paramMenuItem, final En_5b8fbb1e.a parama, final au paramau)
  {
    GMTrace.i(2245194153984L, 16728);
    switch (paramMenuItem.getItemId())
    {
    default: 
      GMTrace.o(2245194153984L, 16728);
      return false;
    case 119: 
      parama.lk(true);
      GMTrace.o(2245194153984L, 16728);
      return true;
    case 120: 
      parama.lk(false);
      GMTrace.o(2245194153984L, 16728);
      return true;
    }
    if (En_5b8fbb1e.a.bVS()) {
      g.a(parama.uRf.uRz, parama.uRf.uRz.getString(R.l.faP), "", new DialogInterface.OnClickListener()
      {
        public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
        {
          GMTrace.i(2117955747840L, 15780);
          En_5b8fbb1e.a.bVT();
          parama.aJ(paramau);
          GMTrace.o(2117955747840L, 15780);
        }
      });
    }
    for (;;)
    {
      b.hTV.w(paramau);
      GMTrace.o(2245194153984L, 16728);
      return true;
      parama.aJ(paramau);
    }
  }
  
  public final boolean a(View paramView, En_5b8fbb1e.a parama, au paramau)
  {
    GMTrace.i(2245328371712L, 16729);
    GMTrace.o(2245328371712L, 16729);
    return false;
  }
  
  protected final boolean a(En_5b8fbb1e.a parama)
  {
    GMTrace.i(2244791500800L, 16725);
    boolean bool = parama.vvA;
    GMTrace.o(2244791500800L, 16725);
    return bool;
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/ui/chatting/cf.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */