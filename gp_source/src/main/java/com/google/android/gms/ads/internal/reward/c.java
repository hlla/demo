package com.google.android.gms.ads.internal.reward;

import android.app.Activity;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.Intent;
import com.google.android.gms.ads.internal.q.a.a;
import java.lang.ref.WeakReference;

@a
public final class c
  extends ContextWrapper
{
  private WeakReference a = new WeakReference(null);
  private Context b;
  
  private c(Context paramContext)
  {
    super(paramContext);
  }
  
  /* Error */
  private final Intent a(Intent paramIntent)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 24	com/google/android/gms/ads/internal/reward/c:b	Landroid/content/Context;
    //   6: ifnull +60 -> 66
    //   9: aload_1
    //   10: invokevirtual 30	android/content/Intent:getComponent	()Landroid/content/ComponentName;
    //   13: ifnull +53 -> 66
    //   16: aload_1
    //   17: invokevirtual 30	android/content/Intent:getComponent	()Landroid/content/ComponentName;
    //   20: invokevirtual 36	android/content/ComponentName:getPackageName	()Ljava/lang/String;
    //   23: aload_0
    //   24: getfield 24	com/google/android/gms/ads/internal/reward/c:b	Landroid/content/Context;
    //   27: invokevirtual 39	android/content/Context:getPackageName	()Ljava/lang/String;
    //   30: invokevirtual 45	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   33: ifeq +33 -> 66
    //   36: aload_1
    //   37: invokevirtual 49	android/content/Intent:clone	()Ljava/lang/Object;
    //   40: checkcast 26	android/content/Intent
    //   43: astore_2
    //   44: aload_2
    //   45: aload_0
    //   46: invokespecial 50	android/content/ContextWrapper:getPackageName	()Ljava/lang/String;
    //   49: aload_1
    //   50: invokevirtual 30	android/content/Intent:getComponent	()Landroid/content/ComponentName;
    //   53: invokevirtual 53	android/content/ComponentName:getClassName	()Ljava/lang/String;
    //   56: invokevirtual 57	android/content/Intent:setClassName	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   59: pop
    //   60: aload_2
    //   61: astore_1
    //   62: aload_0
    //   63: monitorexit
    //   64: aload_1
    //   65: areturn
    //   66: goto -4 -> 62
    //   69: astore_1
    //   70: aload_0
    //   71: monitorexit
    //   72: aload_1
    //   73: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	74	0	this	c
    //   0	74	1	paramIntent	Intent
    //   43	18	2	localIntent	Intent
    // Exception table:
    //   from	to	target	type
    //   2	60	69	finally
  }
  
  public static c a(Context paramContext)
  {
    return new c(c(paramContext));
  }
  
  public static Context b(Context paramContext)
  {
    if ((paramContext instanceof c)) {
      return ((c)paramContext).getBaseContext();
    }
    return c(paramContext);
  }
  
  /* Error */
  private final void b(Intent paramIntent)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 20	com/google/android/gms/ads/internal/reward/c:a	Ljava/lang/ref/WeakReference;
    //   6: invokevirtual 71	java/lang/ref/WeakReference:get	()Ljava/lang/Object;
    //   9: checkcast 73	android/app/Activity
    //   12: astore_2
    //   13: aload_2
    //   14: ifnonnull +18 -> 32
    //   17: aload_1
    //   18: ldc 74
    //   20: invokevirtual 78	android/content/Intent:addFlags	(I)Landroid/content/Intent;
    //   23: pop
    //   24: aload_0
    //   25: aload_1
    //   26: invokespecial 81	android/content/ContextWrapper:startActivity	(Landroid/content/Intent;)V
    //   29: aload_0
    //   30: monitorexit
    //   31: return
    //   32: aload_1
    //   33: invokevirtual 49	android/content/Intent:clone	()Ljava/lang/Object;
    //   36: checkcast 26	android/content/Intent
    //   39: astore_3
    //   40: aload_3
    //   41: aload_1
    //   42: invokevirtual 85	android/content/Intent:getFlags	()I
    //   45: ldc 86
    //   47: iand
    //   48: invokevirtual 89	android/content/Intent:setFlags	(I)Landroid/content/Intent;
    //   51: pop
    //   52: aload_2
    //   53: aload_3
    //   54: invokevirtual 90	android/app/Activity:startActivity	(Landroid/content/Intent;)V
    //   57: goto -28 -> 29
    //   60: astore_2
    //   61: getstatic 96	com/google/android/gms/ads/internal/bt:A	Lcom/google/android/gms/ads/internal/bt;
    //   64: getfield 100	com/google/android/gms/ads/internal/bt:i	Lcom/google/android/gms/ads/internal/v/f;
    //   67: aload_2
    //   68: ldc 102
    //   70: invokevirtual 107	com/google/android/gms/ads/internal/v/f:a	(Ljava/lang/Throwable;Ljava/lang/String;)V
    //   73: aload_1
    //   74: ldc 74
    //   76: invokevirtual 78	android/content/Intent:addFlags	(I)Landroid/content/Intent;
    //   79: pop
    //   80: aload_0
    //   81: aload_1
    //   82: invokespecial 81	android/content/ContextWrapper:startActivity	(Landroid/content/Intent;)V
    //   85: goto -56 -> 29
    //   88: astore_1
    //   89: aload_0
    //   90: monitorexit
    //   91: aload_1
    //   92: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	93	0	this	c
    //   0	93	1	paramIntent	Intent
    //   12	41	2	localActivity	Activity
    //   60	8	2	localThrowable	Throwable
    //   39	15	3	localIntent	Intent
    // Exception table:
    //   from	to	target	type
    //   32	57	60	finally
    //   2	13	88	finally
    //   17	29	88	finally
    //   61	85	88	finally
  }
  
  private static Context c(Context paramContext)
  {
    Context localContext = paramContext.getApplicationContext();
    if (localContext == null) {
      return paramContext;
    }
    return localContext;
  }
  
  public final void a(Activity paramActivity)
  {
    try
    {
      this.a = new WeakReference(paramActivity);
      return;
    }
    finally
    {
      paramActivity = finally;
      throw paramActivity;
    }
  }
  
  public final void a(String paramString)
  {
    try
    {
      this.b = super.createPackageContext(paramString, 0);
      return;
    }
    finally
    {
      paramString = finally;
      throw paramString;
    }
  }
  
  public final Context getApplicationContext()
  {
    return this;
  }
  
  /* Error */
  public final android.content.pm.ApplicationInfo getApplicationInfo()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 24	com/google/android/gms/ads/internal/reward/c:b	Landroid/content/Context;
    //   6: astore_1
    //   7: aload_1
    //   8: ifnull +12 -> 20
    //   11: aload_1
    //   12: invokevirtual 120	android/content/Context:getApplicationInfo	()Landroid/content/pm/ApplicationInfo;
    //   15: astore_1
    //   16: aload_0
    //   17: monitorexit
    //   18: aload_1
    //   19: areturn
    //   20: aload_0
    //   21: invokespecial 121	android/content/ContextWrapper:getApplicationInfo	()Landroid/content/pm/ApplicationInfo;
    //   24: astore_1
    //   25: goto -9 -> 16
    //   28: astore_1
    //   29: aload_0
    //   30: monitorexit
    //   31: aload_1
    //   32: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	33	0	this	c
    //   6	19	1	localObject1	Object
    //   28	4	1	localObject2	Object
    // Exception table:
    //   from	to	target	type
    //   2	7	28	finally
    //   11	16	28	finally
    //   20	25	28	finally
  }
  
  /* Error */
  public final String getPackageName()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 24	com/google/android/gms/ads/internal/reward/c:b	Landroid/content/Context;
    //   6: astore_1
    //   7: aload_1
    //   8: ifnull +12 -> 20
    //   11: aload_1
    //   12: invokevirtual 39	android/content/Context:getPackageName	()Ljava/lang/String;
    //   15: astore_1
    //   16: aload_0
    //   17: monitorexit
    //   18: aload_1
    //   19: areturn
    //   20: aload_0
    //   21: invokespecial 50	android/content/ContextWrapper:getPackageName	()Ljava/lang/String;
    //   24: astore_1
    //   25: goto -9 -> 16
    //   28: astore_1
    //   29: aload_0
    //   30: monitorexit
    //   31: aload_1
    //   32: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	33	0	this	c
    //   6	19	1	localObject1	Object
    //   28	4	1	localObject2	Object
    // Exception table:
    //   from	to	target	type
    //   2	7	28	finally
    //   11	16	28	finally
    //   20	25	28	finally
  }
  
  /* Error */
  public final String getPackageResourcePath()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 24	com/google/android/gms/ads/internal/reward/c:b	Landroid/content/Context;
    //   6: astore_1
    //   7: aload_1
    //   8: ifnull +12 -> 20
    //   11: aload_1
    //   12: invokevirtual 124	android/content/Context:getPackageResourcePath	()Ljava/lang/String;
    //   15: astore_1
    //   16: aload_0
    //   17: monitorexit
    //   18: aload_1
    //   19: areturn
    //   20: aload_0
    //   21: invokespecial 125	android/content/ContextWrapper:getPackageResourcePath	()Ljava/lang/String;
    //   24: astore_1
    //   25: goto -9 -> 16
    //   28: astore_1
    //   29: aload_0
    //   30: monitorexit
    //   31: aload_1
    //   32: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	33	0	this	c
    //   6	19	1	localObject1	Object
    //   28	4	1	localObject2	Object
    // Exception table:
    //   from	to	target	type
    //   2	7	28	finally
    //   11	16	28	finally
    //   20	25	28	finally
  }
  
  public final void startActivity(Intent paramIntent)
  {
    try
    {
      b(a(paramIntent));
      return;
    }
    finally
    {
      paramIntent = finally;
      throw paramIntent;
    }
  }
}


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/com/google/android/gms/ads/internal/reward/c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */