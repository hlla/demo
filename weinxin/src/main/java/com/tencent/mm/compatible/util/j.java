package com.tencent.mm.compatible.util;

import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.res.Resources;
import android.graphics.Rect;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.app.d;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import com.tencent.gmtrace.GMTrace;
import com.tencent.mm.sdk.platformtools.aa;
import com.tencent.mm.sdk.platformtools.v;

public final class j
{
  private static int gSI;
  private static int gSJ;
  private static boolean gSK;
  private static int gSL;
  private static int gSM;
  
  static
  {
    GMTrace.i(13783758012416L, 102697);
    gSI = -1;
    gSJ = -1;
    gSK = false;
    gSL = -1;
    gSM = -1;
    GMTrace.o(13783758012416L, 102697);
  }
  
  public static final int aB(Context paramContext)
  {
    GMTrace.i(13782818488320L, 102690);
    if (!gSK)
    {
      if (gSL > 0)
      {
        i = gSL;
        GMTrace.o(13782818488320L, 102690);
        return i;
      }
      if (!aE(paramContext))
      {
        GMTrace.o(13782818488320L, 102690);
        return 1140;
      }
      i = com.tencent.mm.bg.a.fromDPToPix(paramContext, 380);
      gSL = i;
      GMTrace.o(13782818488320L, 102690);
      return i;
    }
    int i = aC(paramContext);
    GMTrace.o(13782818488320L, 102690);
    return i;
  }
  
  public static final int aC(Context paramContext)
  {
    GMTrace.i(13782952706048L, 102691);
    if (gSM > 0)
    {
      i = gSM;
      GMTrace.o(13782952706048L, 102691);
      return i;
    }
    if (!aE(paramContext))
    {
      i = gSM;
      GMTrace.o(13782952706048L, 102691);
      return i * 3;
    }
    int i = com.tencent.mm.bg.a.fromDPToPix(paramContext, 230);
    gSM = i;
    GMTrace.o(13782952706048L, 102691);
    return i;
  }
  
  public static final int aD(Context paramContext)
  {
    GMTrace.i(13783221141504L, 102693);
    int i = p(paramContext, -1);
    GMTrace.o(13783221141504L, 102693);
    return i;
  }
  
  private static final boolean aE(Context paramContext)
  {
    GMTrace.i(13783355359232L, 102694);
    Context localContext = paramContext;
    if (paramContext == null) {
      localContext = aa.getContext();
    }
    if (localContext != null)
    {
      GMTrace.o(13783355359232L, 102694);
      return true;
    }
    GMTrace.o(13783355359232L, 102694);
    return false;
  }
  
  public static boolean aF(Context paramContext)
  {
    GMTrace.i(13783489576960L, 102695);
    paramContext = aG(paramContext);
    if (paramContext[0] < paramContext[1]) {}
    for (int i = 1; i == 1; i = 2)
    {
      GMTrace.o(13783489576960L, 102695);
      return true;
    }
    GMTrace.o(13783489576960L, 102695);
    return false;
  }
  
  public static int[] aG(Context paramContext)
  {
    GMTrace.i(13783623794688L, 102696);
    if (paramContext == null) {
      paramContext = aa.getContext();
    }
    for (;;)
    {
      int[] arrayOfInt = new int[2];
      if ((paramContext instanceof Activity))
      {
        DisplayMetrics localDisplayMetrics = new DisplayMetrics();
        ((Activity)paramContext).getWindowManager().getDefaultDisplay().getMetrics(localDisplayMetrics);
        arrayOfInt[0] = localDisplayMetrics.widthPixels;
        arrayOfInt[1] = localDisplayMetrics.heightPixels;
      }
      for (;;)
      {
        GMTrace.o(13783623794688L, 102696);
        return arrayOfInt;
        paramContext = ((WindowManager)paramContext.getSystemService("window")).getDefaultDisplay();
        arrayOfInt[0] = paramContext.getWidth();
        arrayOfInt[1] = paramContext.getHeight();
      }
    }
  }
  
  public static final int c(Context paramContext, boolean paramBoolean)
  {
    GMTrace.i(13782281617408L, 102686);
    if (!gSK)
    {
      if ((gSI > 0) && (paramBoolean))
      {
        i = gSI;
        GMTrace.o(13782281617408L, 102686);
        return i;
      }
      if (!gSK)
      {
        if (!aE(paramContext))
        {
          i = aa.bIO().getInt("com.tencent.mm.compatible.util.keybord.height", 690);
          GMTrace.o(13782281617408L, 102686);
          return i;
        }
        i = aa.bIO().getInt("com.tencent.mm.compatible.util.keybord.height", com.tencent.mm.bg.a.fromDPToPix(paramContext, 230));
        gSI = i;
        GMTrace.o(13782281617408L, 102686);
        return i;
      }
      i = aC(paramContext);
      GMTrace.o(13782281617408L, 102686);
      return i;
    }
    int i = aC(paramContext);
    GMTrace.o(13782281617408L, 102686);
    return i;
  }
  
  @TargetApi(11)
  public static final void f(Activity paramActivity)
  {
    GMTrace.i(13782415835136L, 102687);
    if (paramActivity == null)
    {
      GMTrace.o(13782415835136L, 102687);
      return;
    }
    Rect localRect = new Rect();
    paramActivity.getWindow().getDecorView().getWindowVisibleDisplayFrame(localRect);
    int j = localRect.top;
    int i;
    if ((paramActivity instanceof AppCompatActivity))
    {
      if (((AppCompatActivity)paramActivity).cO().cP() == null) {
        break label123;
      }
      i = ((AppCompatActivity)paramActivity).cO().cP().getHeight();
    }
    for (;;)
    {
      gSJ = paramActivity.getResources().getDisplayMetrics().heightPixels - i - j;
      GMTrace.o(13782415835136L, 102687);
      return;
      if (paramActivity.getActionBar() != null) {
        i = paramActivity.getActionBar().getHeight();
      } else {
        label123:
        i = a.e(paramActivity);
      }
    }
  }
  
  public static int g(Activity paramActivity)
  {
    GMTrace.i(15231430426624L, 113483);
    Rect localRect = new Rect();
    paramActivity.getWindow().getDecorView().getWindowVisibleDisplayFrame(localRect);
    int i = localRect.top;
    GMTrace.o(15231430426624L, 113483);
    return i;
  }
  
  public static final boolean o(Context paramContext, int paramInt)
  {
    GMTrace.i(13782684270592L, 102689);
    if (gSI == paramInt)
    {
      GMTrace.o(13782684270592L, 102689);
      return true;
    }
    if (!aE(paramContext))
    {
      GMTrace.o(13782684270592L, 102689);
      return false;
    }
    if (paramInt < 0)
    {
      GMTrace.o(13782684270592L, 102689);
      return false;
    }
    gSI = paramInt;
    v.d("MicroMsg.KeyBordUtil", "save keybord: %d", new Object[] { Integer.valueOf(paramInt) });
    boolean bool = aa.bIO().edit().putInt("com.tencent.mm.compatible.util.keybord.height", paramInt).commit();
    GMTrace.o(13782684270592L, 102689);
    return bool;
  }
  
  public static final int p(Context paramContext, int paramInt)
  {
    GMTrace.i(13783086923776L, 102692);
    int j = aC(paramContext);
    if (!aF(paramContext))
    {
      i = (int)(j / 1.5D);
      j = aG(paramContext)[0];
      paramInt = i;
      if (i > j / 2) {
        paramInt = j / 2;
      }
      GMTrace.o(13783086923776L, 102692);
      return paramInt;
    }
    int i = paramInt;
    if (paramInt <= 0) {
      i = c(paramContext, true);
    }
    paramInt = aB(paramContext);
    if (i > paramInt)
    {
      GMTrace.o(13783086923776L, 102692);
      return paramInt;
    }
    if (i < j)
    {
      GMTrace.o(13783086923776L, 102692);
      return j;
    }
    GMTrace.o(13783086923776L, 102692);
    return i;
  }
  
  public static void sg()
  {
    GMTrace.i(13782147399680L, 102685);
    gSK = false;
    GMTrace.o(13782147399680L, 102685);
  }
  
  public static final int sh()
  {
    GMTrace.i(13782550052864L, 102688);
    int i = gSJ;
    GMTrace.o(13782550052864L, 102688);
    return i;
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/compatible/util/j.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */