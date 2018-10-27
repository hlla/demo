package com.google.android.finsky.g;

import android.annotation.TargetApi;
import android.app.backup.BackupManager;
import com.google.android.finsky.utils.FinskyLog;

@TargetApi(26)
public final class a
  implements c
{
  private final BackupManager a;
  
  public a(BackupManager paramBackupManager)
  {
    this.a = paramBackupManager;
  }
  
  public final void a(String[] paramArrayOfString, e parame)
  {
    int j;
    int i;
    try
    {
      this.a.requestBackup(paramArrayOfString, new b(parame));
      return;
    }
    catch (SecurityException localSecurityException)
    {
      FinskyLog.a("Could not request backups, android.permission.BACKUP permission not granted: %s", new Object[] { localSecurityException });
      j = paramArrayOfString.length;
      i = 0;
    }
    while (i < j)
    {
      parame.b(paramArrayOfString[i]);
      i += 1;
    }
  }
}


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/com/google/android/finsky/g/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */