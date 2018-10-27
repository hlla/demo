package com.google.android.finsky.cl.a;

import com.google.android.finsky.utils.FinskyLog;

public final class j
{
  private static Class a = null;
  
  static Class a()
  {
    try
    {
      Class localClass = Class.forName("com.google.android.finsky.tvtos.TvTosActivity");
      return localClass;
    }
    catch (ClassNotFoundException localClassNotFoundException)
    {
      FinskyLog.d("Could not find class '%s'", new Object[] { "com.google.android.finsky.tvtos.TvTosActivity" });
    }
    return null;
  }
  
  /* Error */
  static Class a(android.content.Context paramContext)
  {
    // Byte code:
    //   0: ldc 2
    //   2: monitorenter
    //   3: getstatic 10	com/google/android/finsky/cl/a/j:a	Ljava/lang/Class;
    //   6: ifnonnull +20 -> 26
    //   9: aload_0
    //   10: invokestatic 37	com/google/android/finsky/ba/a:b	(Landroid/content/Context;)Z
    //   13: istore_1
    //   14: iload_1
    //   15: ifeq +20 -> 35
    //   18: ldc 39
    //   20: invokestatic 22	java/lang/Class:forName	(Ljava/lang/String;)Ljava/lang/Class;
    //   23: putstatic 10	com/google/android/finsky/cl/a/j:a	Ljava/lang/Class;
    //   26: getstatic 10	com/google/android/finsky/cl/a/j:a	Ljava/lang/Class;
    //   29: astore_0
    //   30: ldc 2
    //   32: monitorexit
    //   33: aload_0
    //   34: areturn
    //   35: ldc 41
    //   37: putstatic 10	com/google/android/finsky/cl/a/j:a	Ljava/lang/Class;
    //   40: goto -14 -> 26
    //   43: astore_0
    //   44: ldc 2
    //   46: monitorexit
    //   47: aload_0
    //   48: athrow
    //   49: astore_0
    //   50: ldc 24
    //   52: iconst_1
    //   53: anewarray 4	java/lang/Object
    //   56: dup
    //   57: iconst_0
    //   58: ldc 39
    //   60: aastore
    //   61: invokestatic 44	com/google/android/finsky/utils/FinskyLog:e	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   64: goto -38 -> 26
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	67	0	paramContext	android.content.Context
    //   13	2	1	bool	boolean
    // Exception table:
    //   from	to	target	type
    //   3	14	43	finally
    //   18	26	43	finally
    //   26	30	43	finally
    //   35	40	43	finally
    //   50	64	43	finally
    //   18	26	49	java/lang/ClassNotFoundException
  }
}


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/com/google/android/finsky/cl/a/j.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */