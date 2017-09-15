package com.tencent.mm.sdk.platformtools;

import com.tencent.gmtrace.GMTrace;
import com.tencent.mm.loader.stub.BaseBuildInfo;

public final class e
{
  public static String BUILD_TAG;
  public static String CLIENT_VERSION;
  public static String COMMAND;
  public static boolean DEBUG;
  public static String HOSTNAME;
  public static String OWNER;
  public static String REV;
  public static String SVNPATH;
  public static String TIME;
  public static boolean uqC;
  
  static
  {
    GMTrace.i(13954885615616L, 103972);
    DEBUG = false;
    BUILD_TAG = "MicroMessenger_Android_GIT_RELEASE_GRADLE #4216";
    OWNER = "amm_code_helper";
    HOSTNAME = "8c5ae9bb494e";
    TIME = "2017-08-21 07:05:29";
    COMMAND = "null";
    REV = "ca4a8f7bab4a88eed5ec7f4a36098b8c31e6479b";
    SVNPATH = "origin/RB-2017-JUL@git";
    CLIENT_VERSION = "0x26050D33";
    uqC = true;
    GMTrace.o(13954885615616L, 103972);
  }
  
  public static String aKl()
  {
    GMTrace.i(13954751397888L, 103971);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(String.format("[b.ver] %s\n", new Object[] { a.ew(CLIENT_VERSION, BaseBuildInfo.CLIENT_VERSION) }));
    localStringBuilder.append(String.format("[tag  ] %s\n", new Object[] { a.ew(BUILD_TAG, BaseBuildInfo.BUILD_TAG) }));
    localStringBuilder.append(String.format("[by   ] %s\n", new Object[] { a.ew(OWNER, BaseBuildInfo.OWNER) }));
    localStringBuilder.append(String.format("[host ] %s\n", new Object[] { a.ew(HOSTNAME, BaseBuildInfo.HOSTNAME) }));
    localStringBuilder.append(String.format("[time ] %s\n", new Object[] { a.ew(TIME, BaseBuildInfo.TIME) }));
    localStringBuilder.append(String.format("[cmd  ] %s\n", new Object[] { a.ew(COMMAND, BaseBuildInfo.COMMAND) }));
    localStringBuilder.append(String.format("[path ] %s\n", new Object[] { a.ew(a.ev(SVNPATH, "MicroMsg_proj"), a.ev(BaseBuildInfo.SVNPATH, "MicroMsg_proj")) }));
    localStringBuilder.append(String.format("[rev  ] %s\n", new Object[] { a.ew(REV, BaseBuildInfo.REV) }));
    if (BaseBuildInfo.patchEnabled()) {}
    for (String str = BaseBuildInfo.codeRevision();; str = "disabled")
    {
      localStringBuilder.append(String.format("[p.rev] %s\n", new Object[] { str }));
      str = localStringBuilder.toString();
      GMTrace.o(13954751397888L, 103971);
      return str;
    }
  }
  
  private static final class a
  {
    public static String ev(String paramString1, String paramString2)
    {
      GMTrace.i(13930323771392L, 103789);
      if (paramString1 == null)
      {
        GMTrace.o(13930323771392L, 103789);
        return null;
      }
      int i = paramString1.indexOf(paramString2);
      if (i < 0)
      {
        GMTrace.o(13930323771392L, 103789);
        return paramString1;
      }
      paramString1 = paramString1.substring(i);
      GMTrace.o(13930323771392L, 103789);
      return paramString1;
    }
    
    public static String ew(String paramString1, String paramString2)
    {
      GMTrace.i(13930457989120L, 103790);
      if (paramString1 == null)
      {
        GMTrace.o(13930457989120L, 103790);
        return null;
      }
      if (paramString1.equals(paramString2))
      {
        GMTrace.o(13930457989120L, 103790);
        return paramString1;
      }
      paramString1 = String.format("%s(%s)", new Object[] { paramString1, paramString2 });
      GMTrace.o(13930457989120L, 103790);
      return paramString1;
    }
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/sdk/platformtools/e.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */