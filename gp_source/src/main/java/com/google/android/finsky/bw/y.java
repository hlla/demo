package com.google.android.finsky.bw;

import android.content.Context;
import android.os.AsyncTask;

public final class y
{
  private final Context a;
  
  public y(Context paramContext)
  {
    this.a = paramContext;
  }
  
  public final AsyncTask a(String paramString, z paramz)
  {
    return new aa(this.a.getPackageManager(), paramz).execute(new String[] { paramString });
  }
}


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/com/google/android/finsky/bw/y.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */