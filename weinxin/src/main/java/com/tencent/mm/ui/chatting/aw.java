package com.tencent.mm.ui.chatting;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
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
import com.tencent.mm.sdk.platformtools.aa;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.storage.ar;
import com.tencent.mm.storage.au;
import com.tencent.mm.t.f.a;
import com.tencent.mm.u.ap;
import com.tencent.mm.u.ay;
import com.tencent.mm.u.c;
import com.tencent.mm.u.m;
import com.tencent.mm.ui.base.g;
import com.tencent.mm.ui.l;
import com.tencent.mm.ui.q;

final class aw
  extends ag.c
{
  private En_5b8fbb1e.a vAn;
  
  public aw()
  {
    super(54);
    GMTrace.i(2379143446528L, 17726);
    GMTrace.o(2379143446528L, 17726);
  }
  
  public final View a(LayoutInflater paramLayoutInflater, View paramView)
  {
    GMTrace.i(2379277664256L, 17727);
    Object localObject;
    if ((paramView != null) && (paramView.getTag() != null) && ((paramView.getTag() instanceof k)))
    {
      localObject = paramView;
      if (((ag.a)paramView.getTag()).type == this.klJ) {}
    }
    else
    {
      localObject = new bi(paramLayoutInflater, R.i.cYh);
      ((View)localObject).setTag(new k(this.klJ).di((View)localObject));
    }
    GMTrace.o(2379277664256L, 17727);
    return (View)localObject;
  }
  
  public final void a(ag.a parama, int paramInt, En_5b8fbb1e.a parama1, au paramau, String paramString)
  {
    GMTrace.i(2379411881984L, 17728);
    this.vAn = parama1;
    k localk = (k)parama;
    parama = paramau.field_content;
    if (parama != null) {}
    for (parama = f.a.B(parama, paramau.field_reserved);; parama = null)
    {
      boolean bool;
      if (parama != null)
      {
        k.I(localk.vAj, localk.vwx);
        localk.vAj.setBackgroundResource(R.g.bdh);
        localk.vAj.setPadding(parama1.uRf.uRz.getResources().getDimensionPixelSize(R.f.aXy), 0, com.tencent.mm.bg.a.fromDPToPix(parama1.uRf.uRz, 13), 0);
        localk.vwT.setSingleLine(true);
        paramString = new se();
        paramString.fZy.fSJ = parama.hil;
        com.tencent.mm.sdk.b.a.uql.m(paramString);
        bool = paramString.fZz.fZA;
        if (paramString.fZz.status == -2) {
          bool = false;
        }
        int j = paramString.fZz.status;
        int i = j;
        if (j <= 0) {
          i = parama.hii;
        }
        switch (i)
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
        parama = new ds(paramau, this.vAn.vvA, paramInt, null, 0, (byte)0);
        localk.vAj.setTag(parama);
        GMTrace.o(2379411881984L, 17728);
        return;
        ap.yY();
        paramString = c.wR().Ra(paramau.field_talker);
        if (paramString != null)
        {
          paramString = paramString.tL();
          label406:
          if (!u.mA(parama.hjs)) {
            break label501;
          }
          paramString = parama1.getString(R.l.dTP, new Object[] { u.mz(paramString) });
          localk.vwT.setText(h.b(parama1.uRf.uRz, paramString, localk.vwT.getTextSize()));
        }
        for (;;)
        {
          localk.vwU.setText(parama.hij);
          localk.vwS.setImageResource(R.k.dve);
          break;
          paramString = paramau.field_talker;
          break label406;
          label501:
          paramString = h.a(parama1.uRf.uRz, parama.hjs);
          localk.vwT.setText(paramString);
        }
        if (bool) {
          if (u.mA(parama.hjs))
          {
            paramString = aa.getContext().getString(R.l.dTH);
            label556:
            localk.vwT.setText(h.a(parama1.uRf.uRz, paramString));
          }
        }
        for (;;)
        {
          localk.vwU.setText(parama.hij);
          localk.vwS.setImageResource(R.k.dvf);
          localk.vAj.setBackgroundResource(R.g.bdi);
          break;
          paramString = aa.getContext().getString(R.l.dTH) + "-" + parama.hjs;
          break label556;
          localk.vwT.setText(R.l.dTI);
        }
        localk.vwU.setText(parama.hij);
        localk.vwS.setImageResource(R.k.dvg);
        if (bool) {
          if (u.mA(parama.hjs))
          {
            parama = aa.getContext().getString(R.l.dTS);
            label715:
            localk.vwT.setText(h.a(parama1.uRf.uRz, parama));
          }
        }
        for (;;)
        {
          localk.vAj.setBackgroundResource(R.g.bdi);
          break;
          parama = aa.getContext().getString(R.l.dTS) + "-" + parama.hjs;
          break label715;
          localk.vwT.setText(R.l.dTR);
        }
        if (bool) {
          if (u.mA(parama.hjs))
          {
            paramString = aa.getContext().getString(R.l.dTN);
            label827:
            localk.vwT.setText(h.a(parama1.uRf.uRz, paramString));
          }
        }
        for (;;)
        {
          localk.vwU.setText(parama.hij);
          localk.vwS.setImageResource(R.k.dvf);
          localk.vAj.setBackgroundResource(R.g.bdi);
          break;
          paramString = aa.getContext().getString(R.l.dTN) + "-" + parama.hjs;
          break label827;
          localk.vwT.setText(R.l.dTO);
        }
        localk.vwT.setText(R.l.dTJ);
        localk.vwU.setText(parama.hij);
        localk.vwS.setImageResource(R.k.dvd);
        localk.vAj.setBackgroundResource(R.g.bdi);
      }
    }
  }
  
  public final boolean a(ContextMenu paramContextMenu, View paramView, au paramau)
  {
    GMTrace.i(2379546099712L, 17729);
    int i = ((ds)paramView.getTag()).position;
    String str = paramau.field_content;
    paramView = null;
    if (str != null) {
      paramView = f.a.B(str, paramau.field_reserved);
    }
    if (paramView != null)
    {
      paramContextMenu.add(i, 100, 0, this.vAn.getString(R.l.dUh));
      if (paramView.hii == 1) {
        paramContextMenu.add(i, 103, 0, this.vAn.getString(R.l.eLl));
      }
    }
    GMTrace.o(2379546099712L, 17729);
    return false;
  }
  
  public final boolean a(final MenuItem paramMenuItem, final En_5b8fbb1e.a parama, final au paramau)
  {
    GMTrace.i(2379680317440L, 17730);
    switch (paramMenuItem.getItemId())
    {
    case 101: 
    case 102: 
    default: 
      GMTrace.o(2379680317440L, 17730);
      return false;
    case 100: 
      ay.L(paramau.field_msgId);
      GMTrace.o(2379680317440L, 17730);
      return true;
    }
    final String str = paramau.field_content;
    paramMenuItem = null;
    if (str != null) {
      paramMenuItem = f.a.B(str, paramau.field_reserved);
    }
    if (paramMenuItem != null)
    {
      str = paramMenuItem.hik;
      paramau = paramau.field_talker;
      final int i = paramMenuItem.him;
      final int j = paramMenuItem.fTr;
      paramMenuItem = paramMenuItem.fEU;
      g.b(parama.uRf.uRz, parama.getString(R.l.eKp), parama.getString(R.l.dIk), parama.getString(R.l.eLl), parama.getString(R.l.dGk), new DialogInterface.OnClickListener()new DialogInterface.OnClickListener
      {
        public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
        {
          GMTrace.i(2220229656576L, 16542);
          paramAnonymousDialogInterface = new Intent();
          paramAnonymousDialogInterface.putExtra("transaction_id", str);
          paramAnonymousDialogInterface.putExtra("receiver_name", paramau);
          paramAnonymousDialogInterface.putExtra("resend_msg_from_flag", 2);
          paramAnonymousDialogInterface.putExtra("invalid_time", i);
          paramAnonymousDialogInterface.putExtra("total_fee", j);
          paramAnonymousDialogInterface.putExtra("fee_type", paramMenuItem);
          if (m.xY())
          {
            d.b(parama.bOZ(), "wallet_payu", ".remittance.ui.PayURemittanceResendMsgUI", paramAnonymousDialogInterface);
            GMTrace.o(2220229656576L, 16542);
            return;
          }
          d.b(parama.bOZ(), "remittance", ".ui.RemittanceResendMsgUI", paramAnonymousDialogInterface);
          GMTrace.o(2220229656576L, 16542);
        }
      }, new DialogInterface.OnClickListener()
      {
        public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
        {
          GMTrace.i(2207881625600L, 16450);
          GMTrace.o(2207881625600L, 16450);
        }
      });
    }
    GMTrace.o(2379680317440L, 17730);
    return true;
  }
  
  public final boolean a(View paramView, En_5b8fbb1e.a parama, au paramau)
  {
    GMTrace.i(2379814535168L, 17731);
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
        v.d("MicroMsg.ChattingItemAppMsgRemittanceTo", "Unrecognized type, probably version to low & check update!");
        u.bq(parama.uRf.uRz);
      }
      for (;;)
      {
        GMTrace.o(2379814535168L, 17731);
        return true;
        ((Intent)localObject).putExtra("invalid_time", paramView.him);
        ((Intent)localObject).putExtra("is_sender", true);
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
    GMTrace.o(2379814535168L, 17731);
    return false;
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/ui/chatting/aw.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */