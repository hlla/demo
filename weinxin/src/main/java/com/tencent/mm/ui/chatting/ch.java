package com.tencent.mm.ui.chatting;

import android.content.Intent;
import android.view.ContextMenu;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.gmtrace.GMTrace;
import com.tencent.mm.R.g;
import com.tencent.mm.R.i;
import com.tencent.mm.R.l;
import com.tencent.mm.e.b.ce;
import com.tencent.mm.platformtools.u;
import com.tencent.mm.plugin.subapp.c.h;
import com.tencent.mm.pluginsdk.j.o;
import com.tencent.mm.pluginsdk.model.app.ab;
import com.tencent.mm.pluginsdk.model.app.an;
import com.tencent.mm.pluginsdk.model.app.b;
import com.tencent.mm.sdk.platformtools.j;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.storage.au;
import com.tencent.mm.t.f.a;
import com.tencent.mm.u.ap;
import com.tencent.mm.u.ay;
import com.tencent.mm.u.m;
import com.tencent.mm.ui.q;
import com.tencent.mm.ui.transmit.MsgRetransmitUI;
import com.tencent.mm.y.n;

final class ch
  extends ag.b
{
  public com.tencent.mm.y.e hTN;
  public En_5b8fbb1e.a vAn;
  
  public ch()
  {
    super(35);
    GMTrace.i(2220363874304L, 16543);
    GMTrace.o(2220363874304L, 16543);
  }
  
  public final View a(LayoutInflater paramLayoutInflater, View paramView)
  {
    GMTrace.i(2220498092032L, 16544);
    Object localObject;
    if ((paramView != null) && (paramView.getTag() != null) && ((paramView.getTag() instanceof ec)))
    {
      localObject = paramView;
      if (((ag.a)paramView.getTag()).type == this.klJ) {}
    }
    else
    {
      localObject = new bi(paramLayoutInflater, R.i.cYv);
      ((View)localObject).setTag(new ec(this.klJ).dt((View)localObject));
    }
    GMTrace.o(2220498092032L, 16544);
    return (View)localObject;
  }
  
  protected final String a(En_5b8fbb1e.a parama, au paramau)
  {
    GMTrace.i(2220632309760L, 16545);
    parama = parama.vzN.fJC;
    GMTrace.o(2220632309760L, 16545);
    return parama;
  }
  
  public final void a(ag.a parama, final int paramInt, En_5b8fbb1e.a parama1, final au paramau, String paramString)
  {
    GMTrace.i(2220900745216L, 16547);
    localec = (ec)parama;
    this.vAn = parama1;
    Object localObject2 = an.bDc().ec(paramau.field_msgId);
    Object localObject1 = paramau.field_content;
    parama = null;
    paramString = parama;
    if (localObject2 != null)
    {
      paramString = parama;
      if (localObject1 != null) {
        paramString = f.a.B((String)localObject1, paramau.field_reserved);
      }
    }
    localObject2 = com.tencent.mm.plugin.subapp.c.e.Hi((String)localObject1);
    if ((localObject2 != null) && (((com.tencent.mm.plugin.subapp.c.e)localObject2).qRC != 0)) {}
    try
    {
      localObject3 = o.M(parama1.uRf.uRz, ((com.tencent.mm.plugin.subapp.c.e)localObject2).qRC);
      localObject1 = "";
      parama = (ag.a)localObject1;
      if (localObject3 != null)
      {
        parama = (ag.a)localObject1;
        if (((String)localObject3).length() > 0)
        {
          localObject3 = ((String)localObject3).split(";");
          localObject1 = "" + localObject3[0].replace(" ", "");
          parama = (ag.a)localObject1;
          if (localObject3.length > 1) {
            parama = (String)localObject1 + localObject3[1];
          }
        }
      }
      localObject1 = parama;
      if (paramString != null)
      {
        localObject1 = parama;
        if (paramString.description != null) {
          localObject1 = parama + " " + paramString.description;
        }
      }
      localec.ipd.setText((CharSequence)localObject1);
    }
    catch (Exception parama)
    {
      for (;;)
      {
        Object localObject3;
        long l;
        v.printErrStackTrace("MicroMsg.ChattingItemVoiceRemindRemind", parama, "", new Object[0]);
        continue;
        int i = 0;
        continue;
        localec.vMf.setImageResource(R.g.bhn);
      }
    }
    v.d("MicroMsg.ChattingItemVoiceRemindRemind", "content remind " + paramau.field_content);
    if ((u.mA(paramau.field_imgPath)) && (((com.tencent.mm.plugin.subapp.c.e)localObject2).qRI > 0))
    {
      ap.yY();
      parama = com.tencent.mm.u.c.wT().x(paramau.field_talker, ((com.tencent.mm.plugin.subapp.c.e)localObject2).qRI);
      if (!u.mA(parama.field_imgPath))
      {
        localObject1 = com.tencent.mm.plugin.subapp.c.k.lv(m.xL());
        localObject3 = h.at((String)localObject1, false);
        if (j.p(h.at(parama.field_imgPath, false), (String)localObject3, false))
        {
          paramau.cI((String)localObject1);
          ap.yY();
          com.tencent.mm.u.c.wT().a(paramau.field_msgId, paramau);
        }
      }
    }
    if ((u.mA(paramau.field_imgPath)) && (localObject2 != null) && (((com.tencent.mm.plugin.subapp.c.e)localObject2).fCN != null) && (((com.tencent.mm.plugin.subapp.c.e)localObject2).fCN.length() > 0) && (((com.tencent.mm.plugin.subapp.c.e)localObject2).hhg > 0) && (this.hTN == null))
    {
      parama = com.tencent.mm.plugin.subapp.c.k.lv(m.xL());
      localObject1 = h.at(parama, false);
      if (u.mA(paramau.field_imgPath))
      {
        paramau.cI(parama);
        ap.yY();
        com.tencent.mm.u.c.wT().a(paramau.field_msgId, paramau);
        v.d("MicroMsg.ChattingItemVoiceRemindRemind", "content.attachid " + paramString.fCN);
        parama = com.tencent.mm.pluginsdk.model.app.l.a((String)localObject1, paramau.field_msgId, paramString.sdkVer, paramString.appId, paramString.fCN, paramString.hhg);
        v.d("MicroMsg.ChattingItemVoiceRemindRemind", "ainfo.field_mediaSvrId " + parama.field_mediaSvrId);
        if (parama.field_mediaSvrId != null)
        {
          paramString = ap.vd();
          localObject1 = new com.tencent.mm.y.e()
          {
            public final void a(int paramAnonymousInt1, int paramAnonymousInt2, String paramAnonymousString, com.tencent.mm.y.k paramAnonymousk)
            {
              GMTrace.i(2111513296896L, 15732);
              v.d("MicroMsg.ChattingItemVoiceRemindRemind", "errType " + paramAnonymousInt1 + " errCode " + paramAnonymousInt2 + "  scene " + paramAnonymousk.getType());
              ap.vd().b(221, ch.this.hTN);
              ch.this.hTN = null;
              GMTrace.o(2111513296896L, 15732);
            }
          };
          this.hTN = ((com.tencent.mm.y.e)localObject1);
          paramString.a(221, (com.tencent.mm.y.e)localObject1);
          v.d("MicroMsg.ChattingItemVoiceRemindRemind", "doscene");
          parama = new ab(parama);
          ap.vd().a(parama, 0);
        }
      }
    }
    localec.vMf.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        GMTrace.i(2368271810560L, 17645);
        if (u.mA(paramau.field_imgPath))
        {
          v.d("MicroMsg.ChattingItemVoiceRemindRemind", "filename is null");
          GMTrace.o(2368271810560L, 17645);
          return;
        }
        ch.this.vAn.vzN.vCX.d(paramInt, paramau);
        GMTrace.o(2368271810560L, 17645);
      }
    });
    l = paramau.field_msgId;
    if ((this.vAn.vzN.vCX.isPlaying()) && (this.vAn.vzN.vCX.vxN == l))
    {
      i = 1;
      if (i == 0) {
        break label821;
      }
      localec.vMf.setImageResource(R.g.bhm);
      localec.vAj.setTag(new ds(paramau, parama1.vvA, paramInt, null, 0, (byte)0));
      localec.vAj.setOnClickListener(parama1.vzN.vDb);
      ap.yY();
      if (com.tencent.mm.u.c.isSDCardAvailable()) {
        localec.vAj.setOnLongClickListener(parama1.vzN.vDd);
      }
      GMTrace.o(2220900745216L, 16547);
    }
  }
  
  public final boolean a(ContextMenu paramContextMenu, View paramView, au paramau)
  {
    GMTrace.i(2221034962944L, 16548);
    int i = ((ds)paramView.getTag()).position;
    int j = com.tencent.mm.pluginsdk.model.app.l.Mf(this.vAn.cQ(paramau.field_content, paramau.field_isSend));
    paramView = f.a.ek(this.vAn.cQ(paramau.field_content, paramau.field_isSend));
    if ((paramView.hhg <= 0) || ((paramView.hhg > 0) && (j >= 100))) {
      paramContextMenu.add(i, 111, 0, this.vAn.getString(R.l.eLz));
    }
    if (!this.vAn.bVz()) {
      paramContextMenu.add(i, 100, 0, this.vAn.getString(R.l.dUh));
    }
    GMTrace.o(2221034962944L, 16548);
    return true;
  }
  
  public final boolean a(MenuItem paramMenuItem, En_5b8fbb1e.a parama, au paramau)
  {
    GMTrace.i(2221169180672L, 16549);
    switch (paramMenuItem.getItemId())
    {
    default: 
      GMTrace.o(2221169180672L, 16549);
      return false;
    case 100: 
      parama = paramau.field_content;
      paramMenuItem = null;
      if (parama != null) {
        paramMenuItem = f.a.ek(parama);
      }
      if (paramMenuItem != null) {
        com.tencent.mm.pluginsdk.model.app.l.ed(paramau.field_msgId);
      }
      ay.L(paramau.field_msgId);
      GMTrace.o(2221169180672L, 16549);
      return false;
    }
    paramMenuItem = new Intent(parama.uRf.uRz, MsgRetransmitUI.class);
    paramMenuItem.putExtra("Retr_Msg_content", parama.cQ(paramau.field_content, paramau.field_isSend));
    paramMenuItem.putExtra("Retr_Msg_Type", 2);
    paramMenuItem.putExtra("Retr_Msg_Id", paramau.field_msgId);
    parama.startActivity(paramMenuItem);
    GMTrace.o(2221169180672L, 16549);
    return false;
  }
  
  public final boolean a(View paramView, En_5b8fbb1e.a parama, au paramau)
  {
    GMTrace.i(2221303398400L, 16550);
    GMTrace.o(2221303398400L, 16550);
    return true;
  }
  
  protected final boolean a(En_5b8fbb1e.a parama)
  {
    GMTrace.i(2220766527488L, 16546);
    GMTrace.o(2220766527488L, 16546);
    return false;
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/ui/chatting/ch.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */