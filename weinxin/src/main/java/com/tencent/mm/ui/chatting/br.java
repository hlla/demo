package com.tencent.mm.ui.chatting;

import android.content.Context;
import android.content.Intent;
import android.graphics.BitmapFactory;
import android.view.ContextMenu;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.tencent.gmtrace.GMTrace;
import com.tencent.mm.R.g;
import com.tencent.mm.R.i;
import com.tencent.mm.R.l;
import com.tencent.mm.ah.f;
import com.tencent.mm.ah.n;
import com.tencent.mm.e.a.dd;
import com.tencent.mm.e.a.dd.b;
import com.tencent.mm.e.b.ce;
import com.tencent.mm.modelbiz.e;
import com.tencent.mm.pluginsdk.model.app.g;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.storage.au;
import com.tencent.mm.u.ap;
import com.tencent.mm.u.c;
import com.tencent.mm.ui.l;
import com.tencent.mm.ui.q;

final class br
  extends ag.b
{
  En_5b8fbb1e.a vAn;
  
  public br()
  {
    super(1);
    GMTrace.i(2522353762304L, 18793);
    GMTrace.o(2522353762304L, 18793);
  }
  
  public final View a(LayoutInflater paramLayoutInflater, View paramView)
  {
    GMTrace.i(2522487980032L, 18794);
    Object localObject;
    if ((paramView != null) && (paramView.getTag() != null))
    {
      localObject = paramView;
      if (((ag.a)paramView.getTag()).type == this.klJ) {}
    }
    else
    {
      localObject = new bi(paramLayoutInflater, R.i.cXL);
      ((View)localObject).setTag(new dr(this.klJ).p((View)localObject, true));
    }
    GMTrace.o(2522487980032L, 18794);
    return (View)localObject;
  }
  
  protected final String a(En_5b8fbb1e.a parama, au paramau)
  {
    GMTrace.i(2522622197760L, 18795);
    parama = super.a(parama, paramau);
    GMTrace.o(2522622197760L, 18795);
    return parama;
  }
  
  public final void a(ag.a parama, int paramInt, En_5b8fbb1e.a parama1, au paramau, String paramString)
  {
    GMTrace.i(2522756415488L, 18796);
    this.vAn = parama1;
    parama1.aH(paramau);
    dr localdr = (dr)parama;
    boolean bool = n.GT().a(localdr.vwI, paramau.field_imgPath, com.tencent.mm.bg.a.getDensity(parama1.uRf.uRz), paramau.gxw, paramau.gxx, R.g.bdG, localdr.vKZ, R.g.bdH, 1, null);
    localdr.vLa.setVisibility(0);
    localdr.oCh.setVisibility(8);
    if ((!bool) && (!this.sWq)) {
      localdr.vwI.setImageBitmap(BitmapFactory.decodeResource(parama1.getResources(), R.g.bhQ));
    }
    parama = null;
    if (parama1.vvA) {
      parama = paramau.field_talker;
    }
    localdr.vAj.setTag(new ds(paramau, parama1.vvA, paramInt, paramString, parama));
    localdr.vAj.setOnClickListener(parama1.vzN.vDb);
    localdr.vAj.setOnLongClickListener(parama1.vzN.vDd);
    localdr.vAj.setOnTouchListener(parama1.vzN.vDf);
    if ((paramau.field_content == null) || (paramau.field_content.length() == 0))
    {
      localdr.vwP.setVisibility(8);
      GMTrace.o(2522756415488L, 18796);
      return;
    }
    localdr.vwP.setVisibility(8);
    GMTrace.o(2522756415488L, 18796);
  }
  
  public final boolean a(ContextMenu paramContextMenu, View paramView, au paramau)
  {
    GMTrace.i(2523024850944L, 18798);
    ap.yY();
    int k;
    Object localObject1;
    Object localObject2;
    int j;
    int i;
    if ((c.isSDCardAvailable()) && (paramView != null) && (paramau != null))
    {
      k = ((ds)paramView.getTag()).position;
      localObject1 = null;
      if (paramau.field_msgId > 0L) {
        localObject1 = n.GT().aj(paramau.field_msgId);
      }
      if (localObject1 != null)
      {
        localObject2 = localObject1;
        if (((com.tencent.mm.ah.d)localObject1).hEG > 0L) {}
      }
      else
      {
        localObject2 = localObject1;
        if (paramau.field_msgSvrId > 0L) {
          localObject2 = n.GT().ai(paramau.field_msgSvrId);
        }
      }
      paramContextMenu.add(k, 110, 0, paramView.getContext().getString(R.l.eLz));
      if ((e.Dp()) && (!this.vAn.bVz())) {
        paramContextMenu.add(k, 114, 0, paramView.getContext().getString(R.l.dUd));
      }
      if (com.tencent.mm.bb.d.Jr("favorite")) {
        paramContextMenu.add(k, 116, 0, paramView.getContext().getString(R.l.eFS));
      }
      localObject1 = new dd();
      ((dd)localObject1).fGN.fGD = paramau.field_msgId;
      com.tencent.mm.sdk.b.a.uql.m((b)localObject1);
      if ((((dd)localObject1).fGO.fGl) || (g.L(this.vAn.uRf.uRz, paramau.field_type))) {
        paramContextMenu.add(k, 128, 0, paramView.getContext().getString(R.l.dUm));
      }
      if ((com.tencent.mm.bb.d.Jr("photoedit")) && (((com.tencent.mm.ah.d)localObject2).status != -1))
      {
        paramau = paramContextMenu.add(k, 130, 0, paramView.getContext().getString(R.l.dTF));
        localObject1 = new int[2];
        if (paramView == null) {
          break label450;
        }
        j = paramView.getWidth();
        i = paramView.getHeight();
        paramView.getLocationInWindow((int[])localObject1);
      }
    }
    for (;;)
    {
      localObject2 = new Intent();
      ((Intent)localObject2).putExtra("img_gallery_width", j).putExtra("img_gallery_height", i).putExtra("img_gallery_left", localObject1[0]).putExtra("img_gallery_top", localObject1[1]);
      paramau.setIntent((Intent)localObject2);
      if (!this.vAn.bVz()) {
        paramContextMenu.add(k, 100, 0, paramView.getContext().getString(R.l.dUg));
      }
      GMTrace.o(2523024850944L, 18798);
      return true;
      label450:
      i = 0;
      j = 0;
    }
  }
  
  public final boolean a(MenuItem paramMenuItem, En_5b8fbb1e.a parama, au paramau)
  {
    GMTrace.i(2523159068672L, 18799);
    GMTrace.o(2523159068672L, 18799);
    return false;
  }
  
  public final boolean a(View paramView, En_5b8fbb1e.a parama, au paramau)
  {
    GMTrace.i(2523293286400L, 18800);
    GMTrace.o(2523293286400L, 18800);
    return false;
  }
  
  protected final boolean a(En_5b8fbb1e.a parama)
  {
    GMTrace.i(2522890633216L, 18797);
    boolean bool = parama.vvA;
    GMTrace.o(2522890633216L, 18797);
    return bool;
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/ui/chatting/br.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */