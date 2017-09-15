package com.tencent.mm.ui.account;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;
import com.tencent.gmtrace.GMTrace;
import com.tencent.mm.R.c;
import com.tencent.mm.R.h;
import com.tencent.mm.R.i;
import com.tencent.mm.R.l;
import com.tencent.mm.network.e;
import com.tencent.mm.plugin.c.a;
import com.tencent.mm.plugin.c.b;
import com.tencent.mm.pluginsdk.i;
import com.tencent.mm.protocal.GeneralControlWrapper;
import com.tencent.mm.protocal.JsapiPermissionWrapper;
import com.tencent.mm.protocal.d;
import com.tencent.mm.sdk.platformtools.aa;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.u;
import com.tencent.mm.u.ap;
import com.tencent.mm.u.bb;
import com.tencent.mm.u.bb.a;
import com.tencent.mm.u.bf;
import com.tencent.mm.ui.account.mobile.MobileInputUI;
import com.tencent.mm.y.n;

public class WelcomeSelectView
  extends WelcomeView
{
  private int RQ;
  private Context context;
  private View njN;
  private Button vao;
  private Button vap;
  private TextView vaq;
  
  public WelcomeSelectView(Context paramContext)
  {
    super(paramContext);
    GMTrace.i(2551881662464L, 19013);
    this.RQ = 800;
    bV(paramContext);
    GMTrace.o(2551881662464L, 19013);
  }
  
  @TargetApi(11)
  public WelcomeSelectView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    GMTrace.i(2551747444736L, 19012);
    this.RQ = 800;
    bV(paramContext);
    GMTrace.o(2551747444736L, 19012);
  }
  
  private void bV(final Context paramContext)
  {
    GMTrace.i(2552418533376L, 19017);
    this.context = paramContext;
    View localView = LayoutInflater.from(paramContext).inflate(R.i.drK, this);
    this.njN = localView.findViewById(R.h.cBM);
    this.vao = ((Button)localView.findViewById(R.h.cBL));
    this.vap = ((Button)localView.findViewById(R.h.cBU));
    this.vaq = ((TextView)localView.findViewById(R.h.cSH));
    this.njN.setVisibility(8);
    this.vaq.setVisibility(8);
    this.vaq.setText(u.g(paramContext, R.c.aSd, R.l.dHr));
    this.RQ = paramContext.getResources().getDisplayMetrics().heightPixels;
    this.vaq.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        GMTrace.i(2783944114176L, 20742);
        paramAnonymousView = new Intent();
        paramAnonymousView.putExtra("not_auth_setting", true);
        paramAnonymousView.putExtra("from_login_history", true);
        a.imb.s(paramAnonymousView, WelcomeSelectView.this.getContext());
        GMTrace.o(2783944114176L, 20742);
      }
    });
    this.vao.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        GMTrace.i(2743276142592L, 20439);
        paramAnonymousView = new Intent(paramContext, MobileInputUI.class);
        paramAnonymousView.putExtra("mobile_input_purpose", 1);
        paramContext.startActivity(paramAnonymousView);
        GMTrace.o(2743276142592L, 20439);
      }
    });
    this.vap.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        GMTrace.i(2742470836224L, 20433);
        if (d.sXk)
        {
          paramAnonymousView = paramContext.getString(R.l.eaK, new Object[] { "0x" + Integer.toHexString(d.sXh), u.bID() });
          Intent localIntent = new Intent();
          localIntent.putExtra("rawUrl", paramAnonymousView);
          localIntent.putExtra("showShare", false);
          localIntent.putExtra("show_bottom", false);
          localIntent.putExtra("needRedirect", false);
          localIntent.putExtra("neverGetA8Key", true);
          localIntent.putExtra("hardcode_jspermission", JsapiPermissionWrapper.sXt);
          localIntent.putExtra("hardcode_general_ctrl", GeneralControlWrapper.sXq);
          a.imb.j(localIntent, paramContext);
          GMTrace.o(2742470836224L, 20433);
          return;
        }
        bf.zK();
        paramAnonymousView = new Intent(paramContext, RegByMobileRegAIOUI.class);
        paramAnonymousView.putExtra("login_type", 0);
        paramContext.startActivity(paramAnonymousView);
        bf.zK();
        b.hh(20);
        b.mN("RE200_100");
        b.b(false, ap.uY() + "," + getClass().getName() + ",R100_100_new," + ap.ec("R100_100_new") + ",2");
        b.mM("R100_100_new");
        GMTrace.o(2742470836224L, 20433);
      }
    });
    paramContext = u.e(this.context.getSharedPreferences(aa.bIN(), 0));
    this.vaq.setText(u.g(this.context, R.c.aSd, R.l.dHr));
    if ((paramContext != null) && (paramContext.equals("language_default"))) {
      this.vaq.setText(this.context.getString(R.l.ewJ));
    }
    this.vao.setText(R.l.esy);
    this.vap.setText(R.l.esx);
    GMTrace.o(2552418533376L, 19017);
  }
  
  public final void bRd()
  {
    GMTrace.i(2552552751104L, 19018);
    cY(this.njN);
    cY(this.vaq);
    this.njN.setVisibility(0);
    this.vaq.setVisibility(0);
    ae.v(new Runnable()
    {
      public final void run()
      {
        GMTrace.i(2736028385280L, 20385);
        ap.vd().a(new bb(new bb.a()
        {
          public final void a(e paramAnonymous2e)
          {
            GMTrace.i(2774548873216L, 20672);
            GMTrace.o(2774548873216L, 20672);
          }
        }, "launch normal"), 0);
        GMTrace.o(2736028385280L, 20385);
      }
    });
    GMTrace.o(2552552751104L, 19018);
  }
  
  protected void dispatchDraw(Canvas paramCanvas)
  {
    GMTrace.i(2552150097920L, 19015);
    super.dispatchDraw(paramCanvas);
    GMTrace.o(2552150097920L, 19015);
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/ui/account/WelcomeSelectView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */