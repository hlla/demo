package com.google.android.finsky.g;

import android.app.backup.BackupObserver;
import com.google.android.finsky.utils.FinskyLog;

final class b
  extends BackupObserver
{
  b(e parame) {}
  
  public final void onResult(String paramString, int paramInt)
  {
    FinskyLog.a("backup done for package %s with status %d", new Object[] { paramString, Integer.valueOf(paramInt) });
    this.a.a(paramString);
  }
}


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/com/google/android/finsky/g/b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */