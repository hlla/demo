package android.support.v7.app;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.am;
import android.support.v4.app.am.a;
import android.support.v4.app.u;
import android.support.v4.view.g;
import android.support.v7.widget.ar;
import android.util.DisplayMetrics;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import java.util.ArrayList;

public class AppCompatActivity
  extends FragmentActivity
  implements am.a, c
{
  private Resources Cu;
  private d Gp;
  private int Gq = 0;
  private boolean Gr;
  
  private boolean cN()
  {
    int i = 0;
    Object localObject1 = u.a(this);
    am localam;
    if (localObject1 != null) {
      if (u.a(this, (Intent)localObject1))
      {
        localam = am.j(this);
        if (!(this instanceof am.a)) {
          break label283;
        }
      }
    }
    label283:
    Object localObject2;
    for (localObject1 = ((am.a)this).bo();; localObject2 = null)
    {
      if (localObject1 == null) {
        localObject1 = u.a(this);
      }
      for (;;)
      {
        if (localObject1 != null)
        {
          ComponentName localComponentName = ((Intent)localObject1).getComponent();
          localObject3 = localComponentName;
          if (localComponentName == null) {
            localObject3 = ((Intent)localObject1).resolveActivity(localam.tk.getPackageManager());
          }
          localam.a((ComponentName)localObject3);
          localam.tj.add(localObject1);
        }
        if (localam.tj.isEmpty()) {
          throw new IllegalStateException("No intents added to TaskStackBuilder; cannot startActivities");
        }
        localObject1 = (Intent[])localam.tj.toArray(new Intent[localam.tj.size()]);
        localObject1[0] = new Intent(localObject1[0]).addFlags(268484608);
        Object localObject3 = localam.tk;
        int j = Build.VERSION.SDK_INT;
        if (j >= 16)
        {
          ((Context)localObject3).startActivities((Intent[])localObject1, null);
          i = 1;
          if (i == 0)
          {
            localObject1 = new Intent(localObject1[(localObject1.length - 1)]);
            ((Intent)localObject1).addFlags(268435456);
            localam.tk.startActivity((Intent)localObject1);
          }
        }
        for (;;)
        {
          try
          {
            if (Build.VERSION.SDK_INT >= 16)
            {
              finishAffinity();
              return true;
              if (j < 11) {
                break;
              }
              ((Context)localObject3).startActivities((Intent[])localObject1);
              i = 1;
              break;
            }
            finish();
            continue;
          }
          catch (IllegalStateException localIllegalStateException)
          {
            finish();
            continue;
          }
          u.b(this, localIllegalStateException);
        }
        return false;
      }
    }
  }
  
  public void aQ()
  {
    cO().invalidateOptionsMenu();
  }
  
  public void addContentView(View paramView, ViewGroup.LayoutParams paramLayoutParams)
  {
    cO().addContentView(paramView, paramLayoutParams);
  }
  
  public final boolean aq(int paramInt)
  {
    return cO().requestWindowFeature(paramInt);
  }
  
  public final Intent bo()
  {
    return u.a(this);
  }
  
  public final d cO()
  {
    if (this.Gp == null) {
      this.Gp = d.a(this, this);
    }
    return this.Gp;
  }
  
  public boolean dispatchKeyEvent(KeyEvent paramKeyEvent)
  {
    if ((g.a(paramKeyEvent, 4096)) && (paramKeyEvent.getUnicodeChar(paramKeyEvent.getMetaState() & 0x8FFF) == 60))
    {
      int i = paramKeyEvent.getAction();
      if (i == 0)
      {
        ActionBar localActionBar = cO().cP();
        if ((localActionBar != null) && (localActionBar.isShowing()) && (localActionBar.requestFocus()))
        {
          this.Gr = true;
          return true;
        }
      }
      else if ((i == 1) && (this.Gr))
      {
        this.Gr = false;
        return true;
      }
    }
    return super.dispatchKeyEvent(paramKeyEvent);
  }
  
  public View findViewById(int paramInt)
  {
    return cO().findViewById(paramInt);
  }
  
  public MenuInflater getMenuInflater()
  {
    return cO().getMenuInflater();
  }
  
  public Resources getResources()
  {
    if ((this.Cu == null) && (ar.hd())) {
      this.Cu = new ar(this, super.getResources());
    }
    if (this.Cu == null) {
      return super.getResources();
    }
    return this.Cu;
  }
  
  public void invalidateOptionsMenu()
  {
    cO().invalidateOptionsMenu();
  }
  
  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    super.onConfigurationChanged(paramConfiguration);
    cO().onConfigurationChanged(paramConfiguration);
    if (this.Cu != null)
    {
      DisplayMetrics localDisplayMetrics = super.getResources().getDisplayMetrics();
      this.Cu.updateConfiguration(paramConfiguration, localDisplayMetrics);
    }
  }
  
  public void onContentChanged() {}
  
  public void onCreate(Bundle paramBundle)
  {
    d locald = cO();
    locald.cR();
    locald.onCreate(paramBundle);
    if ((locald.cS()) && (this.Gq != 0))
    {
      if (Build.VERSION.SDK_INT < 23) {
        break label55;
      }
      onApplyThemeResource(getTheme(), this.Gq, false);
    }
    for (;;)
    {
      super.onCreate(paramBundle);
      return;
      label55:
      setTheme(this.Gq);
    }
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    cO().onDestroy();
  }
  
  public final boolean onMenuItemSelected(int paramInt, MenuItem paramMenuItem)
  {
    if (super.onMenuItemSelected(paramInt, paramMenuItem)) {
      return true;
    }
    ActionBar localActionBar = cO().cP();
    if ((paramMenuItem.getItemId() == 16908332) && (localActionBar != null) && ((localActionBar.getDisplayOptions() & 0x4) != 0)) {
      return cN();
    }
    return false;
  }
  
  public boolean onMenuOpened(int paramInt, Menu paramMenu)
  {
    return super.onMenuOpened(paramInt, paramMenu);
  }
  
  public void onPanelClosed(int paramInt, Menu paramMenu)
  {
    super.onPanelClosed(paramInt, paramMenu);
  }
  
  protected void onPostCreate(Bundle paramBundle)
  {
    super.onPostCreate(paramBundle);
    cO().cQ();
  }
  
  protected void onPostResume()
  {
    super.onPostResume();
    cO().onPostResume();
  }
  
  public void onSaveInstanceState(Bundle paramBundle)
  {
    super.onSaveInstanceState(paramBundle);
    cO().onSaveInstanceState(paramBundle);
  }
  
  public void onStop()
  {
    super.onStop();
    cO().onStop();
  }
  
  protected void onTitleChanged(CharSequence paramCharSequence, int paramInt)
  {
    super.onTitleChanged(paramCharSequence, paramInt);
    cO().setTitle(paramCharSequence);
  }
  
  public void setContentView(int paramInt)
  {
    cO().setContentView(paramInt);
  }
  
  public void setContentView(View paramView)
  {
    cO().setContentView(paramView);
  }
  
  public void setContentView(View paramView, ViewGroup.LayoutParams paramLayoutParams)
  {
    cO().setContentView(paramView, paramLayoutParams);
  }
  
  public void setTheme(int paramInt)
  {
    super.setTheme(paramInt);
    this.Gq = paramInt;
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/android/support/v7/app/AppCompatActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */