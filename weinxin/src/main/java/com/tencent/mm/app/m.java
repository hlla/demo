package com.tencent.mm.app;

import android.app.Application;
import android.content.Context;
import android.content.res.Resources;
import com.tencent.gmtrace.GMTrace;
import com.tencent.mm.R.k;
import com.tencent.mm.kiss.a.b;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.svg.a.e;
import com.tencent.mm.svg.b.c.a;

public final class m
{
  private static Class<?> fwO;
  private static String fwP;
  
  static
  {
    GMTrace.i(15659450761216L, 116672);
    fwO = null;
    fwP = null;
    GMTrace.o(15659450761216L, 116672);
  }
  
  public static void a(Application paramApplication)
  {
    boolean bool = true;
    GMTrace.i(12978988515328L, 96701);
    v.i("MicroMsg.SVGInit", "SVG initSVGPreload");
    e.a(new c.a()
    {
      public final void d(String paramAnonymousString1, String paramAnonymousString2, Object... paramAnonymousVarArgs)
      {
        GMTrace.i(12971203887104L, 96643);
        v.d(paramAnonymousString1, paramAnonymousString2, paramAnonymousVarArgs);
        GMTrace.o(12971203887104L, 96643);
      }
      
      public final void e(String paramAnonymousString1, String paramAnonymousString2, Object... paramAnonymousVarArgs)
      {
        GMTrace.i(12971069669376L, 96642);
        v.e(paramAnonymousString1, paramAnonymousString2, paramAnonymousVarArgs);
        GMTrace.o(12971069669376L, 96642);
      }
      
      public final void i(String paramAnonymousString1, String paramAnonymousString2, Object... paramAnonymousVarArgs)
      {
        GMTrace.i(12970935451648L, 96641);
        v.i(paramAnonymousString1, paramAnonymousString2, paramAnonymousVarArgs);
        GMTrace.o(12970935451648L, 96641);
      }
      
      public final void printErrStackTrace(String paramAnonymousString1, Throwable paramAnonymousThrowable, String paramAnonymousString2, Object... paramAnonymousVarArgs)
      {
        GMTrace.i(12971338104832L, 96644);
        v.printErrStackTrace(paramAnonymousString1, paramAnonymousThrowable, paramAnonymousString2, paramAnonymousVarArgs);
        GMTrace.o(12971338104832L, 96644);
      }
    });
    e.d(fwO);
    e.b(paramApplication, fwP);
    for (;;)
    {
      try
      {
        paramApplication = paramApplication.getBaseContext().getResources().getDrawable(R.k.dsE);
        if (paramApplication != null)
        {
          i = 1;
          paramApplication = b.vS();
          if (i == 0)
          {
            paramApplication.gZE = bool;
            GMTrace.o(12978988515328L, 96701);
            return;
          }
          bool = false;
          continue;
        }
        int i = 0;
      }
      catch (Throwable paramApplication)
      {
        v.printErrStackTrace("MicroMsg.SVGInit", paramApplication, "not support get svg from application context", new Object[0]);
        b.vS().gZE = true;
        GMTrace.o(12978988515328L, 96701);
        return;
      }
      finally
      {
        b.vS().gZE = true;
      }
    }
  }
  
  public static void bl(String paramString)
  {
    GMTrace.i(15659316543488L, 116671);
    fwP = paramString;
    GMTrace.o(15659316543488L, 116671);
  }
  
  public static void d(Class<?> paramClass)
  {
    GMTrace.i(15659182325760L, 116670);
    fwO = paramClass;
    GMTrace.o(15659182325760L, 116670);
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/app/m.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */