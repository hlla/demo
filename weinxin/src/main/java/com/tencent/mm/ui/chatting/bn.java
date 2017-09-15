package com.tencent.mm.ui.chatting;

import android.view.ContextMenu;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.gmtrace.GMTrace;
import com.tencent.mm.R.g;
import com.tencent.mm.R.i;
import com.tencent.mm.R.l;
import com.tencent.mm.e.b.ce;
import com.tencent.mm.modelfriend.af;
import com.tencent.mm.modelfriend.m;
import com.tencent.mm.platformtools.u;
import com.tencent.mm.pluginsdk.ui.d.h;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.storage.au;
import com.tencent.mm.storage.au.a;
import com.tencent.mm.storage.au.d;
import com.tencent.mm.u.ap;
import com.tencent.mm.u.o;
import com.tencent.mm.ui.l;
import com.tencent.mm.ui.q;

final class bn
  extends ag.b
{
  public bn()
  {
    super(9);
    GMTrace.i(2261971369984L, 16853);
    GMTrace.o(2261971369984L, 16853);
  }
  
  public final View a(LayoutInflater paramLayoutInflater, View paramView)
  {
    GMTrace.i(2262105587712L, 16854);
    Object localObject;
    if ((paramView != null) && (paramView.getTag() != null))
    {
      localObject = paramView;
      if (((ag.a)paramView.getTag()).type == this.klJ) {}
    }
    else
    {
      localObject = new bi(paramLayoutInflater, R.i.cXI);
      ((View)localObject).setTag(new dp(this.klJ).ds((View)localObject));
    }
    GMTrace.o(2262105587712L, 16854);
    return (View)localObject;
  }
  
  public final void a(ag.a parama, int paramInt, En_5b8fbb1e.a parama1, au paramau, String paramString)
  {
    GMTrace.i(2262374023168L, 16856);
    dp localdp = (dp)parama;
    if (paramau.field_type == 37)
    {
      ap.yY();
      parama = com.tencent.mm.u.c.wT().As(paramau.field_content);
      if ((parama == null) || (parama.rTh == null) || (parama.rTh.length() <= 0))
      {
        v.e("MicroMsg.ChattingItemFMessageFrom", "getView : parse verify msg failed");
        GMTrace.o(2262374023168L, 16856);
        return;
      }
      com.tencent.mm.x.b.u(parama.rTh, parama.uIh);
      if (o.eU(parama.rTh))
      {
        localdp.vKS.setVisibility(8);
        localdp.vKT.setVisibility(8);
        localdp.vKU.setVisibility(0);
        localdp.vKR.setBackgroundColor(16777215);
        localdp.vKU.setText(parama1.getString(R.l.emJ));
        switch (parama.scene)
        {
        case 14: 
        case 15: 
        case 16: 
        case 17: 
        case 19: 
        case 20: 
        case 21: 
        default: 
          label248:
          localdp.vyr.setText(R.l.dTv);
          label259:
          localdp.pjl.setText(h.b(parama1.uRf.uRz, parama.getDisplayName(), localdp.pjl.getTextSize()));
          o(localdp.ipb, parama.rTh);
          localdp.stp.setVisibility(0);
          if ((parama.content != null) && (!parama.content.trim().equals(""))) {
            localdp.stp.setText(parama.content);
          }
          break;
        }
      }
    }
    for (;;)
    {
      localdp.vAj.setTag(new ds(paramau, parama1.vvA, paramInt, null, 0, (byte)0));
      localdp.vAj.setOnClickListener(parama1.vzN.vDb);
      localdp.vAj.setOnLongClickListener(parama1.vzN.vDd);
      localdp.vAj.setOnTouchListener(parama1.vzN.vDf);
      GMTrace.o(2262374023168L, 16856);
      return;
      localdp.vKS.setVisibility(0);
      localdp.vKT.setVisibility(0);
      localdp.vKU.setVisibility(0);
      localdp.vKR.setBackgroundResource(R.g.biO);
      localdp.vKU.setText(parama1.getString(R.l.emI));
      break;
      localdp.vyr.setText(R.l.dTz);
      break label259;
      localdp.vyr.setText(R.l.dTB);
      break label259;
      localdp.vyr.setText(R.l.eHm);
      break label259;
      localdp.vyr.setText(R.l.dTu);
      break label259;
      paramString = af.FZ().ja(parama.rTh);
      if ((paramString.ES() != null) && (!paramString.ES().equals("")))
      {
        localdp.vKV.setVisibility(0);
        localdp.vKV.setText(parama1.getString(R.l.dTp, new Object[] { paramString.ES() }));
        break label248;
      }
      localdp.vKV.setVisibility(8);
      break label248;
      localdp.stp.setText(parama1.getString(R.l.dTA));
      continue;
      if (paramau.field_type == 40)
      {
        ap.yY();
        au.a locala = com.tencent.mm.u.c.wT().At(paramau.field_content);
        if ((locala == null) || (locala.rTh == null) || (locala.rTh.length() <= 0))
        {
          v.e("MicroMsg.ChattingItemFMessageFrom", "getView : parse possible friend msg failed");
          GMTrace.o(2262374023168L, 16856);
          return;
        }
        com.tencent.mm.x.b.u(locala.rTh, locala.uIh);
        if (o.eU(locala.rTh))
        {
          localdp.vKS.setVisibility(8);
          localdp.vKT.setVisibility(8);
          localdp.vKU.setVisibility(0);
          localdp.vKR.setBackgroundColor(16777215);
          localdp.vKU.setText(parama1.getString(R.l.emJ));
          label789:
          switch (locala.scene)
          {
          default: 
            v.d("MicroMsg.ChattingItemFMessageFrom", "prossible friend sceneType:%d", new Object[] { Integer.valueOf(locala.scene) });
            localdp.vyr.setText(R.l.dTq);
            localdp.stp.setText(R.l.dTr);
            localdp.pjl.setText(h.b(parama1.uRf.uRz, locala.getDisplayName(), localdp.pjl.getTextSize()));
          }
        }
        for (;;)
        {
          o(localdp.ipb, locala.rTh);
          break;
          localdp.vKS.setVisibility(0);
          localdp.vKT.setVisibility(0);
          localdp.vKU.setVisibility(0);
          localdp.vKR.setBackgroundResource(R.g.biO);
          localdp.vKU.setText(parama1.getString(R.l.emI));
          break label789;
          localdp.vyr.setText(R.l.dTl);
          localdp.stp.setText(R.l.dTm);
          paramString = locala.bMx();
          parama = paramString;
          if (paramString == null) {
            parama = locala.getDisplayName();
          }
          localdp.pjl.setText(h.b(parama1.uRf.uRz, parama, localdp.pjl.getTextSize()));
          continue;
          localdp.vyr.setText(R.l.dTo);
          paramString = m.ji(locala.uIi);
          parama = paramString;
          if (u.mA(paramString)) {
            parama = m.ji(locala.uIj);
          }
          localdp.stp.setText(parama1.getString(R.l.dTp, new Object[] { parama }));
          localdp.pjl.setText(h.b(parama1.uRf.uRz, locala.getDisplayName(), localdp.pjl.getTextSize()));
          continue;
          localdp.vyr.setText(R.l.dTx);
          localdp.stp.setText(R.l.dTy);
          localdp.pjl.setText(h.b(parama1.uRf.uRz, locala.getDisplayName(), localdp.pjl.getTextSize()));
          continue;
          localdp.vyr.setText(R.l.dTt);
          localdp.stp.setText(R.l.dTs);
          localdp.pjl.setText(h.b(parama1.uRf.uRz, locala.getDisplayName(), localdp.pjl.getTextSize()));
        }
      }
      v.w("MicroMsg.ChattingItemFMessageFrom", "FROM_FMESSAGE did not include this type, msgType = " + paramau.field_type);
    }
  }
  
  public final boolean a(ContextMenu paramContextMenu, View paramView, au paramau)
  {
    GMTrace.i(2262508240896L, 16857);
    GMTrace.o(2262508240896L, 16857);
    return false;
  }
  
  public final boolean a(MenuItem paramMenuItem, En_5b8fbb1e.a parama, au paramau)
  {
    GMTrace.i(2262642458624L, 16858);
    GMTrace.o(2262642458624L, 16858);
    return false;
  }
  
  public final boolean a(View paramView, En_5b8fbb1e.a parama, au paramau)
  {
    GMTrace.i(2262776676352L, 16859);
    GMTrace.o(2262776676352L, 16859);
    return false;
  }
  
  protected final boolean bUf()
  {
    GMTrace.i(2262239805440L, 16855);
    GMTrace.o(2262239805440L, 16855);
    return false;
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/ui/chatting/bn.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */