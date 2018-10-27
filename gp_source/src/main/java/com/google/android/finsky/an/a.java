package com.google.android.finsky.an;

import android.content.Context;

public final class a
{
  private static a d = null;
  public Boolean a = null;
  private final Context b;
  private boolean c;
  
  private a(Context paramContext)
  {
    this.b = paramContext.getApplicationContext();
  }
  
  public static a a(Context paramContext)
  {
    try
    {
      if (d == null) {
        d = new a(paramContext);
      }
      paramContext = d;
      return paramContext;
    }
    finally {}
  }
  
  /* Error */
  public final boolean a()
  {
    // Byte code:
    //   0: iconst_0
    //   1: istore_1
    //   2: aload_0
    //   3: monitorenter
    //   4: invokestatic 39	android/support/v4/os/a:a	()Z
    //   7: ifeq +104 -> 111
    //   10: aload_0
    //   11: getfield 23	com/google/android/finsky/an/a:a	Ljava/lang/Boolean;
    //   14: astore_2
    //   15: aload_2
    //   16: ifnull +12 -> 28
    //   19: aload_2
    //   20: invokevirtual 44	java/lang/Boolean:booleanValue	()Z
    //   23: istore_1
    //   24: aload_0
    //   25: monitorexit
    //   26: iload_1
    //   27: ireturn
    //   28: aload_0
    //   29: getfield 46	com/google/android/finsky/an/a:c	Z
    //   32: ifne +39 -> 71
    //   35: new 48	android/content/IntentFilter
    //   38: dup
    //   39: invokespecial 49	android/content/IntentFilter:<init>	()V
    //   42: astore_2
    //   43: aload_2
    //   44: ldc 51
    //   46: invokevirtual 55	android/content/IntentFilter:addAction	(Ljava/lang/String;)V
    //   49: aload_0
    //   50: getfield 31	com/google/android/finsky/an/a:b	Landroid/content/Context;
    //   53: new 57	com/google/android/finsky/an/b
    //   56: dup
    //   57: aload_0
    //   58: invokespecial 60	com/google/android/finsky/an/b:<init>	(Lcom/google/android/finsky/an/a;)V
    //   61: aload_2
    //   62: invokevirtual 64	android/content/Context:registerReceiver	(Landroid/content/BroadcastReceiver;Landroid/content/IntentFilter;)Landroid/content/Intent;
    //   65: pop
    //   66: aload_0
    //   67: iconst_1
    //   68: putfield 46	com/google/android/finsky/an/a:c	Z
    //   71: aload_0
    //   72: getfield 31	com/google/android/finsky/an/a:b	Landroid/content/Context;
    //   75: ldc 66
    //   77: invokevirtual 70	android/content/Context:getSystemService	(Ljava/lang/String;)Ljava/lang/Object;
    //   80: checkcast 72	android/net/ConnectivityManager
    //   83: invokevirtual 76	android/net/ConnectivityManager:getRestrictBackgroundStatus	()I
    //   86: iconst_3
    //   87: if_icmpne +5 -> 92
    //   90: iconst_1
    //   91: istore_1
    //   92: aload_0
    //   93: iload_1
    //   94: invokestatic 80	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   97: putfield 23	com/google/android/finsky/an/a:a	Ljava/lang/Boolean;
    //   100: aload_0
    //   101: getfield 23	com/google/android/finsky/an/a:a	Ljava/lang/Boolean;
    //   104: invokevirtual 44	java/lang/Boolean:booleanValue	()Z
    //   107: istore_1
    //   108: goto -84 -> 24
    //   111: iconst_0
    //   112: istore_1
    //   113: goto -89 -> 24
    //   116: astore_2
    //   117: aload_0
    //   118: monitorexit
    //   119: aload_2
    //   120: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	121	0	this	a
    //   1	112	1	bool	boolean
    //   14	48	2	localObject1	Object
    //   116	4	2	localObject2	Object
    // Exception table:
    //   from	to	target	type
    //   4	15	116	finally
    //   19	24	116	finally
    //   28	71	116	finally
    //   71	90	116	finally
    //   92	108	116	finally
  }
}


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/com/google/android/finsky/an/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */