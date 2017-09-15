package com.tencent.mm.pluginsdk.model.app;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.net.Uri;
import com.tencent.gmtrace.GMTrace;
import com.tencent.mm.sdk.platformtools.aa;
import com.tencent.mm.sdk.platformtools.bf;
import com.tencent.mm.sdk.platformtools.v;

public final class q
{
  public static String Mk(String paramString)
  {
    GMTrace.i(16427310383104L, 122393);
    if (bf.mA(paramString))
    {
      GMTrace.o(16427310383104L, 122393);
      return null;
    }
    Object localObject = aa.getContext().getPackageManager();
    try
    {
      localObject = ((PackageManager)localObject).getPackageArchiveInfo(paramString, 0);
      v.i("MicroMsg.ApplicationUtil", "get package name from archive filepath  :%s, package name is : %s", new Object[] { paramString, ((PackageInfo)localObject).packageName });
      paramString = ((PackageInfo)localObject).packageName;
      GMTrace.o(16427310383104L, 122393);
      return paramString;
    }
    catch (Exception paramString)
    {
      v.e("MicroMsg.ApplicationUtil", "get package name from archive file path, failed : %s", new Object[] { paramString.getMessage() });
      GMTrace.o(16427310383104L, 122393);
    }
    return null;
  }
  
  public static int Ml(String paramString)
  {
    GMTrace.i(16427444600832L, 122394);
    if (bf.mA(paramString))
    {
      GMTrace.o(16427444600832L, 122394);
      return 0;
    }
    Object localObject = aa.getContext().getPackageManager();
    try
    {
      localObject = ((PackageManager)localObject).getPackageArchiveInfo(paramString, 0);
      v.i("MicroMsg.ApplicationUtil", "get package version code from archive filepath  :%s, package version code is : %d", new Object[] { paramString, Integer.valueOf(((PackageInfo)localObject).versionCode) });
      int i = ((PackageInfo)localObject).versionCode;
      GMTrace.o(16427444600832L, 122394);
      return i;
    }
    catch (Exception paramString)
    {
      v.e("MicroMsg.ApplicationUtil", "get package version code from archive file path, failed : %s", new Object[] { paramString.getMessage() });
      GMTrace.o(16427444600832L, 122394);
    }
    return 0;
  }
  
  public static boolean aR(Context paramContext, String paramString)
  {
    GMTrace.i(16427041947648L, 122391);
    Uri localUri = Uri.parse(paramString);
    Intent localIntent = new Intent("android.intent.action.VIEW", localUri);
    localIntent.addFlags(268435456);
    if (ay(paramContext, "com.android.vending") != null)
    {
      v.v("MicroMsg.ApplicationUtil", "installAppWithGP, gp is installed, url = %s", new Object[] { paramString });
      localIntent.setPackage("com.android.vending");
    }
    for (;;)
    {
      try
      {
        paramContext.startActivity(localIntent);
        GMTrace.o(16427041947648L, 122391);
        return true;
      }
      catch (Exception paramString)
      {
        v.e("MicroMsg.ApplicationUtil", "installAppWithGP first, ex = %s", new Object[] { paramString.getMessage() });
        try
        {
          paramString = new Intent("android.intent.action.VIEW", localUri);
          paramString.addFlags(268435456);
          paramContext.startActivity(paramString);
          GMTrace.o(16427041947648L, 122391);
          return true;
        }
        catch (Exception paramContext)
        {
          v.e("MicroMsg.ApplicationUtil", "installAppWithGP second, ex = %s", new Object[] { paramContext.getMessage() });
          GMTrace.o(16427041947648L, 122391);
        }
      }
      v.v("MicroMsg.ApplicationUtil", "installAppWithGP, gp is not installed, url = %s", new Object[] { paramString });
    }
    return false;
  }
  
  private static PackageInfo ay(Context paramContext, String paramString)
  {
    Object localObject = null;
    GMTrace.i(16427176165376L, 122392);
    if (paramString.length() == 0)
    {
      v.e("MicroMsg.ApplicationUtil", "getPackageInfo, packageName is null");
      GMTrace.o(16427176165376L, 122392);
      return null;
    }
    try
    {
      paramContext = paramContext.getPackageManager().getPackageInfo(paramString, 0);
      GMTrace.o(16427176165376L, 122392);
      return paramContext;
    }
    catch (PackageManager.NameNotFoundException paramContext)
    {
      for (;;)
      {
        v.w("MicroMsg.ApplicationUtil", "app not installed, packageName = " + paramString);
        paramContext = (Context)localObject;
      }
    }
  }
  
  public static boolean e(Context paramContext, Uri paramUri)
  {
    GMTrace.i(16426907729920L, 122390);
    Intent localIntent = new Intent("android.intent.action.VIEW");
    localIntent.setDataAndType(paramUri, "application/vnd.android.package-archive");
    localIntent.addFlags(268435456);
    try
    {
      paramContext.startActivity(localIntent);
      GMTrace.o(16426907729920L, 122390);
      return true;
    }
    catch (Exception paramContext)
    {
      v.e("MicroMsg.ApplicationUtil", "install app failed: " + paramUri.toString() + ", ex = " + paramContext.getMessage());
      GMTrace.o(16426907729920L, 122390);
    }
    return false;
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/pluginsdk/model/app/q.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */