package com.tencent.mm.ui.chatting;

import android.content.Context;
import android.content.Intent;
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
import com.tencent.mm.ah.m;
import com.tencent.mm.ah.m.d;
import com.tencent.mm.ah.n;
import com.tencent.mm.e.a.dd;
import com.tencent.mm.e.a.dd.b;
import com.tencent.mm.e.b.ce;
import com.tencent.mm.pluginsdk.model.app.g;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.storage.au;
import com.tencent.mm.u.ap;
import com.tencent.mm.u.c;
import com.tencent.mm.ui.l;
import com.tencent.mm.ui.q;
import java.util.concurrent.ConcurrentHashMap;

final class bs
  extends ag.c
{
  private En_5b8fbb1e.a vAn;
  
  public bs()
  {
    super(3);
    GMTrace.i(2116882006016L, 15772);
    GMTrace.o(2116882006016L, 15772);
  }
  
  public static void a(ag.a parama, int paramInt1, int paramInt2)
  {
    GMTrace.i(2117687312384L, 15778);
    if (paramInt2 > 0) {
      if (paramInt1 >= paramInt2) {
        paramInt1 = 100;
      }
    }
    for (;;)
    {
      parama = (dr)parama;
      if ((paramInt1 < 100) || (parama.vKY.getVisibility() == 0)) {
        break;
      }
      GMTrace.o(2117687312384L, 15778);
      return;
      paramInt1 = (int)(paramInt1 * 100L / paramInt2);
      continue;
      paramInt1 = 0;
    }
    parama.vKY.setText(paramInt1 + "%");
    if (bUg()) {
      parama.oCh.setVisibility(8);
    }
    for (;;)
    {
      parama.vKY.setVisibility(0);
      parama.vLa.setVisibility(0);
      GMTrace.o(2117687312384L, 15778);
      return;
      parama.oCh.setVisibility(0);
    }
  }
  
  public final View a(LayoutInflater paramLayoutInflater, View paramView)
  {
    GMTrace.i(2117016223744L, 15773);
    Object localObject;
    if ((paramView != null) && (paramView.getTag() != null))
    {
      localObject = paramView;
      if (((ag.a)paramView.getTag()).type == this.klJ) {}
    }
    else
    {
      localObject = new bi(paramLayoutInflater, R.i.cYo);
      ((View)localObject).setTag(new dr(this.klJ).p((View)localObject, false));
    }
    GMTrace.o(2117016223744L, 15773);
    return (View)localObject;
  }
  
  public final void a(ag.a parama, int paramInt, En_5b8fbb1e.a parama1, au paramau, String paramString)
  {
    GMTrace.i(2117150441472L, 15774);
    this.vAn = parama1;
    paramString = (dr)parama;
    parama = m.GK();
    long l = paramau.field_msgId;
    boolean bool2 = parama.hGQ.containsKey(Long.valueOf(l));
    Object localObject1 = n.GT().n(paramau);
    int i;
    int j;
    boolean bool1;
    Object localObject2;
    Object localObject3;
    int k;
    if ((localObject1 != null) && (!bool2)) {
      if (m.GK().am(((com.tencent.mm.ah.d)localObject1).hEG))
      {
        parama = m.GK().an(((com.tencent.mm.ah.d)localObject1).hEG);
        i = (int)parama.hHe;
        j = (int)parama.hHf;
        if (i == 0)
        {
          bool1 = true;
          localObject2 = n.GT();
          localObject3 = paramString.vwI;
          String str = paramau.field_imgPath;
          float f = com.tencent.mm.bg.a.getDensity(parama1.uRf.uRz);
          i = paramau.gxw;
          j = paramau.gxx;
          k = R.g.bdI;
          ImageView localImageView = paramString.vKZ;
          int m = R.g.bdJ;
          if (!bool1) {
            break label604;
          }
          parama = null;
          label182:
          if ((!((f)localObject2).a((ImageView)localObject3, str, f, i, j, k, localImageView, m, 0, parama)) && (!this.sWq)) {
            paramString.vwI.setImageDrawable(com.tencent.mm.bg.a.a(parama1.uRf.uRz, R.g.bhQ));
          }
          if ((localObject1 == null) && (!bool2)) {
            break label854;
          }
          if ((!bool1) && (paramau.field_status != 5)) {
            break label613;
          }
          k = 1;
          label263:
          if (!bool2) {
            break label619;
          }
          paramString.vKY.setText("0%");
          parama = paramString.oCh;
          if (k == 0) {
            break label836;
          }
          i = 8;
          label293:
          parama.setVisibility(i);
          parama = paramString.vKY;
          if (k == 0) {
            break label842;
          }
          i = 8;
          label314:
          parama.setVisibility(i);
          parama = paramString.vLa;
          if (k == 0) {
            break label848;
          }
          i = 8;
          label335:
          parama.setVisibility(i);
          label341:
          paramString.vAj.setTag(new ds(paramau, parama1.vvA, paramInt, paramau.field_talker, 0, (byte)0));
          paramString.vAj.setOnClickListener(parama1.vzN.vDb);
          paramString.vAj.setOnTouchListener(parama1.vzN.vDf);
          paramString.vAj.setOnLongClickListener(parama1.vzN.vDd);
          paramString.vwI.setContentDescription(parama1.getString(R.l.dTG));
          if (bUg())
          {
            paramString.oCh.setVisibility(8);
            v.d("MicroMsg.ContactInfoUI", "[oneliang]%s,%s", new Object[] { Long.valueOf(paramau.field_msgId), Integer.valueOf(paramau.field_status) });
            if (bUg())
            {
              if ((paramau.field_status != 2) || (!a(parama1.vzN, paramau.field_msgId))) {
                break label887;
              }
              if (paramString.vwJ != null) {
                paramString.vwJ.setVisibility(0);
              }
            }
          }
        }
      }
    }
    for (;;)
    {
      a(paramInt, paramString, paramau, parama1.vzN.hrv, parama1.vvA, parama1.vzN.vDb);
      GMTrace.o(2117150441472L, 15774);
      return;
      if ((j == i) && (i != 0))
      {
        bool1 = true;
        break;
      }
      bool1 = false;
      break;
      bool1 = com.tencent.mm.ah.e.b((com.tencent.mm.ah.d)localObject1);
      break;
      bool1 = false;
      break;
      label604:
      parama = paramString.vLa;
      break label182;
      label613:
      k = 0;
      break label263;
      label619:
      parama = paramString.vKY;
      localObject2 = new StringBuilder();
      if (localObject1 != null)
      {
        j = ((com.tencent.mm.ah.d)localObject1).hrb;
        i = ((com.tencent.mm.ah.d)localObject1).offset;
        if (m.GK().am(((com.tencent.mm.ah.d)localObject1).hEG))
        {
          localObject3 = m.GK().an(((com.tencent.mm.ah.d)localObject1).hEG);
          j = (int)((m.d)localObject3).hHe;
          i = (int)((m.d)localObject3).hHf;
        }
        if (((com.tencent.mm.ah.d)localObject1).GC())
        {
          localObject3 = n.GT().fT(((com.tencent.mm.ah.d)localObject1).hEQ);
          if (m.GK().am(((com.tencent.mm.ah.d)localObject1).hEQ))
          {
            localObject1 = m.GK().an(((com.tencent.mm.ah.d)localObject1).hEQ);
            j = (int)((m.d)localObject1).hHe;
            i = (int)((m.d)localObject1).hHf;
          }
        }
        else
        {
          label762:
          if (j <= 0) {
            break label830;
          }
          if (i < j) {
            break label817;
          }
          i = 100;
        }
      }
      for (;;)
      {
        parama.setText(i + "%");
        break;
        j = ((com.tencent.mm.ah.d)localObject3).hrb;
        i = ((com.tencent.mm.ah.d)localObject3).offset;
        break label762;
        label817:
        i = i * 100 / j;
        continue;
        label830:
        i = 0;
      }
      label836:
      i = 0;
      break label293;
      label842:
      i = 0;
      break label314;
      label848:
      i = 0;
      break label335;
      label854:
      paramString.vLa.setVisibility(8);
      paramString.oCh.setVisibility(8);
      paramString.vKY.setVisibility(8);
      break label341;
      label887:
      if (paramString.vwJ != null) {
        paramString.vwJ.setVisibility(8);
      }
    }
  }
  
  public final boolean a(ContextMenu paramContextMenu, View paramView, au paramau)
  {
    GMTrace.i(2117284659200L, 15775);
    ap.yY();
    int k;
    Object localObject2;
    Object localObject1;
    int j;
    int i;
    if (c.isSDCardAvailable())
    {
      k = ((ds)paramView.getTag()).position;
      localObject2 = null;
      if (paramau.field_msgId > 0L) {
        localObject2 = n.GT().aj(paramau.field_msgId);
      }
      if (localObject2 != null)
      {
        localObject1 = localObject2;
        if (((com.tencent.mm.ah.d)localObject2).hEG > 0L) {}
      }
      else
      {
        localObject1 = localObject2;
        if (paramau.field_msgSvrId > 0L) {
          localObject1 = n.GT().ai(paramau.field_msgSvrId);
        }
      }
      localObject2 = localObject1;
      if (((com.tencent.mm.ah.d)localObject1).GC())
      {
        localObject2 = localObject1;
        if (((com.tencent.mm.ah.d)localObject1).hrb == 0) {
          localObject2 = n.GT().fT(((com.tencent.mm.ah.d)localObject1).hEQ);
        }
      }
      paramContextMenu.add(k, 110, 0, paramView.getContext().getString(R.l.eLz));
      if (paramau.field_status == 5) {
        paramContextMenu.add(k, 103, 0, paramView.getContext().getString(R.l.dVe));
      }
      if ((com.tencent.mm.modelbiz.e.Dp()) && (!this.vAn.bVz())) {
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
        localObject1 = paramContextMenu.add(k, 130, 0, paramView.getContext().getString(R.l.dTF));
        localObject2 = new int[2];
        if (paramView == null) {
          break label580;
        }
        j = paramView.getWidth();
        i = paramView.getHeight();
        paramView.getLocationInWindow((int[])localObject2);
      }
    }
    for (;;)
    {
      Intent localIntent = new Intent();
      localIntent.putExtra("img_gallery_width", j).putExtra("img_gallery_height", i).putExtra("img_gallery_left", localObject2[0]).putExtra("img_gallery_top", localObject2[1]);
      ((MenuItem)localObject1).setIntent(localIntent);
      if ((!paramau.bLN()) && (paramau.bLX()) && ((paramau.field_status == 2) || (paramau.gxz == 1)) && (ao(paramau)) && (Tm(paramau.field_talker))) {
        paramContextMenu.add(k, 123, 0, paramView.getContext().getString(R.l.dUp));
      }
      if (!this.vAn.bVz()) {
        paramContextMenu.add(k, 100, 0, paramView.getContext().getString(R.l.dUg));
      }
      GMTrace.o(2117284659200L, 15775);
      return true;
      label580:
      i = 0;
      j = 0;
    }
  }
  
  public final boolean a(MenuItem paramMenuItem, En_5b8fbb1e.a parama, au paramau)
  {
    GMTrace.i(2117418876928L, 15776);
    GMTrace.o(2117418876928L, 15776);
    return false;
  }
  
  public final boolean a(View paramView, En_5b8fbb1e.a parama, au paramau)
  {
    GMTrace.i(2117553094656L, 15777);
    GMTrace.o(2117553094656L, 15777);
    return false;
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/ui/chatting/bs.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */