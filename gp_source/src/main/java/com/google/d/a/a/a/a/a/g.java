package com.google.d.a.a.a.a.a;

import android.content.Context;
import android.content.ContextWrapper;
import android.content.res.AssetManager;
import android.content.res.Resources;
import android.content.res.Resources.Theme;

public final class g
  extends ContextWrapper
{
  public g(Context paramContext)
  {
    super(paramContext);
  }
  
  public final AssetManager getAssets()
  {
    return d.c(this);
  }
  
  public final Resources getResources()
  {
    return d.b(this);
  }
  
  public final Resources.Theme getTheme()
  {
    return d.d(this);
  }
  
  public final void setTheme(int paramInt)
  {
    d.a(this, paramInt);
  }
}


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/com/google/d/a/a/a/a/a/g.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */