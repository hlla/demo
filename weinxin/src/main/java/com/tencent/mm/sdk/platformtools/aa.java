package com.tencent.mm.sdk.platformtools;

import android.app.ActivityManager;
import android.app.ActivityManager.RunningAppProcessInfo;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.res.Resources;
import com.tencent.gmtrace.GMTrace;
import java.util.Iterator;
import java.util.List;

public final class aa
{
  private static Resources Cu;
  private static Context context;
  private static String fwG;
  private static String processName;
  private static String urh;
  private static String urj;
  private static boolean urk;
  public static boolean urm;
  private static ActivityManager urn;
  
  static
  {
    GMTrace.i(14001996038144L, 104323);
    context = null;
    urh = "com.tencent.mm";
    fwG = "com.tencent.mm";
    urj = "com.tencent.mm.ui.LauncherUI";
    processName = fwG;
    urk = false;
    urm = false;
    Cu = null;
    urn = null;
    GMTrace.o(14001996038144L, 104323);
  }
  
  public static void Pq(String paramString)
  {
    GMTrace.i(14000788078592L, 104314);
    processName = paramString;
    GMTrace.o(14000788078592L, 104314);
  }
  
  private static boolean Pr(String paramString)
  {
    GMTrace.i(14001593384960L, 104320);
    if ((context == null) || (fwG == null))
    {
      GMTrace.o(14001593384960L, 104320);
      return false;
    }
    if (urn == null) {
      urn = (ActivityManager)context.getSystemService("activity");
    }
    try
    {
      Iterator localIterator = urn.getRunningAppProcesses().iterator();
      while (localIterator.hasNext())
      {
        boolean bool = ((ActivityManager.RunningAppProcessInfo)localIterator.next()).processName.equals(paramString);
        if (bool)
        {
          GMTrace.o(14001593384960L, 104320);
          return true;
        }
      }
    }
    catch (Exception paramString)
    {
      v.e("MicroMsg.MMApplicationContext", "isMMProcessExist Exception: " + paramString.toString());
      GMTrace.o(14001593384960L, 104320);
      return false;
    }
    catch (Error paramString)
    {
      v.e("MicroMsg.MMApplicationContext", "isMMProcessExist Error: " + paramString.toString());
      GMTrace.o(14001593384960L, 104320);
      return false;
    }
    GMTrace.o(14001593384960L, 104320);
    return false;
  }
  
  public static void a(Resources paramResources)
  {
    GMTrace.i(14001861820416L, 104322);
    Cu = paramResources;
    GMTrace.o(14001861820416L, 104322);
  }
  
  public static boolean bIK()
  {
    GMTrace.i(13999043248128L, 104301);
    boolean bool = urk;
    GMTrace.o(13999043248128L, 104301);
    return bool;
  }
  
  public static String bIL()
  {
    GMTrace.i(13999177465856L, 104302);
    String str = urj;
    GMTrace.o(13999177465856L, 104302);
    return str;
  }
  
  public static String bIM()
  {
    GMTrace.i(13999714336768L, 104306);
    String str = urh;
    GMTrace.o(13999714336768L, 104306);
    return str;
  }
  
  public static String bIN()
  {
    GMTrace.i(13999848554496L, 104307);
    String str = fwG + "_preferences";
    GMTrace.o(13999848554496L, 104307);
    return str;
  }
  
  public static SharedPreferences bIO()
  {
    GMTrace.i(14000116989952L, 104309);
    if (context != null)
    {
      SharedPreferences localSharedPreferences = context.getSharedPreferences(bIN(), 0);
      GMTrace.o(14000116989952L, 104309);
      return localSharedPreferences;
    }
    GMTrace.o(14000116989952L, 104309);
    return null;
  }
  
  public static SharedPreferences bIP()
  {
    GMTrace.i(14000251207680L, 104310);
    if (context != null)
    {
      SharedPreferences localSharedPreferences = context.getSharedPreferences(fwG + "_preferences_tools", 0);
      GMTrace.o(14000251207680L, 104310);
      return localSharedPreferences;
    }
    GMTrace.o(14000251207680L, 104310);
    return null;
  }
  
  public static String bIQ()
  {
    GMTrace.i(14000519643136L, 104312);
    String str = fwG + "_tmp_preferences";
    GMTrace.o(14000519643136L, 104312);
    return str;
  }
  
  public static boolean bIR()
  {
    GMTrace.i(14000922296320L, 104315);
    String str2 = processName;
    String str1;
    if (str2 != null)
    {
      str1 = str2;
      if (str2.length() != 0) {}
    }
    else
    {
      str1 = fwG;
    }
    boolean bool = fwG.equals(str1);
    GMTrace.o(14000922296320L, 104315);
    return bool;
  }
  
  public static boolean bIS()
  {
    GMTrace.i(14001056514048L, 104316);
    String str2 = processName;
    String str1;
    if (str2 != null)
    {
      str1 = str2;
      if (str2.length() != 0) {}
    }
    else
    {
      str1 = fwG;
    }
    boolean bool = "com.tencent.mm:push".equalsIgnoreCase(str1);
    GMTrace.o(14001056514048L, 104316);
    return bool;
  }
  
  public static boolean bIT()
  {
    GMTrace.i(14001190731776L, 104317);
    String str2 = processName;
    String str1;
    if (str2 != null)
    {
      str1 = str2;
      if (str2.length() != 0) {}
    }
    else
    {
      str1 = fwG;
    }
    boolean bool = "com.tencent.mm:tools".equalsIgnoreCase(str1);
    GMTrace.o(14001190731776L, 104317);
    return bool;
  }
  
  public static boolean bIU()
  {
    GMTrace.i(14001324949504L, 104318);
    String str2 = processName;
    String str1;
    if (str2 != null)
    {
      str1 = str2;
      if (str2.length() != 0) {}
    }
    else
    {
      str1 = fwG;
    }
    boolean bool = "com.tencent.mm:exdevice".equalsIgnoreCase(str1);
    GMTrace.o(14001324949504L, 104318);
    return bool;
  }
  
  public static boolean bIV()
  {
    GMTrace.i(14001459167232L, 104319);
    boolean bool = Pr(fwG);
    GMTrace.o(14001459167232L, 104319);
    return bool;
  }
  
  public static Context getContext()
  {
    GMTrace.i(13999445901312L, 104304);
    Context localContext = context;
    GMTrace.o(13999445901312L, 104304);
    return localContext;
  }
  
  public static String getPackageName()
  {
    GMTrace.i(13999580119040L, 104305);
    String str = fwG;
    GMTrace.o(13999580119040L, 104305);
    return str;
  }
  
  public static Resources getResources()
  {
    GMTrace.i(14001727602688L, 104321);
    Resources localResources = Cu;
    GMTrace.o(14001727602688L, 104321);
    return localResources;
  }
  
  public static void jO(boolean paramBoolean)
  {
    GMTrace.i(13998909030400L, 104300);
    urk = paramBoolean;
    GMTrace.o(13998909030400L, 104300);
  }
  
  public static void setContext(Context paramContext)
  {
    GMTrace.i(13999311683584L, 104303);
    context = paramContext;
    fwG = paramContext.getPackageName();
    v.d("MicroMsg.MMApplicationContext", "setup application context for package: " + fwG);
    GMTrace.o(13999311683584L, 104303);
  }
  
  public static String um()
  {
    GMTrace.i(14000653860864L, 104313);
    String str = processName;
    GMTrace.o(14000653860864L, 104313);
    return str;
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/sdk/platformtools/aa.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */