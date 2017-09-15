package com.tencent.mm.ui;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.KeyEvent;
import com.tencent.gmtrace.GMTrace;
import com.tencent.mm.sdk.platformtools.v;

public abstract class AbstractTabChildActivity
  extends ActionBarActivity
{
  public AbstractTabChildActivity()
  {
    GMTrace.i(3464427995136L, 25812);
    GMTrace.o(3464427995136L, 25812);
  }
  
  public static abstract class a
    extends q
    implements i
  {
    private Bundle qwt;
    private boolean uMd;
    private boolean uMe;
    private boolean uMf;
    protected boolean uMg;
    protected boolean uMh;
    protected boolean uMi;
    protected boolean uMj;
    protected boolean uMk;
    
    public a()
    {
      GMTrace.i(3089960534016L, 23022);
      this.uMh = false;
      this.uMi = false;
      this.uMk = false;
      GMTrace.o(3089960534016L, 23022);
    }
    
    public abstract void bOb();
    
    public abstract void bOc();
    
    public abstract void bOd();
    
    public abstract void bOe();
    
    public abstract void bOf();
    
    public abstract void bOg();
    
    public abstract void bOh();
    
    public abstract void bOi();
    
    public abstract void bOj();
    
    public final void bOk()
    {
      GMTrace.i(3091705364480L, 23035);
      bOi();
      this.uMf = true;
      GMTrace.o(3091705364480L, 23035);
    }
    
    public final void bOl()
    {
      GMTrace.i(15337999302656L, 114277);
      GMTrace.o(15337999302656L, 114277);
    }
    
    public final void bOm()
    {
      GMTrace.i(3092242235392L, 23039);
      this.uMi = true;
      GMTrace.o(3092242235392L, 23039);
    }
    
    public final void bOn()
    {
      GMTrace.i(3092510670848L, 23041);
      if (!this.uMh)
      {
        GMTrace.o(3092510670848L, 23041);
        return;
      }
      if (this.uMe)
      {
        bOb();
        this.uMe = false;
      }
      for (;;)
      {
        this.uMk = true;
        long l = System.currentTimeMillis();
        if (this.uMf)
        {
          this.uMf = false;
          bOj();
        }
        bOc();
        v.d("MicroMsg.INIT", "KEVIN " + toString() + " OnTabResume last : " + (System.currentTimeMillis() - l));
        this.uMg = true;
        this.uMh = false;
        GMTrace.o(3092510670848L, 23041);
        return;
        if (this.uMd)
        {
          if (this.uMk) {
            bOg();
          }
          bOb();
          v.v("MicroMsg.INIT", "KEVIN tab onRecreate " + toString());
          this.uMd = false;
        }
      }
    }
    
    public boolean bin()
    {
      GMTrace.i(3093047541760L, 23045);
      GMTrace.o(3093047541760L, 23045);
      return false;
    }
    
    public int getLayoutId()
    {
      GMTrace.i(3090363187200L, 23025);
      GMTrace.o(3090363187200L, 23025);
      return 0;
    }
    
    public final void onActivityCreated(Bundle paramBundle)
    {
      GMTrace.i(3090228969472L, 23024);
      super.onActivityCreated(paramBundle);
      this.uMe = true;
      this.qwt = paramBundle;
      GMTrace.o(3090228969472L, 23024);
    }
    
    public void onDestroy()
    {
      GMTrace.i(3092913324032L, 23044);
      if (this.uMk) {
        bOg();
      }
      super.onDestroy();
      GMTrace.o(3092913324032L, 23044);
    }
    
    public final boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent)
    {
      GMTrace.i(3091839582208L, 23036);
      if ((paramInt == 4) && (paramKeyEvent.getAction() == 0))
      {
        GMTrace.o(3091839582208L, 23036);
        return false;
      }
      boolean bool = super.onKeyDown(paramInt, paramKeyEvent);
      GMTrace.o(3091839582208L, 23036);
      return bool;
    }
    
    public void onPause()
    {
      GMTrace.i(3092376453120L, 23040);
      super.onPause();
      this.uMj = true;
      if (this.uMj)
      {
        if (!this.uMg)
        {
          this.uMj = false;
          GMTrace.o(3092376453120L, 23040);
          return;
        }
        long l = System.currentTimeMillis();
        bOe();
        v.d("MicroMsg.INIT", "KEVIN " + toString() + " onTabPause last : " + (System.currentTimeMillis() - l));
        this.uMg = false;
        this.uMj = false;
      }
      GMTrace.o(3092376453120L, 23040);
    }
    
    public void onResume()
    {
      GMTrace.i(3092108017664L, 23038);
      super.onResume();
      LauncherUI localLauncherUI = LauncherUI.bPy();
      if ((localLauncherUI == null) || (!localLauncherUI.uQb))
      {
        GMTrace.o(3092108017664L, 23038);
        return;
      }
      this.uMh = true;
      if (this.uMi)
      {
        bOn();
        this.uMi = false;
      }
      GMTrace.o(3092108017664L, 23038);
    }
    
    public final void onStart()
    {
      GMTrace.i(3092779106304L, 23043);
      super.onStart();
      LauncherUI localLauncherUI = LauncherUI.bPy();
      if ((localLauncherUI == null) || (!localLauncherUI.uQb))
      {
        GMTrace.o(3092779106304L, 23043);
        return;
      }
      bOd();
      GMTrace.o(3092779106304L, 23043);
    }
    
    public final void onStop()
    {
      GMTrace.i(3092644888576L, 23042);
      super.onStop();
      bOf();
      GMTrace.o(3092644888576L, 23042);
    }
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/ui/AbstractTabChildActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */