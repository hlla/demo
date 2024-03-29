package com.tencent.tinker.loader;

import android.annotation.TargetApi;
import android.content.Intent;
import com.tencent.tinker.loader.app.TinkerApplication;
import com.tencent.tinker.loader.shareutil.ShareConstants;
import com.tencent.tinker.loader.shareutil.ShareDexDiffPatchInfo;
import com.tencent.tinker.loader.shareutil.ShareIntentUtil;
import com.tencent.tinker.loader.shareutil.SharePatchFileUtil;
import com.tencent.tinker.loader.shareutil.ShareSecurityCheck;
import com.tencent.tinker.loader.shareutil.ShareTinkerInternals;
import dalvik.system.PathClassLoader;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TinkerDexLoader
{
  private static boolean xdZ = ShareTinkerInternals.cgK();
  private static final ArrayList<ShareDexDiffPatchInfo> xeX = new ArrayList();
  private static HashSet<ShareDexDiffPatchInfo> xeY = new HashSet();
  
  private static void VL(String paramString)
  {
    SharePatchFileUtil.aP(paramString + "/odex/");
    if (ShareTinkerInternals.cgM()) {
      SharePatchFileUtil.aP(paramString + "/oat/");
    }
  }
  
  private static String a(ShareDexDiffPatchInfo paramShareDexDiffPatchInfo)
  {
    if (xdZ) {
      return paramShareDexDiffPatchInfo.xfy;
    }
    return paramShareDexDiffPatchInfo.xfx;
  }
  
  @TargetApi(14)
  public static boolean a(TinkerApplication paramTinkerApplication, String paramString1, String paramString2, Intent paramIntent, boolean paramBoolean)
  {
    if ((xeX.isEmpty()) && (xeY.isEmpty())) {
      return true;
    }
    PathClassLoader localPathClassLoader = (PathClassLoader)TinkerDexLoader.class.getClassLoader();
    Object localObject1;
    ArrayList localArrayList;
    final Object localObject2;
    if (localPathClassLoader != null)
    {
      new StringBuilder("classloader: ").append(localPathClassLoader.toString());
      localObject1 = paramString1 + "/dex/";
      localArrayList = new ArrayList();
      localObject2 = xeX.iterator();
    }
    Object localObject3;
    long l;
    while (((Iterator)localObject2).hasNext())
    {
      localObject3 = (ShareDexDiffPatchInfo)((Iterator)localObject2).next();
      if (!b((ShareDexDiffPatchInfo)localObject3))
      {
        File localFile = new File((String)localObject1 + ((ShareDexDiffPatchInfo)localObject3).gTO);
        if (paramTinkerApplication.isTinkerLoadVerifyFlag())
        {
          l = System.currentTimeMillis();
          if (!SharePatchFileUtil.f(localFile, a((ShareDexDiffPatchInfo)localObject3)))
          {
            ShareIntentUtil.a(paramIntent, -13);
            paramIntent.putExtra("intent_patch_mismatch_dex_path", localFile.getAbsolutePath());
            return false;
            ShareIntentUtil.a(paramIntent, -12);
            return false;
          }
          new StringBuilder("verify dex file:").append(localFile.getPath()).append(" md5, use time: ").append(System.currentTimeMillis() - l);
        }
        localArrayList.add(localFile);
      }
    }
    if ((xdZ) && (!xeY.isEmpty()))
    {
      localObject1 = new File((String)localObject1 + "tinker_classN.apk");
      l = System.currentTimeMillis();
      if (paramTinkerApplication.isTinkerLoadVerifyFlag())
      {
        localObject2 = xeY.iterator();
        while (((Iterator)localObject2).hasNext())
        {
          localObject3 = (ShareDexDiffPatchInfo)((Iterator)localObject2).next();
          if (!SharePatchFileUtil.b((File)localObject1, ((ShareDexDiffPatchInfo)localObject3).xfw, ((ShareDexDiffPatchInfo)localObject3).xfy))
          {
            ShareIntentUtil.a(paramIntent, -13);
            paramIntent.putExtra("intent_patch_mismatch_dex_path", ((File)localObject1).getAbsolutePath());
            return false;
          }
        }
      }
      new StringBuilder("verify dex file:").append(((File)localObject1).getPath()).append(" md5, use time: ").append(System.currentTimeMillis() - l);
      localArrayList.add(localObject1);
    }
    paramString2 = new File(paramString1 + "/" + paramString2);
    if (paramBoolean)
    {
      localObject1 = new boolean[1];
      localObject1[0] = 1;
      localObject2 = new Throwable[1];
      try
      {
        localObject3 = ShareTinkerInternals.cgN();
        VL(paramString1);
        paramString2 = new File(paramString1 + "/interpet");
        TinkerDexOptimizer.a(localArrayList, paramString2, true, (String)localObject3, new TinkerDexOptimizer.ResultCallback()
        {
          long start;
          
          public final void N(File paramAnonymousFile)
          {
            this.start = System.currentTimeMillis();
            new StringBuilder("start to optimize dex:").append(paramAnonymousFile.getPath());
          }
          
          public final void b(File paramAnonymousFile, Throwable paramAnonymousThrowable)
          {
            this.xeZ[0] = false;
            localObject2[0] = paramAnonymousThrowable;
            new StringBuilder("fail to optimize dex ").append(paramAnonymousFile.getPath()).append(", use time ").append(System.currentTimeMillis() - this.start);
          }
          
          public final void j(File paramAnonymousFile1, File paramAnonymousFile2)
          {
            new StringBuilder("success to optimize dex ").append(paramAnonymousFile1.getPath()).append(", use time ").append(System.currentTimeMillis() - this.start);
          }
        });
        if (localObject1[0] == 0)
        {
          paramIntent.putExtra("intent_patch_interpret_exception", localObject2[0]);
          ShareIntentUtil.a(paramIntent, -16);
          return false;
        }
      }
      catch (Throwable paramTinkerApplication)
      {
        new StringBuilder("getCurrentInstructionSet fail:").append(paramTinkerApplication);
        VL(paramString1);
        paramIntent.putExtra("intent_patch_interpret_exception", paramTinkerApplication);
        ShareIntentUtil.a(paramIntent, -15);
        return false;
      }
    }
    try
    {
      SystemClassLoaderAdder.a(paramTinkerApplication, localPathClassLoader, paramString2, localArrayList);
      return true;
    }
    catch (Throwable paramTinkerApplication)
    {
      paramIntent.putExtra("intent_patch_exception", paramTinkerApplication);
      ShareIntentUtil.a(paramIntent, -14);
    }
    return false;
  }
  
  public static boolean a(String paramString1, ShareSecurityCheck paramShareSecurityCheck, String paramString2, Intent paramIntent)
  {
    Object localObject = (String)paramShareSecurityCheck.xgN.get("assets/dex_meta.txt");
    if (localObject == null) {
      return true;
    }
    xeX.clear();
    xeY.clear();
    paramShareSecurityCheck = new ArrayList();
    ShareDexDiffPatchInfo.k((String)localObject, paramShareSecurityCheck);
    if (paramShareSecurityCheck.isEmpty()) {
      return true;
    }
    HashMap localHashMap = new HashMap();
    Iterator localIterator = paramShareSecurityCheck.iterator();
    paramShareSecurityCheck = null;
    while (localIterator.hasNext())
    {
      localObject = (ShareDexDiffPatchInfo)localIterator.next();
      if (!b((ShareDexDiffPatchInfo)localObject))
      {
        if (!ShareDexDiffPatchInfo.c((ShareDexDiffPatchInfo)localObject))
        {
          paramIntent.putExtra("intent_patch_package_patch_check", -3);
          ShareIntentUtil.a(paramIntent, -8);
          return false;
        }
        if ((xdZ) && (((ShareDexDiffPatchInfo)localObject).xfw.startsWith("test.dex")))
        {
          paramShareSecurityCheck = (ShareSecurityCheck)localObject;
        }
        else if ((xdZ) && (ShareConstants.xfv.matcher(((ShareDexDiffPatchInfo)localObject).gTO).matches()))
        {
          xeY.add(localObject);
        }
        else
        {
          localHashMap.put(((ShareDexDiffPatchInfo)localObject).gTO, a((ShareDexDiffPatchInfo)localObject));
          xeX.add(localObject);
        }
      }
    }
    if ((xdZ) && (!xeY.isEmpty()))
    {
      if (paramShareSecurityCheck != null) {
        xeY.add(ShareTinkerInternals.a(paramShareSecurityCheck, xeY.size() + 1));
      }
      localHashMap.put("tinker_classN.apk", "");
    }
    paramShareSecurityCheck = paramString1 + "/dex/";
    localObject = new File(paramShareSecurityCheck);
    if ((!((File)localObject).exists()) || (!((File)localObject).isDirectory()))
    {
      ShareIntentUtil.a(paramIntent, -9);
      return false;
    }
    paramString1 = new File(paramString1 + "/" + paramString2 + "/");
    paramString2 = localHashMap.keySet().iterator();
    while (paramString2.hasNext())
    {
      localObject = (String)paramString2.next();
      localObject = new File(paramShareSecurityCheck + (String)localObject);
      if (!SharePatchFileUtil.U((File)localObject))
      {
        paramIntent.putExtra("intent_patch_missing_dex_path", ((File)localObject).getAbsolutePath());
        ShareIntentUtil.a(paramIntent, -10);
        return false;
      }
      localObject = new File(SharePatchFileUtil.l((File)localObject, paramString1));
      if (!SharePatchFileUtil.U((File)localObject))
      {
        paramIntent.putExtra("intent_patch_missing_dex_path", ((File)localObject).getAbsolutePath());
        ShareIntentUtil.a(paramIntent, -11);
        return false;
      }
    }
    paramIntent.putExtra("intent_patch_dexes_path", localHashMap);
    return true;
  }
  
  private static boolean b(ShareDexDiffPatchInfo paramShareDexDiffPatchInfo)
  {
    if (xdZ) {}
    while (!paramShareDexDiffPatchInfo.xfx.equals("0")) {
      return false;
    }
    return true;
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/tinker/loader/TinkerDexLoader.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */