package com.google.android.finsky.w;

import android.content.Context;
import android.content.res.AssetManager;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.content.res.Resources.Theme;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.preference.PreferenceActivity;
import android.support.v7.app.z;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import com.google.d.a.a.a.a.a.d;
import com.google.d.a.a.a.a.a.g;

public class a
  extends PreferenceActivity
{
  private z a;
  
  public void addContentView(View paramView, ViewGroup.LayoutParams paramLayoutParams)
  {
    f().b(paramView, paramLayoutParams);
  }
  
  public Context createConfigurationContext(Configuration paramConfiguration)
  {
    if (Build.VERSION.SDK_INT >= 17) {
      return new g(super.createConfigurationContext(paramConfiguration));
    }
    return null;
  }
  
  public final z f()
  {
    if (this.a == null) {
      this.a = z.a(this, null);
    }
    return this.a;
  }
  
  public void g()
  {
    onBackPressed();
  }
  
  public AssetManager getAssets()
  {
    return d.c(this);
  }
  
  public MenuInflater getMenuInflater()
  {
    return f().b();
  }
  
  public Resources getResources()
  {
    return d.b(this);
  }
  
  public Theme getTheme()
  {
    return d.d(this);
  }
  
  public void invalidateOptionsMenu()
  {
    f().h();
  }
  
  protected boolean isValidFragment(String paramString)
  {
    return false;
  }
  
  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    super.onConfigurationChanged(paramConfiguration);
    f().d();
  }
  
  public void onCreate(Bundle paramBundle)
  {
    f().k();
    f().a(paramBundle);
    super.onCreate(paramBundle);
    f().a().a(true);
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    f().i();
  }
  
  public boolean onOptionsItemSelected(MenuItem paramMenuItem)
  {
    switch (paramMenuItem.getItemId())
    {
    default: 
      return super.onOptionsItemSelected(paramMenuItem);
    }
    g();
    return true;
  }
  
  protected void onPostCreate(Bundle paramBundle)
  {
    super.onPostCreate(paramBundle);
    f().c();
  }
  
  protected void onPostResume()
  {
    super.onPostResume();
    f().g();
  }
  
  protected void onStop()
  {
    super.onStop();
    f().f();
  }
  
  protected void onTitleChanged(CharSequence paramCharSequence, int paramInt)
  {
    super.onTitleChanged(paramCharSequence, paramInt);
    f().a(paramCharSequence);
  }
  
  public void setContentView(int paramInt)
  {
    f().b(paramInt);
  }
  
  public void setContentView(View paramView)
  {
    f().a(paramView);
  }
  
  public void setContentView(View paramView, ViewGroup.LayoutParams paramLayoutParams)
  {
    f().a(paramView, paramLayoutParams);
  }
  
  public void setTheme(int paramInt)
  {
    super.setTheme(paramInt);
    d.a(this, paramInt);
  }
}


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/com/google/android/finsky/w/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */