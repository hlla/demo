package com.tencent.mm.svg.b;

import com.tencent.gmtrace.GMTrace;
import java.lang.reflect.Field;

public final class b
{
  private static String fwP;
  private static boolean gZD;
  private static boolean uLH;
  private static boolean uLI;
  
  static
  {
    GMTrace.i(3480265687040L, 25930);
    fwP = "";
    gZD = false;
    uLH = false;
    uLI = false;
    GMTrace.o(3480265687040L, 25930);
  }
  
  private static final Object Sv(String paramString)
  {
    GMTrace.i(3479594598400L, 25925);
    try
    {
      Class localClass = Class.forName(fwP + ".svg.SVGBuildConfig");
      paramString = localClass.getDeclaredField(paramString);
      paramString.setAccessible(true);
      paramString = paramString.get(localClass);
      GMTrace.o(3479594598400L, 25925);
      return paramString;
    }
    catch (NoSuchFieldException paramString)
    {
      c.printErrStackTrace("MicroMSG.WeChatSVGConfig", paramString, "NoSuchFieldException", new Object[0]);
      GMTrace.o(3479594598400L, 25925);
      return null;
    }
    catch (IllegalArgumentException paramString)
    {
      for (;;)
      {
        c.printErrStackTrace("MicroMSG.WeChatSVGConfig", paramString, "IllegalArgumentException", new Object[0]);
      }
    }
    catch (ClassNotFoundException paramString)
    {
      for (;;)
      {
        c.printErrStackTrace("MicroMSG.WeChatSVGConfig", paramString, "ClassNotFoundException", new Object[0]);
      }
    }
    catch (IllegalAccessException paramString)
    {
      for (;;)
      {
        c.printErrStackTrace("MicroMSG.WeChatSVGConfig", paramString, "IllegalAccessException", new Object[0]);
      }
    }
  }
  
  public static final boolean bNP()
  {
    GMTrace.i(3479326162944L, 25923);
    boolean bool = uLI;
    GMTrace.o(3479326162944L, 25923);
    return bool;
  }
  
  public static final boolean bNQ()
  {
    GMTrace.i(3479728816128L, 25926);
    Object localObject;
    if (!gZD)
    {
      localObject = Sv("WxSVGCode");
      if (localObject != null) {
        break label70;
      }
    }
    label70:
    for (uLH = false;; uLH = ((Boolean)localObject).booleanValue())
    {
      c.i("MicroMSG.WeChatSVGConfig", "Initialized mUsingWeChatSVGCode %s", new Object[] { Boolean.valueOf(uLH) });
      gZD = true;
      if (uLH) {
        break;
      }
      GMTrace.o(3479728816128L, 25926);
      return true;
    }
    GMTrace.o(3479728816128L, 25926);
    return false;
  }
  
  public static final Class<?> bNR()
  {
    GMTrace.i(3479863033856L, 25927);
    Object localObject = Sv("WxSVGRawClass");
    if (localObject != null)
    {
      localObject = (Class)localObject;
      GMTrace.o(3479863033856L, 25927);
      return (Class<?>)localObject;
    }
    GMTrace.o(3479863033856L, 25927);
    return null;
  }
  
  public static long bNS()
  {
    GMTrace.i(3479997251584L, 25928);
    long l = System.nanoTime();
    GMTrace.o(3479997251584L, 25928);
    return l;
  }
  
  public static void bl(String paramString)
  {
    GMTrace.i(3479191945216L, 25922);
    fwP = paramString;
    GMTrace.o(3479191945216L, 25922);
  }
  
  public static long eD(long paramLong)
  {
    GMTrace.i(3480131469312L, 25929);
    paramLong = (System.nanoTime() - paramLong) / 1000L;
    GMTrace.o(3480131469312L, 25929);
    return paramLong;
  }
  
  public static final void jY(boolean paramBoolean)
  {
    GMTrace.i(3479460380672L, 25924);
    uLI = paramBoolean;
    GMTrace.o(3479460380672L, 25924);
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/svg/b/b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */