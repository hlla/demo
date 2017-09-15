package com.tencent.mm.pluginsdk.ui.tools;

import android.app.Activity;
import android.view.KeyEvent;
import android.view.Menu;
import com.tencent.gmtrace.GMTrace;
import com.tencent.mm.aw.e.a;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.pluginsdk.ui.VoiceSearchLayout;
import com.tencent.mm.pluginsdk.ui.VoiceSearchLayout.4;
import com.tencent.mm.pluginsdk.ui.VoiceSearchLayout.a;
import com.tencent.mm.sdk.platformtools.aa;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.ui.tools.f;
import com.tencent.mm.ui.tools.p.b;

public final class p
  extends com.tencent.mm.ui.tools.p
{
  private VoiceSearchLayout pdQ;
  public boolean sVU;
  public int sVV;
  public int sVW;
  public a sVX;
  private VoiceSearchLayout.a sVY;
  
  public p()
  {
    GMTrace.i(1102732853248L, 8216);
    this.sVU = true;
    this.sVY = new VoiceSearchLayout.a()
    {
      public final void a(boolean paramAnonymousBoolean, String[] paramAnonymousArrayOfString, long paramAnonymousLong)
      {
        GMTrace.i(1130113269760L, 8420);
        v.d("MicroMsg.VoiceSearchViewHelper", "on voice search return, success %B, voice id %d", new Object[] { Boolean.valueOf(paramAnonymousBoolean), Long.valueOf(paramAnonymousLong) });
        if (p.this.sVX != null) {
          p.this.sVX.a(paramAnonymousBoolean, paramAnonymousArrayOfString, paramAnonymousLong, p.this.sVW);
        }
        GMTrace.o(1130113269760L, 8420);
      }
      
      public final void bEJ()
      {
        GMTrace.i(1129844834304L, 8418);
        if ((com.tencent.mm.n.a.aJ(aa.getContext())) || (com.tencent.mm.n.a.aH(aa.getContext())))
        {
          GMTrace.o(1129844834304L, 8418);
          return;
        }
        v.d("MicroMsg.VoiceSearchViewHelper", "on voice search start");
        g.oSF.i(10453, new Object[] { Integer.valueOf(p.this.sVV), Integer.valueOf(3) });
        if (p.this.sVX != null) {
          p.this.sVX.aed();
        }
        GMTrace.o(1129844834304L, 8418);
      }
      
      public final void bEK()
      {
        GMTrace.i(1129979052032L, 8419);
        v.d("MicroMsg.VoiceSearchViewHelper", "on voice search cancel");
        g.oSF.i(10453, new Object[] { Integer.valueOf(p.this.sVV), Integer.valueOf(4) });
        if (p.this.wlX != null)
        {
          p.this.wlX.lC(true);
          p.this.wlX.lD(true);
        }
        if (p.this.sVX != null) {
          p.this.sVX.aee();
        }
        GMTrace.o(1129979052032L, 8419);
      }
    };
    GMTrace.o(1102732853248L, 8216);
  }
  
  public p(byte paramByte)
  {
    super(true, true);
    GMTrace.i(1102867070976L, 8217);
    this.sVU = true;
    this.sVY = new VoiceSearchLayout.a()
    {
      public final void a(boolean paramAnonymousBoolean, String[] paramAnonymousArrayOfString, long paramAnonymousLong)
      {
        GMTrace.i(1130113269760L, 8420);
        v.d("MicroMsg.VoiceSearchViewHelper", "on voice search return, success %B, voice id %d", new Object[] { Boolean.valueOf(paramAnonymousBoolean), Long.valueOf(paramAnonymousLong) });
        if (p.this.sVX != null) {
          p.this.sVX.a(paramAnonymousBoolean, paramAnonymousArrayOfString, paramAnonymousLong, p.this.sVW);
        }
        GMTrace.o(1130113269760L, 8420);
      }
      
      public final void bEJ()
      {
        GMTrace.i(1129844834304L, 8418);
        if ((com.tencent.mm.n.a.aJ(aa.getContext())) || (com.tencent.mm.n.a.aH(aa.getContext())))
        {
          GMTrace.o(1129844834304L, 8418);
          return;
        }
        v.d("MicroMsg.VoiceSearchViewHelper", "on voice search start");
        g.oSF.i(10453, new Object[] { Integer.valueOf(p.this.sVV), Integer.valueOf(3) });
        if (p.this.sVX != null) {
          p.this.sVX.aed();
        }
        GMTrace.o(1129844834304L, 8418);
      }
      
      public final void bEK()
      {
        GMTrace.i(1129979052032L, 8419);
        v.d("MicroMsg.VoiceSearchViewHelper", "on voice search cancel");
        g.oSF.i(10453, new Object[] { Integer.valueOf(p.this.sVV), Integer.valueOf(4) });
        if (p.this.wlX != null)
        {
          p.this.wlX.lC(true);
          p.this.wlX.lD(true);
        }
        if (p.this.sVX != null) {
          p.this.sVX.aee();
        }
        GMTrace.o(1129979052032L, 8419);
      }
    };
    GMTrace.o(1102867070976L, 8217);
  }
  
  public final void a(Activity paramActivity, Menu paramMenu)
  {
    GMTrace.i(1103672377344L, 8223);
    super.a(paramActivity, paramMenu);
    if (this.pdQ != null) {
      this.pdQ.sJQ = this.sVY;
    }
    GMTrace.o(1103672377344L, 8223);
  }
  
  public final void a(a parama)
  {
    GMTrace.i(1103001288704L, 8218);
    this.sVX = parama;
    this.wlY = parama;
    GMTrace.o(1103001288704L, 8218);
  }
  
  protected final boolean bGA()
  {
    boolean bool1 = false;
    GMTrace.i(1103403941888L, 8221);
    boolean bool2 = this.sVU;
    if (this.pdQ == null) {
      bool1 = true;
    }
    v.d("MicroMsg.VoiceSearchViewHelper", "check has voice search, Enable %B, layout is null ? %B", new Object[] { Boolean.valueOf(bool2), Boolean.valueOf(bool1) });
    bool1 = this.sVU;
    GMTrace.o(1103403941888L, 8221);
    return bool1;
  }
  
  protected final void bGB()
  {
    GMTrace.i(1103538159616L, 8222);
    v.d("MicroMsg.VoiceSearchViewHelper", "do require voice search");
    if (this.wlX != null)
    {
      this.wlX.lC(false);
      this.wlX.lD(false);
    }
    if ((this.pdQ != null) && (this.pdQ.getVisibility() == 8))
    {
      v.d("MicroMsg.VoiceSearchViewHelper", "do voice search layout start");
      Object localObject = this.pdQ;
      int i = this.sVW;
      boolean bool = com.tencent.mm.pluginsdk.i.a.aS(((VoiceSearchLayout)localObject).getContext(), "android.permission.RECORD_AUDIO");
      v.i("MicroMsg.VoiceSearchLayout", "summerper checkPermission checkMicrophone[%b]", new Object[] { Boolean.valueOf(bool) });
      if (bool)
      {
        v.d("MicroMsg.VoiceSearchLayout", "doStart " + ((VoiceSearchLayout)localObject).fOM);
        ((VoiceSearchLayout)localObject).sJT = i;
        ((VoiceSearchLayout)localObject).fOM = true;
        ((VoiceSearchLayout)localObject).sJS = false;
        if (((VoiceSearchLayout)localObject).sJQ != null) {
          ((VoiceSearchLayout)localObject).sJQ.bEJ();
        }
        ((VoiceSearchLayout)localObject).setVisibility(0);
        ((VoiceSearchLayout)localObject).jXi.v(50L, 50L);
        ((VoiceSearchLayout)localObject).a(true, null);
        ((VoiceSearchLayout)localObject).sKd = 0;
        ((VoiceSearchLayout)localObject).sJX = new com.tencent.mm.aw.e(new VoiceSearchLayout.4((VoiceSearchLayout)localObject), i);
        localObject = ((VoiceSearchLayout)localObject).sJX;
        v.i("MicroMsg.SceneVoiceAddr", "start record");
        if ((((com.tencent.mm.aw.e)localObject).ict == 0) && (al.is2G(aa.getContext()))) {}
        for (bool = true;; bool = false)
        {
          ((com.tencent.mm.aw.e)localObject).icE = bool;
          v.i("MicroMsg.SceneVoiceAddr", "mEnableAmrMode: %b", new Object[] { Boolean.valueOf(((com.tencent.mm.aw.e)localObject).icE) });
          com.tencent.mm.sdk.f.e.post(new e.a((com.tencent.mm.aw.e)localObject), "SceneVoiceAddr_record");
          GMTrace.o(1103538159616L, 8222);
          return;
        }
      }
      if ((((VoiceSearchLayout)localObject).getContext() instanceof Activity)) {
        com.tencent.mm.pluginsdk.i.a.d((Activity)((VoiceSearchLayout)localObject).getContext(), "android.permission.RECORD_AUDIO");
      }
      GMTrace.o(1103538159616L, 8222);
      return;
    }
    GMTrace.o(1103538159616L, 8222);
  }
  
  protected final void bGC()
  {
    GMTrace.i(1103940812800L, 8225);
    cancel();
    GMTrace.o(1103940812800L, 8225);
  }
  
  public final void cancel()
  {
    GMTrace.i(1103269724160L, 8220);
    v.d("MicroMsg.VoiceSearchViewHelper", "do cancel");
    if (this.pdQ != null) {
      this.pdQ.bEt();
    }
    if (this.wlX != null)
    {
      this.wlX.lC(true);
      this.wlX.lD(true);
    }
    GMTrace.o(1103269724160L, 8220);
  }
  
  public final void o(VoiceSearchLayout paramVoiceSearchLayout)
  {
    GMTrace.i(1103135506432L, 8219);
    this.pdQ = paramVoiceSearchLayout;
    this.sVW = 1;
    if (1 == this.sVW)
    {
      this.sVV = 2;
      GMTrace.o(1103135506432L, 8219);
      return;
    }
    this.sVV = 1;
    GMTrace.o(1103135506432L, 8219);
  }
  
  public final boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    GMTrace.i(1103806595072L, 8224);
    if (4 == paramInt)
    {
      if ((this.pdQ != null) && (this.pdQ.getVisibility() == 0)) {}
      for (bool = true;; bool = false)
      {
        v.d("MicroMsg.VoiceSearchViewHelper", "on back key down, try hide voice search panel, it is visiable[%B]", new Object[] { Boolean.valueOf(bool) });
        cancel();
        if (!bool) {
          break;
        }
        GMTrace.o(1103806595072L, 8224);
        return true;
      }
    }
    v.d("MicroMsg.VoiceSearchViewHelper", "not match key code, pass to super");
    boolean bool = super.onKeyDown(paramInt, paramKeyEvent);
    GMTrace.o(1103806595072L, 8224);
    return bool;
  }
  
  public static abstract interface a
    extends p.b
  {
    public abstract void a(boolean paramBoolean, String[] paramArrayOfString, long paramLong, int paramInt);
    
    public abstract void aed();
    
    public abstract void aee();
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/pluginsdk/ui/tools/p.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */