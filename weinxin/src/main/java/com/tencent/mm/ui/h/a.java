package com.tencent.mm.ui.h;

import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Context;
import android.graphics.Rect;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.app.d;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import com.tencent.gmtrace.GMTrace;

public final class a
{
  private static b whs;
  private static b wht;
  
  @TargetApi(11)
  public static void b(Activity paramActivity, View paramView)
  {
    GMTrace.i(2873333121024L, 21408);
    View localView = paramActivity.getWindow().getDecorView();
    whs = b.fc(paramActivity);
    wht = b.fc(paramActivity);
    int[] arrayOfInt = new int[2];
    paramView.getLocationOnScreen(arrayOfInt);
    Object localObject = new Rect();
    paramActivity.getWindow().getDecorView().getWindowVisibleDisplayFrame((Rect)localObject);
    int i = ((Rect)localObject).top;
    int j = ((AppCompatActivity)paramActivity).cO().cP().getHeight();
    int k = arrayOfInt[1];
    whs.setHeight(k - i - j);
    localObject = new int[2];
    if ((paramActivity instanceof Activity))
    {
      DisplayMetrics localDisplayMetrics = new DisplayMetrics();
      ((Activity)paramActivity).getWindowManager().getDefaultDisplay().getMetrics(localDisplayMetrics);
      localObject[0] = localDisplayMetrics.widthPixels;
      localObject[1] = localDisplayMetrics.heightPixels;
    }
    for (;;)
    {
      k = localObject[1];
      int m = arrayOfInt[1];
      int n = paramView.getHeight();
      wht.setHeight(k - m - n);
      whs.showAtLocation(localView, 48, 0, i + j);
      wht.showAtLocation(localView, 80, 0, 0);
      GMTrace.o(2873333121024L, 21408);
      return;
      paramActivity = ((WindowManager)paramActivity.getSystemService("window")).getDefaultDisplay();
      localObject[0] = paramActivity.getWidth();
      localObject[1] = paramActivity.getHeight();
    }
  }
  
  public static void dismiss()
  {
    GMTrace.i(2873467338752L, 21409);
    if (whs != null)
    {
      whs.setAnimationStyle(-1);
      whs.dismiss();
      whs = null;
    }
    if (wht != null)
    {
      wht.setAnimationStyle(-1);
      wht.dismiss();
      wht = null;
    }
    GMTrace.o(2873467338752L, 21409);
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/ui/h/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */