package com.google.android.finsky.bw;

import android.support.v4.view.o;
import android.view.View;
import android.view.ViewGroup.MarginLayoutParams;
import android.view.ViewParent;

public final class au
{
  public static void a(View paramView, int paramInt)
  {
    ViewGroup.MarginLayoutParams localMarginLayoutParams = (ViewGroup.MarginLayoutParams)paramView.getLayoutParams();
    localMarginLayoutParams.bottomMargin = paramInt;
    paramView.setLayoutParams(localMarginLayoutParams);
  }
  
  public static void a(View paramView, int paramInt1, int paramInt2)
  {
    ViewGroup.MarginLayoutParams localMarginLayoutParams = (ViewGroup.MarginLayoutParams)paramView.getLayoutParams();
    o.a(localMarginLayoutParams, paramInt1);
    o.b(localMarginLayoutParams, paramInt2);
    paramView.setLayoutParams(localMarginLayoutParams);
  }
  
  public static boolean a(View paramView1, View paramView2)
  {
    paramView2 = paramView2.getParent();
    while (paramView2 != null) {
      if (paramView2 != paramView1) {
        paramView2 = paramView2.getParent();
      } else {
        return true;
      }
    }
    return false;
  }
}


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/com/google/android/finsky/bw/au.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */