package com.tencent.mm.ui.chatting;

import android.app.Activity;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.util.SparseArray;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.CheckBox;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.tencent.gmtrace.GMTrace;
import com.tencent.mm.R.e;
import com.tencent.mm.R.f;
import com.tencent.mm.R.h;
import com.tencent.mm.R.k;
import com.tencent.mm.ah.f;
import com.tencent.mm.ah.n;
import com.tencent.mm.bg.a;
import com.tencent.mm.e.b.ce;
import com.tencent.mm.modelvideo.o;
import com.tencent.mm.modelvideo.r;
import com.tencent.mm.modelvideo.s;
import com.tencent.mm.modelvideo.s.a.a;
import com.tencent.mm.modelvideo.s.a.b;
import com.tencent.mm.modelvideo.t;
import com.tencent.mm.platformtools.u;
import com.tencent.mm.pluginsdk.model.j;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.d;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.storage.au;
import com.tencent.mm.u.ap;
import com.tencent.mm.ui.l;
import com.tencent.mm.ui.q;
import com.tencent.mm.ui.widget.MMPinProgressBtn;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Map;

final class el
  extends ag.a
{
  private static SparseArray<String> vMA;
  public static Map<String, WeakReference<el>> vwN;
  TextView oBA;
  ImageView qhZ;
  ImageView vKZ;
  TextView vME;
  MMPinProgressBtn vMF;
  View vMG;
  ProgressBar vMH;
  ImageView vwI;
  ImageView vwJ;
  TextView vwP;
  ImageView vxc;
  ImageView vxd;
  
  static
  {
    GMTrace.i(2406792298496L, 17932);
    vMA = new SparseArray();
    vwN = new HashMap();
    GMTrace.o(2406792298496L, 17932);
  }
  
  public el(int paramInt)
  {
    super(paramInt);
    GMTrace.i(2406255427584L, 17928);
    GMTrace.o(2406255427584L, 17928);
  }
  
  public static void a(el paramel, au paramau, boolean paramBoolean, int paramInt1, En_5b8fbb1e.a parama, int paramInt2)
  {
    GMTrace.i(2406523863040L, 17930);
    Object localObject1 = (String)vMA.get(paramel.hashCode());
    if (localObject1 != null) {
      vwN.remove(localObject1);
    }
    vMA.put(paramel.hashCode(), paramau.field_imgPath);
    vwN.put(paramau.field_imgPath, new WeakReference(paramel));
    Object localObject2 = t.lI(paramau.field_imgPath);
    localObject1 = localObject2;
    if (localObject2 == null) {
      localObject1 = new r();
    }
    o.KW();
    localObject2 = s.lx(paramau.field_imgPath);
    localObject2 = n.GT().a((String)localObject2, a.getDensity(parama.uRf.uRz), parama.uRf.uRz, paramInt2);
    paramel.vKZ.setLayoutParams(new FrameLayout.LayoutParams(0, 0));
    int i;
    int j;
    if (localObject2 == null)
    {
      i = a.fromDPToPix(parama.uRf.uRz, 85);
      j = a.T(parama.uRf.uRz, R.f.aWG);
      localObject2 = d.a(d.U(parama.uRf.uRz.getResources().getColor(R.e.aUi), i, j), paramInt2, i, j);
      ap.yY();
      if (!com.tencent.mm.u.c.isSDCardAvailable())
      {
        paramel.vwI.setImageDrawable(a.a(parama.uRf.uRz, R.k.dAh));
        paramel.vwI.setBackground(new BitmapDrawable((Bitmap)localObject2));
        localObject2 = new FrameLayout.LayoutParams(i, j);
        paramel.vKZ.setLayoutParams((ViewGroup.LayoutParams)localObject2);
        label302:
        if (!paramBoolean) {
          break label866;
        }
        paramel.oBA.setText(u.ay(((r)localObject1).hrb));
        paramel.vME.setText(u.ha(((r)localObject1).hZV));
        paramInt2 = ((r)localObject1).status;
        v.i("MicroMsg.VideoItemHoder", "parseVideo from video status : " + paramInt2 + " info : " + ((r)localObject1).getFileName());
        if (paramInt2 != 199) {
          break label717;
        }
        paramel.qhZ.setImageDrawable(a.a(parama.uRf.uRz, R.k.dzp));
        label411:
        if ((paramInt2 != 112) && (paramInt2 != 122) && (paramInt2 != 120)) {
          break label750;
        }
        paramel.vxc.setVisibility(8);
        paramel.qhZ.setVisibility(8);
        paramel.vMF.setVisibility(0);
        paramel.vMF.setProgress(t.f((r)localObject1));
        v.v("MicroMsg.VideoItemHoder", "status begin");
        paramel.vMF.invalidate();
      }
    }
    for (;;)
    {
      paramel.vxd.setTag(new ds(paramau, parama.vvA, paramInt1, paramau.field_talker, 4, (byte)0));
      paramel.vxd.setOnClickListener(parama.vzN.vDb);
      paramel.vxc.setTag(new ds(paramau, parama.vvA, paramInt1, paramau.field_talker, 3, (byte)0));
      paramel.vxc.setOnClickListener(parama.vzN.vDb);
      paramel.vAj.setTag(new ds(paramau, parama.vvA, paramInt1, paramau.field_talker, 2, (byte)0));
      paramel.vAj.setOnClickListener(parama.vzN.vDb);
      paramel.vAj.setOnLongClickListener(parama.vzN.vDd);
      paramel.vAj.setOnTouchListener(parama.vzN.vDf);
      GMTrace.o(2406523863040L, 17930);
      return;
      localObject2 = d.a((Bitmap)localObject2, paramInt2, i, j);
      paramel.vwI.setImageBitmap((Bitmap)localObject2);
      break;
      paramel.vwI.setImageBitmap((Bitmap)localObject2);
      localObject2 = new FrameLayout.LayoutParams(((Bitmap)localObject2).getWidth(), ((Bitmap)localObject2).getHeight());
      paramel.vKZ.setLayoutParams((ViewGroup.LayoutParams)localObject2);
      break label302;
      label717:
      paramel.qhZ.setImageDrawable(a.a(parama.uRf.uRz, R.k.dzp));
      paramel.oBA.setVisibility(8);
      break label411;
      label750:
      if ((paramInt2 == 113) || (paramInt2 == 198) || (((r)localObject1).Lj()))
      {
        paramel.vxc.setVisibility(0);
        paramel.vxd.setVisibility(8);
        paramel.vMF.setVisibility(8);
        paramel.qhZ.setVisibility(0);
        v.v("MicroMsg.VideoItemHoder", "status pause");
      }
      else
      {
        paramel.vxd.setVisibility(8);
        paramel.vxc.setVisibility(8);
        paramel.vMF.setVisibility(8);
        paramel.qhZ.setVisibility(0);
        v.v("MicroMsg.VideoItemHoder", "status gone");
        continue;
        label866:
        paramel.oBA.setText(u.ay(((r)localObject1).hrb));
        paramel.vME.setText(u.ha(((r)localObject1).hZV));
        paramInt2 = ((r)localObject1).status;
        paramel.qhZ.setImageDrawable(a.a(parama.uRf.uRz, R.k.dzp));
        if (paramel.vMH != null) {
          paramel.vMH.setVisibility(8);
        }
        v.v("MicroMsg.VideoItemHoder", "video status %d", new Object[] { Integer.valueOf(paramInt2) });
        if ((paramInt2 == 104) || (paramInt2 == 103))
        {
          if (com.tencent.mm.plugin.mmsight.c.pu(((r)localObject1).hZW))
          {
            if (paramel.vMH != null) {
              paramel.vMH.setVisibility(0);
            }
            paramel.vME.setText(null);
            paramel.oBA.setText(null);
            paramel.qhZ.setImageDrawable(null);
            paramel.vxd.setVisibility(8);
            paramel.vxc.setVisibility(8);
            paramel.vMF.setVisibility(8);
          }
          for (;;)
          {
            v.v("MicroMsg.VideoItemHoder", "status begin");
            break;
            paramel.vMH.setVisibility(8);
            paramel.vxc.setVisibility(8);
            paramel.qhZ.setVisibility(8);
            paramel.vMF.setVisibility(0);
            paramel.vMF.setProgress(t.g((r)localObject1));
          }
        }
        if ((paramInt2 == 105) || (paramInt2 == 198) || (((r)localObject1).Lj()))
        {
          paramel.vxc.setVisibility(0);
          paramel.vxd.setVisibility(8);
          paramel.vMF.setVisibility(8);
          paramel.qhZ.setVisibility(0);
          v.v("MicroMsg.VideoItemHoder", "status pause");
        }
        else if (paramInt2 == 106)
        {
          if (!j.LR(paramau.field_imgPath))
          {
            t.lB(paramau.field_imgPath);
          }
          else
          {
            if (paramel.vMH != null) {
              paramel.vMH.setVisibility(0);
            }
            paramel.vME.setText(null);
            paramel.oBA.setText(null);
            paramel.qhZ.setImageDrawable(null);
            paramel.vxd.setVisibility(8);
            paramel.vxc.setVisibility(8);
            paramel.vMF.setVisibility(8);
          }
        }
        else
        {
          paramel.vxd.setVisibility(8);
          paramel.vxc.setVisibility(8);
          paramel.vMF.setVisibility(8);
          paramel.qhZ.setVisibility(0);
          v.v("MicroMsg.VideoItemHoder", "status gone");
        }
      }
    }
  }
  
  public static boolean b(s.a.a parama)
  {
    GMTrace.i(2406121209856L, 17927);
    if (parama.ial != s.a.b.iap)
    {
      GMTrace.o(2406121209856L, 17927);
      return false;
    }
    r localr = t.lI(parama.fyw);
    if (localr == null)
    {
      v.w("MicroMsg.VideoItemHoder", "update status, filename %s, videoInfo not found", new Object[] { parama.fyw });
      GMTrace.o(2406121209856L, 17927);
      return false;
    }
    if ((localr.status != 112) && (localr.status != 104) && (localr.status != 103))
    {
      GMTrace.o(2406121209856L, 17927);
      return false;
    }
    ae.v(new Runnable()
    {
      public final void run()
      {
        GMTrace.i(2287338520576L, 17042);
        Object localObject = (WeakReference)el.vwN.get(this.vDT.getFileName());
        if (localObject == null)
        {
          v.w("MicroMsg.VideoItemHoder", "update status, filename %s, holder not found", new Object[] { this.vDT.getFileName() });
          GMTrace.o(2287338520576L, 17042);
          return;
        }
        localObject = (el)((WeakReference)localObject).get();
        if (localObject == null)
        {
          v.w("MicroMsg.VideoItemHoder", "update status, filename %s, holder gc!", new Object[] { this.vDT.getFileName() });
          GMTrace.o(2287338520576L, 17042);
          return;
        }
        ((el)localObject).vxc.setVisibility(8);
        ((el)localObject).qhZ.setVisibility(8);
        ((el)localObject).vMF.setVisibility(0);
        int i = this.vDT.status;
        v.i("MicroMsg.VideoItemHoder", "updateStatus videoStatus : " + i);
        if ((i == 112) || (i == 122) || (i == 120))
        {
          ((el)localObject).vMF.setProgress(t.f(this.vDT));
          GMTrace.o(2287338520576L, 17042);
          return;
        }
        ((el)localObject).vMF.setProgress(t.g(this.vDT));
        GMTrace.o(2287338520576L, 17042);
      }
    });
    GMTrace.o(2406121209856L, 17927);
    return true;
  }
  
  public final ag.a p(View paramView, boolean paramBoolean)
  {
    GMTrace.i(2406389645312L, 17929);
    super.dl(paramView);
    this.kvw = ((TextView)paramView.findViewById(R.h.bBt));
    this.vwI = ((ImageView)paramView.findViewById(R.h.bAc));
    this.phd = ((TextView)paramView.findViewById(R.h.bBz));
    this.oBA = ((TextView)paramView.findViewById(R.h.bBn));
    this.vME = ((TextView)paramView.findViewById(R.h.bAI));
    this.qhZ = ((ImageView)paramView.findViewById(R.h.bBq));
    this.vxc = ((ImageView)paramView.findViewById(R.h.bAg));
    this.vxd = ((ImageView)paramView.findViewById(R.h.bBs));
    this.vMF = ((MMPinProgressBtn)paramView.findViewById(R.h.bAk));
    this.vMG = paramView.findViewById(R.h.bBB);
    this.vAj = paramView.findViewById(R.h.bzX);
    int i;
    ImageView localImageView;
    if (paramBoolean)
    {
      i = 10;
      this.type = i;
      this.vwP = ((TextView)paramView.findViewById(R.h.bzr));
      this.mdQ = ((CheckBox)paramView.findViewById(R.h.bzW));
      this.nQv = paramView.findViewById(R.h.bAQ);
      this.vKZ = ((ImageView)paramView.findViewById(R.h.bAe));
      if (paramBoolean) {
        break label286;
      }
      localImageView = (ImageView)paramView.findViewById(R.h.bBr);
      label243:
      this.vwJ = localImageView;
      if (paramBoolean) {
        break label292;
      }
    }
    label286:
    label292:
    for (paramView = (ProgressBar)paramView.findViewById(R.h.bBC);; paramView = null)
    {
      this.vMH = paramView;
      GMTrace.o(2406389645312L, 17929);
      return this;
      i = 11;
      break;
      localImageView = null;
      break label243;
    }
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/ui/chatting/el.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */