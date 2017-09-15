package com.tencent.mm.ui.d;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import com.tencent.gmtrace.GMTrace;
import com.tencent.mm.R.h;
import com.tencent.mm.R.i;
import com.tencent.mm.R.l;
import com.tencent.mm.bb.d;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.appbrand.config.WxaAttributes;
import com.tencent.mm.plugin.appbrand.config.WxaExposedParams;
import com.tencent.mm.plugin.appbrand.config.WxaExposedParams.a;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bf;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.ui.base.l;
import com.tencent.mm.ui.base.n.c;
import com.tencent.mm.ui.base.n.d;
import com.tencent.mm.ui.r;
import com.tencent.mm.ui.widget.e;

public final class a
{
  public String appId;
  public Context context;
  public e jbb;
  public WxaExposedParams jhY;
  public int scene;
  public String username;
  public h vcX;
  public String vcY;
  public boolean vcZ;
  
  public a(Context paramContext)
  {
    GMTrace.i(17883841167360L, 133245);
    this.jhY = new WxaExposedParams.a().RI();
    this.appId = "";
    this.vcY = "";
    this.context = paramContext;
    GMTrace.o(17883841167360L, 133245);
  }
  
  private String getAppId()
  {
    GMTrace.i(17884109602816L, 133247);
    if (bf.mA(this.username))
    {
      GMTrace.o(17884109602816L, 133247);
      return null;
    }
    if (bf.mA(this.appId))
    {
      localObject = ((com.tencent.mm.plugin.appbrand.i.b)h.h(com.tencent.mm.plugin.appbrand.i.b.class)).og(this.username);
      if (localObject != null) {
        this.appId = ((WxaAttributes)localObject).field_appId;
      }
    }
    Object localObject = this.appId;
    GMTrace.o(17884109602816L, 133247);
    return (String)localObject;
  }
  
  public final String bRl()
  {
    GMTrace.i(17884512256000L, 133250);
    if (this.jhY == null)
    {
      GMTrace.o(17884512256000L, 133250);
      return "";
    }
    if (bf.mA(this.jhY.fER)) {
      this.jhY.fER = "";
    }
    String str = this.context.getString(R.l.dDg, new Object[] { this.jhY.fER });
    GMTrace.o(17884512256000L, 133250);
    return str;
  }
  
  public final void dU(int paramInt1, int paramInt2)
  {
    GMTrace.i(17884378038272L, 133249);
    if (bf.mA(getAppId()))
    {
      GMTrace.o(17884378038272L, 133249);
      return;
    }
    v.d("MicroMsg.AppBrandSerivceActionSheet", "stev report(%s), appId : %s, scene %s, sceneId %s, action %s", new Object[] { Integer.valueOf(13918), this.appId, Integer.valueOf(paramInt1), this.vcY, Integer.valueOf(paramInt2) });
    g.oSF.i(13918, new Object[] { getAppId(), Integer.valueOf(paramInt1), this.vcY, Integer.valueOf(paramInt2), Long.valueOf(bf.Nz()) });
    GMTrace.o(17884378038272L, 133249);
  }
  
  public final void show(int paramInt)
  {
    GMTrace.i(17883975385088L, 133246);
    this.jbb = new e(this.context, e.wsK, true);
    switch (paramInt)
    {
    default: 
      GMTrace.o(17883975385088L, 133246);
      return;
    case 1: 
      this.vcX = new a();
      if (this.vcX == null) {
        v.e("MicroMsg.AppBrandSerivceActionSheet", "resetTitleView, state is null");
      }
      break;
    }
    for (;;)
    {
      this.jbb.qHD = new n.c()
      {
        public final void a(l paramAnonymousl)
        {
          GMTrace.i(2894807957504L, 21568);
          if (a.this.vcX == null)
          {
            v.e("MicroMsg.AppBrandSerivceActionSheet", "resetOnCreateMenuListener, state is null");
            GMTrace.o(2894807957504L, 21568);
            return;
          }
          a.this.vcX.a(paramAnonymousl);
          GMTrace.o(2894807957504L, 21568);
        }
      };
      this.jbb.qHE = new n.d()
      {
        public final void c(MenuItem paramAnonymousMenuItem, int paramAnonymousInt)
        {
          GMTrace.i(2890915643392L, 21539);
          if (a.this.vcX == null)
          {
            v.e("MicroMsg.AppBrandSerivceActionSheet", "resetOnCreateMenuListener, state is null");
            GMTrace.o(2890915643392L, 21539);
            return;
          }
          a.this.vcX.c(paramAnonymousMenuItem, paramAnonymousInt);
          GMTrace.o(2890915643392L, 21539);
        }
      };
      this.jbb.byZ();
      GMTrace.o(17883975385088L, 133246);
      return;
      this.vcX = new b();
      break;
      this.vcX = new f();
      break;
      this.vcX = new g();
      break;
      this.vcX = new d();
      break;
      this.vcX = new e();
      break;
      View localView = this.vcX.bRm();
      if (localView != null) {
        this.jbb.dC(localView);
      }
    }
  }
  
  public final void zA(int paramInt)
  {
    GMTrace.i(17884243820544L, 133248);
    if (bf.mA(getAppId()))
    {
      GMTrace.o(17884243820544L, 133248);
      return;
    }
    v.d("MicroMsg.AppBrandSerivceActionSheet", "stev report(%s), eventId : %s, appId %s, sceneId %s", new Object[] { Integer.valueOf(13798), Integer.valueOf(paramInt), this.appId, this.vcY });
    g.oSF.i(13798, new Object[] { Integer.valueOf(paramInt), getAppId(), Integer.valueOf(0), this.vcY, Long.valueOf(bf.Nz()) });
    GMTrace.o(17884243820544L, 133248);
  }
  
  public final class a
    extends a.c
  {
    public a()
    {
      super();
      GMTrace.i(17880754159616L, 133222);
      GMTrace.o(17880754159616L, 133222);
    }
    
    public final void a(l paraml)
    {
      GMTrace.i(17880888377344L, 133223);
      super.a(paraml);
      paraml.e(2, a.this.context.getString(R.l.dFO));
      paraml.e(7, a.this.bRl());
      GMTrace.o(17880888377344L, 133223);
    }
    
    public final void c(MenuItem paramMenuItem, int paramInt)
    {
      GMTrace.i(17881022595072L, 133224);
      super.c(paramMenuItem, paramInt);
      GMTrace.o(17881022595072L, 133224);
    }
  }
  
  public final class b
    extends a.c
  {
    public b()
    {
      super();
      GMTrace.i(17882230554624L, 133233);
      GMTrace.o(17882230554624L, 133233);
    }
    
    public final void a(l paraml)
    {
      GMTrace.i(17882364772352L, 133234);
      super.a(paraml);
      paraml.e(3, a.this.context.getString(R.l.dFQ));
      paraml.e(7, a.this.bRl());
      GMTrace.o(17882364772352L, 133234);
    }
    
    public final void c(MenuItem paramMenuItem, int paramInt)
    {
      GMTrace.i(17882498990080L, 133235);
      super.c(paramMenuItem, paramInt);
      GMTrace.o(17882498990080L, 133235);
    }
  }
  
  public class c
    implements a.h
  {
    public c()
    {
      GMTrace.i(17882633207808L, 133236);
      GMTrace.o(17882633207808L, 133236);
    }
    
    public void a(l paraml)
    {
      GMTrace.i(17882901643264L, 133238);
      GMTrace.o(17882901643264L, 133238);
    }
    
    public View bRm()
    {
      GMTrace.i(17882767425536L, 133237);
      GMTrace.o(17882767425536L, 133237);
      return null;
    }
    
    public void c(MenuItem paramMenuItem, int paramInt)
    {
      int i = 1;
      GMTrace.i(17883035860992L, 133239);
      switch (paramMenuItem.getItemId())
      {
      default: 
        paramInt = 0;
      }
      for (;;)
      {
        if (paramInt != 0) {
          a.this.jbb.bza();
        }
        GMTrace.o(17883035860992L, 133239);
        return;
        ae.f(new Runnable()
        {
          public final void run()
          {
            GMTrace.i(17885988651008L, 133261);
            a.this.show(3);
            GMTrace.o(17885988651008L, 133261);
          }
        }, 100L);
        paramInt = i;
        continue;
        ae.f(new Runnable()
        {
          public final void run()
          {
            GMTrace.i(17880619941888L, 133221);
            a.this.show(4);
            GMTrace.o(17880619941888L, 133221);
          }
        }, 100L);
        paramInt = i;
        continue;
        a.this.jbb.bza();
        paramInt = i;
        continue;
        paramInt = i;
        if (!bf.mA(a.this.username))
        {
          b.j(a.this.context, a.this.username, true);
          if (a.this.vcZ)
          {
            a.this.zA(6);
            paramInt = i;
          }
          else
          {
            a.this.dU(a.this.scene, 4);
            paramInt = i;
            continue;
            paramInt = i;
            if (!bf.mA(a.this.username))
            {
              b.j(a.this.context, a.this.username, false);
              if (a.this.vcZ)
              {
                a.this.zA(1);
                paramInt = i;
              }
              else
              {
                a.this.dU(a.this.scene, 2);
                paramInt = i;
                continue;
                paramMenuItem = a.this;
                Context localContext = a.this.context;
                WxaExposedParams localWxaExposedParams = a.this.jhY;
                if (localWxaExposedParams == null)
                {
                  v.e("MicroMsg.AppBrandSerivceActionSheet", "exportUrlParams is null");
                  paramInt = i;
                }
                else
                {
                  v.i("MicroMsg.AppBrandSerivceActionSheet", "exportUrlParams : %s", new Object[] { localWxaExposedParams.toString() });
                  paramInt = i;
                  if (!bf.mA(localWxaExposedParams.username))
                  {
                    Intent localIntent = new Intent();
                    localIntent.putExtra("key_username", localWxaExposedParams.username);
                    localIntent.putExtra("key_from_scene", 4);
                    localIntent.putExtra("key_scene_exposed_params", localWxaExposedParams);
                    d.b(localContext, "appbrand", ".ui.AppBrandProfileUI", localIntent);
                    paramMenuItem.dU(paramMenuItem.scene, 1);
                    paramInt = i;
                  }
                }
              }
            }
          }
        }
      }
    }
  }
  
  public final class d
    extends a.c
  {
    public d()
    {
      super();
      GMTrace.i(17886659739648L, 133266);
      GMTrace.o(17886659739648L, 133266);
    }
    
    public final void a(l paraml)
    {
      GMTrace.i(17886793957376L, 133267);
      super.a(paraml);
      paraml.e(2, a.this.context.getString(R.l.dFO));
      paraml.e(7, a.this.bRl());
      GMTrace.o(17886793957376L, 133267);
    }
    
    public final void c(MenuItem paramMenuItem, int paramInt)
    {
      GMTrace.i(17886928175104L, 133268);
      super.c(paramMenuItem, paramInt);
      GMTrace.o(17886928175104L, 133268);
    }
  }
  
  public final class e
    extends a.c
  {
    public e()
    {
      super();
      GMTrace.i(17885451780096L, 133257);
      GMTrace.o(17885451780096L, 133257);
    }
    
    public final void a(l paraml)
    {
      GMTrace.i(17885585997824L, 133258);
      super.a(paraml);
      paraml.e(3, a.this.context.getString(R.l.dFQ));
      paraml.e(7, a.this.bRl());
      GMTrace.o(17885585997824L, 133258);
    }
    
    public final void c(MenuItem paramMenuItem, int paramInt)
    {
      GMTrace.i(17885720215552L, 133259);
      super.c(paramMenuItem, paramInt);
      GMTrace.o(17885720215552L, 133259);
    }
  }
  
  public final class f
    extends a.c
  {
    public f()
    {
      super();
      GMTrace.i(17879948853248L, 133216);
      GMTrace.o(17879948853248L, 133216);
    }
    
    public final void a(l paraml)
    {
      GMTrace.i(17880217288704L, 133218);
      super.a(paraml);
      paraml.e(5, a.this.context.getString(R.l.dEK));
      paraml.e(4, a.this.context.getString(R.l.dFM));
      GMTrace.o(17880217288704L, 133218);
    }
    
    public final View bRm()
    {
      GMTrace.i(17880083070976L, 133217);
      View localView = r.eC(a.this.context).inflate(R.i.cXh, null);
      ((TextView)localView.findViewById(R.h.bpK)).setText(a.this.context.getString(R.l.dFN));
      GMTrace.o(17880083070976L, 133217);
      return localView;
    }
    
    public final void c(MenuItem paramMenuItem, int paramInt)
    {
      GMTrace.i(17880351506432L, 133219);
      super.c(paramMenuItem, paramInt);
      GMTrace.o(17880351506432L, 133219);
    }
  }
  
  public final class g
    extends a.c
  {
    public g()
    {
      super();
      GMTrace.i(17884914909184L, 133253);
      GMTrace.o(17884914909184L, 133253);
    }
    
    public final void a(l paraml)
    {
      GMTrace.i(17885183344640L, 133255);
      super.a(paraml);
      paraml.e(6, a.this.context.getString(R.l.dEL));
      paraml.e(4, a.this.context.getString(R.l.dFM));
      GMTrace.o(17885183344640L, 133255);
    }
    
    public final View bRm()
    {
      GMTrace.i(17885049126912L, 133254);
      View localView = r.eC(a.this.context).inflate(R.i.cXh, null);
      ((TextView)localView.findViewById(R.h.bpK)).setText(a.this.context.getString(R.l.dFP));
      GMTrace.o(17885049126912L, 133254);
      return localView;
    }
    
    public final void c(MenuItem paramMenuItem, int paramInt)
    {
      GMTrace.i(17885317562368L, 133256);
      super.c(paramMenuItem, paramInt);
      GMTrace.o(17885317562368L, 133256);
    }
  }
  
  public static abstract interface h
  {
    public abstract void a(l paraml);
    
    public abstract View bRm();
    
    public abstract void c(MenuItem paramMenuItem, int paramInt);
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/ui/d/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */