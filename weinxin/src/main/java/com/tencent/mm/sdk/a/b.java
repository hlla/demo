package com.tencent.mm.sdk.a;

import com.tencent.gmtrace.GMTrace;

public final class b
{
  public static boolean foreground;
  public static String uqf;
  private static c uqg;
  private static boolean uqh;
  private static String uqi;
  private static boolean uqj;
  private static boolean uqk;
  
  static
  {
    GMTrace.i(13866973003776L, 103317);
    foreground = false;
    uqf = "unknow";
    uqg = null;
    uqh = false;
    uqi = null;
    uqj = false;
    uqk = false;
    GMTrace.o(13866973003776L, 103317);
  }
  
  public static void OZ(String paramString)
  {
    GMTrace.i(13865899261952L, 103309);
    uqf = paramString;
    GMTrace.o(13865899261952L, 103309);
  }
  
  public static void Pa(String paramString)
  {
    GMTrace.i(13866704568320L, 103315);
    uqi = paramString;
    GMTrace.o(13866704568320L, 103315);
  }
  
  public static void a(a parama)
  {
    GMTrace.i(13866033479680L, 103310);
    if (uqg != null) {
      uqg.a(parama);
    }
    GMTrace.o(13866033479680L, 103310);
  }
  
  public static void a(c paramc)
  {
    GMTrace.i(13865362391040L, 103305);
    uqg = paramc;
    GMTrace.o(13865362391040L, 103305);
  }
  
  public static void aX(boolean paramBoolean)
  {
    GMTrace.i(13865765044224L, 103308);
    foreground = paramBoolean;
    GMTrace.o(13865765044224L, 103308);
  }
  
  public static boolean bIi()
  {
    GMTrace.i(13866301915136L, 103312);
    boolean bool = uqj;
    GMTrace.o(13866301915136L, 103312);
    return bool;
  }
  
  public static void bIj()
  {
    GMTrace.i(13866436132864L, 103313);
    uqh = true;
    GMTrace.o(13866436132864L, 103313);
  }
  
  public static boolean bIk()
  {
    GMTrace.i(13866570350592L, 103314);
    boolean bool = uqh;
    GMTrace.o(13866570350592L, 103314);
    return bool;
  }
  
  public static String bIl()
  {
    GMTrace.i(13866838786048L, 103316);
    String str = uqi;
    GMTrace.o(13866838786048L, 103316);
    return str;
  }
  
  public static boolean bIm()
  {
    GMTrace.i(18798400765952L, 140059);
    boolean bool = uqk;
    GMTrace.o(18798400765952L, 140059);
    return bool;
  }
  
  public static void h(int paramInt, String paramString)
  {
    GMTrace.i(13865630826496L, 103307);
    if (uqg != null) {
      uqg.h(paramInt, paramString);
    }
    GMTrace.o(13865630826496L, 103307);
  }
  
  public static void jM(boolean paramBoolean)
  {
    GMTrace.i(13866167697408L, 103311);
    uqj = paramBoolean;
    GMTrace.o(13866167697408L, 103311);
  }
  
  public static void jN(boolean paramBoolean)
  {
    GMTrace.i(18982144835584L, 141428);
    uqk = paramBoolean;
    GMTrace.o(18982144835584L, 141428);
  }
  
  public static void r(String paramString1, String paramString2)
  {
    GMTrace.i(13865496608768L, 103306);
    if (uqg != null) {
      uqg.r(paramString1, paramString2);
    }
    GMTrace.o(13865496608768L, 103306);
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/sdk/a/b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */