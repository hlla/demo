package com.tencent.mm.ui;

import android.support.v7.app.ActionBar;
import android.support.v7.view.f.a;
import android.support.v7.view.g;
import android.view.ActionMode;
import android.view.ActionMode.Callback;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import com.tencent.gmtrace.GMTrace;
import com.tencent.mm.ui.b.a;
import com.tencent.mm.ui.b.a.a;
import com.tencent.mm.ui.b.b.a;

public final class m
  extends l
  implements b.a
{
  private ActionBar Gx;
  public q uSF;
  public com.tencent.mm.ui.b.b uSG;
  
  public m()
  {
    GMTrace.i(1606317768704L, 11968);
    this.uSF = null;
    GMTrace.o(1606317768704L, 11968);
  }
  
  protected final void Sz()
  {
    GMTrace.i(1607257292800L, 11975);
    if (this.uSF != null) {
      q.Sz();
    }
    GMTrace.o(1607257292800L, 11975);
  }
  
  protected final String aFH()
  {
    GMTrace.i(1606854639616L, 11972);
    if (this.uSF != null)
    {
      String str = this.uSF.aFH();
      GMTrace.o(1606854639616L, 11972);
      return str;
    }
    GMTrace.o(1606854639616L, 11972);
    return null;
  }
  
  public final void aQ()
  {
    GMTrace.i(1607928381440L, 11980);
    this.uSG.aQ();
    GMTrace.o(1607928381440L, 11980);
  }
  
  protected final void bF(View paramView)
  {
    GMTrace.i(1606720421888L, 11971);
    if (this.uSF != null) {
      this.uSF.bF(paramView);
    }
    GMTrace.o(1606720421888L, 11971);
  }
  
  protected final boolean bPE()
  {
    GMTrace.i(1607525728256L, 11977);
    GMTrace.o(1607525728256L, 11977);
    return false;
  }
  
  protected final View bPQ()
  {
    GMTrace.i(1606988857344L, 11973);
    if (this.uSF != null)
    {
      View localView = this.uSF.bPQ();
      GMTrace.o(1606988857344L, 11973);
      return localView;
    }
    GMTrace.o(1606988857344L, 11973);
    return null;
  }
  
  public final boolean bPU()
  {
    GMTrace.i(1607794163712L, 11979);
    GMTrace.o(1607794163712L, 11979);
    return true;
  }
  
  public final void bil()
  {
    GMTrace.i(1607123075072L, 11974);
    if (this.uSF != null) {
      this.uSF.bil();
    }
    GMTrace.o(1607123075072L, 11974);
  }
  
  public final boolean c(Menu paramMenu)
  {
    GMTrace.i(1608062599168L, 11981);
    if (this.uSF != null) {
      this.uSF.onPrepareOptionsMenu(paramMenu);
    }
    GMTrace.o(1608062599168L, 11981);
    return true;
  }
  
  public final ActionBar cP()
  {
    GMTrace.i(1607659945984L, 11978);
    if (this.Gx == null) {
      this.Gx = this.uSG.bRk();
    }
    ActionBar localActionBar = this.Gx;
    GMTrace.o(1607659945984L, 11978);
    return localActionBar;
  }
  
  public final boolean d(Menu paramMenu)
  {
    GMTrace.i(1608196816896L, 11982);
    q localq = this.uSF;
    com.tencent.mm.ui.b.b localb = this.uSG;
    ActionBar localActionBar;
    if (localb.iP == null)
    {
      localActionBar = localb.cP();
      if (localActionBar == null) {
        break label73;
      }
    }
    label73:
    for (localb.iP = new g(localActionBar.getThemedContext());; localb.iP = new g(localb.qb))
    {
      localq.onCreateOptionsMenu(paramMenu, localb.iP);
      GMTrace.o(1608196816896L, 11982);
      return true;
    }
  }
  
  protected final String getClassName()
  {
    GMTrace.i(1607391510528L, 11976);
    String str = this.uSF.getClass().getName();
    GMTrace.o(1607391510528L, 11976);
    return str;
  }
  
  protected final int getLayoutId()
  {
    GMTrace.i(1606586204160L, 11970);
    if (this.uSF != null)
    {
      int i = this.uSF.getLayoutId();
      GMTrace.o(1606586204160L, 11970);
      return i;
    }
    GMTrace.o(1606586204160L, 11970);
    return -1;
  }
  
  public final boolean j(MenuItem paramMenuItem)
  {
    GMTrace.i(1608331034624L, 11983);
    boolean bool = super.onOptionsItemSelected(paramMenuItem);
    GMTrace.o(1608331034624L, 11983);
    return bool;
  }
  
  public final ActionMode startActionMode(ActionMode.Callback paramCallback)
  {
    GMTrace.i(1606451986432L, 11969);
    Object localObject = this.uSG;
    paramCallback = new f.a(((a)localObject).qb, paramCallback);
    if (((a)localObject).GP != null) {
      ((a)localObject).GP.finish();
    }
    a.a locala = new a.a((a)localObject, paramCallback);
    ActionBar localActionBar = ((a)localObject).cP();
    if (localActionBar != null) {
      ((a)localObject).GP = localActionBar.a(locala);
    }
    localObject = ((a)localObject).GP;
    if (localObject != null)
    {
      paramCallback = paramCallback.b((android.support.v7.view.b)localObject);
      GMTrace.o(1606451986432L, 11969);
      return paramCallback;
    }
    GMTrace.o(1606451986432L, 11969);
    return null;
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/ui/m.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */