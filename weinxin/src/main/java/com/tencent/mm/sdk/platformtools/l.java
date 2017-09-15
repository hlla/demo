package com.tencent.mm.sdk.platformtools;

import android.app.ActivityManager;
import android.app.ActivityManager.RunningAppProcessInfo;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Build.VERSION;
import android.os.PowerManager;
import com.tencent.gmtrace.GMTrace;
import java.util.Iterator;
import java.util.List;

public final class l
{
  private static BroadcastReceiver lPk;
  public static int uqM;
  public static int uqN;
  
  static
  {
    GMTrace.i(13905761927168L, 103606);
    lPk = null;
    uqM = 0;
    uqN = -1;
    GMTrace.o(13905761927168L, 103606);
  }
  
  public static boolean cB(Context paramContext)
  {
    GMTrace.i(13904956620800L, 103600);
    paramContext = ((ActivityManager)paramContext.getSystemService("activity")).getRunningAppProcesses();
    if (paramContext == null)
    {
      GMTrace.o(13904956620800L, 103600);
      return false;
    }
    paramContext = paramContext.iterator();
    while (paramContext.hasNext())
    {
      ActivityManager.RunningAppProcessInfo localRunningAppProcessInfo = (ActivityManager.RunningAppProcessInfo)paramContext.next();
      if ((localRunningAppProcessInfo.importance == 100) && (localRunningAppProcessInfo.processName.startsWith("com.tencent.mm")))
      {
        GMTrace.o(13904956620800L, 103600);
        return true;
      }
    }
    GMTrace.o(13904956620800L, 103600);
    return false;
  }
  
  public static boolean dY(Context paramContext)
  {
    GMTrace.i(13904688185344L, 103598);
    try
    {
      paramContext = (PowerManager)paramContext.getSystemService("power");
      if (Build.VERSION.SDK_INT >= 20)
      {
        bool = paramContext.isInteractive();
        GMTrace.o(13904688185344L, 103598);
        return bool;
      }
      boolean bool = paramContext.isScreenOn();
      GMTrace.o(13904688185344L, 103598);
      return bool;
    }
    catch (Exception paramContext)
    {
      v.e("MicroMsg.GreenManUtil", "isScreenOn ERROR use isScreenOn e:%s", new Object[] { bf.g(paramContext) });
      GMTrace.o(13904688185344L, 103598);
    }
    return false;
  }
  
  /* Error */
  public static boolean dZ(Context paramContext)
  {
    // Byte code:
    //   0: iconst_0
    //   1: istore_1
    //   2: ldc 2
    //   4: monitorenter
    //   5: ldc2_w 125
    //   8: ldc 127
    //   10: invokestatic 22	com/tencent/gmtrace/GMTrace:i	(JI)V
    //   13: getstatic 24	com/tencent/mm/sdk/platformtools/l:lPk	Landroid/content/BroadcastReceiver;
    //   16: ifnonnull +50 -> 66
    //   19: new 6	com/tencent/mm/sdk/platformtools/l$1
    //   22: dup
    //   23: invokespecial 130	com/tencent/mm/sdk/platformtools/l$1:<init>	()V
    //   26: putstatic 24	com/tencent/mm/sdk/platformtools/l:lPk	Landroid/content/BroadcastReceiver;
    //   29: aload_0
    //   30: getstatic 24	com/tencent/mm/sdk/platformtools/l:lPk	Landroid/content/BroadcastReceiver;
    //   33: new 132	android/content/IntentFilter
    //   36: dup
    //   37: ldc -122
    //   39: invokespecial 137	android/content/IntentFilter:<init>	(Ljava/lang/String;)V
    //   42: invokevirtual 141	android/content/Context:registerReceiver	(Landroid/content/BroadcastReceiver;Landroid/content/IntentFilter;)Landroid/content/Intent;
    //   45: astore_0
    //   46: aload_0
    //   47: ldc -113
    //   49: iconst_m1
    //   50: invokevirtual 149	android/content/Intent:getIntExtra	(Ljava/lang/String;I)I
    //   53: putstatic 28	com/tencent/mm/sdk/platformtools/l:uqN	I
    //   56: aload_0
    //   57: ldc -105
    //   59: iconst_0
    //   60: invokevirtual 149	android/content/Intent:getIntExtra	(Ljava/lang/String;I)I
    //   63: putstatic 26	com/tencent/mm/sdk/platformtools/l:uqM	I
    //   66: getstatic 28	com/tencent/mm/sdk/platformtools/l:uqN	I
    //   69: iconst_2
    //   70: if_icmpeq +32 -> 102
    //   73: getstatic 26	com/tencent/mm/sdk/platformtools/l:uqM	I
    //   76: iconst_1
    //   77: if_icmpeq +25 -> 102
    //   80: getstatic 26	com/tencent/mm/sdk/platformtools/l:uqM	I
    //   83: iconst_2
    //   84: if_icmpeq +18 -> 102
    //   87: getstatic 99	android/os/Build$VERSION:SDK_INT	I
    //   90: bipush 17
    //   92: if_icmplt +25 -> 117
    //   95: getstatic 26	com/tencent/mm/sdk/platformtools/l:uqM	I
    //   98: iconst_4
    //   99: if_icmpne +18 -> 117
    //   102: ldc2_w 125
    //   105: ldc 127
    //   107: invokestatic 31	com/tencent/gmtrace/GMTrace:o	(JI)V
    //   110: iconst_1
    //   111: istore_1
    //   112: ldc 2
    //   114: monitorexit
    //   115: iload_1
    //   116: ireturn
    //   117: ldc2_w 125
    //   120: ldc 127
    //   122: invokestatic 31	com/tencent/gmtrace/GMTrace:o	(JI)V
    //   125: goto -13 -> 112
    //   128: astore_0
    //   129: ldc 2
    //   131: monitorexit
    //   132: aload_0
    //   133: athrow
    //   134: astore_0
    //   135: goto -69 -> 66
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	138	0	paramContext	Context
    //   1	115	1	bool	boolean
    // Exception table:
    //   from	to	target	type
    //   5	29	128	finally
    //   29	66	128	finally
    //   66	102	128	finally
    //   102	110	128	finally
    //   117	125	128	finally
    //   29	66	134	java/lang/Throwable
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/sdk/platformtools/l.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */