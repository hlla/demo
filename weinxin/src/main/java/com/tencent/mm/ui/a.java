package com.tencent.mm.ui;

import android.os.Bundle;
import android.view.KeyEvent;
import com.tencent.gmtrace.GMTrace;
import com.tencent.mm.sdk.platformtools.v;

public abstract class a
  extends com.tencent.mm.ui.base.preference.i
  implements i
{
  private Bundle qwt;
  private boolean uMd;
  private boolean uMe;
  private boolean uMf;
  private boolean uMg;
  protected boolean uMh;
  protected boolean uMi;
  protected boolean uMj;
  
  public a()
  {
    GMTrace.i(2071919067136L, 15437);
    this.uMh = false;
    this.uMi = false;
    GMTrace.o(2071919067136L, 15437);
  }
  
  protected abstract void bOb();
  
  protected abstract void bOc();
  
  protected abstract void bOd();
  
  protected abstract void bOe();
  
  protected abstract void bOf();
  
  protected abstract void bOg();
  
  public final void bOk()
  {
    GMTrace.i(2073261244416L, 15447);
    bOi();
    this.uMf = true;
    GMTrace.o(2073261244416L, 15447);
  }
  
  public final void bOm()
  {
    GMTrace.i(2073529679872L, 15449);
    this.uMi = true;
    GMTrace.o(2073529679872L, 15449);
  }
  
  public final void bOn()
  {
    GMTrace.i(2073395462144L, 15448);
    if (!this.uMh)
    {
      GMTrace.o(2073395462144L, 15448);
      return;
    }
    if (this.uMe)
    {
      bOb();
      this.uMe = false;
    }
    for (;;)
    {
      long l = System.currentTimeMillis();
      if (this.uMf)
      {
        bOj();
        this.uMf = false;
      }
      bOc();
      v.d("MicroMsg.INIT", "KEVIN " + toString() + " OnTabResume last : " + (System.currentTimeMillis() - l));
      this.uMg = true;
      this.uMh = false;
      GMTrace.o(2073395462144L, 15448);
      return;
      if (this.uMd)
      {
        bOg();
        bOb();
        v.v("MicroMsg.INIT", "KEVIN tab onRecreate ");
        this.uMd = false;
      }
    }
  }
  
  public void onActivityCreated(Bundle paramBundle)
  {
    GMTrace.i(2072858591232L, 15444);
    super.onActivityCreated(paramBundle);
    this.qwt = paramBundle;
    this.uMe = true;
    GMTrace.o(2072858591232L, 15444);
  }
  
  public void onDestroy()
  {
    GMTrace.i(2074066550784L, 15453);
    bOg();
    super.onDestroy();
    GMTrace.o(2074066550784L, 15453);
  }
  
  public final boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    GMTrace.i(2072992808960L, 15445);
    if ((paramInt == 4) && (paramKeyEvent.getAction() == 0))
    {
      GMTrace.o(2072992808960L, 15445);
      return false;
    }
    boolean bool = super.onKeyDown(paramInt, paramKeyEvent);
    GMTrace.o(2072992808960L, 15445);
    return bool;
  }
  
  public final void onPause()
  {
    GMTrace.i(2073663897600L, 15450);
    super.onPause();
    this.uMj = true;
    if (this.uMj)
    {
      if (!this.uMg)
      {
        this.uMj = false;
        GMTrace.o(2073663897600L, 15450);
        return;
      }
      long l = System.currentTimeMillis();
      bOe();
      v.d("MicroMsg.INIT", "KEVIN " + toString() + " onTabPause last : " + (System.currentTimeMillis() - l));
      this.uMg = false;
      this.uMj = false;
    }
    GMTrace.o(2073663897600L, 15450);
  }
  
  public final void onResume()
  {
    GMTrace.i(2073127026688L, 15446);
    super.onResume();
    bOl();
    LauncherUI localLauncherUI = LauncherUI.bPy();
    if ((localLauncherUI == null) || (!localLauncherUI.uQb))
    {
      GMTrace.o(2073127026688L, 15446);
      return;
    }
    this.uMh = true;
    if (this.uMi)
    {
      bOn();
      this.uMi = false;
    }
    GMTrace.o(2073127026688L, 15446);
  }
  
  public final void onStart()
  {
    GMTrace.i(2073932333056L, 15452);
    super.onStart();
    LauncherUI localLauncherUI = LauncherUI.bPy();
    if ((localLauncherUI == null) || (!localLauncherUI.uQb))
    {
      GMTrace.o(2073932333056L, 15452);
      return;
    }
    bOd();
    GMTrace.o(2073932333056L, 15452);
  }
  
  public final void onStop()
  {
    GMTrace.i(2073798115328L, 15451);
    super.onStop();
    bOf();
    GMTrace.o(2073798115328L, 15451);
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/ui/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */