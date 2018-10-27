package com.google.android.gms.ads.internal.webview;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.MutableContextWrapper;
import android.content.res.AssetManager;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.content.res.Resources.Theme;
import android.os.Build.VERSION;
import com.google.android.gms.ads.internal.q.a.a;
import com.google.d.a.a.a.a.a.d;
import com.google.d.a.a.a.a.a.g;

@a
public final class at
  extends MutableContextWrapper
{
  public Activity a;
  public Context b;
  private Context c;
  
  public at(Context paramContext)
  {
    super(paramContext);
    setBaseContext(paramContext);
  }
  
  public final Context createConfigurationContext(Configuration paramConfiguration)
  {
    if (Build.VERSION.SDK_INT >= 17) {
      return new g(super.createConfigurationContext(paramConfiguration));
    }
    return null;
  }
  
  public final AssetManager getAssets()
  {
    return d.c(this);
  }
  
  public final Resources getResources()
  {
    return d.b(this);
  }
  
  public final Object getSystemService(String paramString)
  {
    return this.b.getSystemService(paramString);
  }
  
  public final Resources.Theme getTheme()
  {
    return d.d(this);
  }
  
  public final void setBaseContext(Context paramContext)
  {
    this.c = paramContext.getApplicationContext();
    if ((paramContext instanceof Activity)) {}
    for (Activity localActivity = (Activity)paramContext;; localActivity = null)
    {
      this.a = localActivity;
      this.b = paramContext;
      super.setBaseContext(this.c);
      return;
    }
  }
  
  public final void setTheme(int paramInt)
  {
    super.setTheme(paramInt);
    d.a(this, paramInt);
  }
  
  public final void startActivity(Intent paramIntent)
  {
    Activity localActivity = this.a;
    if (localActivity != null)
    {
      localActivity.startActivity(paramIntent);
      return;
    }
    paramIntent.setFlags(268435456);
    this.c.startActivity(paramIntent);
  }
}


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/com/google/android/gms/ads/internal/webview/at.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */