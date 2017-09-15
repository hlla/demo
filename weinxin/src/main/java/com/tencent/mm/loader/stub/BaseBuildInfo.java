package com.tencent.mm.loader.stub;

import android.os.Build.VERSION;
import com.tencent.gmtrace.GMTrace;

public class BaseBuildInfo
{
  public static String BUILD_TAG;
  public static String CLIENT_VERSION;
  public static String COMMAND;
  public static String DEVICE_TYPE;
  public static boolean ENABLE_STETHO;
  public static String HOSTNAME;
  public static String OWNER;
  private static String PATCH_ENABLED;
  public static String PATCH_REV;
  public static int PATCH_TINKER_FLAG;
  public static String REV;
  public static String SVNPATH;
  public static String TIME;
  
  static
  {
    GMTrace.i(14007767400448L, 104366);
    PATCH_ENABLED = "true";
    REV = "ca4a8f7bab4a88eed5ec7f4a36098b8c31e6479b";
    CLIENT_VERSION = "0x26050D33";
    DEVICE_TYPE = "android-" + Build.VERSION.SDK_INT;
    TIME = "2017-08-21 07:05:29";
    HOSTNAME = "8c5ae9bb494e";
    BUILD_TAG = "MicroMessenger_Android_GIT_RELEASE_GRADLE #4216";
    OWNER = "amm_code_helper";
    COMMAND = "null";
    SVNPATH = "origin/RB-2017-JUL@git";
    PATCH_REV = null;
    PATCH_TINKER_FLAG = 7;
    ENABLE_STETHO = false;
    GMTrace.o(14007767400448L, 104366);
  }
  
  public BaseBuildInfo()
  {
    GMTrace.i(14007230529536L, 104362);
    GMTrace.o(14007230529536L, 104362);
  }
  
  public static String baseRevision()
  {
    GMTrace.i(14007498964992L, 104364);
    String str = REV;
    GMTrace.o(14007498964992L, 104364);
    return str;
  }
  
  public static String codeRevision()
  {
    GMTrace.i(14007364747264L, 104363);
    if (PATCH_REV == null)
    {
      str = REV;
      GMTrace.o(14007364747264L, 104363);
      return str;
    }
    String str = REV + "." + PATCH_REV;
    GMTrace.o(14007364747264L, 104363);
    return str;
  }
  
  public static boolean patchEnabled()
  {
    GMTrace.i(14007633182720L, 104365);
    if (!"false".equalsIgnoreCase(PATCH_ENABLED))
    {
      GMTrace.o(14007633182720L, 104365);
      return true;
    }
    GMTrace.o(14007633182720L, 104365);
    return false;
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/loader/stub/BaseBuildInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */