package com.tencent.mm.ui.conversation.a;

import android.content.Context;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import com.tencent.gmtrace.GMTrace;
import com.tencent.mm.R.h;
import com.tencent.mm.R.i;
import com.tencent.mm.ao.o;
import com.tencent.mm.pluginsdk.l.a;
import com.tencent.mm.pluginsdk.l.w;
import com.tencent.mm.sdk.platformtools.aa;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.storage.t;
import com.tencent.mm.u.ap;
import java.lang.ref.WeakReference;

public final class a
  extends com.tencent.mm.pluginsdk.ui.b.b
{
  private View jHa;
  public b wcD;
  public int wcE;
  private d wcF;
  public a wcG;
  
  public a(Context paramContext)
  {
    super(paramContext);
    GMTrace.i(14494843535360L, 107995);
    this.wcE = 0;
    this.jHa = null;
    if (this.view != null)
    {
      this.jHa = this.view.findViewById(R.h.bnQ);
      this.wcF = new d();
      this.wcF.wcK = this.jHa;
      this.wcF.wcL = ((Button)this.view.findViewById(R.h.bnl));
      this.wcF.wcL.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          GMTrace.i(14499406938112L, 108029);
          if ((a.this.wcD != null) && (a.this.wcG != null))
          {
            paramAnonymousView = a.this.wcD.BL(a.this.wcE);
            a.this.wcG.Ji(paramAnonymousView.wcJ.id);
          }
          GMTrace.o(14499406938112L, 108029);
        }
      });
      this.jHa.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          GMTrace.i(14499943809024L, 108033);
          if ((a.this.wcD != null) && (a.this.wcG != null))
          {
            paramAnonymousView = a.this.wcD.BL(a.this.wcE);
            a.this.wcG.eV(paramAnonymousView.wcJ.id, paramAnonymousView.wcJ.url);
          }
          GMTrace.o(14499943809024L, 108033);
        }
      });
    }
    GMTrace.o(14494843535360L, 107995);
  }
  
  public final boolean Xd()
  {
    GMTrace.i(14495514624000L, 108000);
    this.wcD = new b((Context)this.sLV.get());
    this.wcG = new a()
    {
      public final void Ji(String paramAnonymousString)
      {
        GMTrace.i(14495917277184L, 108003);
        com.tencent.mm.pluginsdk.l.a.a.bDB();
        ap.yY();
        com.tencent.mm.u.c.wQ().b(new o(3, paramAnonymousString));
        GMTrace.o(14495917277184L, 108003);
      }
      
      public final void eV(String paramAnonymousString1, String paramAnonymousString2)
      {
        GMTrace.i(14495783059456L, 108002);
        com.tencent.mm.pluginsdk.l.a.a.bDB();
        ap.yY();
        com.tencent.mm.u.c.wQ().b(new o(2, paramAnonymousString1));
        v.d("MicroMsg.ADBanner", "jump to " + paramAnonymousString2);
        l.a.szU.a((Context)a.this.sLV.get(), paramAnonymousString2, true);
        GMTrace.o(14495783059456L, 108002);
      }
    };
    com.tencent.mm.pluginsdk.l.a.a locala = com.tencent.mm.pluginsdk.l.a.a.dB(aa.getContext());
    if (this.wcD != null)
    {
      if (locala != null)
      {
        this.wcD.wcI = locala;
        this.wcD.OL();
        if ((this.wcD != null) && (this.wcD.getCount() > 0) && (this.wcD.BL(0).a(this.wcF) == 0)) {}
        for (int i = 1; i != 0; i = 0)
        {
          v.i("MicroMsg.ADBanner", "refreshAndReturnIsVisible[true]");
          setVisibility(0);
          GMTrace.o(14495514624000L, 108000);
          return true;
        }
      }
      setVisibility(8);
    }
    setVisibility(8);
    GMTrace.o(14495514624000L, 108000);
    return false;
  }
  
  public final void destroy()
  {
    GMTrace.i(14495111970816L, 107997);
    ap.yY();
    com.tencent.mm.u.c.vr().b(this.wcD);
    GMTrace.o(14495111970816L, 107997);
  }
  
  public final int getLayoutId()
  {
    GMTrace.i(14494977753088L, 107996);
    int i = R.i.cTz;
    GMTrace.o(14494977753088L, 107996);
    return i;
  }
  
  public final void release()
  {
    GMTrace.i(14495380406272L, 107999);
    this.wcD = null;
    GMTrace.o(14495380406272L, 107999);
  }
  
  public final void setVisibility(int paramInt)
  {
    GMTrace.i(14495246188544L, 107998);
    if (this.jHa != null) {
      this.jHa.setVisibility(paramInt);
    }
    GMTrace.o(14495246188544L, 107998);
  }
  
  public static abstract interface a
  {
    public abstract void Ji(String paramString);
    
    public abstract void eV(String paramString1, String paramString2);
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/ui/conversation/a/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */