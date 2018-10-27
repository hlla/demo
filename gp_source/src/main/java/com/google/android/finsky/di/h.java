package com.google.android.finsky.di;

import android.content.pm.IPackageStatsObserver.Stub;
import android.content.pm.PackageStats;
import android.os.Handler;

final class h
  extends IPackageStatsObserver.Stub
{
  h(a parama, j paramj, String paramString) {}
  
  public final void onGetStatsCompleted(PackageStats paramPackageStats, boolean paramBoolean)
  {
    this.a.f.post(new i(paramPackageStats, paramBoolean, this.b, this.c));
  }
}


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/com/google/android/finsky/di/h.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */