package com.google.android.finsky.ba;

import android.annotation.TargetApi;
import android.app.Activity;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.RestrictionsManager;
import android.os.Build.VERSION;
import android.os.PersistableBundle;

public class d
{
  public Boolean a = null;
  public boolean b = false;
  private final Context c;
  private Boolean d = null;
  private final com.google.android.finsky.fc.d e;
  
  public d(Context paramContext, com.google.android.finsky.fc.d paramd)
  {
    this.c = paramContext;
    this.e = paramd;
  }
  
  /* Error */
  @TargetApi(18)
  private final boolean a()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 20	com/google/android/finsky/ba/d:d	Ljava/lang/Boolean;
    //   6: ifnonnull +36 -> 42
    //   9: aload_0
    //   10: getfield 26	com/google/android/finsky/ba/d:c	Landroid/content/Context;
    //   13: ldc 39
    //   15: invokevirtual 45	android/content/Context:getSystemService	(Ljava/lang/String;)Ljava/lang/Object;
    //   18: checkcast 47	android/app/admin/DevicePolicyManager
    //   21: astore_2
    //   22: aload_0
    //   23: aload_2
    //   24: getstatic 53	com/google/android/finsky/ag/d:cf	Lcom/google/android/play/utils/b/a;
    //   27: invokevirtual 58	com/google/android/play/utils/b/a:b	()Ljava/lang/Object;
    //   30: checkcast 60	java/lang/String
    //   33: invokevirtual 64	android/app/admin/DevicePolicyManager:isDeviceOwnerApp	(Ljava/lang/String;)Z
    //   36: invokestatic 70	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   39: putfield 20	com/google/android/finsky/ba/d:d	Ljava/lang/Boolean;
    //   42: aload_0
    //   43: getfield 20	com/google/android/finsky/ba/d:d	Ljava/lang/Boolean;
    //   46: invokevirtual 73	java/lang/Boolean:booleanValue	()Z
    //   49: istore_1
    //   50: aload_0
    //   51: monitorexit
    //   52: iload_1
    //   53: ireturn
    //   54: astore_2
    //   55: aload_2
    //   56: ldc 75
    //   58: iconst_0
    //   59: anewarray 4	java/lang/Object
    //   62: invokestatic 80	com/google/android/finsky/utils/FinskyLog:b	(Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   65: aload_0
    //   66: iconst_0
    //   67: invokestatic 70	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   70: putfield 20	com/google/android/finsky/ba/d:d	Ljava/lang/Boolean;
    //   73: goto -31 -> 42
    //   76: astore_2
    //   77: aload_0
    //   78: monitorexit
    //   79: aload_2
    //   80: athrow
    //   81: astore_2
    //   82: aload_2
    //   83: ldc 82
    //   85: iconst_0
    //   86: anewarray 4	java/lang/Object
    //   89: invokestatic 80	com/google/android/finsky/utils/FinskyLog:b	(Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   92: aload_0
    //   93: iconst_0
    //   94: invokestatic 70	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   97: putfield 20	com/google/android/finsky/ba/d:d	Ljava/lang/Boolean;
    //   100: goto -58 -> 42
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	103	0	this	d
    //   49	4	1	bool	boolean
    //   21	3	2	localDevicePolicyManager	android.app.admin.DevicePolicyManager
    //   54	2	2	localNoSuchMethodError	NoSuchMethodError
    //   76	4	2	localObject	Object
    //   81	2	2	localRuntimeException	RuntimeException
    // Exception table:
    //   from	to	target	type
    //   22	42	54	java/lang/NoSuchMethodError
    //   2	22	76	finally
    //   22	42	76	finally
    //   42	50	76	finally
    //   55	73	76	finally
    //   82	100	76	finally
    //   22	42	81	java/lang/RuntimeException
  }
  
  private final void b(e parame)
  {
    try
    {
      f localf = new f(this, this.c, parame);
      Intent localIntent = new Intent("com.google.android.nfcprovision.IOwnedService.BIND");
      localIntent.setComponent(new ComponentName("com.google.android.nfcprovision", "com.google.android.nfcprovision.SchoolOwnedService"));
      if (!this.c.bindService(localIntent, localf, 1))
      {
        this.a = Boolean.valueOf(false);
        parame.a(false);
      }
      return;
    }
    finally
    {
      parame = finally;
      throw parame;
    }
  }
  
  @TargetApi(21)
  public final Intent a(Activity paramActivity)
  {
    if (!this.b)
    {
      Intent localIntent = ((RestrictionsManager)paramActivity.getSystemService("restrictions")).createLocalApprovalIntent();
      PersistableBundle localPersistableBundle = new PersistableBundle();
      localPersistableBundle.putString("android.request.mesg", paramActivity.getString(2131953160));
      localIntent.putExtra("android.content.extra.REQUEST_BUNDLE", localPersistableBundle);
      return localIntent;
    }
    return null;
  }
  
  public final void a(e parame)
  {
    for (;;)
    {
      try
      {
        if (this.a == null)
        {
          if ((this.e.a.b()) || (((Boolean)com.google.android.finsky.ag.d.bo.b()).booleanValue())) {
            this.a = Boolean.valueOf(true);
          }
        }
        else
        {
          parame.a(this.a.booleanValue());
          return;
        }
        if (Build.VERSION.SDK_INT < 18)
        {
          this.a = Boolean.valueOf(false);
          continue;
        }
        if (!a()) {
          break label100;
        }
      }
      finally {}
      b(parame);
      continue;
      label100:
      this.a = Boolean.valueOf(false);
    }
  }
}


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/com/google/android/finsky/ba/d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */