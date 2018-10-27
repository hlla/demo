package com.google.android.finsky.ba;

import android.app.ActivityManager;
import android.app.ActivityManager.MemoryInfo;
import android.content.Context;
import android.content.pm.PackageManager;
import android.os.Build.VERSION;
import com.google.android.finsky.ag.d;
import com.google.android.finsky.utils.j;
import java.util.Set;

public final class a
{
  private static final Set e = j.b((String)d.fQ.b());
  private static final Set f = j.b((String)d.fR.b());
  private static Boolean g = null;
  private static Boolean h = null;
  private static Boolean i = null;
  private static Boolean j = null;
  public final boolean a;
  public final boolean b;
  public final boolean c;
  public final boolean d;
  private final com.google.android.finsky.eq.a k;
  
  a(Context paramContext, com.google.android.finsky.eq.a parama)
  {
    this.a = a(paramContext);
    this.b = b(paramContext);
    this.c = c(paramContext);
    this.d = d(paramContext);
    if (Build.VERSION.SDK_INT >= 19) {
      ((ActivityManager)paramContext.getSystemService("activity")).isLowRamDevice();
    }
    for (;;)
    {
      this.k = parama;
      return;
      paramContext = (ActivityManager)paramContext.getSystemService("activity");
      MemoryInfo localMemoryInfo = new MemoryInfo();
      paramContext.getMemoryInfo(localMemoryInfo);
      long l = localMemoryInfo.totalMem;
      ((Long)d.fc.b()).longValue();
    }
  }
  
  @Deprecated
  public static boolean a(Context paramContext)
  {
    try
    {
      if (g == null) {
        g = Boolean.valueOf(paramContext.getPackageManager().hasSystemFeature("android.hardware.type.automotive"));
      }
      boolean bool = g.booleanValue();
      return bool;
    }
    finally {}
  }
  
  /* Error */
  @Deprecated
  public static boolean b(Context paramContext)
  {
    // Byte code:
    //   0: ldc 2
    //   2: monitorenter
    //   3: getstatic 25	com/google/android/finsky/ba/a:h	Ljava/lang/Boolean;
    //   6: ifnonnull +46 -> 52
    //   9: aload_0
    //   10: invokevirtual 123	android/content/Context:getPackageManager	()Landroid/content/pm/PackageManager;
    //   13: ldc -113
    //   15: invokevirtual 131	android/content/pm/PackageManager:hasSystemFeature	(Ljava/lang/String;)Z
    //   18: ifeq +56 -> 74
    //   21: aload_0
    //   22: ldc -111
    //   24: invokevirtual 90	android/content/Context:getSystemService	(Ljava/lang/String;)Ljava/lang/Object;
    //   27: checkcast 147	android/app/UiModeManager
    //   30: astore_0
    //   31: aload_0
    //   32: ifnull +37 -> 69
    //   35: aload_0
    //   36: invokevirtual 151	android/app/UiModeManager:getCurrentModeType	()I
    //   39: iconst_4
    //   40: if_icmpne +24 -> 64
    //   43: iconst_1
    //   44: istore_1
    //   45: iload_1
    //   46: invokestatic 137	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   49: putstatic 25	com/google/android/finsky/ba/a:h	Ljava/lang/Boolean;
    //   52: getstatic 25	com/google/android/finsky/ba/a:h	Ljava/lang/Boolean;
    //   55: invokevirtual 140	java/lang/Boolean:booleanValue	()Z
    //   58: istore_1
    //   59: ldc 2
    //   61: monitorexit
    //   62: iload_1
    //   63: ireturn
    //   64: iconst_0
    //   65: istore_1
    //   66: goto -21 -> 45
    //   69: iconst_0
    //   70: istore_1
    //   71: goto -26 -> 45
    //   74: iconst_0
    //   75: istore_1
    //   76: goto -31 -> 45
    //   79: astore_0
    //   80: ldc 2
    //   82: monitorexit
    //   83: aload_0
    //   84: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	85	0	paramContext	Context
    //   44	32	1	bool	boolean
    // Exception table:
    //   from	to	target	type
    //   3	31	79	finally
    //   35	43	79	finally
    //   45	52	79	finally
    //   52	59	79	finally
  }
  
  @Deprecated
  public static boolean c(Context paramContext)
  {
    try
    {
      if (i == null) {
        i = Boolean.valueOf(paramContext.getPackageManager().hasSystemFeature("android.hardware.type.watch"));
      }
      boolean bool = i.booleanValue();
      return bool;
    }
    finally {}
  }
  
  @Deprecated
  public static boolean d(Context paramContext)
  {
    try
    {
      if (j == null) {
        j = Boolean.valueOf(paramContext.getPackageManager().hasSystemFeature("org.chromium.arc"));
      }
      boolean bool = j.booleanValue();
      return bool;
    }
    finally {}
  }
  
  public final boolean a()
  {
    String[] arrayOfString = this.k.b();
    int n = arrayOfString.length;
    int m = 0;
    boolean bool1 = false;
    for (;;)
    {
      bool2 = bool1;
      if (m >= n) {
        break label69;
      }
      String str = arrayOfString[m];
      if (f.contains(str)) {
        break;
      }
      if (e.contains(str)) {
        bool1 = true;
      }
      m += 1;
    }
    boolean bool2 = false;
    label69:
    return bool2;
  }
}


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/com/google/android/finsky/ba/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */