package com.google.android.finsky.bw;

import android.graphics.Rect;
import android.view.View;
import android.view.ViewGroup;

public final class av
{
  private static final Rect a = new Rect();
  
  public static void a(ViewGroup paramViewGroup, int paramInt)
  {
    int j = paramViewGroup.getChildCount();
    int i = 0;
    while (i < j) {
      if (paramViewGroup.getChildAt(i).getVisibility() != 0)
      {
        i += 1;
      }
      else
      {
        paramViewGroup.setVisibility(0);
        return;
      }
    }
    paramViewGroup.setVisibility(paramInt);
  }
  
  public static boolean a(View paramView)
  {
    return paramView.getGlobalVisibleRect(a);
  }
  
  public static boolean b(View paramView)
  {
    return (paramView.getGlobalVisibleRect(a)) && (paramView.getHeight() == a.height()) && (paramView.getWidth() == a.width());
  }
}


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/com/google/android/finsky/bw/av.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */