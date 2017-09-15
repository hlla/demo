package com.tencent.mm.ui.conversation.a;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.widget.ImageView;
import android.widget.LinearLayout.LayoutParams;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.tencent.gmtrace.GMTrace;
import com.tencent.mm.R.g;
import com.tencent.mm.R.h;
import com.tencent.mm.R.i;
import com.tencent.mm.R.k;
import com.tencent.mm.R.l;
import com.tencent.mm.bg.a;
import com.tencent.mm.modelsimple.q;
import com.tencent.mm.platformtools.r;
import com.tencent.mm.pluginsdk.ui.b.b;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.u.ap;
import com.tencent.mm.u.c;
import com.tencent.mm.ui.MMAppMgr;
import com.tencent.mm.y.n;
import java.lang.ref.WeakReference;

public final class m
  extends b
{
  private boolean hJL;
  private TextView ipc;
  private TextView ipd;
  private ProgressDialog isb;
  public View jHa;
  private ImageView jaK;
  private TextView qTr;
  private TextView wdA;
  private TextView wdB;
  private ImageView wdC;
  private ImageView wdD;
  private ImageView wdE;
  private ProgressBar wdF;
  public String wdG;
  private boolean wdH;
  public boolean wdI;
  
  public m(Context paramContext)
  {
    super(paramContext);
    GMTrace.i(14503299252224L, 108058);
    this.isb = null;
    this.hJL = false;
    this.wdH = false;
    this.jHa = null;
    this.wdI = false;
    initialize();
    GMTrace.o(14503299252224L, 108058);
  }
  
  private void initialize()
  {
    GMTrace.i(14503567687680L, 108060);
    if ((!this.wdH) && (this.view != null))
    {
      this.jHa = this.view.findViewById(R.h.coS);
      this.ipc = ((TextView)this.view.findViewById(R.h.coN));
      this.ipd = ((TextView)this.view.findViewById(R.h.coO));
      this.qTr = ((TextView)this.view.findViewById(R.h.coP));
      this.wdA = ((TextView)this.view.findViewById(R.h.coM));
      this.wdF = ((ProgressBar)this.view.findViewById(R.h.coR));
      this.jaK = ((ImageView)this.view.findViewById(R.h.coQ));
      this.wdC = ((ImageView)this.view.findViewById(R.h.bCu));
      this.wdD = ((ImageView)this.view.findViewById(R.h.bQW));
      this.wdE = ((ImageView)this.view.findViewById(R.h.cFo));
      this.wdB = ((TextView)this.view.findViewById(R.h.bLQ));
      this.wdC.setVisibility(8);
      this.wdH = true;
    }
    GMTrace.o(14503567687680L, 108060);
  }
  
  public final boolean Xd()
  {
    int j = 0;
    GMTrace.i(14503836123136L, 108062);
    final int i = ap.vd().BR();
    final Object localObject = ap.vd().getNetworkServerIp();
    this.wdG = String.format("http://w.mail.qq.com/cgi-bin/report_mm?failuretype=1&devicetype=2&clientversion=%s&os=%s&username=%s&iport=%s&t=weixin_bulletin&f=xhtml&lang=%s", new Object[] { "0x" + Integer.toHexString(com.tencent.mm.protocal.d.sXh), com.tencent.mm.protocal.d.DEVICE_TYPE, com.tencent.mm.u.m.xL(), localObject, com.tencent.mm.sdk.platformtools.u.bID() });
    initialize();
    v.i("MicroMsg.NetWarnView", "update st:%d", new Object[] { Integer.valueOf(i) });
    boolean bool1;
    boolean bool2;
    switch (i)
    {
    case 1: 
    case 4: 
    default: 
      bool1 = false;
      if (bool1)
      {
        this.qTr.setVisibility(8);
        this.ipc.setVisibility(0);
        this.jHa.setBackgroundResource(R.g.bkI);
        localObject = new LinearLayout.LayoutParams(this.jaK.getLayoutParams());
        ((LinearLayout.LayoutParams)localObject).setMargins(a.fromDPToPix((Context)this.sLV.get(), 10), 0, a.fromDPToPix((Context)this.sLV.get(), 4), 0);
        this.jaK.setLayoutParams((ViewGroup.LayoutParams)localObject);
        this.jaK.setImageResource(R.k.dzR);
        this.wdD.setVisibility(8);
        this.wdE.setVisibility(8);
        this.wdB.setVisibility(8);
        bool2 = bool1;
        label282:
        bool1 = bool2;
        if (!bool2)
        {
          this.wdC.setVisibility(8);
          bool1 = bool2;
          if (r.ihW)
          {
            i = al.getBackgroundLimitType((Context)this.sLV.get());
            if ((!al.isLimited(i)) || (this.wdI)) {
              break label1258;
            }
            this.ipc.setText(((Context)this.sLV.get()).getString(R.l.eGQ));
            this.ipd.setText(((Context)this.sLV.get()).getString(R.l.eGP));
            this.ipd.setVisibility(0);
            this.wdA.setVisibility(8);
            this.wdF.setVisibility(8);
            this.jaK.setVisibility(0);
            this.wdC.setVisibility(0);
            this.jHa.setOnClickListener(new View.OnClickListener()
            {
              public final void onClick(View paramAnonymousView)
              {
                GMTrace.i(14510144356352L, 108109);
                try
                {
                  al.startSettingItent((Context)m.this.sLV.get(), i);
                  GMTrace.o(14510144356352L, 108109);
                  return;
                }
                catch (Exception paramAnonymousView)
                {
                  v.printErrStackTrace("MicroMsg.NetWarnView", paramAnonymousView, "", new Object[0]);
                  GMTrace.o(14510144356352L, 108109);
                }
              }
            });
            this.wdC.setOnClickListener(new View.OnClickListener()
            {
              public final void onClick(View paramAnonymousView)
              {
                GMTrace.i(14512023404544L, 108123);
                MMAppMgr.a((Context)m.this.sLV.get(), i, new DialogInterface.OnClickListener()new DialogInterface.OnClickListener
                {
                  public final void onClick(DialogInterface paramAnonymous2DialogInterface, int paramAnonymous2Int)
                  {
                    GMTrace.i(14509204832256L, 108102);
                    try
                    {
                      m.this.jHa.setVisibility(8);
                      m.this.wdI = true;
                      al.startSettingItent((Context)m.this.sLV.get(), m.6.this.iyZ);
                      GMTrace.o(14509204832256L, 108102);
                      return;
                    }
                    catch (Exception paramAnonymous2DialogInterface)
                    {
                      v.printErrStackTrace("MicroMsg.NetWarnView", paramAnonymous2DialogInterface, "", new Object[0]);
                      GMTrace.o(14509204832256L, 108102);
                    }
                  }
                }, new DialogInterface.OnClickListener()
                {
                  public final void onClick(DialogInterface paramAnonymous2DialogInterface, int paramAnonymous2Int)
                  {
                    GMTrace.i(14496722583552L, 108009);
                    m.this.jHa.setVisibility(8);
                    m.this.wdI = true;
                    GMTrace.o(14496722583552L, 108009);
                  }
                });
                GMTrace.o(14512023404544L, 108123);
              }
            });
            bool1 = true;
          }
        }
        label458:
        this.wdE.setImageResource(R.k.dvl);
        this.wdC.setImageResource(R.g.bcC);
        localObject = this.jHa;
        if (!bool1) {
          break label1273;
        }
      }
      break;
    }
    label990:
    label1036:
    label1181:
    label1253:
    label1258:
    label1273:
    for (i = j;; i = 8)
    {
      ((View)localObject).setVisibility(i);
      GMTrace.o(14503836123136L, 108062);
      return bool1;
      this.ipc.setText(R.l.eDf);
      this.ipd.setVisibility(8);
      this.wdA.setVisibility(8);
      this.wdF.setVisibility(8);
      this.jaK.setVisibility(0);
      this.jHa.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          GMTrace.i(14499138502656L, 108027);
          paramAnonymousView = new Intent();
          paramAnonymousView.putExtra("title", ((Context)m.this.sLV.get()).getString(R.l.eDf));
          paramAnonymousView.putExtra("rawUrl", ((Context)m.this.sLV.get()).getString(R.l.eDe));
          paramAnonymousView.putExtra("showShare", false);
          com.tencent.mm.bb.d.b((Context)m.this.sLV.get(), "webview", ".ui.tools.WebViewUI", paramAnonymousView);
          GMTrace.o(14499138502656L, 108027);
        }
      });
      bool1 = true;
      break;
      this.ipc.setText(R.l.eDd);
      this.ipd.setVisibility(8);
      this.wdA.setVisibility(8);
      this.wdF.setVisibility(0);
      this.jaK.setVisibility(0);
      bool1 = true;
      break;
      this.ipc.setText(R.l.eDi);
      this.ipd.setVisibility(8);
      this.wdA.setVisibility(8);
      this.wdF.setVisibility(8);
      this.jaK.setVisibility(0);
      this.jHa.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          GMTrace.i(14500212244480L, 108035);
          com.tencent.mm.bb.d.w((Context)m.this.sLV.get(), "traceroute", ".ui.NetworkDiagnoseIntroUI");
          GMTrace.o(14500212244480L, 108035);
        }
      });
      bool1 = true;
      break;
      this.ipc.setText(R.l.eDg);
      this.ipd.setText(((Context)this.sLV.get()).getString(R.l.eDh));
      this.ipd.setVisibility(0);
      this.wdA.setVisibility(8);
      this.wdF.setVisibility(8);
      this.jaK.setVisibility(0);
      this.jHa.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          GMTrace.i(14505580953600L, 108075);
          if (!com.tencent.mm.platformtools.u.F((Context)m.this.sLV.get(), m.this.wdG))
          {
            paramAnonymousView = new Intent();
            paramAnonymousView.putExtra("title", ((Context)m.this.sLV.get()).getString(R.l.eDi));
            paramAnonymousView.putExtra("rawUrl", ((Context)m.this.sLV.get()).getString(R.l.eDe));
            paramAnonymousView.putExtra("showShare", false);
            com.tencent.mm.bb.d.b((Context)m.this.sLV.get(), "webview", ".ui.tools.WebViewUI", paramAnonymousView);
          }
          GMTrace.o(14505580953600L, 108075);
        }
      });
      bool1 = true;
      break;
      ap.yY();
      if (c.wM())
      {
        ap.yY();
        if (q.gw(c.wN()))
        {
          localObject = ap.vd();
          ap.yY();
          ((n)localObject).a(new q(c.wN()), 0);
          bool2 = bool1;
          break label282;
        }
      }
      ap.yY();
      bool2 = bool1;
      if (!c.wM()) {
        break label282;
      }
      bool2 = bool1;
      if (com.tencent.mm.platformtools.u.mA(q.hRJ)) {
        break label282;
      }
      bool2 = bool1;
      if (q.Jc()) {
        break label282;
      }
      this.jHa.setBackgroundResource(R.g.bkJ);
      localObject = new LinearLayout.LayoutParams(this.jaK.getLayoutParams());
      ((LinearLayout.LayoutParams)localObject).setMargins(a.fromDPToPix((Context)this.sLV.get(), 22), 0, a.fromDPToPix((Context)this.sLV.get(), 20), 0);
      this.jaK.setLayoutParams((ViewGroup.LayoutParams)localObject);
      this.ipc.setVisibility(8);
      this.ipd.setVisibility(8);
      this.qTr.setVisibility(0);
      if (com.tencent.mm.u.m.eV(com.tencent.mm.u.m.xR())) {
        if ((!q.Jf()) && (q.Jd()))
        {
          this.qTr.setText(q.hRQ);
          this.wdA.setVisibility(8);
          this.wdF.setVisibility(8);
          this.jaK.setPadding(0, 0, 0, 0);
          if (q.Jb() != 1) {
            break label1181;
          }
          this.jaK.setImageResource(R.k.dwc);
          this.jaK.setVisibility(0);
          this.wdD.setVisibility(8);
          this.wdE.setVisibility(8);
          localObject = this.wdB;
          if (!com.tencent.mm.u.m.eV(com.tencent.mm.u.m.xR())) {
            break label1253;
          }
        }
      }
      for (i = 8;; i = 0)
      {
        ((TextView)localObject).setVisibility(i);
        localObject = new Intent();
        ((Intent)localObject).putExtra("intent.key.online_version", q.Je());
        this.jHa.setOnClickListener(new View.OnClickListener()
        {
          public final void onClick(View paramAnonymousView)
          {
            GMTrace.i(14501822857216L, 108047);
            com.tencent.mm.bb.d.b((Context)m.this.sLV.get(), "webwx", ".ui.WebWXLogoutUI", localObject);
            GMTrace.o(14501822857216L, 108047);
          }
        });
        bool2 = true;
        break;
        this.qTr.setText(q.hRJ);
        break label990;
        if ((!q.Jf()) && (q.Jd()))
        {
          this.qTr.setText(q.hRR);
          break label990;
        }
        this.qTr.setText(q.hRM);
        break label990;
        if (q.Jb() == 2)
        {
          if (q.Jd())
          {
            this.jaK.setImageResource(R.k.dwb);
            break label1036;
          }
          this.jaK.setImageResource(R.k.dwa);
          break label1036;
        }
        if (q.Jb() == 3)
        {
          this.jaK.setImageResource(R.k.dvZ);
          break label1036;
        }
        this.jaK.setImageResource(R.k.dzN);
        break label1036;
      }
      this.wdC.setVisibility(8);
      bool1 = bool2;
      break label458;
    }
  }
  
  public final void destroy()
  {
    GMTrace.i(14503701905408L, 108061);
    GMTrace.o(14503701905408L, 108061);
  }
  
  public final int getLayoutId()
  {
    GMTrace.i(14503433469952L, 108059);
    int i = R.i.djR;
    GMTrace.o(14503433469952L, 108059);
    return i;
  }
  
  public final int getOrder()
  {
    GMTrace.i(16853585887232L, 125569);
    GMTrace.o(16853585887232L, 125569);
    return 2;
  }
  
  public final void setVisibility(int paramInt)
  {
    GMTrace.i(14504104558592L, 108064);
    if (this.jHa != null) {
      this.jHa.setVisibility(paramInt);
    }
    GMTrace.o(14504104558592L, 108064);
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/ui/conversation/a/m.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */