package com.tencent.mm.ui.chatting;

import android.graphics.Bitmap;
import android.view.View;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.tencent.gmtrace.GMTrace;
import com.tencent.mm.R.g;
import com.tencent.mm.R.h;
import com.tencent.mm.R.l;
import com.tencent.mm.ah.n;
import com.tencent.mm.e.a.hn;
import com.tencent.mm.e.a.ik;
import com.tencent.mm.e.a.ik.b;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.storage.au;
import com.tencent.mm.ui.l;
import com.tencent.mm.ui.q;

final class dv
  extends ag.a
{
  LinearLayout stm;
  TextView sto;
  TextView stp;
  ProgressBar stq;
  ImageView str;
  ProgressBar sts;
  ImageView stt;
  ImageView vwJ;
  
  public dv(int paramInt)
  {
    super(paramInt);
    GMTrace.i(2523695939584L, 18803);
    GMTrace.o(2523695939584L, 18803);
  }
  
  public static void a(dv paramdv, au paramau, boolean paramBoolean, int paramInt, En_5b8fbb1e.a parama)
  {
    GMTrace.i(2523964375040L, 18805);
    if (paramdv == null)
    {
      GMTrace.o(2523964375040L, 18805);
      return;
    }
    paramdv.stm.setVisibility(8);
    int i = com.tencent.mm.bg.a.fromDPToPix(parama.uRf.uRz, 236);
    int j = com.tencent.mm.bg.a.fromDPToPix(parama.uRf.uRz, 90);
    paramdv.sto.setMaxLines(1);
    paramdv.stp.setMaxLines(1);
    paramdv.stp.setText("");
    Object localObject2;
    ImageView localImageView;
    com.tencent.mm.ah.f localf;
    int k;
    int m;
    if (com.tencent.mm.bb.d.Jr("location"))
    {
      v.d("MicroMsg.LocationItemHolder", "plugin found!");
      localObject2 = new ik();
      ((ik)localObject2).fNV.fNQ = 1;
      ((ik)localObject2).fNV.fCQ = paramau;
      com.tencent.mm.sdk.b.a.uql.m((b)localObject2);
      localObject1 = ((ik)localObject2).fNW.fNY;
      localObject2 = ((ik)localObject2).fNW.fNZ;
      if (((localObject1 == null) && (!a((String)localObject2, parama))) || ((localObject1 != null) && (((String)localObject1).equals("")) && (!a((String)localObject2, parama))) || ((localObject1 != null) && (((String)localObject1).equals("err_not_started"))))
      {
        v.d("MicroMsg.LocationItemHolder", "info error or subcore not started!");
        paramdv.sts.setVisibility(0);
        paramdv.stm.setVisibility(0);
        paramdv.sto.setText("");
        paramdv.stp.setText("");
        localImageView = paramdv.str;
        localf = n.GT();
        k = R.g.bgk;
        m = R.g.bgT;
        if (!paramBoolean) {
          break label684;
        }
      }
    }
    label684:
    for (Object localObject1 = "location_backgroup_key_from";; localObject1 = "location_backgroup_key_tor")
    {
      Bitmap localBitmap = (Bitmap)localf.hFn.get(localObject1);
      if (localBitmap != null)
      {
        localObject2 = localBitmap;
        if (!localBitmap.isRecycled()) {}
      }
      else
      {
        localObject2 = com.tencent.mm.sdk.platformtools.d.s(k, m, i, j);
        localf.hFn.k(localObject1, localObject2);
      }
      localImageView.setImageBitmap((Bitmap)localObject2);
      localObject1 = new hn();
      ((hn)localObject1).fMN.fCQ = paramau;
      ((hn)localObject1).fMN.w = i;
      ((hn)localObject1).fMN.h = j;
      ((hn)localObject1).fMN.fMS = R.g.bgT;
      ((hn)localObject1).fMN.fMP = paramdv.str;
      ((hn)localObject1).fMN.fMR = paramdv.stq;
      ((hn)localObject1).fMN.fMQ = paramdv.stt;
      com.tencent.mm.sdk.b.a.uql.m((b)localObject1);
      paramdv.vAj.setTag(new ds(paramau, parama.vvA, paramInt, null, 0, (byte)0));
      paramdv.vAj.setOnClickListener(parama.vzN.vDb);
      paramdv.vAj.setOnLongClickListener(parama.vzN.vDd);
      paramdv.vAj.setOnTouchListener(parama.vzN.vDf);
      GMTrace.o(2523964375040L, 18805);
      return;
      paramdv.sts.setVisibility(8);
      paramdv.stm.setVisibility(0);
      v.d("MicroMsg.LocationItemHolder", "location info : " + (String)localObject1);
      if (a((String)localObject2, parama))
      {
        paramdv.sto.setVisibility(0);
        paramdv.sto.setText((CharSequence)localObject2);
        if ((localObject1 == null) || (((String)localObject1).equals("")))
        {
          paramdv.stp.setVisibility(8);
          break;
        }
        paramdv.stp.setVisibility(0);
        paramdv.stp.setText((CharSequence)localObject1);
        break;
      }
      paramdv.sto.setMaxLines(2);
      paramdv.sto.setText((CharSequence)localObject1);
      paramdv.stp.setVisibility(8);
      break;
      paramdv.stq.setVisibility(0);
      paramdv.stm.setVisibility(8);
      break;
    }
  }
  
  private static boolean a(String paramString, En_5b8fbb1e.a parama)
  {
    GMTrace.i(2524098592768L, 18806);
    if ((paramString != null) && (!paramString.equals("")) && (!paramString.equals(parama.getString(R.l.ewq))))
    {
      GMTrace.o(2524098592768L, 18806);
      return true;
    }
    GMTrace.o(2524098592768L, 18806);
    return false;
  }
  
  public final ag.a p(View paramView, boolean paramBoolean)
  {
    GMTrace.i(2523830157312L, 18804);
    super.dl(paramView);
    this.kvw = ((TextView)paramView.findViewById(R.h.bBt));
    this.stp = ((TextView)paramView.findViewById(R.h.bAM));
    this.sto = ((TextView)paramView.findViewById(R.h.bAO));
    this.stm = ((LinearLayout)paramView.findViewById(R.h.bAN));
    this.stq = ((ProgressBar)paramView.findViewById(R.h.bAJ));
    this.vAj = paramView.findViewById(R.h.bzX);
    this.phd = ((TextView)paramView.findViewById(R.h.bBz));
    this.mdQ = ((CheckBox)paramView.findViewById(R.h.bzW));
    this.nQv = paramView.findViewById(R.h.bAQ);
    this.str = ((ImageView)paramView.findViewById(R.h.bAL));
    this.sts = ((ProgressBar)paramView.findViewById(R.h.bAK));
    this.stt = ((ImageView)paramView.findViewById(R.h.bAf));
    if (paramBoolean) {}
    for (int i = 16;; i = 17)
    {
      this.type = i;
      if (!paramBoolean)
      {
        this.vwV = ((ImageView)paramView.findViewById(R.h.bBp));
        this.vwJ = ((ImageView)paramView.findViewById(R.h.bBr));
      }
      this.sto.setTextSize(1, 16.0F);
      this.stp.setTextSize(1, 12.0F);
      GMTrace.o(2523830157312L, 18804);
      return this;
    }
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/ui/chatting/dv.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */