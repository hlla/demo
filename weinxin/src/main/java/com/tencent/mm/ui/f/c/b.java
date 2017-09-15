package com.tencent.mm.ui.f.c;

import android.content.Context;
import com.tencent.gmtrace.GMTrace;

public final class b
{
  private static a wdQ;
  
  static
  {
    GMTrace.i(14613760442368L, 108881);
    wdQ = null;
    GMTrace.o(14613760442368L, 108881);
  }
  
  public static CharSequence a(Context paramContext, CharSequence paramCharSequence, float paramFloat)
  {
    GMTrace.i(14613492006912L, 108879);
    if (wdQ != null)
    {
      paramContext = wdQ.a(paramContext, paramCharSequence, paramFloat);
      GMTrace.o(14613492006912L, 108879);
      return paramContext;
    }
    GMTrace.o(14613492006912L, 108879);
    return paramCharSequence;
  }
  
  public static CharSequence a(Context paramContext, CharSequence paramCharSequence, int paramInt)
  {
    GMTrace.i(14613357789184L, 108878);
    if (wdQ != null)
    {
      paramContext = wdQ.a(paramContext, paramCharSequence, paramInt);
      GMTrace.o(14613357789184L, 108878);
      return paramContext;
    }
    GMTrace.o(14613357789184L, 108878);
    return paramCharSequence;
  }
  
  public static void a(a parama)
  {
    GMTrace.i(14613223571456L, 108877);
    wdQ = parama;
    GMTrace.o(14613223571456L, 108877);
  }
  
  public static int m(Context paramContext, String paramString, int paramInt)
  {
    GMTrace.i(14613626224640L, 108880);
    if (wdQ != null)
    {
      paramInt = wdQ.aG(paramString, paramInt);
      GMTrace.o(14613626224640L, 108880);
      return paramInt;
    }
    GMTrace.o(14613626224640L, 108880);
    return paramInt;
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/ui/f/c/b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */