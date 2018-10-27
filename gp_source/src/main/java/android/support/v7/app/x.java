package android.support.v7.app;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.support.v4.app.ca;
import android.support.v4.app.cq;
import android.support.v4.app.cr;
import android.support.v4.app.cs;
import android.support.v4.app.o;
import android.support.v7.view.b;
import android.support.v7.widget.Toolbar;
import android.support.v7.widget.hv;
import android.util.DisplayMetrics;
import android.view.KeyEvent;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.view.Window;

public class x
  extends o
  implements cs, g, y
{
  private z e;
  private Resources f;
  private int g = 0;
  
  private final boolean l()
  {
    Intent localIntent = ca.a(this);
    if (localIntent != null)
    {
      if (!shouldUpRecreateTask(localIntent))
      {
        navigateUpTo(localIntent);
        return true;
      }
      cr localcr = cr.a(this);
      if ((this instanceof cs)) {}
      Object localObject;
      for (localIntent = ((cs)this).d_();; localObject = null)
      {
        if (localIntent == null) {
          localIntent = ca.a(this);
        }
        for (;;)
        {
          if (localIntent != null)
          {
            ComponentName localComponentName2 = localIntent.getComponent();
            ComponentName localComponentName1 = localComponentName2;
            if (localComponentName2 == null) {
              localComponentName1 = localIntent.resolveActivity(localcr.a.getPackageManager());
            }
            localcr.a(localComponentName1);
            localcr.a(localIntent);
          }
          localcr.a();
          try
          {
            android.support.v4.app.a.a(this);
          }
          catch (IllegalStateException localIllegalStateException)
          {
            finish();
          }
          break;
        }
      }
    }
    return false;
  }
  
  public final void K_() {}
  
  public final b L_()
  {
    return null;
  }
  
  public final f M_()
  {
    return N_().j();
  }
  
  public final z N_()
  {
    if (this.e == null) {
      this.e = z.a(this, this);
    }
    return this.e;
  }
  
  public final void a(Toolbar paramToolbar)
  {
    N_().a(paramToolbar);
  }
  
  public void addContentView(View paramView, ViewGroup.LayoutParams paramLayoutParams)
  {
    N_().b(paramView, paramLayoutParams);
  }
  
  public void closeOptionsMenu()
  {
    a locala = N_().a();
    if ((getWindow().hasFeature(0)) && ((locala == null) || (!locala.j()))) {
      super.closeOptionsMenu();
    }
  }
  
  public final Intent d_()
  {
    return ca.a(this);
  }
  
  public boolean dispatchKeyEvent(KeyEvent paramKeyEvent)
  {
    int i = paramKeyEvent.getKeyCode();
    a locala = N_().a();
    if ((i != 82) || (locala == null) || (!locala.a(paramKeyEvent))) {
      return super.dispatchKeyEvent(paramKeyEvent);
    }
    return true;
  }
  
  public View findViewById(int paramInt)
  {
    return N_().a(paramInt);
  }
  
  public MenuInflater getMenuInflater()
  {
    return N_().b();
  }
  
  public Resources getResources()
  {
    if ((this.f == null) && (hv.a())) {
      this.f = new hv(this, super.getResources());
    }
    Resources localResources2 = this.f;
    Resources localResources1 = localResources2;
    if (localResources2 == null) {
      localResources1 = super.getResources();
    }
    return localResources1;
  }
  
  public final void i() {}
  
  public void invalidateOptionsMenu()
  {
    N_().h();
  }
  
  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    super.onConfigurationChanged(paramConfiguration);
    N_().d();
    if (this.f != null)
    {
      DisplayMetrics localDisplayMetrics = super.getResources().getDisplayMetrics();
      this.f.updateConfiguration(paramConfiguration, localDisplayMetrics);
    }
  }
  
  public void onContentChanged() {}
  
  public void onCreate(Bundle paramBundle)
  {
    z localz = N_();
    localz.k();
    localz.a(paramBundle);
    if ((localz.l()) && (this.g != 0))
    {
      if (Build.VERSION.SDK_INT < 23) {
        break label55;
      }
      onApplyThemeResource(getTheme(), this.g, false);
    }
    for (;;)
    {
      super.onCreate(paramBundle);
      return;
      label55:
      setTheme(this.g);
    }
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    N_().i();
  }
  
  public boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    if ((Build.VERSION.SDK_INT < 26) && (!paramKeyEvent.isCtrlPressed()) && (!KeyEvent.metaStateHasNoModifiers(paramKeyEvent.getMetaState())) && (paramKeyEvent.getRepeatCount() == 0) && (!KeyEvent.isModifierKey(paramKeyEvent.getKeyCode())))
    {
      Window localWindow = getWindow();
      if ((localWindow != null) && (localWindow.getDecorView() != null) && (localWindow.getDecorView().dispatchKeyShortcutEvent(paramKeyEvent))) {
        return true;
      }
    }
    return super.onKeyDown(paramInt, paramKeyEvent);
  }
  
  public final boolean onMenuItemSelected(int paramInt, MenuItem paramMenuItem)
  {
    if (!super.onMenuItemSelected(paramInt, paramMenuItem))
    {
      a locala = N_().a();
      if ((paramMenuItem.getItemId() == 16908332) && (locala != null) && ((locala.b() & 0x4) != 0)) {
        return l();
      }
      return false;
    }
    return true;
  }
  
  public void onPostCreate(Bundle paramBundle)
  {
    super.onPostCreate(paramBundle);
    N_().c();
  }
  
  public void onPostResume()
  {
    super.onPostResume();
    N_().g();
  }
  
  public void onSaveInstanceState(Bundle paramBundle)
  {
    super.onSaveInstanceState(paramBundle);
    N_().b(paramBundle);
  }
  
  public void onStart()
  {
    super.onStart();
    N_().e();
  }
  
  public void onStop()
  {
    super.onStop();
    N_().f();
  }
  
  protected void onTitleChanged(CharSequence paramCharSequence, int paramInt)
  {
    super.onTitleChanged(paramCharSequence, paramInt);
    N_().a(paramCharSequence);
  }
  
  public void openOptionsMenu()
  {
    a locala = N_().a();
    if ((getWindow().hasFeature(0)) && ((locala == null) || (!locala.i()))) {
      super.openOptionsMenu();
    }
  }
  
  public void setContentView(int paramInt)
  {
    N_().b(paramInt);
  }
  
  public void setContentView(View paramView)
  {
    N_().a(paramView);
  }
  
  public void setContentView(View paramView, ViewGroup.LayoutParams paramLayoutParams)
  {
    N_().a(paramView, paramLayoutParams);
  }
  
  public void setTheme(int paramInt)
  {
    super.setTheme(paramInt);
    this.g = paramInt;
  }
  
  public final void u_()
  {
    N_().h();
  }
}


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/android/support/v7/app/x.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */