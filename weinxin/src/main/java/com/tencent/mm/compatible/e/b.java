package com.tencent.mm.compatible.e;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Build.VERSION;
import android.provider.Settings;
import com.tencent.gmtrace.GMTrace;
import com.tencent.mm.sdk.platformtools.aa;
import com.tencent.mm.sdk.platformtools.v;
import java.lang.reflect.Method;

public final class b
{
  @TargetApi(19)
  public static boolean aA(Context paramContext)
  {
    boolean bool2 = true;
    GMTrace.i(13778120867840L, 102655);
    int i = Build.VERSION.SDK_INT;
    boolean bool1;
    if (i >= 23) {
      try
      {
        bool1 = ((Boolean)Settings.class.getDeclaredMethod("canDrawOverlays", new Class[] { Context.class }).invoke(null, new Object[] { paramContext })).booleanValue();
        v.i("MicroMsg.PermissionUtil", "isFloatWindowOpAllowed allowed: " + bool1);
        GMTrace.o(13778120867840L, 102655);
        return bool1;
      }
      catch (Exception paramContext)
      {
        v.e("MicroMsg.PermissionUtil", "getDeclaredMethod:canDrawOverlays! Error:%s, etype:%s", new Object[] { paramContext.getMessage(), paramContext.getClass().getCanonicalName() });
        GMTrace.o(13778120867840L, 102655);
        return true;
      }
    }
    if (i >= 19)
    {
      Object localObject = aa.getContext().getSystemService("appops");
      try
      {
        paramContext = Class.forName("android.app.AppOpsManager").getMethod("checkOp", new Class[] { Integer.TYPE, Integer.TYPE, String.class });
        bool1 = bool2;
        if (paramContext != null) {}
        try
        {
          i = ((Integer)paramContext.invoke(localObject, new Object[] { Integer.valueOf(24), Integer.valueOf(aa.getContext().getApplicationInfo().uid), aa.getPackageName() })).intValue();
          if (i != 0) {
            break label310;
          }
          bool1 = true;
        }
        catch (Exception paramContext)
        {
          for (;;)
          {
            v.e("MicroMsg.PermissionUtil", "call checkOp failed: %s etype:%s", new Object[] { paramContext.getMessage(), paramContext.getClass().getCanonicalName() });
            bool1 = bool2;
          }
        }
        v.i("MicroMsg.PermissionUtil", "isFloatWindowOpAllowed allowed: " + bool1);
        GMTrace.o(13778120867840L, 102655);
        return bool1;
      }
      catch (NoSuchMethodException paramContext)
      {
        for (;;)
        {
          v.e("MicroMsg.PermissionUtil", "NoSuchMethodException method:checkOp! Error:%s", new Object[] { paramContext.getMessage() });
          paramContext = null;
        }
      }
      catch (ClassNotFoundException paramContext)
      {
        for (;;)
        {
          v.e("MicroMsg.PermissionUtil", "ClassNotFoundException class:android.app.AppOpsManager! Error:%s", new Object[] { paramContext.getMessage() });
          paramContext = null;
          continue;
          label310:
          bool1 = false;
        }
      }
    }
    GMTrace.o(13778120867840L, 102655);
    return true;
  }
  
  public static boolean ay(Context paramContext)
  {
    GMTrace.i(13777583996928L, 102651);
    boolean bool = paramContext.getPackageManager().hasSystemFeature("org.chromium.arc.device_management");
    GMTrace.o(13777583996928L, 102651);
    return bool;
  }
  
  public static void az(Context paramContext)
  {
    GMTrace.i(13777852432384L, 102653);
    if (Build.MANUFACTURER.equalsIgnoreCase("meizu")) {
      try
      {
        Intent localIntent1 = new Intent();
        localIntent1.setClassName("com.android.settings", "com.android.settings.applications.AppsCheckReadPermission");
        paramContext.startActivity(localIntent1);
        GMTrace.o(13777852432384L, 102653);
        return;
      }
      catch (Exception localException1)
      {
        v.e("MicroMsg.PermissionUtil", "unable start activity AppsCheckReadPermission");
        try
        {
          Intent localIntent2 = new Intent("android.settings.APP_OPS_SETTINGS");
          localIntent2.addCategory("android.intent.category.DEFAULT");
          paramContext.startActivity(localIntent2);
          GMTrace.o(13777852432384L, 102653);
          return;
        }
        catch (Exception localException2)
        {
          v.e("MicroMsg.PermissionUtil", "unable start activity APP_OPS_SETTINGS");
          try
          {
            Intent localIntent3 = new Intent();
            localIntent3.setClassName("com.android.settings", "com.android.settings.Settings$AppControlSettingsActivity");
            paramContext.startActivity(localIntent3);
            GMTrace.o(13777852432384L, 102653);
            return;
          }
          catch (Exception paramContext)
          {
            v.e("MicroMsg.PermissionUtil", "unable start activity AppControlSettingsActivity");
          }
        }
      }
    }
    GMTrace.o(13777852432384L, 102653);
  }
  
  /* Error */
  private static boolean en(int paramInt)
  {
    // Byte code:
    //   0: ldc2_w 228
    //   3: ldc -26
    //   5: invokestatic 24	com/tencent/gmtrace/GMTrace:i	(JI)V
    //   8: iload_0
    //   9: ifne +13 -> 22
    //   12: ldc2_w 228
    //   15: ldc -26
    //   17: invokestatic 80	com/tencent/gmtrace/GMTrace:o	(JI)V
    //   20: iconst_1
    //   21: ireturn
    //   22: invokestatic 102	com/tencent/mm/sdk/platformtools/aa:getContext	()Landroid/content/Context;
    //   25: ldc 104
    //   27: invokevirtual 108	android/content/Context:getSystemService	(Ljava/lang/String;)Ljava/lang/Object;
    //   30: astore_2
    //   31: aload_2
    //   32: ifnull +158 -> 190
    //   35: ldc 110
    //   37: invokestatic 114	java/lang/Class:forName	(Ljava/lang/String;)Ljava/lang/Class;
    //   40: ldc -24
    //   42: iconst_3
    //   43: anewarray 36	java/lang/Class
    //   46: dup
    //   47: iconst_0
    //   48: getstatic 122	java/lang/Integer:TYPE	Ljava/lang/Class;
    //   51: aastore
    //   52: dup
    //   53: iconst_1
    //   54: getstatic 122	java/lang/Integer:TYPE	Ljava/lang/Class;
    //   57: aastore
    //   58: dup
    //   59: iconst_2
    //   60: ldc 124
    //   62: aastore
    //   63: invokevirtual 127	java/lang/Class:getMethod	(Ljava/lang/String;[Ljava/lang/Class;)Ljava/lang/reflect/Method;
    //   66: astore_1
    //   67: aload_1
    //   68: ifnull +151 -> 219
    //   71: aload_1
    //   72: aload_2
    //   73: iconst_3
    //   74: anewarray 4	java/lang/Object
    //   77: dup
    //   78: iconst_0
    //   79: iload_0
    //   80: invokestatic 131	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   83: aastore
    //   84: dup
    //   85: iconst_1
    //   86: invokestatic 102	com/tencent/mm/sdk/platformtools/aa:getContext	()Landroid/content/Context;
    //   89: invokevirtual 135	android/content/Context:getApplicationInfo	()Landroid/content/pm/ApplicationInfo;
    //   92: getfield 140	android/content/pm/ApplicationInfo:uid	I
    //   95: invokestatic 131	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   98: aastore
    //   99: dup
    //   100: iconst_2
    //   101: invokestatic 143	com/tencent/mm/sdk/platformtools/aa:getPackageName	()Ljava/lang/String;
    //   104: aastore
    //   105: invokevirtual 48	java/lang/reflect/Method:invoke	(Ljava/lang/Object;[Ljava/lang/Object;)Ljava/lang/Object;
    //   108: checkcast 118	java/lang/Integer
    //   111: invokevirtual 147	java/lang/Integer:intValue	()I
    //   114: istore_0
    //   115: iload_0
    //   116: ifeq +103 -> 219
    //   119: ldc 56
    //   121: ldc -22
    //   123: iconst_1
    //   124: anewarray 4	java/lang/Object
    //   127: dup
    //   128: iconst_0
    //   129: iload_0
    //   130: invokestatic 131	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   133: aastore
    //   134: invokestatic 96	com/tencent/mm/sdk/platformtools/v:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   137: ldc2_w 228
    //   140: ldc -26
    //   142: invokestatic 80	com/tencent/gmtrace/GMTrace:o	(JI)V
    //   145: iconst_0
    //   146: ireturn
    //   147: astore_1
    //   148: ldc 56
    //   150: ldc -20
    //   152: iconst_1
    //   153: anewarray 4	java/lang/Object
    //   156: dup
    //   157: iconst_0
    //   158: aload_1
    //   159: invokevirtual 150	java/lang/NoSuchMethodException:getMessage	()Ljava/lang/String;
    //   162: aastore
    //   163: invokestatic 96	com/tencent/mm/sdk/platformtools/v:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   166: aconst_null
    //   167: astore_1
    //   168: goto -101 -> 67
    //   171: astore_1
    //   172: ldc 56
    //   174: ldc -104
    //   176: iconst_1
    //   177: anewarray 4	java/lang/Object
    //   180: dup
    //   181: iconst_0
    //   182: aload_1
    //   183: invokevirtual 153	java/lang/ClassNotFoundException:getMessage	()Ljava/lang/String;
    //   186: aastore
    //   187: invokestatic 96	com/tencent/mm/sdk/platformtools/v:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   190: aconst_null
    //   191: astore_1
    //   192: goto -125 -> 67
    //   195: astore_1
    //   196: ldc 56
    //   198: ldc -18
    //   200: iconst_1
    //   201: anewarray 4	java/lang/Object
    //   204: dup
    //   205: iconst_0
    //   206: aload_1
    //   207: invokevirtual 85	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   210: aastore
    //   211: invokestatic 96	com/tencent/mm/sdk/platformtools/v:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   214: iconst_m1
    //   215: istore_0
    //   216: goto -101 -> 115
    //   219: ldc2_w 228
    //   222: ldc -26
    //   224: invokestatic 80	com/tencent/gmtrace/GMTrace:o	(JI)V
    //   227: iconst_1
    //   228: ireturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	229	0	paramInt	int
    //   66	6	1	localMethod	Method
    //   147	12	1	localNoSuchMethodException	NoSuchMethodException
    //   167	1	1	localObject1	Object
    //   171	12	1	localClassNotFoundException	ClassNotFoundException
    //   191	1	1	localObject2	Object
    //   195	12	1	localException	Exception
    //   30	43	2	localObject3	Object
    // Exception table:
    //   from	to	target	type
    //   35	67	147	java/lang/NoSuchMethodException
    //   35	67	171	java/lang/ClassNotFoundException
    //   71	115	195	java/lang/Exception
  }
  
  public static boolean rU()
  {
    GMTrace.i(13777449779200L, 102650);
    if (!Build.MANUFACTURER.equalsIgnoreCase("meizu"))
    {
      GMTrace.o(13777449779200L, 102650);
      return true;
    }
    int i = 0;
    if (Build.VERSION.SDK_INT == 17) {
      i = 36;
    }
    for (;;)
    {
      boolean bool = en(i);
      GMTrace.o(13777449779200L, 102650);
      return bool;
      if (Build.VERSION.SDK_INT >= 19) {
        i = 27;
      }
    }
  }
  
  public static boolean rV()
  {
    GMTrace.i(13777718214656L, 102652);
    if (!Build.MANUFACTURER.equalsIgnoreCase("meizu"))
    {
      GMTrace.o(13777718214656L, 102652);
      return true;
    }
    int i = 0;
    if (Build.VERSION.SDK_INT == 17) {
      i = 35;
    }
    for (;;)
    {
      boolean bool = en(i);
      GMTrace.o(13777718214656L, 102652);
      return bool;
      if (Build.VERSION.SDK_INT >= 19) {
        i = 26;
      }
    }
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/compatible/e/b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */