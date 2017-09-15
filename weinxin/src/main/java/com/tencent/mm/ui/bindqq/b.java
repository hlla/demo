package com.tencent.mm.ui.bindqq;

import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.DialogInterface.OnClickListener;
import android.content.DialogInterface.OnDismissListener;
import android.os.Build.VERSION;
import android.view.View;
import android.widget.EditText;
import com.tencent.gmtrace.GMTrace;
import com.tencent.mm.R.h;
import com.tencent.mm.R.i;
import com.tencent.mm.R.l;
import com.tencent.mm.modelsimple.ai;
import com.tencent.mm.protocal.c.avt;
import com.tencent.mm.protocal.c.biw;
import com.tencent.mm.u.ap;
import com.tencent.mm.ui.applet.SecurityImage;
import com.tencent.mm.ui.applet.SecurityImage.a;
import com.tencent.mm.ui.applet.SecurityImage.b;
import com.tencent.mm.ui.base.g;
import com.tencent.mm.ui.base.p;
import com.tencent.mm.y.b.c;
import com.tencent.mm.y.e;
import com.tencent.mm.y.k;
import com.tencent.mm.y.v;

public final class b
  implements e
{
  public Context context;
  com.tencent.mm.ui.base.h oGr;
  private View oGs;
  public SecurityImage uSI;
  public p uWW;
  public String uXd;
  private String uXf;
  private String uXg;
  private byte[] uXh;
  private a vsX;
  
  public b(Context paramContext, a parama)
  {
    GMTrace.i(1901328334848L, 14166);
    this.context = paramContext;
    this.oGs = null;
    this.uWW = null;
    this.oGr = null;
    this.uXd = "";
    this.uSI = null;
    this.uXh = null;
    this.uXf = "";
    this.vsX = parama;
    GMTrace.o(1901328334848L, 14166);
  }
  
  @TargetApi(17)
  public final void a(int paramInt1, int paramInt2, String paramString, k paramk)
  {
    GMTrace.i(1901865205760L, 14170);
    onDetach();
    if ((paramk == null) || (paramk.getType() != 384))
    {
      GMTrace.o(1901865205760L, 14170);
      return;
    }
    if (this.uWW != null)
    {
      this.uWW.dismiss();
      this.uWW = null;
    }
    this.uXf = com.tencent.mm.platformtools.n.a(((biw)((ai)paramk).gUq.hrT.hsa).tGC);
    paramk = (ai)paramk;
    if ((((biw)paramk.gUq.hrT.hsa).tfB != null) && (((biw)paramk.gUq.hrT.hsa).tfB.tXB > 0)) {}
    for (paramk = com.tencent.mm.kernel.h.vG().gWS.R(paramk.htM);; paramk = com.tencent.mm.platformtools.n.a(((biw)paramk.gUq.hrT.hsa).tdB))
    {
      this.uXh = paramk;
      if ((this.vsX == null) || (!this.vsX.t(paramInt1, paramInt2, paramString))) {
        break;
      }
      GMTrace.o(1901865205760L, 14170);
      return;
    }
    if ((this.context instanceof Activity))
    {
      paramk = (Activity)this.context;
      if ((paramk.isFinishing()) || ((Build.VERSION.SDK_INT >= 17) && (paramk.isDestroyed())))
      {
        GMTrace.o(1901865205760L, 14170);
        return;
      }
    }
    if (paramInt1 == 4)
    {
      switch (paramInt2)
      {
      default: 
        paramString = com.tencent.mm.f.a.dn(paramString);
        if (paramString != null)
        {
          paramString.a(this.context, null, null);
          GMTrace.o(1901865205760L, 14170);
          return;
        }
        break;
      case -311: 
      case -310: 
      case -6: 
        if (ap.zb())
        {
          if (this.uSI == null)
          {
            this.uSI = SecurityImage.a.a(this.context, R.l.eJY, 0, this.uXh, this.uXf, this.uXg, new DialogInterface.OnClickListener()
            {
              public final void onClick(final DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
              {
                GMTrace.i(1904952213504L, 14193);
                paramAnonymousDialogInterface = new ai(5, b.this.uXd, b.this.uSI.uXf, b.this.uSI.bRp(), b.this.uSI.uXg, true, 1);
                b.this.wC();
                ap.vd().a(paramAnonymousDialogInterface, 0);
                b localb = b.this;
                Context localContext = b.this.context;
                b.this.context.getString(R.l.dIG);
                localb.uWW = g.a(localContext, b.this.context.getString(R.l.ewP), true, new DialogInterface.OnCancelListener()
                {
                  public final void onCancel(DialogInterface paramAnonymous2DialogInterface)
                  {
                    GMTrace.i(1888577650688L, 14071);
                    b.this.onDetach();
                    ap.vd().c(paramAnonymousDialogInterface);
                    GMTrace.o(1888577650688L, 14071);
                  }
                });
                GMTrace.o(1904952213504L, 14193);
              }
            }, null, new DialogInterface.OnDismissListener()new b
            {
              public final void onDismiss(DialogInterface paramAnonymousDialogInterface)
              {
                GMTrace.i(1894751666176L, 14117);
                b.this.uSI = null;
                GMTrace.o(1894751666176L, 14117);
              }
            }, new b());
            GMTrace.o(1901865205760L, 14170);
            return;
          }
          this.uSI.a(0, this.uXh, this.uXf, this.uXg);
        }
        GMTrace.o(1901865205760L, 14170);
        return;
      case -3: 
        paramString = new DialogInterface.OnClickListener()
        {
          public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
          {
            GMTrace.i(1893275271168L, 14106);
            b.this.oGr = null;
            b.this.onDetach();
            b.this.bTc();
            GMTrace.o(1893275271168L, 14106);
          }
        };
        this.oGr = g.a(this.context, this.context.getString(R.l.dTj), this.context.getString(R.l.dIG), paramString, null);
        GMTrace.o(1901865205760L, 14170);
        return;
      case -72: 
        this.oGr = g.h(this.context, R.l.dUI, R.l.dIG);
        GMTrace.o(1901865205760L, 14170);
        return;
      case -34: 
        this.oGr = g.b(this.context, this.context.getString(R.l.dOr), this.context.getString(R.l.dIG), true);
        GMTrace.o(1901865205760L, 14170);
        return;
      }
      GMTrace.o(1901865205760L, 14170);
      return;
    }
    paramString = com.tencent.mm.f.a.dn(paramString);
    if (paramString != null)
    {
      paramString.a(this.context, null, null);
      GMTrace.o(1901865205760L, 14170);
      return;
    }
    GMTrace.o(1901865205760L, 14170);
  }
  
  public final void bTc()
  {
    GMTrace.i(1901730988032L, 14169);
    this.oGs = View.inflate(this.context, R.i.dnG, null);
    final Object localObject = (EditText)this.oGs.findViewById(R.h.cCp);
    ((EditText)localObject).setHint(R.l.dUG);
    localObject = new DialogInterface.OnClickListener()
    {
      public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
      {
        GMTrace.i(1890725134336L, 14087);
        b.this.oGr = null;
        paramAnonymousDialogInterface = b.this;
        Object localObject = localObject.getText().toString().trim();
        paramAnonymousDialogInterface.wC();
        paramAnonymousDialogInterface.uXd = ((String)localObject);
        localObject = paramAnonymousDialogInterface.context;
        paramAnonymousDialogInterface.context.getString(R.l.dIG);
        paramAnonymousDialogInterface.uWW = g.a((Context)localObject, paramAnonymousDialogInterface.context.getString(R.l.eRe), true, new b.3(paramAnonymousDialogInterface));
        ap.vd().a(new ai(5, paramAnonymousDialogInterface.uXd, "", "", "", false, 1), 0);
        GMTrace.o(1890725134336L, 14087);
      }
    };
    DialogInterface.OnClickListener local2 = new DialogInterface.OnClickListener()
    {
      public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
      {
        GMTrace.i(1902133641216L, 14172);
        b.this.oGr = null;
        b.this.onDetach();
        GMTrace.o(1902133641216L, 14172);
      }
    };
    this.oGr = g.a(this.context, this.context.getString(R.l.dUH), this.oGs, (DialogInterface.OnClickListener)localObject, local2);
    GMTrace.o(1901730988032L, 14169);
  }
  
  public final void onDetach()
  {
    GMTrace.i(1901596770304L, 14168);
    ap.vd().b(384, this);
    if (this.vsX != null) {
      this.vsX.bTb();
    }
    GMTrace.o(1901596770304L, 14168);
  }
  
  public final void wC()
  {
    GMTrace.i(1901462552576L, 14167);
    ap.vd().a(384, this);
    GMTrace.o(1901462552576L, 14167);
  }
  
  public static abstract interface a
  {
    public abstract void bTb();
    
    public abstract boolean t(int paramInt1, int paramInt2, String paramString);
  }
  
  final class b
    extends SecurityImage.b
  {
    b()
    {
      GMTrace.i(1894349012992L, 14114);
      GMTrace.o(1894349012992L, 14114);
    }
    
    public final void bQy()
    {
      GMTrace.i(1894483230720L, 14115);
      b.this.wC();
      ai localai = new ai(5, b.this.uXd, b.this.uSI.uXf, b.this.uSI.bRp(), b.this.uSI.uXg, true, 1);
      ap.vd().a(localai, 0);
      GMTrace.o(1894483230720L, 14115);
    }
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/ui/bindqq/b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */