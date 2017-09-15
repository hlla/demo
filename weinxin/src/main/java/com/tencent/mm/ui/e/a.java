package com.tencent.mm.ui.e;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.gmtrace.GMTrace;
import com.tencent.mm.R.h;
import com.tencent.mm.R.i;
import com.tencent.mm.R.l;
import com.tencent.mm.bb.d;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.sdk.platformtools.bf;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.storage.t;
import com.tencent.mm.storage.w.a;
import com.tencent.mm.u.ap;
import com.tencent.mm.u.b.b.b;
import com.tencent.mm.u.c;
import java.lang.ref.WeakReference;

public class a
  extends com.tencent.mm.pluginsdk.ui.b.b
{
  private String mUZ;
  public String mUrl;
  private boolean vdM;
  public b.b vdN;
  private String vdO;
  
  public a(Context paramContext, b.b paramb)
  {
    super(paramContext);
    GMTrace.i(16235513249792L, 120964);
    this.mUZ = null;
    this.mUrl = null;
    this.vdM = false;
    this.vdN = null;
    this.vdO = "";
    this.vdN = paramb;
    refresh();
    GMTrace.o(16235513249792L, 120964);
  }
  
  private void refresh()
  {
    GMTrace.i(16235781685248L, 120966);
    ap.yY().xA();
    if (com.tencent.mm.u.b.b.a(this.vdN))
    {
      v.i("MicroMsg.ChattingMonitoredBanner", "hy: start show banner: %s, %s, %s, %b", new Object[] { this.vdN, this.mUZ, this.mUrl, Boolean.valueOf(this.vdM) });
      Object localObject;
      if (this.vdN == b.b.hot)
      {
        ap.yY().xA();
        this.mUZ = com.tencent.mm.u.b.b.Ak();
        ap.yY().xA();
        this.mUrl = com.tencent.mm.u.b.b.Al();
        ap.yY().xA();
        this.vdM = com.tencent.mm.u.b.b.Am();
        localObject = (TextView)getView().findViewById(R.h.bAU);
        if (bf.mA(this.mUZ)) {
          break label320;
        }
        ((TextView)localObject).setText(this.mUZ);
      }
      for (;;)
      {
        ((TextView)localObject).setSelected(true);
        getView().setOnClickListener(new View.OnClickListener()
        {
          public final void onClick(View paramAnonymousView)
          {
            GMTrace.i(16236721209344L, 120973);
            a.this.zB(1);
            if (!bf.mA(a.this.mUrl)) {
              a.this.Is(a.this.mUrl);
            }
            GMTrace.o(16236721209344L, 120973);
          }
        });
        if (getView().getVisibility() != 0)
        {
          localObject = new StringBuilder();
          h.vG();
          this.vdO = (com.tencent.mm.kernel.a.uH() + "_" + System.currentTimeMillis());
          zB(0);
        }
        setVisibility(0);
        localObject = (ImageView)getView().findViewById(R.h.bCu);
        if (!this.vdM) {
          break label330;
        }
        ((ImageView)localObject).setVisibility(0);
        ((ImageView)localObject).setOnClickListener(new View.OnClickListener()
        {
          public final void onClick(View paramAnonymousView)
          {
            GMTrace.i(16236452773888L, 120971);
            v.i("MicroMsg.ChattingMonitoredBanner", "hy: user required close the banner");
            a.this.zB(2);
            paramAnonymousView = ap.yY().xA();
            b.b localb = a.this.vdN;
            if (localb == b.b.hos)
            {
              ap.yY();
              c.vr().a(w.a.uGh, Long.valueOf(0L));
            }
            for (;;)
            {
              paramAnonymousView.Ap();
              do
              {
                a.this.setVisibility(8);
                GMTrace.o(16236452773888L, 120971);
                return;
              } while (localb != b.b.hot);
              if (!com.tencent.mm.u.b.b.An())
              {
                ap.yY();
                c.vr().a(w.a.uGb, Long.valueOf(0L));
              }
              else
              {
                ap.yY();
                c.vr().a(w.a.uGe, Boolean.valueOf(true));
              }
            }
          }
        });
        GMTrace.o(16235781685248L, 120966);
        return;
        ap.yY().xA();
        this.mUZ = com.tencent.mm.u.b.b.Ah();
        ap.yY().xA();
        this.mUrl = com.tencent.mm.u.b.b.Ai();
        ap.yY().xA();
        this.vdM = com.tencent.mm.u.b.b.Aj();
        break;
        label320:
        ((TextView)localObject).setText(R.l.dIV);
      }
      label330:
      ((ImageView)localObject).setVisibility(8);
      GMTrace.o(16235781685248L, 120966);
      return;
    }
    v.i("MicroMsg.ChattingMonitoredBanner", "hy: should not show banner");
    setVisibility(8);
    GMTrace.o(16235781685248L, 120966);
  }
  
  protected void Is(String paramString)
  {
    GMTrace.i(17829885640704L, 132843);
    if (bf.mA(paramString))
    {
      v.e("MicroMsg.ChattingMonitoredBanner", "hy: not provide url");
      GMTrace.o(17829885640704L, 132843);
      return;
    }
    Intent localIntent = new Intent();
    localIntent.putExtra("rawUrl", paramString);
    localIntent.putExtra("showShare", false);
    localIntent.putExtra("show_bottom", false);
    d.b((Context)this.sLV.get(), "webview", ".ui.tools.WebViewUI", localIntent);
    GMTrace.o(17829885640704L, 132843);
  }
  
  public final boolean Xd()
  {
    GMTrace.i(16236050120704L, 120968);
    refresh();
    boolean bool = super.Xd();
    GMTrace.o(16236050120704L, 120968);
    return bool;
  }
  
  public final void destroy()
  {
    GMTrace.i(16236184338432L, 120969);
    GMTrace.o(16236184338432L, 120969);
  }
  
  public int getLayoutId()
  {
    GMTrace.i(16235647467520L, 120965);
    int i = R.i.cYA;
    GMTrace.o(16235647467520L, 120965);
    return i;
  }
  
  public final void setVisibility(int paramInt)
  {
    GMTrace.i(16235915902976L, 120967);
    super.setVisibility(paramInt);
    getView().findViewById(R.h.ckU).setVisibility(paramInt);
    GMTrace.o(16235915902976L, 120967);
  }
  
  public final void zB(int paramInt)
  {
    int i = 1;
    GMTrace.i(17804652707840L, 132655);
    g localg = g.oSF;
    String str = this.vdO;
    if (this.vdN == b.b.hos) {
      i = 0;
    }
    localg.i(14439, new Object[] { str, Integer.valueOf(paramInt), Integer.valueOf(i) });
    g.oSF.a(633L, paramInt, 1L, false);
    GMTrace.o(17804652707840L, 132655);
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/ui/e/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */