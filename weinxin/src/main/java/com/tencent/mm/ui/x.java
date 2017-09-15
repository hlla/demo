package com.tencent.mm.ui;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Point;
import android.graphics.Rect;
import android.os.Build.VERSION;
import android.view.Display;
import android.view.View;
import android.view.View.OnApplyWindowInsetsListener;
import android.view.ViewGroup;
import android.view.ViewGroup.MarginLayoutParams;
import android.view.ViewParent;
import android.view.Window;
import android.view.WindowInsets;
import android.view.WindowManager;
import com.tencent.gmtrace.GMTrace;
import com.tencent.mm.compatible.loader.c;
import com.tencent.mm.compatible.util.d;
import com.tencent.mm.sdk.platformtools.v;
import java.lang.reflect.Method;

public final class x
{
  private static Rect uVc;
  
  static
  {
    GMTrace.i(2879507136512L, 21454);
    uVc = new Rect(0, 0, 0, 0);
    GMTrace.o(2879507136512L, 21454);
  }
  
  @TargetApi(21)
  public static ViewGroup a(Window paramWindow, View paramView)
  {
    ViewParent localViewParent = null;
    GMTrace.i(2878299176960L, 21445);
    if (paramWindow == null)
    {
      GMTrace.o(2878299176960L, 21445);
      return null;
    }
    Object localObject = c(paramWindow);
    if (localObject != null)
    {
      GMTrace.o(2878299176960L, 21445);
      return (ViewGroup)localObject;
    }
    if (paramView != null)
    {
      localObject = paramView.getParent();
      paramView = localViewParent;
      while ((localObject != paramWindow.getDecorView()) && (localObject != null))
      {
        localViewParent = ((ViewParent)localObject).getParent();
        paramView = (View)localObject;
        localObject = localViewParent;
      }
    }
    for (;;)
    {
      if (paramView == null)
      {
        localObject = ((ViewGroup)paramWindow.getDecorView()).getChildAt(0);
        if ((localObject instanceof ViewGroup))
        {
          paramWindow = (ViewGroup)localObject;
          GMTrace.o(2878299176960L, 21445);
          return paramWindow;
        }
        if (Build.VERSION.SDK_INT >= 21) {
          paramWindow.clearFlags(Integer.MIN_VALUE);
        }
      }
      paramWindow = (ViewGroup)paramView;
      GMTrace.o(2878299176960L, 21445);
      return paramWindow;
      paramView = null;
    }
  }
  
  public static void a(Window paramWindow)
  {
    GMTrace.i(2879372918784L, 21453);
    if (paramWindow == null)
    {
      GMTrace.o(2879372918784L, 21453);
      return;
    }
    if (Build.VERSION.SDK_INT >= 21)
    {
      paramWindow.addFlags(Integer.MIN_VALUE);
      paramWindow.setStatusBarColor(0);
    }
    GMTrace.o(2879372918784L, 21453);
  }
  
  public static Rect bQv()
  {
    GMTrace.i(2878836047872L, 21449);
    Rect localRect = uVc;
    GMTrace.o(2878836047872L, 21449);
    return localRect;
  }
  
  private static ViewGroup c(Window paramWindow)
  {
    GMTrace.i(2878433394688L, 21446);
    if (Build.VERSION.SDK_INT >= 21)
    {
      paramWindow = new c(paramWindow, "mContentRoot", null);
      if (!paramWindow.rS()) {}
    }
    try
    {
      paramWindow = (ViewGroup)paramWindow.get();
      GMTrace.o(2878433394688L, 21446);
      return paramWindow;
    }
    catch (NoSuchFieldException paramWindow)
    {
      v.printErrStackTrace("MicroMsg.UIUtils", paramWindow, "", new Object[0]);
      GMTrace.o(2878433394688L, 21446);
      return null;
    }
    catch (IllegalAccessException paramWindow)
    {
      for (;;) {}
    }
    catch (IllegalArgumentException paramWindow)
    {
      for (;;) {}
    }
  }
  
  @TargetApi(20)
  public static boolean d(View paramView1, final View paramView2)
  {
    GMTrace.i(2878567612416L, 21447);
    if (!d.eo(21))
    {
      GMTrace.o(2878567612416L, 21447);
      return true;
    }
    if ((paramView1 != null) && ((paramView1 instanceof ViewGroup)) && (paramView2 != null) && ((paramView1.getLayoutParams() instanceof ViewGroup.MarginLayoutParams)))
    {
      paramView1.setOnApplyWindowInsetsListener(new View.OnApplyWindowInsetsListener()
      {
        public final WindowInsets onApplyWindowInsets(View paramAnonymousView, WindowInsets paramAnonymousWindowInsets)
        {
          GMTrace.i(1905623302144L, 14198);
          paramAnonymousView = (ViewGroup.MarginLayoutParams)this.uVd.getLayoutParams();
          x.t(paramAnonymousView.leftMargin, paramAnonymousView.topMargin, paramAnonymousView.rightMargin, paramAnonymousView.bottomMargin);
          paramView2.setPadding(paramView2.getPaddingLeft(), paramView2.getPaddingTop(), paramAnonymousView.rightMargin, paramAnonymousView.bottomMargin);
          paramAnonymousView = this.uVd.onApplyWindowInsets(paramAnonymousWindowInsets);
          GMTrace.o(1905623302144L, 14198);
          return paramAnonymousView;
        }
      });
      GMTrace.o(2878567612416L, 21447);
      return true;
    }
    GMTrace.o(2878567612416L, 21447);
    return false;
  }
  
  public static int eE(Context paramContext)
  {
    GMTrace.i(2878970265600L, 21450);
    if (eF(paramContext))
    {
      int i = Resources.getSystem().getIdentifier("navigation_bar_height", "dimen", "android");
      if (i > 0)
      {
        i = Resources.getSystem().getDimensionPixelSize(i);
        GMTrace.o(2878970265600L, 21450);
        return i;
      }
    }
    GMTrace.o(2878970265600L, 21450);
    return 0;
  }
  
  @TargetApi(17)
  public static boolean eF(Context paramContext)
  {
    GMTrace.i(2879104483328L, 21451);
    Display localDisplay = ((WindowManager)paramContext.getSystemService("window")).getDefaultDisplay();
    Point localPoint = new Point();
    localDisplay.getSize(localPoint);
    paramContext = eG(paramContext);
    int i = Math.max(localPoint.y, localPoint.x);
    if (Math.max(paramContext.y, paramContext.x) > i)
    {
      GMTrace.o(2879104483328L, 21451);
      return true;
    }
    GMTrace.o(2879104483328L, 21451);
    return false;
  }
  
  public static Point eG(Context paramContext)
  {
    GMTrace.i(2879238701056L, 21452);
    Point localPoint = new Point();
    paramContext = ((WindowManager)paramContext.getSystemService("window")).getDefaultDisplay();
    if (Build.VERSION.SDK_INT >= 17) {
      paramContext.getRealSize(localPoint);
    }
    for (;;)
    {
      GMTrace.o(2879238701056L, 21452);
      return localPoint;
      if (Build.VERSION.SDK_INT >= 14) {
        try
        {
          Method localMethod = Display.class.getMethod("getRawHeight", new Class[0]);
          localPoint.x = ((Integer)Display.class.getMethod("getRawWidth", new Class[0]).invoke(paramContext, new Object[0])).intValue();
          localPoint.y = ((Integer)localMethod.invoke(paramContext, new Object[0])).intValue();
        }
        catch (Exception localException) {}
      } else {
        paramContext.getSize(localPoint);
      }
    }
  }
  
  public static void t(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    GMTrace.i(2878701830144L, 21448);
    uVc.set(paramInt1, paramInt2, paramInt3, paramInt4);
    GMTrace.o(2878701830144L, 21448);
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/ui/x.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */