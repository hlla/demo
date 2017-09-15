package com.tencent.mm.ui.chatting;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.view.ContextMenu;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.gmtrace.GMTrace;
import com.tencent.mm.R.f;
import com.tencent.mm.R.g;
import com.tencent.mm.R.i;
import com.tencent.mm.R.k;
import com.tencent.mm.R.l;
import com.tencent.mm.bb.d;
import com.tencent.mm.e.a.se;
import com.tencent.mm.e.a.se.b;
import com.tencent.mm.e.b.ce;
import com.tencent.mm.platformtools.u;
import com.tencent.mm.pluginsdk.ui.d.h;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.sdk.platformtools.aa;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.storage.au;
import com.tencent.mm.t.f.a;
import com.tencent.mm.u.ay;
import com.tencent.mm.u.m;
import com.tencent.mm.ui.l;
import com.tencent.mm.ui.q;

final class av
  extends ag.b
{
  private En_5b8fbb1e.a vAn;
  
  public av()
  {
    super(53);
    GMTrace.i(2516716617728L, 18751);
    GMTrace.o(2516716617728L, 18751);
  }
  
  public final View a(LayoutInflater paramLayoutInflater, View paramView)
  {
    GMTrace.i(2516850835456L, 18752);
    Object localObject;
    if ((paramView != null) && (paramView.getTag() != null) && ((paramView.getTag() instanceof k)))
    {
      localObject = paramView;
      if (((ag.a)paramView.getTag()).type == this.klJ) {}
    }
    else
    {
      localObject = new bi(paramLayoutInflater, R.i.cXC);
      ((View)localObject).setTag(new k(this.klJ).di((View)localObject));
    }
    GMTrace.o(2516850835456L, 18752);
    return (View)localObject;
  }
  
  public final void a(ag.a parama, int paramInt, En_5b8fbb1e.a parama1, au paramau, String paramString)
  {
    GMTrace.i(2516985053184L, 18753);
    this.vAn = parama1;
    k localk = (k)parama;
    parama = paramau.field_content;
    if (parama != null) {}
    for (parama = f.a.B(parama, paramau.field_reserved);; parama = null)
    {
      int i;
      if (parama != null)
      {
        k.I(localk.vAj, localk.vwx);
        localk.vAj.setBackgroundResource(R.g.bdf);
        localk.vAj.setPadding(parama1.uRf.uRz.getResources().getDimensionPixelSize(R.f.aXy), 0, parama1.uRf.uRz.getResources().getDimensionPixelOffset(R.f.aYX), 0);
        localk.vwT.setSingleLine(true);
        paramString = new se();
        paramString.fZy.fSJ = parama.hil;
        a.uql.m(paramString);
        if (paramString.fZz.fZA) {
          break label380;
        }
        i = 1;
        if (paramString.fZz.status == -2) {
          i = 0;
        }
        int k = paramString.fZz.status;
        int j = k;
        if (k <= 0) {
          j = parama.hii;
        }
        switch (j)
        {
        case 2: 
        default: 
          localk.vwS.setImageResource(R.k.dve);
          localk.vwT.setSingleLine(false);
          localk.vwT.setMaxLines(2);
          localk.vwU.setText(null);
          localk.vwT.setText(parama.description);
        }
      }
      for (;;)
      {
        localk.vAj.setOnClickListener(parama1.vzN.vDb);
        localk.vAj.setOnLongClickListener(parama1.vzN.vDd);
        localk.vAj.setOnTouchListener(parama1.vzN.vDf);
        parama = new ds(paramau, parama1.vvA, paramInt, null, 0, (byte)0);
        localk.vAj.setTag(parama);
        GMTrace.o(2516985053184L, 18753);
        return;
        label380:
        i = 0;
        break;
        if (u.mA(parama.hjs)) {
          localk.vwT.setText(R.l.dTQ);
        }
        for (;;)
        {
          localk.vwU.setText(parama.hij);
          localk.vwS.setImageResource(R.k.dve);
          break;
          paramString = h.a(parama1.uRf.uRz, parama.hjs);
          localk.vwT.setText(paramString);
        }
        if (i != 0) {
          if (u.mA(parama.hjs))
          {
            paramString = aa.getContext().getString(R.l.dTH);
            label488:
            localk.vwT.setText(h.a(parama1.uRf.uRz, paramString));
          }
        }
        for (;;)
        {
          localk.vwU.setText(parama.hij);
          localk.vwS.setImageResource(R.k.dvf);
          localk.vAj.setBackgroundResource(R.g.bdg);
          break;
          paramString = aa.getContext().getString(R.l.dTH) + "-" + parama.hjs;
          break label488;
          localk.vwT.setText(R.l.dTI);
        }
        localk.vwU.setText(parama.hij);
        localk.vwS.setImageResource(R.k.dvg);
        if (i != 0) {
          if (u.mA(parama.hjs))
          {
            parama = aa.getContext().getString(R.l.dTS);
            label647:
            localk.vwT.setText(h.a(parama1.uRf.uRz, parama));
          }
        }
        for (;;)
        {
          localk.vAj.setBackgroundResource(R.g.bdg);
          break;
          parama = aa.getContext().getString(R.l.dTS) + "-" + parama.hjs;
          break label647;
          localk.vwT.setText(R.l.dTR);
        }
        localk.vwU.setText(parama.hij);
        localk.vwS.setImageResource(R.k.dvf);
        if (i != 0) {
          if (u.mA(parama.hjs))
          {
            parama = aa.getContext().getString(R.l.dTN);
            label781:
            localk.vwT.setText(h.a(parama1.uRf.uRz, parama));
          }
        }
        for (;;)
        {
          localk.vAj.setBackgroundResource(R.g.bdg);
          break;
          parama = aa.getContext().getString(R.l.dTN) + "-" + parama.hjs;
          break label781;
          localk.vwT.setText(R.l.dTO);
        }
        localk.vwT.setText(R.l.dTJ);
        localk.vwU.setText(parama.hij);
        localk.vwS.setImageResource(R.k.dvd);
        localk.vAj.setBackgroundResource(R.g.bdg);
      }
    }
  }
  
  public final boolean a(ContextMenu paramContextMenu, View paramView, au paramau)
  {
    GMTrace.i(2517119270912L, 18754);
    int i = ((ds)paramView.getTag()).position;
    if (paramau != null) {
      paramContextMenu.add(i, 100, 0, this.vAn.getString(R.l.dUh));
    }
    GMTrace.o(2517119270912L, 18754);
    return false;
  }
  
  public final boolean a(MenuItem paramMenuItem, En_5b8fbb1e.a parama, au paramau)
  {
    GMTrace.i(2517253488640L, 18755);
    switch (paramMenuItem.getItemId())
    {
    default: 
      GMTrace.o(2517253488640L, 18755);
      return false;
    }
    ay.L(paramau.field_msgId);
    GMTrace.o(2517253488640L, 18755);
    return true;
  }
  
  public final boolean a(View paramView, En_5b8fbb1e.a parama, au paramau)
  {
    GMTrace.i(2517387706368L, 18756);
    Object localObject = paramau.field_content;
    paramView = null;
    if (localObject != null) {
      paramView = f.a.B((String)localObject, paramau.field_reserved);
    }
    if (paramView != null)
    {
      localObject = new Intent();
      ((Intent)localObject).putExtra("sender_name", paramau.field_talker);
      switch (paramView.hii)
      {
      case 2: 
      default: 
        v.d("MicroMsg.ChattingItemAppMsgRemittanceFrom", "Unrecognized type, probably version to low & check update!");
        u.bq(parama.uRf.uRz);
      }
      for (;;)
      {
        GMTrace.o(2517387706368L, 18756);
        return true;
        ((Intent)localObject).putExtra("invalid_time", paramView.him);
        ((Intent)localObject).putExtra("is_sender", false);
        ((Intent)localObject).putExtra("appmsg_type", paramView.hii);
        ((Intent)localObject).putExtra("transfer_id", paramView.hil);
        ((Intent)localObject).putExtra("transaction_id", paramView.hik);
        ((Intent)localObject).putExtra("effective_date", paramView.hin);
        ((Intent)localObject).putExtra("total_fee", paramView.fTr);
        ((Intent)localObject).putExtra("fee_type", paramView.fEU);
        if (m.xY())
        {
          d.a(parama, "wallet_payu", ".remittance.ui.PayURemittanceDetailUI", (Intent)localObject, 221);
        }
        else
        {
          d.a(parama, "remittance", ".ui.RemittanceDetailUI", (Intent)localObject, 221);
          continue;
          ((Intent)localObject).putExtra("is_sender", true);
          ((Intent)localObject).putExtra("appmsg_type", paramView.hii);
          ((Intent)localObject).putExtra("transfer_id", paramView.hil);
          ((Intent)localObject).putExtra("transaction_id", paramView.hik);
          ((Intent)localObject).putExtra("effective_date", paramView.hin);
          ((Intent)localObject).putExtra("total_fee", paramView.fTr);
          ((Intent)localObject).putExtra("fee_type", paramView.fEU);
          if (m.xY()) {
            d.b(parama.uRf.uRz, "wallet_payu", ".remittance.ui.PayURemittanceDetailUI", (Intent)localObject);
          } else {
            d.b(parama.uRf.uRz, "remittance", ".ui.RemittanceDetailUI", (Intent)localObject);
          }
        }
      }
    }
    GMTrace.o(2517387706368L, 18756);
    return false;
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/ui/chatting/av.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */