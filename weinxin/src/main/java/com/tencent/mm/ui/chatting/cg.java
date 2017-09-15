package com.tencent.mm.ui.chatting;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.content.res.Resources;
import android.view.ContextMenu;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import com.tencent.gmtrace.GMTrace;
import com.tencent.mm.R.e;
import com.tencent.mm.R.g;
import com.tencent.mm.R.i;
import com.tencent.mm.R.l;
import com.tencent.mm.e.b.ce;
import com.tencent.mm.platformtools.u;
import com.tencent.mm.plugin.subapp.c.a;
import com.tencent.mm.plugin.subapp.c.h;
import com.tencent.mm.pluginsdk.j.o;
import com.tencent.mm.pluginsdk.model.app.ab;
import com.tencent.mm.pluginsdk.model.app.an;
import com.tencent.mm.pluginsdk.model.app.b;
import com.tencent.mm.protocal.c.bjm;
import com.tencent.mm.sdk.platformtools.j;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.storage.au;
import com.tencent.mm.t.f.a;
import com.tencent.mm.u.ag.f;
import com.tencent.mm.u.ap;
import com.tencent.mm.u.ay;
import com.tencent.mm.u.m;
import com.tencent.mm.ui.base.g;
import com.tencent.mm.ui.q;
import com.tencent.mm.ui.transmit.MsgRetransmitUI;
import com.tencent.mm.y.n;
import java.util.LinkedList;

final class cg
  extends ag
{
  public com.tencent.mm.y.e hTN;
  public ProgressDialog phY;
  public En_5b8fbb1e.a vAn;
  
  public cg()
  {
    super(34);
    GMTrace.i(2371090382848L, 17666);
    GMTrace.o(2371090382848L, 17666);
  }
  
  public final View a(LayoutInflater paramLayoutInflater, View paramView)
  {
    GMTrace.i(2371224600576L, 17667);
    Object localObject;
    if ((paramView != null) && (paramView.getTag() != null) && ((paramView.getTag() instanceof dh)))
    {
      localObject = paramView;
      if (((ag.a)paramView.getTag()).type == this.klJ) {}
    }
    else
    {
      localObject = new bi(paramLayoutInflater, R.i.cYu);
      ((View)localObject).setTag(new dh(this.klJ).dr((View)localObject));
    }
    GMTrace.o(2371224600576L, 17667);
    return (View)localObject;
  }
  
  public final void a(final ag.a parama, final int paramInt, final En_5b8fbb1e.a parama1, final au paramau, String paramString)
  {
    GMTrace.i(2371493036032L, 17669);
    paramString = (dh)parama;
    this.vAn = parama1;
    Object localObject2 = an.bDc().ec(paramau.field_msgId);
    final Object localObject1 = paramau.field_content;
    parama1 = null;
    parama = parama1;
    if (localObject2 != null)
    {
      parama = parama1;
      if (localObject1 != null) {
        parama = f.a.ek((String)localObject1);
      }
    }
    boolean bool2 = false;
    parama1 = com.tencent.mm.plugin.subapp.c.e.Hi((String)localObject1);
    boolean bool1 = bool2;
    if (parama1 != null)
    {
      bool1 = bool2;
      if (parama1.qRC == 0) {}
    }
    for (;;)
    {
      try
      {
        localObject1 = o.M(this.vAn.uRf.uRz, parama1.qRC);
        if ((parama != null) && (parama.description != null))
        {
          i = parama.description.indexOf('|');
          if ((i <= 0) || (parama.description.length() <= i + 1)) {
            continue;
          }
          localObject2 = parama.description.substring(i + 1);
          paramString.ipd.setText((CharSequence)localObject2);
        }
        if ((localObject1 != null) && (((String)localObject1).length() > 0))
        {
          localObject1 = ((String)localObject1).split(";");
          paramString.vFY.setText(localObject1[0]);
          if (localObject1.length > 1) {
            paramString.vFZ.setText(localObject1[1]);
          }
        }
      }
      catch (Exception localException)
      {
        long l;
        Object localObject3;
        int j;
        int k;
        String str;
        v.printErrStackTrace("MicroMsg.ChattingItemVoiceRemindConfirm", localException, "", new Object[0]);
        continue;
        paramString.vGc.setVisibility(8);
        paramString.ipd.setTextColor(this.vAn.getResources().getColor(R.e.aWc));
        paramString.vFZ.setTextColor(this.vAn.getResources().getColor(R.e.aWc));
        paramString.vFY.setTextColor(this.vAn.getResources().getColor(R.e.aWc));
        continue;
        int i = 0;
        continue;
        paramString.vGa.setBackgroundResource(R.g.bla);
        continue;
      }
      bool1 = u.hb(parama1.qRC);
      if (!bool1) {
        continue;
      }
      paramString.vGc.setVisibility(0);
      paramString.ipd.setTextColor(this.vAn.getResources().getColor(R.e.aWd));
      paramString.vFZ.setTextColor(this.vAn.getResources().getColor(R.e.aWd));
      paramString.vFY.setTextColor(this.vAn.getResources().getColor(R.e.aWd));
      paramString.vGa.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          GMTrace.i(2271500828672L, 16924);
          if (u.mA(paramau.field_imgPath))
          {
            v.d("MicroMsg.ChattingItemVoiceRemindConfirm", "filename is null");
            GMTrace.o(2271500828672L, 16924);
            return;
          }
          cg.this.vAn.vzN.vCX.c(paramInt, paramau);
          GMTrace.o(2271500828672L, 16924);
        }
      });
      l = paramau.field_msgId;
      if ((this.vAn.vzN.vCX == null) || (!this.vAn.vzN.vCX.isPlaying()) || (this.vAn.vzN.vCX.vxN != l)) {
        continue;
      }
      i = 1;
      if (i == 0) {
        continue;
      }
      paramString.vGa.setBackgroundResource(R.g.bkZ);
      if ((parama1 != null) && (!u.mA(parama1.qRE)) && (parama1.qRF > 0) && (u.mA(paramau.field_reserved)))
      {
        localObject2 = com.tencent.mm.plugin.subapp.c.k.lv(m.xL());
        localObject1 = h.at((String)localObject2, false);
        paramau.cJ((String)localObject2);
        ap.yY();
        com.tencent.mm.u.c.wT().a(paramau.field_msgId, paramau);
        l = paramau.field_msgId;
        i = parama.sdkVer;
        localObject2 = parama.appId;
        localObject3 = parama1.qRE;
        j = parama1.qRF;
        k = parama.type;
        str = parama.hhu;
        localObject1 = com.tencent.mm.pluginsdk.model.app.l.a((String)localObject1, l, i, (String)localObject2, (String)localObject3, j, k, parama.hhk);
        if (localObject1 != null)
        {
          localObject2 = ap.vd();
          localObject3 = new com.tencent.mm.y.e()
          {
            public final void a(int paramAnonymousInt1, int paramAnonymousInt2, String paramAnonymousString, com.tencent.mm.y.k paramAnonymousk)
            {
              GMTrace.i(2246670548992L, 16739);
              v.d("MicroMsg.ChattingItemVoiceRemindConfirm", "errType " + paramAnonymousInt1 + " errCode " + paramAnonymousInt2 + "  scene " + paramAnonymousk.getType());
              boolean bool = false;
              if (com.tencent.mm.u.ag.a.hlD != null) {
                bool = com.tencent.mm.u.ag.a.hlD.K(paramau.field_msgId);
              }
              if ((!bool) && (paramAnonymousInt1 == 0) && (paramAnonymousInt2 == 0) && (((ab)paramAnonymousk).getMediaId().equals(localObject1)))
              {
                paramAnonymousString = au.Y(paramau);
                paramAnonymousString.cI(paramau.field_reserved);
                paramAnonymousString.x(-1L);
                cg.this.vAn.vzN.vCX.c(paramInt, paramAnonymousString);
              }
              ap.vd().b(221, cg.this.hTN);
              cg.this.hTN = null;
              GMTrace.o(2246670548992L, 16739);
            }
          };
          this.hTN = ((com.tencent.mm.y.e)localObject3);
          ((n)localObject2).a(221, (com.tencent.mm.y.e)localObject3);
          localObject1 = new ab((String)localObject1);
          ((ab)localObject1).bCX();
          ap.vd().a((com.tencent.mm.y.k)localObject1, 0);
        }
      }
      if ((u.mA(paramau.field_imgPath)) && (parama1.qRI > 0))
      {
        ap.yY();
        localObject1 = com.tencent.mm.u.c.wT().x(paramau.field_talker, parama1.qRI);
        if (!u.mA(((ce)localObject1).field_imgPath))
        {
          localObject2 = com.tencent.mm.plugin.subapp.c.k.lv(m.xL());
          localObject3 = h.at((String)localObject2, false);
          if (j.p(h.at(((ce)localObject1).field_imgPath, false), (String)localObject3, false))
          {
            paramau.cI((String)localObject2);
            ap.yY();
            com.tencent.mm.u.c.wT().a(paramau.field_msgId, paramau);
          }
        }
      }
      if ((u.mA(paramau.field_imgPath)) && (parama1 != null) && (!u.mA(parama1.fCN)) && (parama1.hhg > 0) && (this.hTN == null))
      {
        localObject1 = com.tencent.mm.plugin.subapp.c.k.lv(m.xL());
        localObject2 = h.at((String)localObject1, false);
        paramau.cI((String)localObject1);
        ap.yY();
        com.tencent.mm.u.c.wT().a(paramau.field_msgId, paramau);
        parama = com.tencent.mm.pluginsdk.model.app.l.a((String)localObject2, paramau.field_msgId, parama.sdkVer, parama.appId, parama.fCN, parama.hhg);
        v.d("MicroMsg.ChattingItemVoiceRemindConfirm", "mediaId  " + parama.field_mediaSvrId);
        if (parama.field_mediaSvrId != null)
        {
          localObject1 = ap.vd();
          localObject2 = new com.tencent.mm.y.e()
          {
            public final void a(int paramAnonymousInt1, int paramAnonymousInt2, String paramAnonymousString, com.tencent.mm.y.k paramAnonymousk)
            {
              GMTrace.i(2168421613568L, 16156);
              v.d("MicroMsg.ChattingItemVoiceRemindConfirm", "errType " + paramAnonymousInt1 + " errCode " + paramAnonymousInt2 + "  scene " + paramAnonymousk.getType());
              if (((ab)paramAnonymousk).getMediaId().equals(parama.field_mediaSvrId))
              {
                ap.vd().b(221, cg.this.hTN);
                cg.this.hTN = null;
              }
              GMTrace.o(2168421613568L, 16156);
            }
          };
          this.hTN = ((com.tencent.mm.y.e)localObject2);
          ((n)localObject1).a(221, (com.tencent.mm.y.e)localObject2);
          parama = new ab(parama);
          ap.vd().a(parama, 0);
        }
      }
      paramString.vGb.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          GMTrace.i(2114331869184L, 15753);
          g.a(cg.this.vAn.uRf.uRz, R.l.faH, R.l.faJ, new DialogInterface.OnClickListener()
          {
            public final void onClick(final DialogInterface paramAnonymous2DialogInterface, int paramAnonymous2Int)
            {
              GMTrace.i(2525843423232L, 18819);
              paramAnonymous2DialogInterface = ap.vd();
              Object localObject1 = cg.this;
              Object localObject2 = new com.tencent.mm.y.e()
              {
                public final void a(int paramAnonymous3Int1, int paramAnonymous3Int2, String paramAnonymous3String, com.tencent.mm.y.k paramAnonymous3k)
                {
                  GMTrace.i(2211639721984L, 16478);
                  v.d("MicroMsg.ChattingItemVoiceRemindConfirm", "errType " + paramAnonymous3Int1 + " errCode " + paramAnonymous3Int2 + "  scene " + paramAnonymous3k.getType());
                  if ((paramAnonymous3Int1 == 0) && (paramAnonymous3Int2 == 0))
                  {
                    paramAnonymous3String = cg.4.this.vCF.field_content;
                    if (paramAnonymous3String == null) {
                      break label243;
                    }
                  }
                  label243:
                  for (paramAnonymous3String = f.a.ek(paramAnonymous3String);; paramAnonymous3String = null)
                  {
                    if (paramAnonymous3String != null) {
                      com.tencent.mm.pluginsdk.model.app.l.ed(cg.4.this.vCF.field_msgId);
                    }
                    ay.L(cg.4.this.vCF.field_msgId);
                    Toast.makeText(cg.this.vAn.uRf.uRz, cg.this.vAn.getString(R.l.dTV), 0).show();
                    ap.vd().b(331, cg.this.hTN);
                    cg.this.hTN = null;
                    if (cg.this.phY != null) {
                      cg.this.phY.dismiss();
                    }
                    GMTrace.o(2211639721984L, 16478);
                    return;
                  }
                }
              };
              ((cg)localObject1).hTN = ((com.tencent.mm.y.e)localObject2);
              paramAnonymous2DialogInterface.a(331, (com.tencent.mm.y.e)localObject2);
              paramAnonymous2DialogInterface = new LinkedList();
              localObject1 = new bjm();
              ((bjm)localObject1).ter = cg.4.this.vCJ.qRD;
              paramAnonymous2DialogInterface.add(localObject1);
              paramAnonymous2DialogInterface = new a(paramAnonymous2DialogInterface, paramAnonymous2DialogInterface.size());
              ap.vd().a(paramAnonymous2DialogInterface, 0);
              localObject1 = cg.this;
              localObject2 = cg.this.vAn.uRf.uRz;
              cg.this.vAn.getString(R.l.dIG);
              ((cg)localObject1).phY = g.a((Context)localObject2, cg.this.vAn.getString(R.l.dTW), true, new DialogInterface.OnCancelListener()
              {
                public final void onCancel(DialogInterface paramAnonymous3DialogInterface)
                {
                  GMTrace.i(2156878888960L, 16070);
                  ap.vd().c(paramAnonymous2DialogInterface);
                  ap.vd().b(331, cg.this.hTN);
                  cg.this.hTN = null;
                  if (cg.this.phY != null) {
                    cg.this.phY.dismiss();
                  }
                  GMTrace.o(2156878888960L, 16070);
                }
              });
              GMTrace.o(2525843423232L, 18819);
            }
          }, null);
          GMTrace.o(2114331869184L, 15753);
        }
      });
      paramString.vAj.setTag(new ds(paramau, this.vAn.vvA, paramInt, null, 0, (byte)0));
      paramString.vAj.setOnClickListener(this.vAn.vzN.vDb);
      ap.yY();
      if (com.tencent.mm.u.c.isSDCardAvailable()) {
        paramString.vAj.setOnLongClickListener(this.vAn.vzN.vDd);
      }
      GMTrace.o(2371493036032L, 17669);
      return;
      paramString.ipd.setText("");
    }
  }
  
  public final boolean a(ContextMenu paramContextMenu, View paramView, au paramau)
  {
    GMTrace.i(2371627253760L, 17670);
    int i = ((ds)paramView.getTag()).position;
    int j = com.tencent.mm.pluginsdk.model.app.l.Mf(this.vAn.cQ(paramau.field_content, paramau.field_isSend));
    paramView = f.a.ek(this.vAn.cQ(paramau.field_content, paramau.field_isSend));
    if ((paramView.hhg <= 0) || ((paramView.hhg > 0) && (j >= 100))) {
      paramContextMenu.add(i, 111, 0, this.vAn.getString(R.l.eLz));
    }
    if (!this.vAn.bVz()) {
      paramContextMenu.add(i, 100, 0, this.vAn.getString(R.l.dUh));
    }
    GMTrace.o(2371627253760L, 17670);
    return true;
  }
  
  public final boolean a(MenuItem paramMenuItem, En_5b8fbb1e.a parama, au paramau)
  {
    GMTrace.i(2371761471488L, 17671);
    switch (paramMenuItem.getItemId())
    {
    default: 
      GMTrace.o(2371761471488L, 17671);
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
      GMTrace.o(2371761471488L, 17671);
      return false;
    }
    paramMenuItem = new Intent(parama.uRf.uRz, MsgRetransmitUI.class);
    paramMenuItem.putExtra("Retr_Msg_content", parama.cQ(paramau.field_content, paramau.field_isSend));
    paramMenuItem.putExtra("Retr_Msg_Type", 2);
    paramMenuItem.putExtra("Retr_Msg_Id", paramau.field_msgId);
    parama.startActivity(paramMenuItem);
    GMTrace.o(2371761471488L, 17671);
    return false;
  }
  
  public final boolean a(View paramView, En_5b8fbb1e.a parama, au paramau)
  {
    GMTrace.i(2371895689216L, 17672);
    GMTrace.o(2371895689216L, 17672);
    return true;
  }
  
  protected final boolean bUf()
  {
    GMTrace.i(2371358818304L, 17668);
    GMTrace.o(2371358818304L, 17668);
    return false;
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/ui/chatting/cg.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */