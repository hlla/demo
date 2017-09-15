package com.tencent.mm.ui.chatting;

import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.CheckBox;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.tencent.gmtrace.GMTrace;
import com.tencent.mm.R.a;
import com.tencent.mm.R.g;
import com.tencent.mm.R.h;
import com.tencent.mm.R.l;
import com.tencent.mm.e.b.ce;
import com.tencent.mm.modelvoice.n;
import com.tencent.mm.pluginsdk.ui.e;
import com.tencent.mm.storage.au;
import com.tencent.mm.ui.a.a.a;
import com.tencent.mm.ui.base.AnimImageView;
import com.tencent.mm.ui.l;
import com.tencent.mm.ui.widget.MMTextView;

final class eq
  extends ag.a
{
  TextView stp;
  TextView vMR;
  TextView vMS;
  TextView vMT;
  AnimImageView vMU;
  AnimImageView vMV;
  LinearLayout vMW;
  LinearLayout vMX;
  MMTextView vMY;
  ProgressBar vMZ;
  FrameLayout vNa;
  FrameLayout vNb;
  FrameLayout vNc;
  ImageView vNd;
  AnimImageView vNe;
  ProgressBar vNf;
  TextView vNg;
  Animation vNh;
  ImageView vwJ;
  TextView vwP;
  
  public eq(int paramInt)
  {
    super(paramInt);
    GMTrace.i(2217545302016L, 16522);
    GMTrace.o(2217545302016L, 16522);
  }
  
  private static void a(eq parameq, int paramInt1, int paramInt2, boolean paramBoolean1, boolean paramBoolean2)
  {
    GMTrace.i(14468134207488L, 107796);
    parameq.vwV.setVisibility(paramInt2);
    parameq.stp.setVisibility(paramInt2);
    if (paramBoolean1)
    {
      parameq.vNe.setVisibility(paramInt1);
      parameq.vwP.setVisibility(paramInt2);
    }
    while (paramInt2 == 0) {
      if (paramBoolean2)
      {
        parameq.vNa.setVisibility(8);
        parameq.vMW.setVisibility(0);
        parameq.vMZ.setVisibility(0);
        GMTrace.o(14468134207488L, 107796);
        return;
        parameq.vNg.setVisibility(paramInt1);
      }
      else
      {
        parameq.vNa.setVisibility(0);
        parameq.vMW.setVisibility(8);
        parameq.vMZ.setVisibility(8);
        GMTrace.o(14468134207488L, 107796);
        return;
      }
    }
    parameq.vNa.setVisibility(8);
    parameq.vMW.setVisibility(8);
    parameq.vMZ.setVisibility(8);
    GMTrace.o(14468134207488L, 107796);
  }
  
  public static void a(eq parameq, au paramau, int paramInt, En_5b8fbb1e.a parama, boolean paramBoolean)
  {
    GMTrace.i(2217813737472L, 16524);
    if (parameq == null)
    {
      GMTrace.o(2217813737472L, 16524);
      return;
    }
    Object localObject = new n(paramau.field_content);
    float f2 = com.tencent.mm.modelvoice.q.aw(((n)localObject).time);
    float f1;
    if ((parama.vzN.vCX != null) && (paramau.field_msgId == parama.vzN.vCX.vxN))
    {
      parameq.vMU.setVisibility(0);
      parameq.vMV.setVisibility(0);
      parameq.vMU.bRr();
      parameq.vMV.bRr();
      f1 = f2;
      if (paramau.field_isSend == 0)
      {
        if (((n)localObject).time != 0L) {
          break label712;
        }
        a(parameq, 8, 0, true, paramau.bMq());
        parameq.vNe.aWQ();
        parameq.vNe.setVisibility(8);
        parameq.vwV.setVisibility(8);
        f1 = 0.0F;
        parameq.vMS.setWidth(com.tencent.mm.bg.a.fromDPToPix(parama.uRf.uRz, jV(0)));
        parameq.stp.setText(parama.getString(R.l.elS, new Object[] { Integer.valueOf(0) }));
        parameq.vMU.setWidth(com.tencent.mm.bg.a.fromDPToPix(parama.uRf.uRz, jV(0)));
      }
      label232:
      f2 = f1;
      if (1 != paramau.field_isSend) {
        break label1201;
      }
      if (paramau.field_status != 1) {
        break label916;
      }
      a(parameq, 0, 8, false, paramau.bMq());
      parameq.vNc.setVisibility(8);
      parameq.bWh();
      label277:
      if (parama.vzN.oIE != null)
      {
        parameq.stp.setTextColor(parama.vzN.oIE.sGO);
        if (!parama.vzN.oIE.sGP) {
          break label1208;
        }
        parameq.stp.setShadowLayer(2.0F, 1.2F, 1.2F, parama.vzN.oIE.sGQ);
        label339:
        if (!parama.vzN.oIE.sGR) {
          break label1222;
        }
        parameq.stp.setBackgroundResource(R.g.beh);
      }
      label362:
      localObject = new ds(paramau, parama.vvA, paramInt, null, 0, (byte)0);
      parameq.vMS.setTag(localObject);
      parameq.vMT.setTag(localObject);
      parameq.vMS.setOnClickListener(parama.vzN.vDb);
      parameq.vMT.setOnClickListener(parama.vzN.vDb);
      parameq.vMS.setOnLongClickListener(parama.vzN.vDd);
      parameq.vMS.setOnTouchListener(parama.vzN.vDf);
      parameq.vMT.setOnLongClickListener(parama.vzN.vDd);
      parameq.vMT.setOnTouchListener(parama.vzN.vDf);
      parameq.vMY.setTag(localObject);
      parameq.vMY.setOnClickListener(null);
      parameq.vMY.wuG = parama.vzN.vDh;
      parameq.vMY.setOnLongClickListener(parama.vzN.vDd);
      parameq.vMY.setOnTouchListener(parama.vzN.vDf);
      if ((paramau.gxu & 0x1) != 1) {
        break label1266;
      }
      parameq.vMR.setVisibility(0);
      if (paramau.field_isSend != 0) {
        break label1233;
      }
      parameq.vMU.setBackgroundResource(R.g.bdY);
      parameq.vMV.setBackgroundResource(R.g.bdY);
      label586:
      if (!paramBoolean) {
        break label1318;
      }
    }
    label712:
    label916:
    label1201:
    label1208:
    label1222:
    label1233:
    label1266:
    label1318:
    for (paramau = parama.vzN.fJC;; paramau = parama.vzN.hrv)
    {
      localObject = a.a.uVh;
      TextView localTextView = parameq.vMS;
      paramInt = (int)f1;
      parama.eK(paramau);
      ((com.tencent.mm.ui.a.a)localObject).F(localTextView, paramInt);
      localObject = a.a.uVh;
      localTextView = parameq.vMT;
      paramInt = (int)f1;
      parama.eK(paramau);
      ((com.tencent.mm.ui.a.a)localObject).F(localTextView, paramInt);
      parameq.stp.setContentDescription(" ");
      GMTrace.o(2217813737472L, 16524);
      return;
      parameq.vMV.setVisibility(8);
      parameq.vMU.setVisibility(8);
      parameq.vMU.aWQ();
      parameq.vMV.aWQ();
      break;
      if (((n)localObject).time == -1L)
      {
        a(parameq, 8, 0, true, paramau.bMq());
        parameq.vNe.aWQ();
        parameq.vNe.setVisibility(8);
        parameq.vMS.setWidth(80);
        parameq.stp.setVisibility(8);
        parameq.vMU.setWidth(com.tencent.mm.bg.a.fromDPToPix(parama.uRf.uRz, jV((int)f2)));
        f1 = f2;
        break label232;
      }
      a(parameq, 8, 0, true, paramau.bMq());
      parameq.vNe.aWQ();
      parameq.vNe.setVisibility(8);
      parameq.stp.setVisibility(0);
      parameq.vMS.setWidth(com.tencent.mm.bg.a.fromDPToPix(parama.uRf.uRz, jV((int)f2)));
      parameq.stp.setText(parama.getString(R.l.elS, new Object[] { Integer.valueOf((int)f2) }));
      parameq.vMU.setWidth(com.tencent.mm.bg.a.fromDPToPix(parama.uRf.uRz, jV((int)f2)));
      f1 = f2;
      break label232;
      if (((n)localObject).time == -1L)
      {
        a(parameq, 8, 0, false, paramau.bMq());
        parameq.vMS.setWidth(80);
        parameq.stp.setVisibility(8);
        parameq.vNc.setVisibility(8);
        parameq.vMU.setWidth(com.tencent.mm.bg.a.fromDPToPix(parama.uRf.uRz, jV((int)f1)));
        parameq.bWh();
        break label277;
      }
      if (paramau.field_status == 7)
      {
        a(parameq, 8, 8, false, paramau.bMq());
        parameq.stp.setVisibility(8);
        parameq.vNc.setVisibility(0);
        parameq.bWh();
        if (parameq.vNd != null)
        {
          parameq.vNh = AnimationUtils.loadAnimation(parameq.mgy.getContext(), R.a.aRV);
          parameq.vNd.startAnimation(parameq.vNh);
        }
        break label277;
      }
      a(parameq, 8, 0, false, paramau.bMq());
      parameq.vNc.setVisibility(8);
      parameq.stp.setVisibility(0);
      parameq.bWh();
      if (((n)localObject).time == 0L) {
        f1 = 0.0F;
      }
      parameq.vMS.setWidth(com.tencent.mm.bg.a.fromDPToPix(parama.uRf.uRz, jV((int)f1)));
      parameq.stp.setText(parama.getString(R.l.elS, new Object[] { Integer.valueOf((int)f1) }));
      parameq.vMU.setWidth(com.tencent.mm.bg.a.fromDPToPix(parama.uRf.uRz, jV((int)f1)));
      f2 = f1;
      f1 = f2;
      break label277;
      parameq.stp.setShadowLayer(0.0F, 0.0F, 0.0F, 0);
      break label339;
      parameq.stp.setBackgroundColor(0);
      break label362;
      parameq.vNg.setBackgroundResource(R.g.bek);
      parameq.vMU.setBackgroundResource(R.g.bek);
      parameq.vMV.setBackgroundResource(R.g.bek);
      break label586;
      parameq.vMR.setVisibility(8);
      if (paramau.field_isSend == 0)
      {
        parameq.vMU.setBackgroundResource(R.g.bdS);
        break label586;
      }
      parameq.vNg.setBackgroundResource(R.g.bei);
      parameq.vMU.setBackgroundResource(R.g.bei);
      break label586;
    }
  }
  
  private void bWh()
  {
    GMTrace.i(2217947955200L, 16525);
    if (this.vNh != null)
    {
      this.vNh.cancel();
      this.vNh = null;
    }
    GMTrace.o(2217947955200L, 16525);
  }
  
  private static int jV(int paramInt)
  {
    GMTrace.i(2218216390656L, 16527);
    if (paramInt <= 2)
    {
      GMTrace.o(2218216390656L, 16527);
      return 80;
    }
    if (paramInt < 10)
    {
      GMTrace.o(2218216390656L, 16527);
      return (paramInt - 2) * 9 + 80;
    }
    if (paramInt < 60)
    {
      paramInt /= 10;
      GMTrace.o(2218216390656L, 16527);
      return (paramInt + 7) * 9 + 80;
    }
    GMTrace.o(2218216390656L, 16527);
    return 204;
  }
  
  public final ag.a s(View paramView, boolean paramBoolean)
  {
    GMTrace.i(2217679519744L, 16523);
    super.dl(paramView);
    this.kvw = ((TextView)paramView.findViewById(R.h.bBt));
    this.phd = ((TextView)paramView.findViewById(R.h.bBz));
    this.vMS = ((TextView)paramView.findViewById(R.h.bBH));
    this.vMT = ((TextView)paramView.findViewById(R.h.bBI));
    this.mdQ = ((CheckBox)paramView.findViewById(R.h.bzW));
    this.nQv = paramView.findViewById(R.h.bAQ);
    this.vwV = ((ImageView)paramView.findViewById(R.h.bBp));
    this.stp = ((TextView)paramView.findViewById(R.h.bAb));
    this.vNa = ((FrameLayout)paramView.findViewById(R.h.bBJ));
    this.vNb = ((FrameLayout)paramView.findViewById(R.h.bBK));
    this.vMW = ((LinearLayout)paramView.findViewById(R.h.bBL));
    this.vMX = ((LinearLayout)paramView.findViewById(R.h.bBM));
    this.vMY = ((MMTextView)paramView.findViewById(R.h.bBN));
    this.vMZ = ((ProgressBar)paramView.findViewById(R.h.bBO));
    this.vMR = ((TextView)paramView.findViewById(R.h.bBF));
    this.vMU = ((AnimImageView)paramView.findViewById(R.h.bBD));
    this.vMV = ((AnimImageView)paramView.findViewById(R.h.bBE));
    this.vMU.setType(1);
    this.vMV.setType(2);
    if (paramBoolean)
    {
      this.type = 6;
      this.vMU.veA = true;
      this.vMV.veA = true;
      this.vwP = ((TextView)paramView.findViewById(R.h.bzr));
      this.vNe = ((AnimImageView)paramView.findViewById(R.h.bBG));
      this.vNe.veA = true;
      this.vNe.setType(0);
    }
    for (;;)
    {
      GMTrace.o(2217679519744L, 16523);
      return this;
      this.vNc = ((FrameLayout)paramView.findViewById(R.h.bBP));
      this.vNd = ((ImageView)paramView.findViewById(R.h.bBQ));
      this.vNf = ((ProgressBar)paramView.findViewById(R.h.bBR));
      this.oCh = ((ProgressBar)paramView.findViewById(R.h.cKO));
      this.vNg = ((TextView)paramView.findViewById(R.h.bBS));
      this.vMU.veA = false;
      this.vMV.veA = false;
      this.type = 7;
      this.vwJ = ((ImageView)paramView.findViewById(R.h.bBr));
    }
  }
  
  public static enum a
  {
    static
    {
      GMTrace.i(14465852506112L, 107779);
      vNi = new a("NoTransform", 0);
      vNj = new a("PreTransform", 1);
      vNk = new a("Transforming", 2);
      vNl = new a("Transformed", 3);
      vNm = new a[] { vNi, vNj, vNk, vNl };
      GMTrace.o(14465852506112L, 107779);
    }
    
    private a()
    {
      GMTrace.i(14465718288384L, 107778);
      GMTrace.o(14465718288384L, 107778);
    }
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/ui/chatting/eq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */