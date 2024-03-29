package com.tencent.tinker.loader;

import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Build;
import android.os.Build.VERSION;
import android.os.SystemClock;
import com.tencent.tinker.loader.app.TinkerApplication;
import com.tencent.tinker.loader.shareutil.ShareIntentUtil;
import com.tencent.tinker.loader.shareutil.SharePatchFileUtil;
import com.tencent.tinker.loader.shareutil.SharePatchInfo;
import com.tencent.tinker.loader.shareutil.ShareSecurityCheck;
import com.tencent.tinker.loader.shareutil.ShareTinkerInternals;
import java.io.File;

public class TinkerLoader
  extends AbstractTinkerLoader
{
  private static final String TAG = "Tinker.TinkerLoader";
  private SharePatchInfo patchInfo;
  
  private boolean checkSafeModeCount(TinkerApplication paramTinkerApplication)
  {
    String str = ShareTinkerInternals.hH(paramTinkerApplication);
    str = "tinker_own_config_" + str;
    SharedPreferences localSharedPreferences = paramTinkerApplication.getSharedPreferences(str, 0);
    int i = localSharedPreferences.getInt("safe_mode_count", 0) + 1;
    new StringBuilder("tinker safe mode preferName:").append(str).append(" count:").append(i);
    if (i >= 3)
    {
      localSharedPreferences.edit().putInt("safe_mode_count", 0).commit();
      return false;
    }
    paramTinkerApplication.setUseSafeMode(true);
    localSharedPreferences.edit().putInt("safe_mode_count", i).commit();
    return true;
  }
  
  private void tryLoadPatchFilesInternal(TinkerApplication paramTinkerApplication, Intent paramIntent)
  {
    int k = paramTinkerApplication.getTinkerFlags();
    if (!ShareTinkerInternals.DT(k))
    {
      ShareIntentUtil.a(paramIntent, -1);
      return;
    }
    if (ShareTinkerInternals.hF(paramTinkerApplication))
    {
      ShareIntentUtil.a(paramIntent, -1);
      return;
    }
    Object localObject1 = SharePatchFileUtil.hx(paramTinkerApplication);
    if (localObject1 == null)
    {
      ShareIntentUtil.a(paramIntent, -2);
      return;
    }
    Object localObject3 = ((File)localObject1).getAbsolutePath();
    if (!((File)localObject1).exists())
    {
      ShareIntentUtil.a(paramIntent, -2);
      return;
    }
    File localFile1 = SharePatchFileUtil.VM((String)localObject3);
    if (!localFile1.exists())
    {
      new StringBuilder("tryLoadPatchFiles:patch info not exist:").append(localFile1.getAbsolutePath());
      ShareIntentUtil.a(paramIntent, -3);
      return;
    }
    File localFile2 = SharePatchFileUtil.VN((String)localObject3);
    this.patchInfo = SharePatchInfo.m(localFile1, localFile2);
    if (this.patchInfo == null)
    {
      ShareIntentUtil.a(paramIntent, -4);
      return;
    }
    localObject1 = this.patchInfo.xgB;
    String str = this.patchInfo.xgC;
    Object localObject2 = this.patchInfo.xew;
    if ((localObject1 == null) || (str == null) || (localObject2 == null))
    {
      ShareIntentUtil.a(paramIntent, -4);
      return;
    }
    paramIntent.putExtra("intent_patch_old_version", (String)localObject1);
    paramIntent.putExtra("intent_patch_new_version", str);
    boolean bool3 = ShareTinkerInternals.hE(paramTinkerApplication);
    int j;
    label231:
    int i;
    if (!((String)localObject1).equals(str))
    {
      j = 1;
      if ((!((String)localObject2).equals("changing")) || (!bool3)) {
        break label300;
      }
      i = 1;
      label248:
      localObject2 = ShareTinkerInternals.bK(paramTinkerApplication, (String)localObject2);
      paramIntent.putExtra("intent_patch_oat_dir", (String)localObject2);
      if ((j == 0) || (!bool3)) {
        break label836;
      }
      localObject1 = str;
    }
    label300:
    label661:
    label836:
    for (;;)
    {
      if (ShareTinkerInternals.mA((String)localObject1))
      {
        ShareIntentUtil.a(paramIntent, -5);
        return;
        j = 0;
        break label231;
        i = 0;
        break label248;
      }
      str = SharePatchFileUtil.VO((String)localObject1);
      if (str == null)
      {
        ShareIntentUtil.a(paramIntent, -6);
        return;
      }
      str = (String)localObject3 + "/" + str;
      localObject3 = new File(str);
      if (!((File)localObject3).exists())
      {
        ShareIntentUtil.a(paramIntent, -6);
        return;
      }
      localObject3 = new File(((File)localObject3).getAbsolutePath(), SharePatchFileUtil.VP((String)localObject1));
      if (!SharePatchFileUtil.U((File)localObject3))
      {
        ShareIntentUtil.a(paramIntent, -7);
        return;
      }
      ShareSecurityCheck localShareSecurityCheck = new ShareSecurityCheck(paramTinkerApplication);
      int m = ShareTinkerInternals.a(paramTinkerApplication, k, (File)localObject3, localShareSecurityCheck);
      if (m != 0)
      {
        paramIntent.putExtra("intent_patch_package_patch_check", m);
        ShareIntentUtil.a(paramIntent, -8);
        return;
      }
      paramIntent.putExtra("intent_patch_package_config", localShareSecurityCheck.cgJ());
      boolean bool4 = ShareTinkerInternals.DP(k);
      if (((bool4) && (!TinkerDexLoader.a(str, localShareSecurityCheck, (String)localObject2, paramIntent))) || ((ShareTinkerInternals.DQ(k)) && (!TinkerSoLoader.a(str, localShareSecurityCheck, paramIntent)))) {
        break;
      }
      boolean bool2 = ShareTinkerInternals.DR(k);
      if ((bool2) && (!TinkerResourceLoader.a(paramTinkerApplication, str, localShareSecurityCheck, paramIntent))) {
        break;
      }
      if ((ShareTinkerInternals.cgK()) && (ShareTinkerInternals.VS(this.patchInfo.xgD)) && (Build.VERSION.SDK_INT >= 21)) {}
      for (boolean bool1 = true;; bool1 = false)
      {
        paramIntent.putExtra("intent_patch_system_ota", bool1);
        if (((!bool3) || (j == 0)) && (i == 0)) {
          break label661;
        }
        this.patchInfo.xgB = ((String)localObject1);
        this.patchInfo.xew = ((String)localObject2);
        if (SharePatchInfo.a(localFile1, this.patchInfo, localFile2)) {
          break;
        }
        ShareIntentUtil.a(paramIntent, -19);
        return;
      }
      if (i != 0) {
        SharePatchFileUtil.aP(str + "/interpet");
      }
      if (!checkSafeModeCount(paramTinkerApplication))
      {
        paramIntent.putExtra("intent_patch_exception", new TinkerRuntimeException("checkSafeModeCount fail"));
        ShareIntentUtil.a(paramIntent, -25);
        return;
      }
      j = i;
      if (bool4)
      {
        bool3 = TinkerDexLoader.a(paramTinkerApplication, str, (String)localObject2, paramIntent, bool1);
        if (bool1)
        {
          this.patchInfo.xgD = Build.FINGERPRINT;
          localObject2 = this.patchInfo;
          if (bool3) {}
          for (localObject1 = "interpet";; localObject1 = "odex")
          {
            ((SharePatchInfo)localObject2).xew = ((String)localObject1);
            i = 0;
            if (SharePatchInfo.a(localFile1, this.patchInfo, localFile2)) {
              break;
            }
            ShareIntentUtil.a(paramIntent, -19);
            return;
          }
          paramIntent.putExtra("intent_patch_oat_dir", this.patchInfo.xew);
        }
        if (!bool3) {
          break;
        }
        j = i;
      }
      if ((bool2) && (!TinkerResourceLoader.a(paramTinkerApplication, str, paramIntent))) {
        break;
      }
      if (j != 0) {
        ShareTinkerInternals.hG(paramTinkerApplication);
      }
      ShareIntentUtil.a(paramIntent, 0);
      return;
    }
  }
  
  public Intent tryLoad(TinkerApplication paramTinkerApplication)
  {
    Intent localIntent = new Intent();
    long l = SystemClock.elapsedRealtime();
    tryLoadPatchFilesInternal(paramTinkerApplication, localIntent);
    ShareIntentUtil.a(localIntent, SystemClock.elapsedRealtime() - l);
    return localIntent;
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/tinker/loader/TinkerLoader.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */