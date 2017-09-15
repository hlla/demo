package com.tencent.tinker.loader;

import android.content.Context;
import android.content.Intent;
import com.tencent.tinker.loader.app.TinkerApplication;
import com.tencent.tinker.loader.shareutil.ShareIntentUtil;
import com.tencent.tinker.loader.shareutil.SharePatchFileUtil;
import com.tencent.tinker.loader.shareutil.ShareResPatchInfo;
import com.tencent.tinker.loader.shareutil.ShareSecurityCheck;
import java.io.File;
import java.util.HashMap;

public class TinkerResourceLoader
{
  private static ShareResPatchInfo xfh = new ShareResPatchInfo();
  
  public static boolean a(Context paramContext, String paramString, ShareSecurityCheck paramShareSecurityCheck, Intent paramIntent)
  {
    paramShareSecurityCheck = (String)paramShareSecurityCheck.xgN.get("assets/res_meta.txt");
    if (paramShareSecurityCheck == null) {
      return true;
    }
    ShareResPatchInfo.b(paramShareSecurityCheck, xfh);
    if (xfh.xgF == null) {
      return true;
    }
    if (!ShareResPatchInfo.a(xfh))
    {
      paramIntent.putExtra("intent_patch_package_patch_check", -8);
      ShareIntentUtil.a(paramIntent, -8);
      return false;
    }
    paramString = paramString + "/res/";
    paramShareSecurityCheck = new File(paramString);
    if ((!paramShareSecurityCheck.exists()) || (!paramShareSecurityCheck.isDirectory()))
    {
      ShareIntentUtil.a(paramIntent, -21);
      return false;
    }
    if (!SharePatchFileUtil.U(new File(paramString + "resources.apk")))
    {
      ShareIntentUtil.a(paramIntent, -22);
      return false;
    }
    try
    {
      TinkerResourcePatcher.hv(paramContext);
      return true;
    }
    catch (Throwable paramContext)
    {
      paramIntent.putExtra("intent_patch_exception", paramContext);
      ShareIntentUtil.a(paramIntent, -23);
    }
    return false;
  }
  
  public static boolean a(TinkerApplication paramTinkerApplication, String paramString, Intent paramIntent)
  {
    if ((xfh == null) || (xfh.xgF == null)) {
      return true;
    }
    paramString = paramString + "/res/resources.apk";
    File localFile = new File(paramString);
    long l = System.currentTimeMillis();
    if (paramTinkerApplication.isTinkerLoadVerifyFlag())
    {
      if (!SharePatchFileUtil.g(localFile, xfh.xgF))
      {
        new StringBuilder("Failed to load resource file, path: ").append(localFile.getPath()).append(", expect md5: ").append(xfh.xgF);
        ShareIntentUtil.a(paramIntent, -24);
        return false;
      }
      new StringBuilder("verify resource file:").append(localFile.getPath()).append(" md5, use time: ").append(System.currentTimeMillis() - l);
    }
    try
    {
      TinkerResourcePatcher.bJ(paramTinkerApplication, paramString);
      new StringBuilder("monkeyPatchExistingResources resource file:").append(paramString).append(", use time: ").append(System.currentTimeMillis() - l);
      return true;
    }
    catch (Throwable paramString) {}
    try
    {
      SystemClassLoaderAdder.a(paramTinkerApplication.getClassLoader());
      paramIntent.putExtra("intent_patch_exception", paramString);
      ShareIntentUtil.a(paramIntent, -23);
      return false;
    }
    catch (Throwable paramTinkerApplication)
    {
      for (;;) {}
    }
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/tinker/loader/TinkerResourceLoader.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */